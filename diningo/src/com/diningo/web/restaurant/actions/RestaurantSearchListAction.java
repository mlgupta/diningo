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
 * $Id: RestaurantSearchListAction.java,v 1.8 2009/01/08 21:11:22 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.actions;

import com.diningo.web.general.beans.DBConnection;
import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.preferences.beans.PreferenceBean;
import com.diningo.web.restaurant.actionforms.RestaurantSearchForm;

import com.diningo.web.restaurant.beans.Operations;
import com.diningo.web.restaurant.beans.RestaurantSearchBean;

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
 *              Purpose: To display list of restaurants that match search criteria in restaurant_search.jsp 
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

RestaurantSearchListAction extends Action {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    public ActionForward execute(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {
      RestaurantSearchForm RestaurantSearchForm=null;
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
           
           RestaurantSearchForm = (RestaurantSearchForm)form;
           context=servlet.getServletContext();
           jdbcDS = (String)context.getAttribute("jdbcDS");
           
           logger.debug("jdbs-DS:" + jdbcDS);
           
           String pagerOffset = request.getParameter("pager.offset");
          
           if(pagerOffset == null || "".equals(pagerOffset)) {
              pagerOffset = "0";
              RestaurantSearchForm.setRow_count(0);
           }
           
           String cboZipCode = request.getParameter("cboZipCode");
          
           if(cboZipCode == null || "".equals(cboZipCode)) {
           }
           else {
              RestaurantSearchForm.setCboZipCode(cboZipCode.substring(0,5));
           }

           String cboState = request.getParameter("cboState");
           
           if(cboState == null || "".equals(cboState)) {
           }
           else {
               RestaurantSearchForm.setCboState(cboState.substring(0,2));
           }

           String metroArea = request.getParameter("metroArea");
           
           if (metroArea == null || "".equals(metroArea)) {
               
           }
           else {
               RestaurantSearchForm.setTxtMetroArea(metroArea.substring(0,2));
           }

//           String cboMeals = request.getParameter("cboMeals");
//          
//            if(cboMeals == null || "".equals(cboMeals)) {
//           }
//           else {
//              RestaurantSearchForm.setCboMeals(cboMeals.substring(0,1));
//           }
           RestaurantSearchForm.setCboMeals("2");

           RestaurantSearchForm.setUri(request.getRequestURI());
           
           HttpSession session = request.getSession();
          
           userPreferences = (PreferenceBean)session.getAttribute("userPreferences");
           
           maxPageItems = RestaurantSearchForm.getMaxPageItems();
           if (maxPageItems == 0) {
               maxPageItems = 20;
               RestaurantSearchForm.setMaxPageItems(maxPageItems);
           }
                     
           Context ctx = new javax.naming.InitialContext();
           DataSource ds = (DataSource)ctx.lookup(jdbcDS);
           
           DBConnection dbcon = new DBConnection(ds);
           
           String userEmailAddress = RestaurantSearchForm.getUserEmailAddress();
           
           logger.debug("User Email Address: " + userEmailAddress);
           
           if(userEmailAddress == null || "".equals(userEmailAddress)) {
           }
           else {
               if(RestaurantSearchForm.getCboZipCode() == null || "".equals(RestaurantSearchForm.getCboZipCode())) {
                   sqlString  =  "select  a.zipcode "                          +
                                 "from    subscribed_emails_tbl  a "           +
                                 "where   a.work_email = '" + userEmailAddress + "'";
                   logger.debug(sqlString);
                   
                   rs = dbcon.executeQuery(sqlString);            
                   while (rs.next()) {
                       RestaurantSearchForm.setCboZipCode(rs.getString(1));
                       logger.debug("Zipcode : " + rs.getString(1));
                   }
               }
           }
           
           sqlString_tbl =  "from    restaurant_tbl                  a "               +
                                   ",state_tbl                       b "               +
                                   ",restaurant_subscription_tbl     c "               +
                                   ",restaurant_todays_specials_vw   d ";
                                   
           sqlString_where = "where   a.state_tbl_fk = b.state_tbl_pk "               +
                               "and   a.restaurant_tbl_pk  = c.restaurant_tbl_fk "    +
                               "and   c.subscription_from    <= CURRENT_DATE "        +
                               "and   c.subscription_to      >= CURRENT_DATE "        +
                               "and   a.date_inac            >= CURRENT DATE "        +
                               "and   a.date_eff             <= CURRENT DATE "        +
                               "and   a.restaurant_tbl_pk   = d.restaurant_tbl_fk "   +
                               "and   c.specials_tbl_fk	= d.specials_tbl_fk ";

          if (RestaurantSearchForm.getTxtName() == null  || "".equals(RestaurantSearchForm.getTxtName())  || " All Restaurant".equals(RestaurantSearchForm.getTxtName())) {
          }
          else {
              logger.debug("Name: " + RestaurantSearchForm.getTxtName());
              sqlString_where = sqlString_where                      +
                                "and a.restaurant_name like '"       +
                                RestaurantSearchForm.getTxtName()    +
                                "%' ";
          }
           
          if (RestaurantSearchForm.getCboCuisine() == null || "".equals(RestaurantSearchForm.getCboCuisine()) ) {
          }
          else {
              logger.debug("Cuisine: " + RestaurantSearchForm.getCboCuisine());
              sqlString_tbl = sqlString_tbl               +
                              ",restaurant_category_tbl    e ";
              sqlString_where = sqlString_where           +
                                "and a.restaurant_tbl_pk = e.restaurant_tbl_fk " +
                                "and e.category_tbl_fk = "                       +
                               RestaurantSearchForm.getCboCuisine()              +
                                " ";
          }
          
          if (RestaurantSearchForm.getCboCity() == null  || "".equals(RestaurantSearchForm.getCboCity())) {
          }
          else {
              logger.debug("City: " + RestaurantSearchForm.getCboCity());
              sqlString_where = sqlString_where                      +
                                "and a.city = '"                     +
                                RestaurantSearchForm.getCboCity()    +
                                "' ";
          }
          if (RestaurantSearchForm.getCboState() == null || "".equals(RestaurantSearchForm.getCboState())) {
          }
          else {
              logger.debug("State: " + RestaurantSearchForm.getCboState());
              sqlString_where = sqlString_where                             +
                                "and a.state_tbl_fk = "                     +
                                RestaurantSearchForm.getCboState()          +
                                " ";
          }
          if (RestaurantSearchForm.getCboZipCode() == null  || "".equals(RestaurantSearchForm.getCboZipCode()) || " Zip".equals(RestaurantSearchForm.getCboZipCode())) {
          }
          else {
              logger.debug("Zipcode: " + RestaurantSearchForm.getCboZipCode());
              sqlString_where = sqlString_where                              +
                                "and a.zipcode = '"                          +
                                RestaurantSearchForm.getCboZipCode()         +
                                "' ";
          }
          if (RestaurantSearchForm.getCboMeals() == null || "".equals(RestaurantSearchForm.getCboMeals())) {
          }
          else {
              logger.debug("Meal: " + RestaurantSearchForm.getCboMeals());
              sqlString_where = sqlString_where                                  +
                                "and d.specials_tbl_fk = "                       +
                               RestaurantSearchForm.getCboMeals()                +
                                " ";
          }
          
          if (RestaurantSearchForm.getTxtMetroArea() == null || "".equals(RestaurantSearchForm.getTxtMetroArea())) {
              
          }
          else {
              logger.debug("Metro: " + RestaurantSearchForm.getTxtMetroArea());
              sqlString_where += " and a.metro_area_tbl_fk = " + RestaurantSearchForm.getTxtMetroArea() + " ";
          }

           if (RestaurantSearchForm.getRow_count() == 0) {
               sqlString = "select count(a.restaurant_tbl_pk) "           +
                           sqlString_tbl                                  +
                           sqlString_where;
                           
               logger.debug(sqlString);
               
               rs = dbcon.executeQuery(sqlString);            
               while (rs.next()) {
                   RestaurantSearchForm.setRow_count(rs.getInt(1));
                   logger.debug("Row Count: " + rs.getInt(1));
               }
           }
          
           if(Integer.parseInt(pagerOffset) > RestaurantSearchForm.getRow_count())
              pagerOffset = String.valueOf(RestaurantSearchForm.getRow_count() - Integer.parseInt(pagerOffset));
                   
               sqlString = "select   a.restaurant_name "                              +
                                   ",a.address1 "                                     +
                                   ",a.address2 "                                     +
                                   ",a.city "                                         +
                                   ",b.state_name "                                   +
                                   ",a.zipcode "                                      +
                                   ",a.restaurant_phone "                             +
                                   ",a.website "                                      +
                                   ",a.menu_url "                                     +
                                   ",a.entertainment_url "                            +
                                   ",a.map_url "                                      +
                                   ",a.reservation_url "                              +
                                   ",d.template_specials_menu "                       +
                                   ",d.daily_specials_menu "                          +
                                   ",a.restaurant_tbl_pk "                            +
                            sqlString_tbl                                             +
                            sqlString_where                                           +
                           "order by a.restaurant_name "                              +
                           "offset " + pagerOffset + " limit " + maxPageItems;
                           
           logger.debug(sqlString);
               
           rs = dbcon.executeQuery(sqlString,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
               
           rs.last();
           int rs_count = rs.getRow();
           rs.beforeFirst();

           RestaurantSearchBean[] restaurantSearchBean = new RestaurantSearchBean[rs_count];
           
           String daily_specials_menu = "";
           String txtFormattedSpecialsMenu;
               
           int i = 0;           
           while (rs.next()) {
              restaurantSearchBean[i] = new RestaurantSearchBean();
              restaurantSearchBean[i].setTxtRestaurantName(rs.getString(1));
              restaurantSearchBean[i].setTxtAddress1(rs.getString(2));
              restaurantSearchBean[i].setTxtAddress2(rs.getString(3));
              restaurantSearchBean[i].setTxtCity(rs.getString(4));
              restaurantSearchBean[i].setTxtState(rs.getString(5));
              restaurantSearchBean[i].setTxtZipcode(rs.getString(6));
              restaurantSearchBean[i].setTxtRestaurantPhone(rs.getString(7));
              restaurantSearchBean[i].setTxtWebsite(rs.getString(8));
              restaurantSearchBean[i].setTxtMenuUrl(rs.getString(9));
              restaurantSearchBean[i].setTxtEntertainmentUrl(rs.getString(10));
              restaurantSearchBean[i].setTxtMapUrl(rs.getString(11));
              restaurantSearchBean[i].setTxtReservationUrl(rs.getString(12));
              
              daily_specials_menu = rs.getString(14);
              if (daily_specials_menu == null || "".equals(daily_specials_menu)) {
                  restaurantSearchBean[i].setTxtSpecialsMenu(rs.getString(13));
              }
              else {
                  restaurantSearchBean[i].setTxtSpecialsMenu(daily_specials_menu);
              }
              
              txtFormattedSpecialsMenu = Operations.text2html(restaurantSearchBean[i].getTxtSpecialsMenu());
              restaurantSearchBean[i].setTxtFormattedSpecialsMenu(txtFormattedSpecialsMenu);
              
              restaurantSearchBean[i].setHdnRestaurantTblPk(rs.getString(15));
               
              ++i;
           }
               
           RestaurantSearchForm.setRestaurantSearchList(restaurantSearchBean);

           dbcon.free(rs);
           request.setAttribute("RestaurantSearchForm", RestaurantSearchForm);
      } catch (Exception e) {
        logger.error(e.toString());
      } finally {
         logger.debug("Exit");
      }
      return mapping.findForward("success");          
    }
}
