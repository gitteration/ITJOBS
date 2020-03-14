<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.member.model.vo.Member, com.kh.member.model.vo.Co_Info" %>
<%
	Member m = (Member)request.getAttribute("m");
	Co_Info co = new Co_Info();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src='<%=request.getContextPath()%>/resources/naver-smarteditor2-ca95d21/demo/js/service/HuskyEZCreator.js' charset="utf-8"></script>
<script type="text/javascript" src='<%=request.getContextPath()%>/resources/naver-smarteditor2-ca95d21/demo/css/ko_KR/smart_editor2.css' charset="utf-8"></script>
<style>
	h3,#regnum,#filediv,#formDiv{
		margin:0px;
	}


	 #file,#address{
		font-size: 19.5px;
		position: absolute;
		right: 0px;
		top: 0px;
		opacity: 0;
 	    overflow: hidden;
	}
	#file:hover{
		cursor:pointer;
	}

	#filediv{
	position: relative;
    width: 575px;
    height: 40px;
	text-align:center;
		margin-bottom: 0px;
	}
	
	#check{
	border:0px;
	}

	#address{
	font-size: 23px;
	width: 380px;
	}
	#address:hover{
		cursor:pointer;
	}
	.adr{
	border : 1px solid rgb(236,236,236);
	}
	iframe{
	width:300px;
	}
	
</style>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
		<div class="container" style="margin-right: 470px;">
		<div class="row justify-content-center">
		<div class="col-lg-5 col-md-6 col-xs-12">
		<div class="page-login-form box" style="width: 633px;">
		<h3>
		기업 상세정보
		</h3>
		<form class="login-form" action="<%=request.getContextPath() %>/coinfo.me" method="post" autocomplete=off enctype="multipart/form-data" onsubmit="return validate();">
		
		<!---------------------- 1차 기업정보 ------------------------->
		<input type="hidden" value=<%=m.getPw()%> name="pw">
		<input type="hidden" value=<%=m.getNickname()%> name="nickName">		
		<input type="hidden"value=<%=m.getType()%> name="type">
		<input type="hidden" value="<%=m.getEmail()%>" name="email" id="eamil">
		
		
		
		<div class="form-group" id="formDiv">
		<div class="input-icon">
		<i class="lni-lock"></i>
		<input type="text" class="form-control" id="regnum" name="regnum" placeholder="사업자등록번호*" required>
		</div>
		</div>
		
		<div class="btn btn-common log-btn mt-3" id="filediv" name="fileInsert">
		<label id="ttt">사업자등록파일 첨부</label>
		<input type="file" id="file" name="file1"  required>
		</div>  
		
		<div class="btn btn-common log-btn mt-3" id="filediv" >
		로고 첨부
		<input type="file" id="file" name="file2" value="" onchange="loadImg(this,2);" required>
		</div>  
		
		<!-- 우선 주석처리 -->
		<img id ="titleImg2" width="575" height="100" >
		
		<div class="btn btn-common log-btn mt-3" id="filediv" >
		본사 주소지
		<input type="text" id="address" onclick="sample3_execDaumPostcode()" value="우편번호 찾기" required >
		</div>  
		
		<input type="text" id="sample3_postcode" name="sample3_postcode" class="adr" placeholder="우편번호*" required style="width:170px;">
		<input type="text" id="sample3_address" name="sample3_address" class="adr" placeholder="주소*" required style="width:399px;">
		<input type="text" id="sample3_detailAddress" name="sample3_detailAddress" class="adr" required placeholder="상세주소" style="width:571px;">
		<input type="hidden" id="sample3_extraAddress" placeholder="참고항목">
	
		<div id="wrap" style="display:none;border:1px solid;width:500px;height:300px;margin:5px 0;position:relative">
		<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1" onclick="foldDaumPostcode()" alt="접기 버튼">
		</div>
		<!-- 주소api 스크립트 -->
		<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		
		<div class="form-group"style="margin-top:15px;">
		<div class="input-icon">
		<i class="lni-lock"></i>
		<input type="text" class="form-control" id="name" name="name" placeholder="담당자명*" required>
		</div>
		</div>
		<div class="form-group">
		<div class="input-icon">
		<i class="lni-lock"></i>
		<input type="text" class="form-control" id="phone"name="phone" placeholder="담당자폰*" required>
		</div>
		</div>
		<div class="form-group">
		<div class="input-icon">
		<i class="lni-lock"></i>
		<input type="text" class="form-control" id="ceo" name="ceo" placeholder="대표자명*" required>
		</div>
		</div>
		
		
		
		<div class="form-group" >
		<div class="input-icon">
		<i class="lni-lock"></i>
		<input type="text" class="form-control" id="co_phone"name="co_phone" placeholder="대표자폰(-없이)*" pattern="[0-9]{3,12}" title="- 없이 숫자만  입력해주세요" required>
		</div>
		</div>
		<div class="form-group" style="margin-bottom: 0px;">
		<div class="input-icon">
		<i class="lni-lock"></i>
		<input type="text" class="form-control" name="descript" placeholder="사업내용">
		</div>
		</div>
		<div class="form-group">
		<div class="input-icon" >
		<label class="control-label" style="margin-left: 45%;">성립일</label>
		<input class="form-control" type="date" name="birth_date">
		<span class="material-input"></span>
		</div>
		</div>
		<div class="form-group">
		<div class="input-icon">
		<i class="lni-lock"></i>
		<input type="text" class="form-control" id="memsum" name="memsum" placeholder="사원수*(숫자만)" pattern="[0-9]{0,10}" title="숫자만 입력해 주세요" maxlength="9" required> <!-- 우선 필수로 받자 오류는 다음에  -->
		</div>
		</div>
		<div class="form-group"style="margin-bottom: 0px;">
		<div class="input-icon">
		<i class="lni-lock"></i>
		<input type="text" class="form-control" name="revenue" placeholder="매출액*(원)" pattern="[0-9]{0,10}" title="원 단위로 숫자만 입력해 주세요" maxlength="9" required> <!-- 이놈도 필수로 받자   -->
		</div>
		</div>
		
		<section id="editor" style="margin-bottom:0px;">
		<div class="form-group" style="margin-bottom:0px;">
		<label class="control-label" style="margin-left: 45%;">연혁</label>
		<textarea class="form-control" rows="5"  id="history" name="content" style="width:50px;" ></textarea>
		
		</div>
		</section>
		
		<section id="editor" style="margin-bottom:0px;">
		<div class="form-group" >
		<label class="control-label" style="margin-left: 45%;">복지</label>
		<textarea class="form-control" rows="5" id="welfair" name="content" style="width:50px;"></textarea>
		</div>
		</section>
		
		
		<input type="submit" class="btn btn-common log-btn mt-3" value="가입신청" id="submit" >
		
		</form>
		</div>
		</div>
		</div>
		</div>
		</section>
		
		<script>
		/* 사업자등록파일  */
		 $(function(){
				
			var fileInsert = $(document.getElementsByName("fileInsert"));
			
		$("#file").change(function(){
			
			var file = $("#file").val();

				if(file != null || file != ""){
					$("#ttt").html(file).attr('style','color:green');
				}
				if(file == null || file ==""){
					$("#check").attr('value','선택된 파일이 없습니다.').attr('style','color:red');
				}
			})
		}) 
		
		/* 사업자등록파일 */
		$(function(){
			
			$("#file").change(function(){
				
				var file = $("#file").val();
					if(file != null || file != ""){
						$("#check").attr('value',file).attr('style','color:green');
					}
					if(file == null || file ==""){
						$("#check").attr('value','선택된 파일이 없습니다.').attr('style','color:red');
					}
				})
			})
				
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
	 	 oAppRef: oEditors,
 		 elPlaceHolder: document.getElementById('history'),
  		 sSkinURI: "<%=contextPath%>/resources/naver-smarteditor2-ca95d21/demo/SmartEditor2Skin.html",  
    	 fCreator: "createSEditor2",
    	 htParams:{
    	 bUseToolbar:true, // 툴바 사용여부
    	 bUseVerticalResizer:false, // 크기조절바 사용여부
    	 bUseModeChanger : true,	// 모드 탭(Editor | HTML | TEXT) 사용 여부
    	 }
	});
		
		
		nhn.husky.EZCreator.createInIFrame({
	 	 oAppRef: oEditors,
 		 elPlaceHolder: document.getElementById('welfair'),
  		 sSkinURI: "<%=contextPath%>/resources/naver-smarteditor2-ca95d21/demo/SmartEditor2Skin.html",  
    	 fCreator: "createSEditor2",
    	 htParams:{
    	 bUseToolbar:true , // 툴바 사용여부
    	 bUseVerticalResizer:false, // 크기조절바 사용여부
    	 bUseModeChanger : true,	// 모드 탭(Editor | HTML | TEXT) 사용 여부
    	 }
	});
			
			
		$("#submit").click(function(){
			confirm("회원가입을 진행 하시겠습니까?");
			oEditors.getById["history"].exec("UPDATE_CONTENTS_FIELD", []);
			oEditors.getById["welfair"].exec("UPDATE_CONTENTS_FIELD", []);
		});	

		
		</script>
		
		
		
		

<%@ include file="/views/include/user/footer.jsp" %>









<!---------------------------------------------------------------  -->







<!-- 주소*<input type="text" name="address"><br> -->

<!-- 주소api -->


<script>
    
    
    // 우편번호 찾기 찾기 화면을 넣을 element
    var element_wrap = document.getElementById('wrap');

    function foldDaumPostcode() {
        // iframe을 넣은 element를 안보이게 한다.
        element_wrap.style.display = 'none';
    }

    function sample3_execDaumPostcode() {
        // 현재 scroll 위치를 저장해놓는다.
        var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
        new daum.Postcode({
            oncomplete: function(data) {
                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample3_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample3_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
            	document.getElementById('sample3_postcode').value = data.zonecode;
             	 document.getElementById("sample3_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample3_detailAddress").focus();

                // iframe을 넣은 element를 안보이게 한다.
                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                element_wrap.style.display = 'none';

                // 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
                document.body.scrollTop = currentScroll;
            },
            // 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
            onresize : function(size) {
                element_wrap.style.height = size.height+'px';
            },
            width : '100%',
            height : '100%'
        }).embed(element_wrap);

        // iframe을 넣은 element를 보이게 한다.
        element_wrap.style.display = 'block';
  
    	
    
    }
    
    function loadImg(value,num){

		 if(value.files && value.files[0]){
			var reader = new FileReader();
			
			reader.onload = function(e){
				
				$("#titleImg"+num).attr("src",e.target.result); //date:URL
				
			}
			reader.readAsDataURL(value.files[0]);
		 }
	 	}
    
    
    
</script>
	<!-- end of 주소api -->



<!-- <script>
	 function loadImg(value,num){

		 if(value.files && value.files[0]){
			var reader = new FileReader();
			
			reader.onload = function(e){
				
				$("#titleImg"+num).attr("src",e.target.result); //date:URL
				
			}
			reader.readAsDataURL(value.files[0]);
		 }
	 	}
	
	 
	 
	 
	 
	 
</script> -->


</body>
</html>