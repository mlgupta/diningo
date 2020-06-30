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
 * $Id: CSVToTempSubscription.java,v 1.1 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.utils;

import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.general.beans.GeneralUtil;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *              Purpose: To subcribe users from csv file to temp subscription table.
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 11/14/2007
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class
CSVToTempSubscription {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    public CSVToTempSubscription() {
    }
    
    public static void main(String[] args) {
      CSVToTempSubscription CSVToTempSubscription = new CSVToTempSubscription();

      if (args.length != 7) {
          System.err.println("--------------------------------------------------------------------------------------------------------------------");
          System.err.println("Usage: java CSVToTempSubscription <db_user> <db_passwd> <db_url> <log4j-init-file> <smtpHost> <webURL> <CSV File>");
          System.err.println("--------------------------------------------------------------------------------------------------------------------");
          System.exit(1);
      }
     
      int totalEmailAdded = 0;
      int totalEmailRejected = 0;
      
      String dbUser        = args[0];
      String dbPassword    = args[1];
      String dbUrl         = args[2];
      String log4jInitFile = args[3];
      String smtpHost      = args[4];
      String webServer     = args[5];
      String CSVFile       = args[6];

      String recipient=null;
      String subject=null;
      String message=null;
      String from=null;
      String sqlString = null;
      
      String domainName = "diningo.com";
      String subscribeAction = "/DinerSubscribeConfirmAction.do";

      String prefix = System.getProperty("user.dir");
      Connection conn;
      CallableStatement cs;
      CSVReader csvr;
        
      PropertyConfigurator.configure(prefix + "/" + log4jInitFile);
      logger.debug("Log4J Initialized");

      int rc = 0;

      try {
         logger.debug("Enter");
           
         Class.forName("org.postgresql.Driver");

         conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
         logger.debug("Connected to the database");
         
         sqlString = "{? = call sp_ins_subscribed_emails_temp(?,?,?,?,?,?,?,?)}";
         
         cs = conn.prepareCall(sqlString);
         cs.registerOutParameter(1,Types.INTEGER);

         csvr = new CSVReader(new FileReader(prefix + "/" + CSVFile));
         String [] nextLine;
         
         int lineNumber = 0;
         
         String name;
         String city;
         String state;
         String zipCode;
         String email;
         String state_tbl_pk;
         
          while ((nextLine = csvr.readNext()) != null) {
            ++lineNumber;
            rc = 0;
            
            name     = nextLine[0];
            city     = nextLine[1];
            state    = nextLine[2];
            zipCode  = nextLine[3];
            email    = nextLine[4];
            
            state_tbl_pk = CSVToTempSubscription.getStateTblPk(state, conn);
            
            cs.setString(2,name);
            cs.setString(3,city);
            cs.setInt(4,Integer.parseInt(state_tbl_pk));
            cs.setString(5,zipCode);
            cs.setString(6,"");
            cs.setString(7,email);
            cs.setString(8,"");        
            cs.setString(9,"1,2,3,4");        
            
            cs.execute();
            rc = cs.getInt(1);

            if (rc < 0) {
               ++totalEmailRejected;
               logger.error("Line Number:" + lineNumber + " with email address:" + email + " Rejected.");
            }
            else {
                ++totalEmailAdded;
                
                recipient = email;
                from = "Diningo.com <listconfirm+" + rc + "@" + domainName + ">";
                subject = "Request to joing Diningo.com mailing list";
                message = "Greetings, \n\n";
                message += "You (or someone using your email address) just asked to join the ";
                message += "diningo.com mailing list to receive daily chef's specials in your neighborhood ";
                message += "restaurants. Because we practice good email list etiquette, we need ";
                message += "you to confirm that you actually made this request by following ";
                message += "the URL below: \n\n";
                message += "<" + webServer + subscribeAction + "?confirm=" + rc + ">\n\n";
                message += "You can also reply to this message with any content (or none) or send ";
                message += "email to <mailto:listconfirm+" + rc + "@" + domainName + "> to confirm. \n\n" ;
                message += "If you do not respond to this message in any fashion, you will receive ";
                message += "no further email from us. There is no need to opt-out or unsubscribe. ";
                message += "When you do confirm your subscription, you will receive further instructions. \n\n";
                message += "In accordance with the latest legislation, our postal address is: \n";
                message += "DBSentry Corp. \n";
                message += "200 Little Falls St, Suite G201A \n";
                message += "Falls Church, VA - 22046, USA \n";
                message += "";
                  
                logger.debug(message);

                GeneralUtil.postMail(recipient,subject,message,from,smtpHost);
              }
          }  
          
          csvr.close();
          conn.close();
          
          logger.info("-----------------------------------------------------------------------------");
          logger.info("              CSV To Temp Subscription Execution Summary");
          logger.info("");
          logger.info("Records Received:            " + lineNumber);
          logger.info("Records successfully added:  " + totalEmailAdded);
          logger.info("Records Rejected:            " + totalEmailRejected);
          logger.info("-----------------------------------------------------------------------------");

          } catch (ClassNotFoundException e) {
               e.printStackTrace();
               logger.error("--- ClassNotFoundException Caught ---");
          } catch (SQLException e) {
               e.printStackTrace();
               logger.error("--- SQLException Caught ---");
               while (e != null) {
                   logger.error("Message: " + e.getMessage());
                   logger.error("SQLState: " + e.getSQLState());
                   logger.error("ErrorCode: " + e.getErrorCode());
                   e = e.getNextException();
               }    
          } catch (FileNotFoundException e) {
              e.printStackTrace();
              logger.error("--- FileNotFoundException Caught ---");
          } catch (EOFException e) {
              e.printStackTrace();
              logger.error("--- EOFException Caught ---");
          } catch (IOException e) {
              e.printStackTrace();
              logger.error("--- IOException Caught ---");
          } catch (Exception e) {
              e.printStackTrace();
          } finally {
              logger.debug("End");
          }
    }
    
    public static 
        String getStateTblPk(String stateName,Connection conn) throws SQLException, Exception {
            Statement stmt = null;
            String query = null;
            String returnStateTblPk = null;
            ResultSet rs = null;
            
            try {
                stmt = conn.createStatement();
                query = "select state_tbl_pk from state_tbl where state_name ='" +
                       stateName + "'";
                rs = stmt.executeQuery(query);
                
                if (rs.next()) {
                  returnStateTblPk = String.valueOf(rs.getInt("state_tbl_pk"));
                } else {
                   throw new SQLException("State '" + stateName + "' not found.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            } finally {
                if (rs != null) {
                  rs.close();
                }
                if (stmt != null) {
                  stmt.close();
                }
                rs = null;
                stmt = null;
            }
            return returnStateTblPk;
      }
    
}
