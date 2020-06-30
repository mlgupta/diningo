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
 * $Id: SubscriptionExpiryReportForm.java,v 1.3 2007/02/26 21:48:46 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.reports.actionforms;

import org.apache.log4j.Logger;
import org.apache.struts.validator.ValidatorForm;
import com.diningo.web.general.beans.DNGConstants;

/**
 *              Purpose: To display restaurant subscription expiry report
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

SubscriptionExpiryReportForm extends ValidatorForm {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    private String txtNumberofDays;

    public String getTxtNumberofDays() {
        return txtNumberofDays;
    }

    public void setTxtNumberofDays(String txtNumberofDays) {
        this.txtNumberofDays = txtNumberofDays;
    }
}
