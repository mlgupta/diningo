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
 * $Id: diningoRequestProcessor.java,v 1.1 2007/05/01 20:29:34 manish Exp $
 *****************************************************************************
 */

package com.diningo.web.action;

import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.loginout.beans.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;


/**
 *              Purpose: Custom Request processor
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 03-20-2007
 *    Last Modified by : 
 *  Last Modified Date :
 */

public class diningoRequestProcessor extends org.apache.struts.action.RequestProcessor {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());

    protected boolean processRoles(HttpServletRequest request,
                                   HttpServletResponse response,
                                   ActionMapping mapping) throws IOException, ServletException {   
      logger.debug("Enter");    

      // Is this action protected by role requirements?
      String roles[] = mapping.getRoleNames();
      if ((roles == null) || (roles.length < 1)) {
          return (true);
      }

      String contextPath = request.getContextPath();
      String loginB4Action = contextPath + "/LoginB4Action.do";
      
      logger.debug("Loginpage: " + loginB4Action);

      String pageReq = request.getRequestURI();
      logger.debug("requestedPage: " + pageReq);
      
      // Check the current user against the list of required roles
      HttpSession session = request.getSession();
      
      User user = (User) session.getAttribute("user");

      if (user == null) {
          logger.debug("Invalid Session");
          response.sendRedirect(loginB4Action);
          return false;
      }

      for (int i = 0; i < roles.length; i++) {
          if (user.hasRole(roles[i])) {
              return (true);
          }
      }

      logger.debug("Unauthorized attempt to access " + pageReq + " by " + user.getUsername());

      response.sendRedirect("errorNotAuthorized.do");
      return (false);
  }
}
