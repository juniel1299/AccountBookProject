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
				<a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fas fa-piggy-bank"></i> 가계부</a>
				<div class="dropdown-menu bg-transparent border-0">
					<a href="/account/account/calendar.do" class="dropdown-item"><i class="fa-solid fa-calendar-days"></i> 달력</a> 
					<a href="/account/account/list.do" class="dropdown-item"><i class="fa-solid fa-bars"></i> 목록</a> 
					<a href="/account/account/analysis.do" class="dropdown-item"><i class="fa-solid fa-chart-pie"></i> 분석</a>
				</div>
			</div>
			<a href="/account/account/card-use.do" class="nav-item nav-link"><i class="fa-solid fa-credit-card"></i> 카드 사용 내역</a>
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