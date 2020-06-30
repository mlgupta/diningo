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
 * $Id: SpecialsB4Action.java,v 1.7 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.actions;

import com.diningo.web.general.beans.DBConnection;
import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.preferences.beans.PreferenceBean;
import com.diningo.web.restaurant.actionforms.RestaurantSpecialsForm;

import com.diningo.web.restaurant.beans.RestaurantSpecialsBean;

import com.diningo.web.restaurant.beans.TemplateBean;
import com.diningo.web.restaurant.beans.Operations;

import java.io.IOException;

import java.sql.ResultSet;

import java.util.Calendar;

import javax.naming.Context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


/**
 *              Purpose: To display given specials data for a given restaurant
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

SpecialsB4Action extends Action {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    public ActionForward execute(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {
      RestaurantSpecialsForm RestaurantSpecialsForm=null;
      ServletContext context=null;
      String jdbcDS = null;
      ResultSet rs = null;
      String sqlString = null;
      PreferenceBean userPreferences;
      String selectedRestaurant;
      int rc = 0;

      try {
           logger.debug("Enter");
           
           RestaurantSpecialsForm = (RestaurantSpecialsForm)form;
           context=servlet.getServletContext();
           jdbcDS = (String)context.getAttribute("jdbcDS");
           
           logger.debug("jdbs-DS:" + jdbcDS);

           String resetFlag = request.getParameter("reset");

           if (resetFlag == null || "".equals(resetFlag)) {
           }
           else {
             if ("true".equals(resetFlag)) {
                 logger.debug("Reset Flag set. Resetting FormBean");
                 Operations.resetRestaurantSpecialsForm(RestaurantSpecialsForm);
             }
           }
           
           ActionErrors actionErrors = new ActionErrors();
           HttpSession session = request.getSession();
          
           selectedRestaurant = (String)session.getAttribute("selectedRestaurant");
          
           if (selectedRestaurant == null || "".equals(selectedRestaurant)) {
               logger.debug("Restaurant is null or blank");
               return mapping.findForward("failure");
           }

           RestaurantSpecialsForm.setHdnRestaurantTblPk(selectedRestaurant);
           
           String modifyRequest = request.getParameter("modify_request");
          
           if(modifyRequest == null || "".equals(modifyRequest)) {
               if (RestaurantSpecialsForm.getHdnSpecialsType() == null || "".equals(RestaurantSpecialsForm.getHdnSpecialsType())) {
                   logger.debug("Modify request is null or blank");
                   return mapping.findForward("failure");
               }
               else {
                   modifyRequest = RestaurantSpecialsForm.getHdnSpecialsType();
               }
           }
           else {
               RestaurantSpecialsForm.setHdnSpecialsType(modifyRequest);
           }
           
           userPreferences = (PreferenceBean)session.getAttribute("userPreferences");
           
           if (modifyRequest.equals("BREAKFAST")) {
             if(!userPreferences.isSubscribeBreakfast()) {
                  return mapping.findForward("failure");
              }
           }   
           
           if (modifyRequest.equals("LUNCH")) {
             if(!userPreferences.isSubscribeLunch()) {
                  return mapping.findForward("failure");
              }
           }   
           
           if (modifyRequest.equals("HAPPYHOUR")) {
             if(!userPreferences.isSubscribeHH()) {
                  return mapping.findForward("failure");
              }
           }    
           
           if (modifyRequest.equals("DINNER")) {
             if(!userPreferences.isSubscribeDinner()) {
                  return mapping.findForward("failure");
              }
           }   
                     
           Context ctx = new javax.naming.InitialContext();
           DataSource ds = (DataSource)ctx.lookup(jdbcDS);
           
           DBConnection dbcon = new DBConnection(ds);
           
           sqlString =  "select a.restaurant_name "                           +
                              ",a.address1 "                                  +
                              ",a.address2 "                                  +
                              ",a.city "                                      +
                              ",b.state_name "                                +
                              ",a.zipcode "                                   +
                              ",a.restaurant_phone "                          +
                              ",a.website "                                   +
                              ",a.menu_url "                                  +
                              ",a.entertainment_url "                         +
                              ",a.map_url "                                   +
                              ",a.reservation_url ";
                                   
           sqlString += "from  restaurant_tbl   a "                           +
                             ",state_tbl        b ";
                             
           sqlString += "where  a.state_tbl_fk = b.state_tbl_pk "             +
                          "and  a.restaurant_tbl_pk = " + RestaurantSpecialsForm.getHdnRestaurantTblPk();

           logger.debug(sqlString);
          
           rs = dbcon.executeQuery(sqlString);
          
           while (rs.next()) {
               RestaurantSpecialsForm.setTxtRestaurantName(rs.getString(1));
               RestaurantSpecialsForm.setTxtAddress1(rs.getString(2));
               RestaurantSpecialsForm.setTxtAddress2(rs.getString(3));
               RestaurantSpecialsForm.setTxtCity(rs.getString(4));
               RestaurantSpecialsForm.setTxtState(rs.getString(5));
               RestaurantSpecialsForm.setTxtZipcode(rs.getString(6));
               RestaurantSpecialsForm.setTxtRestaurantPhone(rs.getString(7));
               RestaurantSpecialsForm.setTxtWebsite(rs.getString(8));
               RestaurantSpecialsForm.setTxtMenuUrl(rs.getString(9));
               RestaurantSpecialsForm.setTxtEntertainmentUrl(rs.getString(10));
               RestaurantSpecialsForm.setTxtMapUrl(rs.getString(11));
               RestaurantSpecialsForm.setTxtReservationUrl(rs.getString(12));
           }
           
           Calendar currCalendar;
        
           if (RestaurantSpecialsForm.getTxtCurrCalendar() == null) {
             currCalendar = Calendar.getInstance();
             RestaurantSpecialsForm.setTxtCurrCalendar(currCalendar);
           }
           else {
               currCalendar = RestaurantSpecialsForm.getTxtCurrCalendar();
           }
           switch(currCalendar.get(Calendar.MONTH)) {
               case Calendar.JANUARY: RestaurantSpecialsForm.setTxtCalMonth("January"); break;
               case Calendar.FEBRUARY: RestaurantSpecialsForm.setTxtCalMonth("February"); break;
               case Calendar.MARCH: RestaurantSpecialsForm.setTxtCalMonth("March"); break;
               case Calendar.APRIL: RestaurantSpecialsForm.setTxtCalMonth("April"); break;
               case Calendar.MAY: RestaurantSpecialsForm.setTxtCalMonth("May"); break;
               case Calendar.JUNE: RestaurantSpecialsForm.setTxtCalMonth("June"); break;
               case Calendar.JULY: RestaurantSpecialsForm.setTxtCalMonth("July"); break;
               case Calendar.AUGUST: RestaurantSpecialsForm.setTxtCalMonth("August"); break;
               case Calendar.SEPTEMBER: RestaurantSpecialsForm.setTxtCalMonth("September"); break;
               case Calendar.OCTOBER: RestaurantSpecialsForm.setTxtCalMonth("October"); break;
               case Calendar.NOVEMBER: RestaurantSpecialsForm.setTxtCalMonth("November"); break;
               case Calendar.DECEMBER: RestaurantSpecialsForm.setTxtCalMonth("December"); break;
           }
           
           currCalendar.set(Calendar.DAY_OF_MONTH,1);
           
           int weekDayOfFirst = currCalendar.get(Calendar.DAY_OF_WEEK);
           int daysInMonth = currCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
           
           RestaurantSpecialsBean[] restaurantSpecialsList = new RestaurantSpecialsBean[35];           
           int i = 0;
           int j = 0;
           
           for (i=0; i<35; ++i) {
               restaurantSpecialsList[i] = new RestaurantSpecialsBean();
               
               if (i < (weekDayOfFirst - 1) || i >= (weekDayOfFirst - 1 + daysInMonth)) {
                   restaurantSpecialsList[i].setDay_of_month("");
               }
               else {
                   ++j;
                   restaurantSpecialsList[i].setDay_of_month(Integer.toString(j));
               }
           }
           
          int currentMonth =  currCalendar.get(Calendar.MONTH) + 1;
          
          sqlString =  "select a.restaurant_daily_specials_tbl_pk "            +
                             ",a.daily_specials_menu "                         +
                             ",extract(day from a.daily_specials_date_eff) ";
                                  
          sqlString += "from  restaurant_daily_specials_tbl  a "               +
                            ",specials_tbl                   b ";
                            
          sqlString += "where  a.specials_tbl_fk = b.specials_tbl_pk "           +
                        " and  extract(month from a.daily_specials_date_eff) = " +
                          currentMonth                                           +
                        " and  b.specials_name = '"                              +
                          RestaurantSpecialsForm.getHdnSpecialsType() + "'"      +
                        " and  a.restaurant_tbl_fk = " + RestaurantSpecialsForm.getHdnRestaurantTblPk();

          logger.debug(sqlString);
          
          rs = dbcon.executeQuery(sqlString);
          
          while (rs.next()) {
              i = weekDayOfFirst - 2 + Integer.parseInt(rs.getString(3));
              restaurantSpecialsList[i].setRestaurant_daily_specials_tbl_pk(rs.getString(1));
              restaurantSpecialsList[i].setSpecials_menu(rs.getString(2));
              restaurantSpecialsList[i].setDay_of_month(rs.getString(3));
          }
           
          RestaurantSpecialsForm.setRestaurantSpecialsList(restaurantSpecialsList);

          TemplateBean[] templateList = new TemplateBean[7];

          sqlString =  "select count(a.template_specials_tbl_pk) ";
                             
          sqlString += "from  template_specials_tbl a "                        +
                            ",specials_tbl          b "                        +
                            ",template_tbl          c ";
                            
          sqlString += "where  a.specials_tbl_fk = b.specials_tbl_pk "           +
                        " and  a.template_tbl_fk = c.template_tbl_pk "           +
                        " and  b.specials_name = '"                              +
                          RestaurantSpecialsForm.getHdnSpecialsType() + "'"      +
                        " and  a.restaurant_tbl_fk = " + RestaurantSpecialsForm.getHdnRestaurantTblPk();

          logger.debug(sqlString);
          
          rs = dbcon.executeQuery(sqlString);

          int rs_count = 0;
          
          while (rs.next()) {
              rs_count = rs.getInt(1);
          }
          
          if (rs_count == 0) {
              int[] templates = new int[7];
              
              sqlString  = "select a.template_tbl_pk ";
              sqlString += "from   template_tbl  a ";

              rs = dbcon.executeQuery(sqlString);
              
              i = 0;

              while (rs.next()) {
                  templates[i] = rs.getInt(1);
                  ++i;
              }
              
              rc = Operations.AddInitialTemplateSpecials(templates, modifyRequest, RestaurantSpecialsForm, ds);
              if (rc < 0) {
                  actionErrors.add("user",new ActionMessage("errors.restaurant.specials.initial.template.error"));
                  saveErrors(request, actionErrors);
              }
          }
          
          sqlString =  "select a.template_specials_tbl_pk "                    +
                             ",c.template_name "                               +
                             ",a.template_specials_menu "                      +
                             ",c.template_tbl_pk ";
                             
          sqlString += "from  template_specials_tbl a "                        +
                            ",specials_tbl          b "                        +
                            ",template_tbl          c ";
                            
          sqlString += "where  a.specials_tbl_fk = b.specials_tbl_pk "           +
                        " and  a.template_tbl_fk = c.template_tbl_pk "           +
                        " and  b.specials_name = '"                              +
                          RestaurantSpecialsForm.getHdnSpecialsType() + "'"      +
                        " and  a.restaurant_tbl_fk = " + RestaurantSpecialsForm.getHdnRestaurantTblPk();
                        
          sqlString += " order by c.template_tbl_pk ";

          logger.debug(sqlString);
          
          rs = dbcon.executeQuery(sqlString);

          while (rs.next()) {
              i = Integer.parseInt(rs.getString(4)) - 1;
              templateList[i] = new TemplateBean();
              templateList[i].setTemplate_tbl_pk(rs.getString(1));
              templateList[i].setTemplate_specials_name(rs.getString(2));
              templateList[i].setTemplate_specials_menu(rs.getString(3));
          }

          String requestedAction = request.getParameter("Action");
          String param1 = request.getParameter("param1");
          String param2 = request.getParameter("param2");

          if (requestedAction == null || "".equals(requestedAction)) {
          }
          else {
            if (requestedAction.equals("date_edit")) {

              String specialsDateYear = Integer.toString(RestaurantSpecialsForm.getTxtCurrCalendar().get(Calendar.YEAR));
              String specialsDateMonth = String.format("%02d",RestaurantSpecialsForm.getTxtCurrCalendar().get(Calendar.MONTH) + 1);
              String specialsDateDay = String.format("%02d",Integer.parseInt(param1));
              
              if (param2 == null || "".equals(param2)) {
                  currCalendar = RestaurantSpecialsForm.getTxtCurrCalendar();
                  currCalendar.set(Calendar.DAY_OF_MONTH,Integer.parseInt(param1));
                  
                  String dayOfWeek = "";
                  
                  switch(currCalendar.get(Calendar.DAY_OF_WEEK)) {
                      case Calendar.SUNDAY:    dayOfWeek = "Sunday"; break;
                      case Calendar.MONDAY:    dayOfWeek = "Monday"; break;
                      case Calendar.TUESDAY:   dayOfWeek = "Tuesday"; break;
                      case Calendar.WEDNESDAY: dayOfWeek = "Wednesday"; break;
                      case Calendar.THURSDAY:  dayOfWeek = "Thursday"; break;
                      case Calendar.FRIDAY:    dayOfWeek = "Friday"; break;
                      case Calendar.SATURDAY:  dayOfWeek = "Saturday"; break;
                  }
                  
                  sqlString =  "select  a.template_specials_menu "          +
                                 "from  template_specials_tbl a "           +
                                 "     ,template_tbl          b "           +
                                 "     ,specials_tbl          c "           +
                                 "where a.template_tbl_fk  = b.template_tbl_pk "  +
                                   "and a.specials_tbl_fk  = c.specials_tbl_pk "  +
                                   "and a.restaurant_tbl_fk = "                   +
                                   RestaurantSpecialsForm.getHdnRestaurantTblPk() +
                                  " and c.specials_name = '"                      +
                                   RestaurantSpecialsForm.getHdnSpecialsType() + "' " +
                                  " and b.template_name = '" + dayOfWeek + "'";
                                  
                  logger.debug(sqlString);
                  
                  rs = dbcon.executeQuery(sqlString);
                  
                  while (rs.next()) {
                      RestaurantSpecialsForm.setTxtSpecialsMenu(rs.getString(1));
                  }
                  RestaurantSpecialsForm.setTxtSpecialsDate(specialsDateYear + "/" + specialsDateMonth + "/" + specialsDateDay);
                  dbcon.free(rs);
              }
              else {
                  sqlString =  "select  a.daily_specials_menu "          +
                                      ",to_char(a.daily_specials_date_eff, 'YYYY/MM/DD') " +
                                 "from  restaurant_daily_specials_tbl a "   +
                                 "where a.restaurant_daily_specials_tbl_pk = " + param2;
                                  
                  logger.debug(sqlString);
                  
                  rs = dbcon.executeQuery(sqlString);
                  
                  while (rs.next()) {
                      RestaurantSpecialsForm.setTxtSpecialsMenu(rs.getString(1));
                      RestaurantSpecialsForm.setTxtSpecialsDate(rs.getString(2));
                  }
              }
            }
            if (requestedAction.equals("template_edit")) {
              sqlString =  "select  a.template_specials_menu "          +
                                  ",a.template_tbl_fk "                 +
                                  ",c.template_name "                   +
                             "from  template_specials_tbl a "           +
                             "     ,template_tbl          c "           +
                             "where a.restaurant_tbl_fk = "                   +
                               RestaurantSpecialsForm.getHdnRestaurantTblPk() +
                              " and a.template_tbl_fk  = c.template_tbl_pk "  +
                              " and a.template_specials_tbl_pk = " + param1;
                              
              logger.debug(sqlString);
              
              rs = dbcon.executeQuery(sqlString);
              
              while (rs.next()) {
                  RestaurantSpecialsForm.setTxtSpecialsMenu(rs.getString(1));
                  RestaurantSpecialsForm.setCboTemplateTblPk(rs.getString(3));
              }
            }
          } 
          dbcon.free(rs);

          RestaurantSpecialsForm.setTemplateList(templateList);
          
          String txtFormattedSpecialsMenu = Operations.text2html(RestaurantSpecialsForm.getTxtSpecialsMenu());
          RestaurantSpecialsForm.setTxtFormattedSpecialsMenu(txtFormattedSpecialsMenu);

          request.setAttribute("RestaurantSpecialsForm",RestaurantSpecialsForm);
      } catch (Exception e) {
        logger.error(e.toString());
      } finally {
         logger.debug("Exit");
      }
      return mapping.findForward("success");
    }
}
