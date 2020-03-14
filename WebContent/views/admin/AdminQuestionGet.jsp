<%@page import="com.kh.question.model.vo.Question"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
      var page_header_title='관리자 문의보기'
   </script>
   <!-- end of page-header -->
   
   <div class="container">
<div class="row">


            <!-- left -->
            <%@ include file="/views/include/user/mypage_menu.jsp" %>
            <!-- End of left -->
            

<div class="col-lg-6 col-md-8 col-xs-12">
<div class="inner-box my-resume">
<div class="author-resume">
<div class="about-me item">
<h3>문의보기</h3>
</div>
</div>

<div class="about-me item">
<%-- ${q }<br> --%>
<%	Question q=(Question)request.getAttribute("q");%>
<h3><%=q.getTitle() %></h3>
<span>등록날짜 : <%=q.getEnroll_date() %> | </span>
<span>처리날짜 : <%=q.getEnd_date()%>  |  </span>
&nbsp;
<label>처리상태 : 
<%if(q.getStatus().equals("Y")){ %>
처리완료
<%}else{%>
미처리
<%} %>
</label>
<label>  | 작성자 : <%= q.getM_no() %> </label>
	<div class="form-group">
	<label for="comment"></label>
	<textarea class="form-control" rows="15" id="comment" name="contents"  readonly><%= q.getContents()%></textarea>

<div class="work-experence item">
<%	if(q.getStatus().equals("Y")){ %>
<h3>답변 </h3>
<div class="form-group">
<label for="comment"></label>
<textarea class="form-control" rows="15" id="comment" name="contents"  readonly><%= q.getAnswer()%></textarea>
<%	} %>

<%	if(q.getStatus().equals("N")){%>
<a class="btn btn-common btn-sm" onclick="answer()" >답변하기</a>



<form id=answerForm action="answer.qu" method=post autocomplete=off style="display:none">
<input type=hidden name="qno" value="<%=q.getQ_no() %>">

<textarea class="form-control" rows="15" id="answer" name="answer" ></textarea>

<a class="btn btn-common btn-sm" onclick="answerInsert()">답변등록</a>

</form>
<script>
function answer(){
	$('#answerForm').toggle();
}
</script>
<a class="btn btn-common btn-sm" id="new" href="<%=contextPath%>/list.qu.ad">목록으로</a>

 <%	} %> 
</div>
</div>
</div>
</div>
</div>


</div>
</div>  


  </div>
  


   
   
   
   
   
   
   
   
   
   
   
   
   

<%--            
 <h1>문의보기</h1>
${q }<br>
<%	Question q1=(Question)request.getAttribute("q");%>
내용:<%=q1.getContents() %><br>
<%	if(q1.getStatus().equals("Y")){ %>
답변:<%=q1.getAnswer() %><br>
<%	} %>
<button onclick="location.href='<%=request.getContextPath()%>/list.qu'">목록</button>

<%	if(q1.getStatus().equals("N")){%>
<button onclick="answer()">답변하기</button>(누르면 밑에 창 뜨고 바로 쓸수있게)
<form id=answerForm action="answer.qu" method=post autocomplete=off style="display:none">
<input type=hidden name="qno" value="<%= q1.getQ_no() %>">
답변:<textarea name=answer></textarea><br>
<button>답변등록</button>
</form> --%>



<script>
	function answer(){
		$('#answerForm').toggle();
	}
	
	$('.inner-header').children('h3').text(page_header_title)
	
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
<%--  <%	} %>  --%>

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


   <!-- import of jobx -->
   <%@ include file="/views/include/user/js.jsp" %>
   <!-- End of import of jobx -->
   
   <%@ include file="/views/include/footer.jsp" %> 

 </body>


</html>

