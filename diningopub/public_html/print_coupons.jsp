<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <title>Print Coupons</title>
  <link href="main.css" rel="stylesheet" type="text/css" />
</head>
<body>
   <table id="coupon" width="664" border="0" align="center" cellspacing="1" cellpadding="1" class="txtBoxDotted" style="margin-bottom:30px;">
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
               <bean:write name="PrintCouponForm" property="txtRestaurantName"/>
             </td>
          </tr>
          <tr>
            <td align="center">
             <bean:write name="PrintCouponForm" property="txtAddress1"/><br>
             <logic:notEmpty name="PrintCouponForm" property="txtAddress2">
               <bean:write name="PrintCouponForm" property="txtAddress2"/><br>
             </logic:notEmpty>
             <bean:write name="PrintCouponForm" property="txtCity"/>, <bean:write name="PrintCouponForm" property="txtState"/> - <bean:write name="PrintCouponForm" property="txtZipcode"/><br>
            </td>
          </tr>
          <tr>
             <td height="30" align="center"><span class="txtHighlight">Phone:</span><bean:write name="PrintCouponForm" property="txtRestaurantPhone"/></td>
          </tr>
          <tr>
            <td align="center" valign="bottom">
              <span class="txtHighlight">Expires:</span> <bean:write name="PrintCouponForm" property="coupon_to_eff_date"/>
            </td>
          </tr>
         </table>
       </td>
       <td width="70%" align="center" valign="top">
        <table width="97%" align="center" border="0" cellspacing="1" cellpadding="1">
        <tr>
         <td align="center" class="couponHeading1">
           <bean:write name="PrintCouponForm" property="coupon_name" filter="false"/>
         </td>
        </tr>
        <tr>
          <td>&nbsp;</td>
        </tr>
        <tr>
         <td align="left">
           <bean:write name="PrintCouponForm" property="coupon_description" filter="false"/>
         </td>
        </tr>
        </table>
       </td>
    </tr>
    <tr>
     <td style="border-right:#FF6600 1px dotted;"><b>www.DininGo.com</b>
     </td>
     <td align="right" valign="top"><b>Coupon valid only at this location.</b>
     </td>
    </tr>
   </table>
</body>
</html>