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
 * $Id: LoginAction.java,v 1.8 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.loginout.actions;

import com.diningo.web.general.beans.DBConnection;
import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.loginout.actionforms.LoginForm;

import com.diningo.web.loginout.beans.User;
import com.diningo.web.preferences.beans.PreferenceBean;
import com.diningo.web.restaurant.beans.AgentBean;
import com.diningo.web.restaurant.beans.CityBean;
import com.diningo.web.restaurant.beans.CuisineBean;

import com.diningo.web.restaurant.beans.MetroBean;
import com.diningo.web.restaurant.beans.SpecialsBean;

//import com.google.code.kaptcha.Constants;

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
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


/**
 *              Purpose: To validate user credentials
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

LoginAction extends Action {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    public ActionForward execute(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {

      LoginForm LoginForm=null;
      ServletContext context=null;
      String jdbcDS = null;
      ResultSet rs = null;
      String sqlString = null;
      int rc = 0;

      try {
           logger.debug("Enter");
           
           LoginForm=(LoginForm)form;
           context=servlet.getServletContext();
           jdbcDS = (String)context.getAttribute("jdbcDS");
           
           String username = LoginForm.getTxtUserId();
           String password = LoginForm.getTxtPassword();
           
           ActionErrors actionErrors = new ActionErrors();
           HttpSession session = request.getSession();
/*
           String sessionCaptchaField = (String)session.getAttribute(Constants.CAPCHA_SESSION_KEY);
           String txtCaptchaField = LoginForm.getTxtCaptchaField();

           if (sessionCaptchaField.equals(txtCaptchaField)) {
*/           
             Context ctx = new javax.naming.InitialContext();
             DataSource ds = (DataSource)ctx.lookup(jdbcDS);
          
             DBConnection dbcon = new DBConnection(ds);
           
             sqlString  = "select a.user_id "                            +
                                ",a.password "                           +
                                ",b.user_category_name "                 +
                                ",c.records_per_page "                   +
                                ",a.restaurant_tbl_fk "                  +
                                ",a.user_tbl_pk ";
             sqlString += "from user_tbl            a "                  +
                              ",user_category_tbl   b "                  +
                              ",user_preferences_tbl c ";
             sqlString += "where a.user_category_tbl_fk = b.user_category_tbl_pk " +
                            "and a.user_tbl_pk = c.user_tbl_fk "         +
                            "and a.user_id = '" + username + "' "        +
                            "and a.date_eff <= CURRENT_DATE "            +
                            "and a.date_inac > CURRENT_DATE ";

             logger.debug(sqlString);
           
             rs = dbcon.executeQuery(sqlString);            
          
             String upwd = "";
             String[] role = new String[1];
             String recordsPerPage = "";
             int restaurantTblFk = 0;
             int userTblPk  = 0;
           
             if (!rs.next()) {
                 actionErrors.add("user",new ActionMessage("errors.user.password.mismatch"));
                 saveErrors(request, actionErrors);
                 dbcon.free(rs);                      
                 return mapping.findForward("failure");
             }

             upwd = rs.getString(2);
             role[0] = rs.getString(3);
             recordsPerPage = rs.getString(4);
             restaurantTblFk = rs.getInt(5);
             userTblPk = rs.getInt(6);
          
             dbcon.free(rs);                      

             User user = new User(username, upwd, role);
           
             if (!user.passwordMatch(password)) {
                 actionErrors.add("user",new ActionMessage("errors.user.password.mismatch"));
                 saveErrors(request, actionErrors);
                 return mapping.findForward("failure");
             }
           
             CuisineBean cuisineBean = new CuisineBean(jdbcDS);
             CityBean cityBean = new CityBean(jdbcDS);
             SpecialsBean specialsBean = new SpecialsBean(jdbcDS);
             AgentBean agentBean = new AgentBean(jdbcDS);
             PreferenceBean userPreferences = new PreferenceBean(jdbcDS);
             MetroBean metroBean = new MetroBean(jdbcDS);
           
             userPreferences.setMaxPageItems(recordsPerPage);
             userPreferences.setUserId(userTblPk);

             if (user.isAdmin()) {
                 userPreferences.setUserType("ADMIN");
                 userPreferences.setUserTypeAdmin(true);
                 userPreferences.setUserTypeAgent(false);
                 userPreferences.setUserTypeOwner(false);
             }
           
             if(user.isAgent()) {
                 userPreferences.setUserType("AGENT");
                 userPreferences.setUserTypeAdmin(false);
                 userPreferences.setUserTypeAgent(true);
                 userPreferences.setUserTypeOwner(false);
             }
           
             if(user.isOwner()) {
                 userPreferences.setUserType("OWNER");
                 userPreferences.setUserTypeAdmin(false);
                 userPreferences.setUserTypeAgent(false);
                 userPreferences.setUserTypeOwner(true);

                 userPreferences.setRestaurant_tbl_pk(restaurantTblFk);
             }
           
             userPreferences.setSubscribeBreakfast(true);
             userPreferences.setSubscribeLunch(true);
             userPreferences.setSubscribeHH(true);
             userPreferences.setSubscribeDinner(true);

             session.setAttribute("CuisineBean", cuisineBean);
             session.setAttribute("CityBean", cityBean);
             session.setAttribute("SpecialsBean", specialsBean);
             session.setAttribute("userPreferences", userPreferences);
             session.setAttribute("AgentBean", agentBean);
             session.setAttribute("user", user);
             session.setAttribute("metroBean", metroBean);
/*
           }  
          else {
              logger.debug("Entered Captcha value is not equal to session Captcha value");
              logger.debug("Entered Captcha value: " + txtCaptchaField);
              logger.debug("Session Captcha value: " + sessionCaptchaField);
              
              actionErrors.add("user",new ActionMessage("errors.user.captcha.mismatch"));
              saveErrors(request, actionErrors);
              rc = -1;
          }
*/          
      } catch (Exception e) {
        logger.error(e.toString());
      } finally {
         logger.debug("Exit");
      }
        if (rc < 0) {
            return mapping.findForward("failure");
        }
        else {
            return mapping.findForward("success");
        }
    }
}
