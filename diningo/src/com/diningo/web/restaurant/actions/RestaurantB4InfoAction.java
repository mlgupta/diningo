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
 * $Id: RestaurantB4InfoAction.java,v 1.3 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.actions;

import com.diningo.web.general.beans.DBConnection;
import com.diningo.web.general.beans.DNGConstants;

import com.diningo.web.restaurant.actionforms.RestaurantListForm;

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
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

RestaurantB4InfoAction extends Action {
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
      String selectedRestaurant;

      try {
           logger.debug("Enter");
           
           RestaurantListForm = (RestaurantListForm)form;
           context=servlet.getServletContext();
           jdbcDS = (String)context.getAttribute("jdbcDS");
           
           logger.debug("jdbs-DS:" + jdbcDS);
           
           HttpSession session = request.getSession();
           
           selectedRestaurant = (String)session.getAttribute("selectedRestaurant");
           
           if (selectedRestaurant == null || "".equals(selectedRestaurant)) {
               return mapping.findForward("failure");
           }
          
           Context ctx = new javax.naming.InitialContext();
           DataSource ds = (DataSource)ctx.lookup(jdbcDS);
           
           DBConnection dbcon = new DBConnection(ds);

           sqlString   =  "select  a.restaurant_tbl_pk "                       +
                                 ",a.restaurant_name "                         +
                                 ",a.restaurant_phone "                        +
                                 ",a.restaurant_fax "                          +
                                 ",a.website "                                 +
                                 ",a.menu_url "                                +
                                 ",a.entertainment_url"                        +
                                 ",a.video_url "                               +
                                 ",a.map_url "                                 +
                                 ",a.address1 "                                +
                                 ",a.address2 "                                +
                                 ",a.city "                                    +
                                 ",a.zipcode "                                 +
                                 ",a.state_tbl_fk "                            +
                                 ",b.user_name "                               +
                                 ",a.metro_area_tbl_fk ";
           sqlString  +=    "from    restaurant_tbl                  a "       +
                                   ",user_tbl                        b " ;
                                   
           sqlString  += "where   a.user_tbl_fk  = b.user_tbl_pk "             +
                           "and   a.restaurant_tbl_pk = " + selectedRestaurant;
                           
          logger.debug(sqlString);
               
          rs = dbcon.executeQuery(sqlString);
          
          while (rs.next()) {
              RestaurantListForm.setHdnRestaurantTblPk(rs.getString(1));
              RestaurantListForm.setTxtName(rs.getString(2));
              RestaurantListForm.setTxtPhoneNo(rs.getString(3));
              RestaurantListForm.setTxtFaxNo(rs.getString(4));
              RestaurantListForm.setTxtWebsite(rs.getString(5));
              RestaurantListForm.setTxtMenuUrl(rs.getString(6));
              RestaurantListForm.setTxtEntertainmentUrl(rs.getString(7));
              RestaurantListForm.setTxtVideoUrl(rs.getString(8));
              RestaurantListForm.setTxtMapUrl(rs.getString(9));
              RestaurantListForm.setTxtAddress1(rs.getString(10));
              RestaurantListForm.setTxtAddress2(rs.getString(11));
              RestaurantListForm.setTxtCity(rs.getString(12));
              RestaurantListForm.setTxtZipcode(rs.getString(13));
              RestaurantListForm.setTxtStateTblFk(rs.getString(14));
              RestaurantListForm.setTxtUserTblFk(rs.getString(15));
              RestaurantListForm.setTxtMetroArea(rs.getString(16));
          }
               
          sqlString   =  "select  a.restaurant_contact_people_tbl_pk "         +
                                ",a.name "                                     +
                                ",a.email "                                    +
                                ",a.phone ";

          sqlString  +=    "from    restaurant_contact_people_tbl    a ";
                                  
          sqlString  += "where   a.restaurant_tbl_fk = " + selectedRestaurant;

          logger.debug(sqlString);

          rs = dbcon.executeQuery(sqlString);

          String [] contact_tbl_pk = new String[4];
          String [] contact_name = new String[4];
          String [] contact_email = new String[4];
          String [] contact_phone = new String[4];
          
          int i = 0;
          while (rs.next()) {
              contact_tbl_pk[i]  = rs.getString(1);
              contact_name[i]  = rs.getString(2);
              contact_email[i] = rs.getString(3);
              contact_phone[i] = rs.getString(4);
              
              ++i;
          }
          
          RestaurantListForm.setHdnContact1_restaurant_contact_people_tbl_pk(contact_tbl_pk[0]);
          RestaurantListForm.setTxtContact1_name(contact_name[0]);
          RestaurantListForm.setTxtContact1_email(contact_email[0]);
          RestaurantListForm.setTxtContact1_phone(contact_phone[0]);
          
          RestaurantListForm.setHdnContact2_restaurant_contact_people_tbl_pk(contact_tbl_pk[1]);
          RestaurantListForm.setTxtContact2_name(contact_name[1]);
          RestaurantListForm.setTxtContact2_email(contact_email[1]);
          RestaurantListForm.setTxtContact2_phone(contact_phone[1]);

          RestaurantListForm.setHdnContact3_restaurant_contact_people_tbl_pk(contact_tbl_pk[2]);
          RestaurantListForm.setTxtContact3_name(contact_name[2]);
          RestaurantListForm.setTxtContact3_email(contact_email[2]);
          RestaurantListForm.setTxtContact3_phone(contact_phone[2]);

          RestaurantListForm.setHdnContact4_restaurant_contact_people_tbl_pk(contact_tbl_pk[3]);
          RestaurantListForm.setTxtContact4_name(contact_name[3]);
          RestaurantListForm.setTxtContact4_email(contact_email[3]);
          RestaurantListForm.setTxtContact4_phone(contact_phone[3]);
          
          sqlString = "select   a.category_tbl_fk "                              +
                      "from    restaurant_category_tbl a       "                 +
                      "where   a.restaurant_tbl_fk = " + selectedRestaurant;

          logger.debug(sqlString);
          
          rs = dbcon.executeQuery(sqlString,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
          
          rs.last();
          int rs_count = rs.getRow();
          rs.beforeFirst();

          String[] selected_cuisine  = new String[rs_count];
          
          i = 0;           
          while (rs.next()) {
              selected_cuisine[i] = rs.getString(1);
              
              ++i;
          }
          
          RestaurantListForm.setSelected_cuisine(selected_cuisine);

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
