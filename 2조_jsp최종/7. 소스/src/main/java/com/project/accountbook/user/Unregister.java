package com.project.accountbook.user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.project.accountbook.user.repository.UserDAO;
import com.project.accountbook.util.OutputUtil;

/**
 * 회원 탈퇴 기능을 수행하는 서블릿입니다.
 * 사용자로부터 현재 비밀번호와 탈퇴 확인을 받아 회원 탈퇴를 처리합니다.
 */
@WebServlet("/user/unregister.do")
public class Unregister extends HttpServlet {

    /**
     * GET 요청을 처리하는 메서드입니다.
     * 회원 탈퇴 페이지로 포워딩합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/unregister.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * POST 요청을 처리하는 메서드입니다.
     * 사용자로부터 현재 비밀번호와 탈퇴 확인을 받아 회원 탈퇴를 처리합니다.
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
        String currentPw = req.getParameter("currentPw");
        String confirmPw = req.getParameter("confirmPw");
        String confirmUnregister = req.getParameter("confirmUnregister");

        if (currentPw != null && confirmPw != null && currentPw.equals(confirmPw) && confirmUnregister != null) {
            UserDAO dao = new UserDAO();
            int result = dao.unregister(id, currentPw);

            if (result == 1) {
                session.invalidate();
                resp.sendRedirect("/account/index.do");
            } else {
                req.setAttribute("error", "탈퇴에 실패했습니다. 비밀번호를 확인해주세요.");
            }
        } else {
            req.setAttribute("error", "비밀번호와 탈퇴 확인을 모두 입력해주세요.");
        }
    }
}