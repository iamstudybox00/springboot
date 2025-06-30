<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
<!-- 		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>게시판 목록</title>
		<link rel="stylesheet" href="./commons/style.css" >
	</head>
	<body>
		<h2>JPA Board</h2>
		<h2>Pageable(페이징적용)</h2>
		총 레코드 개수 : ${ totalElements }<br/>
		전체 페이지 수 : ${ totalPages }<br/>
		페이지 당 레코드 수 : ${ size }<br/>
		페이지번호 : ${ pageNumber }<br/>
		엘리먼트(컨텐츠) 개수 : ${ numberOfElements }<br/>
		<hr/>
		<div class="board">
			<table>
				<thead>
					<tr>
						<th>No</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ boards }" var="row" varStatus="vs">
						<tr>
							<td>${ row.id }</td>
							<td class="bo_title"><a href="view.do?id=${ row.id }"> ${ row.title }</a></td>
							<td>${ row.name }</td>
							<td>${ MyFunctions.stringCut(row.postdate) }</td>
							<td>${ row.hits }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<p>
		<c:forEach begin="1" end="${ totalPages }" step="1" var="p">
			<a href="/list.do?page=${ p }">${ p }&nbsp;&nbsp;</a>
		</c:forEach>
		</p>
		<div class="form-actions">
			<button type="button" onclick="location.href='write.do';">작성</button>
		</div>
	</body>
</html>