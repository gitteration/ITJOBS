<%@page import="com.kh.declare.model.vo.Declare"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String Dhead = (String)request.getAttribute("Dhead");
	switch(Dhead){
	case "noti" : Dhead="공고"; break;
	case "board" : Dhead="게시글"; break;
	case "reply" : Dhead="댓글"; break;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#listArea,#viewArea{
		display:inline-block;
		vertical-align:top;
	}
	#listArea{
		width:60%;
	}
	#viewArea{
		width:30%;
	}
</style>
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
            <h1 class="h1 mb-0 text-gray-800"><%= Dhead %>신고 관리</h1>
          </div>
          

<div id="manageBoard">
	<div id="listArea">
		<table class="table table-hover table-sm">
			<thead>
				<tr>
					<th><input type=checkbox></th>
					<th>no</th>
					<th>b_no</th>
					<th>m_no</th>
					<th>등록일</th>
					<th>처리일</th>
					<th>상태</th>
					<th>보기</th>
					<th>처리</th>
				</tr>
			</thead>
			<tbody>
				<%if(Dhead=="게시글"){%>
				<%	ArrayList<Declare> blist=(ArrayList<Declare>)request.getAttribute("blist");
					for(Declare m:blist){%>
				<tr>
					<td><input type=checkbox data-mno="<%=m.getM_no()%>"></td>
					<td><%=m.getDe_no() %></td>
					<td><%=m.getB_no() %></td>
					<td><%=m.getM_no() %></td>
					<td><%=m.getEnroll_date() %></td>
					<td><%=m.getComp_date() %></td>
					<td><%=m.getStatus() %></td>
					<td><button onclick="view(<%=m.getDe_no()%>)">보기</button></td>
					<td><button onclick="complete(<%=m.getDe_no()%>)">처리완료</button></td>
				</tr>
					<%} %>
				<%	}else if(Dhead=="공고") {%>
				<%	ArrayList<Declare> nlist=(ArrayList<Declare>)request.getAttribute("nlist");
					for(Declare m:nlist){%>
				<tr>
					<td><input type=checkbox data-mno="<%=m.getM_no()%>"></td>
					<td><%=m.getDe_no() %></td>
					<td><%=m.getNoti_no() %></td>
					<td><%=m.getB_no() %></td>
					<td><%=m.getRe_no() %></td>
					<td><%=m.getM_no() %></td>
					<td><%=m.getEnroll_date() %></td>
					<td><%=m.getComp_date() %></td>
					<td><%=m.getStatus() %></td>
					<td><button onclick="view(<%=m.getDe_no()%>)">보기</button></td>
					<td><button onclick="complete(<%=m.getDe_no()%>)">처리완료</button></td>
				</tr>
					<%} %>
				<%	}else if(Dhead=="댓글") {%>
				<%	ArrayList<Declare> rlist=(ArrayList<Declare>)request.getAttribute("rlist");
					for(Declare m:rlist){%>
				<tr>
					<td><input type=checkbox data-mno="<%=m.getM_no()%>"></td>
					<td><%=m.getDe_no() %></td>
					<td><%=m.getNoti_no() %></td>
					<td><%=m.getB_no() %></td>
					<td><%=m.getRe_no() %></td>
					<td><%=m.getM_no() %></td>
					<td><%=m.getEnroll_date() %></td>
					<td><%=m.getComp_date() %></td>
					<td><%=m.getStatus() %></td>
					<td><button onclick="view(<%=m.getDe_no()%>)">보기</button></td>
					<td><button onclick="complete(<%=m.getDe_no()%>)">처리완료</button></td>
				</tr>
				<%} %>
				<%} %>
			</tbody>
		</table>
	</div>
	<div id="viewArea">
		
	</div>
</div>

<script>
	<%if(Dhead=="게시글"){%>
	function view(de_no){
		 $('#viewArea').load("<%=request.getContextPath()%>/get.de.bo?de_no="+de_no+" div#detail");
	}
	<%}else if(Dhead=="공고"){%>
	function view(de_no){
		 $('#viewArea').load("<%=request.getContextPath()%>/get.de.no?de_no="+de_no+" div#detail");
	}	 
	<%}else if(Dhead=="댓글"){%>
	function view(de_no){
		 $('#viewArea').load("<%=request.getContextPath()%>/get.de.re?de_no="+de_no+" div#detail");
	}
	<%}%>
	
	<%if(Dhead=="게시글"){%>
	function complete(de_no){
		location.href="<%=request.getContextPath()%>/complete.de.bo?de_no="+de_no;
	}
	<%}else if(Dhead=="공고"){%>
	function complete(de_no){
		location.href="<%=request.getContextPath()%>/complete.de.no?de_no="+de_no;
	}	 
	<%}else if(Dhead=="댓글"){%>
	function complete(de_no){
		location.href="<%=request.getContextPath()%>/complete.de.re?de_no="+de_no;
	}
	<%}%>
</script>
<%-- <hr>
<h1>게시판 신고</h1>
<table border=1>
	<thead>
		<tr>
			<th><input type=checkbox></th>
			<th>no</th>
			<th>b</th>
			<th>re</th>
			<th>noti</th>
			<th>m</th>
			<th>content</th>
			<th>등록일</th>
			<th>처리일</th>
			<th>상태</th>
		</tr>
	</thead>
	<tbody>
		<%	ArrayList<Declare> rlist=(ArrayList<Declare>)request.getAttribute("rlist");
			for(Declare m:rlist){%>
		<tr>
			<td><input type=checkbox data-mno="<%=m.getM_no()%>"></td>
			<td><%=m.getDe_no() %></td>
			<td><%=m.getB_no() %></td>
			<td><%=m.getRe_no() %></td>
			<td><%=m.getNoti_no() %></td>
			<td><%=m.getM_no() %></td>
			<td><%=m.getContents() %></td>
			<td><%=m.getEnroll_date() %></td>
			<td><%=m.getComp_date() %></td>
			<td><%=m.getStatus() %></td>
		</tr>
		<%	} %>
	</tbody>
</table>
<hr>
<h1>공고 신고</h1>
<table border=1>
	<thead>
		<tr>
			<th><input type=checkbox></th>
			<th>no</th>
			<th>b</th>
			<th>re</th>
			<th>noti</th>
			<th>m</th>
			<th>content</th>
			<th>등록일</th>
			<th>처리일</th>
			<th>상태</th>
		</tr>
	</thead>
	<tbody>
		<%	ArrayList<Declare> nlist=(ArrayList<Declare>)request.getAttribute("nlist");
			for(Declare m:nlist){%>
		<tr>
			<td><input type=checkbox data-mno="<%=m.getM_no()%>"></td>
			<td><%=m.getDe_no() %></td>
			<td><%=m.getB_no() %></td>
			<td><%=m.getRe_no() %></td>
			<td><%=m.getNoti_no() %></td>
			<td><%=m.getM_no() %></td>
			<td><%=m.getContents() %></td>
			<td><%=m.getEnroll_date() %></td>
			<td><%=m.getComp_date() %></td>
			<td><%=m.getStatus() %></td>
		</tr>
		<%	} %>
	</tbody>
</table> --%>

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
	var dlendud=$('#accordionSidebar').children('li').eq(3).children();
	dlendud.eq(0).removeClass('collapsed').attr('aria-expanded','true')
	dlendud.eq(1).addClass('show').children('div').children('a').eq(0).addClass('active')
</script>
</body>
</html>