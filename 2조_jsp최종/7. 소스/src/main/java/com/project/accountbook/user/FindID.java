package com.project.accountbook.user;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.project.accountbook.user.repository.UserDAO;

/**
 * 아이디 찾기 기능을 수행하는 서블릿입니다.
 * 사용자로부터 이름과 주민등록번호를 입력받아 해당하는 아이디를 찾습니다.
 */
@WebServlet("/user/find-id.do")
public class FindID extends HttpServlet {

    /**
     * GET 요청을 처리하는 메서드입니다.
     * 아이디 찾기 페이지로 포워딩합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/find-id.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * POST 요청을 처리하는 메서드입니다.
     * 사용자로부터 이름과 주민등록번호를 받아 아이디를 찾고, 결과를 아이디 찾기 페이지로 전달합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String ssn = req.getParameter("ssn");
        System.out.println("Input Name: " + name);
        System.out.println("Input SSN: " + ssn);
        UserDAO dao = new UserDAO();
        String foundId = dao.findId(name, ssn);
        req.setAttribute("foundId", foundId);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/find-id.jsp");
        dispatcher.forward(req, resp);
    }
}