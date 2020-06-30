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
 * $Id: DinersEventsForm.java,v 1.1 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.actionforms;

import com.diningo.web.general.beans.DNGConstants;

import com.diningo.web.restaurant.beans.RestaurantEventsBean;

import org.apache.log4j.Logger;
import org.apache.struts.validator.ValidatorForm;


/**
 *              Purpose: To store and display diner events information in diners_events.jsp
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

DinersEventsForm extends ValidatorForm {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String hdnRestaurantTblPk;
    private String txtRestaurantName;
    private String txtAddress1;
    private String txtAddress2;
    private String txtCity;
    private String txtState;
    private String txtZipcode;
    private String txtRestaurantPhone;

    private RestaurantEventsBean[] eventBean;
    
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

    public void setEventBean(RestaurantEventsBean[] eventBean) {
        this.eventBean = eventBean;
    }

    public RestaurantEventsBean[] getEventBean() {
        return eventBean;
    }
}
