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
 * $Id: AgentAddAction.java,v 1.7 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.users.actions;

import com.diningo.web.users.beans.Operations;
import com.diningo.web.general.beans.DNGConstants;

import com.diningo.web.users.actionforms.AgentForm;

import java.io.IOException;

import javax.naming.Context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


/**
 *              Purpose: To add new agent
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

AgentAddAction extends Action {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    public ActionForward execute(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {

      AgentForm AgentForm=null;
      ServletContext context=null;
      String jdbcDS = null;
      int rc=0;

      try {
         logger.debug("Enter");
           
         AgentForm=(AgentForm)form;
         context=servlet.getServletContext();
         jdbcDS = (String)context.getAttribute("jdbcDS");
         
         logger.debug("jdbs-DS:" + jdbcDS);
         
         Context ctx = new javax.naming.InitialContext();
         DataSource ds = (DataSource)ctx.lookup(jdbcDS);
         
         ActionErrors actionErrors = new ActionErrors();
         
         if (AgentForm.getHdnUserTblPk() == null || "".equals(AgentForm.getHdnUserTblPk())) {
              rc = Operations.AddAgent(AgentForm,ds);  
              if (rc < 0) {
                 actionErrors.add("user",new ActionMessage("errors.user.duplicateuser"));
              }
         }
         else {
             rc = Operations.UpdateAgent(AgentForm,ds);
             if (rc < 0) {
                actionErrors.add("user",new ActionMessage("errors.user.update.error"));
             }
         }
         
         if (rc < 0) {
             saveErrors(request, actionErrors);
         }
      } catch (Exception e) {
        logger.error(e.toString());
        return mapping.findForward("failure");
      } finally {
         logger.info("Exit");
      }
        if (rc < 0) {
            return mapping.findForward("failure");
        }
        else {
            return mapping.findForward("success");
        }
    }
}
