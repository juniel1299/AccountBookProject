package com.project.accountbook.user.member;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.project.accountbook.user.repository.UserDAO;

/**
 * 친구 초대 기능을 처리하는 서블릿입니다.
 * GET 요청 시 친구 초대 페이지로 이동하고, API 키를 가져와 페이지에 전달합니다.
 */
@WebServlet("/user/member/friend-invitation.do")
public class FriendInvitation extends HttpServlet {

    /**
     * GET 요청을 처리하는 메서드입니다.
     * 친구 초대 페이지로 이동하고, API 키를 가져와 페이지에 전달합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 데이터 가져오기
        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("id");

        UserDAO dao = new UserDAO();
        HashMap<String, String> map = dao.getAPIKey("1");

        req.setAttribute("key", map.get("key"));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/member/friend-invitation.jsp");
        dispatcher.forward(req, resp);
    }
}