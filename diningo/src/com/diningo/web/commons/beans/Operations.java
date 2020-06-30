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
 * $Id: Operations.java,v 1.6 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.commons.beans;

import com.diningo.web.commons.actionforms.ExploreDinerForm;
import com.diningo.web.general.beans.DNGConstants;


import java.sql.CallableStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Types;


/**
 *              Purpose: Class to perform common tasks such as composing mails 
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
    
    public static int signup(ExploreDinerForm ExploreDinerForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;
        String birthDate;
        String selectSpecialsList;
        int returnSubscribedEmailsTempTblPK;
        int rc = 0;
  
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_ins_subscribed_emails_temp(?,?,?,?,?,?,?,?)}";
            
            birthDate = ExploreDinerForm.gettxtBirthDateMonth() + ExploreDinerForm.gettxtBirthDateDay();
                
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setString(2,ExploreDinerForm.gettxtName());
            cs.setString(3,ExploreDinerForm.gettxtCity());
            cs.setInt(4,Integer.parseInt(ExploreDinerForm.gettxtcboState()));
            cs.setString(5,ExploreDinerForm.gettxtZipCode());
            cs.setString(6,ExploreDinerForm.gettxtHomeEmail());
            cs.setString(7,ExploreDinerForm.gettxtWorkEmail());
            cs.setString(8,birthDate);        
            
            selectSpecialsList = "";
            for (String selectedSpecial: ExploreDinerForm.getChkSpecials()) {
                if (selectedSpecial == null || "".equals(selectedSpecial)) {
                    
                }
                else {
                    selectSpecialsList += selectedSpecial + ',';
                }
            }
            
            selectSpecialsList = selectSpecialsList.substring(0,selectSpecialsList.length() - 1);
            cs.setString(9,selectSpecialsList);        
            
            cs.execute();
            returnSubscribedEmailsTempTblPK = cs.getInt(1);
            rc = returnSubscribedEmailsTempTblPK;
            
            logger.debug("returnSubscribedEmailsTempTblPK : " + returnSubscribedEmailsTempTblPK);
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
        
        logger.debug("Exit");        
        return(rc);
    }

    public static int confirmSignup(ExploreDinerForm ExploreDinerForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;
        int returnSubscribedEmailsTblPK;
        int rc = 0;
    
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_ins_subscribed_emails(?,?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setString(2,ExploreDinerForm.getHdnSubscribedEmailTempTblPk());
            cs.setString(3,ExploreDinerForm.gettxtWorkEmail());
            
            cs.execute();
            returnSubscribedEmailsTblPK = cs.getInt(1);
            rc = returnSubscribedEmailsTblPK;
            
            logger.debug("returnSubscribedEmailsTblPK : " + returnSubscribedEmailsTblPK);
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
        
        logger.debug("Exit");        
        return(rc);
    }
    
    public static int unsubscribe(ExploreDinerForm ExploreDinerForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;
        int rc = 0;
    
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_opt_out_subscriber(?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setString(2,ExploreDinerForm.gettxtUnsubscribeEmail());
           
            cs.execute();
            rc = cs.getInt(1);
            
            logger.debug("Return Code : " + rc);
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
        
        logger.debug("Exit");        
        return(rc);
    }
    
}
