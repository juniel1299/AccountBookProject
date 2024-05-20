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
 * 댓글 추가 기능을 수행하는 서블릿입니다.
 * POST 요청을 받아 댓글을 데이터베이스에 저장합니다.
 */
@WebServlet("/board/add-comment.do")
public class AddComment extends HttpServlet {

    private CommentDAO cdao = new CommentDAO();

    /**
     * POST 요청을 처리하는 메서드입니다.
     * 요청 파라미터에서 게시글 번호, 사용자 번호, 댓글 내용을 추출하여 댓글을 데이터베이스에 저장합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String seqPost = req.getParameter("paramSeq");
        String seqUser = req.getParameter("user");
        String content = req.getParameter("comment");

        // CommentDTO 객체 생성 및 데이터 설정
        CommentDTO dto = new CommentDTO();
        CommentDAO dao = new CommentDAO();

        System.out.println("comment start");
        System.out.println(seqPost);
        System.out.println(seqUser);
        System.out.println(content);
        System.out.println("comment start");

        dto.setContent(content);
        dto.setSeqPost(Integer.parseInt(seqPost));
        dto.setSeqUser(Integer.parseInt(seqUser));

        int response = dao.addComment(dto);

        System.out.println("response: " + response);
    }
}