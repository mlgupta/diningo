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
 * $Id: ExploreOwnerB4Action.java,v 1.2 2007/03/16 19:44:57 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.commons.actions;

import com.diningo.web.commons.actionforms.ExploreOwnerForm;
import com.diningo.web.general.beans.DNGConstants;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 *              Purpose: To display contact_us.jsp.
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

ExploreOwnerB4Action extends Action {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    public ActionForward execute(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {

      ExploreOwnerForm ExploreOwnerForm=null;

      try {
           logger.debug("Enter");
              
           ExploreOwnerForm=new ExploreOwnerForm();
           ExploreOwnerForm.settxtName("");
           ExploreOwnerForm.settxtEmailId("");
           ExploreOwnerForm.settxtRestaurantName("");
           ExploreOwnerForm.settxtCity("") ;
           ExploreOwnerForm.setcboState("") ;
           ExploreOwnerForm.settxtZipCode("") ;
           ExploreOwnerForm.settxtPhone("") ;
           
           request.setAttribute("ExploreOwnerForm",ExploreOwnerForm);
          } catch (Exception e) {
            logger.error(e.toString());
            e.printStackTrace();
          } finally {
            logger.debug("Exit");
          }
          return mapping.findForward("success");
    }
}
