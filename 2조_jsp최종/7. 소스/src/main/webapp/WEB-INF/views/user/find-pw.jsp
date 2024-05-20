<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>BudgetBuddy | 비밀번호 찾기</title>

<head>
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
                <h3 class="card-title text-left mb-3">비밀번호 찾기</h3>
                <form method="POST">
	                  <div class="form-group">
	                    <label>아이디(이메일)</label>
	                    	<input type="text" class="form-control input-style-form" name="id">
	                  </div>
	                  <div class="form-group">
	                    <label>이름</label>
	                    	<input type="text" class="form-control input-style-form" name="name">
	                  </div>
	                  <button type="submit" class="button purple-btn full-btn submit-btn-style">비밀번호 찾기</button>
                  
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
    <!-- endinject -->
    
    <!-- 모달 -->
	<div class="modal fade" id="find-pw-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">비밀번호 찾기</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <div class="find-pw-success" style="display: none;">이메일로 비밀번호 재설정 링크를 전송했습니다.</div>
	        <div class="find-pw-fail" style="display: none;">이메일 전송을 실패했습니다.</div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class=" button gray-btn submit-btn-style" data-dismiss="modal">닫기</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script>
	$(document).ready(function() {
	    // 서블릿에서 설정한 결과 값을 가져옴
	    var result = ${result};

	    // 모달을 보여주는 함수
	    function showModal() {
	        if (result === 1) {
	            $('#find-pw-modal .find-pw-success').show();
// 	            $('#find-pw-modal .find-pw-fail').hide();
	        } else if (result === 0) {
	            $('#find-pw-modal .find-pw-fail').show();
// 	            $('#find-pw-modal .find-pw-success').hide();
	        }
	        $('#find-pw-modal').modal('show'); // 모달 보이기
	    }

	    // 결과에 따라 모달을 보여줌
	    showModal();

	    // 닫기 버튼 클릭 시 모달 닫기 및 페이지 이동 또는 새로고침
	    $('#find-pw-modal .close, #find-pw-modal .submit-btn-style').click(function() {
	        $('#find-pw-modal').modal('hide'); // 모달 닫기
	        
	        if (result === 1) {
	            location.href = '/account/user/login.do'; // 로그인 페이지로 이동
	        } else if (result === 0) {
	            location.reload(); // 페이지 새로고침
	        }
	    });
	});
</script>

</body>
</html>

