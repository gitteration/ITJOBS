<%@page import="com.kh.board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   Board b = (Board)request.getAttribute("b");
   Board prev = (Board)request.getAttribute("prev");
   Board next = (Board)request.getAttribute("next");
   
   String[] videoName = new String[4];
   
   if(b .getVideo() != null){
    	videoName = b.getVideo().split("=");
   }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.max-small {
    width: auto; height: auto;
    max-width: 500px;
    max-height: 500px;
}

</style>
</head>
<body>
   
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

   <!--  <section class="job-detail section"> -->
      <div class="job-alerts-item">
        <div class="row justify-content-between">
          <div class="col-lg-12 col-md-12 col-xs-12">
           <%if(mem != null && mem.getM_no() == b.getM_no()) { %>
          <span class="btn btn-common float-right" onclick="deleteBtn()" style="margin-left: 10px;">삭제</span>&nbsp;&nbsp;&nbsp;
          <span class="btn btn-common float-right" onclick="location.href='<%=contextPath %>/updateForm.bo?bId=<%=b.getB_no()%>';" >수정</span>&nbsp;&nbsp;
          <%}else{ %>
           <span class="btn btn-common float-right" id="deBtn">신고</span>
             <%}%>
            <div class="content-area" style="border-bottom:1px solid lightgray">  
       
              <span style="font-size:20px;"> &nbsp;<%=b.getHead() %></span><br><br>
              
              <p style="font-size:30px; color:black; font-weight:border;"><%=b.getTitle() %></p><br>
              <span style="font-size:18px; color:black;"> &nbsp;<%=b.getNickname() %></span>  &nbsp; &nbsp;
              <span style="font-size:18px; color:black;"><%=b.getUpdate_date() %></span>&nbsp; &nbsp;&nbsp; &nbsp;
              <span id="img1">조회수</span>
              <span style="font-size:18px; color:black;" id="img1_1"><%=b.getCount() %></span>&nbsp; &nbsp;
              <span id="img2">댓글수</span>
           <span style="font-size:18px; color:black;" id="img2_1"><%=b.getReply_count() %></span> &nbsp; &nbsp;
            <%if(b.getEditFile() != null){ %>
           <span id="img2">다운로드수</span>
           <span style="font-size:18px; color:black;" id="img2_1"><%= b.getDown_count() %></span>
           <%} %>
           </div>
           
           
           <br><br>
           <div style="border-bottom:1px solid lightgray">
             <pre style="font-size:20px;color:black;"><%=b.getContents() %></pre><br><br>

            <%if(b.getVideo() != null){%>
            	<iframe width="640" height="360" src="https://www.youtube.com/embed/<%=videoName[1] %>" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
            <%} %>
		
            <%if(b.getEditFile() != null){ %>
            	<%if(b.getFile().contains("jpg") || b.getFile().contains("jpeg") || b.getFile().contains("png")){ %>
               		<img class='max-small' id="img" src="<%= contextPath %>/resources/fileupload_board/<%= b.getEditFile()%>">
            	<%}%>
            <br><br>
            <span><%=b.getFile() %> </span>&nbsp; &nbsp;
            <a href="<%= contextPath %>/download.bo?bId=<%=b.getB_no()%>" class="btn btn-common">다운로드</a> <br><br>
            <% } %>
            </div>
            <br>
             <% if((b.getHead().equals("스터디") || b.getHead().equals("study"))|| (b.getHead().equals("프로젝트") || b.getHead().equals("project"))){ %>
            <div style="font-size:15px;color:black;">모집기간 - <%=b.getTime() %></div><br>
         	<%} %>              
           
         <%if(prev.getTitle() != null){ %>
             <div id="prev">이전글 - <%=prev.getTitle() %> </div>
          <%}else { %>
             <div>이전글 - 이전 글이 없습니다.</div>
          <%} %>
          <%if(next.getTitle() != null){ %>
             <div id="next">다음글 - <%=next.getTitle() %> </div>
          <%}else { %>
             <div>다음글 - 다음 글이 없습니다.</div>
          <%} %>
            
          </div>
        </div>
      </div>
   <!--  </section> -->
   
   <br>
   <div class="job-alerts-item">
      <div id="replyWrite" style="height:50px;">
         <span><textarea rows="2" cols="60" id="replyContent" style="resize: none; overflow:auto;"></textarea></span>
         <span><a class="btn btn-common" id="addReply"style="margin-bottom: 40px;">등록</a></span>            
         </div>
         
            <div id="replySelect">
               
            
           </div>
   
   </div>
   </div>
   
   </div>
   </div>
   </div>
   
      
   
   
      <script>
   		 $(function(){
   			$("#prev").mouseenter(function(){
   				$(this).css({"cursor":"pointer", "color":"red"});
   			}).mouseleave(function(){
   				$(this).css({"color":"gray"});
   			});
   			$("#prev").click(function(){
   				location.href="<%= contextPath %>/detail.bo?head=<%=head%>&bId=<%=prev.getB_no() %>";
   			});
   		});
   		
   		$(function(){
   			$("#next").mouseenter(function(){
   				$(this).css({"cursor":"pointer", "color":"red"});
   			}).mouseleave(function(){
   				$(this).css({"color":"gray"});
   			});
   			
   			$("#next").click(function(){
   				location.href="<%= contextPath %>/detail.bo?head=<%=head%>&bId=<%=next.getB_no() %>";
   			});
   		}); 
      
      $(function(){
         $("#deBtn").click(function(){
        	 
            <%if(mem!=null && !mem.getType().equals("0")){ %>
           		window.open("<%=contextPath %>/insertForm.de?bId=<%=b.getB_no()%>&title=<%=b.getTitle()%>&boardNick=<%=b.getNickname()%>&head=<%=b.getHead()%>", "ITJOBS_게시글 신고", "width=500, height=600, toolbar=no, menubar=no, scrollbars=no, resizable=no"); 
            <%} else if(mem != null && mem.getType().equals("0")){%>
            	alert("관리자는 신고 불가!");
            <%} else{%>
            	alert("로그인해주세요");
            <%}%>
         });
      });
      
      
      function deleteBtn(){

         if(confirm("정말 삭제하시겠습니까?") == true){
            
            location.href="<%=contextPath%>/delete.bo?bId=<%=b.getB_no()%>&head=<%=b.getHead()%>";
         }else{
            return;
         }
      }
      
		 $(function(){
				// 화면 로딩 시 댓글 출력
				selectRlist();
				
				setInterval(function(){
					selectRlist();
				}, 1000);
				
				$("#addReply").click(function(){
					var reply = $("#replyContent");
					if(reply.val().trim().length == 0){
						alert("댓글 내용을 입력해주세요.");
						reply.focus();
						return false;
					} 
				
					<%if(mem != null) { %>
					var content = $("#replyContent").val();
					var bId = <%= b.getB_no()%>;
					
					
					$.ajax({
						url:"brinsert.bo",
						type:"post",
						data:{content:content, bId:bId},
						success:function(status){
							if(status == "success"){
								selectRlist();
								$("#replyContent").val("");
							}else{
								alert("댓글 작성 실패");
							}
						},error:function(){
							console.log("서버 통신 실패");
						}
					});
					
				<% }else{%>
				alert("로그인해야 댓글작성이 가능합니다.");
				<%}%>
				});
		 });
		 
		function selectRlist(){
			$.ajax({
				url:"brlist.bo",
				data:{bId:<%=b.getB_no() %>},
				dataType:"json",
				success:function(list){
					console.log(list);
					
					var replySelect = $("#replySelect");
					
					replySelect.html("");
					
					$.each(list,function(index, value){
						var div = $("<div>").css("border-bottom", "1px dashed lightgray ");
						var a = $("<input type='hidden'>").text(value.re_no).css("width","100px");
						var writer = $("<span>").text(value.nickname).css("width","100px");
					 	var str1 = $("<span>").text(" | ");
						var content = $("<div>").text(value.contents).css("width","400px");
						var date = $("<span>").text(value.update_date).css("width","200px");
						
					    <%-- if(<%=mem.getM_no()%> == value.m_no){ --%>
		                var m_no=0; 
		                <%if(mem!= null){%>
		                m_no=<%=mem.getM_no()%>;
		                <%}%>
		                var deleteRe=$("<span>");
		                <%-- <%   if(mem!=null){ %>
		                //var deleteRe= $("<span>").text("삭제");
		                <%}%> --%>
		                if(m_no==value.m_no){
		                   deleteRe= $("<span>").text("삭제");
		                }
					 		
						
						div.append(a);
						div.append(writer);
					 	div.append(str1);
						div.append(date);
						div.append(content);
						div.append(deleteRe);
				
						
						replySelect.append(div);	
						
						
						deleteRe.click(function(){
							var re_no = $(this).parent().children().eq(0).text();
							
							$.ajax({
						        url: "brDelete.bo",
						        type:"post",
						        data: {re_no : re_no},
						        success: function(result){
						        	
						            if (result=="success") {
						                $("#div").remove();
						                alert("삭제되었습니다.");
						            } else{
						                alert("삭제에실패하였습니다");
						            }
						        }
						    })

                     console.log(re_no);      
                     console.log($(this).parent().children().eq(0).text());
                     
                  })
                  
               });
               
            },error:function(){
               console.log("서버와의 통신실패!!");
            }
         });
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
   $('.inner-header').children('h3').text(page_header_title);
   </script>
   
   
   
   



</body>
</html>