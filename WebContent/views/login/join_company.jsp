<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#check{
	border:0px;
	}
	#checkDiv{
	margin-bottom:0px;
	}

	.checkDiv2{
	width:200px;height:20px
	
	}
</style>

</head>
<body>

<%@ include file="/views/include/user/js.jsp" %>

<%@ include file="/views/include/user/style.jsp" %>

<%@ include file="/views/include/user/header_nav.jsp" %>



	<div class="page-header">
		<div class="container">
		<div class="row">
		<div class="col-lg-12">
		<div class="inner-header">
		<h3>Create Your account</h3>
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
		기업
		</h3>
		<form class="login-form" id="joinForm"action="<%=request.getContextPath() %>/join.me" method="post" autocomplete=off onsubmit="return validate();">
		<input type="hidden"value=2 name=type readonly>
		<input type="hidden"value=1 name=type readonly>
		<div class="form-group" id="checkDiv">
		<div class="input-icon">
		<i class="lni-user"></i>
		<input type="text" class="form-control" id="nickName" name="nickName" placeholder="기업명(특수문자불가능)" oninput="nickOverlapCheck()" required>
		<div id="nickCheck" class = "checkDiv2"></div>
		</div>
		</div>
		<div class="form-group" id="checkDiv">
		<div class="input-icon">
		<i class="lni-envelope"></i>
		<input type="text" class="form-control" id="email" name="email" placeholder="이메일" oninput="emailOverlapCheck()" required>
		<div id="emailCheck" class = "checkDiv2"></div>
		</div>
		</div>
		<div class="form-group">
		<div class="input-icon">
		<i class="lni-lock"></i>
		<input type="password" class="form-control" name="pw" placeholder="비밀번호" oninput="pwdOverlapCheck()" required>
		</div>
		</div>
		<div class="form-group">
		<div class="input-icon">
		<i class="lni-unlock"></i>
		<input type="password" class="form-control" name="pw1" placeholder="비밀번호 확인" oninput="pwdOverlapCheck()" required>
		<div id="pwdCheck" class = "checkDiv2"></div>
		</div>
		</div>
		<input type="submit" id="submit" class="btn btn-common log-btn mt-3" value="가입" disabled style="background:gray;">
		
		
		
		</form>
		</div>
		</div>
		</div>
		</div>
		</section>
		
		<script>
	
		var flag1 = false;
	 	var flag2 = false;
	 	var flag3 = false;
	 	var flag4 = false;
		
		
	 	/*  닉네임 중복체크 */
		function nickOverlapCheck(){
	
			var nickNameCo = $("#nickName").val();
			
			var nickDiv = $(document.getElementById("nickCheck"));
			
			var regExp = /^[가-힣a-zA-Z0-9]{1,}$/;
			$.ajax({
					url:"<%=request.getContextPath() %>/nickoverlap.me",
					data:{nickNameCo:nickNameCo},
					type:"get",
					success:function(result1){
					
						
						if(result1==1){	
							 nickDiv.html('중복되는 닉네임이 있습니다').attr('style','color:red'); 
							flag1=false;
							btnChange();
						}else if(!regExp.test(nickNameCo)){	
								nickDiv.html('닉네임 양식에 맞지 않습니다').attr('style','color:red');
								flag1=false;
								btnChange();
								}else{
								nickDiv.html('사용가능').attr('style','color:green');
								flag1 = true;
								btnChange();
							}
						
						
						
						
						
						
					},error:function(){
						console.log("ajax실패");
					
					}
			 });
			
		}
		
		
		
		
		/* 이메일 중복체크 */
		function emailOverlapCheck(){
			
			
			var email = $("#email").val();
			
			var emailDiv = $(document.getElementById("emailCheck"));
			/* 이메일 유효성검사  */
			 
			  var regExp = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+)([a-zA-Z]{2,4}))$/;  
			
			
			 if(!regExp.test(email)){
				 emailDiv.html('이메일 형식에 맞지 않습니다').attr('style','color:red');
				 flag4=false;
				btnChange();
			 }else{
					$.ajax({
							url:"<%=request.getContextPath() %>/emoverlap.me",
							data:{email:email},
							type:"get",
							success:function(result){
								if(result==0){	
									emailDiv.html('사용가능').attr('style','color:green');
									flag2 = true;
									flag4=true;
									btnChange();
								}else{	
									emailDiv.html('중복되는 이메일이 있습니다.').attr('style','color:red');
									 flag2 = false;
									flag4=false;
									btnChange();
								}
						
							},error:function(){
								console.log("ajax실패");
							
							}
						});

						
			 		}	
			 
		
			 	}
			/* 비밀번호 유효성검사 */
			
			
			function pwdOverlapCheck(){
		
				var pwdDiv = $(document.getElementById("pwdCheck"));
				
				var pw1 = $("#joinForm input[name=pw]");
				var pw2 = $("#joinForm input[name=pw1]");
				
					if(pw1.val() == pw2.val()){	
						pwdDiv.html('비밀번호와 일치 합니다').attr('style','color:green');
						flag3 = true;
						btnChange();
					}else{	
						pwdDiv.html('비밀번호와 일치하지 않습니다').attr('style','color:red');
						flag3=false;
						btnChange();
					}
					
					
				
			}	
			
			function btnChange(){	// 전체적으로 체크 하기위해서 
				if((flag1&&flag2&&flag3&&flag4)){
					
					$("#submit").attr('disabled',false).attr('style','background:#00bcd4').attr('value','가입');
				}else{
					$("#submit").attr('disabled',true).attr('style','background:gray').attr('value','양식을 확인해 주세요');
				}
			}
		
		</script>


<%@ include file="/views/include/user/footer.jsp" %>




</body>
</html>