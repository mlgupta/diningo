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
 * $Id: RestaurantCouponsForm.java,v 1.5 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.actionforms;

import org.apache.log4j.Logger;
import org.apache.struts.validator.ValidatorForm;
import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.restaurant.beans.RestaurantCouponsBean;


/**
 *              Purpose: To store and display coupon information in restaurant_coupons.jsp
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

RestaurantCouponsForm extends ValidatorForm {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String hdnRestaurantTblPk;
    
    private String txtRestaurantName;
    private String txtAddress1;
    private String txtAddress2;
    private String txtCity;
    private String txtState;
    private String txtZipcode;
    private String txtRestaurantPhone;

    private String hdnRestaurantCouponsTblPk;
    private String txtCouponsName;
    private String txtCouponDescription;
    private String txtCouponFromEffDate;
    private String txtCouponToEffDate;
    
    private RestaurantCouponsBean[] restaurantCouponsList;
    private String[] selectedCoupons = {};
    
    private String method;

    public void setHdnRestaurantTblPk(String hdnRestaurantTblPk) {
        this.hdnRestaurantTblPk = hdnRestaurantTblPk;
    }

    public String getHdnRestaurantTblPk() {
        return hdnRestaurantTblPk;
    }

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

    public void setHdnRestaurantCouponsTblPk(String hdnRestaurantCouponsTblPk) {
        this.hdnRestaurantCouponsTblPk = hdnRestaurantCouponsTblPk;
    }

    public String getHdnRestaurantCouponsTblPk() {
        return hdnRestaurantCouponsTblPk;
    }

    public void setTxtCouponsName(String txtCouponsName) {
        this.txtCouponsName = txtCouponsName;
    }

    public String getTxtCouponsName() {
        return txtCouponsName;
    }

    public void setTxtCouponDescription(String txtCouponDescription) {
        this.txtCouponDescription = txtCouponDescription;
    }

    public String getTxtCouponDescription() {
        return txtCouponDescription;
    }

    public void setTxtCouponFromEffDate(String txtCouponFromEffDate) {
        this.txtCouponFromEffDate = txtCouponFromEffDate;
    }

    public String getTxtCouponFromEffDate() {
        return txtCouponFromEffDate;
    }

    public void setTxtCouponToEffDate(String txtCouponToEffDate) {
        this.txtCouponToEffDate = txtCouponToEffDate;
    }

    public String getTxtCouponToEffDate() {
        return txtCouponToEffDate;
    }

    public void setRestaurantCouponsList(RestaurantCouponsBean[] restaurantCouponsList) {
        this.restaurantCouponsList = restaurantCouponsList;
    }

    public RestaurantCouponsBean[] getRestaurantCouponsList() {
        return restaurantCouponsList;
    }

    public void setSelectedCoupons(String[] selectedCoupons) {
        this.selectedCoupons = selectedCoupons;
    }

    public String[] getSelectedCoupons() {
        return selectedCoupons;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}
