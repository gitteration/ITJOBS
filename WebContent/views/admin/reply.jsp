<%@page import="com.kh.reply.model.vo.Reply"%>
<%@page import="com.kh.board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/views/include/style.jsp" %>
</head>
<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">
	
	<!-- Side bar -->
	<%@ include file="/views/include/sidebar.jsp" %>
	<!-- End of Sidebar -->
	
	<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">
	
	<!-- Main Content -->
	<div id="content">
	
	<!-- Topbar -->
        <%@ include file="/views/include/topbar.jsp" %>
    <!-- End of Topbar -->
    
    <!-- Begin Page Content -->
    <div class="container-fluid">
    
    	<!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h1 mb-0 text-gray-800">리플 관리</h1>
          </div>
          
<table class="table table-hover table-sm">
	<tr>
		<th><input type=checkbox></th>
		<th>본문번호</th>
		<th>작성자</th>
		<th>등록일</th>
		<th>수정일</th>
		<th>내용</th>
		<th>상태</th>
		<th>신고수</th>
		<th>삭제</th>
		<th>삭제취소</th>
	</tr>
	<%	ArrayList<Reply> rlist=(ArrayList<Reply>)request.getAttribute("rlist");
		for(Reply b:rlist){%>
	<tr>
		<td><input type=checkbox></td>
		<td><%=b.getB_no() %></td>
		<td><%=b.getM_no() %></td>
		<td><%=b.getEnroll_date() %></td>
		<td><%=b.getUpdate_date() %></td>
		<td><%=b.getContents() %>
		<td><%=b.getStatus() %></td>
		<td><%=b.getD_count() %></td>
		<td><button onclick="del(<%=b.getRe_no()%>)">삭제</button></td>
		<td><button onclick="delCancle(<%=b.getRe_no()%>)">삭제취소</button></td>
	</tr>
	<%	} %>
</table>

	</div>
    <!-- End of Page Content -->
    
	</div>
	<!-- End of Main Content -->
	
	<!-- Footer -->
		<%@ include file="/views/include/footer.jsp" %>
	<!-- End of Footer -->
	
	</div>
	<!-- End of Content Wrapper -->
	
	</div>
	<!-- End of Page Wrapper -->
<%@ include file="/views/include/js.jsp" %>
<script>
	function del(rno){
		location.href="<%=request.getContextPath()%>/del.re.ad?rno="+rno
	}
	function delCancle(rno){
		location.href="<%=request.getContextPath()%>/delCancle.re.ad?rno="+rno
	}
</script>
<script>
	$('#accordionSidebar').children('li.nav-item').eq(4).addClass('active');
</script>
</body>
</html>