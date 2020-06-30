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
 * $Id: ReviewDinersForm.java,v 1.3 2007/02/26 21:48:46 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.reports.actionforms;

import com.diningo.web.general.beans.DNGConstants;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


/**
 *              Purpose: To display potential diner information for admin to commit to db
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

ReviewDinersForm extends ActionForm {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    private String chkSunscribedEmailsTemptblPk;

    public String getChkSunscribedEmailsTemptblPk() {
        return chkSunscribedEmailsTemptblPk;
    }

    public void setChkSunscribedEmailsTemptblPk(String chkSunscribedEmailsTemptblPk) {
        this.chkSunscribedEmailsTemptblPk = chkSunscribedEmailsTemptblPk;
    }
    public void reset(ActionMapping mapping, HttpServletRequest request) {
            this.chkSunscribedEmailsTemptblPk = null;
    }        
}
