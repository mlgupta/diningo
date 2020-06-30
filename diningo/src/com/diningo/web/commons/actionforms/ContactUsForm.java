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
 * $Id: ContactUsForm.java,v 1.4 2007/05/29 01:33:00 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.commons.actionforms;

import org.apache.log4j.Logger;
import org.apache.struts.validator.ValidatorForm;
import com.diningo.web.general.beans.DNGConstants;


/**
 *              Purpose: To carry field specific information from contact_us.jsp.
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

ContactUsForm extends ValidatorForm {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String txtEmailId;
    private String txtSubject;
    private String txtFeedBack;
    private String txtCaptchaField;

    public String gettxtEmailId() {
            return (txtEmailId);
    }        
    public void settxtEmailId(String txtEmailId) {
            this.txtEmailId = txtEmailId;
    }        
    public String gettxtSubject() {
            return (txtSubject);
    }        
    public void settxtSubject(String txtSubject) {
            this.txtSubject = txtSubject;
    }        
    public String gettxtFeedBack() {
            return (txtFeedBack);
    }        
    public void settxtFeedBack(String txtFeedBack) {
            this.txtFeedBack = txtFeedBack;
    }

    public void setTxtCaptchaField(String txtCaptchaField) {
        this.txtCaptchaField = txtCaptchaField;
    }

    public String getTxtCaptchaField() {
        return txtCaptchaField;
    }
}
