<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>home 화면</title>
	</head>
	<body>
		<h2>JPQL</h2>
		<ul>
			<li><a href="/selectNameLike1.do?name=test">Name Like 조회1</a></li>
			<li><a href="/selectNameLike2.do?name=test">Name Like 조회2</a></li>
			<li><a href="/selectNameLike3.do?name=test&page=2">Name Like 조회3(페이징 적용)</a></li>
			<li><a href="/selectNameLike4.do?name=test">Name Like 조회4 : Native SQL</a></li>
		</ul>
	</body>
</html>