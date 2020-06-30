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
 * $Id: RestaurantSubscriptionAction.java,v 1.4 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.actions;

import com.diningo.web.general.beans.DBConnection;
import com.diningo.web.general.beans.DNGConstants;

import com.diningo.web.preferences.beans.PreferenceBean;
import com.diningo.web.restaurant.actionforms.RestaurantSubscriptionForm;
import com.diningo.web.restaurant.beans.Operations;

import com.diningo.web.restaurant.beans.RestaurantSubscriptionBean;

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

RestaurantSubscriptionAction extends Action {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    public ActionForward execute(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {
      RestaurantSubscriptionForm RestaurantSubscriptionForm=null;
      ServletContext context=null;
      String jdbcDS = null;
      ResultSet rs = null;
      String sqlString = null;
      String sqlString_tbl = null;
      String sqlString_where = null;
      String selectedRestaurant = null;
      String selectedRestaurantName = null;
      int maxPageItems = 0;
      PreferenceBean userPreferences;

      try {
           logger.debug("Enter");
           
           RestaurantSubscriptionForm = (RestaurantSubscriptionForm)form;
           context=servlet.getServletContext();
           jdbcDS = (String)context.getAttribute("jdbcDS");
           
           logger.debug("jdbs-DS:" + jdbcDS);

           String resetFlag = request.getParameter("reset");

           if (resetFlag == null || "".equals(resetFlag)) {
           }
           else {
            if ("true".equals(resetFlag)) {
                logger.debug("Reset Flag set. Resetting FormBean");
                Operations.resetRestaurantSubscriptionForm(RestaurantSubscriptionForm);
            }
           }
           
          if (RestaurantSubscriptionForm.getHdnRestaurantSubscriptionTblPk() == null || "".equals(RestaurantSubscriptionForm.getHdnRestaurantSubscriptionTblPk())) {
              Operations.resetRestaurantSubscriptionForm(RestaurantSubscriptionForm);
          }
          
           String pagerOffset = request.getParameter("pager.offset");
          
           if(pagerOffset == null || "".equals(pagerOffset)) {
              pagerOffset = "0";
              RestaurantSubscriptionForm.setRow_count(0);
           }

           RestaurantSubscriptionForm.setUri(request.getRequestURI());
           
           HttpSession session = request.getSession();
          
           userPreferences = (PreferenceBean)session.getAttribute("userPreferences");
           
           maxPageItems = RestaurantSubscriptionForm.getMaxPageItems();
           if (maxPageItems == 0) {
               maxPageItems = Integer.parseInt(userPreferences.getMaxPageItems());
              
               if (maxPageItems == 0) {
                 maxPageItems = 50;
               }
               RestaurantSubscriptionForm.setMaxPageItems(maxPageItems);
           }

          selectedRestaurant = (String)session.getAttribute("selectedRestaurant");
          selectedRestaurantName = (String)session.getAttribute("selectedRestaurantName");

          if (selectedRestaurant == null || "".equals(selectedRestaurant)) {
              return mapping.findForward("failure");
          }
           
           RestaurantSubscriptionForm.setHdnRestaurantTblPk(selectedRestaurant);
           RestaurantSubscriptionForm.setTxtName(selectedRestaurantName);
           
           Context ctx = new javax.naming.InitialContext();
           DataSource ds = (DataSource)ctx.lookup(jdbcDS);
           
           DBConnection dbcon = new DBConnection(ds);
           
           sqlString_tbl =  "from    restaurant_subscription_tbl     a "       +
                                   ",specials_tbl                    b ";
                                   
           sqlString_where = "where   a.specials_tbl_fk = b.specials_tbl_pk "  +
                               "and   a.restaurant_tbl_fk = " + selectedRestaurant;

           
           if (RestaurantSubscriptionForm.getRow_count() == 0) {
               sqlString = "select count(a.restaurant_subscription_tbl_pk) "       +
                           sqlString_tbl                                       +
                           sqlString_where;
                           
               logger.debug(sqlString);
               
               rs = dbcon.executeQuery(sqlString);            
               while (rs.next()) {
                   RestaurantSubscriptionForm.setRow_count(rs.getInt(1));
               }
           }
          
           if (RestaurantSubscriptionForm.getRow_count() == 0) {
               RestaurantSubscriptionBean[] restaurantSubscriptionList = new RestaurantSubscriptionBean[1];
               String[] selected   = new String[1];
               
               restaurantSubscriptionList[0] = new RestaurantSubscriptionBean();
               
               restaurantSubscriptionList[0].setRestaurant_subscription_tbl_pk("0");
               restaurantSubscriptionList[0].setSubscription_from("");
               restaurantSubscriptionList[0].setSubscription_to("");
               restaurantSubscriptionList[0].setSubscription_charges("");

               RestaurantSubscriptionForm.setRestaurantSubscriptionList(restaurantSubscriptionList);
               RestaurantSubscriptionForm.setSelected(selected);
           }
           else {
               if(Integer.parseInt(pagerOffset) > RestaurantSubscriptionForm.getRow_count())
                   pagerOffset = String.valueOf(RestaurantSubscriptionForm.getRow_count() - Integer.parseInt(pagerOffset));
                   
               sqlString = "select   a.restaurant_subscription_tbl_pk "        +
                                   ",a.subscription_from "                     +
                                   ",a.subscription_to "                       +
                                   ",a.subscription_charges "                  +
                                   ",b.specials_name "                         +
                            sqlString_tbl                                      +
                            sqlString_where                                    +
                           "order by a.subscription_from "                     +
                           "offset " + pagerOffset + " limit " + maxPageItems;
                           
               logger.debug(sqlString);
               
               rs = dbcon.executeQuery(sqlString,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
               
               rs.last();
               int rs_count = rs.getRow();
               rs.beforeFirst();

               RestaurantSubscriptionBean[] restaurantSubscriptionList = new RestaurantSubscriptionBean[rs_count];
               String[] selected   = new String[rs_count];
               
               int i = 0;           
               while (rs.next()) {
                   restaurantSubscriptionList[i] = new RestaurantSubscriptionBean();
                   restaurantSubscriptionList[i].setRestaurant_subscription_tbl_pk(rs.getString(1));
                   restaurantSubscriptionList[i].setSubscription_from(rs.getString(2));
                   restaurantSubscriptionList[i].setSubscription_to(rs.getString(3));
                   restaurantSubscriptionList[i].setSubscription_charges(rs.getString(4));
                   restaurantSubscriptionList[i].setSpecials_name(rs.getString(5));
                   
                   ++i;
               }
               
               RestaurantSubscriptionForm.setRestaurantSubscriptionList(restaurantSubscriptionList);
               RestaurantSubscriptionForm.setSelected(selected);
           }
           dbcon.free(rs);
           request.setAttribute("RestaurantSubscriptionForm", RestaurantSubscriptionForm);
      } catch (Exception e) {
        logger.error(e.toString());
      } finally {
         logger.debug("Exit");
      }
      return mapping.findForward("success");
    }
}
