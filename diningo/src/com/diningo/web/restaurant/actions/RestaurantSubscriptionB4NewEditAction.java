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
 * $Id: RestaurantSubscriptionB4NewEditAction.java,v 1.2 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.actions;

import com.diningo.web.general.beans.DBConnection;
import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.restaurant.actionforms.RestaurantSubscriptionForm;

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
 *              Purpose: 
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

RestaurantSubscriptionB4NewEditAction extends Action {
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
      
      try {
           logger.debug("Enter");
           
           RestaurantSubscriptionForm = (RestaurantSubscriptionForm)form;
           context=servlet.getServletContext();
           jdbcDS = (String)context.getAttribute("jdbcDS");
          
           logger.debug("jdbs-DS:" + jdbcDS);
          
           Context ctx = new javax.naming.InitialContext();
           DataSource ds = (DataSource)ctx.lookup(jdbcDS);
          
           String restaurantSubscriptionTblPk = request.getParameter("restaurant_subscription_tbl_pk");
           
           if (restaurantSubscriptionTblPk.equals("") || restaurantSubscriptionTblPk == null) {
             logger.debug("Passed parameter restaurant_subscription_tbl_pk is blank or null");
           }
           else {
               DBConnection dbcon = new DBConnection(ds);

               RestaurantSubscriptionForm.setHdnRestaurantSubscriptionTblPk(restaurantSubscriptionTblPk);

               sqlString = "select   a.restaurant_subscription_tbl_pk "          +
                                   ",to_char(a.subscription_from,'YYYY/MM/DD') " +
                                   ",to_char(a.subscription_to,'YYYY/MM/DD') "   +
                                   ",a.subscription_charges "                    +
                                   ",a.specials_tbl_fk "                         +
                           "from    restaurant_subscription_tbl    a "           +
                           "where   a.restaurant_subscription_tbl_pk   = "       + 
                                    restaurantSubscriptionTblPk;
               
               rs = dbcon.executeQuery(sqlString);
               
               while (rs.next()) {
                   RestaurantSubscriptionForm.setHdnRestaurantSubscriptionTblPk(rs.getString(1));
                   RestaurantSubscriptionForm.setTxtFromDate(rs.getString(2));
                   RestaurantSubscriptionForm.setTxtToDate(rs.getString(3));
                   RestaurantSubscriptionForm.setTxtSubscriptionFee(rs.getString(4));
                   RestaurantSubscriptionForm.setCboSubscription(rs.getString(5));
               }
               
               dbcon.free(rs);
           }
      } catch (Exception e) {
        logger.error(e.toString());
          return mapping.findForward("failure");
      } finally {
         logger.debug("Exit");
      }
      return mapping.findForward("success");
    }
}
