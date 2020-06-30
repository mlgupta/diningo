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
 * $Id: Operations.java,v 1.5 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.category.beans;

import com.diningo.web.category.actionforms.CategoryForm;
import com.diningo.web.general.beans.DNGConstants;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**
 *              Purpose: Class to perform database operations for category
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
    
    public static int AddCategory(CategoryForm CategoryForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter AddCategory");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;
        int returnCategoryTblPk;
        int rc = 0;
    
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_ins_category(?,?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setString(2,CategoryForm.getTxtCategoryName());
            cs.setString(3,CategoryForm.getTxtCategoryDesc());
            
            cs.execute();
            returnCategoryTblPk = cs.getInt(1);
            
            logger.debug("returnCategoryTblPk : " + returnCategoryTblPk);
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
        
        logger.debug("Exit AddCategory");        
        return(rc);
    }

    public static int UpdateCategory(CategoryForm CategoryForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter UpdateCategory");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;
        int returnCategoryTblPk;
        int rc = 0;
    
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_upd_category(?,?,?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setInt(2,Integer.parseInt(CategoryForm.getHdnCategoryTblPk()));
            cs.setString(3,CategoryForm.getTxtCategoryName());
            cs.setString(4,CategoryForm.getTxtCategoryDesc());
            
            cs.execute();
            returnCategoryTblPk = cs.getInt(1);
            
            logger.debug("returnCategoryTblPk : " + returnCategoryTblPk);
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
        
        logger.debug("Exit UpdateCategory");        
        return(rc);
    }
    
    public static int DeleteCategory(CategoryForm CategoryForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter DeleteCategory");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;
        int returnCategoryTblPk;
        int rc = 0;
    
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_del_category(?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            
            for (String selected: CategoryForm.getSelected()) {
                cs.setInt(2,Integer.parseInt(selected));

                cs.execute();
                returnCategoryTblPk = cs.getInt(1);
                
                logger.debug("Deleted Category : " + returnCategoryTblPk);
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
        
        logger.debug("Exit DeleteCategory");        
        return(rc);
    }
    
    public static void resetCategoryForm(CategoryForm CategoryForm) throws Exception {
        logger.debug("Enter resetCategoryForm");
        
        try {
            CategoryForm.setTxtCategoryName("");
            CategoryForm.setTxtCategoryDesc("");
            CategoryForm.setHdnCategoryTblPk("");
        } catch(Exception e) {
            e.printStackTrace();
            logger.error("Message: " + e.getMessage());
        }
        
        logger.debug("Exit resetCategoryForm");        
    }

}
