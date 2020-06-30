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
 * $Id: DinersEventsListAction.java,v 1.1 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.actions;

import com.diningo.web.general.beans.DBConnection;
import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.restaurant.actionforms.DinersEventsForm;
import com.diningo.web.restaurant.beans.Operations;
import com.diningo.web.restaurant.beans.RestaurantEventsBean;

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
 *              Purpose: To display list of events for a given restaurant to diner
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

DinersEventsListAction extends Action {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    public ActionForward execute(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {
      DinersEventsForm DinersEventsForm=null;
      ServletContext context=null;
      String jdbcDS = null;
      
      ResultSet rs = null;
      String sqlString = null;

      try {
           logger.debug("Enter");
           
           DinersEventsForm = (DinersEventsForm)form;
           context=servlet.getServletContext();
           jdbcDS = (String)context.getAttribute("jdbcDS");
           
           logger.debug("jdbs-DS:" + jdbcDS);
           
           String restaurant_tbl_pk = request.getParameter("restaurant_tbl_pk");
          
           if(restaurant_tbl_pk == null || "".equals(restaurant_tbl_pk)) {
               logger.debug("Restaurant is null or blank");
               return mapping.findForward("failure");
           }
           
           DinersEventsForm.setHdnRestaurantTblPk(restaurant_tbl_pk);

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
                          "and  a.restaurant_tbl_pk = " + DinersEventsForm.getHdnRestaurantTblPk();

           logger.debug(sqlString);
               
           rs = dbcon.executeQuery(sqlString);            
           while (rs.next()) {
               DinersEventsForm.setTxtRestaurantName(rs.getString(1));
               DinersEventsForm.setTxtAddress1(rs.getString(2));
               DinersEventsForm.setTxtAddress2(rs.getString(3));
               DinersEventsForm.setTxtCity(rs.getString(4));
               DinersEventsForm.setTxtState(rs.getString(5));
               DinersEventsForm.setTxtZipcode(rs.getString(6));
               DinersEventsForm.setTxtRestaurantPhone(rs.getString(7));
           }
          
           sqlString =  "select a.restaurant_events_tbl_pk "
                     +        ",a.event_name "
                     +        ",a.event_description "
                     +        ",a.event_eff_date ";
                                  
           sqlString += "from  restaurant_events_tbl  a ";
                            
           sqlString += "where  a.restaurant_tbl_fk = " 
                     +   DinersEventsForm.getHdnRestaurantTblPk()
                     +  "  and  a.event_eff_date >= CURRENT_DATE ";
                     
          sqlString += "order by a.event_eff_date ";

           logger.debug(sqlString);
               
           rs = dbcon.executeQuery(sqlString,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
               
           rs.last();
           int rs_count = rs.getRow();
           rs.beforeFirst();

           RestaurantEventsBean[] eventBean = new RestaurantEventsBean[rs_count];
           
           int i = 0;           
           String formattedEventDescription;
           
           while (rs.next()) {
              eventBean[i] = new RestaurantEventsBean();
              eventBean[i].setRestaurant_events_tbl_pk(rs.getString(1));
              eventBean[i].setEvent_name(rs.getString(2));
              formattedEventDescription = Operations.text2html(rs.getString(3));
              eventBean[i].setEvent_description(formattedEventDescription);
              eventBean[i].setEvent_eff_date(rs.getString(4));
               
              ++i;
           }
               
           DinersEventsForm.setEventBean(eventBean);

           dbcon.free(rs);
           request.setAttribute("DinersEventsForm", DinersEventsForm);
      } catch (Exception e) {
        logger.error(e.toString());
      } finally {
         logger.debug("Exit");
      }
      return mapping.findForward("success");          
    }
}
