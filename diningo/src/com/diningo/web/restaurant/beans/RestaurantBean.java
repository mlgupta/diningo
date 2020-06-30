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
 * $Id: RestaurantBean.java,v 1.3 2007/04/24 19:10:43 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.beans;

import com.diningo.web.general.beans.DNGConstants;

import org.apache.log4j.Logger;

/**
 *              Purpose: Bean to contain restaurant specific data
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class
RestaurantBean {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String restaurant_tbl_pk;
    private String restaurant_name;
    private String restaurant_phone;
    private String agent_name;
    private String restaurant_city;
    private String restaurant_state;
    
    public void setRestaurant_tbl_pk(String restaurant_tbl_pk) {
        this.restaurant_tbl_pk = restaurant_tbl_pk;
    }

    public String getRestaurant_tbl_pk() {
        return restaurant_tbl_pk;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_phone(String restaurant_phone) {
        this.restaurant_phone = restaurant_phone;
    }

    public String getRestaurant_phone() {
        return restaurant_phone;
    }

    public void setAgent_name(String agent_name) {
        this.agent_name = agent_name;
    }

    public String getAgent_name() {
        return agent_name;
    }

    public void setRestaurant_city(String restaurant_city) {
        this.restaurant_city = restaurant_city;
    }

    public String getRestaurant_city() {
        return restaurant_city;
    }

    public void setRestaurant_state(String restaurant_state) {
        this.restaurant_state = restaurant_state;
    }

    public String getRestaurant_state() {
        return restaurant_state;
    }
}
