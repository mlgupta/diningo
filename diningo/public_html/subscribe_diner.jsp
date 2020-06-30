<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
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
		<td width="180px" align="center" class="tabActive">Subscribe Diner</td>
                <%@ include file="link_home_logout.html" %>  
              </tr>
            </table></td>
          </tr>
          <tr>
            <td>
             <html:errors/>
            </td>
          </tr>
          <tr>
            <td height="200" valign="top" style="text-align:justify">
              <html:form action="/SubscribeDinerAction.do">
                <table width="100%" border="0" cellspacing="1" cellpadding="1">
                <tr>
                  <td align="right">&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td width="30%" align="right"><span class="txtHighlight">*</span>Name: </td>
                  <td width="70%"><html:text property="txtName" style="width:250px" styleClass="txtBox"/></td>
                </tr>
                <tr>
                  <td align="right"><span class="txtHighlight">*</span>Email: </td>
                  <td><html:text property="txtWorkEmail" style="width:200px" styleClass="txtBox"/></td>
                </tr>
                <tr>
                  <td align="right"><span class="txtHighlight">*</span>City: </td>
                  <td><html:text property="txtCity" style="width:125px" styleClass="txtBox"/></td>
                </tr>
                <tr>
                  <td align="right" valign="top"><span class="txtHighlight">*</span>State: </td>
                  <td><html:select property="txtcboState" styleClass="txtBox">
                      <html:optionsCollection name="StateBean" property="states" value="state_tbl_pk" label="state_name" />
                  </html:select></td>
                </tr>
                <tr>
                  <td align="right"><span class="txtHighlight">*</span>Zip Code: </td>
                  <td><html:text property="txtZipCode" style="width:50px" maxlength="5" styleClass="txtBox"/></td>
                </tr>
                <tr>
                  <td align="right" >Specials,<br>
                  <span class="txtHighlightSml">(select at least<br> 
                     one):</span>
                  </td>
                  <td>
                    <table border="0" cellspacing="0" cellpadding="0">
                    <logic:iterate id="Specials" name="SpecialsBean" property="specials">
                    <tr>
                      <td>
                        &nbsp;
                        <html:multibox property="chkSpecials" styleClass="txtBox">
                          <bean:write name="Specials" property="specials_tbl_pk"/>
                        </html:multibox>
                      </td>
                      <td>
                        <bean:write name="Specials" property="specials_name"/>
                      </td>
                    </tr>
                    </logic:iterate>
                    </table>
                  </td> 
                </tr>
                <tr>
                  <td align="right">Birth Date:<br>
                      <span class="txtHighlightSml">(for gift offers)</span></td>
                  <td><html:select property="txtBirthDateDay" styleClass="txtBox">
                      <html:option value=""></html:option>
                      <html:option value="01">01</html:option>
                      <html:option value="02">02</html:option>
                      <html:option value="03">03</html:option>
                      <html:option value="04">04</html:option>
                      <html:option value="05">05</html:option>
                      <html:option value="06">06</html:option>
                      <html:option value="07">07</html:option>
                      <html:option value="08">08</html:option>
                      <html:option value="09">09</html:option>
                      <html:option value="10">10</html:option>
                      <html:option value="11">11</html:option>
                      <html:option value="12">12</html:option>
                      <html:option value="13">13</html:option>
                      <html:option value="14">14</html:option>
                      <html:option value="15">15</html:option>
                      <html:option value="16">16</html:option>
                      <html:option value="17">17</html:option>
                      <html:option value="18">18</html:option>
                      <html:option value="19">19</html:option>
                      <html:option value="20">20</html:option>
                      <html:option value="21">21</html:option>
                      <html:option value="22">22</html:option>
                      <html:option value="23">23</html:option>
                      <html:option value="24">24</html:option>
                      <html:option value="25">25</html:option>
                      <html:option value="26">26</html:option>
                      <html:option value="27">27</html:option>
                      <html:option value="28">28</html:option>
                      <html:option value="29">29</html:option>
                      <html:option value="30">30</html:option>
                      <html:option value="31">31</html:option>
                    </html:select>
                      <html:select property="txtBirthDateMonth" styleClass="txtBox">
                        <html:option value=""></html:option>
                        <html:option value="01">Jan</html:option>
                        <html:option value="02">Feb</html:option>
                        <html:option value="03">Mar</html:option>
                        <html:option value="04">Apr</html:option>
                        <html:option value="05">May</html:option>
                        <html:option value="06">Jun</html:option>
                        <html:option value="07">Jul</html:option>
                        <html:option value="08">Aug</html:option>
                        <html:option value="09">Sep</html:option>
                        <html:option value="10">Oct</html:option>
                        <html:option value="11">Nov</html:option>
                        <html:option value="12">Dec</html:option>
                      </html:select>
                    </td>
                </tr>
                <tr>
                  <td height="50" align="right">&nbsp;</td>
                  <td><html:submit styleClass="button_signup" alt="Sign Up" title="Sign Up">&nbsp;</html:submit></td>
                </tr>
              </table>
              </html:form></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  
</table>
<%@ include file="footer.html" %>  </body>
</html>