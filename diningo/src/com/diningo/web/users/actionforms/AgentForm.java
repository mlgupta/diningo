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
 * $Id: AgentForm.java,v 1.5 2007/05/01 20:29:34 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.users.actionforms;


import org.apache.log4j.Logger;
import org.apache.struts.validator.ValidatorForm;
import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.users.beans.AgentListBean;

/**
 *              Purpose: To display and store agent specific information in agent_list.jsp
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

AgentForm extends ValidatorForm {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String hdnUserTblPk;
    private String txtGroup;
    private String txtPhone;
    private String txtEmailAddress;
    private String txtZip;
    private String txtState;
    private String txtCity;
    private String txtAddress2;
    private String txtAddress1;
    private String txtConfirmPassword;
    private String txtPassword;
    private String txtUserId;
    private String txtName;    
    
    private String[] selectedAgents = {};
    private AgentListBean[] agentList;

    public String getTxtUserId() {
        return txtUserId;
    }

    public void setTxtUserId(String txtUserId) {
        this.txtUserId = txtUserId;
    }

    public String getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(String txtPassword) {
        this.txtPassword = txtPassword;
    }

    public String getTxtConfirmPassword() {
        return txtConfirmPassword;
    }

    public void setTxtConfirmPassword(String txtConfirmPassword) {
        this.txtConfirmPassword = txtConfirmPassword;
    }

    public String getTxtAddress1() {
        return txtAddress1;
    }

    public void setTxtAddress1(String txtAddress1) {
        this.txtAddress1 = txtAddress1;
    }

    public String getTxtAddress2() {
        return txtAddress2;
    }

    public void setTxtAddress2(String txtAddress2) {
        this.txtAddress2 = txtAddress2;
    }

    public String getTxtCity() {
        return txtCity;
    }

    public void setTxtCity(String txtCity) {
        this.txtCity = txtCity;
    }

    public String getTxtState() {
        return txtState;
    }

    public void setTxtState(String txtState) {
        this.txtState = txtState;
    }

    public String getTxtZip() {
        return txtZip;
    }

    public void setTxtZip(String txtZip) {
        this.txtZip = txtZip;
    }

    public String getTxtEmailAddress() {
        return txtEmailAddress;
    }

    public void setTxtEmailAddress(String txtEmailAddress) {
        this.txtEmailAddress = txtEmailAddress;
    }

    public String getTxtPhone() {
        return txtPhone;
    }

    public void setTxtPhone(String txtPhone) {
        this.txtPhone = txtPhone;
    }

    public String getTxtGroup() {
        return txtGroup;
    }

    public void setTxtGroup(String txtGroup) {
        this.txtGroup = txtGroup;
    }

    public void setSelectedAgents(String[] selectedAgents) {
        this.selectedAgents = selectedAgents;
    }

    public String[] getSelectedAgents() {
        return selectedAgents;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setHdnUserTblPk(String hdnUserTblPk) {
        this.hdnUserTblPk = hdnUserTblPk;
    }

    public String getHdnUserTblPk() {
        return hdnUserTblPk;
    }

    public void setAgentList(AgentListBean[] agentList) {
        this.agentList = agentList;
    }

    public AgentListBean[] getAgentList() {
        return agentList;
    }
}
