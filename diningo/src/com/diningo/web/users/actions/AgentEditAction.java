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
 * $Id: AgentEditAction.java,v 1.6 2007/05/01 20:29:34 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.users.actions;

import com.diningo.web.general.beans.DBConnection;
import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.users.actionforms.AgentForm;

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
 *              Purpose: To edit selected agent
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

AgentEditAction extends Action {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    public ActionForward execute(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {

      AgentForm AgentForm=null;
      ServletContext context=null;
      String jdbcDS = null;
      ResultSet rs = null;
      String sqlString = null;
      
      try {
           logger.debug("Enter");
           
           AgentForm = (AgentForm)form;
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
               DBConnection dbcon = new DBConnection(ds);

               AgentForm.setHdnUserTblPk(userTblPk);

               sqlString = "select   a.user_tbl_pk "                                  +
                                   ",a.user_id "                                      +
                                   ",a.password "                                     +
                                   ",a.user_name "                                    +
                                   ",a.user_email "                                   +
                                   ",a.phone   "                                      + 
                                   ",a.address1 "                                     +
                                   ",a.address2 "                                     +
                                   ",a.city "                                         +
                                   ",a.zipcode "                                      +
                                   ",c.state_name "                                   +
                           "from    user_tbl          a "                             +
                                  ",state_tbl         c "                             +
                                  ",user_category_tbl d "                             +
                           "where   a.user_category_tbl_fk = d.user_category_tbl_pk " +
                             "and   d.user_category_name   = 'AGENT' "                +
                             "and   a.state_tbl_fk         = c.state_tbl_pk "         +
                             "and   a.user_tbl_pk          =  " + userTblPk;
               
               logger.debug(sqlString);
               rs = dbcon.executeQuery(sqlString);
               
               while (rs.next()) {
                   AgentForm.setTxtUserId(rs.getString(2));
                   AgentForm.setTxtPassword(rs.getString(3));
                   AgentForm.setTxtConfirmPassword(rs.getString(3));
                   AgentForm.setTxtName(rs.getString(4));
                   AgentForm.setTxtEmailAddress(rs.getString(5));
                   AgentForm.setTxtPhone(rs.getString(6));
                   AgentForm.setTxtAddress1(rs.getString(7));
                   AgentForm.setTxtAddress2(rs.getString(8));
                   AgentForm.setTxtCity(rs.getString(9));
                   AgentForm.setTxtState(rs.getString(11));
                   AgentForm.setTxtZip(rs.getString(10));
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
