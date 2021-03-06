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
 * $Id: PubActionServlet.java,v 1.3 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */

package com.diningo.web.action;

import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.restaurant.beans.CityBean;
import com.diningo.web.restaurant.beans.CuisineBean;
import com.diningo.web.restaurant.beans.SpecialsBean;
import com.diningo.web.restaurant.beans.StateBean;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


/**
 *              Purpose: General Action Servlet
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 03-20-2007
 *    Last Modified by : 
 *  Last Modified Date :
 */

public class PubActionServlet extends org.apache.struts.action.ActionServlet {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    private ServletContext context = null;

  public void init(ServletConfig config) throws ServletException {

    try {
      super.init(config);

      log("Entering Actionservlet");

      log("Initializing Logger...");
      context = config.getServletContext();
      
      String prefix = context.getRealPath("/");
      String log4jInitFile = getInitParameter("log4j-init-file");
      String smtpHost = getInitParameter("smtp-host");
      String domain = getInitParameter("domain");
      String sendMailTo = getInitParameter("sendmailto");
      String jdbcDS = getInitParameter("jdbc-DS");
      String webServer = getInitParameter("web-server");
      
      context.setAttribute("contextPath", prefix);
      context.setAttribute("smtpHost", smtpHost);
      context.setAttribute("domain", domain);
      context.setAttribute("sendMailTo", sendMailTo);
      context.setAttribute("jdbcDS", jdbcDS);
      context.setAttribute("webServer", webServer);

      if (log4jInitFile != null) {
        PropertyConfigurator.configure(prefix + log4jInitFile);
        logger.info("Logger initialized successfully..");
      } else {
        log("Unable to find log4j-initialization-file : " + log4jInitFile);
      }
      logger.debug("Initializing beans for application scope");
      
      logger.debug("Initializing States Bean");
      StateBean stateBean = new StateBean(jdbcDS);
      config.getServletContext().setAttribute("StateBean", stateBean);
      
      logger.debug("Initializing Specials Bean");
      SpecialsBean specialsBean = new SpecialsBean(jdbcDS);
      config.getServletContext().setAttribute("SpecialsBean", specialsBean);
     
      logger.debug("Initializing Specials Bean");
      CuisineBean cuisineBean = new CuisineBean(jdbcDS);
      config.getServletContext().setAttribute("CuisineBean", cuisineBean);
        
      logger.debug("Initializing Specials Bean");
      CityBean cityBean = new CityBean(jdbcDS);
      config.getServletContext().setAttribute("CityBean", cityBean);
        
      logger.debug("Exit init");
    } catch (Exception e) {
      e.printStackTrace();
      log(" Unable to initialize logger : " + e.toString());
    }
  }

//All the request will pass through this method
  public void process(HttpServletRequest request,
                      HttpServletResponse response) {
   
    logger.debug("Enter");    
    
    try {
      super.process(request, response);
      logger.debug("Exit");    
    } catch (Exception ex) {
      ex.printStackTrace();
      logger.error(ex);
    }
  }
}
