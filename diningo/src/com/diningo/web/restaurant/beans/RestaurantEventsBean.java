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
 * $Id: RestaurantEventsBean.java,v 1.1 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.beans;

import com.diningo.web.general.beans.DNGConstants;

import org.apache.log4j.Logger;

/**
 *              Purpose: Bean to contain restaurant events data
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 13-08-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class
RestaurantEventsBean {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String restaurant_events_tbl_pk;
    private String event_name;
    private String event_description;
    private String event_eff_date;

    public void setRestaurant_events_tbl_pk(String restaurant_events_tbl_pk) {
        this.restaurant_events_tbl_pk = restaurant_events_tbl_pk;
    }

    public String getRestaurant_events_tbl_pk() {
        return restaurant_events_tbl_pk;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }

    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_eff_date(String event_eff_date) {
        this.event_eff_date = event_eff_date;
    }

    public String getEvent_eff_date() {
        return event_eff_date;
    }
}
