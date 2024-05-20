package com.project.accountbook.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.project.accountbook.account.model.AccountInfoDTO;
import com.project.accountbook.account.repository.AccountDAO;

/**
 * 가계부 항목 삭제를 처리하는 서블릿 클래스입니다.
 */
@WebServlet("/account/calendardelete.do")
public class AccountDel extends HttpServlet {

	/**
     * POST 요청을 처리하여 가계부 항목을 삭제합니다.
     *
     * @param req  HTTP 요청 객체
     * @param resp HTTP 응답 객체
     * @throws ServletException 서블릿 예외
     * @throws IOException      입출력 예외
     */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("id");

        try {
            req.setCharacterEncoding("UTF-8");
            String seq = req.getParameter("seq");
            System.out.println(seq);
            AccountDAO dao = new AccountDAO();
            AccountInfoDTO dto = new AccountInfoDTO();

            // Set DTO properties from request
            System.out.println("dto start");
            dto.setIdMember(id);
            dto.setSeqAccInfo(seq);
            System.out.println("dto end");

            int delResult = dao.delAcc(dto);
            
            if (delResult > 0) {
                out.println("{\"message\": \"Update successful\", \"status\": \"success\"}");
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.println("{\"message\": \"Update failed\", \"status\": \"error\"}");
            }
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("{\"message\": \"" + e.getMessage() + "\", \"status\": \"error\"}");
        } 
    }

}