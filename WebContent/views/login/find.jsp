<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String findResult = (String)request.getAttribute("findResult"); %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/views/include/user/style.jsp" %>

<%@ include file="/views/include/user/header_nav.jsp" %>

<%@ include file="/views/include/user/js.jsp" %>  
<script>
	$(function(){
		var findResult = "<%=findResult%>";
		
		if(findResult != "null"){
			alert(findResult);
			
			// 세션에 담긴 메세지 한번만 출력하고 삭제하기
			<% session.removeAttribute("findResult"); %>
		}
	});
</script>



</head>
<body>

<div class="page-header">
<div class="container">
<div class="row">
<div class="col-lg-12">
<div class="inner-header">
<h3>Login</h3>
</div>
</div>
</div>
</div>
</div>


<section id="content" class="section-padding">
<div class="container">
<div class="row justify-content-center">
<div class="col-lg-5 col-md-6 col-xs-12">
<div class="page-login-form box">
<h3>
비밀번호찾기
</h3>
<form class="login-form" action="<%=contextPath%>/findpwd.me" method=post autocomplete=off onsubmit="return validateEmail();">

<div class="form-group">
<div class="input-icon">
<i class="lni-user"></i>
<input type="text" id="sender-email" class="form-control" name="email" placeholder="EmailAddress">
</div>
</div>
<button type="submit" class="btn btn-common log-btn" >비밀번호 발송</button>
</form>
</div>
</div>
</div>
 </div>
</section>


<script>
	$('#sender-email').focus();
	
		function validateEmail(){
			
	
			var memEmail = $('#sender-email').val();
			
			if(memEmail == ""){
				alert("이메일을 입력해 주세요");
				return false;		
			}
		
			var regExp = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
			
			if(!regExp.test(memEmail)){
				alert("맞지 않은 이메일 형식입니다.");
				return false;
			}else{
				return true;
			}
		
		
		}
			

		
	
	
	
	
</script>


<%@ include file="/views/include/user/footer.jsp" %>
</body>
</html>