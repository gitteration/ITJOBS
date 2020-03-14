<%@page import="com.kh.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
    div.aaa{
        width:100px;
        height:30px;
        border:0px solid;
        position:relative;
        float:left;
        text-align:center;
        cursor:pointer;
    }
    div.aaa div{
        position:absolute;
        bottom:0px;
        width:0%;
        height:10%;
        opacity:0.7;
        background:white;
    }
</style>
</head>
<body>
${mem }
${msg }
<h1><a href="<%=contextPath %>">ITJobs</a></h1>
<hr>공통 
<a href="<%=contextPath%>/list.bo?head=main">게시판</a>
<a href="<%=contextPath%>/list.bo?head=free">자유게시판</a>
<a href="<%=contextPath%>/list.bo?head=study">스터디</a>
<a href="<%=contextPath%>/list.bo?head=project">프로젝트</a>
<a href="<%=contextPath%>/list.bo?head=qna">공지사항</a>
<a href="<%=contextPath%>/listForm.bo?head=form">서식</a>
<a href="<%=contextPath%>/list.qu"><del>문의사항</del></a>
<a href="<%=contextPath%>/notificationList.se">공고검색(기업상세정보)</a>
<a href="<%=contextPath%>/resumeList.se">인재검색</a>
<hr>공통
<a href="<%=contextPath %>/views/login/join_law.jsp">회원가입</a>
<a href="<%=contextPath %>/login.me">로그인</a>
<a href="<%=contextPath %>/logout.me">로그아웃</a><br>
<hr>일반
<a href="<%=contextPath%>/myInfo.me"><del>내 정보 수정</del></a>
<a href="<%=contextPath%>/myApplyList.vo">지원리스트</a>
<a href="<%=contextPath%>/myCompanyList.like"><del>관심기업</del></a>
<a href="<%=contextPath%>/myNotificationList.like"><del>관심공고</del></a>
<a href="<%=contextPath%>/list.re">이력서 관리</a>
<a href="<%=contextPath%>/mylist.qu"><del>나의 문의</del></a>
+지원하기
<hr>기업

<a href="<%=contextPath%>/myInfo.me"><del>내 정보 수정</del></a>
<a href="<%=contextPath%>/myNotification.me">공고리스트</a>
<a href="<%=contextPath%>/myResumeList.like"><del>관심인재</del></a>
<a href="<%=contextPath%>/mylist.qu"><del>나의 문의</del></a>
<hr>관리자
<%-- <a href="<%=contextPath%>/boardList.ad"><del>게시판관리</del></a>
<a href="<%=contextPath%>/replyList.ad">댓글관리(도 그냥 게시글로 가면 되는건가)</a>
<a href="<%=contextPath%>/memberList.ad"><del>회원관리</del></a>
<a href="<%=contextPath%>/noticeList.ad"><del>공고관리</del></a>
<a href="<%=contextPath%>/list.qu.ad"><del>문의관리</del></a>
<a href="<%=contextPath%>/list.de"><del>신고관리</del></a> --%>
<div class="aaa" onclick="location.href='<%=contextPath%>/boardList.ad'">게시판 관리
    <div></div>
</div>
<div class="aaa" onclick="location.href='<%=contextPath%>/replyList.ad'">댓글 관리
    <div></div>
</div>
<div class="aaa" onclick="location.href='<%=contextPath%>/memberList.ad'">회원 관리
    <div></div>
</div>
<div class="aaa" onclick="location.href='<%=contextPath%>/noticeList.ad'">공고 관리
    <div></div>
</div>
<div class="aaa" onclick="location.href='<%=contextPath%>/list.qu.ad'">문의 관리
    <div></div>
</div>
<div class="aaa" onclick="location.href='<%=contextPath%>/list.de'">신고 관리
    <div></div>
</div>
<br clear="both">
<script>
    function lease(){
        var bar=aaa_div.eq(n)
        aaa.eq(n).css({'background':'#ff4e0b','color':'white'})
        $(bar).animate({
            width: "100%",
        }, 2000, 'linear', function(){
            aaa.css({'background':'white','color':'black'})
            aaa_div.css('width','0%')
            n=(n+1)%6
            lease()
        });
    }

    var aaa=$('.aaa')

    aaa.on('mouseover',function(){
        aaa_div.eq(n).stop()
    }).on('mouseleave',function(){
        var bar=aaa_div.eq(n)

        $(bar).animate({
            width: "100%",
        }, (2000*(100-parseFloat(bar.css('width')))/100), 'linear', function(){
        	aaa.css({'background':'white','color':'black'})
            aaa_div.css('width','0%')
            n=(n+1)%6
            lease()
        });
    })

    var n=0;
    var W=$('.aaa').css('width');
    var aaa_div=$('.aaa').children('div');

    lease()
</script> 
<hr>
</body>
</html>