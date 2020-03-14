<%@page import="com.kh.question.model.vo.Question"%>
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
            <h1 class="h1 mb-0 text-gray-800">문의 관리</h1>
          </div>
          
          
<!-- <select>
	<option>제목</option>
	<option>작성자</option>
	<option>내용</option>
</select>
<input>
<button>검색</button> -->
<table class="table table-hover table-sm" style="width:60%; float:right;">
	<tr>
		<th>보기</th>
		<th>제목</th>
		<th>작성자</th>
		<th>등록일</th>
		<th>처리일</th>
		<th>상태</th>
	</tr>
	<%	ArrayList<Question> list=(ArrayList<Question>)request.getAttribute("list");
		for(Question q:list){%>
	<tr>
		<td><button onclick="return showQ(<%=q.getQ_no()%>)">보기</button></td>
		<td><%=q.getTitle() %></td>
		<td><%=q.getM_no() %></td>
		<td><%=q.getEnroll_date() %></td>
		<td><%=q.getEnd_date() %></td>
		<td><%=q.getStatus() %></td>
	</tr>
	<%	} %>
</table>
	<div id="showAreaa" style="float:right;width:40%;"></div>
	</div>
	<script>
		function answer(){
			$('#answerForm').toggle();
		}
		function showQ(q_no){
			$('#showAreaa').load("<%=request.getContextPath()%>/get.qu.ad?qno="+q_no+" div.inner-box.my-resume");
			return false;
		}
		function answerInsert(){
			
			var answer = $('#answer');
			
			if(answer.val().trim().length == 0){
				alert("답변내용을입력해주세요");
				answer.focus();
				return false;
			}else{
				$('#answerForm').submit();
			}
		}
	
	</script>
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
	$('#accordionSidebar').children('li.nav-item').eq(4).addClass('active');
</script>
</body>
</html>