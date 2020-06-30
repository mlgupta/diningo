<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<html>
<head>
<title>DiningO - Restaurant Search</title>
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
<bean:define id="row_count" name="RestaurantSearchForm" property="row_count" type="java.lang.Integer"/>
<bean:define id="uri" name="RestaurantSearchForm" property="uri" type="java.lang.String"/>
<bean:define id="maxPageItems" name="RestaurantSearchForm" property="maxPageItems" type="java.lang.Integer"/>
<pg:pager items="<%=row_count%>"
          url="<%=uri%>"
          maxPageItems="<%=maxPageItems%>" 
          scope="request" export="offset,currentPageNumber=pageNumber" isOffset="true">
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
        <td width="76%" align="center" valign="top">
          <html:form action="/RestaurantSearchListAction.do">
          <html:hidden property="uri"/>
          <html:hidden property="row_count"/>
          <html:hidden property="maxPageItems"/>
          <table width="97%" border="0" cellspacing="1" cellpadding="1">
          <tr>
            <td align="left" height="30" class="textHeading1">Find  Restaurants in Your Neighborhood!</td>
          </tr>
          <tr>
            <td height="70" style="text-align:justify"  class="bdrBtmClr_Lvl_2">
              <table width="100%" align="center" border="0" cellpadding="3" cellspacing="1" style="margin-top:5px; margin-bottom:50px; margin:2px" class="txtBoxThick">
              <tr>
                <td width="90%">
                  <table border="0" cellpadding="3" cellspacing="1">
                  <tr>
                    <td align="right" class="textHeading4">Find: </td>
                    <td align="justify">
                      <html:select property="cboCuisine" styleClass="txtBox1">
                        <html:option value="">All Cuisines</html:option>
                        <html:optionsCollection name="CuisineBean" property="cuisines" value="category_tbl_pk" label="category_name"/>
                      </html:select>
                      <span class="textHeading4">&nbsp; in &nbsp;</span>
                      <html:select property="cboCity" styleClass="txtBox1">
                        <html:option value="">All Cities</html:option>
                        <html:optionsCollection name="CityBean" property="cities" value="city" label="city"/>
                      </html:select>
                      &nbsp;
                      <html:select property="cboState" styleClass="txtBox1" >
                        <html:option value="">ST</html:option>
                        <html:optionsCollection name="StateBean" property="states" value="state_tbl_pk" label="state_name"/>
                      </html:select>
                      &nbsp;
                      <html:text property="cboZipCode" styleClass="txtBox1" style="width:45px" maxlength="5" onfocus="clearText(this)" value=" Zip"/>
                    </td>
                  </tr>  
                  <tr>
                    <td align="right" class="textHeading4">Name: </td>
                    <td align="justify">
                      <html:text property="txtName" styleClass="txtBox1" style="width:100px" onfocus="clearText(this)" value=" All Restaurant"/>
                    </td>
                  </tr>
                  </table>
                </td>
                <td width="10%" valign="top">
                  <table border="0" cellpadding="3" cellspacing="1">
                  <tr>
                    <td align="right" class="textHeading4">
                      <html:submit styleClass="button_search" alt="Search Restaurant" title="Search Restaurant" onclick="clearText(cboZipCode)">&nbsp;</html:submit>
                    </td>
                  </tr>
                  </table>
                </td>
              </tr>  
              </table>
            </td>
          </tr>
          <tr>
            <td align="right">
                <%@ include file="pager.html" %>
	    </td>
          </tr>
	  <tr>
          <td align="center">
            <logic:notEmpty name="RestaurantSearchForm" property="restaurantSearchList">
            <logic:iterate id="RestaurantSearchBean" name="RestaurantSearchForm" property="restaurantSearchList" indexId="i">
            <pg:item>
	    <table width="97%" border="0" cellspacing="1" cellpadding="1" class="txtBoxThick" style="margin:10px;">
            <tr>
              <td width="30%" align="center" style="border-right:#FF6600 1px dotted;">
                <table width="100%" border="0" cellpadding="1" cellspacing="1">
                <tr>
                  <td height="18" align="center" class="textHeading2">
                    <bean:write name="RestaurantSearchBean" property="txtRestaurantName"/>
                  </td>
                </tr>
                <tr>
                  <td align="center">
                     <bean:write name="RestaurantSearchBean" property="txtAddress1"/><br>
                     <logic:notEmpty name="RestaurantSearchBean" property="txtAddress2">
                       <bean:write name="RestaurantSearchBean" property="txtAddress2"/><br>
                     </logic:notEmpty>
                     <bean:write name="RestaurantSearchBean" property="txtCity"/>, <bean:write name="RestaurantSearchBean" property="txtState"/> - <bean:write name="RestaurantSearchBean" property="txtZipcode"/><br>
                  </td>
                </tr>
                <tr>
                  <td height="30" align="center"><span class="txtHighlight">Phone:</span><bean:write name="RestaurantSearchBean" property="txtRestaurantPhone"/></td>
                </tr>
              </table></td>
              <td width="70%" align="center">
                <table width="97%" align="center" border="0" cellspacing="1" cellpadding="1">
                <tr>
                  <td align="left">
                    <bean:write name="RestaurantSearchBean" property="txtFormattedSpecialsMenu" filter="false"/>
                  </td>
                </tr>
                </table>
              </td>
            </tr>
            <tr>
              <td height="22" colspan="2" align="center" style="border-top:#FF6600 1px dotted;">
                <logic:notEmpty name="RestaurantSearchBean" property="txtMenuUrl">
                  <span class="textLinkNormal"><a href="<bean:write name="RestaurantSearchBean" property="txtMenuUrl"/>" target="_blank">Menu</a></span> | 
                </logic:notEmpty>  
                <span class="textLinkNormal"><a href="DinersCouponsListAction.do?restaurant_tbl_pk=<bean:write name="RestaurantSearchBean" property="hdnRestaurantTblPk"/>" target="_blank">Coupons</a></span> | 
                <logic:notEmpty name="RestaurantSearchBean" property="txtWebsite">
                  <span class="textLinkNormal"><a href="<bean:write name="RestaurantSearchBean" property="txtWebsite"/>" target="_blank">Website</a></span> | 
                </logic:notEmpty>  
                <span class="textLinkNormal"><a href="DinersEventsListAction.do?restaurant_tbl_pk=<bean:write name="RestaurantSearchBean" property="hdnRestaurantTblPk"/>" target="_blank">Entertainment</a></span> | 
                <logic:notEmpty name="RestaurantSearchBean" property="txtMapUrl">
                  <span class="textLinkNormal"><a href="<bean:write name="RestaurantSearchBean" property="txtMapUrl"/>" target="_blank">Map</a></span> 
                </logic:notEmpty>  
              </td>
            </tr>
            </table>
            </pg:item>
            </logic:iterate>
            </logic:notEmpty>
            <logic:empty  name="RestaurantSearchForm" property="restaurantSearchList">
             No restaurant found that meets your search criteria...
            </logic:empty>
          </td>
          </tr>
          <tr>
            <td align="right">
             <%@ include file="pager.html" %>
            </td>
          </tr>
	  <tr>
            <td valign="top" style="text-align:justify">&nbsp;</td>
          </tr>
        </table>
        </html:form>
        </td>
        <td width="24%" align="center" valign="top">
          <table width="100%" border="0" cellspacing="1" cellpadding="1">
          <tr>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td height="630px" align="center" valign="top" class="bdrLftClr_Lvl_2">
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
<%@ include file="footer.html" %>  
</pg:pager>
</body>
</html>