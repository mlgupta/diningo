<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<title>DiningO - Agent List</title>
<link href="main.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript">
<!--
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
//-->
</script>
<style type="text/css">
th {
	font-family: Arial, Verdana, Helvetica, sans-serif;
	font-size: 13px;
	color: #336600;
	font-weight:normal;
	/*background-color:#F8F3ED;*/
	/*background-color:#c6db94;*/
	background-color:#d6e7b5;
	
}
</style>
</head>
<body onLoad="MM_preloadImages('images/btn_contactus_over.gif','images/btn_home_over.gif')">
<table width="900px" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="bdrLftClr_Lvl_2 bdrRgtClr_Lvl_2">
  <tr>
    <td height="90px" style="background-image: url(images/bar_top_tile90.gif)">
      <%@ include file="header.html" %>  
    </td>
  </tr>
  <tr>
    <td height="255" valign="top" align="center">
          <table width="97%" border="0" cellspacing="1" cellpadding="1">
          <tr>
            <td class="textHeading12bold">&nbsp;</td>
          </tr>
          <tr>
            <td class="textHeading12bold">
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
		<td height="25px" width="5px" class="tabSpace">&nbsp;</td>
                <td width="155px" align="center" class="tabActive">Agent Management</td>
                <%@ include file="link_home_logout.html" %>  
              </tr>
            </table></td>
          </tr>
          <tr>
            <td height="30" class="textHeading12bold">&nbsp;</td>
          </tr>
          <tr>
            <td align="left">
              <html:errors/>
              <html:form action="/AgentAddAction.do">            
              <html:hidden property="hdnUserTblPk"/>
              <table border="0" cellspacing="1" cellpadding="1">
              <tr>
                <td width="371">
                 <table border="0" cellspacing="1" cellpadding="1">
                 <tr>
                   <td width="134" align="right"><span class="txtHighlight">*</span> Name:</td>
                   <td width="237"><html:text property="txtName" style="width:220px" styleClass="txtBox"></html:text></td>
                 </tr>
                 <tr>
                   <td align="right" valign="top">Address 1:</td>
                   <td><html:text property="txtAddress1" style="width:220px" styleClass="txtBox"/></td>
                 </tr>
                 <tr>
                   <td align="right" valign="top">Address 2: </td>
                   <td><html:text property="txtAddress2" style="width:220px" styleClass="txtBox"/></td>
                 </tr>
                 <tr>
                   <td align="right" valign="top">City:</td>
                   <td><html:text property="txtCity" style="width:120px" styleClass="txtBox"/></td>
                 </tr>
                 <tr>
                   <td align="right" valign="top">State:</td>
                   <td>
                     <html:select property="txtState" styleClass="txtBox">
                       <html:optionsCollection name="StateBean" property="states" value="state_name" label="state_name" />
                     </html:select>
                   </td>
                 </tr>
                 <tr>
                   <td align="right" valign="top">Zip:</td>
                   <td><html:text property="txtZip" styleClass="txtBox" style="width:50px" maxlength="5"/></td>
                 </tr>		  
                 </table>
                </td>
                <td>
                  <table border="0" cellspacing="1" cellpadding="1">
                  <tr>
                    <td align="right"><span class="txtHighlight">*</span> Email Address:</td>
                    <td><html:text property="txtEmailAddress" style="width:220px" styleClass="txtBox"/></td>
                  </tr>
                  <tr>
                    <td align="right" valign="top"><span class="txtHighlight">*</span> User ID:</td>
                    <td><html:text property= "txtUserId" style="width:220px" styleClass="txtBox"></html:text></td>                
                  </tr>
                  <tr>
                    <td align="right" valign="top"><span class="txtHighlight">*</span> Password:</td>
                    <td><html:password property="txtPassword" style="width:120px" styleClass="txtBox"/></td>
                  </tr>
                  <tr>
                    <td align="right" valign="top"><span class="txtHighlight">*</span> Confirm Password: </td>
                    <td><html:password property="txtConfirmPassword" style="width:120px" styleClass="txtBox"/></td>
                  </tr>
                  <tr>
                    <td align="right"><span class="txtHighlight">*</span> Phone:</td>
                    <td><html:text property="txtPhone" style="width:120px" styleClass="txtBox"/><span class="txtHighlightSml"> XXX-XXX-XXXX</span></td> 
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                  </tr>
                  </table>
                </td>
              </tr>
            </table>
              <table border="0" cellspacing="1" cellpadding="1">
              <tr>
                <td width="134"></td>
                <td height="40" align="left">
                    <html:submit alt="Submit">Save</html:submit>
                    <html:reset alt="Reset">Reset</html:reset></td>
              </tr>
              </table>            
              </html:form>
              </td>
            </tr>
          <tr>
            <td height="25" class="textHeading3 bdrBtmClr_Lvl_2"  align="left">Agent:</td>
          </tr>
          <html:form action="/AgentDeleteAction.do">
	  <tr>
            <td height="40" align="left"><html:submit alt="Delete">Delete</html:submit></td>
          </tr>
          <tr>
            <td >
	    <table id="dataDynamic" width="100%" border="0" cellspacing="0" cellpadding="1" style="border:#CCCCCC 1px solid;">
              <tr>
                <th class="thBold bdr_TH_rgt bdr_TH_btm" width="6%">Select</th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="30%"> Name </th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="31%">User ID </th>
                <th class="thBold bdr_TH_lft bdr_TH_btm" >Email</th>
                <th class="thBold bdr_TH_lft bdr_TH_btm" >Action</th>
	      </tr>
              <logic:notEmpty name="AgentForm" property="agentList">
              <logic:iterate id="AgentListBean" name="AgentForm" property="agentList" indexId="i">
              <tr class="tr_<%= i%2 + 1 %>">
                <td align="center">
                  <html:multibox property="selectedAgents">
                    <bean:write name="AgentListBean" property="user_tbl_pk"/>
                  </html:multibox>
                </td>
                <td align="left"><bean:write name="AgentListBean" property="user_name"/></td>
                <td align="left"><bean:write name="AgentListBean" property="user_id"/></td>
                <td width="33%" align="left"><bean:write name="AgentListBean" property="user_email"/></td>
                <td align="left"><a href="AgentEditAction.do?user_tbl_pk=<bean:write name="AgentListBean" property="user_tbl_pk"/>">Edit</a></td>
              </tr>
              </logic:iterate>
              </logic:notEmpty>
            </table></td>
          </tr>
	  <tr>
            <td height="40" align="left"><html:submit alt="Delete">Delete</html:submit></td>
          </tr>
          <tr>
            <td height="30" >&nbsp;</td>
          </tr>
          </html:form>
        </table></td>
  </tr>
  
</table>
<%@ include file="footer.html" %>  
</body>
</html>