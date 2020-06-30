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
 * $Id: PreferencesForm.java,v 1.3 2007/02/26 21:48:46 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.preferences.actionforms;

import org.apache.log4j.Logger;
import org.apache.struts.validator.ValidatorForm;
import com.diningo.web.general.beans.DNGConstants;

/**
 *              Purpose: To store and display user preferences
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

PreferencesForm extends ValidatorForm {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    private String txtNumberofRecords;
    private String txtConfirmPassword;
    private String txtPassword;

    public String getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(String txtPassword) {
        this.txtPassword = txtPassword;
    }

    public String getTxtConfirmPassword() {
        return txtConfirmPassword;
    }

    public void setTxtConfirmPassword(String txtConfirmPassword) {
        this.txtConfirmPassword = txtConfirmPassword;
    }

    public String getTxtNumberofRecords() {
        return txtNumberofRecords;
    }

    public void setTxtNumberofRecords(String txtNumberofRecords) {
        this.txtNumberofRecords = txtNumberofRecords;
    }
}
