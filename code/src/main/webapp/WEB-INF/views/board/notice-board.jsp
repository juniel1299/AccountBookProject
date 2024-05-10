<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>BudgetBuddy | 공지 게시판</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
</head>
<style>
    
    #pagebar{
    display: flex;
    justify-content: center;
    align-items: center;
	}
	
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
        <section class="noticeboard">
        
        <div class="content-header">
					<div class="content-title-style">
						<h3>공지 게시판</h3>
					</div>
				    <div class="board-search-container">
				        <div>
				          <form id="formSearch" method="GET" action="/account/board/noticeBoard.do">
				            <div class="board-search-wrap">              
				              <select name="column">
				                <option value="total">제목+내용</option>
				                <option value="title">제목</option>
				                <option value="content">내용</option>
				              </select>
				              <label for="search" class="blind">게시판 검색</label>
				              <input class="input-style-form board-search-input" id="search" type="search" name="word" placeholder="검색어를 입력해주세요." value="">
				              <button type="submit" class="button purple-btn board-search-btn">검색</button>	              			
				            </div>
			          	  </form>
				        </div>
				    </div>
				</div>
				
    
		    <!-- board list area -->
		    <div id="board-list">
	        	<div class="">
	           		<table class="table-style">
					<tbody>
		                <tr>
		                    <th scope="col" class="th-num">번호</th>
		                    <th scope="col" class="th-title">제목</th>
		                    <th scope="col" class="th-writer">작성자</th>
		                    <th scope="col" class="th-date">등록일</th>
		                    <th scope="col" class="th-view">조회수</th>
		                    <th scope="col" class="th-like">추천</th>
		                    
		                <c:if test="${noticeList.size() == 0}">
						    <tr>
						    	<td></td>
						    	<td></td>
						        <td>게시물이 없습니다.</td>
						        <td></td>
						        <td></td>
						    </tr>
						</c:if>
	                
					<c:forEach var="notice" items="${noticeList}" varStatus="status">
			                <tr>
			                    <%-- <td>${notice.seq}</td> --%>
			                    <td>${status.count}</td>
						        <td><a href="/account/board/discussion.do?seq=${notice.seq}">${notice.title}</a></td>
						        <td>${notice.me_nickName != null ? notice.me_nickName : notice.ad_nickName}</td>
						        <td>${notice.writeDate}</td>
						        <td>${notice.viewCount}</td>
						        <td>${notice.likeCount}</td>
			                </tr>
	                </c:forEach>
	                </tbody>
	            </table>
	            <!-- 페이지바 -->
				<div id="pagebar">${pagebar}</div>
				
	            <div class="write-btn">
	                <a href="/account/board/write.do" class="button purple-btn submit-btn-style bottom-btn-style">글작성</a>
	            </div>
	        </div>
	    </div>
		</section>
		</div>
        <!-- fakecontent 끝 -->
  
    	</div>
    </div>

    <!-- JavaScript Libraries -->
   
    <!-- Template Javascript -->
    <script src="${pageContext.request.contextPath}/asset/css/temp/js/main.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>

    <c:if test="${map.search == 'y'}">
	//검색중 상태 유지
	$('input[name=word]').val('${map.word}');
	$('select[name=column]').val('${map.column}');
	</c:if>

    </script>
</body>

</html>

