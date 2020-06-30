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
 * $Id: RestaurantUserNewEditForm.java,v 1.4 2007/04/24 19:10:43 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.users.actionforms;

import org.apache.log4j.Logger;
import org.apache.struts.validator.ValidatorForm;
import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.users.beans.RestaurantUserInfoBean;

/**
 *              Purpose: To display and store restaurant user specific information in restaurant_user.jsp
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

RestaurantUserNewEditForm extends ValidatorForm {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String hdnRestaurantTblPk;
    private String txtName;
    
    private String hdnUserTblPk;
    private String txtUserName;
    private String txtUserId;  
    private String txtPassword;
    private String txtConfirmPassword;
    private String txtEmailAddress;
    private String txtPhoneNo;
    
    private String[] selectedUsers = {};
    private RestaurantUserInfoBean[] restaurantUserList;
    
    private int row_count;


    public void setHdnUserTblPk(String hdnUserTblPk) {
        this.hdnUserTblPk = hdnUserTblPk;
    }

    public String getHdnUserTblPk() {
        return hdnUserTblPk;
    }

    public void setTxtUserName(String txtUserName) {
        this.txtUserName = txtUserName;
    }

    public String getTxtUserName() {
        return txtUserName;
    }

    public void setTxtUserId(String txtUserId) {
        this.txtUserId = txtUserId;
    }

    public String getTxtUserId() {
        return txtUserId;
    }

    public void setTxtPassword(String txtPassword) {
        this.txtPassword = txtPassword;
    }

    public String getTxtPassword() {
        return txtPassword;
    }

    public void setTxtConfirmPassword(String txtConfirmPassword) {
        this.txtConfirmPassword = txtConfirmPassword;
    }

    public String getTxtConfirmPassword() {
        return txtConfirmPassword;
    }

    public void setTxtEmailAddress(String txtEmailAddress) {
        this.txtEmailAddress = txtEmailAddress;
    }

    public String getTxtEmailAddress() {
        return txtEmailAddress;
    }

    public void setTxtPhoneNo(String txtPhoneNo) {
        this.txtPhoneNo = txtPhoneNo;
    }

    public String getTxtPhoneNo() {
        return txtPhoneNo;
    }

    public void setSelectedUsers(String[] selectedUsers) {
        this.selectedUsers = selectedUsers;
    }

    public String[] getSelectedUsers() {
        return selectedUsers;
    }

    public void setRestaurantUserList(RestaurantUserInfoBean[] restaurantUserList) {
        this.restaurantUserList = restaurantUserList;
    }

    public RestaurantUserInfoBean[] getRestaurantUserList() {
        return restaurantUserList;
    }

    public void setHdnRestaurantTblPk(String hdnRestaurantTblPk) {
        this.hdnRestaurantTblPk = hdnRestaurantTblPk;
    }

    public String getHdnRestaurantTblPk() {
        return hdnRestaurantTblPk;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setRow_count(int row_count) {
        this.row_count = row_count;
    }

    public int getRow_count() {
        return row_count;
    }
}
