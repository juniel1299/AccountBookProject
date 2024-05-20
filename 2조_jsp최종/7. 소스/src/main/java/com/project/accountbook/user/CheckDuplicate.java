package com.project.accountbook.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.project.accountbook.user.repository.UserDAO;

/**
 * 중복 검사를 수행하는 서블릿입니다.
 * 사용자로부터 필드와 값을 받아 해당 필드의 값이 중복되는지 확인합니다.
 */
@WebServlet("/user/checkDuplicate.do")
public class CheckDuplicate extends HttpServlet {

    /**
     * POST 요청을 처리하는 메서드입니다.
     * 필드와 값을 받아 중복 검사를 수행하고 결과를 반환합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String field = req.getParameter("field");
        String value = req.getParameter("value");

        UserDAO dao = new UserDAO();
        boolean isDuplicate = false;

        switch (field) {
            case "id":
                isDuplicate = dao.isIdDuplicate(value);
                break;
            case "nickname":
                isDuplicate = dao.isNicknameDuplicate(value);
                break;
            case "phoneNumber":
                isDuplicate = dao.isPhoneNumberDuplicate(value);
                break;
            case "ssn":
                isDuplicate = dao.isSsnDuplicate(value);
                break;
        }

        resp.setContentType("text/plain");
        resp.getWriter().write(isDuplicate ? "duplicate" : "available");
    }
}