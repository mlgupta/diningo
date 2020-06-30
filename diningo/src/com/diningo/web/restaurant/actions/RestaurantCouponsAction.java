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
 * $Id: RestaurantCouponsAction.java,v 1.3 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.actions;

import com.diningo.web.general.beans.DBConnection;
import com.diningo.web.general.beans.DNGConstants;

import com.diningo.web.restaurant.actionforms.RestaurantCouponsForm;

import com.diningo.web.restaurant.beans.Operations;

import java.io.IOException;

import java.sql.ResultSet;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.actions.LookupDispatchAction;


/**
 *              Purpose:
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

RestaurantCouponsAction extends LookupDispatchAction {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    protected Map getKeyMethodMap() {
        logger.debug("Enter getKeyMethodMap");
        
        Map map = new HashMap();
        
        map.put("button.preview", "preview");
        map.put("button.save", "save");
        map.put("button.cancel", "cancel");
        map.put("button.delete", "delete");
        
        logger.debug("Exit getKeyMethodMap");
        return map;
    }

    public ActionForward preview(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {
        RestaurantCouponsForm RestaurantCouponsForm=null;
        ServletContext context=null;
        String jdbcDS = null;

        try {
            logger.debug("Enter preview");
             
             RestaurantCouponsForm = (RestaurantCouponsForm)form;
             context=servlet.getServletContext();
             jdbcDS = (String)context.getAttribute("jdbcDS");
             
             logger.debug("jdbs-DS:" + jdbcDS);
        } catch (Exception e) {
          logger.error(e.toString());
        } finally {
            logger.debug("Exit preview");
        }
        return mapping.findForward("success");
    }

    public ActionForward save(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {
        RestaurantCouponsForm RestaurantCouponsForm=null;
        ServletContext context=null;
        String jdbcDS = null;
        int rc = 0;

        try {
            logger.debug("Enter save");
             
            RestaurantCouponsForm=(RestaurantCouponsForm)form;
            context=servlet.getServletContext();
            jdbcDS = (String)context.getAttribute("jdbcDS");
            
            logger.debug("jdbs-DS:" + jdbcDS);
            
            ActionErrors actionErrors = new ActionErrors();
            Context ctx = new javax.naming.InitialContext();
            DataSource ds = (DataSource)ctx.lookup(jdbcDS);
            
            if (RestaurantCouponsForm.getHdnRestaurantCouponsTblPk() == null || "".equals(RestaurantCouponsForm.getHdnRestaurantCouponsTblPk())) {
                rc = Operations.AddRestaurantCoupons(RestaurantCouponsForm,ds);
                if (rc < 0) {
                   actionErrors.add("user",new ActionMessage("errors.restaurant.coupons.insert.error"));
                }
            }
            else {
                rc = Operations.UpdateRestaurantCoupons(RestaurantCouponsForm,ds);
                if (rc < 0) {
                   actionErrors.add("user",new ActionMessage("errors.restaurant.coupons.update.error"));
                }
            }
            if (rc < 0) {
                saveErrors(request, actionErrors);
            }
        } catch (Exception e) {
          logger.error(e.toString());
        } finally {
            logger.debug("Exit save");
        }
        if (rc < 0) {
            return mapping.findForward("failure");
        }
        else {
            return mapping.findForward("success_save");
        }
    }


    public ActionForward cancel(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {
        logger.debug("Enter cancel");
        logger.debug("Exit cancel");
        return mapping.findForward("success_cancel");
    }

    public ActionForward delete(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {
        RestaurantCouponsForm RestaurantCouponsForm=null;
        ServletContext context=null;
        String jdbcDS = null;
        int rc = 0;

        try {
            logger.debug("Enter save");
             
            RestaurantCouponsForm=(RestaurantCouponsForm)form;
            context=servlet.getServletContext();
            jdbcDS = (String)context.getAttribute("jdbcDS");
            
            logger.debug("jdbs-DS:" + jdbcDS);
            
            ActionErrors actionErrors = new ActionErrors();
            Context ctx = new javax.naming.InitialContext();
            DataSource ds = (DataSource)ctx.lookup(jdbcDS);

            rc = Operations.DeleteRestaurantCoupons(RestaurantCouponsForm,ds);
            if (rc < 0) {
                actionErrors.add("user",new ActionMessage("errors.restaurant.coupons.delete.error"));
                saveErrors(request, actionErrors);
            }
        } catch (Exception e) {
          logger.error(e.toString());
        } finally {
            logger.debug("Exit save");
        }
        return mapping.findForward("success");
    }

    public ActionForward unspecified(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {
        RestaurantCouponsForm RestaurantCouponsForm=null;
        ServletContext context=null;
        String jdbcDS = null;

        try {
            logger.debug("Enter unspecified");
             
             RestaurantCouponsForm = (RestaurantCouponsForm)form;
             context=servlet.getServletContext();
             jdbcDS = (String)context.getAttribute("jdbcDS");
             
             logger.debug("jdbs-DS:" + jdbcDS);
             
        } catch (Exception e) {
          logger.error(e.toString());
        } finally {
            logger.debug("Exit unspecified");
        }
        return mapping.findForward("success");
    }

    public ActionForward cancelled(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {
        RestaurantCouponsForm RestaurantCouponsForm=null;
        ServletContext context=null;
        String jdbcDS = null;

        try {
            logger.debug("Enter cancelled");
             
             RestaurantCouponsForm = (RestaurantCouponsForm)form;
             context=servlet.getServletContext();
             jdbcDS = (String)context.getAttribute("jdbcDS");
             
             logger.debug("jdbs-DS:" + jdbcDS);
        } catch (Exception e) {
          logger.error(e.toString());
        } finally {
            logger.debug("Exit cancelled");
        }
        return mapping.findForward("success_cancel");
    }

}
