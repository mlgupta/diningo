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
 * $Id: Metro.java,v 1.1 2008/01/22 22:02:51 manish Exp $
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
Metro {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
      private String metro_area_tbl_pk;
      private String metro_area_name;

    public void setMetro_area_tbl_pk(String metro_area_tbl_pk) {
        this.metro_area_tbl_pk = metro_area_tbl_pk;
    }

    public String getMetro_area_tbl_pk() {
        return metro_area_tbl_pk;
    }

    public void setMetro_area_name(String metro_area_name) {
        this.metro_area_name = metro_area_name;
    }

    public String getMetro_area_name() {
        return metro_area_name;
    }
}

