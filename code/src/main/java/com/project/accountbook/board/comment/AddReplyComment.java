package com.project.accountbook.board.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.accountbook.board.comment.model.CommentDTO;
import com.project.accountbook.board.comment.repository.CommentDAO;

/**
 * 답글 추가 기능을 수행하는 서블릿입니다.
 * POST 요청을 받아 답글을 데이터베이스에 저장합니다.
 */
@WebServlet("/board/addReplyComment.do")
public class AddReplyComment extends HttpServlet {

    private CommentDAO cdao = new CommentDAO();

    /**
     * POST 요청을 처리하는 메서드입니다.
     * 요청 파라미터에서 댓글 번호, 사용자 번호, 답글 내용을 추출하여 답글을 데이터베이스에 저장합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String seqComments = req.getParameter("seqComments");
            String seqUser = req.getParameter("seqUser");
            String content = req.getParameter("content");

            System.out.println("seqComments: " + seqComments);
            System.out.println("seqUser: " + seqUser);
            System.out.println("content: " + content);

            int seqCommentsInt = Integer.parseInt(seqComments);
            int seqUserInt = 0;

            if (seqUser != null && !seqUser.isEmpty()) {
                seqUserInt = Integer.parseInt(seqUser);
            }

            CommentDTO replyComment = new CommentDTO();
            replyComment.setSeqComments(seqCommentsInt);
            replyComment.setSeqUser(seqUserInt);
            replyComment.setContent(content);

            int result = cdao.addReplyComment(replyComment);

            if (result > 0) {
                resp.getWriter().write("Success");
            } else {
                resp.getWriter().write("Fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}