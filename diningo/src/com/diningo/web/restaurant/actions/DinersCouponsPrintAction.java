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
 * $Id: DinersCouponsPrintAction.java,v 1.2 2007/05/29 01:33:00 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.actions;

import com.diningo.web.general.beans.DBConnection;
import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.restaurant.actionforms.PrintCouponForm;

import com.diningo.web.restaurant.beans.Operations;

import java.io.IOException;

import java.sql.ResultSet;

import javax.naming.Context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 *              Purpose: To print a coupon
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

DinersCouponsPrintAction extends Action {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    public ActionForward execute(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {
      PrintCouponForm PrintCouponForm=null;
      ServletContext context=null;
      String jdbcDS = null;
      ResultSet rs = null;
      String sqlString = null;

      try {
           logger.debug("Enter");
           
           PrintCouponForm = (PrintCouponForm)form;
           context=servlet.getServletContext();
           jdbcDS = (String)context.getAttribute("jdbcDS");
           
           logger.debug("jdbs-DS:" + jdbcDS);
           
           String restaurant_coupons_tbl_pk = request.getParameter("restaurant_coupons_tbl_pk");
          
           if(restaurant_coupons_tbl_pk == null || "".equals(restaurant_coupons_tbl_pk)) {
               logger.debug("Restaurant Coupon is null or blank");
               return mapping.findForward("failure");
           }
           
           PrintCouponForm.setRestaurant_coupons_tbl_pk(restaurant_coupons_tbl_pk);

           Context ctx = new javax.naming.InitialContext();
           DataSource ds = (DataSource)ctx.lookup(jdbcDS);
           
           DBConnection dbcon = new DBConnection(ds);
           
           sqlString =  "select a.restaurant_name "                           +
                              ",a.address1 "                                  +
                              ",a.address2 "                                  +
                              ",a.city "                                      +
                              ",b.state_name "                                +
                              ",a.zipcode "                                   +
                              ",a.restaurant_phone "                          +
                              ",a.restaurant_tbl_pk "                         +
                              ",c.coupon_name "                               +
                              ",c.coupon_description "                        +
                              ",c.coupon_from_eff_date "                      +
                              ",c.coupon_to_eff_date ";
                                  
           sqlString += "from  restaurant_tbl   a "                           +
                             ",state_tbl        b "                           +
                             ",restaurant_coupons_tbl c ";
                            
           sqlString += "where  a.state_tbl_fk = b.state_tbl_pk "             +
                          "and  a.restaurant_tbl_pk = c.restaurant_tbl_fk "   +
                          "and  c.restaurant_coupons_tbl_pk = " + restaurant_coupons_tbl_pk;

           logger.debug(sqlString);
               
           rs = dbcon.executeQuery(sqlString);            
           String formattedCouponDescription;

           while (rs.next()) {
               PrintCouponForm.setTxtRestaurantName(rs.getString(1));
               PrintCouponForm.setTxtAddress1(rs.getString(2));
               PrintCouponForm.setTxtAddress2(rs.getString(3));
               PrintCouponForm.setTxtCity(rs.getString(4));
               PrintCouponForm.setTxtState(rs.getString(5));
               PrintCouponForm.setTxtZipcode(rs.getString(6));
               PrintCouponForm.setTxtRestaurantPhone(rs.getString(7));
               PrintCouponForm.setHdnRestaurantTblPk(rs.getString(8));
               PrintCouponForm.setCoupon_name(rs.getString(9));

               formattedCouponDescription = Operations.text2html(rs.getString(10));
               PrintCouponForm.setCoupon_description(formattedCouponDescription);
               
               PrintCouponForm.setCoupon_from_eff_date(rs.getString(11));
               PrintCouponForm.setCoupon_to_eff_date(rs.getString(12));
           }
          
           dbcon.free(rs);
           request.setAttribute("PrintCouponForm", PrintCouponForm);
      } catch (Exception e) {
        logger.error(e.toString());
      } finally {
         logger.debug("Exit");
      }
      return mapping.findForward("success");          
    }
}
