<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% 
 	String error = (String)request.getAttribute("error"); 
	String findResult = (String)request.getAttribute("findResult");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id"
	content="1000553833429-up535tqsl6oga3f0651pbib7l69ja2ag.apps.googleusercontent.com">

<title>로그인 페이지</title>

<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<script>
	$(function(){
		var error = "<%=error%>";
		var findResult = "<%=findResult%>";
		
		if(error != "null"){
			alert(error);
			
			<% session.removeAttribute("error");%>
		}
		
		if(findResult != "null"){
			alert(findResult);
			<% session.removeAttribute("findResult");%>
		}
		
	});
	</script>




</head>
<body>

	<%@ include file="/views/include/user/style.jsp"%>

	<%@ include file="/views/include/user/header_nav.jsp"%>



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
				<div class="col-lg-5 col-md-6 col-xs-12" style="margin-left: 15%;">
					<div class="page-login-form box">
						<h3>Login</h3>
						<form class="login-form" action="<%=contextPath%>/login.me"
							method=post autocomplete=off onsubmit="return validate();">
							<div class="form-group">
								<div class="input-icon">
									<i class="lni-user"></i> <input type="text" id="sender-email"
										class="form-control" name="email" placeholder="EmailAddress">
								</div>
								<script>
								$('#sender-email').focus()
</script>
							</div>
							<div class="form-group">
								<div class="input-icon">
									<i class="lni-lock"></i> <input type="password" id="pw"
										class="form-control" name="pw" placeholder="Password">
								</div>
							</div>
							<button class="btn btn-common log-btn">로그인</button>
						</form>
						<ul class="form-links">
							<li class="text-center"><a
								href="<%=contextPath%>/joinlaw.jo">회원가입</a><a
								href="<%=contextPath%>/memfindpwd.me">/비밀번호 찾기</a></li>
						</ul>
					</div>
				</div>
				 <span style="margin-top: 101px;"> <span id="naverIdLogin"></span> 
				<!-- <span style="margin-top: 101px;"> <span id="naver_id_login"></span> -->
					<br><br> 
					<span class="g-signin2" data-onsuccess="onSignIn" data-theme="dark" style="width: 186px;"></span>
				</span>
			</div>
		</div>
	</section>

	<script>
	function validate(){
		 $('input[name=email]').focus(); 
			
		 var memEmail = $('#sender-email').val();
		 
		 /* 이메일 유효성검사  */
		 
		/*  var regExp = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/; 
		 
		 if(!regExp.test(memEmail)){
				alert("맞지 않은 이메일 형식입니다.");
				return false;
		 } */
		 
		 if(memEamil.trim().length==0){
			alert("이메일을 입력해주세요");
			$("#sender-email").focus();
			return false;
		}
	
		if(memEmail == ""){
			alert("이메일을 입력해 주세요");
			return false;		
		}
		
		/* 비밀번호 유효성 검사   */
		
		if($("#pw").val().trim().length==0){
			alert("비밀번호를 입력해주세요");
			$("#pw").focus();
			return false;
		}
		
			
			return true;
		
		}		
	

	
	
	

  </script>

	<%-- 네이버 간편로그인 --%> 

	<script type="text/javascript">
  	
	// 아 이거 문제가 있따.. 기존에 회원이 존재하고 이메일이 같을 경우 기존회원꺼에 로그인이 된다..
		
	 	
		
		var naverLogin = new naver.LoginWithNaverId(
				{
					clientId: "ybquUitRdYWWMHEEV389",
					callbackUrl: "http://localhost:8090/itjobs/naverlogin.do",
					isPopup: false, /* 팝업을 통한 연동처리 여부 */
					loginButton: {color: "green", type: 3, height: 40}, /* 로그인 버튼의 타입을 지정 */
					
				}
			);
			naverLogin.init();	 
			
	
	
		/*
	
	 var naver_id_login = new naver_id_login("ybquUitRdYWWMHEEV389", "http://localhost:8090/itjobs");
  	var state = naver_id_login.getUniqState();
  	naver_id_login.setButton("green", 3,40);
    naver_id_login.setDomain("http://localhost:8090/itjobs");  
  	naver_id_login.setState(state);
  	naver_id_login.setPopup(false);
  	naver_id_login.init_naver_id_login(); 	

  	 location.replace(naver_id_login_url); 
 

	
 	 var naver_id_login = new naver_id_login("ybquUitRdYWWMHEEV389", "http://localhost:8090/itjobs");
  	// 접근 토큰 값 출력
 	 alert(naver_id_login.oauthParams.access_token);
 	 // 네이버 사용자 프로필 조회
 	 naver_id_login.get_naver_userprofile("naverSignInCallback()");
  	// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
 	 function naverSignInCallback() {
	    alert(naver_id_login.getProfileData('email'));
	    alert(naver_id_login.getProfileData('nickname'));
	    
	  	 
	} 

  	*/
  	
  	
 
    </script>



	<%@ include file="/views/include/user/footer.jsp"%>



	<%-- 구글 간편로그인 
   
   		 AIzaSyDHKA8HB2t2nNu2Z-n5dBn34a-HfU0MBU8
 		구글 api 아이디	 1000553833429-up535tqsl6oga3f0651pbib7l69ja2ag.apps.googleusercontent.com
		비번     Jc2TkKm84zYNZjMQ25V8e1vK
 	
 	--%>

	<%-- 구글 api --%>
	<script>
	
	    		 function onSignIn(googleUser){
	    		        // Useful data for your client-side scripts:
	    		        var profile = googleUser.getBasicProfile();
	    		        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
	    		        console.log('Full Name: ' + profile.getName());
	    		        console.log('Given Name: ' + profile.getGivenName());
	    		        console.log('Family Name: ' + profile.getFamilyName());
	    		        console.log("Image URL: " + profile.getImageUrl());
	    		        console.log("Email: " + profile.getEmail());

	    		        // The ID token you need to pass to your backend:
	    		        var id_token = googleUser.getAuthResponse().id_token;
	    		       
	   				var googleEm = profile.getEmail();
			    				    	
			    	$.ajax({
			    		url:"<%=request.getContextPath()%>/google.me",
			    		data:{googleEm:googleEm},
			    		type:"get",
			    		success:function(result){
			    		
			    			if(result == 0){
			    				alert("회원가입을 환영합니다");
			    				location.href="<%=request.getContextPath()%>"			    				
			    			
			    			}else{
			    				location.href="<%=request.getContextPath()%>"		
					}

				},
				error : function() {
					console.log("ajax실패");

				}

			});

			// 로그인 후 쿠키 바로 삭제(로그인시 자동로그인 방지하기 위함)

			var auth2 = gapi.auth2.getAuthInstance();
			auth2.signOut().then(function() {
				console.log('User signed out.');
			});

		}
	</script>

</body>
</html>






