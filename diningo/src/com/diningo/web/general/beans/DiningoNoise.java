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
 * $Id: DiningoNoise.java,v 1.1 2007/05/29 01:33:00 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.general.beans;

import java.awt.image.BufferedImage;
import java.util.Properties;

import com.google.code.kaptcha.NoiseProducer;

import org.apache.log4j.Logger;

/**
 *
 */
public class DiningoNoise implements NoiseProducer {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());

    private Properties props = null;

    public DiningoNoise(Properties props) {
        logger.debug("Enter DiningoNoise");
    	this.props = props;
        logger.debug("Exit DiningoNoise");    
    }

    public void setProperties(Properties props) {
	this.props = props;
    }

    public void makeNoise(BufferedImage image, float factorOne, float factorTwo, float factorThree, float factorFour) {
        logger.debug("Enter makeNoise");
        logger.debug("Exit makeNoise");    
    }
}
