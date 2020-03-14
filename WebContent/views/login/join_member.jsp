<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	
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
		일반
		</h3>
		<form class="login-form" id="joinForm" action="<%=request.getContextPath() %>/join.me" method="post" autocomplete="off" >
		<input type="hidden"value=1 name=type readonly>
		<div class="form-group" id="checkDiv">
		<div class="input-icon">
		<i class="lni-user"></i>
		<input type="text" class="form-control" id="nickName" name="nickName" placeholder="닉네임(8자리이하  ,특수문자불가능)" oninput="nickOverlapCheck()" maxlength="8" required>
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
	 	
		
		// ajax는 비동기식여서 진행되는 방식이 일정하지 않으므로 주의하자 !
		
		// 전체적으로 결과가 true 여야 넘어가게끔 받은 변수들(안그러면 disabled 가 제대로 작동하지 않음)
	 	var flag1 = false;
	 	var flag2 = false;
	 	var flag3 = false;
	 	var flag4 = false;
		/*  닉네임 중복체크 */
		function nickOverlapCheck(){
			var nickName = $("#nickName").val();	// 아이디 값을 선택자로 해당하는 아이디값을 받고
			var nickDiv = $(document.getElementById("nickCheck")); // 결과를 보여줄 div 영역 를 받고
			var regExp = /^[가-힣a-zA-Z0-9]{1,}$/;	// 1자 이상 한글,영어,숫자가 포함되어야  하고				
			$.ajax({
					/* ajax로 닉네임을 중복체크하기 위해   */
					url:"<%=request.getContextPath() %>/nickoverlap.me",  
					data:{nickName:nickName},
					type:"get",
					success:function(result1){	
						/* 양식이 맞지 않으면 */
						if(!regExp.test(nickName)){			 
								nickDiv.html('닉네임 양식에 맞지 않습니다').attr('style','color:red');
								flag1=false;
								btnChange();
						/* 중복되면 */
						}else if(result1==1){		
								nickDiv.html('중복되는 닉네임이 있습니다').attr('style','color:red'); 
								flag1=false;
								btnChange();	
						/* 사용가능  */
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
			/* 이메일 값을 받아 */
			var email = $("#email").val();
			/* 결과 div를 담고 */
			var emailDiv = $(document.getElementById("emailCheck"));
			/* 이메일 유효성검사  */
			 var regExp = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+)([a-zA-Z]{2,4}))$/;  
			 if(!regExp.test(email)){
				/* 형식이 맞지 않으면 */
				 emailDiv.html('이메일 형식에 맞지 않습니다').attr('style','color:red');
				flag4=false;
				btnChange();	
				/* btnchange() 함수를 매번 실행시켜 주는 이유는 그렇지 않으면 가입버튼이 정상적으로 작동을 안함.  */
			 }else{
					$.ajax({
							url:"<%=request.getContextPath() %>/emoverlap.me",
							data:{email:email},
							type:"get",
							success:function(result){	
								/* 중복되는 닉네임이 없으면 */	
								if(result==0){	
									flag2 = true;
									flag4=true;
									emailDiv.html('사용가능').attr('style','color:green');
									btnChange();
								}else{	
									/* 있으면 */									
									 flag2 = false;
									 flag4=false;
									emailDiv.html('중복되는 이메일이 있습니다').attr('style','color:red');
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
				
				var pw1 = $("#joinForm input[name=pw]");    // 첫 번째 비밀번호
				var pw2 = $("#joinForm input[name=pw1]");   // 두 번째 비밀번호
				
					if(pw1.val() == pw2.val()){	  // 둘 다 일치하면
						pwdDiv.html('비밀번호와 일치 합니다').attr('style','color:green');
						flag3 = true;
						btnChange();
					}else{	 // 그렇지 않으면
						pwdDiv.html('비밀번호와 일치하지 않습니다').attr('style','color:red');
						flag3=false;
						btnChange();
					}
				
			}	
			
			

			function btnChange(){	// 전체적으로 체크 하기위해서 (중요)
				
				if((flag1&&flag2&&flag3&&flag4)){	
					$("#submit").attr('disabled',false).attr('style','background:#00bcd4').attr('value','가입');
				}else{
					$("#submit").attr('disabled',true).attr('style','background:gray').attr('value','양식을 확인해 주세요');
				}
			}
			
		</script>
	 
	 
	 
	 
		
<%@ include file="/views/include/user/footer.jsp" %>


<!-- 회원가입 이메일인증 ajax  -->



<script>
	
	$(function(){
			
			
			$(".cerBtn").click(function(){
				
				var email =	$(".email").val();
				
			
					/* 생각해 보니 구지 db까지 안가고 키값만 받아서 가능함 하지만 만들어 논게 아까워서 우선 이렇게 처리   */	
		 			 $.ajax({
						url:"<%=request.getContextPath() %>/certify.mem",
						data:{email:email},
						type:"get",
						success:function(cerNo){		// db에 이메일과 임시 비밀번호 저장 후 임시 비밀번호를 result값으로 받아 
							
										 $.ajax({		//  이메일로 보내줄 ajax 실행
												url:"<%=request.getContextPath()%>/cerno.em",
												data:{email:email,cerNo:cerNo},
												type:"get",
												success:function(result1){		
													
													var input_no1="";
													var input_no2="";
													
													 input_no = prompt("인증번호를 입력해주세요");
																 
													 	if(input_no == cerNo){
													 		alert("인증에 성공 하셨습니다.");
													 	}else{
													 		 input_no1 = prompt("인증번호가 다릅니다. 다시 입력해 주세요");
													 			if(input_no1 == cerNo){
													 				alert("인증에 성공 하셨습니다");
													 			}else{
													 		 		input_no2 = prompt("인증번호가 다릅니다. 다시 입력해주세요");
													 				if(input_no2 == cerNo){
													 				alert("인증에 성공 하셨습니다");
													 				}else{
													 				alert("이메일을 다시 한 번 확인 후 재인증 부탁 드립니다.");
													 				}
													 			}
													 	}
												
													if(input_no == null || input_no1 == null || input_no2 == null){
														request.setAttribute("email","email");
														request.setAttribute("cerNo","cerNo");
														location.href="<%=request.getContextPath()%>/cerno.de";
													}	 
																 														 
												},error:function(){
													
													console.log("ajax실패");
												}
										
											}) 			 								 
										 
									},error:function(){
									
									console.log("ajax실패");
									}
				
								}) 
							})
						})

		
</script>




</body>
</html>