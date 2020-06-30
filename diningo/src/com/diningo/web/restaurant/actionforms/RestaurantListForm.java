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
 * $Id: RestaurantListForm.java,v 1.5 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.actionforms;

import org.apache.log4j.Logger;
import org.apache.struts.validator.ValidatorForm;
import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.restaurant.beans.RestaurantBean;

/**
 *              Purpose: To store and display list of restaurants
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

RestaurantListForm extends ValidatorForm {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String hdnRestaurantTblPk;
    private String txtName;
    private String txtAddress1;
    private String txtAddress2;
    private String txtCity;
    private String txtStateTblFk;
    private String txtZipcode;
    private String txtMetroArea;
    private String txtPhoneNo;
    private String txtFaxNo;
    private String txtUserTblFk;
    private String txtWebsite;
    private String txtMenuUrl;
    private String txtEntertainmentUrl;
    private String txtVideoUrl;
    private String txtMapUrl;
    private String hdnContact1_restaurant_contact_people_tbl_pk;
    private String txtContact1_name;
    private String txtContact1_phone;
    private String txtContact1_email;
    private String hdnContact2_restaurant_contact_people_tbl_pk;
    private String txtContact2_name;
    private String txtContact2_phone;
    private String txtContact2_email;
    private String hdnContact3_restaurant_contact_people_tbl_pk;
    private String txtContact3_name;
    private String txtContact3_phone;
    private String txtContact3_email;
    private String hdnContact4_restaurant_contact_people_tbl_pk;
    private String txtContact4_name;
    private String txtContact4_phone;
    private String txtContact4_email;
    private String [] selected_cuisine = {};
    private String hdnRestaurant_category_tbl_pk;
   
    private String cboCuisine  = null;
    private String cboCity  = null;
    private String cboState = null;
    private String cboZipCode = null;
    private String cboSubscription = null;
    
    private String[] selected = {};
    private RestaurantBean[] restaurantList;
    
    private String uri;
    private int row_count;
    private int maxPageItems;

    public void setCboCuisine(String cboCuisine) {
        this.cboCuisine = cboCuisine;
    }

    public String getCboCuisine() {
        return cboCuisine;
    }

    public void setCboCity(String cboCity) {
        this.cboCity = cboCity;
    }

    public String getCboCity() {
        return cboCity;
    }

    public void setCboState(String cboState) {
        this.cboState = cboState;
    }

    public String getCboState() {
        return cboState;
    }

    public void setCboSubscription(String cboSubscription) {
        this.cboSubscription = cboSubscription;
    }

    public String getCboSubscription() {
        return cboSubscription;
    }

    public void setSelected(String[] selected) {
        this.selected = selected;
    }

    public String[] getSelected() {
        return selected;
    }

    public void setRestaurantList(RestaurantBean[] restaurantList) {
        this.restaurantList = restaurantList;
    }

    public RestaurantBean[] getRestaurantList() {
        return restaurantList;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    public void setRow_count(int row_count) {
        this.row_count = row_count;
    }

    public int getRow_count() {
        return row_count;
    }

    public void setMaxPageItems(int maxPageItems) {
        this.maxPageItems = maxPageItems;
    }

    public int getMaxPageItems() {
        return maxPageItems;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtAddress1(String txtAddress1) {
        this.txtAddress1 = txtAddress1;
    }

    public String getTxtAddress1() {
        return txtAddress1;
    }

    public void setTxtAddress2(String txtAddress2) {
        this.txtAddress2 = txtAddress2;
    }

    public String getTxtAddress2() {
        return txtAddress2;
    }

    public void setTxtCity(String txtCity) {
        this.txtCity = txtCity;
    }

    public String getTxtCity() {
        return txtCity;
    }

    public void setTxtStateTblFk(String txtStateTblFk) {
        this.txtStateTblFk = txtStateTblFk;
    }

    public String getTxtStateTblFk() {
        return txtStateTblFk;
    }

    public void setTxtZipcode(String txtZipcode) {
        this.txtZipcode = txtZipcode;
    }

    public String getTxtZipcode() {
        return txtZipcode;
    }

    public void setTxtPhoneNo(String txtPhoneNo) {
        this.txtPhoneNo = txtPhoneNo;
    }

    public String getTxtPhoneNo() {
        return txtPhoneNo;
    }

    public void setTxtFaxNo(String txtFaxNo) {
        this.txtFaxNo = txtFaxNo;
    }

    public String getTxtFaxNo() {
        return txtFaxNo;
    }

    public void setTxtUserTblFk(String txtUserTblFk) {
        this.txtUserTblFk = txtUserTblFk;
    }

    public String getTxtUserTblFk() {
        return txtUserTblFk;
    }

    public void setTxtWebsite(String txtWebsite) {
        this.txtWebsite = txtWebsite;
    }

    public String getTxtWebsite() {
        return txtWebsite;
    }

    public void setTxtMenuUrl(String txtMenuUrl) {
        this.txtMenuUrl = txtMenuUrl;
    }

    public String getTxtMenuUrl() {
        return txtMenuUrl;
    }

    public void setTxtEntertainmentUrl(String txtEntertainmentUrl) {
        this.txtEntertainmentUrl = txtEntertainmentUrl;
    }

    public String getTxtEntertainmentUrl() {
        return txtEntertainmentUrl;
    }

    public void setTxtVideoUrl(String txtVideoUrl) {
        this.txtVideoUrl = txtVideoUrl;
    }

    public String getTxtVideoUrl() {
        return txtVideoUrl;
    }

    public void setTxtMapUrl(String txtMapUrl) {
        this.txtMapUrl = txtMapUrl;
    }

    public String getTxtMapUrl() {
        return txtMapUrl;
    }

    public void setTxtContact1_name(String txtContact1_name) {
        this.txtContact1_name = txtContact1_name;
    }

    public String getTxtContact1_name() {
        return txtContact1_name;
    }

    public void setTxtContact1_phone(String txtContact1_phone) {
        this.txtContact1_phone = txtContact1_phone;
    }

    public String getTxtContact1_phone() {
        return txtContact1_phone;
    }

    public void setTxtContact1_email(String txtContact1_email) {
        this.txtContact1_email = txtContact1_email;
    }

    public String getTxtContact1_email() {
        return txtContact1_email;
    }

    public void setTxtContact2_name(String txtContact2_name) {
        this.txtContact2_name = txtContact2_name;
    }

    public String getTxtContact2_name() {
        return txtContact2_name;
    }

    public void setTxtContact2_phone(String txtContact2_phone) {
        this.txtContact2_phone = txtContact2_phone;
    }

    public String getTxtContact2_phone() {
        return txtContact2_phone;
    }

    public void setTxtContact2_email(String txtContact2_email) {
        this.txtContact2_email = txtContact2_email;
    }

    public String getTxtContact2_email() {
        return txtContact2_email;
    }

    public void setTxtContact3_name(String txtContact3_name) {
        this.txtContact3_name = txtContact3_name;
    }

    public String getTxtContact3_name() {
        return txtContact3_name;
    }

    public void setTxtContact3_phone(String txtContact3_phone) {
        this.txtContact3_phone = txtContact3_phone;
    }

    public String getTxtContact3_phone() {
        return txtContact3_phone;
    }

    public void setTxtContact3_email(String txtContact3_email) {
        this.txtContact3_email = txtContact3_email;
    }

    public String getTxtContact3_email() {
        return txtContact3_email;
    }

    public void setTxtContact4_name(String txtContact4_name) {
        this.txtContact4_name = txtContact4_name;
    }

    public String getTxtContact4_name() {
        return txtContact4_name;
    }

    public void setTxtContact4_phone(String txtContact4_phone) {
        this.txtContact4_phone = txtContact4_phone;
    }

    public String getTxtContact4_phone() {
        return txtContact4_phone;
    }

    public void setTxtContact4_email(String txtContact4_email) {
        this.txtContact4_email = txtContact4_email;
    }

    public String getTxtContact4_email() {
        return txtContact4_email;
    }

    public void setSelected_cuisine(String[] selected_cuisine) {
        this.selected_cuisine = selected_cuisine;
    }

    public String[] getSelected_cuisine() {
        return selected_cuisine;
    }

    public void setHdnRestaurantTblPk(String hdnRestaurantTblPk) {
        this.hdnRestaurantTblPk = hdnRestaurantTblPk;
    }

    public String getHdnRestaurantTblPk() {
        return hdnRestaurantTblPk;
    }

    public void setHdnContact1_restaurant_contact_people_tbl_pk(String hdnContact1_restaurant_contact_people_tbl_pk) {
        this.hdnContact1_restaurant_contact_people_tbl_pk = hdnContact1_restaurant_contact_people_tbl_pk;
    }

    public String getHdnContact1_restaurant_contact_people_tbl_pk() {
        return hdnContact1_restaurant_contact_people_tbl_pk;
    }

    public void setHdnContact2_restaurant_contact_people_tbl_pk(String hdnContact2_restaurant_contact_people_tbl_pk) {
        this.hdnContact2_restaurant_contact_people_tbl_pk = hdnContact2_restaurant_contact_people_tbl_pk;
    }

    public String getHdnContact2_restaurant_contact_people_tbl_pk() {
        return hdnContact2_restaurant_contact_people_tbl_pk;
    }

    public void setHdnContact3_restaurant_contact_people_tbl_pk(String hdnContact3_restaurant_contact_people_tbl_pk) {
        this.hdnContact3_restaurant_contact_people_tbl_pk = hdnContact3_restaurant_contact_people_tbl_pk;
    }

    public String getHdnContact3_restaurant_contact_people_tbl_pk() {
        return hdnContact3_restaurant_contact_people_tbl_pk;
    }

    public void setHdnContact4_restaurant_contact_people_tbl_pk(String hdnContact4_restaurant_contact_people_tbl_pk) {
        this.hdnContact4_restaurant_contact_people_tbl_pk = hdnContact4_restaurant_contact_people_tbl_pk;
    }

    public String getHdnContact4_restaurant_contact_people_tbl_pk() {
        return hdnContact4_restaurant_contact_people_tbl_pk;
    }

    public void setHdnRestaurant_category_tbl_pk(String hdnRestaurant_category_tbl_pk) {
        this.hdnRestaurant_category_tbl_pk = hdnRestaurant_category_tbl_pk;
    }

    public String getHdnRestaurant_category_tbl_pk() {
        return hdnRestaurant_category_tbl_pk;
    }

    public void setCboZipCode(String cboZipCode) {
        this.cboZipCode = cboZipCode;
    }

    public String getCboZipCode() {
        return cboZipCode;
    }

    public void setTxtMetroArea(String txtMetroArea) {
        this.txtMetroArea = txtMetroArea;
    }

    public String getTxtMetroArea() {
        return txtMetroArea;
    }
}
