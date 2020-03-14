<%@page import="com.kh.declare.model.vo.Declare"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="detail">
<%	Declare de=(Declare)request.getAttribute("de");%>
	<h2>신고내용</h2>
	<%=de.getContents() %><br>
</div>
</body>
</html>