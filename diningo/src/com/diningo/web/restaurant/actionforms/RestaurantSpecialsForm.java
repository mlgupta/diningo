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
 * $Id: RestaurantSpecialsForm.java,v 1.6 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.actionforms;

import org.apache.log4j.Logger;
import org.apache.struts.validator.ValidatorForm;
import com.diningo.web.general.beans.DNGConstants;

import com.diningo.web.restaurant.beans.RestaurantSpecialsBean;

import com.diningo.web.restaurant.beans.TemplateBean;

import java.util.Calendar;

/**
 *              Purpose: To store and display restaurant specials information
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

RestaurantSpecialsForm extends ValidatorForm {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String hdnRestaurantTblPk;
    
    private String hdnSpecialsType;

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
    
    private String hdnRestaurantDailySpecialsTblPk;
    private String txtSpecialsDate;
    private String cboTemplateTblPk;
    
    private String txtCalMonth;
    private Calendar txtCurrCalendar;
    
    private RestaurantSpecialsBean[] restaurantSpecialsList;
    private TemplateBean[] templateList;
    
    private String method;

    public void setHdnSpecialsType(String hdnSpecialsType) {
        this.hdnSpecialsType = hdnSpecialsType;
    }

    public String getHdnSpecialsType() {
        return hdnSpecialsType;
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

    public void setHdnRestaurantDailySpecialsTblPk(String hdnRestaurantDailySpecialsTblPk) {
        this.hdnRestaurantDailySpecialsTblPk = hdnRestaurantDailySpecialsTblPk;
    }

    public String getHdnRestaurantDailySpecialsTblPk() {
        return hdnRestaurantDailySpecialsTblPk;
    }

    public void setTxtSpecialsDate(String txtSpecialsDate) {
        this.txtSpecialsDate = txtSpecialsDate;
    }

    public String getTxtSpecialsDate() {
        return txtSpecialsDate;
    }

    public void setCboTemplateTblPk(String cboTemplateTblPk) {
        this.cboTemplateTblPk = cboTemplateTblPk;
    }

    public String getCboTemplateTblPk() {
        return cboTemplateTblPk;
    }

    public void setTxtCurrCalendar(Calendar txtCurrCalendar) {
        this.txtCurrCalendar = txtCurrCalendar;
    }

    public Calendar getTxtCurrCalendar() {
        return txtCurrCalendar;
    }

    public void setRestaurantSpecialsList(RestaurantSpecialsBean[] restaurantSpecialsList) {
        this.restaurantSpecialsList = restaurantSpecialsList;
    }

    public RestaurantSpecialsBean[] getRestaurantSpecialsList() {
        return restaurantSpecialsList;
    }

    public void setTemplateList(TemplateBean[] templateList) {
        this.templateList = templateList;
    }

    public TemplateBean[] getTemplateList() {
        return templateList;
    }

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

    public void setTxtCalMonth(String txtCalMonth) {
        this.txtCalMonth = txtCalMonth;
    }

    public String getTxtCalMonth() {
        return txtCalMonth;
    }

    public void setTxtFormattedSpecialsMenu(String txtFormattedSpecialsMenu) {
        this.txtFormattedSpecialsMenu = txtFormattedSpecialsMenu;
    }

    public String getTxtFormattedSpecialsMenu() {
        return txtFormattedSpecialsMenu;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}
