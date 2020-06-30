<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<title>DiningO - Restaurant Users</title>
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
                <%@ include file="tab_rest_info.html" %>  
                <%@ include file="tab_rest_subs.html" %>
		<td width="3px" class="tabSpace">&nbsp;</td>
                <td width="60px" align="center" class="tabActive">Users</td>
                <%@ include file="tab_rest_bfast.html" %>  
                <%@ include file="tab_rest_lunch.html" %>  
                <%@ include file="tab_rest_hh.html" %>  
                <%@ include file="tab_rest_dinner.html" %>  
                <%@ include file="tab_rest_coupons.html" %>  
                <%@ include file="tab_rest_events.html" %>  
                <%@ include file="link_home_logout.html" %>  
              </tr>
            </table></td>
          </tr>
          <tr>
            <td class="textHeading12bold" align="left">&nbsp;<html:errors/></td>
          </tr>
          <tr>
            <td valign="top" align="left">
                <html:form action="/RestaurantUserNewEditAction.do">
                <html:hidden property="hdnRestaurantTblPk"/>
                <html:hidden property="hdnUserTblPk"/>
		<table width="100%" border="0" cellspacing="1" cellpadding="1">
                <tr>
                  <td width="16%" align="right">Restaurant Name:</td>
                  <td width="26%"><html:text property="txtName" style="width:200px" styleClass="txtBox" disabled="true"/></td>
                  <td width="15%" align="right"></td>
                  <td width="43%"></td>
                </tr>
                <tr>
                  <td align="right"><span class="txtHighlight">*</span>Email Address: </td>
                  <td><html:text property="txtEmailAddress" styleClass="txtBox" style="width:200px"/></td>
                  <td align="right"></td>
                  <td></td>
                </tr>
                <tr>
                  <td width="16%" align="right"><span class="txtHighlight">*</span>Name:</td>
                  <td width="26%"><html:text property="txtUserName" styleClass="txtBox" size="20"/></td>
                  <td width="15%" align="right"></td>
                  <td width="43%"></td>
                </tr>
                <tr>
                  <td align="right"><span class="txtHighlight">*</span> User ID:</td>
                  <td><html:text property="txtUserId" styleClass="txtBox" size="20"/></td>
                  <td align="right"></td>
                  <td></td>
                </tr>
                <tr>
                  <td align="right"><span class="txtHighlight">*</span> Password:</td>
                  <td><html:password property="txtPassword" styleClass="txtBox" size="20"/></td>
                  <td align="right"></td>
                  <td></td>
                </tr>
                <tr>
                  <td align="right"><span class="txtHighlight">*</span>Confirm Password:</td>
                  <td><html:password property="txtConfirmPassword" styleClass="txtBox" size="20"/></td>
                  <td align="right"></td>
                  <td></td>
                </tr>
                <tr>
                  <td align="right">Phone:</td>
                  <td><html:text property="txtPhoneNo" styleClass="txtBox" size="14"/><span class="txtHighlightSml"> XXX-XXX-XXXX</span></td>
                  <td align="right"></td>
                  <td></td>
                </tr>
                <tr>
                  <td height="70" align="left" colspan=4>
                    <html:submit>Save</html:submit> <html:reset>Reset</html:reset>
                  </td>
                </tr>
              </table>            
              </html:form>
              </td>
          </tr>
          <html:form action="/RestaurantDeleteUserAction.do">
          <tr>
            <td height="30" align="left"><html:submit>Delete</html:submit>
          </tr>
          <tr>
            <td valign="top">
              <table id="dataDynamic" width="100%" border="0" cellspacing="0" cellpadding="1" style="border:#CCCCCC 1px solid;">
              <tr>
                <th width="3%" class="thBold bdr_TH_rgt bdr_TH_btm">Select</th>
                <th width="20%" class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" align="center">User ID</th>
                <th width="30%" class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" align="center">Name</th>
                <th width="30%" class="thBold bdr_TH_lft bdr_TH_btm" align="center">Email</th>
                <th width="17%" class="thBold bdr_TH_lft bdr_TH_btm" align="center">Action</th>
              </tr>
              <logic:notEmpty name="RestaurantUserNewEditForm" property="restaurantUserList">
              <logic:iterate id="RestaurantUserInfoBean" name="RestaurantUserNewEditForm" property="restaurantUserList" indexId="i">
              <tr class="tr_<%= i%2 + 1 %>">
                <td align="center">
                  <html:multibox property="selectedUsers">
                    <bean:write name="RestaurantUserInfoBean" property="user_tbl_pk"/>
                  </html:multibox>
                </td>
                <td align="left"><bean:write name="RestaurantUserInfoBean" property="user_id"/></td>
                <td align="left"><bean:write name="RestaurantUserInfoBean" property="user_name"/></td>
                <td align="left"><bean:write name="RestaurantUserInfoBean" property="user_email"/></td>
                <td align="left"><a href="RestaurantUserB4NewEditAction.do?user_tbl_pk=<bean:write name="RestaurantUserInfoBean" property="user_tbl_pk"/>">Edit</a></td>
              </tr>
              </logic:iterate>
              </logic:notEmpty>
            </table></td>
          </tr>
          <tr>
            <td height="30" align="left"><html:submit>Delete</html:submit></td>
          </tr>
          </html:form>
          <tr>
            <td >&nbsp;</td>
          </tr>
        </table></td>
  </tr>
  
</table>
<%@ include file="footer.html" %>  
</body>
</html>