// Edit.java

package com.project.accountbook.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.accountbook.board.post.model.PostDTO;
import com.project.accountbook.board.repository.BoardDAO;

/**
 * 게시글 수정 기능을 수행하는 서블릿입니다.
 * 게시글 수정 페이지로 이동하거나 게시글 수정 요청을 처리합니다.
 */
@WebServlet("/board/edit.do")
public class Edit extends HttpServlet {

    private BoardDAO boardDAO = new BoardDAO();

    /**
     * GET 요청을 처리하는 메서드입니다.
     * 게시글 수정 페이지로 이동합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String seq = req.getParameter("seq");
        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("id");

        PostDTO post = boardDAO.readPost(seq, id);
        req.setAttribute("post", post);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/edit.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * POST 요청을 처리하는 메서드입니다.
     * 게시글 수정 요청을 처리합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String seq = req.getParameter("seq");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        PostDTO post = new PostDTO();
        post.setSeq(seq);
        post.setTitle(title);
        post.setContent(content);

        int result = boardDAO.updatePost(post);

        if (result > 0) {
            resp.sendRedirect("/account/board/discussion.do?seq=" + seq);
        } else {
            // 글 수정 실패 시 처리
            resp.sendRedirect("/account/board/edit.do?seq=" + seq);
        }
    }
}