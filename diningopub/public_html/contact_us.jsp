<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<head>
<title>DiningO - Contact Us</title>
<link href="main.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--

-->
</style>
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
    <td>
      <html:errors/>
    <td>
  </tr>
  <tr>
    <td height="255" valign="top">
	  <table width="100%" border="0" cellspacing="1" cellpadding="1">
      <tr>
        <td width="66%" height="510px" align="center" valign="top">
          <table width="93%" border="0" cellspacing="1" cellpadding="1">
          <tr>
            <td height="40" class="textHeading1"><span style="text-align:justify">Give us your feedback / inquiry </span></td>
          </tr>
          <tr>
            <td height="200" valign="top" style="text-align:justify">
                <html:form action="/ContactUsAction.do">
                <table width="95%" border="0" cellspacing="1" cellpadding="1">
              <tr>
                <td align="right">&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td width="28%" align="right"><span class="txtHighlight">*</span> Your Email Address:</td>
                <td width="72%"><html:text property="txtEmailId" style="width:300px" styleClass="txtBox"></html:text></td>
              </tr>
              <tr>
                <td align="right"><span class="txtHighlight">*</span> Subject:</td>
                <td><html:text property="txtSubject" style="width:300px" styleClass="txtBox"></html:text></td>
              </tr>
              <tr>
                <td align="right" valign="top"><span class="txtHighlight">*</span> Feedback/ Inquiry:</td>
                <td><html:textarea property="txtFeedBack" rows="10" cols="40" style="width:300px" styleClass="txtBox"></html:textarea></td>
              </tr>
              <tr>
                <td align="right">&nbsp;</td>
                <td align="left">
                  <html:submit styleClass="button_submit" alt="Submit" title="Submit">&nbsp;</html:submit>
		</td>
              </tr>
            </table> </html:form> </td>
          </tr>
        </table></td>
        <td width="34%" align="center" valign="top">
		<table width="100%" border="0" cellspacing="1" cellpadding="1">
          <tr>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td height="470px" align="center" valign="top" class="bdrLftClr_Lvl_2">
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
</body>
</html>