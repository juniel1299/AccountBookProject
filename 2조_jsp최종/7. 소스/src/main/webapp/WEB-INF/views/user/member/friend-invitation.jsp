<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>BudgetBuddy | 친구 초대</title>
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
						<h3>친구 초대</h3>
					</div>
					<div class="note-style">
						<div class="note-style-text">
							<!-- 글을 여기에 추가하세요 -->
							<div>소비 패턴 분석을 통한 지출 관리 친구 <span>"BudgetBuddy"</span> 를</div>
							<div>친구에게 공유하세요!</div>
						</div>
						<div>
							<a id="kakaotalk-sharing-btn" href="javascript:;"> <img
								src="https://developers.kakao.com/assets/img/about/logos/kakaotalksharing/kakaotalk_sharing_btn_medium.png"
								alt="카카오톡 공유 보내기 버튼" />
						</div>
					</div>
				</div>
				<div class="image-container-friendinvite">
					<!-- 이미지를 여기에 추가하세요 -->
					<img src="/account/asset/images/BudgetBuddy.jpg" alt="이미지" id = "img-friendinvite">
				</div>

			<!-- fakecontent 끝 -->
    </div>
    </div>

    <!-- JavaScript Libraries -->
   
    <!-- Template Javascript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/asset/css/temp/js/main.js"></script>
	<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.7.1/kakao.min.js"
		integrity="sha384-kDljxUXHaJ9xAb2AzRd59KxjrFjzHa5TAoFQ6GbYTCAG0bjM55XohjjDT7tDDC01"
		crossorigin="anonymous"></script>
	<script>
		Kakao.init('${key}'); // 사용하려는 앱의 JavaScript 키 입력
	</script>
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

		Kakao.Share
				.createDefaultButton({
					container : '#kakaotalk-sharing-btn',
					objectType : 'feed',
					content : {
						title : 'BudgetBuddy',
						description : '소비 패턴 분석을 통한 지출 관리 친구 BudgetBuddy!',
						imageUrl : 'https://img.freepik.com/free-vector/hands-with-money-flat-composition-with-top-view-table-with-laptop-paper-calculations-cash-vector-illustration_1284-80352.jpg?t=st=1714872951~exp=1714876551~hmac=ea8293e187b5648b76d78376a64fdf5c902bedd4fc9113bcff518ac04bf42b67&w=740',
						link : {
							// [내 애플리케이션] > [플랫폼] 에서 등록한 사이트 도메인과 일치해야 함
							mobileWebUrl : 'http://localhost:8090',
							webUrl : 'http://localhost:8090',
						},
					},
					buttons : [ {
						title : '웹으로 보기',
						link : {
							mobileWebUrl : 'http://localhost:8090/account/index.do',
							webUrl : 'http://localhost:8090/account/index.do',
						},
					}, 
// 					{
// 						title : '앱으로 보기',
// 						link : {
// 							mobileWebUrl : 'http://localhost:8090',
// 							webUrl : 'http://localhost:8090',
// 						},
// 					}, 
					],
				});
	</script>


</body>

</html>
