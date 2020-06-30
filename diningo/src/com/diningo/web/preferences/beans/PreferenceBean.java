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
 * $Id: PreferenceBean.java,v 1.3 2007/04/24 19:10:43 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.preferences.beans;

import com.diningo.web.general.beans.DBConnection;
import com.diningo.web.general.beans.DNGConstants;

import java.sql.ResultSet;

import javax.naming.Context;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**
 *              Purpose: To store user specifc preferences
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

PreferenceBean {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String maxPageItems;
    private String userType;
    private int userId;
    private int restaurant_tbl_pk;
    private boolean userTypeAdmin;
    private boolean userTypeAgent;
    private boolean userTypeOwner;
    private boolean subscribeBreakfast;
    private boolean subscribeLunch;
    private boolean subscribeHH;
    private boolean subscribeDinner;
    
    
    public PreferenceBean(String jdbcDS) {
        ResultSet rs = null;
        String sqlString = null;
        
        try {
             logger.debug("Enter Constructor");
             
             logger.debug("jdbs-DS:" + jdbcDS);
            
             Context ctx = new javax.naming.InitialContext();
             DataSource ds = (DataSource)ctx.lookup(jdbcDS);
            
             DBConnection dbcon = new DBConnection(ds);
/*
             sqlString = "select   a.category_tbl_pk "                              +
                                 ",a.category_name "                                +
                         "from    category_tbl      a ";
                 
             rs = dbcon.executeQuery(sqlString,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
             
             rs.last();
             int rs_count = rs.getRow();
             rs.beforeFirst();

             cuisines  = new Cuisine[rs_count];
            
             int i = 0;           
             while (rs.next()) {
                 cuisines[i] = new Cuisine();
                 cuisines[i].setCategory_tbl_pk(rs.getString(1));
                 cuisines[i].setCategory_name(rs.getString(2));
                
                 ++i;
             }
 */           
             dbcon.free(rs);
        } catch (Exception e) {
          logger.error(e.toString());
        } finally {
           logger.debug("Exit Constructor");
        }
    }

    public void setMaxPageItems(String maxPageItems) {
        this.maxPageItems = maxPageItems;
    }

    public String getMaxPageItems() {
        return maxPageItems;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserTypeAdmin(boolean userTypeAdmin) {
        this.userTypeAdmin = userTypeAdmin;
    }

    public boolean isUserTypeAdmin() {
        return userTypeAdmin;
    }

    public void setUserTypeAgent(boolean userTypeAgent) {
        this.userTypeAgent = userTypeAgent;
    }

    public boolean isUserTypeAgent() {
        return userTypeAgent;
    }

    public void setUserTypeOwner(boolean userTypeOwner) {
        this.userTypeOwner = userTypeOwner;
    }

    public boolean isUserTypeOwner() {
        return userTypeOwner;
    }

    public void setRestaurant_tbl_pk(int restaurant_tbl_pk) {
        this.restaurant_tbl_pk = restaurant_tbl_pk;
    }

    public int getRestaurant_tbl_pk() {
        return restaurant_tbl_pk;
    }

    public void setSubscribeBreakfast(boolean subscribeBreakfast) {
        this.subscribeBreakfast = subscribeBreakfast;
    }

    public boolean isSubscribeBreakfast() {
        return subscribeBreakfast;
    }

    public void setSubscribeLunch(boolean subscribeLunch) {
        this.subscribeLunch = subscribeLunch;
    }

    public boolean isSubscribeLunch() {
        return subscribeLunch;
    }

    public void setSubscribeHH(boolean subscribeHH) {
        this.subscribeHH = subscribeHH;
    }

    public boolean isSubscribeHH() {
        return subscribeHH;
    }

    public void setSubscribeDinner(boolean subscribeDinner) {
        this.subscribeDinner = subscribeDinner;
    }

    public boolean isSubscribeDinner() {
        return subscribeDinner;
    }
}
