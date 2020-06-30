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
 * $Id: ExploreOwnerForm.java,v 1.5 2007/05/29 01:33:00 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.commons.actionforms;

import org.apache.log4j.Logger;
import org.apache.struts.validator.ValidatorForm;
import com.diningo.web.general.beans.DNGConstants;

/**
 *              Purpose: To carry field specific information from explore_owner.jsp.
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 02-21-2007
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class
ExploreOwnerForm extends ValidatorForm {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String txtName;
    private String txtEmailId;
    private String txtRestaurantName;
    private String txtCity;
    private String cboState;
    private String txtZipCode;
    private String txtPhone;
    private String txtCaptchaField;

    public String gettxtName() {
            return (txtName);
    }        
    public void settxtName(String txtName) {
            this.txtName = txtName;
    }        
    public String gettxtEmailId() {
            return (txtEmailId);
    }        
    public void settxtEmailId(String txtEmailId) {
            this.txtEmailId = txtEmailId;
    }        
    public String gettxtRestaurantName() {
            return (txtRestaurantName);
    }        
    public void settxtRestaurantName(String txtRestaurantName) {
            this.txtRestaurantName = txtRestaurantName;
    }        
    public String gettxtCity() {
            return (txtCity);
    }        
    public void settxtCity(String txtCity) {
            this.txtCity = txtCity;
    }        
    public String getcboState() {
            return (cboState);
    }        
    public void setcboState(String cboState) {
            this.cboState = cboState;
    }        
    public String gettxtZipCode() {
            return (txtZipCode);
    }        
    public void settxtZipCode(String txtZipCode) {
            this.txtZipCode = txtZipCode;
    }        
    public String gettxtPhone() {
            return (txtPhone);
    }        
    public void settxtPhone(String txtPhone) {
            this.txtPhone = txtPhone;
    }

    public void setTxtCaptchaField(String txtCaptchaField) {
        this.txtCaptchaField = txtCaptchaField;
    }

    public String getTxtCaptchaField() {
        return txtCaptchaField;
    }
}
