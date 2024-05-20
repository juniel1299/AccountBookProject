<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>BudgetBuddy | 개인정보 수정</title>

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

    <!-- Libraries Stylesheet -->
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
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
						<h3>개인정보 수정</h3>
					</div>
			</div>
        <div class="mypage-box-container-style">
              
        	<form action="/account/user/member/edit-info.do" method="POST" id="userinfo">
          		<div class="user-info-container-style">
	              <div class="user-profile-mypage-img">
	                  <img alt="" src="/account/asset/images/${dto.fileLink}">
	              </div>
	              <input type="file" class="purple-btn button" id="editImgBtn" name="img">
	              <div class="user-info-input-row-style">
	                    <div class="form-group"><label>이름</label><input class="input-style-form" type="text" name="name" value="${dto.name}"></div>
	               </div>
	              <div class="user-info-input-row-style">
	                    <div class="form-group"><label>닉네임</label><input class="input-style-form" type="text" name="nickname" value="${dto.nickname}"></div>
	               </div>
	              <div class="user-info-input-row-style">
	                    <div class="form-group"><label>전화번호</label><input class="input-style-form" type="text" name="phonenumber" value="${dto.phoneNumber}"></div>
	               </div>
               <button type="submit" class="button purple-btn info-submit-long-btn submit-btn-style" id="submit-button" onclick="location.href='/account/user/member/edit-info.jsp?name=';">수정하기</button>
      		</div>
   		</form>
    </div>
  </div>

        <!-- fakecontent 끝 -->
        <!-- Back to Top -->
        
    </div>
    </div>
    <!-- JavaScript Libraries -->
    <script>
    
    </script>
    <!-- Template Javascript -->
    <script src="${pageContext.request.contextPath}/asset/css/temp/js/main.js"></script>
    

</body>

</html>