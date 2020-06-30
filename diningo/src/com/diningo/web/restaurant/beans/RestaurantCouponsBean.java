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
 * $Id: RestaurantCouponsBean.java,v 1.1 2007/04/24 19:10:43 manish Exp $
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
RestaurantCouponsBean {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String restaurant_coupons_tbl_pk;
    private String coupon_name;
    private String coupon_description;
    private String coupon_from_eff_date;
    private String coupon_to_eff_date;

    public void setRestaurant_coupons_tbl_pk(String restaurant_coupons_tbl_pk) {
        this.restaurant_coupons_tbl_pk = restaurant_coupons_tbl_pk;
    }

    public String getRestaurant_coupons_tbl_pk() {
        return restaurant_coupons_tbl_pk;
    }

    public void setCoupon_name(String coupon_name) {
        this.coupon_name = coupon_name;
    }

    public String getCoupon_name() {
        return coupon_name;
    }

    public void setCoupon_description(String coupon_description) {
        this.coupon_description = coupon_description;
    }

    public String getCoupon_description() {
        return coupon_description;
    }

    public void setCoupon_from_eff_date(String coupon_from_eff_date) {
        this.coupon_from_eff_date = coupon_from_eff_date;
    }

    public String getCoupon_from_eff_date() {
        return coupon_from_eff_date;
    }

    public void setCoupon_to_eff_date(String coupon_to_eff_date) {
        this.coupon_to_eff_date = coupon_to_eff_date;
    }

    public String getCoupon_to_eff_date() {
        return coupon_to_eff_date;
    }
}
