package com.project.accountbook.user.member;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.project.accountbook.user.member.repository.MemberInfoDAO;
import com.project.accountbook.user.model.UserDTO;

/**
 * 사용자 정보 수정을 처리하는 서블릿입니다.
 * GET 요청 시 사용자 정보를 조회하여 수정 페이지로 전달하고, POST 요청 시 사용자 정보를 업데이트합니다.
 */
@WebServlet("/user/member/edit-info.do")
public class EditInfo extends HttpServlet {

    /**
     * GET 요청을 처리하는 메서드입니다.
     * 사용자 정보를 조회하여 수정 페이지로 전달합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("id");

        MemberInfoDAO dao = new MemberInfoDAO();
        UserDTO dto = dao.getMemberInfo(id);

        req.setAttribute("dto", dto);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/member/edit-info.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * POST 요청을 처리하는 메서드입니다.
     * 사용자 정보를 업데이트합니다.
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

        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String nickname = req.getParameter("nickname");
        String phonenumber = req.getParameter("phonenumber");

        HashMap<String, String> map = new HashMap<>();

        MemberInfoDAO dao = new MemberInfoDAO();
        UserDTO dto = new UserDTO();

        String beforePhoneNumber = dao.getPhoneNumber(id);

        if (name != null && !name.isEmpty()) {
            map.put("name", name);
        }

        if (nickname != null && !nickname.isEmpty()) {
            map.put("nickname", nickname);
        }

        if (phonenumber != null && !phonenumber.isEmpty()) {
            String newPhoneNumber = phonenumber;
            boolean isPhoneNumberUnique = dao.isPhoneNumberUnique(newPhoneNumber, id);

            if (isPhoneNumberUnique) {
                map.put("phonenumber", newPhoneNumber);
            } else {
                System.out.println("중복된 전화번호가 있습니다.");
                map.put("phonenumber", beforePhoneNumber);
            }
        } else {
            map.put("phonenumber", beforePhoneNumber);
        }

        // DAO를 사용하여 업데이트 수행
        dao = new MemberInfoDAO();
        dao.updateUserInfo(id, map);

        resp.setCharacterEncoding("UTF-8");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/member/edit-info.jsp");
        dispatcher.forward(req, resp);
    }
}