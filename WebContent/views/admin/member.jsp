<%@page import="com.kh.board.model.vo.PageInfo"%>
<%@page import="com.kh.member.model.vo.Member"%>
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
            <h1 class="h1 mb-0 text-gray-800">회원관리</h1>
            
             <!-- Search -->
	        <!--   <form class="d-none d-sm-inline-block form-inline mr-0 ml-md-3 my-2 my-md-0 mw-100 navbar-search">
	            <div class="input-group">
	              <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
	              <div class="input-group-append">
	                <button class="btn btn-primary" type="button">
	                  <i class="fas fa-search fa-sm"></i>
	                </button>
	              </div>
	            </div>
	          </form> -->
          </div>
	
<div id=listMemberTableArea>
	<table class="table table-hover table-sm">
		<thead>
			<tr>
				<th>m_no</th>
				<th>type</th>
				<th>email</th>
				<th>nickname</th>
				<th>status</th>
				<th width="140px">강퇴</th>
			</tr>
		</thead>
		<tbody>
			<%	ArrayList<Member> list=(ArrayList<Member>)request.getAttribute("list");
				for(Member m:list){%>
			<tr>
				<td><%=m.getM_no()%></td>
				<td><%=m.getType() %></td>
				<td><%=m.getEmail() %></td>
				<td><%=m.getNickname() %></td>
				<td><%=m.getStatus() %></td>
				<%	if(m.getStatus().equals("Y")){ %>
				<td><button type="button" class="btn btn-primary btn-sm vanish">강퇴</button></td>
				<%	}else if(m.getStatus().equals("N")){ %>
				<td><button type="button" class="btn btn-primary btn-sm vanishCancle">강퇴취소</button></td>
				<%	}else if(m.getStatus().equals("D")){ %>
				<td><button type="button" class="btn btn-primary btn-sm auth">승인</button></td>
				<%	} %>
			</tr>
			<%	} %>
		</tbody>
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
		$('#listMemberTableArea').load("<%=request.getContextPath()%>/memberList.ad?currentPage="+pno+" table,#pageArea")
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
	$(".vanish").on("click",function(){
		var mno=$(this).closest('tr').children('td').eq(0).text();
		location.href="<%=request.getContextPath()%>/vanish.ad?mno="+mno
	})
	$(".vanishCancle").on("click",function(){
		var mno=$(this).closest('tr').children('td').eq(0).text();
		location.href="<%=request.getContextPath()%>/vanishCancle.ad?mno="+mno
	})
	$(".auth").on("click",function(){
		//var mno=$(this).parent().parent().children().eq(0).children('input').eq(0).data('mno')
		var mno=$(this).closest('tr').children('td').eq(0).text();
		location.href="<%=request.getContextPath()%>/auth.co.ad?mno="+mno
	})
</script>
<script>
	$('#accordionSidebar').children('li.nav-item').eq(0).addClass('active');
</script>
</body>
</html>