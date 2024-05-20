<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head><title>BudgetBuddy | 아이디 찾기</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@include file="/WEB-INF/views/inc/asset.jsp"%>
<link rel="stylesheet" href="/account/asset/css/style.css">
<link rel="stylesheet" href="/account/asset/css/corona_style.css">
     <link type="image/png" sizes="16x16" rel="icon" href="/account/asset/images/icons8-돈-상자-16.png">
<style>

</style>
</head>
<body>
	<%@include file="/WEB-INF/views/inc/header.jsp"%>

	<div class="container-scroller">
		<div class="content-total-style">
			<div class="user-info-input-page-container login-page-container user-info-box-container-style">
				<div class="user-info-container-style">
					<div class="">
						<div class="card-body">
							<h3 class="card-title text-left mb-3">아이디 찾기</h3>
							<div class="successFind">
								<form method="post" action="/account/user/find-id.do">
									<div class="form-group">
										<label>이름</label> <input type="text"
											class="form-control input-style-form" name="name">
									</div>
									<div class="form-group">
										<label>주민등록번호</label> <input type="text"
											class="form-control input-style-form" name="ssn">
									</div>
									<button type="submit" class="button purple-btn full-btn submit-btn-style">아이디 찾기</button>
								</form>

								<div class="text-line-area">
									<c:choose>
										<c:when test="${not empty foundId}">
											<p>회원님의 아이디는 ${foundId} 입니다.</p>
										</c:when>
										<c:when test="${empty foundId and not empty param.name}">
											<p>입력한 정보와 일치하는 아이디가 없습니다.</p>
										</c:when>
<%-- 										<c:otherwise>
											<p>이름과 주민번호를 입력하여 아이디를 찾아주세요.</p>
										</c:otherwise> --%>
									</c:choose>
								</div>
							</div>
						</div>
					</div>
					<!-- content-wrapper ends -->
				</div>
				<!-- row ends -->
			</div>
			<!-- page-body-wrapper ends -->
		</div>
	</div>
	<!-- container-scroller -->
	<!-- plugins:js -->
	<script src="/account/asset/js/vendor.bundle.base.js"></script>
	<!-- endinject -->
	<!-- Plugin js for this page -->
	<!-- End plugin js for this page -->
	<!-- inject:js -->
	<script src="/account/asset/js/off-canvas.js"></script>
	<script src="/account/asset/js/hoverable-collapse.js"></script>
	<script src="/account/asset/js/misc.js"></script>
	<script src="/account/asset/js/settings.js"></script>
	<script src="/account/asset/js/todolist.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<!-- endinject -->

	<script>
		
	</script>
</body>
</html>

