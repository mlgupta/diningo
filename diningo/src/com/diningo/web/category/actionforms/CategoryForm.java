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
 * $Id: CategoryForm.java,v 1.4 2007/03/21 02:24:20 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.category.actionforms;

import com.diningo.web.category.beans.CategoryBean;

import org.apache.log4j.Logger;
import org.apache.struts.validator.ValidatorForm;
import com.diningo.web.general.beans.DNGConstants;


/**
 *              Purpose: To carry field specific information from Category Form.
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

CategoryForm extends ValidatorForm {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    private String hdnCategoryTblPk;
    private String txtCategoryName;
    private String txtCategoryDesc;
    
    private String[] selected = {};
    private CategoryBean[] categoryList;


    public String getTxtCategoryName() {
        return txtCategoryName;
    }

    public void setTxtCategoryName(String txtCategoryName) {
        this.txtCategoryName = txtCategoryName;
    }

    public String getTxtCategoryDesc() {
        return txtCategoryDesc;
    }

    public void setTxtCategoryDesc(String txtCategoryDesc) {
        this.txtCategoryDesc = txtCategoryDesc;
    }

    public void setHdnCategoryTblPk(String hdnCategoryTblPk) {
        this.hdnCategoryTblPk = hdnCategoryTblPk;
    }

    public String getHdnCategoryTblPk() {
        return hdnCategoryTblPk;
    }

    public void setCategoryList(CategoryBean[] categoryList) {
        this.categoryList = categoryList;
    }

    public CategoryBean[] getCategoryList() {
        return categoryList;
    }

    public void setSelected(String[] selected) {
        this.selected = selected;
    }

    public String[] getSelected() {
        return selected;
    }
}
