<%@page import="com.kh.board.model.vo.Board"%>
<%@page import="com.kh.notification.model.vo.Notification"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/views/include/user/style.jsp"%>

<%@ include file="/views/include/user/js.jsp"%>






<!-- import jobx -->
<!-- End of import from jobx -->

</head>
<body>

   <header id="home" class="hero-area">
      <%@ include file="/views/include/user/header_nav.jsp"%>
      <div class="container">
         <div class="row space-100 justify-content-center">
            <div class="col-lg-10 col-md-12 col-xs-12">
               <div class="contents">
               <h2 class="head-title" >IT JOBS</h2>
                  <h2 class="head-title">Find the job that fits your life</h2>
                  
                  <div class="job-search-form">
                     <form action="notificationList.se" method="get" autocomplete=off>
                        <div class="row justify-content-md-center">
                           <div class="col-lg-5 col-md-5 col-xs-12">
                              <div class="form-group">
                                 <input class="form-control" type="text"
                                    placeholder="Job Title or Company Name" name="sText">
                              </div>
                           </div>
                           <!-- <div class="col-lg-3 col-md-6 col-xs-12">
                              <div class="form-group">
                                 <div class="search-category-container">
                                    <label class="styled-select"> <select>
                                          <option value="none">Locations</option>
                                          <option value="none">New York</option>
                                          <option value="none">California</option>
                                          <option value="none">Washington</option>
                                          <option value="none">Birmingham</option>
                                          <option value="none">Chicago</option>
                                          <option value="none">Phoenix</option>
                                    </select>
                                    </label>
                                 </div>
                                 <i class="lni-map-marker"></i>
                              </div>
                           </div>
                           <div class="col-lg-3 col-md-6 col-xs-12">
                              <div class="form-group">
                                 <div class="search-category-container">
                                    <label class="styled-select"> <select>
                                          <option>All Categories</option>
                                          <option>Finance</option>
                                          <option>IT & Engineering</option>
                                          <option>Education/Training</option>
                                          <option>Art/Design</option>
                                          <option>Sale/Markting</option>
                                          <option>Healthcare</option>
                                          <option>Science</option>
                                          <option>Food Services</option>
                                    </select>
                                    </label>
                                 </div>
                                 <i class="lni-layers"></i>
                              </div>
                           </div> -->
                           <div class="col-lg-1 col-md-2 col-xs-12">
                              <button type="submit" class="button">
                                 <i class="lni-search"></i>
                              </button>
                           </div>
                        </div>
                     </form>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </header>

   <!-- Listings Section Start -->
   <section id="job-listings" class="section">
      <div class="container">
         <div class="section-header">
            <h2 class="section-title">최신공고</h2>
         </div>
         <div class="row">
         
      <!-- 최신공고리스트 -->
            <%
               ArrayList<Notification> nlist = (ArrayList<Notification>) request.getAttribute("nlist");
               for (Notification n : nlist) {
            %>
            <div class="col-lg-6 col-md-12 col-xs-12">
               <a class="job-listings-featured" href="get.no?noti_no=<%=n.getNoti_no() %>">
                  <div class="row">
                     <div class="col-lg-8 col-md-6 col-xs-12">
                     <div class="job-company-logo">
                              <img src="<%=contextPath %>/resources/cofileupload/<%=n.getLogoFile() %>" style="width:70px;height:70px;" alt="">
                        &nbsp;&nbsp;&nbsp;
                        </div>
                        <div class="job-details">
                           <h3><%=n.getTitle()%></h3>
                           <span class="company-neme"><%=n.getP_language()%></span>
                           <div class="tags">
                         
                              <span><i class="lni-map-marker"></i><%=n.getNickname()%></span>
                              <span><i class="lni-user"></i><%=n.getSalary()%>만원</span>
                           </div>
                        </div>
                     </div>
                     <div class="col-lg-4 col-md-6 col-xs-12 text-right">
                        <div class="tag-type">
                           <!--    <sapn class="heart-icon"> <i class="lni-heart"></i> </sapn> -->
                           <span class="full-time">~<%=n.getEnd_date().substring(0,10)%></span>
                        </div>
                     </div>
                  </div>
               </a>
            </div>
            <%
               }
            %>
            <button class="btn btn-common" style="margin-left:89%" onclick="location.href='<%= contextPath %>/notificationList.se';" >더보기</button>
            <!--  최신공고리스트 끝 -->

            <!-- 마감입박 공고 리스트 -->
   
               <div class="container">
                  <div class="section-header">
                     <h2 class="section-title">마감 임박 공고</h2>
                  </div>
                  <div class="row">

                     <%
                        ArrayList<Notification> endlist = (ArrayList<Notification>) request.getAttribute("endlist");
                        for (Notification ne : endlist) {
                     %>
                     <div class="col-lg-6 col-md-12 col-xs-12">
                        <a class="job-listings-featured" href="get.no?noti_no=<%=ne.getNoti_no() %>">
                           <div class="row">
                              <div class="col-lg-8 col-md-6 col-xs-12">
                              <div class="job-company-logo">
                              <img src="<%=contextPath %>/resources/cofileupload/<%=ne.getLogoFile() %>" style="width:70px;height:70px;" alt="">
                              &nbsp;&nbsp;&nbsp;
                              </div>
                                 <div class="job-details">
                                    <h3><%=ne.getTitle() %></h3>
                                    <span class="company-neme"><%=ne.getP_language()%></span>
                                    <div class="tags">
                                       <span><i class="lni-map-marker"></i><%=ne.getNickname()%></span>
                                       <span><i class="lni-user"></i><%=ne.getSalary()%>만원</span>
                                    </div>
                                 </div>
                              </div>
                              <div class="col-lg-4 col-md-6 col-xs-12 text-right">
                                 <div class="tag-type">
                                    <!--    <sapn class="heart-icon"> <i class="lni-heart"></i> </sapn> -->
                                    <span class="full-time">~<%=ne.getEnd_date().substring(0,10)%></span>
                                 </div>
                              </div>
                           </div>
                        </a>

                     </div>
                     <%
                        }
                     %>
                     </div>
   
                     <button class="btn btn-common" style="margin-left:89%" onclick="location.href='<%= contextPath %>/notificationList.se';">더보기</button>
                     <!--  마감임박공고리스트 끝 -->

                  <!-- 공지사항  -->
                  <br><br><br><br><br><br><br><br>
               
                  <div class="container">
                  <div class="section-header">
                     <h2 class="section-title">공지사항</h2>
                  </div>
                  <div class="row">
                     <div class="col-lg-12 col-md-12 col-xs-12">
                        <div class="job-alerts-item candidates">
                        
                           <div class="alerts-list">
                              <div class="row">
                                 <div class="col-lg-1 col-md-2 col-xs-12">
                                    <p>글번호</p>
                                 </div>
                                 <div class="col-lg-5 col-md-2 col-xs-12" >
                                    <p>제목</p>
                                 </div>
                                 <div class="col-lg-2 col-md-2 col-xs-12">
                                    <p>작성자</p>
                                 </div>
                                 <div class="col-lg-2 col-md-2 col-xs-12">
                                    <p>등록날짜</p>
                                 </div>
                                 <div class="col-lg-2 col-md-2 col-xs-12">
                                    <p>조회수</p>
                                 </div>
                                 
                              </div>
                           </div>
                           <div class="alerts-content">
                              <div class="row">
                     <%   ArrayList<Board> nolist=(ArrayList<Board>)request.getAttribute("nolist");
                           for(Board no:nolist){%>
                              <div class="col-lg-12 col-md-12 col-xs-12">
                              <div class="alerts-list">
                              <div class="row">
                                 <div class="col-lg-1 col-md-2 col-xs-12">
                                    <p><%=no.getB_no() %></p>
                                 </div>
                                 <div class="col-lg-5 col-md-2 col-xs-12" >
                                    <a href="detail.bo?head=공지사항&bId=<%=no.getB_no()%>"><%=no.getTitle() %></a>
                                 </div>
							
                                 <div class="col-lg-2 col-md-2 col-xs-12">
                                    <p><%=no.getNickname() %></p>
                                 </div>
                                 <div class="col-lg-2 col-md-2 col-xs-12">
                                    <p><%=no.getEnroll_date()%></p>
                                 </div>
                                 <div class="col-lg-2 col-md-2 col-xs-12">
                                    <p><%=no.getCount() %></p>
                                 </div>
                           </div>
                              </div>
                              </div>
                              <%} %>
                           </div>
   
                        </div>
                        </div>
                        </div>
                        </div>
                        </div>
                        <br>
                        <button class="btn btn-common" style="margin-left:89%" onclick="location.href='<%= contextPath %>/list.bo?head=qu';">더보기</button>
                        <!-- 공지사항 끝 -->

   
                  <!-- 자유게시판 -->
               
                  <div class="container">
                  <br><br><br><br><br>
                  <div class="section-header">
                     <h2 class="section-title">자유게시판</h2>
                  </div>
                  <div class="row">
                     <div class="col-lg-12 col-md-12 col-xs-12">
                        <div class="job-alerts-item candidates">
                        
                           <div class="alerts-list">
                              <div class="row">
                                 <div class="col-lg-1 col-md-2 col-xs-12">
                                    <p>글번호</p>
                                 </div>
                                 <div class="col-lg-5 col-md-2 col-xs-12">
                                    <p>제목</p>
                                 </div>
                                 <div class="col-lg-2 col-md-2 col-xs-12">
                                    <p>작성자</p>
                                 </div>
                                 <div class="col-lg-2 col-md-2 col-xs-12">
                                    <p>등록날짜</p>
                                 </div>
                                 <div class="col-lg-2 col-md-2 col-xs-12">
                                    <p>조회수</p>
                                 </div>
                                 
                              </div>
                           </div>
                           <div class="alerts-content">
                              <div class="row">
                      <%   ArrayList<Board> freelist=(ArrayList<Board>)request.getAttribute("freelist");
                           for(Board s:freelist){%>
                              <div class="col-lg-12 col-md-12 col-xs-12">
                              <div class="alerts-list">
                              <div class="row">
                                 <div class="col-lg-1 col-md-2 col-xs-12">
                                    <p><%=s.getB_no() %></p>
                                 </div>
                                 <div class="col-lg-5 col-md-2 col-xs-12">
                                    <a href="detail.bo?head=자유&bId=<%=s.getB_no()%>"><%= s.getTitle()%></a>
                                 </div>
                                 <div class="col-lg-2 col-md-2 col-xs-12">
                                    <p><%= s.getNickname()%></p>
                                 </div>
                                 <div class="col-lg-2 col-md-2 col-xs-12">
                                    <p><%=s.getEnroll_date()%></p>
                                 </div>
                                 <div class="col-lg-2 col-md-2 col-xs-12">
                                    <p><%=s.getCount() %></p>
                                 </div>
                           </div>
                              </div>
                              </div>
                              <%} %>
                           </div>
   
                        </div>
                        </div>
                        </div>
                        </div>
                        </div>
                        <br>
                        <button class="btn btn-common" style="margin-left:89%" onclick="location.href='<%= contextPath %>/list.bo?head=free';" >더보기</button>
                        <!-- 자유게시판 끝 -->
                        
                        <!-- 프로젝트 -->
               
                  <div class="container">
                  <br><br><br><br><br>
                  <div class="section-header">
                     <h2 class="section-title">프로젝트</h2>
                  </div>
                  <div class="row">
                     <div class="col-lg-12 col-md-12 col-xs-12">
                        <div class="job-alerts-item candidates">
                        
                           <div class="alerts-list">
                              <div class="row">
                                 <div class="col-lg-1 col-md-2 col-xs-12">
                                    <p>글번호</p>
                                 </div>
                                 <div class="col-lg-5 col-md-2 col-xs-12">
                                    <p>제목</p>
                                 </div>
                                 <div class="col-lg-2 col-md-2 col-xs-12">
                                    <p>작성자</p>
                                 </div>
                                 <div class="col-lg-2 col-md-2 col-xs-12">
                                    <p>등록날짜</p>
                                 </div>
                                 <div class="col-lg-2 col-md-2 col-xs-12">
                                    <p>조회수</p>
                                 </div>
                                 
                              </div>
                           </div>
                           <div class="alerts-content">
                              <div class="row">
                            <%   ArrayList<Board> plist=(ArrayList<Board>)request.getAttribute("plist");
                                 for(Board p:plist){%>
                              <div class="col-lg-12 col-md-12 col-xs-12">
                              <div class="alerts-list">
                              <div class="row">
                                 <div class="col-lg-1 col-md-2 col-xs-12">
                                    <p><%=p.getB_no() %></p>
                                 </div>
                                 <div class="col-lg-5 col-md-2 col-xs-12">
                                    <a href="detail.bo?head=프로젝트&bId=<%=p.getB_no()%>"><%= p.getTitle()%></a>
                                 </div>
                                 <div class="col-lg-2 col-md-2 col-xs-12">
                                    <p><%= p.getNickname()%></p>
                                 </div>
                                 <div class="col-lg-2 col-md-2 col-xs-12">
                                    <p><%=p.getEnroll_date()%></p>
                                 </div>
                                 <div class="col-lg-2 col-md-2 col-xs-12">
                                    <p><%=p.getCount() %></p>
                                 </div>
                           </div>
                              </div>
                              </div>
                              <%} %>
                           </div>
   
                        </div>
                        </div>
                        </div>
                        </div>
                        </div>
                        <br>
                        <button class="btn btn-common" style="margin-left:89%" onclick="location.href='<%= contextPath %>/list.bo?head=project';" >더보기</button>
                        <!-- 프로젝트 끝 -->
                        
                  <!-- 스터디 -->
               
                  <div class="container">
                  <br><br><br><br><br>
                  <div class="section-header">
                     <h2 class="section-title">스터디</h2>
                  </div>
                  <div class="row">
                     <div class="col-lg-12 col-md-12 col-xs-12">
                        <div class="job-alerts-item candidates">
                        
                           <div class="alerts-list">
                              <div class="row">
                                 <div class="col-lg-1 col-md-2 col-xs-12">
                                    <p>글번호</p>
                                 </div>
                                 <div class="col-lg-5 col-md-2 col-xs-12">
                                    <p>제목</p>
                                 </div>
                                 <div class="col-lg-2 col-md-2 col-xs-12">
                                    <p>작성자</p>
                                 </div>
                                 <div class="col-lg-2 col-md-2 col-xs-12">
                                    <p>등록날짜</p>
                                 </div>
                                 <div class="col-lg-2 col-md-2 col-xs-12">
                                    <p>조회수</p>
                                 </div>
                                 
                              </div>
                           </div>
                           <div class="alerts-content">
                              <div class="row">
                        <%   ArrayList<Board> slist=(ArrayList<Board>)request.getAttribute("slist");
                              for(Board s:slist){%>
                              <div class="col-lg-12 col-md-12 col-xs-12">
                              <div class="alerts-list">
                              <div class="row">
                                 <div class="col-lg-1 col-md-2 col-xs-12">
                                    <p><%=s.getB_no() %></p>
                                 </div>
                                 <div class="col-lg-5 col-md-2 col-xs-12">
                                    <a href="detail.bo?head=스터디&bId=<%=s.getB_no()%>"><%= s.getTitle()%></a>
                                 </div>
                                 <div class="col-lg-2 col-md-2 col-xs-12">
                                    <p><%= s.getNickname()%></p>
                                 </div>
                                 <div class="col-lg-2 col-md-2 col-xs-12">
                                    <p><%=s.getEnroll_date()%></p>
                                 </div>
                                 <div class="col-lg-2 col-md-2 col-xs-12">
                                    <p><%=s.getCount() %></p>
                                 </div>
                           </div>
                              </div>
                              </div>
                              <%} %>
                           </div>
   
                        </div>
                        </div>
                        </div>
                        </div>
                        </div>
                        <br>
                        <button class="btn btn-common" style="margin-left:89%" onclick="location.href='<%= contextPath %>/list.bo?head=study';" >더보기</button>
                        <!-- 스터디 끝 -->
                        

                  </div>
                  </div>
               </div>
            </section>
            -
            <!-- end of how to work -->


            <!-- footer -->
            <%@ include file="/views/include/user/footer.jsp"%>
            <!-- End of footer -->

            <!-- back to top button -->
            <a href="#" class="back-to-top"> <i class="lni-arrow-up"></i></a>
            <!-- End of back to top button -->

            <!-- 뭔지 모르겠어 -->
            <div id="preloader">
               <div class="loader" id="loader-1"></div>
            </div>
            <!-- 뭔지 모르겠어 -->


            <!-- import of jobx -->
            <!-- End of import of jobx -->




            <%-- <%@ include file="/views/include/header.jsp" %> 

             <h1>메인</h1>
            <form id="searchForm" action="main.se" method="get" autocomplete=off>
               <input name="sText">
               <button onclick="return searchA()">검색</button>
               <button onclick="return search()">상세검색</button>
               <table id=search border=1 style="display: none;">
                  <tr>
                     <th>언어</th>
                     <th>framework/library</th>
                     <th>사용기간</th>
                     <th>프로젝트경험</th>
                     <th>플랫폼</th>
                     <th>자리</th>
                  </tr>
                  <tr>
                     <td><input type=checkbox name=language value="java">java<br>
                        <input type=checkbox name=language value="javascript">javascript<br>
                        <input type=checkbox name=language value="C">C<br>
                        <input type=checkbox name=language value="C++">C++<br>
                        <input type=checkbox name=language value="C#">C#<br>
                        <input type=checkbox name=language value="VBA">VBA<br>
                        <input type=checkbox name=language value="python">python<br>
                        <input type=checkbox name=language value="php">php<br>
                        <input type=checkbox name=language value="asp">asp<br>
                     </td>
                     <td><input type=checkbox />spring<br> <input
                        type=checkbox />jsp&servlet<br> <input type=checkbox />vue<br>
                        <input type=checkbox />react<br> <input type=checkbox />angular<br>
                        <input type=checkbox />tensorflow<br> <input type=checkbox />keras<br>
                     </td>
                     <td><input type=checkbox />1년미만<br> <input
                        type=checkbox />2년미만<br> <input type=checkbox />3년미만<br>
                        <input type=checkbox />4년미만<br> <input type=checkbox />4년이상<br>
                     </td>
                     <td><input type=checkbox />개인<br> <input type=checkbox />중소기업<br>
                        <input type=checkbox />대기업<br></td>
                     <td><input type=checkbox />웹<br> <input type=checkbox />iOS<br>
                        <input type=checkbox />Android<br> <input type=checkbox />AI<br>
                        <input type=checkbox />딥러닝<br> <input type=checkbox />응용sw<br>
                     </td>
                     <td><input type=checkbox />신입<br> <input type=checkbox />팀원급<br>
                        <input type=checkbox />팀장급<br> <input type=checkbox />프리렌서<br>
                     </td>
                  </tr>
               </table>
            </form>
            <script>
               function searchA() {

               }
               function search() {
                  $('#search').toggle()
                  $('#searchForm').attr('action', 'mainDetail.se')

                  return false;
               }
            </script> 

            <fieldset>
               <legend style="text-align: center">최신공고</legend>
               <table border=1>
                  <tr>
                     <th>co_no</th>
                     <th>공고제목</th>
                     <th>마감날짜</th>
                     <th>언어</th>
                  </tr>

                  <%
                     ArrayList<Notification> nlist1 = (ArrayList<Notification>) request.getAttribute("nlist");
                     for (Notification n : nlist1) {
                  %>
                  <tr>
                     <td><%=n.getCo_no()%></td>
                     <td><%=n.getTitle()%></td>
                     <td><%=n.getEnd_date()%></td>
                     <td><%=n.getP_language()%></td>
                  </tr>
                  <%
                     }
                  %>
               </table>
            </fieldset>
            <fieldset>
               <legend style="text-align: center">마감임박</legend>
               <table border=1>
                  <tr>
                     <th>co_no</th>
                     <th>공고제목</th>
                     <th>마감날짜</th>
                     <th>언어</th>
                  </tr> 
                   <%   ArrayList<Notification> endlist=(ArrayList<Notification>)request.getAttribute("endlist");
      for(Notification n:endlist){%>
   <tr>
      <td><%=n.getCo_no() %></td>
      <td><%=n.getTitle() %></td>
      <td><%=n.getEnd_date() %></td>
      <td><%=n.getP_language() %></td>
   </tr>
   <%   } %> 
               </table>
            </fieldset>

            <!-- 공지사항,자유게시판 -->
            <div>
               <div
                  style="display: inline-block; width: 49%; box-sizing: border-box;">
                  <fieldset>
                     <legend style="text-align: center">공지사항</legend>
                     <table border=1>
                        <tr>
                           <th>글번호</th>
                           <th>제목</th>
                           <th>작성자</th>
                           <th>등록날짜</th>
                           <th>조회수</th>
                        </tr>
                         <%   ArrayList<Board> nolist=(ArrayList<Board>)request.getAttribute("nolist");
            for(Board no:nolist){%>
         <tr>
            <td><%=no.getB_no() %></td>
            <td><%=no.getTitle() %></td>
            <td><%=no.getM_no() %></td>
            <td><%=no.getEnroll_date() %></td>
            <td><%=no.getCount() %></td>
         </tr>
         <%   } %> 
                     </table>
                  </fieldset>
               </div>
               <div
                  style="display: inline-block; width: 49%; box-sizing: border-box;">
                  <fieldset>
                     <legend style="text-align: center">자유게시판</legend>
                     <table border=1>
                        <tr>
                           <th>글번호</th>
                           <th>제목</th>
                           <th>작성자</th>
                           <th>등록날짜</th>
                           <th>조회수</th>
                        </tr>
                         <%   ArrayList<Board> freelist=(ArrayList<Board>)request.getAttribute("freelist");
            for(Board s:freelist){%>
         <tr>
            <td><%=s.getB_no() %></td>
            <td><%=s.getTitle() %></td>
            <td><%=s.getM_no() %></td>
            <td><%=s.getEnroll_date() %></td>
            <td><%=s.getCount() %></td>
         </tr>
         <%   } %> 
                     </table>
                  </fieldset>
               </div>
            </div>

            <!-- 프로젝트, 스터디 -->
            <div>
               <div style="float: left;">
                  <fieldset>
                     <legend style="text-align: center">프로젝트</legend>
                     <table border=1>
                        <tr>
                           <th>글번호</th>
                           <th>제목</th>
                           <th>작성자</th>
                           <th>모집기간</th>
                           <th>등록날짜</th>
                           <th>조회수</th>
                        </tr>
                         <%   ArrayList<Board> plist=(ArrayList<Board>)request.getAttribute("plist");
            for(Board p:plist){%>
         <tr>
            <td><%=p.getB_no() %></td>
            <td><%=p.getTitle() %></td>
            <td><%=p.getM_no() %></td>
            <td><%=p.getTime() %></td>
            <td><%=p.getEnroll_date() %></td>
            <td><%=p.getCount() %></td>
         </tr>
         <%   } %> 
                     </table>
                  </fieldset>
               </div>
               <div style="float: left;">
                  <fieldset>
                     <legend style="text-align: center">스터디</legend>
                     <table border=1>
                        <tr>
                           <th>글번호</th>
                           <th>제목</th>
                           <th>작성자</th>
                           <th>모집기간</th>
                           <th>등록날짜</th>
                           <th>조회수</th>
                        </tr>
                         <%   ArrayList<Board> slist=(ArrayList<Board>)request.getAttribute("slist");
            for(Board s:slist){%>
         <tr>
            <td><%=s.getB_no() %></td>
            <td><%=s.getTitle() %></td>
            <td><%=s.getM_no() %></td>
            <td><%=s.getTime() %></td>
            <td><%=s.getEnroll_date() %></td>
            <td><%=s.getCount() %></td>
         </tr>
         <%   } %> 
                     </table>
                  </fieldset>
               </div>
            </div>
            <br clear="both">
            <%@ include file="/views/include/footer.jsp"%> --%>
</body>
</html>