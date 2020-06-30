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
package com.diningo.web.restaurant.beans;

import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.restaurant.actionforms.RestaurantCouponsForm;
import com.diningo.web.restaurant.actionforms.RestaurantEventsForm;
import com.diningo.web.restaurant.actionforms.RestaurantListForm;

import com.diningo.web.restaurant.actionforms.RestaurantSpecialsForm;
import com.diningo.web.restaurant.actionforms.RestaurantSubscriptionForm;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**
 *              Purpose: Class to perform restaurant specific operations
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
    
    public static int AddRestaurant(RestaurantListForm RestaurantListForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter AddRestaurant");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;
        String selectedCuisineList = "";

        int returnRestaurantTblPK;
        int rc = 0;
    
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_ins_restaurant_information(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setInt(2,Integer.parseInt(RestaurantListForm.getTxtUserTblFk()));
            cs.setString(3,RestaurantListForm.getTxtName());
            cs.setString(4,RestaurantListForm.getTxtAddress1());
            cs.setString(5,RestaurantListForm.getTxtAddress2());
            cs.setString(6,RestaurantListForm.getTxtCity());
            cs.setInt(7,Integer.parseInt(RestaurantListForm.getTxtStateTblFk()));
            cs.setString(8,RestaurantListForm.getTxtZipcode());
            cs.setString(9,RestaurantListForm.getTxtPhoneNo());
            cs.setString(10,RestaurantListForm.getTxtFaxNo());
            cs.setString(11,RestaurantListForm.getTxtWebsite());
            cs.setString(12,RestaurantListForm.getTxtMenuUrl());
            cs.setString(13,RestaurantListForm.getTxtEntertainmentUrl());
            cs.setString(14,RestaurantListForm.getTxtVideoUrl());
            cs.setString(15,RestaurantListForm.getTxtMapUrl());
            cs.setString(16,RestaurantListForm.getTxtContact1_name());
            cs.setString(17,RestaurantListForm.getTxtContact1_phone());
            cs.setString(18,RestaurantListForm.getTxtContact1_email());
            cs.setString(19,RestaurantListForm.getTxtContact2_name());
            cs.setString(20,RestaurantListForm.getTxtContact2_phone());
            cs.setString(21,RestaurantListForm.getTxtContact2_email());
            cs.setString(22,RestaurantListForm.getTxtContact3_name());
            cs.setString(23,RestaurantListForm.getTxtContact3_phone());
            cs.setString(24,RestaurantListForm.getTxtContact3_email());
            cs.setString(25,RestaurantListForm.getTxtContact4_name());
            cs.setString(26,RestaurantListForm.getTxtContact4_phone());
            cs.setString(27,RestaurantListForm.getTxtContact4_email());
            
            selectedCuisineList = "";
            
            for (String selectedCuisine: RestaurantListForm.getSelected_cuisine()) {
                selectedCuisineList += selectedCuisine + ',';
            }
            selectedCuisineList = selectedCuisineList.substring(0,selectedCuisineList.length() - 1);
            
            cs.setString(28,selectedCuisineList);
            cs.setInt(29,Integer.parseInt(RestaurantListForm.getTxtMetroArea()));
            
            cs.execute();
            returnRestaurantTblPK = cs.getInt(1);
            
            logger.debug("returnRestaurantTblPK : " + returnRestaurantTblPK);
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
        
        logger.debug("Exit AddRestaurant");        
        return(rc);
    }

    public static int UpdateRestaurant(RestaurantListForm RestaurantListForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter UpdateRestaurant");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;
        String selectedCuisineList = null;
        int returnRestaurantTblPK;
        int rc = 0;
    
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_upd_restaurant_information(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setInt(2,Integer.parseInt(RestaurantListForm.getHdnRestaurantTblPk()));
            cs.setInt(3,Integer.parseInt(RestaurantListForm.getTxtUserTblFk()));
            cs.setString(4,RestaurantListForm.getTxtName());
            cs.setString(5,RestaurantListForm.getTxtAddress1());
            cs.setString(6,RestaurantListForm.getTxtAddress2());
            cs.setString(7,RestaurantListForm.getTxtCity());
            cs.setInt(8,Integer.parseInt(RestaurantListForm.getTxtStateTblFk()));
            cs.setString(9,RestaurantListForm.getTxtZipcode());
            cs.setString(10,RestaurantListForm.getTxtFaxNo());
            cs.setString(11,RestaurantListForm.getTxtPhoneNo());
            cs.setString(12,RestaurantListForm.getTxtWebsite());
            cs.setString(13,RestaurantListForm.getTxtMenuUrl());
            cs.setString(14,RestaurantListForm.getTxtEntertainmentUrl());
            cs.setString(15,RestaurantListForm.getTxtVideoUrl());
            cs.setString(16,RestaurantListForm.getTxtMapUrl());
            cs.setInt(17,Integer.parseInt(RestaurantListForm.getHdnContact1_restaurant_contact_people_tbl_pk()));
            cs.setString(18,RestaurantListForm.getTxtContact1_name());
            cs.setString(19,RestaurantListForm.getTxtContact1_phone());
            cs.setString(20,RestaurantListForm.getTxtContact1_email());
            cs.setInt(21,Integer.parseInt(RestaurantListForm.getHdnContact2_restaurant_contact_people_tbl_pk()));
            cs.setString(22,RestaurantListForm.getTxtContact2_name());
            cs.setString(23,RestaurantListForm.getTxtContact2_phone());
            cs.setString(24,RestaurantListForm.getTxtContact2_email());
            cs.setInt(25,Integer.parseInt(RestaurantListForm.getHdnContact3_restaurant_contact_people_tbl_pk()));
            cs.setString(26,RestaurantListForm.getTxtContact3_name());
            cs.setString(27,RestaurantListForm.getTxtContact3_phone());
            cs.setString(28,RestaurantListForm.getTxtContact3_email());
            cs.setInt(29,Integer.parseInt(RestaurantListForm.getHdnContact4_restaurant_contact_people_tbl_pk()));
            cs.setString(30,RestaurantListForm.getTxtContact4_name());
            cs.setString(31,RestaurantListForm.getTxtContact4_phone());
            cs.setString(32,RestaurantListForm.getTxtContact4_email());
            
            selectedCuisineList = "";
            
            for (String selectedCuisine: RestaurantListForm.getSelected_cuisine()) {
                selectedCuisineList += selectedCuisine + ',';
            }
            
            selectedCuisineList = selectedCuisineList.substring(0,selectedCuisineList.length() - 1);

            cs.setString(33,selectedCuisineList);
            cs.setInt(34,Integer.parseInt(RestaurantListForm.getTxtMetroArea()));
            
            cs.execute();
            returnRestaurantTblPK = cs.getInt(1);
            
            logger.debug("returnRestaurantTblPK : " + returnRestaurantTblPK);
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
        
        logger.debug("Exit UpdateRestaurant");        
        return(rc);
    }
    
    public static int DeleteRestaurant(RestaurantListForm RestaurantListForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter DeleteRestaurant");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;
        int returnRestaurantTblPK;
        int rc = 0;
    
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_del_restaurant_information(?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            
            for (String selectedRestaurant: RestaurantListForm.getSelected()) {
                cs.setInt(2,Integer.parseInt(selectedRestaurant));

                cs.execute();
                returnRestaurantTblPK = cs.getInt(1);
                
                logger.debug("De-activate Restaurant : " + returnRestaurantTblPK);
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
        
        logger.debug("Exit DeleteRestaurant");        
        return(rc);
    }

    public static void resetRestaurantListForm(RestaurantListForm RestaurantListForm) throws Exception {
        logger.debug("Enter resetRestaurantListForm");
        
        try {
            RestaurantListForm.setHdnRestaurantTblPk("");
            RestaurantListForm.setTxtName("");
            RestaurantListForm.setTxtAddress1("");
            RestaurantListForm.setTxtAddress2("");
            RestaurantListForm.setTxtCity("");
            RestaurantListForm.setTxtZipcode("");
            RestaurantListForm.setTxtPhoneNo("");
            RestaurantListForm.setTxtFaxNo("");
            RestaurantListForm.setTxtUserTblFk("");
            RestaurantListForm.setTxtWebsite("");
            RestaurantListForm.setTxtMenuUrl("");
            RestaurantListForm.setTxtEntertainmentUrl("");
            RestaurantListForm.setTxtVideoUrl("");
            RestaurantListForm.setTxtMapUrl("");
            RestaurantListForm.setHdnContact1_restaurant_contact_people_tbl_pk("");
            RestaurantListForm.setTxtContact1_name("");
            RestaurantListForm.setTxtContact1_email("");
            RestaurantListForm.setTxtContact1_phone("");
            RestaurantListForm.setHdnContact2_restaurant_contact_people_tbl_pk("");
            RestaurantListForm.setTxtContact2_name("");
            RestaurantListForm.setTxtContact2_email("");
            RestaurantListForm.setTxtContact2_phone("");
            RestaurantListForm.setHdnContact3_restaurant_contact_people_tbl_pk("");
            RestaurantListForm.setTxtContact3_name("");
            RestaurantListForm.setTxtContact3_email("");
            RestaurantListForm.setTxtContact3_phone("");
            RestaurantListForm.setHdnContact4_restaurant_contact_people_tbl_pk("");
            RestaurantListForm.setTxtContact4_name("");
            RestaurantListForm.setTxtContact4_email("");
            RestaurantListForm.setTxtContact4_phone("");
        } catch(Exception e) {
            e.printStackTrace();
            logger.error("Message: " + e.getMessage());
        }
        
        logger.debug("Exit resetRestaurantListForm");        
    }
    
    public static int UpdateRestaurantContacts(RestaurantListForm RestaurantListForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter UpdateRestaurantContacts");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;
        int returnRestaurantTblPK;
        int rc = 0;
    
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_upd_restaurant_contact_information(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setInt(2,Integer.parseInt(RestaurantListForm.getHdnRestaurantTblPk()));
            cs.setInt(3,Integer.parseInt(RestaurantListForm.getHdnContact1_restaurant_contact_people_tbl_pk()));
            cs.setString(4,RestaurantListForm.getTxtContact1_name());
            cs.setString(5,RestaurantListForm.getTxtContact1_phone());
            cs.setString(6,RestaurantListForm.getTxtContact1_email());
            cs.setInt(7,Integer.parseInt(RestaurantListForm.getHdnContact2_restaurant_contact_people_tbl_pk()));
            cs.setString(8,RestaurantListForm.getTxtContact2_name());
            cs.setString(9,RestaurantListForm.getTxtContact2_phone());
            cs.setString(10,RestaurantListForm.getTxtContact2_email());
            cs.setInt(11,Integer.parseInt(RestaurantListForm.getHdnContact3_restaurant_contact_people_tbl_pk()));
            cs.setString(12,RestaurantListForm.getTxtContact3_name());
            cs.setString(13,RestaurantListForm.getTxtContact3_phone());
            cs.setString(14,RestaurantListForm.getTxtContact3_email());
            cs.setInt(15,Integer.parseInt(RestaurantListForm.getHdnContact4_restaurant_contact_people_tbl_pk()));
            cs.setString(16,RestaurantListForm.getTxtContact4_name());
            cs.setString(17,RestaurantListForm.getTxtContact4_phone());
            cs.setString(18,RestaurantListForm.getTxtContact4_email());
            
            cs.execute();
            returnRestaurantTblPK = cs.getInt(1);
            
            logger.debug("returnRestaurantTblPK : " + returnRestaurantTblPK);
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
        
        logger.debug("Exit UpdateRestaurantContacts");        
        return(rc);
    }

    public static int AddRestaurantSubscription(RestaurantSubscriptionForm RestaurantSubscriptionForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter AddRestaurantSubscription");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;

        int returnRestaurantSubscriptionTblPK;
        int rc = 0;
    
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_ins_restaurant_subscription(?,?,?,?,?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setInt(2,Integer.parseInt(RestaurantSubscriptionForm.getHdnRestaurantTblPk()));
            cs.setString(3,RestaurantSubscriptionForm.getTxtFromDate());
            cs.setString(4,RestaurantSubscriptionForm.getTxtToDate());
            cs.setString(5,RestaurantSubscriptionForm.getTxtSubscriptionFee());
            cs.setInt(6,Integer.parseInt(RestaurantSubscriptionForm.getCboSubscription()));
            
            cs.execute();
            returnRestaurantSubscriptionTblPK = cs.getInt(1);
            
            logger.debug("returnRestaurantSubscriptionTblPK : " + returnRestaurantSubscriptionTblPK);
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
        
        logger.debug("Exit AddRestaurantSubscription");        
        return(rc);
    }

    public static int UpdateRestaurantSubscription(RestaurantSubscriptionForm RestaurantSubscriptionForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter UpdateRestaurantSubscription");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;

        int returnRestaurantSubscriptionTblPK;
        int rc = 0;
        
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_upd_restaurant_subscription(?,?,?,?,?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setInt(2,Integer.parseInt(RestaurantSubscriptionForm.getHdnRestaurantSubscriptionTblPk()));
            cs.setString(3,RestaurantSubscriptionForm.getTxtFromDate());
            cs.setString(4,RestaurantSubscriptionForm.getTxtToDate());
            cs.setString(5,RestaurantSubscriptionForm.getTxtSubscriptionFee());
            cs.setInt(6,Integer.parseInt(RestaurantSubscriptionForm.getCboSubscription()));
            
            cs.execute();
            returnRestaurantSubscriptionTblPK = cs.getInt(1);
            
            logger.debug("returnRestaurantSubscriptionTblPK : " + returnRestaurantSubscriptionTblPK);
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
        
        logger.debug("Exit UpdateRestaurantSubscription");        
        return(rc);
    }
    
    public static int DeleteRestaurantSubscription(RestaurantSubscriptionForm RestaurantSubscriptionForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter DeleteRestaurantSubscription");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;
        int returnRestaurantSubscriptionTblPK;
        int rc = 0;
    
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_del_restaurant_subscription(?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            
            for (String selectedRestaurantSubscription: RestaurantSubscriptionForm.getSelected()) {
                cs.setInt(2,Integer.parseInt(selectedRestaurantSubscription));

                cs.execute();
                returnRestaurantSubscriptionTblPK = cs.getInt(1);
                
                logger.debug("De-activate Subscription : " + returnRestaurantSubscriptionTblPK);
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
        
        logger.debug("Exit DeleteRestaurantSubscription");        
        return(rc);
    }

    public static void resetRestaurantSubscriptionForm(RestaurantSubscriptionForm RestaurantSubscriptionForm) throws Exception {
        logger.debug("Enter resetRestaurantSubscriptionForm");
        
        try {
            RestaurantSubscriptionForm.setHdnRestaurantSubscriptionTblPk("");
            RestaurantSubscriptionForm.setTxtFromDate("");
            RestaurantSubscriptionForm.setTxtToDate("");
            RestaurantSubscriptionForm.setTxtSubscriptionFee("");
        } catch(Exception e) {
            e.printStackTrace();
            logger.error("Message: " + e.getMessage());
        }
        
        logger.debug("Exit resetRestaurantSubscriptionForm");        
    }

    public static int AddInitialTemplateSpecials(int[] templates, 
                                                  String modifyRequest,
                                                  RestaurantSpecialsForm RestaurantSpecialsForm,
                                                  DataSource ds) throws SQLException, Exception {
        logger.debug("Enter AddInitialTemplateSpecials");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;
        
        int returnTemplateSpecialsTblPk;
        int rc = 0;
    
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_ins_initial_template(?,?,?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            
            for (int template: templates) {
                cs.setInt(2,template);
                cs.setString(3,modifyRequest);
                cs.setInt(4,Integer.parseInt(RestaurantSpecialsForm.getHdnRestaurantTblPk()));

                cs.execute();
                returnTemplateSpecialsTblPk = cs.getInt(1);
                
                logger.debug("Added Template : " + returnTemplateSpecialsTblPk);
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
        
        logger.debug("Exit AddInitialTemplateSpecials");        
        return(rc);
    }

    public static int AddRestaurantSpecials(RestaurantSpecialsForm RestaurantSpecialsForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter AddRestaurantSpecials");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;

        int returnRestaurantDailySpecialsTblPk;
        int rc = 0;
    
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_ins_restaurant_specials(?,?,?,?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setInt(2,Integer.parseInt(RestaurantSpecialsForm.getHdnRestaurantTblPk()));
            cs.setString(3,RestaurantSpecialsForm.getHdnSpecialsType());
            cs.setString(4,RestaurantSpecialsForm.getTxtSpecialsMenu());
            cs.setString(5,RestaurantSpecialsForm.getTxtSpecialsDate());
            
            cs.execute();
            returnRestaurantDailySpecialsTblPk = cs.getInt(1);
            
            logger.debug("returnRestaurantDailySpecialsTblPk : " + returnRestaurantDailySpecialsTblPk);
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
        
        logger.debug("Exit AddRestaurantSpecials");        
        return(rc);
    }

    public static int UpdateRestaurantSpecials(RestaurantSpecialsForm RestaurantSpecialsForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter UpdateRestaurantSpecials");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;

        int returnRestaurantDailySpecialsTblPk;
        int rc = 0;
        
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_upd_restaurant_specials(?,?,?,?,?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setInt(2,Integer.parseInt(RestaurantSpecialsForm.getHdnRestaurantDailySpecialsTblPk()));
            cs.setInt(3,Integer.parseInt(RestaurantSpecialsForm.getHdnRestaurantTblPk()));
            cs.setString(4,RestaurantSpecialsForm.getHdnSpecialsType());
            cs.setString(5,RestaurantSpecialsForm.getTxtSpecialsMenu());
            cs.setString(6,RestaurantSpecialsForm.getTxtSpecialsDate());
            
            cs.execute();
            returnRestaurantDailySpecialsTblPk = cs.getInt(1);
            
            logger.debug("returnRestaurantDailySpecialsTblPk : " + returnRestaurantDailySpecialsTblPk);
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
        
        logger.debug("Exit UpdateRestaurantSpecials");        
        return(rc);
    }
    
    public static void resetRestaurantSpecialsForm(RestaurantSpecialsForm RestaurantSpecialsForm) throws Exception {
        logger.debug("Enter resetRestaurantSpecialsForm");
        
        try {
            RestaurantSpecialsForm.setHdnRestaurantDailySpecialsTblPk("");
            RestaurantSpecialsForm.setTxtSpecialsDate("");
            RestaurantSpecialsForm.setTxtSpecialsMenu("");
        } catch(Exception e) {
            e.printStackTrace();
            logger.error("Message: " + e.getMessage());
        }
        
        logger.debug("Exit resetRestaurantSpecialsForm");        
    }

    public static int UpdateSpecialsTemplate(RestaurantSpecialsForm RestaurantSpecialsForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter UpdateSpecialsTemplate");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;

        int returnRestaurantDailySpecialsTblPk;
        int rc = 0;
        
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_upd_restaurant_specials_template(?,?,?,?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setString(2,RestaurantSpecialsForm.getCboTemplateTblPk());
            cs.setInt(3,Integer.parseInt(RestaurantSpecialsForm.getHdnRestaurantTblPk()));
            cs.setString(4,RestaurantSpecialsForm.getHdnSpecialsType());
            cs.setString(5,RestaurantSpecialsForm.getTxtSpecialsMenu());
            
            cs.execute();
            returnRestaurantDailySpecialsTblPk = cs.getInt(1);
            
            logger.debug("returnRestaurantDailySpecialsTblPk : " + returnRestaurantDailySpecialsTblPk);
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
        
        logger.debug("Exit UpdateSpecialsTemplate");        
        return(rc);
    }

    public static int AddRestaurantCoupons(RestaurantCouponsForm RestaurantCouponsForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter AddRestaurantCoupons");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;

        int returnRestaurantCouponsTblPK;
        int rc = 0;
    
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_ins_coupons(?,?,?,?,?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setInt(2,Integer.parseInt(RestaurantCouponsForm.getHdnRestaurantTblPk()));
            cs.setString(3,RestaurantCouponsForm.getTxtCouponsName());
            cs.setString(4,RestaurantCouponsForm.getTxtCouponDescription());
            cs.setString(5,RestaurantCouponsForm.getTxtCouponFromEffDate());
            cs.setString(6,RestaurantCouponsForm.getTxtCouponToEffDate());
            
            cs.execute();
            returnRestaurantCouponsTblPK = cs.getInt(1);
            
            logger.debug("returnRestaurantCouponsTblPK : " + returnRestaurantCouponsTblPK);
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
        
        logger.debug("Exit AddRestaurantCoupons");        
        return(rc);
    }

    public static int UpdateRestaurantCoupons(RestaurantCouponsForm RestaurantCouponsForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter UpdateRestaurantCoupons");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;

        int returnRestaurantCouponsTblPK;
        int rc = 0;
        
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_upd_coupons(?,?,?,?,?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setInt(2,Integer.parseInt(RestaurantCouponsForm.getHdnRestaurantCouponsTblPk()));
            cs.setString(3,RestaurantCouponsForm.getTxtCouponsName());
            cs.setString(4,RestaurantCouponsForm.getTxtCouponDescription());
            cs.setString(5,RestaurantCouponsForm.getTxtCouponFromEffDate());
            cs.setString(6,RestaurantCouponsForm.getTxtCouponToEffDate());

            cs.execute();
            returnRestaurantCouponsTblPK = cs.getInt(1);
            
            logger.debug("returnRestaurantCouponsTblPK : " + returnRestaurantCouponsTblPK);
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
        
        logger.debug("Exit UpdateRestaurantCoupons");        
        return(rc);
    }
    public static int DeleteRestaurantCoupons(RestaurantCouponsForm RestaurantCouponsForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter DeleteRestaurantCoupons");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;
        int returnRestaurantCouponsTblPK;
        int rc = 0;
    
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_del_coupons(?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            
            for (String selectCoupon: RestaurantCouponsForm.getSelectedCoupons()) {
                cs.setInt(2,Integer.parseInt(selectCoupon));

                cs.execute();
                returnRestaurantCouponsTblPK = cs.getInt(1);
                
                logger.debug("Deleted Coupon : " + returnRestaurantCouponsTblPK);
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
        
        logger.debug("Exit DeleteRestaurantCoupons");        
        return(rc);
    }
    
    public static void resetRestaurantCouponsForm(RestaurantCouponsForm RestaurantCouponsForm) throws Exception {
        logger.debug("Enter resetRestaurantCouponsForm");
        
        try {
            RestaurantCouponsForm.setHdnRestaurantCouponsTblPk("");
            RestaurantCouponsForm.setTxtCouponsName("");
            RestaurantCouponsForm.setTxtCouponFromEffDate("");
            RestaurantCouponsForm.setTxtCouponToEffDate("");
            RestaurantCouponsForm.setTxtCouponDescription("");
        } catch(Exception e) {
            e.printStackTrace();
            logger.error("Message: " + e.getMessage());
        }
        
        logger.debug("Exit resetRestaurantCouponsForm");        
    }
    
    public static int AddRestaurantEvents(RestaurantEventsForm RestaurantEventsForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter AddRestaurantEvents");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;

        int returnRestaurantEventsTblPK;
        int rc = 0;
    
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_ins_events(?,?,?,?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setInt(2,Integer.parseInt(RestaurantEventsForm.getHdnRestaurantTblPk()));
            cs.setString(3,RestaurantEventsForm.getTxtEventName());
            cs.setString(4,RestaurantEventsForm.getTxtEventDescription());
            cs.setString(5,RestaurantEventsForm.getTxtEventEffDate());
            
            cs.execute();
            returnRestaurantEventsTblPK = cs.getInt(1);
            
            logger.debug("returnRestaurantEventsTblPK : " + returnRestaurantEventsTblPK);
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
        
        logger.debug("Exit AddRestaurantEvents");        
        return(rc);
    }

    public static int UpdateRestaurantEvents(RestaurantEventsForm RestaurantEventsForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter UpdateRestaurantEvents");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;

        int returnRestaurantEventsTblPK;
        int rc = 0;
        
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_upd_events(?,?,?,?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            cs.setInt(2,Integer.parseInt(RestaurantEventsForm.getHdnRestaurantEventsTblPk()));
            cs.setString(3,RestaurantEventsForm.getTxtEventName());
            cs.setString(4,RestaurantEventsForm.getTxtEventDescription());
            cs.setString(5,RestaurantEventsForm.getTxtEventEffDate());

            cs.execute();
            returnRestaurantEventsTblPK = cs.getInt(1);
            
            logger.debug("returnRestaurantEventsTblPK : " + returnRestaurantEventsTblPK);
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
        
        logger.debug("Exit UpdateRestaurantEvents");        
        return(rc);
    }
    public static int DeleteRestaurantEvents(RestaurantEventsForm RestaurantEventsForm,
                              DataSource ds) throws SQLException, Exception {
        logger.debug("Enter DeleteRestaurantEvents");
        
        Connection conn = null;
        CallableStatement cs= null;
        String sqlString = null;
        int returnRestaurantEventsTblPK;
        int rc = 0;
    
        try {
            conn = ds.getConnection();
            
            sqlString = "{? = call sp_del_events(?)}";
            
            cs = conn.prepareCall(sqlString);
            cs.registerOutParameter(1,Types.INTEGER);
            
            for (String selectEvent: RestaurantEventsForm.getSelectedEvents()) {
                cs.setInt(2,Integer.parseInt(selectEvent));

                cs.execute();
                returnRestaurantEventsTblPK = cs.getInt(1);
                
                logger.debug("Deleted Event : " + returnRestaurantEventsTblPK);
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
        
        logger.debug("Exit DeleteRestaurantEvents");        
        return(rc);
    }

    public static void resetRestaurantEventsForm(RestaurantEventsForm RestaurantEventsForm) throws Exception {
        logger.debug("Enter resetRestaurantEventsForm");
        
        try {
            RestaurantEventsForm.setHdnRestaurantEventsTblPk(null);
            RestaurantEventsForm.setTxtEventName(null);
            RestaurantEventsForm.setTxtEventEffDate(null);
            RestaurantEventsForm.setTxtEventDescription(null);
        } catch(Exception e) {
            e.printStackTrace();
            logger.error("Message: " + e.getMessage());
        }
        
        logger.debug("Exit resetRestaurantEventsForm");        
    }
    
    
    public static String text2html(String txtSpecialsMenu) throws Exception {
        logger.debug("Enter text2html");

        String txtFormattedSpecialsMenu = null;
        try {
            if(txtSpecialsMenu == null || "".equals(txtSpecialsMenu)) {
                
            }
            else {
                Pattern pattern = Pattern.compile("\n");
                Matcher matcher = pattern.matcher(txtSpecialsMenu);
                txtFormattedSpecialsMenu = matcher.replaceAll("<br>\n");
                
                pattern = Pattern.compile(" ");
                matcher = pattern.matcher(txtFormattedSpecialsMenu);
                txtFormattedSpecialsMenu = matcher.replaceAll(" &nbsp;");
            }
        } catch(Exception e) {
            e.printStackTrace();
            logger.error("Message: " + e.getMessage());
        }
        
        logger.debug("Exit text2html"); 
        return(txtFormattedSpecialsMenu);
    }
}
