<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>BudgetBuddy | 게시판 홈</title>
    <link type="image/png" sizes="16x16" rel="icon" href="/account/asset/images/icons8-돈-상자-16.png">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
</head>

<style>

   
    
    <%@include file="/WEB-INF/views/inc/asset.jsp"%>
      
</style>

<body>
    <div class="container-xxl position-relative bg-white d-flex p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->


        <!-- Sidebar Start -->
        <!-- 사이드바  -->
        <%@include file="/WEB-INF/views/inc/board-sidebar.jsp"%>
        <!-- 사이드바 끝  -->
        <!-- Sidebar End -->


        <!-- Content Start -->
        <div class="content">
            
            <!-- Navbar Start -->
            <!-- 상당 메뉴 -->
            <%@include file="/WEB-INF/views/inc/header.jsp"%>
            <!-- 상당 메뉴 끝-->
            <!-- Navbar End -->
        <!-- Content End -->
        <!-- fakecontent 안에서 작성 -->
        <div class="content-total-style">
        	<div class="content-header">
					<div class="content-title-style">
						<h3>게시판 홈</h3>
					</div>
<!-- 				    <div id="board-search"> -->
				    <div class="board-search-container">
<!-- 				        <div class="search-window"> -->
				        <div>
				          <form id="formSearch" method="GET" action="/account/board/view.do">
				            <div class="board-search-wrap">              
				              <select name="column">
				                <option value="total">제목+내용</option>
				                <option value="title">제목</option>
				                <option value="content">내용</option>
				              </select>
				              <label for="search" class="blind">게시판 검색</label><input class="input-style-form board-search-input" id="search" type="search" name="word" placeholder="검색어를 입력해주세요." value="">
				              <button type="submit" class="button purple-btn board-search-btn">검색</button>	              			
				            </div>
			          	  </form>
				        </div>
				    </div>
				</div>
   
		    <div class="board-section">
		      <div class="board-block">
		        <h3>공지사항</h3>
		        <table class="board-list">
		          <tbody>
	            	<c:if test="${noticeList.size() == 0}">
					    <tr>
					        <td>게시물이 없습니다.</td>
					    </tr>
					</c:if>

					<c:forEach var="notice" items="${noticeList}" begin="0" end="4">
			                <tr>
						        <td class="blind-post-title-style">
						            <c:choose>
						                <c:when test="${notice.blindCheck eq '1'}">
						                    관리자에 의해 블라인드 처리 되었습니다.
						                </c:when>
						                <c:otherwise>
						                    <a href="/account/board/discussion.do?seq=${notice.seq}">${notice.title}</a>
						                </c:otherwise>
						            </c:choose>
					        	</td>
						        <td>추천수 ${notice.likeCount}</td>
			                </tr>
	                </c:forEach>
		          </tbody>
		        </table>
		        <a href="/account/board/noticeBoard.do?=" class="more-link"><i class="material-icons board-right-icon">chevron_right</i></a>
		      </div>
		      <div class="board-block">
		        <h3>자유게시판</h3>
		        <table class="board-list">
		          <tbody>
	           		<c:if test="${freeList.size() == 0}">
					    <tr>
					        <td>게시물이 없습니다.</td>
					    </tr>
					</c:if>

					<c:forEach var="free" items="${freeList}" begin="0" end="4">
			                <tr>
						    	<td class="blind-post-title-style">
						            <c:choose>
						                <c:when test="${free.blindCheck eq '1'}">
						                    관리자에 의해 블라인드 처리되었습니다.
						                </c:when>
						                <c:otherwise>
						                	<a href="/account/board/discussion.do?seq=${free.seq}">${free.title}</a>
						                    
						                </c:otherwise>
						            </c:choose>
					        	</td>
					        <td>추천수 ${free.likeCount}</td>
			                </tr>
	                </c:forEach>
		          </tbody>
		        </table>
		        <a href="/account/board/freeBoard.do" class="more-link"><i class="material-icons board-right-icon">chevron_right</i></a>
		      </div>
		      <div class="board-block">
		        <h3>건의게시판</h3>
		        <table class="board-list">
		          <tbody>
		            <c:if test="${reportList.size() == 0}">
					    <tr>
					        <td>게시물이 없습니다.</td>
					    </tr>
					</c:if>

			        <c:forEach var="report" items="${reportList}" begin="0" end="4">
                		<tr>
				    		<td class="blind-post-title-style">
					            <c:choose>
					                <c:when test="${report.blindCheck eq '1'}">
					                    관리자에 의해 블라인드 처리 되었습니다.
					                </c:when>
					                <c:otherwise>
					                	<a href="/account/board/discussion.do?seq=${report.seq}">${report.title}</a>
					                    
					                </c:otherwise>
					            </c:choose>
				        	</td>
				        	<td>추천수 ${report.likeCount}</td>
	                	</tr>
	                </c:forEach>
		          </tbody>
		        </table>
		        <a href="/account/board/reportBoard.do" class="more-link"><i class="material-icons board-right-icon">chevron_right</i></a>
		      </div>
		      <div class="board-block">
		        <h3>출석게시판</h3>
		        <table class="board-list">
		          <tbody>
		            <c:if test="${attendanceList.size() == 0}">
					    <tr>
					        <td>게시물이 없습니다.</td>
					    </tr>
					</c:if>

					<c:forEach var="attendance" items="${attendanceList}" begin="0" end="4">
		                <tr>
				    		<td class="blind-post-title-style">
					            <c:choose>
					                <c:when test="${attendance.blindCheck eq '1'}">
					                    관리자에 의해 블라인드 처리 되었습니다.
					                </c:when>
					                <c:otherwise>
					                	<a href="/account/board/discussion.do?seq=${attendance.seq}">${attendance.title}</a>
					                    
					                </c:otherwise>
					            </c:choose>
				        	</td>
				        	<td>추천수 ${attendance.likeCount}</td>
	                	</tr>
	                </c:forEach>
		          </tbody>
		        </table>
		        <a href="/account/board/attendanceBoard.do" class="more-link"><i class="material-icons board-right-icon">chevron_right</i></a>
		      </div>
		    </div>
		  </div>

        <!-- fakecontent 끝 -->
        
    	</div>
    </div>

    <!-- JavaScript Libraries -->
   
    <!-- Template Javascript -->
    <script src="${pageContext.request.contextPath}/asset/css/temp/js/main.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>


    </script>
</body>

</html>

