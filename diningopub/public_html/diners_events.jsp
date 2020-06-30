<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<title>DiningO - Diner's Events</title>
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
</head>
<body onLoad="MM_preloadImages('images/btn_contactus_over.gif','images/btn_home_over.gif')">
<br>
<table width="900px" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="bdrLftClr_Lvl_2 bdrRgtClr_Lvl_2 bdrTopClr_Lvl_2">
  <tr>
    <td height="90px" style="background-image: url(images/bar_top_tile90.gif)">
      <%@ include file="header.html" %>  
    </td>
  </tr>
  <tr>
    <td height="255" valign="top">
	<table width="100%" border="0" cellspacing="1" cellpadding="1">
      <tr>
        <td width="76%" height="510px" align="center" valign="top">
		  <table width="97%" border="0" cellspacing="1" cellpadding="1">
          <tr>
            <td height="40" class="textHeading1">Entertainment Events For Restaurant</td>
          </tr>
          <tr>
            <td valign="top">
              <table width="100%" border="0" cellpadding="1" cellspacing="1">
              <tr>
                <td height="18" align="left" class="textHeading2">
                   <bean:write name="DinersEventsForm" property="txtRestaurantName"/>
                </td>
              </tr>
              <tr>
                <td align="left">
                  <bean:write name="DinersEventsForm" property="txtAddress1"/><br>
                  <logic:notEmpty name="DinersEventsForm" property="txtAddress2">
                    <bean:write name="DinersEventsForm" property="txtAddress2"/><br>
                  </logic:notEmpty>
                  <bean:write name="DinersEventsForm" property="txtCity"/>, <bean:write name="DinersEventsForm" property="txtState"/> <bean:write name="DinersEventsForm" property="txtZipcode"/><br>
                </td>
              </tr>
              <tr>
                <td height="30" align="left"><span class="txtHighlight">Phone:</span><bean:write name="DinersEventsForm" property="txtRestaurantPhone"/></td>
              </tr>
              </table>            
            </td>
          </tr>
          <tr>
            <td >
              <table id="dataDynamic" width="100%" border="0" cellspacing="0" cellpadding="1" style="border:#CCCCCC 1px solid;">
              <tr>
                <th class="thBold bdr_TH_rgt bdr_TH_btm" width="15%"> Date </th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="20%"> Name </th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="65%"> Event Details</th>
              </tr>
              <logic:notEmpty name="DinersEventsForm" property="eventBean">
              <logic:iterate id="DinersEventsBean" name="DinersEventsForm" property="eventBean" indexId="i">
              <tr class="tr_<%= i%2 + 1 %>">
                <td align="left">&nbsp;<bean:write name="DinersEventsBean" property="event_eff_date"/></td>
                <td align="left"><bean:write name="DinersEventsBean" property="event_name" filter="false"/></td>
                <td align="left"><bean:write name="DinersEventsBean" property="event_description" filter="false"/></td>
              </tr>
              </logic:iterate>
              </logic:notEmpty>
            </table></td>
          </tr>
        </table></td>
        <td width="24%" align="center" valign="top">
         <table width="100%" border="0" cellspacing="1" cellpadding="1">
          <tr>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td height="650px" align="center" valign="top" class="bdrLftClr_Lvl_2">
              <table id="googleAdSense" width="75%" border="0" cellspacing="1" cellpadding="1">
              <tr>
                <td align="center">
                  <%@ include file="google_ad.html" %>  
                </td>
              </tr>
            </table></td>
          </tr>
        </table>
		</td>
      </tr>
    </table></td>
  </tr>
</table>
<%@ include file="footer.html" %>  </body>
</html>