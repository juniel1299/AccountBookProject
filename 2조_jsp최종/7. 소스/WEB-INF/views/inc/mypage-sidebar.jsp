<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/views/inc/asset.jsp"%>
<style>
</style>
</head>

<div class="sidebar">
	<div class="buddy-budget-logo-style">
		<a href="/account/index.do"><span data-attr="Budget">Budget</span><span data-attr="Buddy">Buddy</span></a>
	</div>
	
		<nav class="navbar">
			<div class="navbar-nav w-100">
				<div class="nav-item dropdown">
					<a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fas fa-user"></i> 개인정보 관리</a>
					<div class="dropdown-menu bg-transparent border-0">
						<a href="/account/user/member/info.do" class="dropdown-item"><i class="fas fa-eye"></i> 개인정보 조회</a> 
						<a href="/account/user/member/edit-info.do" class="dropdown-item"><i class="fas fa-id-card"></i> 개인정보 수정</a> 
						<a href="/account/user/member/edit-pw.do" class="dropdown-item"><i class="fas fa-lock"></i> 비밀번호 수정</a> 
						<a href="/account/user/member/edit-challenge.do" class="dropdown-item"><i class="fas fa-fire"></i> 챌린지 관리</a>
						<a href="/account/user/member/my-card.do" class="dropdown-item"><i class="fas fa-credit-card"></i> 나의 카드 관리</a>
					</div>
				</div>
				<div class="nav-item dropdown">
					<a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fas fa-shoe-prints"></i> 게시판 이용 내역</a>
					<div class="dropdown-menu bg-transparent border-0">
						<a href="/account/user/member/my-post.do" class="dropdown-item"><i class="fas fa-clipboard"></i> 내가 쓴 글</a>
						<a href="/account/user/member/my-comment.do" class="dropdown-item"><i class="fas fa-comment"></i> 내가 쓴 댓글</a>
					</div>
				</div>
				<a href="/account/user/member/friend-invitation.do" class="nav-item nav-link"><i class="fas fa-share"></i> 친구 초대</a>
				<a href="/account/user/unregister.do" class="nav-item nav-link"><i class="fas fa-trash"></i> 회원탈퇴</a>
			</div>
		</nav>
	
    
</div>
<script>

	document.addEventListener('DOMContentLoaded', function() {
	    const currentPath = window.location.pathname;
	
	 	// dropdown-item 요소의 href와 동일한 경우에 active 클래스 추가
	    const dropdownItems = document.querySelectorAll('.dropdown-item');
	
	    dropdownItems.forEach(function(item) {
	        const href = item.getAttribute('href');
	
	        if (currentPath === href) {
	            item.classList.add('active');
	            const parentDropdown = item.closest('.dropdown');
	            const dropdownToggle = parentDropdown.querySelector('.dropdown-toggle');
	            if (dropdownToggle) {
	                dropdownToggle.classList.add('active');
	            }
	        }
	    });
	
	    // nav-item nav-link 요소의 href와 동일한 경우에 active 클래스 추가
	    const navLinks = document.querySelectorAll('.nav-item.nav-link');
	
	    navLinks.forEach(function(link) {
	        const href = link.getAttribute('href');
	
	        if (currentPath === href) {
	            link.classList.add('active');
	        }
	    });
	});
			
</script>

</html>