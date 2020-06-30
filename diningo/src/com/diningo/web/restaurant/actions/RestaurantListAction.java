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
 * $Id: RestaurantListAction.java,v 1.6 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.actions;

import com.diningo.web.general.beans.DBConnection;
import com.diningo.web.general.beans.DNGConstants;

import com.diningo.web.preferences.beans.PreferenceBean;
import com.diningo.web.restaurant.actionforms.RestaurantListForm;
import com.diningo.web.restaurant.beans.Operations;

import com.diningo.web.restaurant.beans.RestaurantBean;

import java.io.IOException;

import java.sql.ResultSet;

import javax.naming.Context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


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

RestaurantListAction extends Action {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    public ActionForward execute(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {
      RestaurantListForm RestaurantListForm=null;
      ServletContext context=null;
      String jdbcDS = null;
      ResultSet rs = null;
      String sqlString = null;
      String sqlString_tbl = null;
      String sqlString_where = null;
      int maxPageItems = 0;
      PreferenceBean userPreferences;

      try {
           logger.debug("Enter");
           
           RestaurantListForm = (RestaurantListForm)form;
           context=servlet.getServletContext();
           jdbcDS = (String)context.getAttribute("jdbcDS");
           
           logger.debug("jdbs-DS:" + jdbcDS);

           String resetFlag = request.getParameter("reset");

           if (resetFlag == null || "".equals(resetFlag)) {
           }
           else {
            if ("true".equals(resetFlag)) {
                logger.debug("Reset Flag set. Resetting FormBean");
                Operations.resetRestaurantListForm(RestaurantListForm);
            }
          }
           
          if (RestaurantListForm.getHdnRestaurantTblPk() == null || "".equals(RestaurantListForm.getHdnRestaurantTblPk())) {
           Operations.resetRestaurantListForm(RestaurantListForm);
          } 
           
           String pagerOffset = request.getParameter("pager.offset");
          
           if(pagerOffset == null || "".equals(pagerOffset)) {
              pagerOffset = "0";
              RestaurantListForm.setRow_count(0);
           }

           RestaurantListForm.setUri(request.getRequestURI());
           
           HttpSession session = request.getSession();
          
           userPreferences = (PreferenceBean)session.getAttribute("userPreferences");
           maxPageItems  = RestaurantListForm.getMaxPageItems();
           if (maxPageItems == 0) {
               maxPageItems = Integer.parseInt(userPreferences.getMaxPageItems());
              
               if (maxPageItems == 0) {
                 maxPageItems = 50;
               }
               RestaurantListForm.setMaxPageItems(maxPageItems);
           }
           
           logger.debug("maxPageItems: " + maxPageItems);
                     
           Context ctx = new javax.naming.InitialContext();
           DataSource ds = (DataSource)ctx.lookup(jdbcDS);
           
           DBConnection dbcon = new DBConnection(ds);
           
           sqlString_tbl =  "from    restaurant_tbl                  a "               +
                                   ",user_tbl                        b "               +
                                   ",state_tbl                       c " ;
                                   
           sqlString_where = "where   a.user_tbl_fk = b.user_tbl_pk "                 +
                               "and   a.state_tbl_fk = c.state_tbl_pk "               +
                               "and   a.date_eff            <=  CURRENT_DATE "        +
                               "and   a.date_inac            >  CURRENT_DATE ";

           
          if (RestaurantListForm.getCboCuisine() == null || "".equals(RestaurantListForm.getCboCuisine()) ) {
          }
          else {
              sqlString_tbl = sqlString_tbl               +
                              ",restaurant_category_tbl    d ";
              sqlString_where = sqlString_where           +
                                "and a.restaurant_tbl_pk = d.restaurant_tbl_fk " +
                                "and d.category_tbl_fk = "                       +
                               RestaurantListForm.getCboCuisine()                +
                                " ";
          }
          if (RestaurantListForm.getCboCity() == null  || "".equals(RestaurantListForm.getCboCity())) {
          }
          else {
              sqlString_where = sqlString_where                      +
                                "and a.city = '"                     +
                                RestaurantListForm.getCboCity()      +
                                "' ";
          }
          if (RestaurantListForm.getCboState() == null || "".equals(RestaurantListForm.getCboState())) {
          }
          else {
              sqlString_where = sqlString_where                       +
                                "and a.state_tbl_fk = "               +
                                RestaurantListForm.getCboState()      +
                                " ";
          }
          if (RestaurantListForm.getCboZipCode() == null  || "".equals(RestaurantListForm.getCboZipCode())) {
          }
          else {
              sqlString_where = sqlString_where                        +
                                "and a.zipcode = '"                    +
                                RestaurantListForm.getCboZipCode()     +
                                "' ";
          }
          if (RestaurantListForm.getCboSubscription() == null || "".equals(RestaurantListForm.getCboSubscription())) {
          }
          else {
              sqlString_tbl = sqlString_tbl                         +
                              ",restaurant_subscription_tbl    e ";
              sqlString_where = sqlString_where                                  +
                                "and a.restaurant_tbl_pk = e.restaurant_tbl_fk " +
                                "and e.specials_tbl_fk = "                       +
                               RestaurantListForm.getCboSubscription()           +
                                " ";
          }


           if (RestaurantListForm.getRow_count() == 0) {
               sqlString = "select count(distinct a.restaurant_tbl_pk) "           +
                           sqlString_tbl                                           +
                           sqlString_where;
                           
               logger.debug(sqlString);
               
               rs = dbcon.executeQuery(sqlString);            
               while (rs.next()) {
                   RestaurantListForm.setRow_count(rs.getInt(1));
                   logger.debug("Row Count: " + rs.getInt(1));
               }
           }
          
           if (RestaurantListForm.getRow_count() == 0) {
               RestaurantBean[] restaurantList = new RestaurantBean[1];
               String[] selected   = new String[1];
               
               restaurantList[0] = new RestaurantBean();
               
               restaurantList[0].setRestaurant_tbl_pk("0");
               restaurantList[0].setRestaurant_name("");
               restaurantList[0].setRestaurant_phone("");
               restaurantList[0].setAgent_name("'");

               RestaurantListForm.setRestaurantList(restaurantList);
               RestaurantListForm.setSelected(selected);
           }
           else {
               if(Integer.parseInt(pagerOffset) > RestaurantListForm.getRow_count())
                   pagerOffset = String.valueOf(RestaurantListForm.getRow_count() - Integer.parseInt(pagerOffset));
                   
               sqlString = "select  distinct a.restaurant_tbl_pk "                    +
                                   ",a.restaurant_name "                              +
                                   ",a.restaurant_phone "                             +
                                   ",b.user_name "                                    +
                                   ",a.city "                                         +
                                   ",c.state_name "                                   +
                            sqlString_tbl                                             +
                            sqlString_where                                           +
                           "order by a.restaurant_tbl_pk "                            +
                           "offset " + pagerOffset + " limit " + maxPageItems;
                           
               logger.debug(sqlString);
               
               rs = dbcon.executeQuery(sqlString,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
               
               rs.last();
               int rs_count = rs.getRow();
               rs.beforeFirst();

               RestaurantBean[] restaurantList = new RestaurantBean[rs_count];
               String[] selected   = new String[rs_count];
               
               int i = 0;           
               while (rs.next()) {
                   restaurantList[i] = new RestaurantBean();
                   restaurantList[i].setRestaurant_tbl_pk(rs.getString(1));
                   restaurantList[i].setRestaurant_name(rs.getString(2));
                   restaurantList[i].setRestaurant_phone(rs.getString(3));
                   restaurantList[i].setAgent_name(rs.getString(4));
                   restaurantList[i].setRestaurant_city(rs.getString(5));
                   restaurantList[i].setRestaurant_state(rs.getString(6));
                   
                   ++i;
               }
               
               RestaurantListForm.setRestaurantList(restaurantList);
               RestaurantListForm.setSelected(selected);
           }
           dbcon.free(rs);
           request.setAttribute("RestaurantListForm",RestaurantListForm);
      } catch (Exception e) {
        logger.error(e.toString());
      } finally {
         logger.debug("Exit");
      }
      return mapping.findForward("success");
    }
}
