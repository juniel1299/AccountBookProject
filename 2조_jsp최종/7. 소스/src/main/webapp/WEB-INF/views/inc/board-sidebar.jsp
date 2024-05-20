<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/views/inc/asset.jsp"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<style>
	#assignment_board {
	  position: static;
	  margin-right: 7px;
	  background-color: transparent;
	}
</style>
</head>

<div class="sidebar">
            <div class="buddy-budget-logo-style"><a href="/account/index.do"><span data-attr="Budget">Budget</span><span data-attr="Buddy">Buddy</span></a></div>

	<nav class="navbar">
		<div class="navbar-nav w-100">
			<a href="/account/board/view.do" class="nav-item nav-link"><i class="fas fa-home"></i> 게시판 홈</a>
			<div class="nav-item dropdown">
				<a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fas fa-map-pin"></i> 게시판 카테고리</a>
				<div class="dropdown-menu bg-transparent border-0">
					<a href="/account/board/noticeBoard.do" class="dropdown-item"><i class="fas fa-clipboard"></i> 공지 게시판</a> 
					<a href="/account/board/freeBoard.do" class="dropdown-item"><i class="fas fa-clipboard"></i> 자유 게시판</a> 
					<a href="/account/board/attendanceBoard.do" class="dropdown-item"><i class="fas fa-clipboard"></i> 출석 게시판</a>
					<a href="/account/board/reportBoard.do" class="dropdown-item"><i class="fas fa-clipboard"></i> 건의 게시판</a>
				</div>
			</div>
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

