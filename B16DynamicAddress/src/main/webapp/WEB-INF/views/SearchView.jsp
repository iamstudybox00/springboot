<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>검색 API</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script>
			$(function(){
				$('#keyword').keydown(function(e){
					//엔터키가 눌려졌다면 함수를 호출
					if(e.keyCode == 13){
						runAjax();
						e.preventDefault();
					} else{
						console.log(e.keyCode);
					}
				});
				
				$('#searchBtn').click(function(){
					runAjax();
				});	
			});
			
			function runAjax(){
				$.ajax({
					url : "./NaverSearchRequest.do",
					type : "get",
					data : {
						keyword : $('#keyword').val(),
						startNum : $('#startNum').val()
					},
// 						startNum : $('#startNum').val()
					dataType : "json", //응답 데이터 형식
					success : sucFuncJson, // 요청 성공시 호출할 메서드 설정
					error : errFunc 		// 요청 실패 시 호출할 메서드 설정
				});
			}
			
			function sucFuncJson(d){
				console.log("결과", d);
				var str = "";
				
				$.each(d.items, function(index, item){
					str += "<ul>";
					str += "	<li>" + (index + 1) + "</li>"
					str += "	<li>" + item.title + "</li>";
					str += "	<li>" + item.description + "</li>";
					str += "	<li>" + item.bloggername + "</li>";
					str += "	<li>" + item.bloggerlink + "</li>";
					str += "	<li>" + item.postdate + "</li>";
					str += "	<li><a href='" + item.link + "' target='_blank'>바로가기</a></li>";
					str += "</ul>";
				});
				$('#searchResult').html(str);
			}
			
			function errFunc(e){
				alert("실패: " + e.status);
			}
		</script>
	<style>
    ul{border:2px #cccccc solid;}
    #startNum{width:100px;}
	</style>
	</head>
	<body>
	<div>
	    <div>
	        <form id="searchFrm">
	            한 페이지에 10개씩 출력됨 <br />
	            <select id="startNum">
	            	<option value="1">1페이지</option>
	            	<option value="11">2페이지</option>
	            	<option value="22">3페이지</option>
	            	<option value="31">4페이지</option>
	            	<option value="41">5페이지</option>
	            </select>
	            <input type="number" id="startNum" step="10" 
	            			value="1">
	            <input type="text" id="keyword" 
	            			placeholder="검색어를 입력하세요." />
	            <button type="button" id="searchBtn">검색 요청</button>
	        </form>
	    </div>
	    <div class="row" id="searchResult">
	        여기에 검색 결과가 출력됩니다.
	    </div>
	</div>
	</body>

</html>