<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>BudgetBuddy | 게시글 작성</title>
    <link type="image/png" sizes="16x16" rel="icon" href="/account/asset/images/icons8-돈-상자-16.png">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    <!-- Libraries Stylesheet -->
</head>
<style>

   <%@include file="/WEB-INF/views/inc/asset.jsp"%>
      
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
        <%@include file="/WEB-INF/views/inc/board-sidebar.jsp"%>
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
      	<div class="content-total-style board-write-container-style">
   			<div class="content-header">
					<div class="content-title-style">
						<h3>게시글 작성</h3>
					</div>
				</div>
				<div class="">
					<form method="POST" action="/account/board/write.do" id="write">
					     <div class="form-group">
					       <label for="category">카테고리</label>
					       <select id="seqBoard" name="seqBoard" class="input-style-form">	       
						       <c:if test="${sessionScope.seqPriv == 3 && seqBoard == 1}">
							       <option value="1">공지사항</option>
							       <option value="2">자유 게시판</option>
							       <option value="3">건의 사항 게시판</option>
							       <option value="4">출석 게시판</option>
							   </c:if>
							       
						       <c:if test="${seqBoard == 2}">
							       <option value="2">자유 게시판</option>
							       <option value="3">건의 사항 게시판</option>
							       <option value="4">출석 게시판</option>
						       </c:if>
						       
						       <c:if test="${seqBoard == 3}">
						       	   <option value="3">건의 사항 게시판</option>
							       <option value="2">자유 게시판</option>
							       <option value="4">출석 게시판</option>
						       </c:if>
						       
						       <c:if test="${seqBoard == 4}"> 
						       	   <option value="4">출석 게시판</option>
							       <option value="2">자유 게시판</option>
							       <option value="3">건의 사항 게시판</option>
						       </c:if>
					       </select>
					     </div>
					     
					     <div class="form-group">
					       <label for="title">제목</label>
					       <input type="text" id="title" name="title" placeholder="제목을 입력해 주세요." class="input-style-form">
					     </div>
					     <div class="form-group">
					       <label for="content">내용</label>
					       <textarea id="content" name="content" placeholder="내용을 입력해 주세요." class="input-style-form"></textarea>
					     </div>
					     
					     <div class="secret-box-display">
					     	<div class="user-info-input-box">
									<label><input type="checkbox" name="secretCheck" value="select" id="challenge" class="submit-btn-style"/>비밀글</label>
							</div>
						    <div class="button-group">	
							    <button type="submit" class="button purple-btn submit-btn-style">등록</button>	     
							    <button type="submit" class="button gray-btn submit-btn-style" onclick="javascript:history.back();">취소</button>	     
						    </div>
					     </div>
					     
					</form>
				</div>
			</div>
		</div>
	 </div>	
		<!-- fakecontent 끝 -->


    <!-- JavaScript Libraries -->
   
    <!-- Template Javascript -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.1/chart.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="${pageContext.request.contextPath}/asset/css/temp/js/main.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
    
    
/*     #write > div:nth-child(4) {
    	display: flex;
    	justify-content: flex-end;
    } */

    console.log('${seqBoard}');
    
    document.addEventListener('DOMContentLoaded', function() {
        var seqBoard = ${seqBoard};
        var userInfoInputBox = document.querySelector('.user-info-input-box');
        var secretBoxDisplay = document.querySelector('.secret-box-display');
        
        if (seqBoard == 3) {
            userInfoInputBox.style.display = 'flex';
            secretBoxDisplay.style.display = 'flex';
            secretBoxDisplay.style.justifyContent = 'space-between';
        } else {
            userInfoInputBox.style.display = 'none';
            secretBoxDisplay.style.display = 'flex';
            secretBoxDisplay.style.justifyContent = 'flex-end';
        }
    });
	    
    </script>
</body>

</html>

