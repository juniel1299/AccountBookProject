<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>게시판 홈</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
</head>

<style>
#fakecontent{
    display: flex;
    justify-content: center;
   }

#postpagecontent{
  margin: 20px;

}

#postmaincontent{
  margin: 20px;
}
#postmaincontentreaction{
  display: flex;
  justify-content: center;
}

#commentlevel1head{
  justify-content: space-between;
  align-content: baseline;
}

#commentlevel1info{
  display: flex;
  flex-direction: row;
}

.post-actions-comment{
  positions: relative;

}

.post-actions-comment i.material-icons {
        font-size: 16px;  
    }
    .post-actions-comment span {
        position: relative;
        font-size: 14px; 
        top: -10px
    }

    #commentcontent {
        margin: 10px !important;
        padding: 0;
    }

   #subcommentarrow{
      margin-top: 7px;
    }
    
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
        
        <div id="fakecontent">
          <!-- 게시판 게시물 시작 -->
          <div class="container" id="postpagecontent">
            <div class="post-box">
              <h2>
              
			  	<c:choose>
			  		
			  		<c:when test="${post.seqBoard == 1}">
			  			<div>공지사항</div>
			  		</c:when>
			  		<c:when test="${post.seqBoard == 2}">
			  			<div>자유게시판</div>
			  		</c:when>
			  		<c:when test="${post.seqBoard == 3}">
			  			<div>건의게시판</div>
			  		</c:when>
			  		<c:when test="${post.seqBoard == 4}">
			  			<div>출석게시판</div>
			  		</c:when>
			  	</c:choose>
			  </h2>
              <div class="post-header" id="maincontent">
                <img class="user-image" src="user-image.jpg" alt="사용자 이미지">
                <div class="post-info">
                  <span>작성자: ${post.me_nickName != null ? post.me_nickName : post.ad_nickName}</span>
                  <span>등록일: ${post.writeDate}</span>
                </div>
              </div>
              <div class="post-content" id="postmaincontent">
                <span>${post.content}</span>
              </div>
              <div class="post-actions" id="postmaincontentreaction">
                <span><i class="material-icons">thumb_up</i> ${post.likeCount}</span>
                <span><i class="material-icons">thumb_down</i> ${post.dislikeCount}</span>
                <span><i class="material-icons">report</i> 신고</span>
              </div>     
            </div>
            <!-- 댓글 시작 -->
			<!-- 댓글 목록 출력 -->
			<div class="comments">
                <c:forEach var="comment" items="${comments}">
                    <div class="comment-box">
                        <div class="post-header" id="commentlevel1head">
                            <div class="post-info" id="commentlevel1info">
                                <img class="user-image" src="${comment.profileImage}" alt="사용자 이미지">
                                <div class="post-info">
                                    <span>작성자: ${comment.nickname}</span>
                                    <span>등록일: ${comment.writeDate}</span>
                                </div>
                            </div>
                            <div class="post-actions-comment">
                                <span><i class="material-icons">thumb_up</i> ${comment.likeCount}</span>
                                <span><i class="material-icons">thumb_down</i> ${comment.dislikeCount}</span>
                                <span><i class="material-icons">report</i> 신고</span>
                                <span>답글 (${comment.replyCount})</span>
                            </div>
                        </div>
                        <div class="post-content">
                            <div id="commentcontent">${comment.content}</div>
                        </div>
                        
                        
                        <!-- 대댓글 -->
                        <c:if test="${comment.replyCount > 0}">
                            <div class="replies">
                                <c:forEach var="reply" items="${replyDAO.getRepliesByCommentSeq(comment.seq)}">
                                    <div class="comment-box comment-reply">
                                        <div class="post-header" id="commentlevel1head">
                                            <div class="post-info" id="commentlevel1info">
                                                <i class="material-icons" id="subcommentarrow">subdirectory_arrow_right</i>
                                                <img class="user-image" src="${reply.profileImage}" alt="사용자 이미지">
                                                <div class="post-info">
                                                    <span>작성자: ${reply.nickname}</span>
                                                    <span>등록일: ${reply.writeDate}</span>
                                                </div>
                                            </div>
                                            <div class="post-actions-comment">
                                                <span><i class="material-icons">thumb_up</i> ${reply.likeCount}</span>
                                                <span><i class="material-icons">thumb_down</i> ${reply.dislikeCount}</span>
                                                <span><i class="material-icons">report</i> 신고</span>
                                            </div>
                                        </div>
                                        <div class="post-content">
                                            <div id="commentcontent">${reply.content}</div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:if>
                    </div>
                </c:forEach>
            </div>
            <!-- 댓글 쓰기 끝 -->
          </div>
          <!-- 게시판 게시물 끝 -->
        </div>
        
        <!-- fakecontent 끝 -->
        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
        
    	</div>
    </div>

    <!-- JavaScript Libraries -->
   
    <!-- Template Javascript -->
    <script src="${pageContext.request.contextPath}/asset/css/temp/js/main.js"></script>
    <script>
c
    </script>
</body>

</html>

