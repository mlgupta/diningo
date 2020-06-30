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
 * $Id: AgentBean.java,v 1.2 2007/05/01 20:29:34 manish Exp $
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

AgentBean {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private Agent[] agents;

    public AgentBean(String jdbcDS) {
        ResultSet rs = null;
        String sqlString = null;
        
        try {
             logger.debug("Enter Constructor");
             
             logger.debug("jdbs-DS:" + jdbcDS);
            
             Context ctx = new javax.naming.InitialContext();
             DataSource ds = (DataSource)ctx.lookup(jdbcDS);
            
             DBConnection dbcon = new DBConnection(ds);

             sqlString = "select a.user_tbl_pk "                                  +
                               ",a.user_name "                                    +
                         "from    user_tbl      a "                               +
                                ",user_category_tbl b "                           +
                         "where a.user_category_tbl_fk = b.user_category_tbl_pk " +
                           "and b.user_category_name = 'AGENT'"                   +
                           "and   a.date_eff            <=  CURRENT_DATE "        +
                           "and   a.date_inac            >  CURRENT_DATE "        +
                         "order by a.user_name";

                 
             rs = dbcon.executeQuery(sqlString,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
             
             rs.last();
             int rs_count = rs.getRow();
             rs.beforeFirst();

             agents  = new Agent[rs_count];
            
             int i = 0;           
             while (rs.next()) {
                 agents[i] = new Agent();
                 agents[i].setUser_tbl_pk(rs.getString(1));
                 agents[i].setUser_name(rs.getString(2));
                 
                 ++i;
             }
            
             dbcon.free(rs);
        } catch (Exception e) {
          logger.error(e.toString());
        } finally {
           logger.debug("Exit Constructor");
        }
    }

    public void setAgents(Agent[] agents) {
        this.agents = agents;
    }

    public Agent[] getAgents() {
        return agents;
    }
}
