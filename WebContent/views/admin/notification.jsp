<%@page import="com.kh.board.model.vo.PageInfo"%>
<%@page import="com.kh.notification.model.vo.Notification"%>
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
            <h1 class="h1 mb-0 text-gray-800">공고 관리</h1>
          </div>

<div id=listBoardTableArea>   
	<table id="listBoardTable" class="table table-hover table-sm">
		<tr>
			<th>noti_no</th>
			<th>제목</th>
			<th>마감일</th>
			<th>등록일</th>
			<th>상태</th>
			<th>삭제</th>
			<th>삭제취소</th>
		</tr>
	
		<%	ArrayList<Notification> list=(ArrayList<Notification>)request.getAttribute("list");
			for(Notification n:list){%>
		<tr>
			<td><%=n.getNoti_no() %></td>
			<td><%=n.getTitle() %></td>
			<td><%=n.getEnd_date() %></td>
			<td><%=n.getEnroll_date() %></td>
			<td><%=n.getStatus() %></td>
			<td><button onclick="del(<%=n.getNoti_no()%>)">삭제</button></td>
			<td><button onclick="delCancle(<%=n.getNoti_no()%>)">삭제취소</button></td>
		</tr>
		<%	} %>
	</table>
	<div id=pageArea>
		<%	PageInfo pi=(PageInfo)request.getAttribute("pi");%>
		<%	if(pi.getCurrentPage()>1){ %>
		<button onclick="send(<%=pi.getCurrentPage()-1%>)"><</button>
		<%	} %>
		<%	for(int i=pi.getStartPage();i<=pi.getEndPage();i++){
				if(i==pi.getCurrentPage()){%>
		<button onclick="send(<%=i%>)"><b><%=i %></b></button>
		<%		}else{ %>
		<button onclick="send(<%=i%>)"><%=i %></button>
		<%		} %>
		<%	} %>
		<%	if(pi.getCurrentPage()<pi.getEndPage()){ %>
		<button onclick="send(<%=pi.getCurrentPage()+1%>)">></button>
		<%	} %>
	</div>
</div>
<script>
	function send(pno){
		$('#listBoardTableArea').load("<%=request.getContextPath()%>/noticeList.ad?currentPage="+pno+" table,#pageArea")
	}
</script>
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
	function del(noti_no){
		location.href="<%=request.getContextPath()%>/del.no.ad?noti_no="+noti_no
	}
	function delCancle(noti_no){
		location.href="<%=request.getContextPath()%>/delCancle.no.ad?noti_no="+noti_no
	}
</script>
<script>
	$('#accordionSidebar').children('li.nav-item').eq(1).addClass('active');
</script>
</body>
</html>