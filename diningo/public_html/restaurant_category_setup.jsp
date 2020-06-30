<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<title>DiningO - Restaurant Category Setup</title>
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
		 <td width="25px" class="tabSpace">&nbsp;</td>
		 <td width="155px" align="center" class="tabActive">Category Setup</td>
                 <%@ include file="link_home_logout.html" %>  
              </tr>
            </table></td>
          </tr>
          <tr>
            <td height="30" class="textHeading12bold">&nbsp;</td>
          </tr>
          <tr>
            <td align="left">
              <html:errors/>
              <html:form action="/CategoryAddAction.do">            
              <html:hidden property="hdnCategoryTblPk"/>
              <table border="0" cellspacing="1" cellpadding="1">
              <tr>
                <td width="90" align="right"><span class="txtHighlight">*</span> Category:</td>
                <td width="125"><html:text property="txtCategoryName" style="width:120px" styleClass="txtBox"/></td>
              </tr>		  
              <tr>
                <td width="90" align="right"><span class="txtHighlight">* </span>Description:</td>
                <td width="125"><html:text property="txtCategoryDesc" styleClass="txtBox" style="width:220px"/></td>
              </tr>		  
              </table>
              <table border="0" cellspacing="1" cellpadding="1" style="margin-top:5px; margin-bottom:30px">
                <tr>
                <td width="90"></td>
                <td height="40" align="left">
   		     <html:submit alt="Submit">Save</html:submit>
		     <html:reset alt="Cancel">Cancel</html:reset>
                </td>
                </tr>
              </table>
              </html:form>
              </td>
            </tr>
          <tr>
            <td height="25" class="textHeading3 bdrBtmClr_Lvl_2" align="left">Restaurant Category List :</td>
          </tr>
          <html:form action="/CategoryDeleteAction.do">          
	  <tr>
            <td height="40" align="left"><html:submit alt="Delete">Delete</html:submit></td>
          </tr>
          <tr>
            <td >
	      <table id="dataDynamic" width="100%" border="0" cellspacing="0" cellpadding="1" style="border:#CCCCCC 1px solid;">
              <tr>
                <th class="thBold bdr_TH_rgt bdr_TH_btm" width="6%">Select</th>
                <th class="thBold bdr_TH_rgt bdr_TH_lft bdr_TH_btm" width="25%"> Category </th>
                <th class="thBold  bdr_TH_lft bdr_TH_btm" width="50%">Description</th>
                <th class="thBold  bdr_TH_lft bdr_TH_btm" width="19%">Action</th>
              </tr>
              <logic:notEmpty name="CategoryForm" property="categoryList">
              <logic:iterate id="CategoryBean" name="CategoryForm" property="categoryList" indexId="i">
              <tr class="tr_<%= i%2 + 1 %>">
                <td align="center">
                  <html:multibox property="selected">
                    <bean:write name="CategoryBean" property="category_tbl_pk"/>
                  </html:multibox>
                </td>
                <td align="left"><bean:write name="CategoryBean" property="category_name"/></td>
                <td align="left"><bean:write name="CategoryBean" property="category_description"/></td>
                <td align="left"><a href="CategoryEditAction.do?category_tbl_pk=<bean:write name="CategoryBean" property="category_tbl_pk"/>">Edit</a></td>                
              </tr>
              </logic:iterate>
              </logic:notEmpty>
            </table></td>
          </tr>
          <tr>
            <td height="40" align="left"><html:submit alt="Delete">Delete</html:submit></td>
          </tr>
          <tr>
            <td height="80" >&nbsp;</td>
          </tr>
          </html:form>
          </table></td>
  </tr>
  
</table>
<%@ include file="footer.html" %>  
</body>
</html>