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
 * $Id: RestaurantNewEditForm.java,v 1.3 2007/02/26 21:48:46 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.actionforms;

import org.apache.log4j.Logger;
import org.apache.struts.validator.ValidatorForm;
import com.diningo.web.general.beans.DNGConstants;

/**
 *              Purpose: To store and display restaurant information for adding or editing restaurant
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

RestaurantNewEditForm extends ValidatorForm {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String hdnOperType;
    private String txtCharges;
    private String txtRenewalToDate;
    private String txtRenewalFromDate;
    private String txtCurrSubToDate;
    private String txtCurrSubFromDate;
    private String chkSubscription;
    private String txtMapURL;
    private String txtVideoURL;
    private String txtEntertainmentURL;
    private String txtMenuURL;
    private String txtWebsite;
    private String lstEnabledCuisines;
    private String lstAvailableCuisines;
    private String txtEmail4;
    private String txtPhone4;
    private String txtContact4;
    private String txtEmail3;
    private String txtPhone3;
    private String txtContact3;
    private String txtEmail2;
    private String txtPhone2;
    private String txtContact2;
    private String txtEmail1;
    private String txtPhone1;
    private String txtContact1;
    private String txtFax;
    private String txtPhoneNo;
    private String txtZip;
    private String cboState;
    private String txtCity;
    private String txtAddress2;
    private String txtAddress1;
    private String hdnUserTblPK;
    private String txtAgentName;
    private String txtName;

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getTxtAgentName() {
        return txtAgentName;
    }

    public void setTxtAgentName(String txtAgentName) {
        this.txtAgentName = txtAgentName;
    }

    public String getHdnUserTblPK() {
        return hdnUserTblPK;
    }

    public void setHdnUserTblPK(String hdnUserTblPK) {
        this.hdnUserTblPK = hdnUserTblPK;
    }

    public String getTxtAddress1() {
        return txtAddress1;
    }

    public void setTxtAddress1(String txtAddress1) {
        this.txtAddress1 = txtAddress1;
    }

    public String getTxtAddress2() {
        return txtAddress2;
    }

    public void setTxtAddress2(String txtAddress2) {
        this.txtAddress2 = txtAddress2;
    }

    public String getTxtCity() {
        return txtCity;
    }

    public void setTxtCity(String txtCity) {
        this.txtCity = txtCity;
    }

    public String getCboState() {
        return cboState;
    }

    public void setCboState(String cboState) {
        this.cboState = cboState;
    }

    public String getTxtZip() {
        return txtZip;
    }

    public void setTxtZip(String txtZip) {
        this.txtZip = txtZip;
    }

    public String getTxtPhoneNo() {
        return txtPhoneNo;
    }

    public void setTxtPhoneNo(String txtPhoneNo) {
        this.txtPhoneNo = txtPhoneNo;
    }

    public String getTxtFax() {
        return txtFax;
    }

    public void setTxtFax(String txtFax) {
        this.txtFax = txtFax;
    }

    public String getTxtContact1() {
        return txtContact1;
    }

    public void setTxtContact1(String txtContact1) {
        this.txtContact1 = txtContact1;
    }

    public String getTxtPhone1() {
        return txtPhone1;
    }

    public void setTxtPhone1(String txtPhone1) {
        this.txtPhone1 = txtPhone1;
    }

    public String getTxtEmail1() {
        return txtEmail1;
    }

    public void setTxtEmail1(String txtEmail1) {
        this.txtEmail1 = txtEmail1;
    }

    public String getTxtContact2() {
        return txtContact2;
    }

    public void setTxtContact2(String txtContact2) {
        this.txtContact2 = txtContact2;
    }



    public String getTxtEmail2() {
        return txtEmail2;
    }

    public void setTxtEmail2(String txtEmail2) {
        this.txtEmail2 = txtEmail2;
    }

    public String getTxtContact3() {
        return txtContact3;
    }

    public void setTxtContact3(String txtContact3) {
        this.txtContact3 = txtContact3;
    }

    public String getTxtPhone2() {
        return txtPhone2;
    }

    public void setTxtPhone2(String txtPhone2) {
        this.txtPhone2 = txtPhone2;
    }

    public String getTxtPhone3() {
        return txtPhone3;
    }

    public void setTxtPhone3(String txtPhone3) {
        this.txtPhone3 = txtPhone3;
    }

    public String getTxtEmail3() {
        return txtEmail3;
    }

    public void setTxtEmail3(String txtEmail3) {
        this.txtEmail3 = txtEmail3;
    }

    public String getTxtContact4() {
        return txtContact4;
    }

    public void setTxtContact4(String txtContact4) {
        this.txtContact4 = txtContact4;
    }

    public String getTxtPhone4() {
        return txtPhone4;
    }

    public void setTxtPhone4(String txtPhone4) {
        this.txtPhone4 = txtPhone4;
    }

    public String getTxtEmail4() {
        return txtEmail4;
    }

    public void setTxtEmail4(String txtEmail4) {
        this.txtEmail4 = txtEmail4;
    }

    public String getLstAvailableCuisines() {
        return lstAvailableCuisines;
    }

    public void setLstAvailableCuisines(String lstAvailableCuisines) {
        this.lstAvailableCuisines = lstAvailableCuisines;
    }

    public String getLstEnabledCuisines() {
        return lstEnabledCuisines;
    }

    public void setLstEnabledCuisines(String lstEnabledCuisines) {
        this.lstEnabledCuisines = lstEnabledCuisines;
    }

    public String getTxtWebsite() {
        return txtWebsite;
    }

    public void setTxtWebsite(String txtWebsite) {
        this.txtWebsite = txtWebsite;
    }

    public String getTxtMenuURL() {
        return txtMenuURL;
    }

    public void setTxtMenuURL(String txtMenuURL) {
        this.txtMenuURL = txtMenuURL;
    }

    public String getTxtEntertainmentURL() {
        return txtEntertainmentURL;
    }

    public void setTxtEntertainmentURL(String txtEntertainmentURL) {
        this.txtEntertainmentURL = txtEntertainmentURL;
    }

    public String getTxtVideoURL() {
        return txtVideoURL;
    }

    public void setTxtVideoURL(String txtVideoURL) {
        this.txtVideoURL = txtVideoURL;
    }

    public String getTxtMapURL() {
        return txtMapURL;
    }

    public void setTxtMapURL(String txtMapURL) {
        this.txtMapURL = txtMapURL;
    }

    public String getChkSubscription() {
        return chkSubscription;
    }

    public void setChkSubscription(String chkSubscription) {
        this.chkSubscription = chkSubscription;
    }

    public String getTxtCurrSubFromDate() {
        return txtCurrSubFromDate;
    }

    public void setTxtCurrSubFromDate(String txtCurrSubFromDate) {
        this.txtCurrSubFromDate = txtCurrSubFromDate;
    }

    public String getTxtCurrSubToDate() {
        return txtCurrSubToDate;
    }

    public void setTxtCurrSubToDate(String txtCurrSubToDate) {
        this.txtCurrSubToDate = txtCurrSubToDate;
    }

    public String getTxtRenewalFromDate() {
        return txtRenewalFromDate;
    }

    public void setTxtRenewalFromDate(String txtRenewalFromDate) {
        this.txtRenewalFromDate = txtRenewalFromDate;
    }

    public String getTxtRenewalToDate() {
        return txtRenewalToDate;
    }

    public void setTxtRenewalToDate(String txtRenewalToDate) {
        this.txtRenewalToDate = txtRenewalToDate;
    }

    public String getTxtCharges() {
        return txtCharges;
    }

    public void setTxtCharges(String txtCharges) {
        this.txtCharges = txtCharges;
    }

    public String getHdnOperType() {
        return hdnOperType;
    }

    public void setHdnOperType(String hdnOperType) {
        this.hdnOperType = hdnOperType;
    }
}
