<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인폼</title>
		<link rel="stylesheet" href="/css/loginStyle.css" />
		<script src="./js/loginValidate.js"></script>
	</head>
	<body>
		<fieldset>
		    <table border="0" cellpadding="40" cellspacing="0" width="100%">
		        <tr>
		            <td align="center" valign="middle">
		                <table border="0" cellpadding="0" cellspacing="0" width="470">
		                    <tr>
		                        <td align="center"><img src="./img/login_logo.gif" /></td>
		                    </tr>
		                </table>
		                <form name="myform" action="loginProcess.do" method="post" onsubmit="return formValidate(this);">
		                <table width="470" border="0" cellpadding="0" cellspacing="0">
		                    <tr>
		                        <td width="350">
		                            <input type="text" name="id" placeholder="아이디" class="user_input" />
		                        </td>
		                        <td width="120" rowspan="3" align="right">
		                            <input type="image" src="./img/login_bt.gif" />
		                        </td>
		                    </tr>
		                    <tr height="5">
		                        <td></td>
		                    </tr>
		                    <tr>
		                        <td>
		                            <input type="password" name="pass1" placeholder="****" class="user_input" />
		                        </td>
		                    </tr>
		                </table>
		                <div style="margin-top:15px;"></div>
		                <div style="margin-top:15px;"></div>
		                <table width="470" border="0" cellpadding="0" cellspacing="0">
		                    <tr>
		                        <td align="left">
		                            <a href="#" onClick=""><img src="./img/login_member.gif" alt="아직도 회원이 아니세요?" /></a>
		                        </td>
		                        <td align="right">
		                            <a href="#" onClick=""><img src="./img/login_idpw.gif" alt="아이디/비밀번호를 잊어버리셨어요?" /></a>
		                        </td>
		                    </tr>
		                </table>
		                </form>
		                <div style="margin-top:30px;"></div>
		            </td>
		        </tr>
		    </table>
		</fieldset>
	</body>
</html>