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
 * $Id: CategoryEditAction.java,v 1.1 2007/03/21 02:24:20 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.category.actions;

import com.diningo.web.category.actionforms.CategoryForm;
import com.diningo.web.general.beans.DBConnection;
import com.diningo.web.general.beans.DNGConstants;

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
 *              Purpose: To create new or edit existing categories. 
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

CategoryEditAction extends Action {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    public ActionForward execute(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {

      CategoryForm CategoryForm=null;
      ServletContext context=null;
      String jdbcDS = null;
      ResultSet rs = null;
      String sqlString = null;
      
      try {
           logger.debug("Enter");
           
           CategoryForm = (CategoryForm)form;
           context=servlet.getServletContext();
           jdbcDS = (String)context.getAttribute("jdbcDS");
          
           logger.debug("jdbs-DS:" + jdbcDS);
          
           Context ctx = new javax.naming.InitialContext();
           DataSource ds = (DataSource)ctx.lookup(jdbcDS);
          
           String categoryTblPk = request.getParameter("category_tbl_pk").trim();
           
           if (categoryTblPk.equals("") || categoryTblPk == null) {
             logger.debug("Passed parameter category_tbl_pk is blank or null");
           }
           else {
               DBConnection dbcon = new DBConnection(ds);

               CategoryForm.setHdnCategoryTblPk(categoryTblPk);

               sqlString = "select   a.category_tbl_pk "                              +
                                   ",a.category_name "                                +
                                   ",a.category_description "                         +
                           "from    category_tbl      a "                             +
                           "where   a.category_tbl_pk = " + categoryTblPk;
               
               rs = dbcon.executeQuery(sqlString);
               
               while (rs.next()) {
                   CategoryForm.setTxtCategoryName(rs.getString(2));
                   CategoryForm.setTxtCategoryDesc(rs.getString(3));
               }
               
               dbcon.free(rs);
           }
      } catch (Exception e) {
        logger.error(e.toString());
          return mapping.findForward("failure");
      } finally {
         logger.debug("Exit");
      }
      return mapping.findForward("success");
    }
}
