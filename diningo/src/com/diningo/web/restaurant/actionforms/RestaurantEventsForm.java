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
 * $Id: RestaurantEventsForm.java,v 1.1 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.actionforms;

import org.apache.log4j.Logger;
import org.apache.struts.validator.ValidatorForm;
import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.restaurant.beans.RestaurantEventsBean;


/**
 *              Purpose: To store and display coupon information in restaurant_events.jsp
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 13-08-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

RestaurantEventsForm extends ValidatorForm {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String hdnRestaurantTblPk;
    
    private String txtRestaurantName;
    private String txtAddress1;
    private String txtAddress2;
    private String txtCity;
    private String txtState;
    private String txtZipcode;
    private String txtRestaurantPhone;

    private String hdnRestaurantEventsTblPk;
    private String txtEventName;
    private String txtEventDescription;
    private String txtEventEffDate;
    
    private RestaurantEventsBean[] restaurantEventsList;
    private String[] selectedEvents = {};
    
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

    public void setHdnRestaurantEventsTblPk(String hdnRestaurantEventsTblPk) {
        this.hdnRestaurantEventsTblPk = hdnRestaurantEventsTblPk;
    }

    public String getHdnRestaurantEventsTblPk() {
        return hdnRestaurantEventsTblPk;
    }

    public void setTxtEventName(String txtEventName) {
        this.txtEventName = txtEventName;
    }

    public String getTxtEventName() {
        return txtEventName;
    }

    public void setTxtEventDescription(String txtEventDescription) {
        this.txtEventDescription = txtEventDescription;
    }

    public String getTxtEventDescription() {
        return txtEventDescription;
    }

    public void setTxtEventEffDate(String txtEventEffDate) {
        this.txtEventEffDate = txtEventEffDate;
    }

    public String getTxtEventEffDate() {
        return txtEventEffDate;
    }

    public void setRestaurantEventsList(RestaurantEventsBean[] restaurantEventsList) {
        this.restaurantEventsList = restaurantEventsList;
    }

    public RestaurantEventsBean[] getRestaurantEventsList() {
        return restaurantEventsList;
    }

    public void setSelectedEvents(String[] selectedEvents) {
        this.selectedEvents = selectedEvents;
    }

    public String[] getSelectedEvents() {
        return selectedEvents;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}
