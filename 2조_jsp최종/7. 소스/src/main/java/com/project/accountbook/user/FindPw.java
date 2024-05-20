package com.project.accountbook.user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.project.accountbook.user.model.UserDTO;
import com.project.accountbook.user.repository.UserDAO;
import com.project.accountbook.util.OutputUtil;

/**
 * 비밀번호 찾기 기능을 수행하는 서블릿입니다.
 * 사용자로부터 아이디와 이름을 입력받아 일치하는 회원 정보가 있는 경우 비밀번호 재설정 이메일을 발송합니다.
 */
@WebServlet("/user/find-pw.do")
public class FindPw extends HttpServlet {

    /**
     * GET 요청을 처리하는 메서드입니다.
     * 비밀번호 찾기 페이지로 포워딩합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/find-pw.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * POST 요청을 처리하는 메서드입니다.
     * 사용자로부터 아이디와 이름을 받아 일치하는 회원 정보를 확인하고, 비밀번호 재설정 이메일을 발송합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        System.out.println(id);
        System.out.println(name);
        UserDAO dao = new UserDAO();
        int checkId = dao.checkId(id, name);
        // 일치하는 회원 정보가 존재하면
        if (checkId != 0) {
            int result = dao.gmailSend(id, name);
            req.setAttribute("result", result);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/find-pw.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.setCharacterEncoding("UTF-8");
            PrintWriter writer = resp.getWriter();
            writer.print(OutputUtil.redirect("일치하는 회원 정보가 존재하지 않습니다."));
            writer.close();
        }
    }
}