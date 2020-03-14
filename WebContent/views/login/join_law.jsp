<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

</head>
<body>

<%@ include file="/views/include/user/style.jsp" %>

<%@ include file="/views/include/user/header_nav.jsp" %>


<div class="page-header">
<div class="container">
<div class="row">
<div class="col-lg-12">
<div class="inner-header">
<h3>회원가입</h3>
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


<div class="form-group">
<div class="input-icon">


</div>
</div>
<div class="form-group">
<div class="input-icon">


</div>
</div>
<div class="form-group form-check">


</div>

<button class="btn btn-common log-btn" onclick="location.href='<%=contextPath%>/join.seeker'">일반(구직)</button>

<button class="btn btn-common log-btn" onclick="location.href='<%=contextPath%>/join.co'">기업(구인)</button>


</div>
</div>
</div>
 </div>
</section>


<%@ include file="/views/include/user/footer.jsp" %>


	

</body>
</html>