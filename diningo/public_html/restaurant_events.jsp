<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<title>DiningO - Restaurant Coupons</title>
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
                <%@ include file="tab_rest_user.html" %>  
                <%@ include file="tab_rest_bfast.html" %>  
                <%@ include file="tab_rest_lunch.html" %>  
                <%@ include file="tab_rest_hh.html" %>  
                <%@ include file="tab_rest_dinner.html" %>  
                <%@ include file="tab_rest_coupons.html" %>  
		<td width="3px" class="tabSpace">&nbsp;</td>
		<td width="75px" align="center" class="tabActive">Events</td>
                <%@ include file="link_home_logout.html" %>  
              </tr>
            </table></td>
          </tr>
          <tr>
            <td height="30" class="textHeading12bold" align="left">&nbsp;<html:errors/></td>
          </tr>
          <html:form action="/RestaurantEventsAction.do">
          <html:hidden property="hdnRestaurantTblPk"/>
          <tr>
            <td height="30" class="bdrBtmClr_Lvl_2" align="left"><span class="textHeading3">Events Entry</span></td>
          </tr>
          <tr>
            <td align="left">
              <html:hidden property="hdnRestaurantEventsTblPk"/>
	      <table border="0" cellspacing="1" cellpadding="1" style="margin-top:15px">
              <tr>
                <td width="132" align="right"><span class="txtHighlight">*</span>Event Date:</td>
                <td width="406"><html:text property="txtEventEffDate" style="width:120px" styleClass="txtBox"/> <span class="txtHighlightSml"> YYYY/MM/DD </span></td>
              </tr>
              <tr>
                <td width="132" align="right"><span class="txtHighlight">*</span> Event Name:</td>
                <td width="406"><html:text property="txtEventName" style="width:290px" styleClass="txtBox"/></td>
              </tr>
              <tr>
                <td align="right" valign="top"><span class="txtHighlight">*</span>Description </td>
                <td><html:textarea property="txtEventDescription" rows="8" styleClass="txtBox" style="width:425px"></html:textarea></td>
              </tr>		  
            </table>
            <table border="0" cellspacing="1" cellpadding="1" style="margin-top:15px">
              <tr>
                <td width="132"></td>
                <td height="40">
                    <html:submit property="method"><bean:message key="button.save"/></html:submit>
                    <html:cancel><bean:message key="button.cancel"/></html:cancel>
<!--                    
                    <html:submit property="method"><bean:message key="button.cancel"/></html:submit>
-->                    
                </td>
              </tr>
              </table></td>
            </tr>
          <tr>
            <td >&nbsp;</td>
          </tr>
          <tr>
            <td height="30" class="textHeading3 bdrBtmClr_Lvl_2" align="left">Events:</td>
          </tr>
	  <tr>
            <td height="40" align="left">
              <html:submit property="method"><bean:message key="button.delete"/></html:submit>
            </td>
          </tr>
          <tr>
            <td >
		<table id="dataDynamic" width="100%" border="0" cellspacing="0" cellpadding="1" style="border:#CCCCCC 1px solid;">
              <tr>
                <th class="thBold bdr_TH_rgt bdr_TH_btm" width="6%">Select</th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="19%"> Date </th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="29%"> Name </th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="41%"> Description</th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="5%"> Action</th>
              </tr>
              <logic:notEmpty name="RestaurantEventsForm" property="restaurantEventsList">
              <logic:iterate id="RestaurantEventsBean" name="RestaurantEventsForm" property="restaurantEventsList" indexId="i">
              <tr class="tr_<%= i%2 + 1 %>">
                <td align="center">
                  <html:multibox property="selectedEvents">
                    <bean:write name="RestaurantEventsBean" property="restaurant_events_tbl_pk"/>
                  </html:multibox>
                </td>
                <td align="left"><bean:write name="RestaurantEventsBean" property="event_eff_date"/></td>
                <td align="left"><bean:write name="RestaurantEventsBean" property="event_name"/></td>
                <td align="left"><bean:write name="RestaurantEventsBean" property="event_description"/></td>
                <td align="left"><a href="RestaurantEventsB4Action.do?restaurant_events_tbl_pk=<bean:write name="RestaurantEventsBean" property="restaurant_events_tbl_pk"/>">Edit</a></td>
              </tr>
              </logic:iterate>
              </logic:notEmpty>
            </table></td>
          </tr>
	  <tr>
            <td height="40" align="left">
                <html:submit property="method"><bean:message key="button.delete"/></html:submit>
            </td>
          </tr>
          </html:form>
          <tr>
            <td height="30" >&nbsp;</td>
          </tr>
        </table></td>
  </tr>
</table>
<%@ include file="footer.html" %>  
</body>
</html>