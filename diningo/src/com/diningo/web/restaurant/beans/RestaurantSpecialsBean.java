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
 * $Id: RestaurantSpecialsBean.java,v 1.3 2007/04/24 19:10:43 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.beans;

import com.diningo.web.general.beans.DNGConstants;

import org.apache.log4j.Logger;

/**
 *              Purpose: Bean to contain restaurant specific specials data
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

RestaurantSpecialsBean {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String day_of_month;
    private String specials_menu;
    private String restaurant_daily_specials_tbl_pk;

    public void setDay_of_month(String day_of_month) {
        this.day_of_month = day_of_month;
    }

    public String getDay_of_month() {
        return day_of_month;
    }

    public void setSpecials_menu(String specials_menu) {
        this.specials_menu = specials_menu;
    }

    public String getSpecials_menu() {
        return specials_menu;
    }

    public void setRestaurant_daily_specials_tbl_pk(String restaurant_daily_specials_tbl_pk) {
        this.restaurant_daily_specials_tbl_pk = restaurant_daily_specials_tbl_pk;
    }

    public String getRestaurant_daily_specials_tbl_pk() {
        return restaurant_daily_specials_tbl_pk;
    }
}
