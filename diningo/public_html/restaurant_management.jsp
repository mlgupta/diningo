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
//-->
</script>

</head>
<body onLoad="MM_preloadImages('images/btn_contactus_over.gif','images/btn_home_over.gif')">
<bean:define id="uri" name="RestaurantListForm" property="uri" type="java.lang.String"/>
<bean:define id="row_count" name="RestaurantListForm" property="row_count" type="java.lang.Integer"/>
<bean:define id="maxPageItems" name="RestaurantListForm" property="maxPageItems" type="java.lang.Integer"/>
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
            <td class="textHeading12bold">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
		<td height="25px" width="5px" class="tabSpace">&nbsp;</td>
		<td width="180px" align="center" class="tabActive">Restaurant Management</td>
                <%@ include file="link_home_logout.html" %>  
              </tr>
            </table></td>
          </tr>
          <tr>
            <td class="textHeading12bold"  align="left">&nbsp;<html:errors/></td>
          </tr>
          <tr>
           <td>
            <html:form action="/RestaurantNewEditAction.do">
            <html:hidden property="hdnRestaurantTblPk"/>
            <html:hidden property="hdnContact1_restaurant_contact_people_tbl_pk"/>
            <html:hidden property="hdnContact2_restaurant_contact_people_tbl_pk"/>
            <html:hidden property="hdnContact3_restaurant_contact_people_tbl_pk"/>
            <html:hidden property="hdnContact4_restaurant_contact_people_tbl_pk"/>
            <html:hidden property="hdnRestaurant_category_tbl_pk"/>
            <html:hidden property="uri"/>
            <html:hidden property="row_count"/>
            <html:hidden property="maxPageItems"/>
            <table width="100%" border="0" cellspacing="1" cellpadding="1">
            <tr>
            <td align="center" valign="top">
              <table width="100%" border="0" cellspacing="1" cellpadding="1">
              <tr>
              <td width="38%">
                <table width="100%" border="0" cellspacing="1" cellpadding="1">
                <tr>
                  <td width="30%" align="right"><span class="txtHighlight">*</span> Name:</td>
                  <td width="70%" align="left"><html:text property="txtName" style="width:200px" styleClass="txtBox"/></td>
                </tr>  
                <tr>
                  <td align="right"><span class="txtHighlight">*</span> Address 1:</td>
                  <td align="left"><html:text property="txtAddress1" style="width:200px" styleClass="txtBox"/></td>
                </tr>
                <tr>
                  <td align="right">Address 2:</td>
                  <td align="left"><html:text property="txtAddress2" style="width:200px" styleClass="txtBox"/></td>
                </tr>
                <tr>
                  <td align="right"><span class="txtHighlight">*</span> City:</td>
                  <td align="left"><html:text property="txtCity" style="width:200px" styleClass="txtBox"/></td>
                </tr>
                <tr>
                  <td align="right"><span class="txtHighlight">*</span> State:</td>
                  <td align="left">
                     <html:select property="txtStateTblFk" styleClass="txtBox" >
                       <html:optionsCollection name="StateBean" property="states" value="state_tbl_pk" label="state_name"/>
                     </html:select>
                  </td>
                </tr>
                <tr>
                  <td align="right"><span class="txtHighlight">*</span> Zip:</td>
                  <td align="left"><html:text property="txtZipcode" styleClass="txtBox"  size="10" maxlength="10"/></td>
                </tr>
                <tr>
                  <td align="right"><span class="txtHighlight">*</span> Phone No.:</td>
                  <td align="left"><html:text property="txtPhoneNo" styleClass="txtBox" style="width:110px" maxlength="14"/><span class="txtHighlightSml"> XXX-XXX-XXXX</span></td>
                </tr>
                <tr>
                  <td align="right">Fax:</td>
                  <td align="left"><html:text property="txtFaxNo" styleClass="txtBox" style="width:110px"/><span class="txtHighlightSml"> XXX-XXX-XXXX</span></td>
                </tr>
                </table>
              </td>
              <td width="62%"  valign="top">
                <table width="100%" border="0" cellspacing="1" cellpadding="1">
                <tr>
                  <td width="25%" align="right"><span class="txtHighlight">*</span>Agent:</td>
                  <td width="75%"  align="left">
                    <html:select property="txtUserTblFk" styleClass="txtBox">
                    <html:optionsCollection name="AgentBean" property="agents" value="user_tbl_pk" label="user_name"/>
                  </html:select>
                  </td>
                </tr>  
                <tr>
                  <td align="right">Website:</td>
                  <td align="left"><html:text property="txtWebsite" style="width:350px" styleClass="txtBox"/></td>
                </tr>
                <tr>
                  <td align="right">Menu URL:</td>
                  <td align="left"><html:text property="txtMenuUrl" style="width:350px" styleClass="txtBox"/></td>
                </tr>
                <tr>
                  <td align="right">Entertainment URL:</td>
                  <td align="left"><html:text property="txtEntertainmentUrl" style="width:350px" styleClass="txtBox"/></td>
                </tr>
                <tr>
                  <td align="right">Video URL:</td>
                  <td align="left"><html:text property="txtVideoUrl" style="width:350px" styleClass="txtBox"/></td>
                </tr>
                <tr>
                   <td align="right">Map URL:</td>
                   <td align="left"><html:text property="txtMapUrl" style="width:350px" styleClass="txtBox"/></td>
                </tr>
                <tr>
                  <td align="right"> Metro:</td>
                  <td align="left">
                     <html:select property="txtMetroArea" styleClass="txtBox" >
                       <option value=""></option>
                       <html:optionsCollection name="metroBean" property="metros" value="metro_area_tbl_pk" label="metro_area_name"/>
                     </html:select>
                  </td>
                </tr>
                <tr>
                  <td align="right">&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
               </table>
             </td>
           </tr>
              </table>
            </td>
            </tr>
           <tr>
            <td align="left" valign="top">
              <table width="100%" border="0" cellspacing="1" cellpadding="1" style="margin-top:20px">
                <tr>
                  <td>
                     <table width="40%" border="0" cellspacing="1" cellpadding="1">
                     <tr>
                      <td width="30%" align="center" valign="top">
			<table border="0" cellpadding="1" cellspacing="1">
                        <tr>
                          <th align="center"></th>
                          <th align="center">Contact</th>
                          <th align="center">Phone</th>
                          <th align="center">Email</th>
                        </tr>
                        <tr>
                          <td width="20">1.</td>
                          <td width="120"><html:text property="txtContact1_name" styleClass="txtBox" style="width:120px"/></td>
                          <td width="120"><html:text property="txtContact1_phone" styleClass="txtBox" style="width:110px"/></td>
                          <td width="120"><html:text property="txtContact1_email" style="width:170px" styleClass="txtBox"/></td>
                        </tr>
                        <tr>
                          <td width="20">2.</td>
                          <td><html:text property="txtContact2_name" styleClass="txtBox" style="width:120px"/></td>
                          <td><html:text property="txtContact2_phone" styleClass="txtBox" style="width:110px"/></td>
                          <td><html:text property="txtContact2_email" style="width:170px" styleClass="txtBox"/></td>
                        </tr>
                        <tr>
                          <td width="20">3.</td>
                          <td><html:text property="txtContact3_name" styleClass="txtBox" style="width:120px"/></td>
                          <td><html:text property="txtContact3_phone" styleClass="txtBox" style="width:110px"/></td>
                          <td><html:text property="txtContact3_email" style="width:170px" styleClass="txtBox"/></td>
                        </tr>
                        <tr>
                          <td width="20">4.</td>
                          <td><html:text property="txtContact4_name" styleClass="txtBox" style="width:120px"/></td>
                          <td><html:text property="txtContact4_phone" styleClass="txtBox" style="width:110px"/></td>
                          <td><html:text property="txtContact4_email" style="width:170px" styleClass="txtBox"/></td>
                        </tr>
                        </table>
                      </td>
                      <td width="10%" align="left" valign="top">
		       <table border="0" cellspacing="1" cellpadding="1">
                          <tr>
                             <th align="center">Cuisine</th>
                         </tr>
                          <tr>
                            <td valign="top">
                              <html:select property="selected_cuisine" multiple="true" size="5" styleClass="txtBox">
                                <html:optionsCollection name="CuisineBean" property="cuisines" value="category_tbl_pk" label="category_name"/>
                              </html:select>
                            </td>
                          </tr>
                       </table>
                      </td>
                     </tr>
                     </table>
                   </td>  
                </tr>
                <tr>
                  <td height="70" align="left" >
			<html:submit>Save</html:submit>
                        <html:reset>Reset</html:reset>
                  </td>
                </tr>
                <tr>
                  <td align="right"  class="bdrBtmClr_Lvl_2">&nbsp;</td>
                </tr>
             </table>
           </td>
           </tr>
           </table>
           </html:form> 
           </td>
          </tr>
          <tr>
            <td height="50" style="text-align:justify">
              <html:form action="/RestaurantListAction.do">
              <table border="0" cellspacing="1" cellpadding="0">
              <tr>
                <td width="120px">
                  <html:select property="cboCuisine" styleClass="txtBox">
                    <html:option value="">Select Cuisine</html:option>
                    <html:optionsCollection name="CuisineBean" property="cuisines" value="category_tbl_pk" label="category_name"/>
                  </html:select>
                </td>
                <td width="95px">
                  <html:select property="cboCity" styleClass="txtBox">
                    <html:option value="">Select City</html:option>
                    <html:optionsCollection name="CityBean" property="cities" value="city" label="city"/>
                  </html:select>
                </td>
                <td width="52px">
                   <html:select property="cboState" styleClass="txtBox" >
                     <html:option value="">ST</html:option>
                     <html:optionsCollection name="StateBean" property="states" value="state_tbl_pk" label="state_name"/>
                   </html:select>
                </td>
                <td width="52px"><html:text property="cboZipCode" styleClass="txtBox" style="width:50px" maxlength="6"/></td>
                <td width="110px">
                   <html:select property="cboSubscription" styleClass="txtBox" style="width:100px">
                     <html:option value="">Subscription</html:option>
                     <html:optionsCollection name="SpecialsBean" property="specials" value="specials_tbl_pk" label="specials_name"/>
                   </html:select>
                </td>
                <td valign="bottom"><html:submit>Search</html:submit></td>
              </tr>
            </table>
            </html:form>
            </td>
          </tr>
          <html:form action="/RestaurantDeleteAction.do">
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
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="20%"> Name </th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="10%">Phone</th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="10%">City</th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="3%">State</th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="15%">Agent</th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="5%">Action</th>
              </tr>
              <logic:notEmpty name="RestaurantListForm" property="restaurantList">
              <logic:iterate id="RestaurantBean" name="RestaurantListForm" property="restaurantList" indexId="i">
              <pg:item>
              <tr class="tr_<%= i%2 + 1 %>">
                <td align="center">
                  <html:multibox property="selected">
                    <bean:write name="RestaurantBean" property="restaurant_tbl_pk"/>
                  </html:multibox>
                </td>
                <td><bean:write name="RestaurantBean" property="restaurant_name"/></td>
                <td><bean:write name="RestaurantBean" property="restaurant_phone"/></td>
                <td><bean:write name="RestaurantBean" property="restaurant_city"/></td>
                <td><bean:write name="RestaurantBean" property="restaurant_state"/></td>
                <td><bean:write name="RestaurantBean" property="agent_name"/></td>
                <td><a href="RestaurantB4NewEditAction.do?restaurant_tbl_pk=<bean:write name="RestaurantBean" property="restaurant_tbl_pk"/>">Edit</a></td>
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