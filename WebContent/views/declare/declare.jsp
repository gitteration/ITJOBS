<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String bId = (String)request.getAttribute("bId");
	String title = (String)request.getAttribute("title");
	String boardNick = (String)request.getAttribute("boardNick");
	String head = (String)request.getAttribute("head");

	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%-- <form action="<%=request.getContextPath()%>/insert.de" method="post"> --%>
신고창
<input type="hidden" name="bId" value="<%=bId%>" id="bId">
<input type="hidden" name="head" value="<%=head%>" id="head">

제목:<div name="bId"><%=title %></div><br>
작성자:<div name="boardNick"><%=boardNick %></div><br>
신고내용:<br>
<textarea rows="10" cols="40" name="declare_content" id="declare_content"></textarea><br>
<button type="submit" id="test" onclick="Btn();">신고</button>
<!-- </form> -->

<script>
	$(function(){
		$("#test").click(function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/insert.de",
				data:{head:$("#head").val(), 
					  bId: $("#bId").val(),
					  declare_content :$("#declare_content").val()},
				type:"post",
				success:function(data){
					console.log(data);
					if(data == "1"){
						alert("신고되었습니다.");
						//window.close();
						testtt();
					}
				}
			});
		});
	});
	
	function testtt(){
		window.close();
	}
	
</script>


</body>
</html>