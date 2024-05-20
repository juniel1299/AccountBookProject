package com.project.accountbook.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

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
 * 구매 위시 항목을 삭제하는 서블릿 클래스입니다.
 */
@WebServlet("/account/delwishlist.do")
public class delWishList extends HttpServlet {

	 /**
     * POST 요청을 처리하여 구매 위시 항목을 삭제합니다.
     *
     * @param req  HTTP 요청 객체
     * @param resp HTTP 응답 객체
     * @throws ServletException 서블릿 예외
     * @throws IOException      입출력 예외
     */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("id");
		System.out.println(id);
		String wishitem = req.getParameter("content");
		
		
		AccountInfoDTO dto = new AccountInfoDTO();
		AccountDAO dao = new AccountDAO();
		
		System.out.println("delwishstart");
		dto.setIdMember(id);
		dto.setProductName(wishitem);
		System.out.println("delwishstart");
		
		System.out.println(wishitem);
		
		int indicate = dao.delwishlist(dto);
		
		System.out.println(indicate);
		
	}

}
