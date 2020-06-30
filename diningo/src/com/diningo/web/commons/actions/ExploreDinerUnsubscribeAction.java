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
 * $Id: ExploreDinerUnsubscribeAction.java,v 1.4 2007/05/29 01:33:00 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.commons.actions;

import com.diningo.web.commons.actionforms.ExploreDinerForm;
import com.diningo.web.commons.beans.Operations;
import com.diningo.web.general.beans.DNGConstants;

import com.google.code.kaptcha.Constants;

import java.io.IOException;

import javax.naming.Context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


/**
 *              Purpose: To mail the contents of contact_us.jsp to the designated
 *                        emailid in diningo.
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

ExploreDinerUnsubscribeAction extends Action {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    public ActionForward execute(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {

        ExploreDinerForm ExploreDinerForm=null;
        ServletContext context=null;
        String jdbcDS = null;
        int rc = 0;

        try {
           logger.debug("Enter");
             
           ExploreDinerForm=(ExploreDinerForm)form;
           context=servlet.getServletContext();
           jdbcDS = (String)context.getAttribute("jdbcDS");
           
           logger.debug("jdbs-DS:" + jdbcDS);
           
           HttpSession session = request.getSession();
           
           String sessionCaptchaField = (String)session.getAttribute(Constants.CAPCHA_SESSION_KEY);
           String txtCaptchaField = ExploreDinerForm.getTxtCaptchaField();
           ActionErrors actionErrors = new ActionErrors();
           
           if (sessionCaptchaField.equals(txtCaptchaField)) {
              Context ctx = new javax.naming.InitialContext();
              DataSource ds = (DataSource)ctx.lookup(jdbcDS);
           
              rc = Operations.unsubscribe(ExploreDinerForm,ds);
           
              if (rc < 0) {
                actionErrors.add("diner",new ActionMessage("errors.diner.unsubscribe"));
                saveErrors(request, actionErrors);
              }
           }
            else {
                logger.debug("Entered Captcha value is not equal to session Captcha value");
                logger.debug("Entered Captcha value: " + txtCaptchaField);
                logger.debug("Session Captcha value: " + sessionCaptchaField);
                
                actionErrors.add("user",new ActionMessage("errors.user.captcha.mismatch"));
                saveErrors(request, actionErrors);
                rc = -1;
            }
        } catch (Exception e) {
          logger.error(e.toString());
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
