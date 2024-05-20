package com.project.accountbook.user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.project.accountbook.user.model.UserDTO;
import com.project.accountbook.user.repository.UserDAO;
import com.project.accountbook.util.OutputUtil;

/**
 * 로그인 기능을 수행하는 서블릿입니다.
 * 사용자로부터 아이디와 비밀번호를 입력받아 로그인을 처리하고, 자동 로그인 기능을 제공합니다.
 */
@WebServlet("/user/login.do")
public class Login extends HttpServlet {

    /**
     * GET 요청을 처리하는 메서드입니다.
     * 로그인 페이지로 포워딩합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/login.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * POST 요청을 처리하는 메서드입니다.
     * 사용자로부터 아이디와 비밀번호를 받아 로그인을 처리하고, 자동 로그인 기능을 제공합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        String autoLogin = req.getParameter("autoLogin");

        UserDAO dao = new UserDAO();
        UserDTO dto = new UserDTO();
        dto.setId(id);
        dto.setPw(pw);

        UserDTO result = dao.login(dto);
        if (result != null && result.getId() != null) {
            HttpSession session = req.getSession();
            session.setAttribute("id", result.getId());
            session.setAttribute("seqPriv", result.getSeqPriv());

            // seqUser 값을 가져와서 세션에 저장하는 코드 추가
            UserDAO userDAO = new UserDAO();
            int seqUser = userDAO.getSeqUserByMemberId(result.getId());
            session.setAttribute("seqUser", seqUser);

            if (autoLogin != null && autoLogin.equals("on")) {
                Cookie cookie = new Cookie("autoLogin", result.getId());
                cookie.setMaxAge(60 * 60 * 24 * 30); // 쿠키 유효기간 30일
                resp.addCookie(cookie);
            }

            resp.sendRedirect("/account/index.do");
        } else {
            result = dao.loginAdmin(dto);
            if (result != null && result.getId() != null) {
                HttpSession session = req.getSession();
                session.setAttribute("id", result.getId());
                session.setAttribute("seqPriv", result.getSeqPriv());

                // 관리자의 seqUser 값을 세션에 저장
                int seqUser = dao.getSeqUserByMemberId(result.getId());
                session.setAttribute("seqUser", seqUser);

                if (autoLogin != null && autoLogin.equals("on")) {
                    Cookie cookie = new Cookie("autoLogin", result.getId());
                    cookie.setMaxAge(60 * 60 * 24 * 30); // 쿠키 유효기간 30일
                    resp.addCookie(cookie);
                }

                resp.sendRedirect("/account/index.do");
            } else {
                resp.setCharacterEncoding("UTF-8");
                PrintWriter writer = resp.getWriter();
                writer.print(OutputUtil.redirect("로그인에 실패했습니다."));
                writer.close();
            }
        }
    }
}