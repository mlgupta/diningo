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
 * $Id: RestaurantSubscriptionBean.java,v 1.1 2007/04/24 19:10:43 manish Exp $
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
RestaurantSubscriptionBean {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String restaurant_subscription_tbl_pk;
    private String subscription_from;
    private String subscription_to;
    private String subscription_charges;
    private String specials_name;

    public void setRestaurant_subscription_tbl_pk(String restaurant_subscription_tbl_pk) {
        this.restaurant_subscription_tbl_pk = restaurant_subscription_tbl_pk;
    }

    public String getRestaurant_subscription_tbl_pk() {
        return restaurant_subscription_tbl_pk;
    }

    public void setSubscription_from(String subscription_from) {
        this.subscription_from = subscription_from;
    }

    public String getSubscription_from() {
        return subscription_from;
    }

    public void setSubscription_to(String subscription_to) {
        this.subscription_to = subscription_to;
    }

    public String getSubscription_to() {
        return subscription_to;
    }

    public void setSubscription_charges(String subscription_charges) {
        this.subscription_charges = subscription_charges;
    }

    public String getSubscription_charges() {
        return subscription_charges;
    }

    public void setSpecials_name(String specials_name) {
        this.specials_name = specials_name;
    }

    public String getSpecials_name() {
        return specials_name;
    }
}
