<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<head><title>BudgetBuddy | 비밀번호 재설정</title>
     <link type="image/png" sizes="16x16" rel="icon" href="/account/asset/images/icons8-돈-상자-16.png">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@include file="/WEB-INF/views/inc/asset.jsp"%>
<link rel="stylesheet" href="/account/asset/css/materialdesignicons.min.css">
<link rel="stylesheet" href="/account/asset/css/vendor.bundle.base.css">
<link rel="stylesheet" href="/account/asset/css/corona_style.css">
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
                <h3 class="card-title text-left mb-3">비밀번호 재설정</h3>
                <form method="POST">
	                  <div class="form-group">
	                    <label>아이디(이메일)</label>
	                    <input type="text" class="form-control input-style-form" name="id" value="${id}" readonly>
	                  </div>
	                  <div class="form-group">
	                    <label>새 비밀번호</label>
	                    <input type="password" class="form-control input-style-form" name="pw">
	                  </div>
	                  <div class="form-group">
	                    <label>새 비밀번호(확인)</label>
	                    <input type="password" class="form-control input-style-form" name="pwCheck">
	                  </div>
	                  <button type="submit" class="button purple-btn full-btn submit-btn-style">수정하기</button>
                </form>
              </div>
            </div>
          </div>
          <!-- content-wrapper ends -->
        </div>
        <!-- row ends -->
      </div>
      <!-- page-body-wrapper ends -->
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

