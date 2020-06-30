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
 * $Id: MetroBean.java,v 1.1 2008/01/22 22:02:51 manish Exp $
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
 *              Purpose: 
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 21-03-2007
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

MetroBean {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private Metro[] metros;

    public MetroBean(String jdbcDS) {
        ResultSet rs = null;
        String sqlString = null;
        
        try {
             logger.debug("Enter Constructor");
             
             logger.debug("jdbs-DS:" + jdbcDS);
            
             Context ctx = new javax.naming.InitialContext();
             DataSource ds = (DataSource)ctx.lookup(jdbcDS);
            
             DBConnection dbcon = new DBConnection(ds);

             sqlString = "select   a.metro_area_tbl_pk "                              +
                                 ",a.metro_area_name "                                +
                         "from    metro_area_tbl      a ";
                 
             rs = dbcon.executeQuery(sqlString,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
             
             rs.last();
             int rs_count = rs.getRow();
             rs.beforeFirst();

             metros  = new Metro[rs_count];
            
             int i = 0;           
             while (rs.next()) {
                 metros[i] = new Metro();
                 metros[i].setMetro_area_tbl_pk(rs.getString(1));
                 metros[i].setMetro_area_name(rs.getString(2));
                
                 ++i;
             }
            
             dbcon.free(rs);
        } catch (Exception e) {
          logger.error(e.toString());
        } finally {
           logger.debug("Exit Constructor");
        }
    }

    public void setMetros(Metro[] metros) {
        this.metros = metros;
    }

    public Metro[] getMetros() {
        return metros;
    }
}

