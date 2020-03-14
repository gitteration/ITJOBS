<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- import of jobx -->
<%-- <%@ include file="/views/include/user/js.jsp" %> --%>
<!-- End of import of jobx -->
	
    
	<!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="<%=request.getContextPath()%>">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        &nbsp;&nbsp; <img src="<%=request.getContextPath() %>/resources/images/logo12.png" height="50px">
        <div class="sidebar-brand-text mx-3"></div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

     <%--  <!-- Nav Item - Dashboard -->
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/main.ad">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>관리자 메인</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">
 --%>
	<!-- Heading -->
      <div class="sidebar-heading">
        	admin
      </div>

      

      <!-- Nav Item - Charts -->
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/memberList.ad">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>회원관리</span></a>
      </li>
      
      <!-- Nav Item - Charts -->
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/noticeList.ad">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>공고관리</span></a>
      </li>
      
      <!-- Nav Item - Charts -->
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/boardList.ad">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>게시글관리</span></a>
      </li>
      
   <%--    <!-- Nav Item - Charts -->
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/replyList.ad">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>리플관리</span></a>
      </li> --%>
<!--       
   Nav Item - Pages Collapse Menu
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
          <i class="fas fa-fw fa-folder"></i>
          <span>신고 관리</span>
        </a>
        <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <a class="collapse-item" href="list.de?head=board">게시글 신고</a>
          </div>
        </div>
      </li>  
       -->
          <!-- Nav Item - Charts -->
      <li class="nav-item">
        <a class="nav-link" href="list.de?head=board">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>게시글 신고 관리</span></a>
      </li>

      <!-- Nav Item - Tables -->
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/list.qu.ad">
          <i class="fas fa-fw fa-table"></i>
          <span>문의관리</span></a>
      </li>
      
    <%--   <!-- Divider -->
      <hr class="sidebar-divider">
      
      <!-- Heading -->
      <div class="sidebar-heading">
        Interface
      </div>

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>게시판 관리</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <a class="collapse-item" href="<%=request.getContextPath()%>/boardList.ad?head=free">자유게시판</a>
			<a class="collapse-item" href="<%=request.getContextPath()%>/boardList.ad?head=study">스터디</a>
			<a class="collapse-item" href="<%=request.getContextPath()%>/boardList.ad?head=project">프로젝트</a>
			<a class="collapse-item" href="<%=request.getContextPath()%>/boardList.ad?head=qna">문의</a>
			<a class="collapse-item" href="<%=request.getContextPath()%>/boardList.ad?head=form">서식</a>
          </div>
        </div>
      </li>
      
      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseMypage" aria-expanded="true" aria-controls="collapseMypage">
          <i class="fas fa-fw fa-cog"></i>
          <span>댓글 관리</span>
        </a>
        <div id="collapseMypage" class="collapse" aria-labelledby="headingMypage" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
          	<a class="collapse-item" href="<%=request.getContextPath()%>/views/mypage/myinfo.jsp">내 정보 수정</a>
          	<h6 class="collapse-header">일반회원:</h6>
			<a class="collapse-item" href="<%=request.getContextPath()%>/views/mypage/applyList.jsp">지원리스트</a>
			<a class="collapse-item" href="<%=request.getContextPath()%>/views/mypage/likeCompanyList.jsp">관심기업</a>
			<a class="collapse-item" href="<%=request.getContextPath()%>/views/mypage/likeNoticeList.jsp">관심공고</a>
			<a class="collapse-item" href="<%=request.getContextPath()%>/views/mypage/resume/list.jsp">이력서 관리</a>
			<h6 class="collapse-header">기업회원:</h6>
			<a class="collapse-item" href="<%=request.getContextPath()%>/views/mypage/notice/list.jsp">공고리스트</a>
			<a class="collapse-item" href="<%=request.getContextPath()%>/views/mypage/likePersonList.jsp">관심인재</a>
          </div>
        </div>
      </li>

      <!-- Nav Item - Utilities Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
          <i class="fas fa-fw fa-wrench"></i>
          <span>Utilities</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Custom Utilities:</h6>
            <a class="collapse-item" href="utilities-color.html">Colors</a>
            <a class="collapse-item" href="utilities-border.html">Borders</a>
            <a class="collapse-item" href="utilities-animation.html">Animations</a>
            <a class="collapse-item" href="utilities-other.html">Other</a>
          </div>
        </div>
      </li>

	<!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
          <i class="fas fa-fw fa-folder"></i>
          <span>게시판 관리</span>
        </a>
        <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Login Screens:</h6>
            <a class="collapse-item" href="login.html">Login</a>
            <a class="collapse-item" href="register.html">Register</a>
            <a class="collapse-item" href="forgot-password.html">Forgot Password</a>
            <div class="collapse-divider"></div>
            <h6 class="collapse-header">Other Pages:</h6>
            <a class="collapse-item" href="404.html">404 Page</a>
            <a class="collapse-item" href="blank.html">Blank Page</a>
          </div>
        </div>
      </li> --%>
      
      
      <!-- Divider -->
      <hr class="sidebar-divider">

      

      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
    <!-- End of Sidebar -->
    
    
  <!--   <script>
    
    $(function(){
		$(".collapse-item").click(function(){
			$(this).attr("color:blue");
		});
		
	});
   	
    </script> -->
    