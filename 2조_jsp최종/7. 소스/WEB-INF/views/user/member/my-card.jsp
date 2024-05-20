<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>BudgetBuddy | 나의 카드 관리</title>

<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicon -->
     <link type="image/png" sizes="16x16" rel="icon" href="/account/asset/images/icons8-돈-상자-16.png">
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
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<!-- Libraries Stylesheet -->
</head>

<style>

.myCardImg {
    background-color: lightgrey;
    width: 100px;
    height: 100px;
    border-radius: 50%;
    position: relative;
    display: flex;
    justify-content: center;
    align-items: center;
}


.myCardImg>img {
    max-width: 100px;
    max-height: 100px;
    top: 10%;
    right: 10%;
}

.moreMyCard{
	display: flex;
}

.myCardMoreNum {
	font-size: 20px;
	font-weight: bold;
}




<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
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
							<h3>나의 카드 관리</h3>
						</div>
						<div class="addMyCard">
						<button type="submit"
							onclick="location.href='/account/user/member/add-my-card.do';" class="button purple-btn submit-btn-style">추가하기</button>
					</div>
				</div>
				<div class="myCards">
				<c:forEach items="${clist}" var="dto">
					<div class="box ard-image myCard">
							<div class="recommendation-card-img">
	                        	<p class="card-image-wrapper">
	                                <a></a>
									 <img src="/account/asset/images/${dto.fileLink}" alt="">
	                             </p>
                            </div>
						<div class="myCard-detail">
							<div class="myCardName">
								<div>카드명</div>
								<div>${dto.name}</div>
							</div>
							<div class="myCardCompany">
								<div>카드사</div>
								<div>${dto.cardCompany}</div>
							</div>
							<div class="myCardNickname">
								<div>별칭</div>
								<div>${dto.alias}</div>
							</div>
						</div>
						<div class="myCardBtn">
							<button id="expandbtn" class="purple-btn"><i class="fa-solid fa-angle-down"></i></button>
						</div>
					</div>
					<div class="box moreMyCard">
						<!-- 카드 번호, 카드사, 카드명, 별칭, 유효기간 -->
						<div class="myCardMoreNum">
							<div>카드 번호</div>
							 <div>${dto.cardNumber}</div>
						</div>
						<div class="myCardMoreNoneNum">
							<div class="myCardMoreCompany">
								<div>카드사</div>
								<div>${dto.cardCompany}</div>
							</div>
							<div class="myCardMoreName">
								<div>카드명</div>
								<div>${dto.name}</div>
							</div>
							<div class="myCardMoreNickname">
								<div>별칭</div>
								<div>${dto.alias}</div>
							</div>
							<div class="myCardMorePeriod">
								<div>유효 기간</div>
								<div>${dto.validity}</div>
							</div>

							<button type="button" class="dark-black-btn button submit-btn-style delBtnMyPage"data-seq="${dto.seq}">삭제</button>

						</div>
					</div>
					</c:forEach>

				</div>
			</div>




			<!-- fakecontent 끝 -->
		</div>
	</div>

	<!-- JavaScript Libraries -->

	<!-- Template Javascript -->
	<script
		src="${pageContext.request.contextPath}/asset/css/temp/js/main.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script>

    
    document.addEventListener('DOMContentLoaded', function () {
        const expandButtons = document.querySelectorAll('#expandbtn');
        const moreCards = document.querySelectorAll('.moreMyCard');

        // 초기에는 모든 moreMyCard를 숨깁니다.
        moreCards.forEach(card => {
            card.style.display = 'none';
        });

        // 각각의 버튼에 대해 이벤트 리스너를 추가합니다.
        expandButtons.forEach((button, index) => {
            button.addEventListener('click', function () {
            	const card = this.closest('.myCard');
                if (moreCards[index].style.display === 'none') {
                    moreCards[index].style.display = 'block';
                    card.style.backgroundColor= '#F5ECFF';
                    
                    button.innerHTML = '<i class="fa-solid fa-chevron-up"></i>';
                } else {
                    moreCards[index].style.display = 'none';
                    button.innerHTML = '<i class="fa-solid fa-angle-down"></i>';
                    card.style.backgroundColor= '#FFFFFF';
                }
            });
        });
    });
    
    document.addEventListener('DOMContentLoaded', function() {
        // addMyCard 버튼을 클릭하면 다른 파일로 이동합니다.
        document.getElementById('addCardButton').addEventListener('click', function() {
            // 새로운 URL로 이동합니다.
            window.location.href = '새로운파일.jsp';
        });
    });
    
    $(document).ready(function() {
        // 삭제 버튼 클릭 시 처리
        $(".delBtnMyPage").click(function() {
            var seq = $(this).data('seq'); // 삭제할 카드의 시퀀스 번호를 가져옵니다.
            
            var formData = {
                seq: seq
            };

            // AJAX 요청을 보냅니다.
            $.ajax({
                type: "POST",
                url: "/account/user/member/my-card.do",
                data: formData,
                success: function(response) {
                    console.log("Server response: ", response);
                },
                error: function(xhr, status, error) {
                    console.error("Error occurred: ", error);
                }
            });
        });
    });

    </script>
</body>

</html>