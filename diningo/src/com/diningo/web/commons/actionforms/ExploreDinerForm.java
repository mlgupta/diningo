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
 * $Id: ExploreDinerForm.java,v 1.6 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.commons.actionforms;

import org.apache.log4j.Logger;
import com.diningo.web.general.beans.DNGConstants;

import org.apache.struts.validator.ValidatorActionForm;

/**
 *              Purpose: To carry field specific information from explore_diner.jsp.
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 02-21-2007
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class
ExploreDinerForm extends ValidatorActionForm {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String hdnSubscribedEmailTempTblPk;
    private String txtName ;
    private String txtCity ;
    private String txtcboState ;
    private String txtZipCode ;
    private String txtWorkEmail ;
    private String txtHomeEmail ;
    private String[] chkSpecials = {};
    private String txtBirthDateDay ;
    private String txtBirthDateMonth ;
    private String txtUnsubscribeEmail ;
    private String txtCaptchaField;
    
    public String gettxtName() {
            return (txtName);
    }        
    public void settxtName(String txtName) {
            this.txtName = txtName;
    }        
    public String gettxtCity() {
            return (txtCity);
    }        
    public void settxtCity(String txtCity) {
            this.txtCity = txtCity;
    }        
    public String gettxtcboState() {
            return (txtcboState);
    }        
    public void settxtcboState(String txtcboState) {
            this.txtcboState = txtcboState;
    }        
    public String gettxtZipCode() {
            return (txtZipCode);
    }        
    public void settxtZipCode(String txtZipCode) {
            this.txtZipCode = txtZipCode;
    }        
    public String gettxtWorkEmail() {
            return (txtWorkEmail);
    }        
    public void settxtWorkEmail(String txtWorkEmail) {
            this.txtWorkEmail = txtWorkEmail;
    }        
    public String gettxtHomeEmail() {
            return (txtHomeEmail);
    }        
    public void settxtHomeEmail(String txtHomeEmail) {
            this.txtHomeEmail = txtHomeEmail;
    }        
    public String gettxtBirthDateDay() {
            return (txtBirthDateDay);
    }        
    public void settxtBirthDateDay(String txtBirthDateDay) {
            this.txtBirthDateDay = txtBirthDateDay;
    }        
    public String gettxtBirthDateMonth() {
            return (txtBirthDateMonth);
    }        
    public void settxtBirthDateMonth(String txtBirthDateMonth) {
            this.txtBirthDateMonth = txtBirthDateMonth;
    }        
    public String gettxtUnsubscribeEmail() {
            return (txtUnsubscribeEmail);
    }        
    public void settxtUnsubscribeEmail(String txtUnsubscribeEmail) {
            this.txtUnsubscribeEmail = txtUnsubscribeEmail;
    }

    public void setChkSpecials(String[] chkSpecials) {
        this.chkSpecials = chkSpecials;
    }

    public String[] getChkSpecials() {
        return chkSpecials;
    }

    public void setTxtCaptchaField(String txtCaptchaField) {
        this.txtCaptchaField = txtCaptchaField;
    }

    public String getTxtCaptchaField() {
        return txtCaptchaField;
    }

    public void setHdnSubscribedEmailTempTblPk(String hdnSubscribedEmailTempTblPk) {
        this.hdnSubscribedEmailTempTblPk = hdnSubscribedEmailTempTblPk;
    }

    public String getHdnSubscribedEmailTempTblPk() {
        return hdnSubscribedEmailTempTblPk;
    }
}
