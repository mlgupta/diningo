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
 * $Id: State.java,v 1.1 2007/04/24 19:10:43 manish Exp $
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
State {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
      private String state_tbl_pk;
      private String state_name;

    public void setState_tbl_pk(String state_tbl_pk) {
        this.state_tbl_pk = state_tbl_pk;
    }

    public String getState_tbl_pk() {
        return state_tbl_pk;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getState_name() {
        return state_name;
    }
}

