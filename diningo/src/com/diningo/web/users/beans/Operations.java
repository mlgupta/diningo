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
 * $Id: Operations.java,v 1.5 2007/05/01 20:29:34 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.users.beans;

import com.diningo.web.general.beans.DNGConstants;

import com.diningo.web.users.actionforms.AgentForm;

import com.diningo.web.users.actionforms.RestaurantUserNewEditForm;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**
 *              Purpose: Class to perform operations for users
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

Operations {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    public static int AddAgent(AgentForm AgentForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter AddAgent");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;
        int returnUserTblPK;
        int rc=0;
    
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_ins_agent_user(?,?,?,?,?,?,?,?,?,?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setString(2,AgentForm.getTxtName());
            cs.setString(3,AgentForm.getTxtUserId());
            cs.setString(4,AgentForm.getTxtPassword());
            cs.setString(5,AgentForm.getTxtEmailAddress());
            cs.setString(6,AgentForm.getTxtPhone());
            cs.setString(7,AgentForm.getTxtAddress1());
            cs.setString(8,AgentForm.getTxtAddress2());
            cs.setString(9,AgentForm.getTxtCity());
            cs.setString(10,AgentForm.getTxtState());
            cs.setString(11,AgentForm.getTxtZip());        
            
            cs.execute();
            returnUserTblPK = cs.getInt(1);
            
            logger.debug("returnUserTblPK : " + returnUserTblPK);
        } catch(SQLException e) {
            e.printStackTrace();
            logger.error("--- SQLException Caught ---");
            while (e != null) {
                logger.error("Message: " + e.getMessage());
                logger.error("SQLState: " + e.getSQLState());
                logger.error("ErrorCode: " + e.getErrorCode());
                e = e.getNextException();
            }
            rc=-1;
        } finally {
            try { cs.close(); } catch(Exception e) { logger.debug("Error in closing cs"); }
            try { conn.close(); } catch(Exception e) { logger.debug("Error in closing conn"); }
        }
        
        logger.debug("Exit AddAgent");        
        return(rc);
    }

    public static int UpdateAgent(AgentForm AgentForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter UpdateAgent");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;
        int returnUserTblPK;
        int rc=0;
    
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_upd_agent_user(?,?,?,?,?,?,?,?,?,?,?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setString(2,AgentForm.getTxtName());
            cs.setString(3,AgentForm.getTxtUserId());
            cs.setString(4,AgentForm.getTxtPassword());
            cs.setString(5,AgentForm.getTxtEmailAddress());
            cs.setString(6,AgentForm.getTxtPhone());
            cs.setString(7,AgentForm.getTxtAddress1());
            cs.setString(8,AgentForm.getTxtAddress2());
            cs.setString(9,AgentForm.getTxtCity());
            cs.setString(10,AgentForm.getTxtState());
            cs.setString(11,AgentForm.getTxtZip());        
            cs.setInt(12,Integer.parseInt(AgentForm.getHdnUserTblPk()));        
            
            cs.execute();
            returnUserTblPK = cs.getInt(1);
            
            logger.debug("returnUserTblPK : " + returnUserTblPK);
        } catch(SQLException e) {
            e.printStackTrace();
            logger.error("--- SQLException Caught ---");
            while (e != null) {
                logger.error("Message: " + e.getMessage());
                logger.error("SQLState: " + e.getSQLState());
                logger.error("ErrorCode: " + e.getErrorCode());
                e = e.getNextException();
            }
            rc = -1;
        } finally {
            try { cs.close(); } catch(Exception e) { logger.debug("Error in closing cs"); }
            try { conn.close(); } catch(Exception e) { logger.debug("Error in closing conn"); }
        }
        
        logger.debug("Exit UpdateAgent");        
        return(rc);
    }
    
    public static int DeleteAgent(AgentForm AgentForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter DeleteAgent");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;
        int returnUserTblPK;
        int rc = 0;
    
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_del_agent_user(?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            
            for (String selectedAgent: AgentForm.getSelectedAgents()) {
                cs.setInt(2,Integer.parseInt(selectedAgent));

                cs.execute();
                returnUserTblPK = cs.getInt(1);
                
                logger.debug("De-activate user_tbl_pk : " + returnUserTblPK);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            logger.error("--- SQLException Caught ---");
            while (e != null) {
                logger.error("Message: " + e.getMessage());
                logger.error("SQLState: " + e.getSQLState());
                logger.error("ErrorCode: " + e.getErrorCode());
                e = e.getNextException();
            }
            rc = -1;
        } finally {
            try { cs.close(); } catch(Exception e) { logger.debug("Error in closing cs"); }
            try { conn.close(); } catch(Exception e) { logger.debug("Error in closing conn"); }
        }
        
        logger.debug("Exit DeleteAgent");        
        return(rc);
    }

    public static void resetAgentForm(AgentForm AgentForm) throws Exception {
        logger.debug("Enter resetAgentForm");
        
        try {
            AgentForm.setHdnUserTblPk("");
            AgentForm.setTxtGroup("");
            AgentForm.setTxtName("");
            AgentForm.setTxtUserId("");
            AgentForm.setTxtPassword("");
            AgentForm.setTxtConfirmPassword("");
            AgentForm.setTxtAddress1("");
            AgentForm.setTxtAddress2("");
            AgentForm.setTxtCity("");
            AgentForm.setTxtState("");
            AgentForm.setTxtZip("");
            AgentForm.setTxtPhone("");
            AgentForm.setTxtEmailAddress("");
        } catch(Exception e) {
            e.printStackTrace();
            logger.error("Message: " + e.getMessage());
        }
        
        logger.debug("Exit resetAgentForm");        
    }

    public static int AddRestaurantUser(RestaurantUserNewEditForm RestaurantUserNewEditForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter AddRestaurantUser");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;
        int returnUserTblPK;
        int rc = 0;
    
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_ins_restaurant_user(?,?,?,?,?,?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setString(2,RestaurantUserNewEditForm.getTxtUserName());
            cs.setString(3,RestaurantUserNewEditForm.getTxtUserId());
            cs.setString(4,RestaurantUserNewEditForm.getTxtPassword());
            cs.setString(5,RestaurantUserNewEditForm.getTxtEmailAddress());
            cs.setString(6,RestaurantUserNewEditForm.getTxtPhoneNo());
            cs.setInt(7,Integer.parseInt(RestaurantUserNewEditForm.getHdnRestaurantTblPk()));
            
            cs.execute();
            returnUserTblPK = cs.getInt(1);
            
            logger.debug("returnUserTblPK : " + returnUserTblPK);
        } catch(SQLException e) {
            e.printStackTrace();
            logger.error("--- SQLException Caught ---");
            while (e != null) {
                logger.error("Message: " + e.getMessage());
                logger.error("SQLState: " + e.getSQLState());
                logger.error("ErrorCode: " + e.getErrorCode());
                e = e.getNextException();
            }
            rc = -1;
        } finally {
            try { cs.close(); } catch(Exception e) { logger.debug("Error in closing cs"); }
            try { conn.close(); } catch(Exception e) { logger.debug("Error in closing conn"); }
        }
        
        logger.debug("Exit AddRestaurantUser");        
        return(rc);
    }

    public static int UpdateRestaurantUser(RestaurantUserNewEditForm RestaurantUserNewEditForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter UpdateRestaurantUser");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;
        int returnUserTblPK;
        int rc = 0;
    
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_upd_restaurant_user(?,?,?,?,?,?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setInt(2,Integer.parseInt(RestaurantUserNewEditForm.getHdnUserTblPk()));
            cs.setString(3,RestaurantUserNewEditForm.getTxtUserName());
            cs.setString(4,RestaurantUserNewEditForm.getTxtUserId());
            cs.setString(5,RestaurantUserNewEditForm.getTxtPassword());
            cs.setString(6,RestaurantUserNewEditForm.getTxtEmailAddress());
            cs.setString(7,RestaurantUserNewEditForm.getTxtPhoneNo());

            
            cs.execute();
            returnUserTblPK = cs.getInt(1);
            
            logger.debug("returnUserTblPK : " + returnUserTblPK);
        } catch(SQLException e) {
            e.printStackTrace();
            logger.error("--- SQLException Caught ---");
            while (e != null) {
                logger.error("Message: " + e.getMessage());
                logger.error("SQLState: " + e.getSQLState());
                logger.error("ErrorCode: " + e.getErrorCode());
                e = e.getNextException();
            }
            rc = -1;
        } finally {
            try { cs.close(); } catch(Exception e) { logger.debug("Error in closing cs"); }
            try { conn.close(); } catch(Exception e) { logger.debug("Error in closing conn"); }
        }
        
        logger.debug("Exit UpdateRestaurantUser");        
        return(rc);
    }
    
    public static int DeleteRestaurantUser(RestaurantUserNewEditForm RestaurantUserNewEditForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter DeleteRestaurantUser");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;
        int returnUserTblPK;
        int rc = 0;
    
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_del_restaurant_user(?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            
            for (String selectedUsert: RestaurantUserNewEditForm.getSelectedUsers()) {
                cs.setInt(2,Integer.parseInt(selectedUsert));

                cs.execute();
                returnUserTblPK = cs.getInt(1);
                
                logger.debug("De-activate user_tbl_pk : " + returnUserTblPK);
                resetRestaurantUserNewEditForm(RestaurantUserNewEditForm);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            logger.error("--- SQLException Caught ---");
            while (e != null) {
                logger.error("Message: " + e.getMessage());
                logger.error("SQLState: " + e.getSQLState());
                logger.error("ErrorCode: " + e.getErrorCode());
                e = e.getNextException();
            }
            rc = -1;
        } finally {
            try { cs.close(); } catch(Exception e) { logger.debug("Error in closing cs"); }
            try { conn.close(); } catch(Exception e) { logger.debug("Error in closing conn"); }
        }
        
        logger.debug("Exit DeleteRestaurantUser");        
        return(rc);
    }
    
    public static void resetRestaurantUserNewEditForm(RestaurantUserNewEditForm RestaurantUserNewEditForm) throws Exception {
        logger.debug("Enter resetRestaurantUserNewEditForm");
        
        try {
            RestaurantUserNewEditForm.setHdnUserTblPk("");
            RestaurantUserNewEditForm.setTxtUserName("");
            RestaurantUserNewEditForm.setTxtUserId("");
            RestaurantUserNewEditForm.setTxtPassword("");
            RestaurantUserNewEditForm.setTxtConfirmPassword("");
            RestaurantUserNewEditForm.setTxtEmailAddress("");
            RestaurantUserNewEditForm.setTxtPhoneNo("");
        } catch(Exception e) {
            e.printStackTrace();
            logger.error("Message: " + e.getMessage());
        }
        
        logger.debug("Exit resetRestaurantUserNewEditForm");        
    }

}
