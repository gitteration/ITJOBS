<%@page import="com.kh.board.model.vo.PageInfo"%>
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
<style>
	table{
		text-align:center;
	}
</style>
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
            <h1 class="h1 mb-0 text-gray-800">게시판 관리</h1>
          </div>

<div id=listBoardTableArea>          
	<table id="listBoardTable" class="table table-hover table-sm">
		<tr>
			<th>b_no</th>
			<th>머리말</th>
			<th>제목</th>
			<th>작성자</th>
			<th>수정일</th>
			<th>모집날짜</th>
			<th>상태</th>
			<th>삭제</th>
			<th>삭제취소</th>
		</tr>

		<%	ArrayList<Board> list=(ArrayList<Board>)request.getAttribute("list");
		for(Board b:list){%>


		<tr>
			<td><%=b.getB_no() %></td>
			<td><%=b.getHead() %></td>
			<td>
				<a href="<%=request.getContextPath() %>/detail.bo?head=전체보기&bId=<%=b.getB_no()%>"><%=b.getTitle() %></a>
			</td>
			<td><%=b.getM_no() %></td>
			<td><%=b.getUpdate_date().split(" ")[0] %></td>
			<td><%=b.getTime() %></td>
			<td><%=b.getStatus() %></td>
			<td><button onclick="del(<%=b.getB_no()%>)">삭제</button></td>
			<td><button onclick="delCancle(<%=b.getB_no()%>)">삭제취소</button></td>
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
		$('#listBoardTableArea').load("<%=request.getContextPath()%>/boardList.ad?currentPage="+pno+" table,#pageArea")
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
	function del(bno){
		location.href="<%=request.getContextPath()%>/del.bo.ad?bno="+bno
	}
	function delCancle(bno){
		location.href="<%=request.getContextPath()%>/delCancle.bo.ad?bno="+bno
	}
</script>
<script>
$('#accordionSidebar').children('li.nav-item').eq(2).addClass('active');
</script>
</body>
</html>