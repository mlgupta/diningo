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
 * $Id: LoginForm.java,v 1.3 2007/05/29 01:33:00 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.loginout.actionforms;

import org.apache.log4j.Logger;
import org.apache.struts.validator.ValidatorForm;
import com.diningo.web.general.beans.DNGConstants;

/**
 *              Purpose: To display and store agent specific information in agent_list.jsp
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

LoginForm extends ValidatorForm {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());

    private String txtPassword;
    private String txtUserId;
    private String txtCaptchaField;

    public void setTxtPassword(String txtPassword) {
        this.txtPassword = txtPassword;
    }

    public String getTxtPassword() {
        return txtPassword;
    }

    public void setTxtUserId(String txtUserId) {
        this.txtUserId = txtUserId;
    }

    public String getTxtUserId() {
        return txtUserId;
    }

    public void setTxtCaptchaField(String txtCaptchaField) {
        this.txtCaptchaField = txtCaptchaField;
    }

    public String getTxtCaptchaField() {
        return txtCaptchaField;
    }
}
