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
 * $Id: DinersCouponsListAction.java,v 1.5 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.restaurant.actions;

import com.diningo.web.general.beans.DBConnection;
import com.diningo.web.general.beans.DNGConstants;
import com.diningo.web.restaurant.actionforms.DinersCouponsForm;
import com.diningo.web.restaurant.beans.Operations;
import com.diningo.web.restaurant.beans.RestaurantCouponsBean;

import java.io.IOException;

import java.sql.ResultSet;

import javax.naming.Context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 *              Purpose: To display list of coupons for a given restaurant to diner
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

DinersCouponsListAction extends Action {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    public ActionForward execute(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {
      DinersCouponsForm DinersCouponsForm=null;
      ServletContext context=null;
      String jdbcDS = null;
      
      ResultSet rs = null;
      String sqlString = null;

      try {
           logger.debug("Enter");
           
           DinersCouponsForm = (DinersCouponsForm)form;
           context=servlet.getServletContext();
           jdbcDS = (String)context.getAttribute("jdbcDS");
           
           logger.debug("jdbs-DS:" + jdbcDS);
           
           String restaurant_tbl_pk = request.getParameter("restaurant_tbl_pk");
          
           if(restaurant_tbl_pk == null || "".equals(restaurant_tbl_pk)) {
               logger.debug("Restaurant is null or blank");
               return mapping.findForward("failure");
           }
           
           DinersCouponsForm.setHdnRestaurantTblPk(restaurant_tbl_pk);

           Context ctx = new javax.naming.InitialContext();
           DataSource ds = (DataSource)ctx.lookup(jdbcDS);
           
           DBConnection dbcon = new DBConnection(ds);
           
           sqlString =  "select a.restaurant_name "                           +
                              ",a.address1 "                                  +
                              ",a.address2 "                                  +
                              ",a.city "                                      +
                              ",b.state_name "                                +
                              ",a.zipcode "                                   +
                              ",a.restaurant_phone ";
                                  
           sqlString += "from  restaurant_tbl   a "                           +
                             ",state_tbl        b ";
                            
           sqlString += "where  a.state_tbl_fk = b.state_tbl_pk "             +
                          "and  a.restaurant_tbl_pk = " + DinersCouponsForm.getHdnRestaurantTblPk();

           logger.debug(sqlString);
               
           rs = dbcon.executeQuery(sqlString);            
           while (rs.next()) {
               DinersCouponsForm.setTxtRestaurantName(rs.getString(1));
               DinersCouponsForm.setTxtAddress1(rs.getString(2));
               DinersCouponsForm.setTxtAddress2(rs.getString(3));
               DinersCouponsForm.setTxtCity(rs.getString(4));
               DinersCouponsForm.setTxtState(rs.getString(5));
               DinersCouponsForm.setTxtZipcode(rs.getString(6));
               DinersCouponsForm.setTxtRestaurantPhone(rs.getString(7));
           }
          
           sqlString =  "select a.restaurant_coupons_tbl_pk "                   +
                              ",a.coupon_name "                                 +
                              ",a.coupon_description "                          +
                              ",a.coupon_from_eff_date "                        +
                              ",a.coupon_to_eff_date ";
                                  
           sqlString += "from  restaurant_coupons_tbl  a ";
                            
           sqlString += "where  a.restaurant_tbl_fk = " + DinersCouponsForm.getHdnRestaurantTblPk() +
                        "  and  CURRENT_DATE between a.coupon_from_eff_date and  a.coupon_to_eff_date ";
           

           logger.debug(sqlString);
               
           rs = dbcon.executeQuery(sqlString,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
               
           rs.last();
           int rs_count = rs.getRow();
           rs.beforeFirst();

           RestaurantCouponsBean[] couponBean = new RestaurantCouponsBean[rs_count];
           
           int i = 0;           
           String formattedCouponDescription;
           
           while (rs.next()) {
              couponBean[i] = new RestaurantCouponsBean();
              couponBean[i].setRestaurant_coupons_tbl_pk(rs.getString(1));
              couponBean[i].setCoupon_name(rs.getString(2));
              formattedCouponDescription = Operations.text2html(rs.getString(3));
              couponBean[i].setCoupon_description(formattedCouponDescription);
              couponBean[i].setCoupon_from_eff_date(rs.getString(4));
              couponBean[i].setCoupon_to_eff_date(rs.getString(5));
               
              ++i;
           }
               
           DinersCouponsForm.setCouponBean(couponBean);

           dbcon.free(rs);
           request.setAttribute("DinersCouponsForm", DinersCouponsForm);
      } catch (Exception e) {
        logger.error(e.toString());
      } finally {
         logger.debug("Exit");
      }
      return mapping.findForward("success");          
    }
}
