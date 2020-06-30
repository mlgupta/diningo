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
 * $Id: RestaurantSelectListForm.java,v 1.2 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.actionforms;

import org.apache.log4j.Logger;
import org.apache.struts.validator.ValidatorForm;
import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.restaurant.beans.RestaurantBean;

/**
 *              Purpose: To store and display list of restaurants
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

RestaurantSelectListForm extends ValidatorForm {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String hdnRestaurantTblPk;
   
    private String txtName;
    private String cboCuisine  = null;
    private String cboCity  = null;
    private String cboState = null;
    private String cboZipCode = null;
    private String cboSubscription = null;
    
    private String requestedAction;
    
    private String selectedRestaurant;
    private RestaurantBean[] restaurantList;
    
    private String uri;
    private int row_count;
    private int maxPageItems;

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

    public void setCboSubscription(String cboSubscription) {
        this.cboSubscription = cboSubscription;
    }

    public String getCboSubscription() {
        return cboSubscription;
    }

    public void setSelectedRestaurant(String selectedRestaurant) {
        this.selectedRestaurant = selectedRestaurant;
    }

    public String getSelectedRestaurant() {
        return selectedRestaurant;
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

    public void setHdnRestaurantTblPk(String hdnRestaurantTblPk) {
        this.hdnRestaurantTblPk = hdnRestaurantTblPk;
    }

    public String getHdnRestaurantTblPk() {
        return hdnRestaurantTblPk;
    }

    public void setRestaurantList(RestaurantBean[] restaurantList) {
        this.restaurantList = restaurantList;
    }

    public RestaurantBean[] getRestaurantList() {
        return restaurantList;
    }

    public void setRequestedAction(String requestedAction) {
        this.requestedAction = requestedAction;
    }

    public String getRequestedAction() {
        return requestedAction;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getTxtName() {
        return txtName;
    }
}
