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
 * $Id: CategoryListAction.java,v 1.6 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.category.actions;

import com.diningo.web.category.actionforms.CategoryForm;
import com.diningo.web.category.beans.CategoryBean;
import com.diningo.web.category.beans.Operations;
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
 *              Purpose: To display the list of all the available categories. 
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

CategoryListAction extends Action {
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
           
          String resetFlag = request.getParameter("reset");
           
          if (CategoryForm.getHdnCategoryTblPk() == null || CategoryForm.getHdnCategoryTblPk().equals("")) {
              Operations.resetCategoryForm(CategoryForm);
          }

          if (resetFlag == null || "".equals(resetFlag)) {
          }
          else {
              if ("true".equals(resetFlag)) {
                  logger.debug("Reset Flag set. Resetting FormBean");
                  Operations.resetCategoryForm(CategoryForm);
              }
          }
          
           Context ctx = new javax.naming.InitialContext();
           DataSource ds = (DataSource)ctx.lookup(jdbcDS);
           
           DBConnection dbcon = new DBConnection(ds);
           
           sqlString = "select   a.category_tbl_pk "                              +
                               ",a.category_name "                                +
                               ",a.category_description "                         +
                       "from    category_tbl      a "                             +
                       "order by a.category_name";
           
           rs = dbcon.executeQuery(sqlString,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           
           rs.last();
           int rs_count = rs.getRow();
           rs.beforeFirst();

           CategoryBean[] categoryList   = new CategoryBean[rs_count];
           String[] selectedCategories   = new String[rs_count];
           
           int i = 0;           
           while (rs.next()) {
               categoryList[i] = new CategoryBean();
               categoryList[i].setCategory_tbl_pk(rs.getString(1));
               categoryList[i].setCategory_name(rs.getString(2));
               categoryList[i].setCategory_description(rs.getString(3));
               
               ++i;
           }
           
           CategoryForm.setCategoryList(categoryList);
           CategoryForm.setSelected(selectedCategories);
           
           dbcon.free(rs);
           request.setAttribute("CategoryForm",CategoryForm);
      } catch (Exception e) {
        logger.error(e.toString());
      } finally {
         logger.debug("Exit");
      }
      return mapping.findForward("success");
    }
}
