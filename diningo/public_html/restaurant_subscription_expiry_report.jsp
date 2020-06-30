<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<title>DiningO - Restaurant Subscription Expiry Report</title>
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
    <td height="90px" background="images/bar_top_tile90.gif">
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
			  	<td height="25px" width="5px" class="tabSpace">&nbsp;</td>
                <td width="150px" align="center" class="tabInactive">
				<span class="textTab"><a href="agent_list.jsp">Agent Management</a></span></td>
				<td width="3px" class="tabSpace">&nbsp;</td>
				<td width="180px" align="center" class="tabInactive">
				<span class="textTab"><a href="restaurant_management.jsp">Restaurant Management</a></span></td>
				<td width="3px" class="tabSpace">&nbsp;</td>
				<td width="200px" align="center" class="tabInactive">
				<span class="textTab"><a href="restaurant_category_setup.jsp">Restaurant Category Setup</a></span></td>
				<td width="3px" class="tabSpace">&nbsp;</td>
				<td width="80px" align="center" class="tabActive">
				Reports</td>
                <td align="right" class="tabSpace">
				<span class="textLinkBlock"><a href="#">&nbsp;LogOut&nbsp;</a></span></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td height="25">&nbsp;</td>
          </tr>
          <tr>
            <td height="30" valign="bottom" class="textHeading3 bdrBtmClr_Lvl_2">Subscription Expiry</td>
          </tr>
          <tr>
            <td >
			<table border="0" cellspacing="1" cellpadding="1" style="margin-top:5px; margin-bottom:30px">
              <tr>
                <td width="95">Period:</td>
                <td width="108">City:</td>
                <td width="53">State:</td>
                <td width="57">Zip:</td>
                <td width="160">Expires in</td>
                <td width="149">&nbsp;</td>
              </tr>
              <tr>
                <td><input name="textfield325522" type="text" class="txtBox" style="width:50px" value="7">
                  Days</td>
                <td><input name="textfield3255222" type="text" class="txtBox" style="width:100px"></td>
                <td><select name="select3" class="txtBox" >
                  <option value="AL" selected>AL</option>
                  <option value="AK">AK</option>
                  <option value="AZ">AZ</option>
                  <option value="AR">AR</option>
                  <option value="CA">CA</option>
                  <option value="CO">CO</option>
                  <option value="CT">CT</option>
                  <option value="DE">DE</option>
                  <option value="DC">DC</option>
                  <option value="FL">FL</option>
                  <option value="GA">GA</option>
                  <option value="HI">HI</option>
                  <option value="ID">ID</option>
                  <option value="IL">IL</option>
                  <option value="IN">IN</option>
                  <option value="IA">IA</option>
                  <option value="KS">KS</option>
                  <option value="KY">KY</option>
                  <option value="LA">LA</option>
                  <option value="ME">ME</option>
                  <option value="MD">MD</option>
                  <option value="MA">MA</option>
                  <option value="MI">MI</option>
                  <option value="MN">MN</option>
                  <option value="MS">MS</option>
                  <option value="MO">MO</option>
                  <option value="MT">MT</option>
                  <option value="NE">NE</option>
                  <option value="NV">NV</option>
                  <option value="NH">NH</option>
                  <option value="NJ">NJ</option>
                  <option value="NM">NM</option>
                  <option value="NY">NY</option>
                  <option value="NC">NC</option>
                  <option value="ND">ND</option>
                  <option value="OH">OH</option>
                  <option value="OK">OK</option>
                  <option value="OR">OR</option>
                  <option value="PA">PA</option>
                  <option value="RI">RI</option>
                  <option value="SC">SC</option>
                  <option value="SD">SD</option>
                  <option value="TN">TN</option>
                  <option value="TX">TX</option>
                  <option value="UT">UT</option>
                  <option value="VT">VT</option>
                  <option value="VA">VA</option>
                  <option value="WA">WA</option>
                  <option value="WV">WV</option>
                  <option value="WI">WI</option>
                  <option value="WY">WY</option>
                </select></td>
                <td><input name="textfield23" type="text" class="txtBox" style="width:50px" maxlength="5"></td>
                <td><input type="text" name="textfield3255223" style="width:120px" class="txtBox">
                <img src="images/butt_dtpicker_cal.gif" width="15" height="15"></td>
                <td><img src="images/btn_generate_report.gif" alt="Generate Report" width="130" height="27"></td>
              </tr>
            </table>
              </td>
          </tr>
          <tr>
            <td height="30" valign="bottom" class="textHeading3 bdrBtmClr_Lvl_2" >Restaurant Subscription Report:</td>
          </tr>
          <tr>
            <td height="200px" valign="top">
			<table id="dataDynamic" width="100%" border="0" cellspacing="0" cellpadding="1" style="border:#CCCCCC 1px solid; margin-top:15px;">
              <tr>
                <th class="thBold bdr_TH_rgt bdr_TH_btm" width="20%">Restaurant Name </th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm">Owner Name  </th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm">Agent Name </th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="11%">City </th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm" width="6%">State</th>
                <th class="thBold bdr_TH_lft bdr_TH_rgt bdr_TH_btm">Zip</th>
			    <th class="thBold bdr_TH_lft bdr_TH_btm">Subscription Ends On </th>
		      </tr>
              <tr class="tr_2">
                <!-- This row has to be dynamically repeated-->
                <td>wwwwwwww</td>
                <td width="19%">Wwww Wwwwwww</td>
                <td width="19%">wwwwwwwww</td>
                <td>Wwwwwww</td>
                <td>AL</td>
                <td width="8%">8888888</td>
                <td width="17%" align="center">88-88-8888</td>
              </tr>
              <tr class="tr_1">
                <!-- This row has to be dynamically repeated-->
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr class="tr_2">
                <!-- This row has to be dynamically repeated-->
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <!-- This row has to be dynamically repeated-->
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr class="tr_2">
                <!-- This row has to be dynamically repeated-->
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
            </table></td>
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