<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<title>DiningO - Diner's Coupons</title>
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
            <td height="40" class="textHeading1">Active Coupons For Restaurant</td>
          </tr>
          <tr>
            <td height="200" valign="top" >
                <table width="100%" border="0" cellspacing="1" cellpadding="1">
                <tr>
                  <td width="78%" align="center">
                    <logic:notEmpty name="DinersCouponsForm" property="couponBean">
                    <logic:iterate id="RestaurantCouponsBean" name="DinersCouponsForm" property="couponBean">
		    <table id="coupon" width="97%" border="0" cellspacing="1" cellpadding="1" class="txtBoxDotted" style="margin-bottom:30px;">
                    <tr>
                      <td width="30%" height="194" align="center" valign="top" style="border-right:#FF6600 1px dotted;">
                        <table width="100%" border="0" cellpadding="1" cellspacing="1">
                        <tr>
                          <td align="center"><img src="images/logo_coupon.gif" alt="Coupon Logo"></td>
                        </tr>
                        <tr>
                          <td>&nbsp;</td>
                        </tr>
                        <tr>
                          <td height="18" align="center" class="textHeading2">
                          <bean:write name="DinersCouponsForm" property="txtRestaurantName"/>
                          </td>
                        </tr>
                        <tr>
                          <td align="center">
                            <bean:write name="DinersCouponsForm" property="txtAddress1"/><br>
                            <logic:notEmpty name="DinersCouponsForm" property="txtAddress2">
                              <bean:write name="DinersCouponsForm" property="txtAddress2"/><br>
                            </logic:notEmpty>
                            <bean:write name="DinersCouponsForm" property="txtCity"/>, <bean:write name="DinersCouponsForm" property="txtState"/> <bean:write name="DinersCouponsForm" property="txtZipcode"/><br>
                          </td>
                        </tr>
                        <tr>
                          <td height="30" align="center"><span class="txtHighlight">Phone:</span><bean:write name="DinersCouponsForm" property="txtRestaurantPhone"/></td>
                        </tr>
                        <tr>
                         <td height="30" align="center"> 
                          <span class="txtHighlight">Expires:</span> <bean:write name="RestaurantCouponsBean" property="coupon_to_eff_date"/>
                         </td>
                        </tr>
                        </table></td>
                      <td width="70%" align="center" valign="top">
                       <table width="97%" align="center" border="0" cellspacing="1" cellpadding="1">
                       <tr>
                         <td align="center" class="couponHeading1">
                           <bean:write name="RestaurantCouponsBean" property="coupon_name" filter="false"/>
                       </td>
                       </tr>
                       <tr>
                         <td>&nbsp;</td>
                       </tr>
                       <tr>
                        <td align="left">
                          <bean:write name="RestaurantCouponsBean" property="coupon_description" filter="false"/>
                        </td>
                       </tr>
                       </table>
                      </td>
                    </tr>
                    <tr>
                      <td height="40" colspan="2" align="center" style="border-top:#FF6600 1px dotted;">
			<a href="DinersCouponsPrintAction.do?restaurant_coupons_tbl_pk=<bean:write name="RestaurantCouponsBean" property="restaurant_coupons_tbl_pk"/>" onClick="window.open('DinersCouponsPrintAction.do?restaurant_coupons_tbl_pk=<bean:write name="RestaurantCouponsBean" property="restaurant_coupons_tbl_pk"/>','Coupon','toolbar=no, directories=no, location=no, status=no, menubar=yes, resizable=no, scrollbars=no, width=675, height=225'); return false"><img src="images/btn_print_coupon.gif" alt="Print This Coupon" title="Print This Coupon" width="108" height="27" border="0"></a></td>
                    </tr>
                    </table>				  
                    </logic:iterate>
                    </logic:notEmpty>
                    <logic:empty name="DinersCouponsForm" property="couponBean">
                      No active coupons for this restaurant. Try again later.
                    </logic:empty>
                  </td>
                </tr>
                </table>
             </td>
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