<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>BudgetBuddy | 챌린지 관리</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
         <link type="image/png" sizes="16x16" rel="icon" href="/account/asset/images/icons8-돈-상자-16.png">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
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
						<h3>챌린지 관리</h3>
					</div>
				</div>
				<div class="mypage-box-container-style">
					<form method="POST" action="/account/user/member/edit-challenge.do">
						<div class="user-info-container-style">
							 <div class="user-info-input-row-style">
			                    <div class="form-group"><label>월급</label><input id="sallary" class="input-style-form" type="text" name="sallary" value="${clist[0].sallary}"></div>
			               	</div>
							 <div class="user-info-input-row-style">
			                    <div class="form-group"><label>저축 목표 금액</label><input id="goal" class="input-style-form" type="text" name="goal" value="${clist[0].goal}"></div>
			               	</div>
							 <div class="user-info-input-row-style">
			                    <div class="form-group"><label>저축 목표 기간 설정</label><input id="period" class="input-style-form" type="text" name="period" value="${clist[0].period}"></div>
			               	</div>
			               	<button type="submit" class="button purple-btn info-submit-long-btn submit-btn-style" id="surveyBtn">수정하기</button>
						</div>
					</form>
				</div>
			</div>


			<!-- fakecontent 끝 -->
    </div>
    </div>

    <!-- JavaScript Libraries -->
   
    <!-- Template Javascript -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="${pageContext.request.contextPath}/asset/css/temp/js/main.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
/* 	    
    	$(document).ready(function() {
	        $('input').focus(function() {
	            $(this).val('');
	        });
	    }); */
    
    </script>
</body>

</html>
