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
 * $Id: SubscribeDinerMassAction.java,v 1.1 2009/01/05 15:49:18 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.commons.actions;

import com.diningo.web.commons.actionforms.ExploreDinerForm;
import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.commons.beans.Operations;

import com.diningo.web.utils.CSVReader;

import java.io.FileReader;
import java.io.IOException;

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
 *              Purpose: Mass upload diners from cv file
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 03-11-2008
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

SubscribeDinerMassAction extends Action {
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
         
         Context ctx = new javax.naming.InitialContext();
         DataSource ds = (DataSource)ctx.lookup(jdbcDS);
         
         String CSVFile = request.getParameter("CSVFile");
         
         if ( CSVFile == null || "".equals(CSVFile)) {
             logger.info("Input file variable CSVFile was not specified");
         }
         else {
             CSVReader csvr;
             
             csvr = new CSVReader(new FileReader(CSVFile));
             String [] nextLine;
             int lineNumber = 0;
             
             ExploreDinerForm.setHdnSubscribedEmailTempTblPk("");
             ExploreDinerForm.settxtName("");
             ExploreDinerForm.settxtCity("");
             ExploreDinerForm.settxtcboState("");
             ExploreDinerForm.settxtZipCode("") ;
             ExploreDinerForm.settxtWorkEmail("") ;
             ExploreDinerForm.settxtHomeEmail("") ;
             ExploreDinerForm.settxtBirthDateDay("") ;
             ExploreDinerForm.settxtBirthDateMonth("") ;
             ExploreDinerForm.settxtUnsubscribeEmail("") ;
             
             String [] chkSpecials = new String[4];
             
             chkSpecials[0] = "1";
             chkSpecials[1] = "2";
             chkSpecials[2] = "3";
             chkSpecials[3] = "4";
             
             ExploreDinerForm.setChkSpecials(chkSpecials);
             
             while ((nextLine = csvr.readNext()) != null) {
                 ++lineNumber;
                 
                 rc=0;
                 
                 ExploreDinerForm.settxtName(nextLine[0]);
                 ExploreDinerForm.settxtWorkEmail(nextLine[1]) ;
                 ExploreDinerForm.settxtCity(nextLine[2]);
                 ExploreDinerForm.settxtcboState(nextLine[3]);
                 ExploreDinerForm.settxtZipCode(nextLine[4].substring(0,5)) ;

                 rc = Operations.signup(ExploreDinerForm,ds);
                  
                 if (rc < 0) {
                   logger.info("Line Number: " + lineNumber + " Rejected at signup");
                 }
                 else {
                     ExploreDinerForm.setHdnSubscribedEmailTempTblPk(Integer.toString(rc));
                     rc = Operations.confirmSignup(ExploreDinerForm,ds);
                     
                     if (rc < 0) {
                         logger.info("Line Number: " + lineNumber + " Rejected at confirm");
                     }
                     else {
                         logger.info("Line Number: " + lineNumber + " inserted successfully");
                     }
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
