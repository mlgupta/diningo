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
 * $Id: ExploreDinerAction.java,v 1.5 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.commons.actions;

import com.diningo.web.commons.actionforms.ExploreDinerForm;
import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.commons.beans.Operations;

import com.diningo.web.general.beans.GeneralUtil;

import com.google.code.kaptcha.Constants;

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

import javax.servlet.http.HttpSession;


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

ExploreDinerAction extends Action {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    public ActionForward execute(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {

      ExploreDinerForm ExploreDinerForm=null;
      ServletContext context=null;
      String jdbcDS = null;
      String recipient=null;
      String subject=null;
      String message=null;
      String from=null;
      String smtpHost=null;
      String domainName = null;
      
      String subscribeAction = "/DinerSubscribeConfirmAction.do";
      String webServer = null;

      int rc = 0;

      try {
         logger.debug("Enter");
           
         ExploreDinerForm=(ExploreDinerForm)form;
         context=servlet.getServletContext();
         jdbcDS = (String)context.getAttribute("jdbcDS");
         
         smtpHost = (String)context.getAttribute("smtpHost");
         domainName = (String)context.getAttribute("domain");
         webServer = (String)context.getAttribute("webServer");

         logger.debug("jdbs-DS:" + jdbcDS);
         
         ActionErrors actionErrors = new ActionErrors();
         Context ctx = new javax.naming.InitialContext();
         DataSource ds = (DataSource)ctx.lookup(jdbcDS);
         
         HttpSession session = request.getSession();
         String sessionCaptchaField = (String)session.getAttribute(Constants.CAPCHA_SESSION_KEY);
         String txtCaptchaField = ExploreDinerForm.getTxtCaptchaField();

         if (sessionCaptchaField.equals(txtCaptchaField)) {
           rc = Operations.signup(ExploreDinerForm,ds);
         
           if (rc < 0) {
             actionErrors.add("diner",new ActionMessage("errors.diner.duplicatediner"));
             saveErrors(request, actionErrors);
           }
           else {
               recipient = ExploreDinerForm.gettxtWorkEmail();
               from = "Diningo.com <listconfirm+" + rc + "@" + domainName + ">";
               subject = "Request to joing Diningo.com mailing list";
               message = "Greetings, \n\n";
               message += "You (or someone using your email address) just asked to join the ";
               message += "diningo.com mailing list to receive daily chef's specials in your neighborhood ";
               message += "restaurants. Because we practice good email list etiquette, we need ";
               message += "you to confirm that you actually made this request by following ";
               message += "the URL below: \n\n";
               message += "<" + webServer + request.getContextPath() + subscribeAction + "?confirm=" + rc + ">\n\n";
               message += "You can also reply to this message with any content (or none) or send ";
               message += "email to <mailto:listconfirm+" + rc + "@" + domainName + "> to confirm. \n\n" ;
               message += "If you do not respond to this message in any fashion, you will receive ";
               message += "no further email from us. There is no need to opt-out or unsubscribe. ";
               message += "When you do confirm your subscription, you will receive further instructions. \n\n";
               message += "In accordance with the latest legislation, our postal address is: \n";
               message += "DBSentry Corp. \n";
               message += "200 Little Falls St, Suite G201A \n";
               message += "Falls Church, VA - 22046, USA \n";
               message += "";
               
               logger.debug(message);

               GeneralUtil.postMail(recipient,subject,message,from,smtpHost);
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
