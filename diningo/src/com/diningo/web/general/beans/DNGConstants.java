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
 * $Id: DNGConstants.java,v 1.3 2007/03/05 20:55:02 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.general.beans;

/**
 *	          Purpose: To generate the name for the constants used in program.
 *                   Info: This class has one constructor whaich takes one string argument and initializes the
 *                          constant_name with that value.
 *                @author  Manish Gupta
 *              @version   1.0
 * 	 Date of creation: 24-11-2006
 * 	 Last Modfied by :     
 * 	Last Modfied Date:    
 */
public final class

DNGConstants {

    //Tag Name 
    private final String constant_name;

    //Private Contructor to use in this class only

    private DNGConstants(String constant_name) {
        this.constant_name = constant_name;
    }

    /**
     * Purpose  : To Get the Contant , the toString() method of Object Class is overloaded 
     * @return  : Returns an Contant Name
     */
    public String toString() {
        return this.constant_name;
    }

    public static final DNGConstants LOGGER = new DNGConstants("com.diningo");

}
