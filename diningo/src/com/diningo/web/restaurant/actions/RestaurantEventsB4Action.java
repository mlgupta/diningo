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
 * $Id: RestaurantEventsB4Action.java,v 1.1 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.actions;

import com.diningo.web.general.beans.DBConnection;
import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.preferences.beans.PreferenceBean;
import com.diningo.web.restaurant.actionforms.RestaurantEventsForm;


import com.diningo.web.restaurant.beans.Operations;
import com.diningo.web.restaurant.beans.RestaurantEventsBean;

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
 *              Purpose: 
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 13-08-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

RestaurantEventsB4Action extends Action {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    public ActionForward execute(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {
      RestaurantEventsForm RestaurantEventsForm=null;
      ServletContext context=null;
      String jdbcDS = null;
      ResultSet rs = null;
      String sqlString = null;
      PreferenceBean userPreferences;
      String selectedRestaurant;

      try {
           logger.debug("Enter");
           
           RestaurantEventsForm = (RestaurantEventsForm)form;
           context=servlet.getServletContext();
           jdbcDS = (String)context.getAttribute("jdbcDS");
           
           logger.debug("jdbs-DS:" + jdbcDS);

           String resetFlag = request.getParameter("reset");

           if (resetFlag == null || "".equals(resetFlag)) {
           }
           else {
             if ("true".equals(resetFlag)) {
                 logger.debug("Reset Flag set. Resetting FormBean");
                 Operations.resetRestaurantEventsForm(RestaurantEventsForm);
             }
           }
           
           if (RestaurantEventsForm.getHdnRestaurantEventsTblPk() == null || "".equals(RestaurantEventsForm.getHdnRestaurantEventsTblPk())) {
               Operations.resetRestaurantEventsForm(RestaurantEventsForm);
           }

           HttpSession session = request.getSession();
          
           selectedRestaurant = (String)session.getAttribute("selectedRestaurant");
          
           if (selectedRestaurant == null || "".equals(selectedRestaurant)) {
               logger.debug("Restaurant is null or blank");
               return mapping.findForward("failure");
           }

           RestaurantEventsForm.setHdnRestaurantTblPk(selectedRestaurant);
           
           userPreferences = (PreferenceBean)session.getAttribute("userPreferences");
           
           Context ctx = new javax.naming.InitialContext();
           DataSource ds = (DataSource)ctx.lookup(jdbcDS);
           
           DBConnection dbcon = new DBConnection(ds);
           
           sqlString =  "select a.restaurant_name "                           +
                              ",a.address1 "                                  +
                              ",a.address2 "                                  +
                              ",a.city "                                      +
                              ",b.state_name "                                +
                              ",a.zipcode "                                   +
                              ",a.restaurant_phone ";
                                   
           sqlString += "from  restaurant_tbl   a "                           +
                             ",state_tbl        b ";
                             
           sqlString += "where  a.state_tbl_fk = b.state_tbl_pk "             +
                          "and  a.restaurant_tbl_pk = " + RestaurantEventsForm.getHdnRestaurantTblPk();

           logger.debug(sqlString);
          
           rs = dbcon.executeQuery(sqlString);
          
           while (rs.next()) {
               RestaurantEventsForm.setTxtRestaurantName(rs.getString(1));
               RestaurantEventsForm.setTxtAddress1(rs.getString(2));
               RestaurantEventsForm.setTxtAddress2(rs.getString(3));
               RestaurantEventsForm.setTxtCity(rs.getString(4));
               RestaurantEventsForm.setTxtState(rs.getString(5));
               RestaurantEventsForm.setTxtZipcode(rs.getString(6));
               RestaurantEventsForm.setTxtRestaurantPhone(rs.getString(7));
           }
           
          sqlString =  "select a.restaurant_events_tbl_pk "                    +
                             ",a.event_name "                                  +
                             ",event_description "                             +
                             ",event_eff_date ";
                                  
          sqlString += "from  restaurant_events_tbl  a ";
                            
          sqlString += "where  a.restaurant_tbl_fk = " 
                    +    RestaurantEventsForm.getHdnRestaurantTblPk()
                    +  " and event_eff_date >= CURRENT_DATE ";

          logger.debug(sqlString);
          
          rs = dbcon.executeQuery(sqlString,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
          
          rs.last();
          int rs_count = rs.getRow();
          rs.beforeFirst();

          if (rs_count == 0) {
              RestaurantEventsBean[] restaurantEventsList = new RestaurantEventsBean[1];
              String[] selectedEvents = new String[1];
              
              restaurantEventsList[0] = new RestaurantEventsBean();
              restaurantEventsList[0].setRestaurant_events_tbl_pk("0");
              restaurantEventsList[0].setEvent_name("");
              restaurantEventsList[0].setEvent_description("");
              restaurantEventsList[0].setEvent_eff_date("");

              RestaurantEventsForm.setRestaurantEventsList(restaurantEventsList);
              RestaurantEventsForm.setSelectedEvents(selectedEvents);
          }
          else {
              RestaurantEventsBean[] restaurantEventsList = new RestaurantEventsBean[rs_count];
              String[] selectedEvents = new String[rs_count];
              
              int i = 0;
              
              while (rs.next()) {
                  restaurantEventsList[i] = new RestaurantEventsBean();
                  restaurantEventsList[i].setRestaurant_events_tbl_pk(rs.getString(1));
                  restaurantEventsList[i].setEvent_name(rs.getString(2));
                  restaurantEventsList[i].setEvent_description(rs.getString(3));
                  restaurantEventsList[i].setEvent_eff_date(rs.getString(4));
                  
                  ++i;
              }
              RestaurantEventsForm.setRestaurantEventsList(restaurantEventsList);
              RestaurantEventsForm.setSelectedEvents(selectedEvents);
          }

          String RestaurantEventsTblPk = request.getParameter("restaurant_events_tbl_pk");
          
          if (RestaurantEventsTblPk == null || "".equals(RestaurantEventsTblPk)) {
          }
          else {
              sqlString =  "select  a.restaurant_events_tbl_pk "                +
                                  ",a.event_name "                              +
                                  ",a.event_description "                       +
                                  ",to_char(a.event_eff_date, 'YYYY/MM/DD') ";
                                  
              sqlString += "from  restaurant_events_tbl a ";
              
              sqlString += "where a.restaurant_events_tbl_pk  = "              + 
                                       RestaurantEventsTblPk                   +
                            " and a.restaurant_tbl_fk = "                      +
                                       RestaurantEventsForm.getHdnRestaurantTblPk();
                                      
              logger.debug(sqlString);
                      
              rs = dbcon.executeQuery(sqlString);
                      
              while (rs.next()) {
                  RestaurantEventsForm.setHdnRestaurantEventsTblPk(rs.getString(1));
                  RestaurantEventsForm.setTxtEventName(rs.getString(2));
                  RestaurantEventsForm.setTxtEventDescription(rs.getString(3));
                  RestaurantEventsForm.setTxtEventEffDate(rs.getString(4));
              }
          }
          
          dbcon.free(rs);
           
      } catch (Exception e) {
        logger.error(e.toString());
      } finally {
         logger.debug("Exit");
      }
      return mapping.findForward("success");
    }
}
