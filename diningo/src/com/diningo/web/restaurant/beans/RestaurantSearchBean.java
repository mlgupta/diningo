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
 * $Id: RestaurantSearchBean.java,v 1.2 2007/05/29 01:33:00 manish Exp $
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
RestaurantSearchBean {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String hdnRestaurantTblPk;
    private String txtRestaurantName;
    private String txtAddress1;
    private String txtAddress2;
    private String txtCity;
    private String txtState;
    private String txtZipcode;
    private String txtRestaurantPhone;
    private String txtWebsite;
    private String txtMenuUrl;
    private String txtEntertainmentUrl;
    private String txtMapUrl;
    private String txtReservationUrl;
    private String txtSpecialsMenu;
    private String txtFormattedSpecialsMenu;

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

    public void setTxtWebsite(String txtWebsite) {
        this.txtWebsite = txtWebsite;
    }

    public String getTxtWebsite() {
        return txtWebsite;
    }

    public void setTxtMenuUrl(String txtMenuUrl) {
        this.txtMenuUrl = txtMenuUrl;
    }

    public String getTxtMenuUrl() {
        return txtMenuUrl;
    }

    public void setTxtEntertainmentUrl(String txtEntertainmentUrl) {
        this.txtEntertainmentUrl = txtEntertainmentUrl;
    }

    public String getTxtEntertainmentUrl() {
        return txtEntertainmentUrl;
    }

    public void setTxtMapUrl(String txtMapUrl) {
        this.txtMapUrl = txtMapUrl;
    }

    public String getTxtMapUrl() {
        return txtMapUrl;
    }

    public void setTxtReservationUrl(String txtReservationUrl) {
        this.txtReservationUrl = txtReservationUrl;
    }

    public String getTxtReservationUrl() {
        return txtReservationUrl;
    }

    public void setTxtSpecialsMenu(String txtSpecialsMenu) {
        this.txtSpecialsMenu = txtSpecialsMenu;
    }

    public String getTxtSpecialsMenu() {
        return txtSpecialsMenu;
    }

    public void setTxtFormattedSpecialsMenu(String txtFormattedSpecialsMenu) {
        this.txtFormattedSpecialsMenu = txtFormattedSpecialsMenu;
    }

    public String getTxtFormattedSpecialsMenu() {
        return txtFormattedSpecialsMenu;
    }
}
