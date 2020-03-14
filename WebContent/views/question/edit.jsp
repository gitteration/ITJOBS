<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/views/include/header.jsp" %>

<h1>글쓰기</h1>
머리말:
<select>
	<option selected>자유</option>
	<option>스터디</option>
	<option>프로젝트</option>
	<option>문의</option>
</select><br>
제목:<input value="제목1"><br>
내용:<input value="내용1"><br>
모집기간:<input value="날짜1">~<input value="날짜2"><br>
첨부된파일: abc.txt<br>
파일첨부:<input type=file><br>
<button>등록</button>
<button onclick="history.back()">취소</button>
<%@ include file="/views/include/footer.jsp" %>
</body>
</html>