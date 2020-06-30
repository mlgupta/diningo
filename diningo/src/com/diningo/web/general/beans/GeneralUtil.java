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
 * $Id: GeneralUtil.java,v 1.4 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.general.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;


/**
 *              Purpose: Utility to obtain page count  
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class


GeneralUtil {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());

    /**
     * @param recipients
     * @param subject
     * @param message
     * @param from
     * @param smtphost
     * @throws MessagingException
     */
    public static void postMail(String recipients, String subject,
                                String message, String from,
                                String smtphost) throws MessagingException {
      logger.debug("Enter postMail");

      try {

        logger.debug("Recipient: " + recipients);
        logger.debug("From: " + from);
        logger.debug("SMTPHost: " + smtphost);
        
        //Set the host smtp address
        Properties props = new Properties();
        props.put("mail.smtp.host", smtphost);

        // create some properties and get the default Session
        Session session = Session.getDefaultInstance(props, null);

        // create a message
        Message msg = new MimeMessage(session);

        // set the from and to address
        InternetAddress addressFrom = new InternetAddress(from);
        msg.setFrom(addressFrom);

        InternetAddress addressTo = new InternetAddress(recipients);

        msg.setRecipient(Message.RecipientType.TO, addressTo);

        // Optional : You can also set your custom headers in the Email if you Want
        msg.addHeader("Errors-To", from);

        // Setting the Subject and Content Type
        msg.setSubject(subject);
        msg.setContent(message, "text/plain");
        Transport.send(msg);
      } catch (MessagingException e) {
        logger.error(e.getMessage());
        e.printStackTrace();
      } catch (Exception e) {
        logger.error(e.getMessage());
        e.printStackTrace();
      } finally {
        logger.debug("Exit postMail");
      }
    }

    /**
     * @param rs
     * @param numberOfRecords
     * @return
     * @throws SQLException
     */
    public static int getPageCount(ResultSet rs, 
                                   int numberOfRecords) throws SQLException {
        logger.debug("Enter getPageCount");
        int recordCount;
        int pageCount = 1;
        try {
          rs.last();
          recordCount = rs.getRow();
          if (recordCount != 0) {
            pageCount = ((recordCount % numberOfRecords) == 0) ? (recordCount/numberOfRecords) : 
                                                                 ((recordCount/numberOfRecords) + 1);
          }
          rs.beforeFirst();
        } catch (SQLException se) {
          logger.error("***Exception in getPageCount() method" + se.getMessage());
          throw se;
        }
        logger.debug("Exit getPageCount");
        return pageCount;
    }
}
