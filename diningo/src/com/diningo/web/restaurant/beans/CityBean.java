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
 * $Id: CityBean.java,v 1.2 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.beans;

import com.diningo.web.general.beans.DBConnection;
import com.diningo.web.general.beans.DNGConstants;

import java.sql.ResultSet;

import javax.naming.Context;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**
 *              Purpose: Bean to contain coupon specific data for a given restaurant
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

CityBean {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private City[] cities;

    public CityBean(String jdbcDS) {
        ResultSet rs = null;
        String sqlString = null;
        
        try {
             logger.debug("Enter Constructor");
             
             logger.debug("jdbs-DS:" + jdbcDS);
            
             Context ctx = new javax.naming.InitialContext();
             DataSource ds = (DataSource)ctx.lookup(jdbcDS);
            
             DBConnection dbcon = new DBConnection(ds);

             sqlString = "select  distinct a.city "
                       + "from    restaurant_tbl      a "
                       + "order by a.city";
                 
             rs = dbcon.executeQuery(sqlString,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
             
             rs.last();
             int rs_count = rs.getRow();
             rs.beforeFirst();

             cities  = new City[rs_count];
            
             int i = 0;           
             while (rs.next()) {
                 cities[i] = new City();
                 cities[i].setCity(rs.getString(1));
                
                 ++i;
             }
            
             dbcon.free(rs);
        } catch (Exception e) {
          logger.error(e.toString());
        } finally {
           logger.debug("Exit Constructor");
        }
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }

    public City[] getCities() {
        return cities;
    }
}
