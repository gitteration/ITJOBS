<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.board.model.vo.*, java.util.ArrayList"%>
<%
	String clickHead = request.getParameter("head");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 에디터  -->
<script type="text/javascript" src='<%=request.getContextPath()%>/resources/naver-smarteditor2-ca95d21/demo/js/service/HuskyEZCreator.js' charset="utf-8"></script>


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
	

	
	<div class="col-lg-8 col-md-12 col-xs-12">
	
	<div class="post-job box">
	<h3 class="job-title">새 글쓰기</h3>
	<form class="form-ad" action="<%=contextPath%>/insert.bo?head=<%=head%>" method="post" enctype="multipart/form-data" id="form" >
	<input type="hidden" value="<%= clickHead %>" name="clickHead">
	<div class="form-group">
	<label class="control-label">Category</label>
	<div class="search-category-container">
	<label class="styled-select">
	<select class="dropdown-product selectpicker" name="writehead" id="writehead">
		<option value="no">-------</option>
		<option value="자유">자유</option>
		<option value="스터디">스터디</option>
		<option value="프로젝트">프로젝트</option>
		<%if(mem.getType().equals("0")){ %>
		<option value="공지사항">공지</option>
		<option value="서식">서식</option>
		<%} %>
	</select>
	</label>
	</div>
	</div>
	<div class="form-group">
	<label class="control-label">제목</label>
	<!-- <input type="text" class="form-control" name="title" placeholder="제목을 입력하세요."> -->
	<input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력하세요">
	</div>
	<section id="editor">
	<div class="form-group">
	<label for="comment">내용</label>
	<textarea class="form-control" rows="5" style="width:100px;" id="comment" name="content"></textarea>
	</div>
	</section>
	<div class="form-group time" >
	<label class="control-label">모집 시작</label>
	<input type="date" class="form-control" name="time1" id="time1" placeholder="yyyy-mm-dd">
	</div>
	<div class="form-group time" >
	<label class="control-label">모집 마감</label>
	<input type="date" class="form-control" name="time2" id="time2" placeholder="yyyy-mm-dd">
	</div>
	<div class="form-group" >
	<label class="control-label">영상첨부(url) * 유튜브 영상만 첨부 가능</label>
	<input type="text" class="form-control" name="video" id="video">
	</div>
	<div class="custom-file mb-3">
	<input type="file" class="custom-file-input" name="file1" id="validatedCustomFile" onchange="fileName(this);" required>
	<label class="custom-file-label form-control" for="validatedCustomFile" id="fileAddArea">choose file...</label>
	<div class="invalid-feedback">Example invalid custom file feedback</div>
	</div>
	<div onclick="window.history.back()" class="btn btn-common">취소</div>
	<div onclick="writeAdd();" class="btn btn-common">등록</div>
	</form>
	</div>	


	</div>
	</div>
	</div>
	</div>
	
	<script>
		var oEditors = [];
	
		nhn.husky.EZCreator.createInIFrame({
	
		 	 oAppRef: oEditors,
		 	 elPlaceHolder: document.getElementById('comment'),
		  	 sSkinURI: "<%=contextPath%>/resources/naver-smarteditor2-ca95d21/demo/SmartEditor2Skin.html",  
		     fCreator: "createSEditor2",
		     htParams:{
		    	 bUseToolbar:true, // 툴바 사용여부
		    	 bUseVerticalResizer:false, // 크기조절바 사용여부
		    	 bUseModeChanger : true,	// 모드 탭(Editor | HTML | TEXT) 사용 여부
		     }
		 });

		function writeAdd(){
			oEditors.getById["comment"].exec("UPDATE_CONTENTS_FIELD", []);
	        var title = $("#title");
	        var content = $("#comment");
	        var select = $("#writehead");
	        var time1 = $("#time1");
	        var time2 = $("#time2");
	        
	        if(select.val() == "no"){
	           alert("머리말을 선택해주세요.");
	           select.focus();
	           return false;
	        }
	        if(title.val().trim().length == 0){
	           alert("제목을 입력해주세요.");
	           title.focus();
	           return false;
	        } 
	        if(select.val() == "스터디" || select.val() == "프로젝트"){
	           if(time1.val().trim().length == 0){
	              alert("모집시작일을 입력해주세요.") 
	              time1.focus();
	              return false; 
	           }
	           if(time2.val().trim().length == 0){
	              alert("모집마감일을 입력해주세요.") 
	              time2.focus();
	              return false; 
	           }
	        }
	        if(content.val().trim().length == 0){
	           alert("내용을 입력해주세요.") 
	           content.focus();
	           return false; 
	        
	        }else{
	            $("#form").submit();
	            
	        } 
	     };
		$(function(){
			$("#writehead").change(function(){
				var select = $("select[name=writehead]").val();

				if(select == "자유" || select == "공지사항"){
					$(".time").hide();
					
				}else{
					$(".time").show();
				}
			});
		});
		$(function(){
			$("#fileArea").hide();
		
			$("#fileAdd").click(function(){
				$("#file1").click();
			});
		});
		
		function fileName(value){
			if(value.files && value.files[0]){
			
				$("#fileAddArea").text(value.files[0].name);
			}
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
