<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.member.model.vo.Co_Info"%>

<%
	Co_Info cf = (Co_Info)request.getAttribute("cf");
	String usernick = (String)request.getAttribute("nickname");
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/views/include/header.jsp" %>

<h1>
	<% if(cf != null){ %>
		<% if(cf.getName() != null){ %>
		<%=cf.getName() %>
		<% } %> 
	<% }else{ %>
		 <%=usernick %>
	<% } %>

 님 가입을 환영합니다~ 이제 로그인해주세요.</h1>
<a href="<%=contextPath%>/views/login/login.jsp">login</a>
<a href="<%=contextPath%>">main</a>
<%@ include file="/views/include/footer.jsp" %>
</body>
</html>

<!-- //상화야 여기로 넘어는 왔는데 cf라는걸 안넘겨 줘서 넌ㄹ포인트 나는거 같애 음??그런가요? 근데 저거 cf.getname이 null이여두 null로 화면에는 띄어지던데.
//잠시만 -->