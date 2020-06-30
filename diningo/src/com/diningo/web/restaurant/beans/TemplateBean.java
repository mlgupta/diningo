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
 * $Id: TemplateBean.java,v 1.3 2007/04/24 19:10:43 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.beans;

import com.diningo.web.general.beans.DNGConstants;

import org.apache.log4j.Logger;

/**
 *              Purpose: Bean to contain template information for a given restaurant specials
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

TemplateBean {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String template_tbl_pk;
    private String template_specials_name;
    private String template_specials_menu;

    public void setTemplate_tbl_pk(String template_tbl_pk) {
        this.template_tbl_pk = template_tbl_pk;
    }

    public String getTemplate_tbl_pk() {
        return template_tbl_pk;
    }

    public void setTemplate_specials_name(String template_specials_name) {
        this.template_specials_name = template_specials_name;
    }

    public String getTemplate_specials_name() {
        return template_specials_name;
    }

    public void setTemplate_specials_menu(String template_specials_menu) {
        this.template_specials_menu = template_specials_menu;
    }

    public String getTemplate_specials_menu() {
        return template_specials_menu;
    }
}
