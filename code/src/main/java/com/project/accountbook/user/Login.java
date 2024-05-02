package com.project.accountbook.user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.project.accountbook.user.model.UserDTO;
import com.project.accountbook.user.repository.UserDAO;
import com.project.accountbook.util.OutputUtil;

@WebServlet("/user/login.do")
public class Login extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/login.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//LoginOk.java 역할
//1. 데이터 가져오기(id, pw)
//2. DB 작업 > select
//3. 결과 > 인증 티켓
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		UserDAO dao = new UserDAO();
		UserDTO dto = new UserDTO();
		dto.setId(id);
		dto.setPw(pw);
//int result = dao.login(dto); //1, 0
		UserDTO result = dao.login(dto);// dto, null
		if (result != null && result.getId() != null) {
			HttpSession session = req.getSession();
			session.setAttribute("id", result.getId());
			resp.sendRedirect("/account/index.do"); // 로그인 성공 후 리다이렉트할 페이지 경로
		} else {
			resp.setCharacterEncoding("UTF-8");
			PrintWriter writer = resp.getWriter();
			writer.print(OutputUtil.redirect("로그인에 실패했습니다."));
			writer.close();
		}
	}
}