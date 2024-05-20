<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>BudgetBuddy | 나의 카드 추가</title>
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

    <link rel="stylesheet" href="/account/asset/css/combine.css">
</head>
<style>
<%@ include file ="/WEB-INF/views/inc/asset.jsp"%>

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
							<h3>나의 카드 추가</h3>
						</div>
					</div>
		<div class="mypage-box-container-style">
			<form method="POST" action="/account/user/member/add-my-card.do" id="myForm">
			<div class="user-info-container-style">
			<div class="card-body">
				<div class="form-group">
				<label>카드 종류</label>
					<select class="form-control input-style-form select-box-style" id="cardSelect">
						<c:forEach items="${list}" var="list">
							<option value="${list.seq}" data-name="${list.ciName}" 
								data-issuer="${list.cardCompany}" data-img="${list.fileLink}">${list.ciName}</option>
						</c:forEach>
					</select>
					<div class="preview-addcard" id="imagepreview-addcard" >
						<img id="cardImg">
					</div>
				</div>

				<div class="form-group">
					<label for="cardName">카드명</label> <input class="form-control input-style-form" type="text" id="cardName" name="name" readonly>
				</div>
				<div class="form-group">
					<label for="cardIssuer">카드사</label> <input class="form-control input-style-form" type="text" id="cardIssuer" name="cardCompany" readonly>
				</div>
				<div class="form-group">
					<label for="cardNumber">카드 번호</label> <input class="form-control input-style-form" type="text" id="cardNumber" name="cardNumber">
				</div>
				<div class="form-group">
					<label for="nickname">별칭</label> <input class="form-control input-style-form" type="text" id="nickname" name="alias">
				</div>
				<div class="form-group">
					<label for="expirationDate">유효 기간</label> 
					<input class="form-control input-style-form" type="text" id="expirationDate" name="validity" class="datepicker">
				</div>
				<div class="add-my-card-btn-container">
					<button class="button gray-btn submit-btn-style " type="button" onclick="location.href='/account/user/member/my-card.do'">취소</button>
					<button class="button purple-btn submit-btn-style" id="sendout" type="button" onclick="location.href='/account/user/member/my-card.do'">완료</button>
				</div>
			</div>
			</div>
			</form>
		</div>
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
    
    
    function previewImage(event) {
        var reader = new FileReader();
        reader.onload = function() {
          var output = document.getElementById('imagepreview-addcard');
          output.innerHTML = '<img src="' + reader.result + '">';
        }
        reader.readAsDataURL(event.target.files[0]);
      }
    
 	// #cardSelect의 변경 이벤트를 감지하여 updateCardInfo 함수 호출
    document.getElementById("cardSelect").addEventListener("change", function() {
        updateCardInfo();
    });
    
    // 초기화 시 한번 호출하여 선택된 값에 따라 cardName, cardIssuer 설정
    document.addEventListener("DOMContentLoaded", function() {
        updateCardInfo();
    });
    
    function updateCardInfo() {
        var selectedOptions = document.querySelectorAll("#cardSelect option:checked");
        
        if (selectedOptions.length > 0) {
            var selectedOption = selectedOptions[0]; // 첫 번째 선택된 옵션만 가져옴
            document.getElementById("cardName").value = selectedOption.dataset.name || "";
            document.getElementById("cardIssuer").value = selectedOption.dataset.issuer || "";
            document.getElementById("cardImg").value = selectedOption.dataset.img || "";
            document.getElementById("cardImg").src = "/account/asset/images/" + (selectedOption.dataset.img || "");
        }
    }
      
    document.addEventListener('DOMContentLoaded', function() {
        const cardSelect = document.getElementById('cardSelect');
        const selectedSeqInput = document.getElementById('selectedSeq');

        // cardSelect 변경 이벤트를 감지하여 hidden input에 seq 값 설정
        cardSelect.addEventListener('change', function() {
            selectedSeqInput.value = this.value; // 선택된 옵션의 seq 값 설정
        });
    });
    
    var selectDate;
    
    $(document).ready(function() {
        // Datepicker 초기화
        $('.datepicker').datepicker({
            dateFormat: 'yy-mm-dd', // 날짜 형식 지정
            	onSelect: function(dateText, inst) {
                    // Update variable with selected date value
                    selectedDate = dateText;
                }
        });
    });
    
    $(document).ready(function() {
        // Declare selectedDate in the outer scope
        var selectedDate = null;

        // Initialize datepicker
        $("#datepicker").datepicker({ 
        dateFormat: "yy-mm-dd", 
        onSelect: function(){
            var selected = $(this).datepicker("getDate");
            alert(selected);
        }
    });

        // Click event for the submit button
        $("#sendout").click(function() {
            var formData = {
                cardName: $("#cardName").val(),
                cardIssuer: $("#cardIssuer").val(),
                cardNumber: $("#cardNumber").val(),
                nickname: $("#nickname").val(),
                expirationDate: document.getElementById('expirationDate').value // Use the selectedDate in your formData
            };

            // Debugging log to check what is being sent
            console.log("Sending Data: ", formData);

            // AJAX request to send formData to the server
            $.ajax({
                type: "POST",
                url: "/account/user/member/add-my-card.do",
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
