package com.project.accountbook.board;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.project.accountbook.board.post.model.PostDTO;
import com.project.accountbook.board.repository.BoardDAO;
import com.project.accountbook.util.OutputUtil;

/**
 * 게시글 작성 기능을 수행하는 서블릿입니다.
 * 게시글 작성 페이지로 이동하거나 게시글 작성 요청을 처리합니다.
 */
@WebServlet("/board/write.do")
public class Write extends HttpServlet {

    /**
     * GET 요청을 처리하는 메서드입니다.
     * 게시글 작성 페이지로 이동합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String seqBoard = req.getParameter("seqBoard");
        req.setAttribute("seqBoard", seqBoard);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/write.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * POST 요청을 처리하는 메서드입니다.
     * 게시글 작성 요청을 처리하고 결과에 따라 페이지를 이동합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            String id = (String) session.getAttribute("id"); // 세션으로 user id 가져오기

            req.setCharacterEncoding("UTF-8");

            BoardDAO dao = new BoardDAO();
            int secretCheck = 0;

            String seqBoard = req.getParameter("seqBoard");
            String seqUser = dao.readSession(id); // BoardDAO 객체의 readSession 메소드 호출

            String title = req.getParameter("title");
            String content = req.getParameter("content");
            String secret = req.getParameter("secretCheck");

            if (secret == null) {
                secretCheck = 0;
            } else {
                secretCheck = 1;
            }

            PostDTO dto = new PostDTO();
            dto.setSeqBoard(seqBoard);
            dto.setSeqUser(seqUser);
            dto.setTitle(title);
            dto.setContent(content);
            dto.setSecretCheck(secretCheck);

            int result = dao.boardWrite(dto);

            if (result == 1) {
                resp.sendRedirect("/account/board/view.do");
            } else {
                resp.setCharacterEncoding("UTF-8");
                PrintWriter writer = resp.getWriter();
                writer.print(OutputUtil.redirect("실패했습니다."));
                writer.close();
            }
        } catch (Exception e) {
            System.out.println("Register.doPost");
            e.printStackTrace();
        }
    }
}