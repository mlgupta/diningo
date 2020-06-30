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
 * $Id: DinerSubscribeConfirmAction.java,v 1.1 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.commons.actions;

import com.diningo.web.commons.actionforms.ExploreDinerForm;
import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.commons.beans.Operations;

import com.diningo.web.general.beans.DBConnection;
import com.diningo.web.general.beans.GeneralUtil;

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
 *              Purpose: To confirm subscription
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 05/30/2007
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class
DinerSubscribeConfirmAction extends Action {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    public ActionForward execute(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {

      ExploreDinerForm ExploreDinerForm=null;
      ServletContext context=null;
      String jdbcDS = null;
      ResultSet rs = null;
      String sqlString = null;
      String recipient=null;
      String subject=null;
      String message=null;
      String from=null;
      String smtpHost=null;
      String domainName = null;

      String unSubscribeAction = "/DinerUnsubscribeAction.do";
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
         
         String confirm = request.getParameter("confirm");
         
         if (confirm == null || "".equals(confirm)) {
             rc = -1;
         }
         else {
             ExploreDinerForm.setHdnSubscribedEmailTempTblPk(confirm);
             
             Context ctx = new javax.naming.InitialContext();
             DataSource ds = (DataSource)ctx.lookup(jdbcDS);
             
             DBConnection dbcon = new DBConnection(ds);
             
             sqlString =  "select a.work_email      " ;
             sqlString += "from  subscribed_email_temp_tbl  a ";
             sqlString += "where  a.subscribed_email_temp_tbl_pk = " + confirm;

             logger.debug(sqlString);
                 
             rs = dbcon.executeQuery(sqlString);            
             
             while (rs.next()) {
                 ExploreDinerForm.settxtWorkEmail(rs.getString(1));
             }
             dbcon.free(rs);
             
             if (ExploreDinerForm.gettxtWorkEmail() == null || "".equals(ExploreDinerForm.gettxtWorkEmail())) {
                 rc = -1;
             }
             else {
                 rc = Operations.confirmSignup(ExploreDinerForm,ds);
                 
                 if (rc < 0) {
                 }
                 else {
                       recipient = ExploreDinerForm.gettxtWorkEmail();
                       from = "Diningo.com <listbounce+" + rc + "@" + domainName + ">";
                       subject = "Your diningo.com mailing list subscription is active";
                       message = "Greetings, \n\n";
                       message += "Thank you for confirming your subscription to diningo.com daily chef's ";
                       message += "specials mailing list. To leave the list at any time, just follow the link: \n\n";
                       message += "<" + webServer + request.getContextPath() + unSubscribeAction + "?confirm=" + rc + ">\n\n";
                       message += "To remove yourself, you can also send email to: \n";
                       message += "<mailto:listunsub+" + rc + "@" + domainName + "> \n\n";
                       message += "In accordance with the latest legislation, our postal address is: \n";
                       message += "DBSentry Corp. \n";
                       message += "200 Little Falls St, Suite G201A \n";
                       message += "Falls Church, VA - 22046, USA \n";
                       message += "";
                       
                       logger.debug(message);

                       GeneralUtil.postMail(recipient,subject,message,from,smtpHost);
                 }
             }
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
