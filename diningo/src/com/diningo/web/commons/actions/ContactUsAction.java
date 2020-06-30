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
 * $Id: ContactUsAction.java,v 1.6 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.commons.actions;

import com.diningo.web.commons.actionforms.ContactUsForm;
import com.diningo.web.general.beans.DNGConstants;

import com.diningo.web.general.beans.GeneralUtil;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.code.kaptcha.Constants;

import org.apache.struts.action.ActionErrors;
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

ContactUsAction extends Action {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    public ActionForward execute(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {

      ContactUsForm contactUsForm=null;
      String recipients=null;
      String subject=null;
      String message=null;
      String from=null;
      String smtpHost=null;
      ServletContext context=null;
      String domainName = null;
      int rc =0;

      try {
           logger.debug("Enter");
           
           contactUsForm=(ContactUsForm)form;
           context=servlet.getServletContext();
           
           HttpSession session = request.getSession();

           ActionErrors actionErrors = new ActionErrors();

//           String sessionCaptchaField = (String)session.getAttribute(Constants.CAPCHA_SESSION_KEY);
//           String txtCaptchaField = contactUsForm.getTxtCaptchaField();
           
//           if (sessionCaptchaField.equals(txtCaptchaField)) {
             smtpHost = (String)context.getAttribute("smtpHost");
             domainName = (String)context.getAttribute("domain");
             recipients = (String)context.getAttribute("sendMailTo");
             from = contactUsForm.gettxtEmailId();
             subject = "Online Inquiry/Feedback Form";
             message = "Online Inquiry/Feedback Form :\n";
             message += "       Email: "+contactUsForm.gettxtEmailId()+"\n";
             message += "     Subject: "+contactUsForm.gettxtSubject()+"\n";
             message += "     Message: "+contactUsForm.gettxtFeedBack()+"\n";
           
             logger.debug(message);

             GeneralUtil.postMail(recipients,subject,message,from,smtpHost);
/*
           }
           else {
               logger.debug("Entered Captcha value is not equal to session Captcha value");
               logger.debug("Entered Captcha value: " + txtCaptchaField);
               logger.debug("Session Captcha value: " + sessionCaptchaField);
               
               actionErrors.add("user",new ActionMessage("errors.user.captcha.mismatch"));
               saveErrors(request, actionErrors);
               rc = -1;
           }
*/           
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
