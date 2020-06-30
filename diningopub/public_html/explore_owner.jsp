<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<title>DiningO - Explore Owner</title>
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
        <td width="461px" align="center" valign="top"><br>
		<span class="textHeading1">Three easy steps to attract more customers!</span><img src="images/story_owner.gif" alt="Benefits Of Getting Your Restaurant Listed on DininGo.com" width="433" height="1410" style="margin:5px"></td>
        <td width="430px" align="center" valign="top">
	<table width="100%" border="0" cellspacing="1" cellpadding="1">
          <tr>
            <td align="center" valign="top">
              <table width="93%" border="0" cellspacing="1" cellpadding="1">
              <tr>
                <td height="30" valign="top" style="text-align:justify">&nbsp;</td>
              </tr>
              <tr>
                <td height="30" align="left" valign="bottom" class="textHeading1 ">Registered Owners, click <span class="textLinkHeading1"><a href="http://www.DininGo.com/diningo/LoginB4Action.do">here</a></span> to Login</td>
              </tr>
              <tr>
                <td valign="top" style="text-align:justify">&nbsp;</td>
              </tr>
              <tr>
                <td height="30" align="left" valign="bottom" class="textHeading1 bdrBtmClr_Lvl_2">Restaurant Owners, Sign Up Now!</td>
              </tr>
              <tr>
                <td>
                  <html:errors/>
                </td>
              </tr>
              <tr>
                <td height="200" valign="top" style="text-align:justify">
                 <html:form action="/ExploreOwnerAction.do">
                 <table width="100%" border="0" cellspacing="1" cellpadding="1">
                 <tr>
                   <td align="right">&nbsp;</td>
                   <td>&nbsp;</td>
                 </tr>
                 <tr>
                   <td width="30%" align="right"><span class="txtHighlight">*</span>Your Name: </td>
                   <td width="70%"><html:text property="txtName" style="width:250px" styleClass="txtBox"/></td>
                 </tr>
                 <tr>
                    <td align="right" valign="top"><span class="txtHighlight">*</span>Restaurant:</td>
                    <td><html:text property="txtRestaurantName" style="width:200px" styleClass="txtBox"/></td>
                 </tr>
                 <tr>
                   <td align="right"><span class="txtHighlight">*</span>Email: </td>
                   <td><html:text property="txtEmailId" style="width:200px" styleClass="txtBox"/></td>
                 </tr>
                 <tr>
                    <td align="right"><span class="txtHighlight">*</span>Phone:</td>
                    <td><html:text property="txtPhone" styleClass="txtBox" style="width:125px" maxlength="14"/><span class="txtHighlightSml"> XXX-XXX-XXXX</span></td>
                 </tr>
                 <tr>
                    <td align="right"><span class="txtHighlight">*</span>City: </td>
                    <td><html:text property="txtCity" styleClass="txtBox" style="width:125px"/></td>
                  </tr>
                  <tr>
                    <td align="right"><span class="txtHighlight">*</span>State: </td>
                    <td>
                      <html:select property="cboState" styleClass="txtBox" >
                        <html:optionsCollection name="StateBean" property="states" value="state_name" label="state_name" />
                      </html:select>
                    </td>
                  </tr>
                  <tr>
                     <td align="right"><span class="txtHighlight">*</span>Zip:</td>
                     <td><html:text property="txtZipCode" styleClass="txtBox" style="width:50px" maxlength="5"/></td>
                  </tr>
                  <tr>
                    <td align="right" valign="top">&nbsp;</td>
                    <td>
                      <table>
                      <tr>
                        <td valign="bottom">
                          <html:text property="txtCaptchaField" style="width:60px" styleClass="txtBox"/>
                        </td>
                        <td>
                          <img src="Captcha.jpg" alt="Captcha Image">
                        </td>
                      </tr>
                      </table>
                    </td>
                  </tr>
                  <tr>
                     <td align="right">&nbsp;</td>
                     <td><html:submit styleClass="button_signup" alt="Sign Up" title="Sign Up">&nbsp;</html:submit></td>
                  </tr>
                  </table>
                 </html:form>
                 </td>
              </tr>
              <tr>
                <td  height="50" valign="bottom"></td>
             </tr>
<!--             
              <tr>
                <td height="40" valign="bottom" class="textHeading1 bdrBtmClr_Lvl_2">Rates:</td>
              </tr>
              <tr>
                <td  height="150" align="center" class="bdrBtmClr_Lvl_2">
                  <table width="300px" border="0" cellspacing="1" cellpadding="1" style="margin-bottom:30px">
                  <tr>
                    <td width="24%" height="145" align="center"><a href="#"><img src="images/box_breakfast_sp.gif" alt="Breakfast Special" width="124" height="123" border="0"></a></td>
                    <td width="26%" align="center"><a href="#"><img src="images/box_lunch_sp.gif" alt="Lunch Special" width="124" height="123" border="0"></a></td>
                  </tr>
                  <tr>
                    <td height="145" align="center"><a href="#"><img src="images/box_happy_hour_sp.gif" alt="Happy Hour Special" width="124" height="123" border="0"></a></td>
                    <td align="center"><a href="#"><img src="images/box_dinner_sp.gif" alt="Dinner Special" width="124" height="123" border="0"></a></td>
                  </tr>
                  </table>
                </td>
              </tr>
-->              
             </table>
            </td>
          </tr>
        </table>
        </td>
      </tr>
    </table>
   </td>
  </tr>
</table>
<%@ include file="footer.html" %>  
</body>
</html>