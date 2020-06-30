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
 * $Id: PrintCouponForm.java,v 1.4 2007/05/09 21:19:16 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.actionforms;

import com.diningo.web.general.beans.DNGConstants;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;


/**
 *              Purpose: To display individual diner coupon information in print_coupons.jsp
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

PrintCouponForm extends ActionForm {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String hdnRestaurantTblPk;
    private String txtRestaurantName;
    private String txtAddress1;
    private String txtAddress2;
    private String txtCity;
    private String txtState;
    private String txtZipcode;
    private String txtRestaurantPhone;

    private String restaurant_coupons_tbl_pk;
    private String coupon_name;
    private String coupon_description;
    private String coupon_from_eff_date;
    private String coupon_to_eff_date;

    public void setTxtRestaurantName(String txtRestaurantName) {
        this.txtRestaurantName = txtRestaurantName;
    }

    public String getTxtRestaurantName() {
        return txtRestaurantName;
    }

    public void setTxtAddress1(String txtAddress1) {
        this.txtAddress1 = txtAddress1;
    }

    public String getTxtAddress1() {
        return txtAddress1;
    }

    public void setTxtAddress2(String txtAddress2) {
        this.txtAddress2 = txtAddress2;
    }

    public String getTxtAddress2() {
        return txtAddress2;
    }

    public void setTxtCity(String txtCity) {
        this.txtCity = txtCity;
    }

    public String getTxtCity() {
        return txtCity;
    }

    public void setTxtState(String txtState) {
        this.txtState = txtState;
    }

    public String getTxtState() {
        return txtState;
    }

    public void setTxtZipcode(String txtZipcode) {
        this.txtZipcode = txtZipcode;
    }

    public String getTxtZipcode() {
        return txtZipcode;
    }

    public void setTxtRestaurantPhone(String txtRestaurantPhone) {
        this.txtRestaurantPhone = txtRestaurantPhone;
    }

    public String getTxtRestaurantPhone() {
        return txtRestaurantPhone;
    }

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

    public void setHdnRestaurantTblPk(String hdnRestaurantTblPk) {
        this.hdnRestaurantTblPk = hdnRestaurantTblPk;
    }

    public String getHdnRestaurantTblPk() {
        return hdnRestaurantTblPk;
    }
}
