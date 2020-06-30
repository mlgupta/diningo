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
function clearText(thefield){
if (thefield.defaultValue==thefield.value)
thefield.value = ""
}
//-->
</script>

</head>
<body onLoad="MM_preloadImages('images/btn_contactus_over.gif','images/btn_home_over.gif')">
<bean:define id="row_count" name="RestaurantSelectListForm" property="row_count" type="java.lang.Integer"/>
<bean:define id="uri" name="RestaurantSelectListForm" property="uri" type="java.lang.String"/>
<bean:define id="maxPageItems" name="RestaurantSelectListForm" property="maxPageItems" type="java.lang.Integer"/>
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
            <%@ include file="link_home_logout.html" %>  
          </tr>
          <logic:equal name="userPreferences" property="userTypeOwner" value="false" >
          <tr>
            <td height="50" style="text-align:justify">
              <html:form action="/RestaurantSelectListAction.do">
              <table border="0" cellspacing="1" cellpadding="0">
              <tr>
                <td width="100px" >
                  <html:text property="txtName" styleClass="txtBox" style="width:100px" onfocus="clearText(this)" value="Name"/>
                </td>
                <td width="90px">
                  <html:select property="cboCuisine" styleClass="txtBox">
                    <html:option value="">Select Cuisine</html:option>
                    <html:optionsCollection name="CuisineBean" property="cuisines" value="category_tbl_pk" label="category_name"/>
                  </html:select>
                </td>
                <td width="90px">
                  <html:select property="cboCity" styleClass="txtBox">
                    <html:option value="">Select City</html:option>
                    <html:optionsCollection name="CityBean" property="cities" value="city" label="city"/>
                  </html:select>
                </td>
                <td width="50px">
                   <html:select property="cboState" styleClass="txtBox" >
                     <html:option value="">ST</html:option>
                     <html:optionsCollection name="StateBean" property="states" value="state_tbl_pk" label="state_name"/>
                   </html:select>
                </td>
                <td width="45px"><html:text property="cboZipCode" styleClass="txtBox" style="width:50px" maxlength="5" onfocus="clearText(this)" value="Zip"/></td>
                <td width="90px">
                   <html:select property="cboSubscription" styleClass="txtBox" style="width:100px">
                     <html:option value="">Subscription</html:option>
                     <html:optionsCollection name="SpecialsBean" property="specials" value="specials_tbl_pk" label="specials_name"/>
                   </html:select>
                </td>
                <td valign="bottom"><html:submit alt="Search Restaurant" title="Search Restaurant" onclick="clearText(cboZipCode)">Search</html:submit></td>
              </tr>
            </table>
            </html:form>
            </td>
          </tr>
          </logic:equal>
          <html:form action="/RestaurantSelectedListAction.do">
          <tr>
            <td align="right">
             <%@ include file="pager.html" %>
            </td>
          </tr>
          <tr>
            <td height="50" align="left">
		<html:submit>Select</html:submit>
            </td>
          </tr>
          <tr>
            <td valign="top" style="text-align:justify">
	      <table id="dataDynamic" width="100%" border="0" cellspacing="0" cellpadding="1" style="border:#CCCCCC 1px solid;">
              <tr>
                <th class="thBold bdr_TH_rgt bdr_TH_btm" width="2%">Select</th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="2%"> ID </th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="20%"> Name </th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="8%">Phone</th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="10%">City</th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="3%">State</th>
              </tr>
              <logic:notEmpty name="RestaurantSelectListForm" property="restaurantList">
              <logic:iterate id="RestaurantBean" name="RestaurantSelectListForm" property="restaurantList" indexId="i">
              <pg:item>
              <tr class="tr_<%= i%2 + 1 %>">
                <td align="center">
                  <bean:define id="restaurant_tbl_pk">
                      <bean:write name="RestaurantBean" property="restaurant_tbl_pk"/>
                  </bean:define>
                  <html:radio property="selectedRestaurant" value="<%= restaurant_tbl_pk%>"/>
                </td>
                <td><bean:write name="RestaurantBean" property="restaurant_tbl_pk"/></td>
                <td><bean:write name="RestaurantBean" property="restaurant_name"/></td>
                <td><bean:write name="RestaurantBean" property="restaurant_phone"/></td>
                <td><bean:write name="RestaurantBean" property="restaurant_city"/></td>
                <td><bean:write name="RestaurantBean" property="restaurant_state"/></td>
              </tr>
              </pg:item>
              </logic:iterate>
              </logic:notEmpty>
            </table>			
            </td>
          </tr>
          <tr>
            <td height="50" style="text-align:justify">
		<html:submit>Select</html:submit>
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