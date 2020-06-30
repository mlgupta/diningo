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
 * $Id: RestaurantUserB4NewEditAction.java,v 1.2 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.users.actions;

import com.diningo.web.general.beans.DBConnection;
import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.users.actionforms.RestaurantUserNewEditForm;

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
 *              Purpose: To edit selected restaurant user
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

RestaurantUserB4NewEditAction extends Action {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    public ActionForward execute(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {

      RestaurantUserNewEditForm RestaurantUserNewEditForm=null;
      ServletContext context=null;
      String jdbcDS = null;
      ResultSet rs = null;
      String sqlString = null;
      
      try {
           logger.debug("Enter");
           
           RestaurantUserNewEditForm = (RestaurantUserNewEditForm)form;
           context=servlet.getServletContext();
           jdbcDS = (String)context.getAttribute("jdbcDS");
          
           logger.debug("jdbs-DS:" + jdbcDS);
          
           Context ctx = new javax.naming.InitialContext();
           DataSource ds = (DataSource)ctx.lookup(jdbcDS);
          
           String userTblPk = request.getParameter("user_tbl_pk").trim();
           
           if (userTblPk == null || "".equals(userTblPk)) {
             logger.debug("Passed parameter user_tbl_pk is blank or null");
           }
           else {
               logger.debug("user_tbl_pk:" + userTblPk);
               DBConnection dbcon = new DBConnection(ds);

               RestaurantUserNewEditForm.setHdnUserTblPk(userTblPk);

               sqlString = "select   a.user_tbl_pk "                                  +
                                   ",a.user_id "                                      +
                                   ",a.password "                                     +
                                   ",a.user_name "                                    +
                                   ",a.user_email "                                   +
                                   ",a.phone   "                                      + 
                           "from    user_tbl          a "                             +
                           "where   a.user_tbl_pk          =  " + userTblPk;
               
               logger.debug(sqlString);
               
               rs = dbcon.executeQuery(sqlString);
               
               while (rs.next()) {
                   RestaurantUserNewEditForm.setTxtUserId(rs.getString(2));
                   RestaurantUserNewEditForm.setTxtPassword(rs.getString(3));
                   RestaurantUserNewEditForm.setTxtConfirmPassword(rs.getString(3));
                   RestaurantUserNewEditForm.setTxtUserName(rs.getString(4));
                   RestaurantUserNewEditForm.setTxtEmailAddress(rs.getString(5));
                   RestaurantUserNewEditForm.setTxtPhoneNo(rs.getString(6));
               }
               
               dbcon.free(rs);
               request.setAttribute("RestaurantUserNewEditForm",RestaurantUserNewEditForm);
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
