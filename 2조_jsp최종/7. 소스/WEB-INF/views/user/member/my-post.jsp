<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>BudgetBuddy | 내가 쓴 글</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
     <link type="image/png" sizes="16x16" rel="icon" href="/account/asset/images/icons8-돈-상자-16.png">
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
        <%@include file="/WEB-INF/views/inc/mypage-sidebar.jsp"%>
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
						<h3>내가 쓴 글</h3>
					</div>
			</div>
				<section class="notice">
					<!-- board list area -->
					<div id="board-list">
						<div class="">
							<table class="table-style">
								<tbody>
									<tr>
										<th scope="col" class="th-title">제목</th>
										<th scope="col" class="th-writer">작성자</th>
										<th scope="col" class="th-date">등록일</th>
										<th scope="col" class="th-view">조회수</th>
										<th scope="col" class="th-like">추천</th>
									</tr>
									<c:forEach items="${plist}" var="dto">
										<tr>
											<td><a href="/account/board/discussion.do?seq=${dto.seq}">${dto.title}</a></td>
											<td>${dto.me_nickName}</td>
											<td>${dto.writeDate}</td>
											<td>${dto.viewCount}</td>
											<td>${dto.likeCount}</td>
										</tr>
									</c:forEach>								
								</tbody>								
							</table>
							<div id="pagebar">${pagebar}</div>
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

    document.addEventListener('DOMContentLoaded', function() {
    const sidebarToggler = document.getElementById('sidebar-toggler');
    const sidebar = document.querySelector('.sidebar');
    const content = document.querySelector('.content');

        sidebarToggler.addEventListener('click', function() {
        sidebar.classList.toggle('hidden');
        content.classList.toggle('expanded');
        });
    });

    </script>
</body>

</html>
