<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<title>DiningO - Admin Home</title>
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
<body onLoad="MM_preloadImages('images/btn_contactus_over.gif','images/btn_home_over.gif','images/box_agent_management_over.gif','images/box_restaurant_management_over.gif','images/box_restaurant_category_setup_over.gif','images/box_email_campaign_setup_over.gif')">
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
	      <table width="100%" border="0" cellspacing="1" cellpadding="1">
              <tr>
                <%@ include file="link_home_logout.html" %>  
              </tr>
            </table></td>
          </tr>
          <tr>
            <td height="30" class="bdrBtmClr_Lvl_2"  align="left"><span class="textHeading3">Manage: </span></td>
          </tr>
          <tr>
          <tr>
            <td height="150" align="center" class="textHeading12bold">
              <a href="RestaurantSelectListAction.do?action=restaurant_information" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Restaurant Information','','images/box_restaurant_info_over.gif',1)"><img src="images/box_restaurant_info.gif" alt="Restaurant Information" name="Restaurant Information" width="145" height="100" border="0" style="margin:8px"></a>
              <a href="RestaurantSelectListAction.do?action=subscription_management" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Subscription Management','','images/box_subscription_mgmt_over.gif',1)"><img src="images/box_subscription_mgmt.gif" alt="Subscription Management" name="Subscription Management" width="145" height="100" border="0" style="margin:8px"></a>
              <a href="RestaurantSelectListAction.do?action=user_management" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('User Management','','images/box_user_mgmt_over.gif',1)"><img src="images/box_user_mgmt.gif" alt="User Management" name="User Management" width="145" height="100" border="0" style="margin:8px"></a>
              <a href="RestaurantSelectListAction.do?action=breakfast_specials" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Breakfast Specials','','images/box_bfast_specials_over.gif',1)"><img src="images/box_bfast_specials.gif" alt="Breakfast Specials" name="Breakfast Specials" width="145" height="100" border="0" style="margin:8px"></a>
              <a href="RestaurantSelectListAction.do?action=lunch_specials" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Lunch Specials','','images/box_lunch_specials_over.gif',1)"><img src="images/box_lunch_specials.gif" alt="Lunch Specials" name="Lunch Specials" width="145" height="100" border="0" style="margin:8px"></a>
              <a href="RestaurantSelectListAction.do?action=happy_hour_specials" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Happy Hour Specials','','images/box_hh_specials_over.gif',1)"><img src="images/box_hh_specials.gif" alt="Happy Hour Specials" name="Happy Hour Specials" width="145" height="100" border="0" style="margin:8px"></a>              
              <a href="RestaurantSelectListAction.do?action=dinner_specials" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Dinner Specials','','images/box_dinner_specials_over.gif',1)"><img src="images/box_dinner_specials.gif" alt="Dinner Specials" name="Dinner Specials" width="145" height="100" border="0" style="margin:8px"></a>              
              <a href="RestaurantSelectListAction.do?action=coupons_management" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Coupons','','images/box_coupon_mgmt_over.gif',1)"><img src="images/box_coupon_mgmt.gif" alt="Coupons" name="Coupons" width="145" height="100" border="0" style="margin:8px"></a>              
              <a href="RestaurantSelectListAction.do?action=events_management" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Events','','images/box_event_mgmt_over.gif',1)"><img src="images/box_event_mgmt.gif" alt="Events" name="Events" width="145" height="100" border="0" style="margin:8px"></a>              
              <a href="SubscribeDinerB4Action.do" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Subscribe Diner','','images/box_subscribe_diner_over.gif',1)"><img src="images/box_subscribe_diner.gif" alt="Subscribe Diner" name="Subscribe Diner" width="145" height="100" border="0" style="margin:8px"></a>              
            </td>
          </tr>
          <logic:equal name="userPreferences" property="userTypeAdmin" value="true" >
          <tr>
            <td height="30" class="bdrBtmClr_Lvl_2"  align="left"><span class="textHeading3">Setup: </span></td>
          </tr>
          <tr>
            <td height="150" align="center" class="textHeading12bold">
              <a href="AgentListAction.do" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Agent Management','','images/box_agent_management_over.gif',1)"><img src="images/box_agent_management.gif" alt="Agent Management" name="Agent Management" width="145" height="100" border="0" style="margin:8px"></a>
              <a href="RestaurantListAction.do" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Restaurant Management','','images/box_restaurant_management_over.gif',1)"><img src="images/box_restaurant_management.gif" alt="Restaurant Management" name="Restaurant Management" width="145" height="100" border="0" style="margin:8px"></a>
              <a href="CategoryListAction.do" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Restaurant Category Setup','','images/box_restaurant_category_setup_over.gif',1)"><img src="images/box_restaurant_category_setup.gif" alt="Restaurant Category Setup" name="Restaurant Category Setup" width="145" height="100" border="0" style="margin:8px"></a>
              <a href="#" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Email Campaign Setup','','images/box_email_campaign_setup_over.gif',1)"><img src="images/box_email_campaign_setup.gif" alt="Email Campaign Setup" name="Email Campaign Setup" width="145" height="100" border="0" style="margin:8px"></a>
            </td>
          </tr>
          </logic:equal>
          
          <tr>
            <td height="30" class="bdrBtmClr_Lvl_2" align="left"><span class="textHeading3"> Reports: </span></td>
          </tr>
          <tr>
            <td height="230" valign="top" align="left">
	      <table border="0" cellspacing="1" cellpadding="1">
              <tr>
                <td width="6%" height="15" align="center"></td>
                <td width="94%"></td>
              </tr>
              <logic:equal name="userPreferences" property="userTypeAdmin" value="true">
              <tr>
                <td height="35" align="center"><a href="#"><img src="images/icon_report.gif" alt="" width="30" height="25" border="0"></a></td>
                <td align="left">
				<span class="textLinkBold">
				<a href="#">Review signed up users</a></span></td>
              </tr>
              <tr>
                <td height="35" align="center"><a href="#"><img src="images/icon_report.gif" alt="" width="30" height="25" border="0"></a></td>
                <td align="left">
				<span class="textLinkBold">
				<a href="#">Commission report by agent</a></span></td>
              </tr>
              <tr>
                <td height="35" align="center"><a href="#"><img src="images/icon_report.gif" alt="" width="30" height="25" border="0"></a></td>
                <td align="left">
				<span class="textLinkBold">
				<a href="#">Restaurant whose subscription is expiring (in the next n days)</a></span></td>
              </tr>
              <tr>
                <td height="35" align="center"><a href="#"><img src="images/icon_report.gif" alt="" width="30" height="25" border="0"></a></td>
                <td align="left">
				<span class="textLinkBold">
				<a href="#">Restaurant that have not submitted specials for the day</a></span></td>
              </tr>
              </logic:equal>
              <logic:equal name="userPreferences" property="userTypeAgent" value="true">
              <tr>
                <td height="35" align="center"><a href="#"><img src="images/icon_report.gif" alt="" width="30" height="25" border="0"></a></td>
                <td align="left">
				<span class="textLinkBold">
				<a href="#">My Commission report</a></span></td>
              </tr>
              <tr>
                <td height="35" align="center"><a href="#"><img src="images/icon_report.gif" alt="" width="30" height="25" border="0"></a></td>
                <td align="left">
				<span class="textLinkBold">
				<a href="#">Restaurant with subscription is expiring (in the next n days)</a></span></td>
              </tr>
              <tr>
                <td height="35" align="center"><a href="#"><img src="images/icon_report.gif" alt="" width="30" height="25" border="0"></a></td>
                <td align="left">
				<span class="textLinkBold">
				<a href="#">Restaurant that have not submitted specials for the day</a></span></td>
              </tr>
              </logic:equal>
            </table></td>
          </tr>
          <tr>
            <td height="30" >&nbsp;</td>
          </tr>
        </table></td>
  </tr>
</table>
<%@ include file="footer.html" %>  
</body>
</html>