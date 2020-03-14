<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@page import="com.kh.resume.model.vo.Resume,java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<% 
 	Resume re = (Resume)request.getAttribute("re");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이력서 수정</title>
</head> 
<body>
<div id="head"></div>
</head>
<body>
<form action="<%=request.getContextPath()%>/update.re" method="post" enctype="multipart/form-data">
<h2 align="center">이력서 작성</h2>
	<%	if(re.getPath()==null|| re.getPhoto()==null || re.getPath().equals("null") || re.getPhoto().equals("null")){ %>
	<img id="titleImg"></img>
	<%	} else { %>
	<img id="titleImg" src="resources/fileupload_resumeImg/<%=re.getPhoto()%>"><br>
	<% } %>
<input type="file" name="file" onchange="loadImg(this)">
<script>
	function loadImg(value){
		console.log(value.files)
		console.log(value.files[0])
		if(value.files && value.files[0]){
			var reader = new FileReader();
			reader.onload = function(e){
				console.log(e.target)
				 $("#titleImg").attr("src", e.target.result); // data:URL
				 console.log(e.target.result);
			}
			reader.readAsDataURL(value.files[0]);
		}
	}
</script>
<hr><% System.out.print(re.getBirth_date()); %>
	<input type=hidden name="resume_no" value="<%=re.getResume_no()%>">
	<input type=hidden name="path" value="<%=re.getPath()%>">
	<input type=hidden name="photo" value="<%=re.getPhoto()%>">
	이름: <input type="text" id="name" name="name" value="<%=re.getName()%>"><br>
	생년월일: <input type="Date" id="birth" name="birth" value="<%=re.getBirth_date()%>"><br>
	핸드폰번호: <input type="text" id="phone" name="phone" value="<%=re.getPhone()%>"><br>
	이메일: <input type="text" id="email" name="email" value="<%=re.getEmail()%>"><br>
	
	<%	String[] arr_address=re.getAddress().split("\\+"); %>
	<!-- 주소api -->
	주소:
	<input type="text" id="sample3_postcode" name="sample3_postcode" value="<%=arr_address[0] %>" placeholder="우편번호">
	<input type="button" onclick="sample3_execDaumPostcode()" value="우편번호 찾기"><br>
	<input type="text" id="sample3_address" name="sample3_address" value="<%=arr_address[1] %>" placeholder="주소">
	<input type="text" id="sample3_detailAddress" name="sample3_detailAddress" value="<%=arr_address[2] %>" placeholder="상세주소">
	<input type="hidden" id="sample3_extraAddress" placeholder="참고항목">
	<div id="wrap" style="display:none;border:1px solid;width:500px;height:300px;margin:5px 0;position:relative">
		<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1" onclick="foldDaumPostcode()" alt="접기 버튼">
	</div>
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="resources/util/address_api.js"></script>
	<!-- end of 주소api -->	
<hr>
	<%	String school_final=re.getSchool_final();
		String[] checked_school_final=new String[3];
		switch(school_final){
		case "1":checked_school_final[0]="checked";break;
		case "2":checked_school_final[1]="checked";break;
		case "3":checked_school_final[2]="checked";break;
		}
		
		String[] arr_school=re.getSchool().split(",");
		String[] arr_department=re.getDepartment().split(",");%>
		<input type="radio" name="school_final" value="1" <%=checked_school_final[0] %>>고등학교 졸업<br>	
		학교명: <input type="text" name="school" value="<%=arr_school[0] %>"><br>
		학과명: <input type="text" name="Department" value="<%=arr_department[0] %>"><br>
<!-- 		<select name="Department">
			<option value="">--학교계열--</option>
			<option value="문과" selected>문과계열</option>
			<option value="이과">이과계열</option>
			<option value="전문">전문(실업)계</option>
			<option value="예체능">예체능계</option>
			<option value="특성화/마이스터">특성화/마이스터고</option>
			<option value="특수목적">특수목적고</option>
		</select> -->
		날짜: <input type="date" name="school_Date1" value="2010-01-01"> ~
		<input type="date" name="school_Date2" value="2010-01-02">
<hr>	
<%-- 		<input type="radio" id="college" name="school_final" value="2" <%=checked_school_final[1] %>>초대졸 졸업<br>
		학교명: <input type="text" name="school" value="<%=arr_school[1] %>"><br>
		학과명: <input type="text" name="Department" value="<%=arr_department[1] %>"><br>
		날짜: <input type="date" name="school_Date1" value="2010-01-01"> ~
		<input type="date" name="school_Date2" value="2010-01-02">
	
<hr>
		<input type="radio" id="university" name="school_final" value="3" <%=checked_school_final[2] %>>대졸 졸업 이상<br>
		<label>학교</label>
		<select name="gubun">
			<option value="4">--대학교--</option>
			<option value="4">대학교 4년제</option>
			<option value="s">대학원(석사)</option>
			<option value="p">대학원(박사)</option>
		</select>
		<br>
		
		학교명: <input type="text" name="school" value="<%=arr_school[2] %>"><br>
		학과명: <input type="text" name="Department" value="<%=arr_department[2] %>"><br>
		날짜: <input type="date" name="school_Date1" value="2010-01-01"> ~
		<input type="date" name="school_Date2" value="2010-01-02"> --%>
	</div>
<hr>
	<input type="radio" name="career" value="N" checked>신입
	<input type="radio" name="career" value="Y" >경력
	<input type="button" onclick="add_career()" value="+ 경력추가하기">
	<div id="careerList">
		<div id="careerForm">
			일한회사: <input type="text" name="companyName" value="1"><br>
			한 일: <input type="text" name="workList" value="1"><br>
			근무날짜: 
			<input type="date" name="workDate1" id="workDate1" value="2006-01-01"> ~
			<input type="date" name="workDate2" id="workDate2" value="2010-01-01"><br>
			경력년수 : <input name="career_year" value="2">
			<!-- <input type="button" id="careerButton" value="경력 계산" onclick="math();" >  -->
			<br>
			<div id="durl"></div>
		</div>
	</div>
<hr>
	<input type="button" value="+ 자격증 추가하기" onclick="add_cer()">
	<div id="cerList">
		<div id="cerForm">
			자격증: <input type="text" name="cer_name" value="1"><br>
			날짜: <input type="date" name="cer_date"  value="2010-01-01">
		</div>
	</div>
<hr>
	희망연봉금액: 
	<select name="hope_salary">
	    <option value="회사내규에따름">회사내규에따름<option>
		<option value="2000만원 ~ 2200만원">2000만원 ~ 2200만원<option>
		<option value="2200만원 ~ 2400만원">2200만원 ~ 2400만원<option>
		<option value="2400만원 ~ 2600만원">2400만원 ~ 2600만원<option>
		<option value="2600만원 ~ 2800만원">2600만원 ~ 2800만원<option>
		<option value="2800만원 ~ 3000만원">2800만원 ~ 3000만원<option>
	</select>
<hr>	
	<input type="radio" name="open" value="Y" checked>공개
	<input type="radio" name="open" value="N" >비공개
<hr>
	이력서 제목: <input type="text" maxlength="100" size="100px" name="title" value="1"><br>
	<select name="select" onchange="selectInput();">
		<option value="">== 선택없음 ==</option>
		<option value="title_1" selected>많이 일하고 조금 받겠습니다 뽑아주세요</option>
		<option value="title_2">취업하고 싶습니다 채용해주세요</option>
		<option value="title_3">백수그만하고싶습니다 돈벌게해주세요</option>
	</select>
<hr>
	<%	String[] arr_lan=re.getP_language().split(",");
		String[] checked_lan=new String[4];
		for(int i=0;i<arr_lan.length;i++){
			switch(arr_lan[i]){
			case "c언어":checked_lan[0]="checked";break;
			case "자바":checked_lan[1]="checked";break;
			case "CSS":checked_lan[2]="checked";break;
			case "javascript":checked_lan[3]="checked";break;
			}
		}%>
	프로그램언어: 
	<input type="checkbox" name="p" value="c언어" <%=checked_lan[0] %>>c언어
	<input type="checkbox" name="p" value="자바" <%=checked_lan[1] %>>자바
	<input type="checkbox" name="p" value="CSS" <%=checked_lan[2] %>>css
	<input type="checkbox" name="p" value="javascript" <%=checked_lan[3] %>>javascript
	<br>
	자기소개: <textarea id="self" name="self"><%=re.getCover_letter()%></textarea><br>
	<input type="submit" value="작성완료">
</form>

<script>
	function setDisplay(){
	    if($('input:radio[id=high]').is(':checked')){
	        $('#highInfo').show();
	        $('#collegeInfo').hide();
	        $('#academyInfo').hide();
	        
	    }else if($('input:radio[id=college]').is(':checked')){ 
	    	$('#highInfo').hide();
	    	 $('#collegeInfo').show();
	        $('#academyInfo').hide();
	    }else{
	    	$('#highInfo').hide();
	   	 $('#collegeInfo').hide();
	       $('#academyInfo').show();
	    }
	}
 
	function add_career(){
	/* 	 var form=$('#careerForm')
		 var str=form.html();
		 str=str.replace('</div>','<button onclick="del_career()">삭제</button></div>')
		 console.log(str)
		 $('#careerList').append(str) */
	 	var str='<div id="careerForm">';
		str+='<label>근무 회사명</label>';
		str+='<input type="text" name="companyName" value="1"><br><br>';
		str+='<label>업무 내용 </label>';
		str+='<input type="text" name="workList" value="1"><br><br>';
		str+='<label>근무 일자</label>';
		str+='<input type="date" name="workDate1" value="2010-01-01"> ~';
		str+='<input type="date" name="workDate2" value="2010-01-01">';
		str+='<br><br>';
		str+='<span class="del_career" style="cursor:pointer;">삭제</span></div>';
		str+='</div>';
		$('#careerList').append(str)
	}
	$(document).on('click','.del_career',function(){
		$(this).closest('div #careerForm').remove();
	})

	function add_cer(){
		var str='<div id="cerForm">';
		str+='<label>자격증명</label>';
		str+='<input type="text" name="cer_name" value="1"><br><br>';
		str+='<label>취득날짜</label>';
		str+='<input type="date" name="cer_date"  value="2010-01-01">';
		str+='<br>';
		str+='<span class="del_cer" style="cursor:pointer;">삭제</span></div>';
		str+='</div>';
		$('#cerList').append(str)
	}
	$(document).on('click','.del_cer',function(){
		$(this).closest('div #cerForm').remove();
	})
	
	function math(){
		var inputDate1 = $("#workDate1").val();
		var inputDate2 = $("#workDate2").val(); 
		var dateArrayDate1 = inputDate1.split("-");  	
		var dateArrayDate2 = inputDate2.split("-");
		var dateObj1 = new Date(dateArrayDate1[0], Number(dateArrayDate1[1])-1, dateArrayDate1[2]);  
		var dateObj2 = new Date(dateArrayDate2[0], Number(dateArrayDate2[1])-1, dateArrayDate2[2]);  
		var betweenDay = (dateObj2.getTime() - dateObj1.getTime());  
		if(betweenDay/1000 /60 /60 /24 < 0){
			alert("날짜값이 맞지않습니다. 다시 입력해주세요");
		}else{
			var lastDate = parseInt((betweenDay/365));
			alert("경력"+lastDate+"년차입니다.");
		}
	}
</script>

<%@ include file="/views/include/footer.jsp" %>
</body>
</html>