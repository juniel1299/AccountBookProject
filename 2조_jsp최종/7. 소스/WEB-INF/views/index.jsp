<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicon -->
<link type="image/png" sizes="16x16" rel="icon"
	href="/account/asset/images/icons8-돈-상자-16.png">
<!--     <link href="img/favicon.ico" rel="icon"> -->

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
	integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<style>
blockquote {
	display: block;
	background: #fff;
	padding: 15px 20px 15px 45px;
	margin: 0 0 20px;
	position: relative;
	border-left-color: #ADA0DE;
	border-right-color: #786CA7;
	/*Font*/
	font-family: Georgia, serif;
	font-size: 14px;
	line-height: 1.2;
	color: #666;
	/*Box Shadow - (Optional)*/
	-moz-box-shadow: 2px 2px 15px #ccc;
	-webkit-box-shadow: 2px 2px 15px #ccc;
	box-shadow: 2px 2px 15px #ccc;
	/*Borders - (Optional)*/
	border-left-style: solid;
	border-left-width: 15px;
	border-right-style: solid;
	border-right-width: 2px;
}

blockquote::before {
	content: &quot; \201C &quot;; /*Unicode for Left Double Quote*/
	/*Font*/
	font-family: Georgia, serif;
	font-size: 60px;
	font-weight: bold;
	color: #999;
	/*Positioning*/
	position: absolute;
	left: 10px;
	top: 5px;
}

blockquote::after {
	/*Reset to make sure*/
	content: &quot;
	&
	quot;;
}

blockquote a {
	text-decoration: none;
	cursor: pointer;
/* 	padding: 0 3px; */
	/*   color: #c76c0c; */
}

blockquote a:hover {
	/*  color: #666; */
	
}

blockquote em {
	font-style: italic;
}

/*Default Color Palette*/
blockquote.default {
	border-left-color: #656d77;
	border-right-color: #434a53;
}

.page-description h4 a {
	font-family: 'TTLaundryGothicB';
}

.index-page-item-area hr {
	padding: 0;
	margin: 0;
	color: #afb0b2;
}

.page-description li a {
	font-family: 'WavvePADO-Regular';
	font-size: 16px;
	/* 	color: #FC8E57; */
}
<%@ include file="/WEB-INF/views/inc/asset.jsp"%>

</style>

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
		<%@include file="/WEB-INF/views/inc/sidebar.jsp"%>
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
				<div class="index-page">

					<div class="index-page-item-area main-box-container-style">
						<div>
							<section>
								<h2>
									<span> "소비 패턴 분석을 통한 </span> <span> 지출 관리 친구" </span>
								</h2>
								<!--             <span>"Budget</span><span>Buddy"</span> -->
							</section>
						</div>
						<hr>
						<div class="index-page-box-area">
							<blockquote class="page-description">
								<h4>
									<a href="/account/account/calendar.do"><i
										class="fas fa-piggy-bank"></i> 대시보드</a>
								</h4>
								<!--             <strong>대시보드는 사용자가 가계부를 효과적으로 관리하고 금융 상황을 시각적으로 파악할 수 있습니다.</strong><br><br> -->
								<strong>가계부를 작성하여 금융 상황을 시각적으로 파악해보세요!</strong><br>
								<br>
								<ol style="padding-left: 0">
									<li><a href="/account/account/calendar.do"><i class="fa-solid fa-calendar-days"></i> 달력</a><br>&nbsp;
									카테고리별로 수입과 지출을 기록하고 관리할 수 있습니다.
									일일, 주간, 월간 중 기간을 선택하여 특정 기간 동안의 기록을 조회할 수 있으며, 
									나만의 구매 위시 목록을 기록하여 지출 내용을 관리할 수 있습니다.</li>
									<br><hr><br>
									<li><a href="/account/account/list.do"><i class="fa-solid fa-bars"></i> 목록</a><br>&nbsp; 
									가계부 내용에서 조회하고 싶은 특정 카테고리를 선택하거나 단어를 검색하여 가계부 내역을 필터링하여 조회할 수 있습니다.</li>
									<br><hr><br>
									<li><a href="/account/account/analysis.do"><i class="fa-solid fa-chart-pie"></i> 분석</a><br>&nbsp; 
									일일, 주간 월간 기록을 시각적으로 확인할 수 있도록 사용자의 기간별 카테고리 지출을 그래프로 제공합니다.
									지난 한 달과 이번 달의 지출 카테고리를 비교하여 방향성을 제공하며, 해당 카테고리에 대한 뉴스 정보를 제공합니다. 
									저축 목표를 설정하면 이에 따른 현상황을 파악하고, 지출 금액을 조정할 수 있도록 도와줍니다.</li>
									<br><hr><br>
									<li><a href="/account/account/card-use.do"><i class="fa-solid fa-credit-card"></i> 카드 사용 내역</a><br>&nbsp; 
									가계부 기입 내용을 바탕으로 기간별 각 카드의 소비 내역을 파악할 수 있습니다. 
									이를 통해 카드별 사용 금액과 주 소비 카테고리를 파악할 수 있습니다.</li>

									<!-- 				
				<li><strong>1. 달력</strong>
				<br>&nbsp;사용자는 대시보드에서 가계부를 기입할 수 있습니다. 이를
				통해 사용자는 수입과 지출을 기록하고 관리할 수 있습니다. 가계부에는 날짜, 카테고리(식비, 교통, 의류 등),
				금액, 메모 등의 정보를 입력할 수 있습니다. 새로운 거래를 추가하고 기존 거래를 수정 또는 삭제할 수 있습니다.</li>
				<br><li><strong>2. 목록</strong><br>&nbsp;
				사용자는 대시보드에서 가계부의 내용을 조회할 수 있습니다. 이를 통해 사용자는 이전에 기록한 거래 내역을 확인하고 관리할 수 있습니다.
가계부 조회 기능을 통해 사용자는 특정 기간 동안의 거래 내역을 검색하고 필터링할 수 있습니다.
소비 부문별로 조회할 수 있어서 식비, 교통비, 생활비 등 각각의 소비 부문에 따른 지출 내역을 확인할 수 있습니다.</li>
				<br><li><strong>3. 분석</strong><br>&nbsp;
				대시보드는 사용자의 가계부 데이터를 분석하여 다양한 통계와 그래프를 제공합니다.
사용자는 소비 부문별로 지출된 금액을 시각적으로 파악할 수 있습니다. 예를 들어, 월별 식비 지출 추이를 확인할 수 있습니다.
사용자는 수입과 지출의 총액, 각 소비 부문의 비중, 월별 지출 패턴 등을 쉽게 파악할 수 있습니다.</li>
				<br><li><strong>4. 카드 사용 내역</strong><br>&nbsp;
				사용자의 카드 사용 내역을 조회하고 카드별 소비 금액을 보여줍니다.
사용자는 각 카드의 사용 내역을 확인하고 해당 카드로 발생한 소비 금액을 파악할 수 있습니다.
카드 사용금액 조회를 통해 사용자는 카드별로 어떤 부문에서 얼마나 지출되었는지를 알 수 있습니다.</li>
			 -->

								</ol>
							</blockquote>
							<blockquote class="page-description">
								<h4>
									<a href="/account/card/recommendation.do"><i
										class="fa-solid fa-ranking-star"></i> 카드 추천</a>
								</h4>
								<strong>자신의 소비 습관에 적합한 혜택을 제공하는 카드를 추천받아 보세요!</strong><br><br>
<!-- 								
								<strong>우리의 가계부 웹사이트는 사용자들이 자신의 소비 습관을 파악하고 최적의 신용카드를
									선택할 수 있도록 도와줍니다.</strong> <br>
								<br>
								<p>&nbsp;이를 위해 소비자 맞춤 카드 추천 기능을 제공합니다. 이 기능은 사용자가 자주 이용하는 소비
									부문을 기반으로, 해당 부문에서 가장 적합한 혜택을 제공하는 카드를 추천해줍니다.</p>

								<strong>소비자 맞춤 카드 추천의 원리</strong><br> -->

								<li><a href="/account/card/recommendation.do"><i class="fa-solid fa-ranking-star"></i> 카테고리별 추천</a><br>&nbsp;
									카테고리별로 각 카드가 제공하는 혜택을 기반으로 순위를 매겨 추천합니다.</li> <br>
								<hr>
								<br>
								<li><a href="/account/card/personalized-recommendation.do"><i class="fa-solid fa-medal"></i> 맞춤 추천</a><br>&nbsp; 
									가계부에서 작성한 내용을 기반으로 내가 많이 소비하는 카테고리를 파악하고,
									나의 소비 패턴과 카드의 혜택을 비교하여 해당 분야에서 혜택이 뛰어난 카드를 추천합니다.</li>




								<!-- 								<ol style="padding-left: 0">
									<li><strong>1. 소비 부문 분석 </strong> <br>&nbsp;사용자의 가계부
										데이터를 분석하여 어떤 부문에서 가장 많은 소비가 이루어졌는지 확인합니다. 예를 들어, 식료품, 교통, 의류
										등의 다양한 부문을 고려합니다.</li>
									<br>
									<li><strong>2. 카드 혜택 분석 </strong> <br>&nbsp; 다양한 카드의
										혜택을 수집하고 분석합니다. 이는 카드 회사의 웹사이트, 프로모션 정보, 리워드 프로그램 등을 통해
										이루어집니다. 각 카드의 혜택은 해당 부문에서 제공되는 할인율, 적립률, 현금 환급 등을 포함합니다.</li>
									</br>
									<li><strong>3. 맞춤 카드 추천 </strong> <br>&nbsp;사용자의 소비
										부문과 카드의 혜택을 고려하여 가장 적합한 카드를 추천합니다. 이를 위해 알고리즘은 사용자의 소비 패턴과 카드의
										혜택을 비교하여 최적의 조합을 찾습니다. 예를 들어, 식료품을 가장 많이 소비하는 사용자에게는 해당 부문에서
										할인 혜택이 뛰어난 카드를 추천할 수 있습니다.</li>
									<br> -->
								</ol>
							</blockquote>

						</div>
					</div>
					<!--     	<div class="index-page-item-area">
        	<img src="/account/asset/images/BudgetBuddy.jpg" alt="이미지">
        </div> -->
					<div class="index-page-item-area">
						<img src="/account/asset/images/green-account-book-img.jpeg" alt="이미지">
						
						<blockquote class="page-description">
								<h4>
									<a href="/account/board/view.do"><i
										class="fas fa-clipboard"></i> 게시판</a>
								</h4>
								<strong>다양한 게시판을 통해 회원들과 소통하고 정보를 공유해보세요!</strong><br>
								<br>
								<ol style="padding-left: 0">
									<li><a href="/account/board/view.do"><i class="fas fa-home"></i> 게시판 홈</a><br>&nbsp;
										게시판 카테고리별로 최신 글 목록을 제공합니다.</li> 
<!-- 										
									<br>
									<hr>
									<br>
									<li><a href="/account/board/noticeBoard.do"><i class="fas fa-clipboard"></i> 공지 게시판</a> <br>&nbsp;
										중요한 정보나 업데이트 사항을 알리는 공간입니다. 관리자가 회원들이 반드시 알아야 할 사항이나 서비스 변경 사항 정보를 업데이트합니다.</li> <br>
									<hr>
									<br>
								<li><a href="/account/board/freeBoard.do"><i class="fas fa-clipboard"></i> 자유 게시판</a> <br>&nbsp; 
										자유롭게 의견을 나누고 정보를 공유하는 공간입니다. 특정 주제나 제한된 내용없이 다양한 주제에 대해 이야기할 수 있습니다.</li><br>
									<hr>
									<br>
								<li><a href="/account/board/attendanceBoard.do"><i class="fas fa-clipboard"></i> 출석 게시판</a><br>&nbsp; 
										출석 상황을 공유하는 공간입니다. 나의 활동 상태를 공유하며 소통할 수 있습니다.</li><br>
									<hr>
									<br>
								<li><a href="/account/board/reportBoard.do"><i class="fas fa-clipboard"></i> 건의 게시판</a><b``r>&nbsp; 
										서비스에 대한 건의나 개선 사항을 제안하는 공간압니다. 자신의 의견을 나누고 서비스 향상을 위해 제안할 수 있습니다.</li> -->

<!-- 									<li><strong>1. 공지사항 </strong> <br>&nbsp;&nbsp;관리자가
										회원들에게 중요한 정보나 업데이트 사항을 알리는 공간입니다. 회원들이 반드시 알아야 할 사항이나 서비스의
										변경사항 등을 여기에 올립니다.</li>
									<br>
									<li><strong>2. 건의사항 </strong> <br>&nbsp;&nbsp;회원들이
										서비스에 대한 건의나 개선 사항을 제안하는 공간입니다. 이 게시판을 통해 회원들은 자신들의 의견을 나누고 서비스
										향상을 위한 제안을 할 수 있습니다.</li>
									<br>
									<li><strong>3. 자유게시판 </strong> <br>&nbsp;&nbsp;회원들이
										자유롭게 의견을 나누고 정보를 공유하는 공간입니다. 특정 주제나 제한된 내용 없이 다양한 주제에 대해 이야기할
										수 있습니다.</li>
									<br>
									<li><strong>4. 출석게시판 </strong> <br>회원들이 매일 출석체크를 하고
										&nbsp;&nbsp;출석 현황을 확인하는 공간입니다. 이를 통해 회원들끼리 활동 상태를 공유하고 꾸준한 참여를
										유도합니다.</li> -->
								</ol>

							</blockquote>
					</div>

					<script src="script.js"></script>

					<!-- fakecontent 끝 -->
				</div>
			</div>
		</div>
	</div>

	<!-- JavaScript Libraries -->

	<!-- Template Javascript -->
	<script
		src="${pageContext.request.contextPath}/asset/css/temp/js/main.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script>
		
	</script>
</body>

</html>
