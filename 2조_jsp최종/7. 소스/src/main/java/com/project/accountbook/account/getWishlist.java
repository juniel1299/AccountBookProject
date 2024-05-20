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
 * 회원의 구매 위시 항목을 처리하는 서블릿 클래스입니다.
 */
@WebServlet("/account/wishlist.do")
public class getWishlist extends HttpServlet {

	 /**
     * GET 요청을 처리하여 회원의 구매 위시 항목을 가져와서 JSON 형식으로 응답합니다.
     *
     * @param req  HTTP 요청 객체
     * @param resp HTTP 응답 객체
     * @throws ServletException 서블릿 예외
     * @throws IOException      입출력 예외
     */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		// 인증받지 못한 사용자 or 권한이 없는 사용자 > 거부
//		if (Auth.check(req, resp)) {
//			return;
//		}
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		
		AccountDAO dao = new AccountDAO();
		
		
		ArrayList<AccountInfoDTO> wishlist = dao.mywishlist(id);
		
		 // Serialize data to JSON
        
        JSONArray arr = new JSONArray();
		for (AccountInfoDTO dto : wishlist) {
			JSONObject obj = new JSONObject();
			obj.put("productName",dto.getProductName());
			arr.add(obj);
		}

        // Set response content type to JSON and send the JSON as response
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
			
		
		PrintWriter writer = resp.getWriter();

		writer.print(arr);
		writer.close();

	}
	
	 /**
     * POST 요청을 처리하여 회원의 구매 위시 항목을 추가합니다.
     *
     * @param req  HTTP 요청 객체
     * @param resp HTTP 응답 객체
     * @throws ServletException 서블릿 예외
     * @throws IOException      입출력 예외
     */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		
		req.setCharacterEncoding("UTF-8");
		String wishitem = req.getParameter("item");
		
		
		AccountInfoDTO dto = new AccountInfoDTO();
		AccountDAO dao = new AccountDAO();
		
		dto.setIdMember(id);
		dto.setProductName(wishitem);
		
		System.out.println(wishitem);
		
		int indicate = dao.addlist(dto);
		
		System.out.println(indicate);

	}

}
