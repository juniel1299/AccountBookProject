package com.project.accountbook.board.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.accountbook.board.comment.repository.CommentDAO;

/**
* 답글 수정 기능을 수행하는 서블릿입니다.
* POST 요청을 받아 답글 내용을 수정하고 데이터베이스에 업데이트합니다.
* 답글 작성자만 수정 권한이 있습니다.
*/
@WebServlet("/board/editReplyComment.do")
public class EditReplyComment extends HttpServlet {

   private CommentDAO cdao = new CommentDAO();

   /**
    * POST 요청을 처리하는 메서드입니다.
    * 요청 파라미터에서 답글 번호와 수정된 내용을 추출하고, 세션에서 현재 로그인한 사용자의 정보를 가져옵니다.
    * 답글 작성자와 현재 로그인한 사용자가 일치하는 경우에만 해당 답글을 데이터베이스에서 업데이트합니다.
    *
    * @param req  HttpServletRequest 객체입니다.
    * @param resp HttpServletResponse 객체입니다.
    * @throws ServletException 서블릿 예외가 발생한 경우입니다.
    * @throws IOException      입출력 예외가 발생한 경우입니다.
    */
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String replyCommentSeq = req.getParameter("replyCommentSeq");
       String editedContent = req.getParameter("editedContent");

       // 세션에서 현재 로그인한 사용자의 seqUser 값을 가져옵니다.
       HttpSession session = req.getSession();
       int seqUser = (Integer) session.getAttribute("seqUser");

       // 답글 작성자와 현재 로그인한 사용자가 일치하는지 확인합니다.
       if (cdao.isReplyCommentAuthor(replyCommentSeq, seqUser)) {
           int result = cdao.updateReplyComment(replyCommentSeq, editedContent);

           if (result > 0) {
               resp.getWriter().write("Success");
           } else {
               resp.getWriter().write("Fail");
           }
       } else {
           resp.getWriter().write("Unauthorized");
       }
   }
}