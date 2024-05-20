package com.project.accountbook.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 로그아웃 기능을 수행하는 서블릿입니다.
 * 사용자의 세션을 초기화하여 로그아웃 처리를 합니다.
 */
@WebServlet("/user/logout.do")
public class Logout extends HttpServlet {

    /**
     * GET 요청을 처리하는 메서드입니다.
     * 사용자의 세션을 초기화하여 로그아웃 처리를 수행합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 세션 초기화
        HttpSession session = req.getSession();
        session.invalidate();

        resp.sendRedirect("/account/index.do");
    }
}