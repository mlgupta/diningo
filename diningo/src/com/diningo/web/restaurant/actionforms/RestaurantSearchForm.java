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
 * $Id: RestaurantSearchForm.java,v 1.7 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.actionforms;

import org.apache.log4j.Logger;
import org.apache.struts.validator.ValidatorForm;
import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.restaurant.beans.RestaurantSearchBean;

/**
 *              Purpose: To store restaurant search criteria in restaurant_search.jsp
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

RestaurantSearchForm extends ValidatorForm {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String txtName;
    private String cboCuisine;
    private String cboCity;
    private String cboState;
    private String cboZipCode;
    private String cboMeals;
    private boolean chkEntertainment;
    private String txtMetroArea;
    
    private String uri;
    private int row_count;
    private int maxPageItems;

    private RestaurantSearchBean[] restaurantSearchList;
    
    private String userEmailAddress;

    public void setCboCuisine(String cboCuisine) {
        this.cboCuisine = cboCuisine;
    }

    public String getCboCuisine() {
        return cboCuisine;
    }

    public void setCboCity(String cboCity) {
        this.cboCity = cboCity;
    }

    public String getCboCity() {
        return cboCity;
    }

    public void setCboState(String cboState) {
        this.cboState = cboState;
    }

    public String getCboState() {
        return cboState;
    }

    public void setCboZipCode(String cboZipCode) {
        this.cboZipCode = cboZipCode;
    }

    public String getCboZipCode() {
        return cboZipCode;
    }

    public void setCboMeals(String cboMeals) {
        this.cboMeals = cboMeals;
    }

    public String getCboMeals() {
        return cboMeals;
    }

    public void setRestaurantSearchList(RestaurantSearchBean[] restaurantSearchList) {
        this.restaurantSearchList = restaurantSearchList;
    }

    public RestaurantSearchBean[] getRestaurantSearchList() {
        return restaurantSearchList;
    }

    public void setChkEntertainment(boolean chkEntertainment) {
        this.chkEntertainment = chkEntertainment;
    }

    public boolean isChkEntertainment() {
        return chkEntertainment;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    public void setRow_count(int row_count) {
        this.row_count = row_count;
    }

    public int getRow_count() {
        return row_count;
    }

    public void setMaxPageItems(int maxPageItems) {
        this.maxPageItems = maxPageItems;
    }

    public int getMaxPageItems() {
        return maxPageItems;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtMetroArea(String txtMetroArea) {
        this.txtMetroArea = txtMetroArea;
    }

    public String getTxtMetroArea() {
        return txtMetroArea;
    }
}
