<%@page import="com.kh.board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/views/include/header.jsp" %>

<h1>글보기</h1>
<div id=content>
	<%	Board b=(Board)request.getAttribute("b"); %>
	머리말:<%=b.getHead() %><br>
	제목:<%=b.getTitle() %><br>
	내용:<%=b.getContents() %><br>
	모집기간:<%=b.getTime() %><br>
	첨부된파일: abc.txt<br>
</div>
<button onclick="del(<%=b.getB_no()%>)">삭제(관리자)</button>
<button onclick="history.back()">목록</button>
<%@ include file="/views/include/footer.jsp" %>
<script>
	function del(bno){
		location.href="<%=request.getContextPath()%>/del.bo.ad?bno="+bno;
	}
</script>
</body>
</html>