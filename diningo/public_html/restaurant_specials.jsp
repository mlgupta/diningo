<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<title>DiningO - Restaurant Breakfast Specials</title>
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
            <td colspan="2" class="textHeading12bold">&nbsp;</td>
          </tr>
          <tr>
            <td colspan="2" class="textHeading12bold">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <%@ include file="tab_rest_info.html" %>  
                <%@ include file="tab_rest_subs.html" %>
                <%@ include file="tab_rest_user.html" %>  
                <logic:equal name="RestaurantSpecialsForm" property="hdnSpecialsType" value="BREAKFAST" >
		  <td width="3px" class="tabSpace">&nbsp;</td>
		  <td width="60px" align="center" class="tabActive">B'fast</td>
                  <%@ include file="tab_rest_lunch.html" %>  
                  <%@ include file="tab_rest_hh.html" %>  
                  <%@ include file="tab_rest_dinner.html" %>  
                </logic:equal>
                <logic:equal name="RestaurantSpecialsForm" property="hdnSpecialsType" value="LUNCH" >
                  <%@ include file="tab_rest_bfast.html" %>  
		  <td width="3px" class="tabSpace">&nbsp;</td>
		  <td width="60px" align="center" class="tabActive">Lunch</td>
                  <%@ include file="tab_rest_hh.html" %>  
                  <%@ include file="tab_rest_dinner.html" %>  
                </logic:equal>
                <logic:equal name="RestaurantSpecialsForm" property="hdnSpecialsType" value="HAPPYHOUR" >
                  <%@ include file="tab_rest_bfast.html" %>  
                  <%@ include file="tab_rest_lunch.html" %>  
		  <td width="3px" class="tabSpace">&nbsp;</td>
		  <td width="60px" align="center" class="tabActive">Hpy Hr</td>
                  <%@ include file="tab_rest_dinner.html" %>  
                </logic:equal>
                <logic:equal name="RestaurantSpecialsForm" property="hdnSpecialsType" value="DINNER" >
                  <%@ include file="tab_rest_bfast.html" %>  
                  <%@ include file="tab_rest_lunch.html" %>  
                  <%@ include file="tab_rest_hh.html" %>  
		  <td width="3px" class="tabSpace">&nbsp;</td>
		  <td width="60px" align="center" class="tabActive">Dinner</td>
                </logic:equal>
                <%@ include file="tab_rest_coupons.html" %>  
                <%@ include file="tab_rest_events.html" %>  
                <%@ include file="link_home_logout.html" %>  
              </tr>
            </table></td>
          </tr>
          <tr>
            <td height="30" colspan="2" class="textHeading12bold">&nbsp;<html:errors/></td>
          </tr>
          <html:form action="/SpecialsAction.do">
          <html:hidden property="hdnRestaurantTblPk"/>
          <html:hidden property="hdnSpecialsType"/>
          <tr>
            <td colspan="2" valign="top"><table width="100%" border="0" cellspacing="1" cellpadding="1">
              <tr>
                <td width="76%" valign="top">
		  <table id="PreviewArea" width="97%" border="0" cellspacing="1" cellpadding="1" class="txtBoxThick">
                  <tr>
                    <td width="30%" height="194" align="center" style="border-right:#FF6600 1px dotted;">
                        <table width="100%" border="0" cellpadding="1" cellspacing="1">
                        <tr>
                          <td height="18" align="center" class="textHeading2">
                          <bean:write name="RestaurantSpecialsForm" property="txtRestaurantName"/>
                          </td>
                        </tr>
                        <tr>
                          <td align="center">
                            <bean:write name="RestaurantSpecialsForm" property="txtAddress1"/><br>
                            <logic:notEmpty name="RestaurantSpecialsForm" property="txtAddress2">
                              <bean:write name="RestaurantSpecialsForm" property="txtAddress2"/><br>
                            </logic:notEmpty>
                            <bean:write name="RestaurantSpecialsForm" property="txtCity"/>, <bean:write name="RestaurantSpecialsForm" property="txtState"/> <bean:write name="RestaurantSpecialsForm" property="txtZipcode"/><br>
                          </td>
                        </tr>
                        <tr>
                          <td height="30" align="center"><span class="txtHighlight">Phone:</span><bean:write name="RestaurantSpecialsForm" property="txtRestaurantPhone"/></td>
                        </tr>
                    </table></td>
                    <td width="70%">
                       <table width="97%" align="center" border="0" cellspacing="1" cellpadding="1">
                       <tr>
                        <td align="justify">
                          <bean:write name="RestaurantSpecialsForm" property="txtFormattedSpecialsMenu" filter="false"/>
                        </td>
                       </tr>
                       </table>
                    </td>
                  </tr>
                  <tr>
                    <td height="22" colspan="2" align="center" style="border-top:#FF6600 1px dotted;">
                      <logic:notEmpty name="RestaurantSpecialsForm" property="txtMenuUrl">
                        <span class="textLinkNormal"><a href="<bean:write name="RestaurantSpecialsForm" property="txtMenuUrl"/>" target="_blank">Menu</a></span> | 
                      </logic:notEmpty>  
                        <span class="textLinkNormal"><a href="http://www.diningo.com/diningopub/DinersCouponsListAction.do?restaurant_tbl_pk=<bean:write name="RestaurantSpecialsForm" property="hdnRestaurantTblPk"/>" target="_blank">Coupons</a></span> | 
                      <logic:notEmpty name="RestaurantSpecialsForm" property="txtWebsite">
                        <span class="textLinkNormal"><a href="<bean:write name="RestaurantSpecialsForm" property="txtWebsite"/>" target="_blank">Website</a></span> | 
                      </logic:notEmpty>  
                      <logic:notEmpty name="RestaurantSpecialsForm" property="txtEntertainmentUrl">
                        <span class="textLinkNormal"><a href="<bean:write name="RestaurantSpecialsForm" property="txtEntertainmentUrl"/>" target="_blank">Entertainment</a></span> | 
                      </logic:notEmpty>  
                      <logic:notEmpty name="RestaurantSpecialsForm" property="txtMapUrl">
                        <span class="textLinkNormal"><a href="<bean:write name="RestaurantSpecialsForm" property="txtMapUrl"/>" target="_blank">Map</a></span> 
                      </logic:notEmpty>  
                    </td>
                  </tr>
                </table></td>
                <td width="24%" align="center" valign="top">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td height="40" colspan="2">&nbsp;</td>
          </tr>
          <tr>
            <td height="30" colspan="2" class="bdrBtmClr_Lvl_2" align="left">
              <span class="textHeading3"> 
                <logic:equal name="RestaurantSpecialsForm" property="hdnSpecialsType" value="BREAKFAST" >
                  Breakfast Specials
                </logic:equal>
                <logic:equal name="RestaurantSpecialsForm" property="hdnSpecialsType" value="LUNCH" >
                  Lunch Specials
                </logic:equal>
                <logic:equal name="RestaurantSpecialsForm" property="hdnSpecialsType" value="HAPPYHOUR" >
                  Happy Hour Specials
                </logic:equal>
                <logic:equal name="RestaurantSpecialsForm" property="hdnSpecialsType" value="DINNER" >
                  Dinner Specials
                </logic:equal>
              </span>
            </td>
          </tr>
          <tr>
            <td width="64%" align="left">
              <table border="0" cellspacing="1" cellpadding="1" style="margin-top:15px">
              <tr>
                <td width="75" align="right">Date:</td>
                <td><html:text property="txtSpecialsDate" style="width:120px" styleClass="txtBox"/><span class="txtHighlightSml"> YYYY/MM/DD </span></td>
                <td><html:submit property="method"><bean:message key="button.save"/></html:submit></td>
              </tr>
              <tr>
                <td align="right">Default Day:</td>
                <td>
                  <html:select property="cboTemplateTblPk" styleClass="txtBox">
                    <option value="">-- Select Default Day -- </option>
                    <html:optionsCollection name="RestaurantSpecialsForm" property="templateList" value="template_specials_name" label="template_specials_name"/>
                  </html:select>
                </td>
                <td><html:submit property="method"><bean:message key="button.save_as_default"/></html:submit></td>
              </tr>
              <tr>
                <td align="right" valign="top"><span class="txtHighlight">*</span>Menu</td>
                <td colspan=2><html:textarea property="txtSpecialsMenu" rows="8" cols="80" styleClass="txtBox" style="width:425px"/></td>
              </tr>
            </table>
              <table border="0" cellspacing="1" cellpadding="1" style="margin-top:15px">
                <tr>
                <td height="40">
                    <html:submit property="method"><bean:message key="button.preview"/></html:submit>
                    <html:cancel><bean:message key="button.cancel"/></html:cancel>
<!--                    
                    <html:submit property="method"><bean:message key="button.cancel"/></html:submit>
-->                    
		</td>
                </tr>
              </table></td>
            <td width="36%" align="center" valign="top" >
              <table id="calendar" width="300px" border="0" cellspacing="1" cellpadding="1" class="myTbl" style="margin-top:20px">
              <tr>
                <td align="center"><html:submit property="method"><bean:message key="button.prev"/></html:submit></td>
                <td colspan="5" align="center"><span class="textHeading1"><bean:write name="RestaurantSpecialsForm" property="txtCalMonth"/></span></td>
                <td align="center"><html:submit property="method"><bean:message key="button.next"/></html:submit></td>
              </tr>
              <tr>
                <th width="14%" align="center" style="font-size:14px;">Sun</th>
                <th width="14%" align="center" style="font-size:14px;">Mon</th>
                <th width="14%" align="center" style="font-size:14px;">Tue</th>
                <th width="14%" align="center" style="font-size:14px;">Wed</th>
                <th width="14%" align="center" style="font-size:14px;">Thu</th>
                <th width="14%" align="center" style="font-size:14px;">Fri</th>
                <th width="14%" align="center" style="font-size:14px;">Sat</th>
              </tr>
              <bean:define id="rowChange" value="</tr><tr>"/>
              <tr>
              <logic:iterate id="RestaurantSpecialsBean" name="RestaurantSpecialsForm" property="restaurantSpecialsList" indexId="i">
                <bean:define id="indexId_mod_7">
                  <%= i%7 %>
                </bean:define>
                <logic:equal name="indexId_mod_7" value="0">
                </tr><tr>
                </logic:equal>
                <logic:notEmpty name="RestaurantSpecialsBean" property="day_of_month">
                 <logic:notEmpty name="RestaurantSpecialsBean" property="specials_menu">
                   <td height="40" align="center" class="calendarActive" style="cursor:pointer" onClick="location='SpecialsB4Action.do?Action=date_edit&param1=<bean:write name="RestaurantSpecialsBean" property="day_of_month"/>&param2=<bean:write name="RestaurantSpecialsBean" property="restaurant_daily_specials_tbl_pk"/>'">
                    <bean:write name="RestaurantSpecialsBean" property="day_of_month"/>
                   </td>
                 </logic:notEmpty>
                 <logic:empty name="RestaurantSpecialsBean" property="specials_menu">
                   <td height="40" align="center" style="cursor:pointer" onClick="location='SpecialsB4Action.do?Action=date_edit&param1=<bean:write name="RestaurantSpecialsBean" property="day_of_month"/>'">
                    <bean:write name="RestaurantSpecialsBean" property="day_of_month"/>
                   </td>
                 </logic:empty>
                 </logic:notEmpty>
                 <logic:empty name="RestaurantSpecialsBean" property="day_of_month">
                   <td height="40" align="center">&nbsp;</td>
                 </logic:empty>
              </logic:iterate>  
              </tr>
            </table></td>
          </tr>
          <tr>
            <td colspan="2" >&nbsp;</td>
          </tr>
          <tr>
            <td colspan="2" class="textHeading3" align="left">Defaults for weekdays:</td>
          </tr>
          <tr>
            <td colspan="2" >
		<table width="865" border="0" cellspacing="0" cellpadding="1" style="border:#CCCCCC 1px solid;">
              <tr>
                <th width="10%" class="thBold bdr_TH_rgt bdr_TH_btm" align="left" style="font-size:14px;">&nbsp;Name</th>
                <th width="85%" class="thBold bdr_TH_rgt bdr_TH_btm" align="left" style="font-size:14px;">&nbsp;Default Specials Menu</th>
                <th width="5%" class="thBold bdr_TH_lft bdr_TH_btm" align="left" style="font-size:14px;">&nbsp;Action</th>
              </tr>
              <logic:iterate id="TemplateBean" name="RestaurantSpecialsForm" property="templateList" indexId="i">
              <tr class="tr_<%= i%2 + 1 %>">
                <td align="left">
                  <bean:write name="TemplateBean" property="template_specials_name"/>
                </td>
                <td align="left">
                  <bean:write name="TemplateBean" property="template_specials_menu"/>
                </td>
                <td align="center">
                  <a href="SpecialsB4Action.do?Action=template_edit&param1=<bean:write name="TemplateBean" property="template_tbl_pk"/>">Edit</a>
                </td>
              </tr>
              </logic:iterate>
            </table></td>
          </tr>
          <tr>
            <td height="30" colspan="2" >&nbsp;</td>
          </tr>
          </html:form>
        </table></td>
  </tr>
</table>
<%@ include file="footer.html" %>  
</body>
</html>