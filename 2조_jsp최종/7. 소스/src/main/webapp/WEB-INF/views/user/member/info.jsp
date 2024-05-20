<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>BudgetBuddy | 개인정보 조회</title>
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

    <!-- Libraries Stylesheet -->
</head>
<style>

/*   
.user-profile-mypage {
  width: 600px;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin: 30px;
  background-color: #f3f6f9;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1), 0 6px 20px rgba(0, 0, 0, 0.1); 
  border-radius: 10px;
}

.userinfo-content:last-child {
  border-bottom: none;
}
    */

        
    
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
						<h3>개인정보 조회</h3>
					</div>
			</div>
        <div class="mypage-box-container-style ">
          <div class="user-info-container-style">
              <div class="user-profile-mypage-img">
                  <img alt="" src="/account/asset/images/${dto.fileLink}">
              </div>
              <div class="user-info-input-row-style">
					<div class="form-group"><label>이름</label><input type="text" class="input-style-form" value="${dto.name}" readonly></div>
				</div>
              <div class="user-info-input-row-style">
					<div class="form-group"><label>닉네임</label><input type="text" class="input-style-form" value="${dto.nickname}" readonly></div>
				</div>
              <div class="user-info-input-row-style">
					<div class="form-group"><label>성별</label><input type="text" class="input-style-form" value="${dto.gender}" readonly></div>
				</div>
              <div class="user-info-input-row-style">
					<div class="form-group"><label>전화번호</label><input type="text" class="input-style-form" value="${dto.phoneNumber}" readonly></div>
				</div>
              <div class="user-info-input-row-style">
					<div class="form-group"><label>주민등록번호</label><input type="text" class="input-style-form" id="ssn" value="${dto.ssn}" readonly></div>
				</div>
      </div>
    </div>
        <!-- fakecontent 끝 -->
    </div>
    </div>

    <!-- JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
   
    <!-- Template Javascript -->
    <script src="${pageContext.request.contextPath}/asset/css/temp/js/main.js"></script>

</body>

</html>
