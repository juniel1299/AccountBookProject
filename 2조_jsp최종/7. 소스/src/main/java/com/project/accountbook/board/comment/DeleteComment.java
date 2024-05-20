package com.project.accountbook.board.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.accountbook.board.comment.repository.CommentDAO;

/**
* 댓글 삭제 기능을 수행하는 서블릿입니다.
* POST 요청을 받아 댓글을 데이터베이스에서 삭제합니다.
*/
@WebServlet("/board/deleteComment.do")
public class DeleteComment extends HttpServlet {

   private CommentDAO cdao = new CommentDAO();

   /**
    * POST 요청을 처리하는 메서드입니다.
    * 요청 파라미터에서 댓글 번호를 추출하여 해당 댓글을 데이터베이스에서 삭제합니다.
    *
    * @param req  HttpServletRequest 객체입니다.
    * @param resp HttpServletResponse 객체입니다.
    * @throws ServletException 서블릿 예외가 발생한 경우입니다.
    * @throws IOException      입출력 예외가 발생한 경우입니다.
    */
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String commentSeq = req.getParameter("commentSeq");

       int result = cdao.deleteComment(commentSeq);

       if (result > 0) {
           resp.getWriter().write("Success");
       } else {
           resp.getWriter().write("Fail");
       }
   }
}