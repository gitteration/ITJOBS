<%@page import="java.util.Enumeration"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.board.model.vo.*, java.util.ArrayList"%>
<%
	Board b = (Board)request.getAttribute("b");
	PageInfo pi = (PageInfo)request.getAttribute("pi");  
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");


	  Enumeration param = request.getParameterNames();
	   String strParam = "";
	   while(param.hasMoreElements()) {
	       String name = (String)param.nextElement();
	       String value = request.getParameter(name);
	       strParam += name + "=" + value + "&";
	   }
	   String URL = request.getRequestURL() + "?" + strParam;
	
	   boolean boo  = URL.contains("searchList.bo");
	   
	String sessionSelect = (String)session.getAttribute("sessionSelect");
	String sessionSearch =  (String)session.getAttribute("sessionSearch");
	String sessionHead = (String)session.getAttribute("sessionHead");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- import jobx -->
<%@ include file="/views/include/user/style.jsp" %>
<!-- End of import from jobx -->

<!-- import of jobx -->
<%@ include file="/views/include/user/js.jsp" %>
<!-- End of import of jobx -->
	
</head>
<body>

	<header id="home" class="hero-area">
	<%@ include file="/views/include/user/header_nav.jsp" %>
	</header>

	<!-- page-header -->
	<%@ include file="/views/include/user/page_header.jsp" %>
	<script>
		var page_header_title='게시판'
	</script>
	<!-- end of page-header -->
	

	
	
	<div id="content">
	<div class="container">
	<div class="row">
	<div class="col-lg-4 col-md-12 col-xs-12">
	<div class="right-sideabr">
	<h4>게시판</h4>
	<ul class="list-item">
	<li><a href="<%=contextPath%>/list.bo?head=main">전체보기</a></li>
	<li><a href="<%=contextPath%>/list.bo?head=free">자유</a></li>
	<li><a href="<%=contextPath%>/list.bo?head=study">스터디</a></li>
	<li><a href="<%=contextPath%>/list.bo?head=project">프로젝트</a></li>
	<li><a href="<%=contextPath%>/list.bo?head=qu">공지사항</a></li>
	<li><a href="<%=contextPath%>/listForm.bo?head=form">서식</a></li>
	</ul>
	</div>
	</div>
	
	<% 
	switch(head) {
		case "main" : head="전체보기"; break;
		case "free" : head="자유"; break;
		case "study" : head="스터디"; break;
		case "project" : head="프로젝트"; break;
		case "qu" : head="공지사항"; break;
		case "form" : head="서식"; break;
	}
	%>
	
	<div class="col-lg-8 col-md-12 col-xs-12">
	
	
	<div class="job-alerts-item">
   <h3 class="alerts-title" style="display:inline-block"><%=head%></h3>
    <% if(!(head.equals("공지사항") || head.equals("qu"))){ %>
   <span class="full-time" onclick="writeBtn();" style="float:right">글쓰기</span>
   <%} %>
   <div class="alerts-list">
   <div class="row">
   <div class="col-md-3">
   <p>제목</p>
   </div>
   <div class="col-md-2">
   <p>작성자</p>
   </div>
   <div class="col-md-3">
   <% if(head.equals("스터디") || head.equals("프로젝트")){ %>
   <p>모집기간</p>
   <%} %>
   </div>
   <div class="col-md-2">
   <p>등록일자</p>
   </div>
   <div class="col-md-2">
    <p>조회수</p>
   </div>
   </div>
   </div>
   
   
   <% for(Board i : list) { %>
    <a href="<%= contextPath %>/detail.bo?head=<%=head%>&bId=<%=i.getB_no() %>">
   
   <div class="alerts-content">
   <div class="row">
   <div class="col-md-3">
   <span class="full-time"><%= "No." + i.getB_no() %></span>
   <%if(i.getEditFile() != null){ %>
   <sapn><img style="width:20px; height=20px;"src="<%= contextPath %>/resources/images/fileBoard.png"></sapn>
   <%} %>
    <%if(i.getVideo() != null){ %>
   <sapn><img style="width:20px; height=20px;"src="<%= contextPath %>/resources/images/video.png"></sapn>
   <%} %>
   <br>
   <% if(list.isEmpty()) { %>
            등록된 게시글이 없습니다.
         <% }else { %>
            <%if(head.equals("전체보기")){%>
            <%= "["+i.getHead()+"] "+i.getTitle() %>
            <% }else{ %>
            <%= i.getTitle() %>
            <% } %>   
   <% } %>   
   </div>
   <div class="col-md-2">
   <p><%= i.getNickname() %></p>
   </div>
   <div class="col-md-3">
   <% if(head.equals("스터디") || head.equals("프로젝트")){ %>
   <p><%= i.getTime() %></p>
   <% } %>
   </div>
   <div class="col-md-2">
   <p><span class="location"><%= i.getUpdate_date() %></span></p>
   </div>
   <div class="col-md-2">
   <p><%= i.getCount() %></p>
   </div>
   </div>
   </div>
   </a>
   <% } %>


	<br>
	<div align="center">
	<span><select name="writehead" id="writehead">
		<option value="title">제목</option>
		<option value="contents">내용</option>
		<option value="nickname">닉네임 </option>
	</select></span>
	<span><input type="text" name="search" id="search"></span>
	<span><button onclick="searchBtn()">검색</button></span>
	</div>
	<br>
	
	
	   <ul class="pagination" >
   <% if(pi.getCurrentPage() == 1) {%>
   <li class="active"><a href="#" onclick="return false;"><i class="ti-angle-left"></i> prev</a></li>
   <%}else{ %>
      <%if(URL.contains("search")){ %>
      <li class="active"><a href="<%=contextPath%>/searchList.bo?head=<%=sessionHead%>&select=<%=sessionSelect%>&search=<%=sessionSearch%>currentPage=<%=pi.getCurrentPage()-1%>" class="btn btn-common"><i class="ti-angle-left"></i> prev</a></li>
      <%}else{ %>
      <li class="active"><a href="<%=contextPath%>/list.bo?head=<%=head%>&currentPage=<%=pi.getCurrentPage()-1%>" class="btn btn-common"><i class="ti-angle-left"></i> prev</a></li>
      <%} %>
   <%} %>
   
   <%for(int i=pi.getStartPage(); i<=pi.getEndPage(); i++){%>
   <%if(i == pi.getCurrentPage()){%>
   <li><a href="#" onclick="return false;"><%=i %></a></li>
   <%}else{ %>
      <%if(URL.contains("search")){ %>
      <li><a href="<%=contextPath%>/searchList.bo?head=<%=sessionHead%>&select=<%=sessionSelect%>&search=<%=sessionSearch%>&currentPage=<%=i%>"><%=i %></a></li>
      <%}else{ %>
      <li><a href="<%=contextPath%>/list.bo?head=<%=head%>&currentPage=<%=i%>"><%=i %></a></li>
      <%} %>
   <%} %>
   <%} %>
   
   <% if(pi.getCurrentPage() == pi.getMaxPage()){ %>
   <li class="active"><a href="#" onclick="return false;">Next<i class="ti-angle-right"></i></a></li>
   <%}else{ %>
      <%if(URL.contains("search")){ %>
      <li class="active"><a href="<%=contextPath%>/searchList.bo?head=<%=sessionHead%>&select=<%=sessionSelect%>&search=<%=sessionSearch%>&currentPage=<%=pi.getCurrentPage()+1%>" class="btn btn-common">Next <i class="ti-angle-right"></i></a></li>
      <%}else{ %>
      <li class="active"><a href="<%=contextPath%>/list.bo?head=<%=head%>&currentPage=<%=pi.getCurrentPage()+1%>" class="btn btn-common">Next <i class="ti-angle-right"></i></a></li>
      <%} %>
   <%} %>
   </ul>
   
	
	
	</div>
	</div>
	</div>
	</div>
	</div>
	

	
	
	

		<script>
		
		function searchBtn(){
			var select = $("#writehead").val();
			var search = $("#search").val();
		
			location.href="<%=contextPath %>/searchList.bo?head=<%=head%>&select="+select+"&search="+search; 
		}
		
		
		function writeBtn(){
			<%if(mem != null) {%>
				location.href='<%= contextPath %>/insertForm.bo?head=<%=head%>';
			<%}else{%>
				alert('로그인을 해야 글쓰기가 가능합니다.');
			<%}%>
		}  
				
		</script>
		
	

	
	
	<!-- footer -->
		<%@ include file="/views/include/user/footer.jsp" %>
	<!-- End of footer -->
	
	<!-- back to top button -->
		<a href="#" class="back-to-top"> <i class="lni-arrow-up"></i></a>
	<!-- End of back to top button -->
	
	<!-- 뭔지 모르겠어 -->
	<div id="preloader">
		<div class="loader" id="loader-1"></div>
	</div>
	<!-- 뭔지 모르겠어 -->


	<script>
	$('.inner-header').children('h3').text(page_header_title)
	</script>
</body>
</html>
