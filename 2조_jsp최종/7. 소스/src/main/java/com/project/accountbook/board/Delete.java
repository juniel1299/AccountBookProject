package com.project.accountbook.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.project.accountbook.board.repository.BoardDAO;

/**
 * 게시글 삭제 기능을 수행하는 서블릿입니다.
 * POST 요청을 받아 게시글을 삭제합니다.
 */
@WebServlet("/board/delete.do")
public class Delete extends HttpServlet {

    private BoardDAO bdao = new BoardDAO();

    /**
     * POST 요청을 처리하는 메서드입니다.
     * 게시글 삭제 요청을 처리합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String seq = req.getParameter("seq");
        System.out.println(seq);

        int result = bdao.deletePost(seq);

        if (result > 0) {
            resp.getWriter().write("Success");
        } else {
            resp.getWriter().write("Fail");
        }
    }
}