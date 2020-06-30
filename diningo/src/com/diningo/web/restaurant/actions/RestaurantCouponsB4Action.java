/*
 *****************************************************************************
 *                       Confidentiality Information                         *
 *                                                                           *
 * This module is the confidential and proprietary information of            *
 * DBSentry Corp.; it is not to be copied, reproduced, or transmitted in any *
 * form, by any means, in whole or in part, nor is it to be used for any     *
 * purpose other than that for which it is expressly provided without the    *
 * written permission of DBSentry Corp.                                      *
 *                                                                           *
 * Copyright (c) 2004-2005 DBSentry Corp.  All Rights Reserved.              *
 *                                                                           *
 *****************************************************************************
 * $Id: RestaurantCouponsB4Action.java,v 1.2 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.actions;

import com.diningo.web.general.beans.DBConnection;
import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.preferences.beans.PreferenceBean;
import com.diningo.web.restaurant.actionforms.RestaurantCouponsForm;


import com.diningo.web.restaurant.beans.Operations;
import com.diningo.web.restaurant.beans.RestaurantCouponsBean;

import java.io.IOException;

import java.sql.ResultSet;

import javax.naming.Context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 *              Purpose: 
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

RestaurantCouponsB4Action extends Action {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    public ActionForward execute(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {
      RestaurantCouponsForm RestaurantCouponsForm=null;
      ServletContext context=null;
      String jdbcDS = null;
      ResultSet rs = null;
      String sqlString = null;
      PreferenceBean userPreferences;
      String selectedRestaurant;

      try {
           logger.debug("Enter");
           
           RestaurantCouponsForm = (RestaurantCouponsForm)form;
           context=servlet.getServletContext();
           jdbcDS = (String)context.getAttribute("jdbcDS");
           
           logger.debug("jdbs-DS:" + jdbcDS);

           String resetFlag = request.getParameter("reset");

           if (resetFlag == null || "".equals(resetFlag)) {
           }
           else {
             if ("true".equals(resetFlag)) {
                 logger.debug("Reset Flag set. Resetting FormBean");
                 Operations.resetRestaurantCouponsForm(RestaurantCouponsForm);
             }
           }

           HttpSession session = request.getSession();
          
           selectedRestaurant = (String)session.getAttribute("selectedRestaurant");
          
           if (selectedRestaurant == null || "".equals(selectedRestaurant)) {
               logger.debug("Restaurant is null or blank");
               return mapping.findForward("failure");
           }

           RestaurantCouponsForm.setHdnRestaurantTblPk(selectedRestaurant);
           
           userPreferences = (PreferenceBean)session.getAttribute("userPreferences");
           
           Context ctx = new javax.naming.InitialContext();
           DataSource ds = (DataSource)ctx.lookup(jdbcDS);
           
           DBConnection dbcon = new DBConnection(ds);
           
           sqlString =  "select a.restaurant_name "                           +
                              ",a.address1 "                                  +
                              ",a.address2 "                                  +
                              ",a.city "                                      +
                              ",b.state_name "                                +
                              ",a.zipcode "                                   +
                              ",a.restaurant_phone ";
                                   
           sqlString += "from  restaurant_tbl   a "                           +
                             ",state_tbl        b ";
                             
           sqlString += "where  a.state_tbl_fk = b.state_tbl_pk "             +
                          "and  a.restaurant_tbl_pk = " + RestaurantCouponsForm.getHdnRestaurantTblPk();

           logger.debug(sqlString);
          
           rs = dbcon.executeQuery(sqlString);
          
           while (rs.next()) {
               RestaurantCouponsForm.setTxtRestaurantName(rs.getString(1));
               RestaurantCouponsForm.setTxtAddress1(rs.getString(2));
               RestaurantCouponsForm.setTxtAddress2(rs.getString(3));
               RestaurantCouponsForm.setTxtCity(rs.getString(4));
               RestaurantCouponsForm.setTxtState(rs.getString(5));
               RestaurantCouponsForm.setTxtZipcode(rs.getString(6));
               RestaurantCouponsForm.setTxtRestaurantPhone(rs.getString(7));
           }
           
          sqlString =  "select a.restaurant_coupons_tbl_pk "                   +
                             ",a.coupon_name "                                 +
                             ",coupon_description "                            +
                             ",coupon_from_eff_date "                          +
                             ",coupon_to_eff_date ";
                                  
          sqlString += "from  restaurant_coupons_tbl  a ";
                            
          sqlString += "where  a.restaurant_tbl_fk = " + RestaurantCouponsForm.getHdnRestaurantTblPk();

          logger.debug(sqlString);
          
          rs = dbcon.executeQuery(sqlString,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
          
          rs.last();
          int rs_count = rs.getRow();
          rs.beforeFirst();

          if (rs_count == 0) {
              RestaurantCouponsBean[] restaurantCouponsList = new RestaurantCouponsBean[1];
              String[] selectedCoupons = new String[1];
              
              restaurantCouponsList[0] = new RestaurantCouponsBean();
              restaurantCouponsList[0].setRestaurant_coupons_tbl_pk("0");
              restaurantCouponsList[0].setCoupon_name("");
              restaurantCouponsList[0].setCoupon_description("");
              restaurantCouponsList[0].setCoupon_from_eff_date("");
              restaurantCouponsList[0].setCoupon_to_eff_date("");

              RestaurantCouponsForm.setRestaurantCouponsList(restaurantCouponsList);
              RestaurantCouponsForm.setSelectedCoupons(selectedCoupons);
          }
          else {
              RestaurantCouponsBean[] restaurantCouponsList = new RestaurantCouponsBean[rs_count];
              String[] selectedCoupons = new String[rs_count];
              
              int i = 0;
              
              while (rs.next()) {
                  restaurantCouponsList[i] = new RestaurantCouponsBean();
                  restaurantCouponsList[i].setRestaurant_coupons_tbl_pk(rs.getString(1));
                  restaurantCouponsList[i].setCoupon_name(rs.getString(2));
                  restaurantCouponsList[i].setCoupon_description(rs.getString(3));
                  restaurantCouponsList[i].setCoupon_from_eff_date(rs.getString(4));
                  restaurantCouponsList[i].setCoupon_to_eff_date(rs.getString(5));
                  
                  ++i;
              }
              RestaurantCouponsForm.setRestaurantCouponsList(restaurantCouponsList);
              RestaurantCouponsForm.setSelectedCoupons(selectedCoupons);
          }
          
          String restaurantCouponsTblPk = request.getParameter("restaurant_coupons_tbl_pk");
          
          if (restaurantCouponsTblPk == null || "".equals(restaurantCouponsTblPk)) {
          }
          else {
              sqlString =  "select  a.restaurant_coupons_tbl_pk "               +
                                  ",a.coupon_name "                             +
                                  ",a.coupon_description "                      +
                                  ",to_char(a.coupon_from_eff_date, 'YYYY/MM/DD') " +
                                  ",to_char(a.coupon_to_eff_date, 'YYYY/MM/DD') ";
                                  
              sqlString += "from  restaurant_coupons_tbl a ";
              
              sqlString += "where a.restaurant_coupons_tbl_pk  = "              + 
                                       restaurantCouponsTblPk                   +
                            " and a.restaurant_tbl_fk = "                       +
                                       RestaurantCouponsForm.getHdnRestaurantTblPk();
                                      
              logger.debug(sqlString);
                      
              rs = dbcon.executeQuery(sqlString);
                      
              while (rs.next()) {
                  RestaurantCouponsForm.setHdnRestaurantCouponsTblPk(rs.getString(1));
                  RestaurantCouponsForm.setTxtCouponsName(rs.getString(2));
                  RestaurantCouponsForm.setTxtCouponDescription(rs.getString(3));
                  RestaurantCouponsForm.setTxtCouponFromEffDate(rs.getString(4));
                  RestaurantCouponsForm.setTxtCouponToEffDate(rs.getString(5));
              }
          }
          dbcon.free(rs);
           
      } catch (Exception e) {
        logger.error(e.toString());
      } finally {
         logger.debug("Exit");
      }
      return mapping.findForward("success");
    }
}
