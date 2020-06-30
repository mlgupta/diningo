<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<title>DiningO - logout</title>
<link href="main.css" rel="stylesheet" type="text/css" />
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
<body>
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
            <td class="textHeading12bold">&nbsp;<html:errors/></td>
          </tr>
          <tr>
            <td class="textHeading12bold">&nbsp;</td>
          </tr>
          <tr>
            <td height="400" align="center" class="textHeading1" >
              <table width="93%" border="0" cellspacing="1" cellpadding="1">
              <tr>
                <td height="30" valign="bottom" class="textHeading1 bdrBtmClr_Lvl_2">Log In:</td>
              </tr>
              <tr>
                <td valign="top" style="text-align:justify">
                  <html:form action="/LoginAction.do">
                  <table width="100% "border="0" cellspacing="1" cellpadding="1" >
                  <tr>
                    <td colspan="2" height="5px">&nbsp;</td>
                  </tr>
                  <tr>
                    <td width="40%" align="right">User ID:</td>
                    <td width="60%"><html:text property="txtUserId" style="width:150px" styleClass="txtBox"/></td>
                  </tr>
                  <tr>
                    <td align="right">Password:</td>
                    <td><html:password property="txtPassword" style="width:150px" styleClass="txtBox"/></td>
                  </tr>
<!--                  
                  <tr>
                    <td align="right" valign="top"><img src="Captcha.jpg" alt="Captcha Image"></td>
                    <td valign="bottom"><html:text property="txtCaptchaField" style="width:60px" styleClass="txtBox"></html:text> <span class="txtHighlight">*</span>Please type the word in image</td>
                  </tr>
-->                  
                  <tr>
                    <td height="50" align="right">&nbsp;</td>
                    <td valign="top">
                       <html:submit>Login</html:submit>
                       <html:reset>Reset</html:reset>
                    </td>
                  </tr>
                  </table>
                  </html:form>
                </td>
              </tr>  
              </table>
            </td>
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