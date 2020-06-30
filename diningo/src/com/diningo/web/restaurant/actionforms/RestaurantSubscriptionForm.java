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
 * $Id: RestaurantSubscriptionForm.java,v 1.1 2007/04/24 19:10:43 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.actionforms;

import org.apache.log4j.Logger;
import org.apache.struts.validator.ValidatorForm;
import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.restaurant.beans.RestaurantSubscriptionBean;

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

RestaurantSubscriptionForm extends ValidatorForm {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String hdnRestaurantTblPk;
    private String txtName;
    private String hdnRestaurantSubscriptionTblPk;
    private String txtFromDate;
    private String txtToDate;
    private String cboSubscription;
    private String txtStateTblFk;
    private String txtSubscriptionFee;

    private String[] selected = {};
    private RestaurantSubscriptionBean[] restaurantSubscriptionList;
    
    private String uri;
    private int row_count;
    private int maxPageItems;

    public void setHdnRestaurantTblPk(String hdnRestaurantTblPk) {
        this.hdnRestaurantTblPk = hdnRestaurantTblPk;
    }

    public String getHdnRestaurantTblPk() {
        return hdnRestaurantTblPk;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtFromDate(String txtFromDate) {
        this.txtFromDate = txtFromDate;
    }

    public String getTxtFromDate() {
        return txtFromDate;
    }

    public void setTxtToDate(String txtToDate) {
        this.txtToDate = txtToDate;
    }

    public String getTxtToDate() {
        return txtToDate;
    }

    public void setCboSubscription(String cboSubscription) {
        this.cboSubscription = cboSubscription;
    }

    public String getCboSubscription() {
        return cboSubscription;
    }

    public void setTxtStateTblFk(String txtStateTblFk) {
        this.txtStateTblFk = txtStateTblFk;
    }

    public String getTxtStateTblFk() {
        return txtStateTblFk;
    }

    public void setTxtSubscriptionFee(String txtSubscriptionFee) {
        this.txtSubscriptionFee = txtSubscriptionFee;
    }

    public String getTxtSubscriptionFee() {
        return txtSubscriptionFee;
    }

    public void setSelected(String[] selected) {
        this.selected = selected;
    }

    public String[] getSelected() {
        return selected;
    }

    public void setRestaurantSubscriptionList(RestaurantSubscriptionBean[] restaurantSubscriptionList) {
        this.restaurantSubscriptionList = restaurantSubscriptionList;
    }

    public RestaurantSubscriptionBean[] getRestaurantSubscriptionList() {
        return restaurantSubscriptionList;
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

    public void setHdnRestaurantSubscriptionTblPk(String hdnRestaurantSubscriptionTblPk) {
        this.hdnRestaurantSubscriptionTblPk = hdnRestaurantSubscriptionTblPk;
    }

    public String getHdnRestaurantSubscriptionTblPk() {
        return hdnRestaurantSubscriptionTblPk;
    }
}
