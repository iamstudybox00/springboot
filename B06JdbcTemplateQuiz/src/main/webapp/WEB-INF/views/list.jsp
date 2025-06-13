<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>리스트</title>
	</head>
	<script>
		function validateForm(frm){
			if(frm.searchKeyword.value == ""){
				alert("검색어를 입력하세요");
				return false;
			}
		}
	</script>
	<body>
		<h2>회원 리스트</h2>
		<form method="get" action="list.do" onsubmit="return validateForm(this);">  
	    <table border="1" width="30%">
	    <tr>
	        <td align="center">
	            <select name="searchField">
	                <option value="id">아이디</option>
	                <option value="name">이름</option>
	            </select>
	            <input type="text" name="searchKeyword" />
	            <input type="submit" value="검색하기" />
	        </td>
	    </tr>
	    </table>
	    </form>
		
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>패스워드</th>
				<th>이름</th>
				<th>가입일</th>
				<th></th>
			</tr>
			
			<c:forEach items="${ memberList }" var="row" varStatus="loop">
				<tr>
					<td>${ row.id }</td>
					<td>${ row.pass }</td>
					<td>${ row.name }</td>
					<td>${ row.regidate }</td>
					<td>
						<a href="edit.do?id=${ row.id }">수정</a>
						<a href="delete.do?id=${ row.id }">삭제</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="regist.do">회원등록</a>
		<a href="list.do">리스트</a>
	</body>
</html>