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
 * $Id: Specials.java,v 1.1 2007/04/24 19:10:43 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.beans;

import com.diningo.web.general.beans.DNGConstants;

import org.apache.log4j.Logger;

/**
 *              Purpose: 
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class
Specials {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
      private String specials_tbl_pk;
      private String specials_name;

    public void setSpecials_tbl_pk(String specials_tbl_pk) {
        this.specials_tbl_pk = specials_tbl_pk;
    }

    public String getSpecials_tbl_pk() {
        return specials_tbl_pk;
    }

    public void setSpecials_name(String specials_name) {
        this.specials_name = specials_name;
    }

    public String getSpecials_name() {
        return specials_name;
    }
}

