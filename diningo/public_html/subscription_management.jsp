<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<html>
<head>
<title>DiningO - Restaurant Management</title>
<link href="main.css" rel="stylesheet" type="text/css"/>
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
<bean:define id="uri" name="RestaurantSubscriptionForm" property="uri" type="java.lang.String"/>
<bean:define id="row_count" name="RestaurantSubscriptionForm" property="row_count" type="java.lang.Integer"/>
<bean:define id="maxPageItems" name="RestaurantSubscriptionForm" property="maxPageItems" type="java.lang.Integer"/>
<pg:pager items="<%=row_count%>"
          url="<%=uri%>"
          maxPageItems="<%=maxPageItems%>" 
          scope="request" export="offset,currentPageNumber=pageNumber" isOffset="true">
<table width="900px" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="bdrLftClr_Lvl_2 bdrRgtClr_Lvl_2">
  <tr>
    <td height="90px" style="background-image: url(images/bar_top_tile90.gif)">
      <%@ include file="header.html" %>  
    </td>
  </tr>
  <tr>
    <td height="255" valign="top">
	  <table width="100%" border="0" cellspacing="1" cellpadding="1">
      <tr>
        <td width="76%" height="510" align="center" valign="top">
		  <table width="97%" border="0" cellspacing="1" cellpadding="1">
          <tr>
            <td class="textHeading12bold">&nbsp;</td>
          </tr>
          <tr>
            <td class="textHeading12bold">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <%@ include file="tab_rest_info.html" %>  
                <td width="3px" class="tabSpace">&nbsp;</td>
		<td width="95px" align="center" class="tabActive">Subscription</td>
                <%@ include file="tab_rest_user.html" %>  
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
           <td align="left">
            <html:form action="/RestaurantSubscriptionNewEditAction.do">
            <html:hidden property="hdnRestaurantTblPk"/>
            <html:hidden property="hdnRestaurantSubscriptionTblPk"/>
            <html:hidden property="uri"/>
            <html:hidden property="row_count"/>
            <html:hidden property="maxPageItems"/>
            <table width="50%" border="0" cellspacing="1" cellpadding="1">
            <tr>
            <td valign="top">
              <table width="100%" border="0" cellspacing="1" cellpadding="1">
              <tr>
              <td width="35%">
                <table width="100%" border="0" cellspacing="1" cellpadding="1">
                <tr>
                  <td width="30%" align="right"><span class="txtHighlight">*</span> Name:</td>
                  <td width="70%"><html:text property="txtName" style="width:200px" styleClass="txtBox" disabled="true"/></td>
                </tr>  
                <tr>
                  <td align="right"><span class="txtHighlight">*</span> Subscribe For:</td>
                  <td>
                   <html:select property="cboSubscription" styleClass="txtBox" style="width:100px">
                     <html:option value="">Subscription</html:option>
                     <html:optionsCollection name="SpecialsBean" property="specials" value="specials_tbl_pk" label="specials_name"/>
                   </html:select>
                  </td>
                </tr>
                <tr>
                  <td align="right"><span class="txtHighlight">*</span> From Date:</td>
                  <td><html:text property="txtFromDate" style="width:65px" styleClass="txtBox"/><span class="txtHighlightSml">&nbsp;YYYY/MM/DD</span></td>
                </tr>
                <tr>
                  <td align="right"><span class="txtHighlight">*</span> To Date:</td>
                  <td><html:text property="txtToDate" style="width:65px" styleClass="txtBox"/><span class="txtHighlightSml">&nbsp;YYYY/MM/DD</span></td>
                </tr>
                <tr>
                  <td align="right"><span class="txtHighlight">*</span>Fee: $</td>
                  <td><html:text property="txtSubscriptionFee" style="width:40px" styleClass="txtBox"/></td>
                </tr>
                </table>
              </td>
           </tr>
              </table>
            </td>
            </tr>
            <tr>
              <td height="70" align="left" ><html:submit>Save</html:submit>&nbsp;<html:reset>Reset</html:reset></td>
            </tr>

           </table>
           </html:form> 
           </td>
          </tr>
          <html:form action="/RestaurantSubscriptionDeleteAction.do">
          <tr>
            <td align="right">
             <%@ include file="pager.html" %>
            </td>
          </tr>
          <tr>
            <td height="50" align="left">
		<html:submit>Delete</html:submit>
            </td>
          </tr>
          <tr>
            <td valign="top" style="text-align:justify">
	      <table id="dataDynamic" width="100%" border="0" cellspacing="0" cellpadding="1" style="border:#CCCCCC 1px solid;">
              <tr>
                <th class="thBold bdr_TH_rgt bdr_TH_btm" width="2%">Select</th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="20%">From Date </th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="10%">To Date</th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="10%">Fee</th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="10%">Subscription For</th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="10%">Action</th>
              </tr>
              <logic:notEmpty name="RestaurantSubscriptionForm" property="restaurantSubscriptionList">
              <logic:iterate id="RestaurantSubscriptionBean" name="RestaurantSubscriptionForm" property="restaurantSubscriptionList" indexId="i">
              <pg:item>
              <tr class="tr_<%= i%2 + 1 %>">
                <td align="center">
                  <html:multibox property="selected">
                    <bean:write name="RestaurantSubscriptionBean" property="restaurant_subscription_tbl_pk"/>
                  </html:multibox>
                </td>
                <td><bean:write name="RestaurantSubscriptionBean" property="subscription_from"/></td>
                <td><bean:write name="RestaurantSubscriptionBean" property="subscription_to"/></td>
                <td><bean:write name="RestaurantSubscriptionBean" property="subscription_charges"  format="$#,000.00"/></td>
                <td><bean:write name="RestaurantSubscriptionBean" property="specials_name"/></td>
                <td><a href="RestaurantSubscriptionB4NewEditAction.do?restaurant_subscription_tbl_pk=<bean:write name="RestaurantSubscriptionBean" property="restaurant_subscription_tbl_pk"/>">Edit</a></td>
              </tr>
              </pg:item>
              </logic:iterate>
              </logic:notEmpty>
            </table>			
            </td>
          </tr>
          <tr>
            <td height="50" style="text-align:justify">
		<html:submit>Delete</html:submit>
          </tr>
          <tr>
            <td align="right"  class="bdrBtmClr_Lvl_2">
             <%@ include file="pager.html" %>
            </td>
          </tr>
          </html:form>
          <tr>
            <td valign="top" style="text-align:justify">&nbsp;</td>
          </tr>
        </table></td>
        </tr>
    </table></td>
  </tr>
</table>
</pg:pager>
<%@ include file="footer.html" %>  
</body>
</html>