<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<title>BudgetBuddy | ${selectedCategory} 카드 추천</title>
<head>
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    

    <link rel="stylesheet" href="/account/asset/css/combine.css">
</head>
<style>

   @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@700&display=swap');
    
    <%@include file="/WEB-INF/views/inc/asset.jsp"%>
      
</style>
<script type="module" src="chart.min.js"></script>
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
        <%@include file="/WEB-INF/views/inc/card-sidebar.jsp"%>
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
    		<h3>${selectedCategory} 카드 추천</h3>
    	</div>
	</div>
    <div class="card-use-list">
        <c:choose>
            <c:when test="${empty list}">
                <div class="card">
                    <div>선택된 카테고리에 해당하는 추천 카드가 없습니다.</div>
                 
            </c:when>
            <c:otherwise>
                <div class="card-recommendation-box">
                <c:forEach items="${list}" var="dto" varStatus="loop">
                    <div class="box card-image">
                        	<div class="recommendation-card-img">
	                        	<p class="card-image-wrapper">
	                                <a></a>
	                                <img src="${pageContext.request.contextPath}/asset/images/${dto.fileLink}">
	                             </p>
                            </div>
                            <div class="card-recommendation-info-box" >
								<h4>${dto.ciName}</h4>
								<div class="card-company">${dto.cardCompany}</div>
							</div>
                    </div>
                </c:forEach>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>

        <!-- fakecontent 끝 -->
        <!-- Back to Top -->
    <!-- JavaScript Libraries -->
   
    <!-- Template Javascript -->
    <script src="${pageContext.request.contextPath}/asset/css/temp/js/main.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
    console.log("recommendation-list.jsp - Script");
    console.log("Selected Category in JSP: ${selectedCategory}");
    console.log("Number of Cards in JSP: ${list.size()}");

    </script>
</body>

</html>
