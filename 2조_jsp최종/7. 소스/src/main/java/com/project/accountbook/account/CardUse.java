package com.project.accountbook.account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.accountbook.account.model.AccountInfoDTO;
import com.project.accountbook.account.repository.AccountDAO;

/**
 * 회원의 카드 사용 내역을 처리하는 서블릿 클래스입니다.
 */
@WebServlet("/account/card-use.do")
public class CardUse extends HttpServlet {

	 /**
     * GET 요청을 처리하여 회원의 카드 사용 내역을 가져오고 페이지를 렌더링합니다.
     *
     * @param req  HTTP 요청 객체
     * @param resp HTTP 응답 객체
     * @throws ServletException 서블릿 예외
     * @throws IOException      입출력 예외
     */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//카드 사용 정보 가져오기
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		
		// 시작일과 종료일 받아오기
	    String startDate = req.getParameter("startDate");
	    String endDate = req.getParameter("endDate");
	    
	    HashMap<String, String> map = new HashMap<>();
	    
	    map.put("startDate", startDate);
	    map.put("endDate", endDate);
	    
		AccountDAO dao = new AccountDAO();
		
		ArrayList<AccountInfoDTO> list = dao.list(id, map);
				
		req.setAttribute("list", list);
		req.setAttribute("map", map);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/account/card-use.jsp");
		dispatcher.forward(req, resp);

	}
	
}