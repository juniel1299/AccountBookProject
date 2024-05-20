package com.project.accountbook.user.member;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.project.accountbook.user.member.repository.MemberInfoDAO;

/**
 * 비밀번호 수정을 처리하는 서블릿입니다.
 * GET 요청 시 비밀번호 수정 페이지로 이동하고, POST 요청 시 비밀번호를 업데이트합니다.
 */
@WebServlet("/user/member/edit-pw.do")
public class EditPw extends HttpServlet {

    /**
     * GET 요청을 처리하는 메서드입니다.
     * 비밀번호 수정 페이지로 이동합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/member/edit-pw.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * POST 요청을 처리하는 메서드입니다.
     * 현재 비밀번호와 새로운 비밀번호를 받아 비밀번호를 업데이트합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("id");

        String nowPw = req.getParameter("nowPw");
        String editPw = req.getParameter("editPw");
        String checkPw = req.getParameter("checkPw");

        MemberInfoDAO dao = new MemberInfoDAO();
        String realPw = dao.getPw(id);

        if (realPw != null && realPw.equals(nowPw) && editPw.equals(checkPw)) {
            dao.editPw(id, editPw);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/member/info.jsp");
        dispatcher.forward(req, resp);
    }
}