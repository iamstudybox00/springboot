<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>home 화면</title>
		<script src="./js/commons.js"></script>
		<link rel="stylesheet" href="./css/main.css">
	</head>
	<body>
		<h2>스프링 부트 프로젝트-시큐리티</h2>
		<ul>
			<li><a href="/">루트</a></li>
		</ul>
		
		<script>
			window.onload = function() {
				myconsole("시큐리티");
			}
		</script>
		
		<h2>파일업로드</h2>
		<ul>
			<li><a href="/fileUpload.do">파일업로드(싱글파일)</a></li>
			<li><a href="/multiFileUpload.do">파일업로드(멀티파일)</a></li>
			
		</ul>
	</body>
</html>