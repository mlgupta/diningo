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
 * $Id: AgentListAction.java,v 1.6 2008/01/22 22:02:51 manish Exp $
 *****************************************************************************
 */
package com.diningo.web.users.actions;

import com.diningo.web.general.beans.DBConnection;
import com.diningo.web.general.beans.DNGConstants;

import com.diningo.web.users.beans.Operations;

import com.diningo.web.users.actionforms.AgentForm;

import com.diningo.web.users.beans.AgentListBean;

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
 *              Purpose: To list exisiting agents
 *
 *             @author   Manish Gupta
 *            @version   1.0
 *    Date of creation : 24-11-2006
 *    Last Modified by : 
 *  Last Modified Date :
 */
public class

AgentListAction extends Action {
    static Logger logger = Logger.getLogger(DNGConstants.LOGGER.toString());
    
    public ActionForward execute(ActionMapping mapping, 
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {

      AgentForm AgentForm=null;
      ServletContext context=null;
      String jdbcDS = null;
      ResultSet rs = null;
      String sqlString = null;

      try {
           logger.debug("Enter");
           
           AgentForm = (AgentForm)form;
           context=servlet.getServletContext();
           jdbcDS = (String)context.getAttribute("jdbcDS");
           
           logger.debug("jdbs-DS:" + jdbcDS);

           String resetFlag = request.getParameter("reset");
           
           if (resetFlag == null || "".equals(resetFlag)) {
           }
           else {
             if ("true".equals(resetFlag)) {
                 logger.debug("Reset Flag set. Resetting FormBean");
                 Operations.resetAgentForm(AgentForm);
             }
           }    

           if (AgentForm.getHdnUserTblPk() == null || "".equals(AgentForm.getHdnUserTblPk())) {
                Operations.resetAgentForm(AgentForm);
            }
           Context ctx = new javax.naming.InitialContext();
           DataSource ds = (DataSource)ctx.lookup(jdbcDS);
           
           DBConnection dbcon = new DBConnection(ds);
           
           sqlString = "select   a.user_tbl_pk "                                  +
                               ",a.user_id "                                      +
                               ",a.user_name "                                    +
                               ",a.user_email "                                   +
                       "from    user_tbl          a "                             +
                              ",user_category_tbl b "                             +
                       "where   a.user_category_tbl_fk = b.user_category_tbl_pk " +
                         "and   b.user_category_name   = 'AGENT' "                +
                         "and   a.date_eff            <=  CURRENT_DATE "          +
                         "and   a.date_inac            >  CURRENT_DATE "          +
                       "order by a.user_name";
           
           rs = dbcon.executeQuery(sqlString,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           
           rs.last();
           int rs_count = rs.getRow();
           rs.beforeFirst();

           AgentListBean[] agentList = new AgentListBean[rs_count];
           String[] selectedAgents   = new String[rs_count];
           
           int i = 0;           
           while (rs.next()) {
               agentList[i] = new AgentListBean();
               agentList[i].setUser_tbl_pk(rs.getString(1));
               agentList[i].setUser_id(rs.getString(2));
               agentList[i].setUser_name(rs.getString(3));
               agentList[i].setUser_email(rs.getString(4));
               
               ++i;
           }
           
           AgentForm.setAgentList(agentList);
           AgentForm.setSelectedAgents(selectedAgents);
           
           dbcon.free(rs);
      } catch (Exception e) {
        logger.error(e.toString());
      } finally {
         logger.debug("Exit");
      }
      return mapping.findForward("success");
    }
}