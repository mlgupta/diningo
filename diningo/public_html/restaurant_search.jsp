<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
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
//-->
</script>
</head>
<body onLoad="MM_preloadImages('images/btn_contactus_over.gif','images/btn_home_over.gif')">
<table width="900px" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="bdrLftClr_Lvl_2 bdrRgtClr_Lvl_2">
  <tr>
    <td height="90px" background="images/bar_top_tile90.gif">
      <%@ include file="header.html" %>  
    </td>
  </tr>
  <tr>
    <td height="255" valign="top">
	  <table width="100%" border="0" cellspacing="1" cellpadding="1">
      <tr>
        <td width="76%" height="510px" align="center" valign="top">
		  <table width="97%" border="0" cellspacing="1" cellpadding="1">
          <tr>
            <td height="40" class="textHeading1">
			Find  Restaurants in Your Proximity!            </td>
          </tr>
          <tr>
            <td height="90" style="text-align:justify"  class="bdrBtmClr_Lvl_2">
			<table border="0" cellpadding="0" cellspacing="1">
              <tr>
                <td width="116px"><select name="select4" class="txtBox">
                  <option>Select Cuisine</option>
                                </select></td>
                <td width="125px"><select name="select2" class="txtBox">
                  <option>Select Your City</option>
                                </select></td>
                <td width="55px" >
                  <select name="select3" class="txtBox" >
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
                        </select>                </td>
                <td width="57px" >
				<input name="textfield322" type="text" class="txtBox" style="width:50px" value="Zip" maxlength="6"></td>
                <td width="110px" ><select name="select5" class="txtBox" style="width:100px">
                  <option>Meals here</option>
                </select></td>
                <td align="right"><input type="checkbox" name="checkbox322" value="checkbox" ></td>
                <td width="67px">Coupons</td>
                <td align="right"><input type="checkbox" name="checkbox2222" value="checkbox"></td>
                <td>Entertainment</td>
              </tr>
            </table>
              <table width="100%" border="0" cellspacing="1" cellpadding="3">

                <tr>
                  <td align="right"><a href="#"><img src="images/btn_search.gif" alt="Search" width="80" height="27" border="0"></a></td>
                  </tr>
              </table></td>
          </tr>
          
		  <tr>
		    <td align="right">
			  <table id="nagigation" border="0" cellspacing="1" cellpadding="1">
              <tr>
                <td  align="right">
				<img src="images/btn_previous.gif" alt="Previous Page" title="Previous Page" width="35" height="27"></td>
                <td align="right">&nbsp;
				<span class="textLinkNormal"><a href="#">1</a></span>
				<span class="textLinkNormal"><a href="#">2</a></span>
				<span class="textLinkNormal"><a href="#">3</a></span>
				<span class="textLinkNormal"><a href="#">4</a></span>
				<span class="textLinkNormal"><a href="#">5</a></span>
				<span class="textLinkNormal"><a href="#">6</a></span>
				<span class="textLinkNormal"><a href="#">7</a></span>
				<span class="textLinkNormal"><a href="#">8</a></span>
				<span class="textLinkNormal"><a href="#">9</a></span>
&nbsp;				</td>
                <td align="right">
				<img src="images/btn_next.gif" alt="Next Page" title="Next Page" width="35" height="27">				</td>
              </tr>
            </table></td>
		    </tr>
		  <tr>
		  <td align="center">
		  <table id="restaurant" width="97%" border="0" cellspacing="1" cellpadding="1" class="txtBoxThick" style="margin:10px;">
            <tr>
              <td width="30%" align="center" style="border-right:#FF6600 1px dotted;">
			  <table width="100%" height="100%" border="0" cellpadding="1" cellspacing="1">
                <tr>
                  <td height="18" align="center" class="textHeading2">McDonald</td>
                </tr>
                <tr>
                  <td align="center"><img src="images/logo_mcdonald.jpg" width="45" height="42" style="margin:10px; border:#CCCCCC 1px solid;"></td>
                </tr>
                <tr>
                  <td align="center">Address Line 1<br>
                    Address Line 123<br>
                    Address Line 1234<br>
                    Address Line 123456789</td>
                </tr>
                <tr>
                  <td height="30" align="center"><span class="txtHighlight">Phone:</span> 888-888-8888</td>
                </tr>
              </table></td>
              <td width="70%" align="center">Special text Goes Here... <br>
Special text Goes Here...<br>
Special text Goes Here...<br>
Special text Goes Here...<br>
Special text Goes Here...</td>
            </tr>
            <tr>
              <td height="22" colspan="2" align="center" style="border-top:#FF6600 1px dotted;">
			  <span class="textLinkNormal"><a href="#">Menu</a></span> | <span class="textLinkNormal"><a href="#">Coupons</a></span> | <span class="textLinkNormal"><a href="#">Website</a></span> | <span class="textLinkNormal"><a href="#">Video</a></span> | <span class="textLinkNormal"><a href="#">Entertainment</a></span> | <span class="textLinkNormal"><a href="#">Map</a></span>			  </td>
              </tr>
          </table>
		  <table width="97%" border="0" cellspacing="1" cellpadding="1" class="txtBoxThick" style="margin:10px;">
            <tr>
              <td width="30%" align="center" style="border-right:#FF6600 1px dotted;"><table width="100%" height="100%" border="0" cellpadding="1" cellspacing="1">
                  <tr>
                    <td height="18" align="center" class="textHeading2">McDonald</td>
                  </tr>
                  <tr>
                    <td align="center"><img src="images/logo_mcdonald.jpg" width="45" height="42" style="margin:10px; border:#CCCCCC 1px solid;"></td>
                  </tr>
                  <tr>
                    <td align="center">Address Line 1<br>
                      Address Line 123<br>
                      Address Line 1234<br>
                      Address Line 123456789</td>
                  </tr>
                  <tr>
                    <td height="30" align="center"><span class="txtHighlight">Phone:</span> 888-888-8888</td>
                  </tr>
              </table></td>
              <td width="70%" align="center">Special text Goes Here... <br>
                Special text Goes Here...<br>
                Special text Goes Here...<br>
                Special text Goes Here...<br>
                Special text Goes Here...</td>
            </tr>
            <tr>
              <td height="22" colspan="2" align="center" style="border-top:#FF6600 1px dotted;"><span class="textLinkNormal"><a href="#">Menu</a></span> | <span class="textLinkNormal"><a href="#">Coupons</a></span> | <span class="textLinkNormal"><a href="#">Website</a></span> | <span class="textLinkNormal"><a href="#">Video</a></span> | <span class="textLinkNormal"><a href="#">Entertainment</a></span> | <span class="textLinkNormal"><a href="#">Map</a></span> </td>
            </tr>
          </table></td>
		  </tr>
          <tr>
		    <td align="right">
			  <table id="nagigation" border="0" cellspacing="1" cellpadding="1">
              <tr>
                <td  align="right">
				<img src="images/btn_previous.gif" alt="Previous Page" title="Previous Page" width="35" height="27"></td>
                <td align="right">&nbsp;
				<span class="textLinkNormal"><a href="#">1</a></span>
				<span class="textLinkNormal"><a href="#">2</a></span>
				<span class="textLinkNormal"><a href="#">3</a></span>
				<span class="textLinkNormal"><a href="#">4</a></span>
				<span class="textLinkNormal"><a href="#">5</a></span>
				<span class="textLinkNormal"><a href="#">6</a></span>
				<span class="textLinkNormal"><a href="#">7</a></span>
				<span class="textLinkNormal"><a href="#">8</a></span>
				<span class="textLinkNormal"><a href="#">9</a></span>
&nbsp;				</td>
                <td align="right">
				<img src="images/btn_next.gif" alt="Next Page" title="Next Page" width="35" height="27">				</td>
              </tr>
            </table></td>
		    </tr>
		  <tr>
            <td valign="top" style="text-align:justify">&nbsp;</td>
          </tr>
        </table></td>
        <td width="24%" align="center" valign="top">
		<table width="100%" border="0" cellspacing="1" cellpadding="1">
          <tr>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td height="630px" align="center" valign="top" class="bdrLftClr_Lvl_2">
			  <table id="googleAdSense" width="75%" border="0" cellspacing="1" cellpadding="1">
              <tr>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
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