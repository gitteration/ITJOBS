<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>비밀번호 변경</h1>

<form action="<%=request.getContextPath() %>/changePw.me" method="post">
	현재 비번:<input name=pw><br>
	새로운 비번:<input name=newPw><br>
	비번확인:<input name=newPw$><br>
	<button>변경(클릭 후 이동할 페이지 설정해야함)</button>
</form>
</body>
</html>