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
 * $Id: CategoryBean.java,v 1.3 2007/03/21 02:24:20 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.category.beans;

import com.diningo.web.general.beans.DNGConstants;
import org.apache.log4j.Logger;

/**
 *              Purpose: Bean to display individual category
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

CategoryBean {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String category_tbl_pk;
    private String category_name;
    private String category_description;

    public void setCategory_tbl_pk(String category_tbl_pk) {
        this.category_tbl_pk = category_tbl_pk;
    }

    public String getCategory_tbl_pk() {
        return category_tbl_pk;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_description(String category_description) {
        this.category_description = category_description;
    }

    public String getCategory_description() {
        return category_description;
    }
}
