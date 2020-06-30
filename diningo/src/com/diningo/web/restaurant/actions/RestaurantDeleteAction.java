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
 * $Id: RestaurantDeleteAction.java,v 1.2 2007/05/01 20:29:34 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.actions;

import com.diningo.web.general.beans.DNGConstants;

import com.diningo.web.restaurant.actionforms.RestaurantListForm;

import com.diningo.web.restaurant.beans.Operations;

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
 *              Purpose: To display list of restaurants for restaurant_management.jsp 
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

RestaurantDeleteAction extends Action {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    public ActionForward execute(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {

        RestaurantListForm RestaurantListForm=null;
        ServletContext context=null;
        String jdbcDS = null;
        int rc = 0;

        try {
           logger.debug("Enter");
             
           RestaurantListForm=(RestaurantListForm)form;
           context=servlet.getServletContext();
           jdbcDS = (String)context.getAttribute("jdbcDS");
           
           logger.debug("jdbs-DS:" + jdbcDS);
           
           ActionErrors actionErrors = new ActionErrors();           
           
           Context ctx = new javax.naming.InitialContext();
           DataSource ds = (DataSource)ctx.lookup(jdbcDS);
           
           rc = Operations.DeleteRestaurant(RestaurantListForm,ds);
           if (rc < 0) {
               actionErrors.add("user",new ActionMessage("errors.restaurant.delete.error"));
               saveErrors(request, actionErrors);
            }
        } catch (Exception e) {
          logger.error(e.toString());
          return mapping.findForward("failure");
        } finally {
           logger.info("Exit");
        }
        return mapping.findForward("success");
     }
}
