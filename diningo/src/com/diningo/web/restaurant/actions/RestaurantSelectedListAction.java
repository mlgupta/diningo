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
 * $Id: RestaurantSelectedListAction.java,v 1.2 2007/05/01 20:29:34 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.actions;

import com.diningo.web.general.beans.DBConnection;
import com.diningo.web.general.beans.DNGConstants;

import com.diningo.web.restaurant.actionforms.RestaurantSelectListForm;

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
 *              Purpose: To display list of restaurants for restaurant_management.jsp 
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

RestaurantSelectedListAction extends Action {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    public ActionForward execute(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {
      RestaurantSelectListForm RestaurantSelectListForm=null;
      ServletContext context=null;
      String jdbcDS = null;
      ResultSet rs = null;
      String sqlString = null;

      try {
           logger.debug("Enter");
           
           RestaurantSelectListForm = (RestaurantSelectListForm)form;
           context=servlet.getServletContext();
           
           jdbcDS = (String)context.getAttribute("jdbcDS");
           
           logger.debug("jdbs-DS:" + jdbcDS);
          
           Context ctx = new javax.naming.InitialContext();
           DataSource ds = (DataSource)ctx.lookup(jdbcDS);

           HttpSession session = request.getSession();
           
           logger.debug("Selected Restaurant: " + RestaurantSelectListForm.getSelectedRestaurant());
           logger.debug("Requested Action: " + RestaurantSelectListForm.getRequestedAction());
          
           if (RestaurantSelectListForm.getSelectedRestaurant() == null || "".equals(RestaurantSelectListForm.getSelectedRestaurant()) ||
               RestaurantSelectListForm.getRequestedAction() == null    || "".equals(RestaurantSelectListForm.getRequestedAction())) {
                   RestaurantSelectListForm.setRequestedAction("failure");
           }
           else {
                session.setAttribute("selectedRestaurant",RestaurantSelectListForm.getSelectedRestaurant());
                
                DBConnection dbcon = new DBConnection(ds);
                sqlString = "select a.restaurant_name "                        +
                              "from restaurant_tbl a "                         +
                             "where a.restaurant_tbl_pk = " + RestaurantSelectListForm.getSelectedRestaurant();
                            
                rs = dbcon.executeQuery(sqlString);            
                while (rs.next()) {
                   session.setAttribute("selectedRestaurantName",rs.getString(1));
               }
               dbcon.free(rs);
           }
      } catch (Exception e) {
        logger.error(e.toString());
      } finally {
         logger.debug("Exit");
      }
      return mapping.findForward(RestaurantSelectListForm.getRequestedAction());
    }
}
