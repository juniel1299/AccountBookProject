<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/views/inc/asset.jsp"%>
<style>
@import url('https://fonts.googleapis.com/css?family=Rubik:700&display=swap');


/* .header-content {
  position: relative;
  display: inline-block;
  cursor: pointer;
  outline: none;
  border: 0;
  vertical-align: middle;
  text-decoration: none;
  font-size: inherit;
  font-family: inherit;
  background-color: rgb(0 0 0 / 0%);
  
  &.header-content-item {
    font-weight: 600;
    color: #382b22;
    text-transform: uppercase;
    padding: 1.25em 2em;
    background: #fff0f0;
    border: 2px solid #b18597;
    border-radius: 0.75em;
    transform-style: preserve-3d;
    transition: transform 150ms cubic-bezier(0, 0, 0.58, 1), background 150ms cubic-bezier(0, 0, 0.58, 1);
    &::before {
      position: absolute;
      content: '';
      width: 100%;
      height: 100%;
      top: 0;
      left: 0;
      right: 0;
      bottom: 0;
      background: #f9c4d2;
      border-radius: inherit;
      box-shadow: 0 0 0 2px #b18597, 0 0.625em 0 0 #A6CCBA;
      transform: translate3d(0, 0.75em, -1em);
      transition: transform 150ms cubic-bezier(0, 0, 0.58, 1), box-shadow 150ms cubic-bezier(0, 0, 0.58, 1);
    }
    &:hover {
      background: #ffe9e9;
      transform: translate(0, 0.25em);
      &::before {
        box-shadow: 0 0 0 2px #b18597, 0 0.5em 0 0 #A6CCBA;
        transform: translate3d(0, 0.5em, -1em);
      }
    }
    &:active {
      background: #ffe9e9;
      transform: translate(0em, 0.75em);
      &::before {
        box-shadow: 0 0 0 2px #b18597, 0 0 #A6CCBA;
        transform: translate3d(0, 0, -1em);
      }
    }
  }
} */


  .header-content {
  	color: #333;
	text-decoration: none;
	font-weight: bold;
	margin-left: 100px;
	margin: 0 20px;
    border:none;
        
    box-sizing: border-box;
	  &::before, &::after {
	    box-sizing: border-box;
	  }
  }
  
  .header-content:hover,
  .header-content.active {
   	transform: translate(0, 0.25em);
  	color: #EFFDF6;
  	font-weight: bold;
  	font-weight: 600;
  	text-shadow: 1px -1px 1px #88bfad;
  }
 
 .header-content:hover::before {
 }
 .header-content.active::before {
 }

  
</style>
</head>

<header id="navheader">
	<nav>
            <div id="view-header-btn" class="">
           	 	<a href="/account/account/calendar.do" class="header-content ">대시보드</a>
           	 	<a href="/account/card/recommendation.do" class="header-content ">카드추천</a>
           	 	<a href="/account/board/view.do" class="header-content ">게시판</a>
           	 	<a href="/account/user/member/info.do" class="header-content ">마이페이지</a>
           	 	
				<c:if test="${empty id}">
	           	 	<a href="/account/user/login.do" class="header-content ">로그인</a>
				</c:if>
				<c:if test="${not empty id}">
	           	 	<a href="/account/user/logout.do" class="header-content ">로그아웃</a>
				</c:if>
            </div>
	</nav>
</header>
<script>

	document.addEventListener('DOMContentLoaded', function() {
	    const currentPath = window.location.pathname;
	
	 	// dropdown-item 요소의 href와 동일한 경우에 active 클래스 추가
	    const headerContents = document.querySelectorAll('.header-content');
	
	    headerContents.forEach(function(item) {
	        const href = item.getAttribute('href');
	
	        if (currentPath === href) {
// 	            item.classList.add('header-content-item');
	            item.classList.add('active');
	        }
	    });
	

	});


		// 현재 URL
		var currentUrl = window.location.pathname;
		
		console.log(currentUrl);
		
		// 로그인 페이지나 관련 페이지일 때
		if (currentUrl.endsWith("login.do") || currentUrl.endsWith("/register.do") || currentUrl.endsWith("find-id.do") || currentUrl.endsWith("find-pw.do") || currentUrl.endsWith("reset-pw.do")) {
		    // "header-content" 클래스를 가진 모든 요소를 숨김
		    document.querySelectorAll(".header-content").forEach(function(item) {
		        item.style.display = "none";
		    });
		
		    // "header-buddy-budget-logo" 요소를 추가
		    var buddyBudgetLogo = document.createElement("div");
		    buddyBudgetLogo.id = "header-buddy-budget-logo";
		    buddyBudgetLogo.classList.add("buddy-budget-logo-style");
		    buddyBudgetLogo.innerHTML = '<a href="/account/index.do"><span data-attr="Budget">Budget</span><span data-attr="Buddy">Buddy</span></a>';
		    document.querySelector("header#navheader").appendChild(buddyBudgetLogo);
		} else {
		    // 로그인 페이지나 관련 페이지가 아닐 때는 "buddy-budget-logo" 요소를 제거
		    var buddyBudgetLogo = document.getElementById("header-buddy-budget-logo");
		    if (buddyBudgetLogo) {
		        buddyBudgetLogo.remove();
		    }
		}	
		
</script>

</html>

