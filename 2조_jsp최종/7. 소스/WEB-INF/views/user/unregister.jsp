<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>BudgetBuddy | 회원 탈퇴</title>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicon -->
     <link type="image/png" sizes="16x16" rel="icon" href="/account/asset/images/icons8-돈-상자-16.png">
<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
</head>
<style>
/* #fakecontent{
    display: flex;
    justify-content: center;
   }
   .container-unregister{
    display: flex;
    border: 1px solid black;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    width: 600px;
    height: 100%;
    margin: 20px;
    background-color: #f3f6f9;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1), 0 6px 20px rgba(0, 0, 0, 0.1); 
    border-radius: 10px;
    padding: 10px;
   }
   .input-pw, .check-pw{
    display: flex;
    justify-content: center;
    margin: 10px;
    align-items: center;
    width: 100%;
   }
   .input-pw-title, .check-pw-titles{
    width: 50%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 5px;

  flex: 1;
  text-align: left;
  font-weight: bold;
  padding: 10px 20px; 
  background-color: #e8e8e8; 
  border-right: 2px solid #ccc; 
  box-shadow: inset 0 0 5px rgba(0,0,0,0.1); 
  margin-right: 10px; 

   }

   .input-pw-real, .check-pw-input{
    width: 50%;
  display: flex;
  justify-content: center;
  align-items: center;

  flex: 1.5; 
  text-align: right;
  font-weight: normal;
  padding: 10px 20px; 
  color: #555;
  background-color: #fff;
  border-left: none;

   }

   .unregisterPw{
    display: flex;
  justify-content: center;
  text-align: center;
  border: none;
   }

   .unregister{
    display: flex;
  justify-content: center;
  margin: 10px;
   }

   .unregister div{
    margin: 10px;
   }

   .check-pw-btn{
    margin-bottom: 10px;
    background-color: #d9d9d9;
  color: black;
  padding: 5px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  width: 60%;
   }

   .check-pw-btn:hover{
  box-shadow: inset 0 0 5px rgba(0,0,0,0.1);
  border-radius: 5px;
} */
<%@include file="/WEB-INF/views/inc/asset.jsp"%>
</style>
<title>
회원 탈퇴
</title>
<body>
	<div class="container-xxl position-relative bg-white d-flex p-0">
		<!-- Spinner Start -->
		<div id="spinner"
			class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
			<div class="spinner-border text-primary"
				style="width: 3rem; height: 3rem;" role="status">
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
<div id="content-total-style">
			<div class="content-header">
					<div class="content-title-style">
						<h3>회원 탈퇴</h3>
					</div>
				</div>
			<div class="mypage-box-container-style">
				<form method="POST" action="/account/user/unregister.do">
				    <div class="user-info-container-style">
				   		<div class="user-info-input-row-style">
			            	<div class="form-group"><label>비밀번호</label><input class="input-style-form" type="password" name="currentPw" placeholder="비밀번호를 입력하세요."></div>
			            </div>
				   		<div class="user-info-input-row-style">
			            	<div class="form-group"><label>비밀번호 확인</label><input class="input-style-form" type="password" name="confirmPw" placeholder="비밀번호를 입력하세요."></div>
			            </div>
			            <div class="user-info-input-box">
			            	<input type="checkbox" name="confirmUnregister"/> <label>탈퇴하시겠습니까?</label>
						</div>
						<button type="submit" class="button purple-btn info-submit-long-btn submit-btn-style">탈퇴하기</button>
				    </div>
				</form>
			</div>
		</div>
			<!-- fakecontent 끝 -->
			<!-- Back to Top -->

		</div>
	</div>

	<!-- JavaScript Libraries -->

	<!-- Template Javascript -->
	<script
		src="${pageContext.request.contextPath}/asset/css/temp/js/main.js"></script>
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
    
    document.addEventListener('DOMContentLoaded', function () {
        const unregisterPwInputs = document.querySelectorAll('.unregisterPw');

        unregisterPwInputs.forEach(input => {
            input.addEventListener('focus', function () {
                this.value = '';
            });
        });
    });


    </script>
</body>

</html>
