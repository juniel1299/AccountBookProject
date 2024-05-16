package com.project.accountbook.user.member;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.project.accountbook.user.member.repository.MemberInfoDAO;
import com.project.accountbook.user.model.UserDTO;

/**
* 회원 정보를 조회하는 서블릿입니다.
* GET 요청 시 회원 정보를 가져와 info.jsp 페이지로 전달합니다.
*/
@WebServlet("/user/member/info.do")
public class Info extends HttpServlet {

   /**
    * GET 요청을 처리하는 메서드입니다.
    * 세션에서 회원 ID를 가져와 회원 정보를 조회하고, info.jsp 페이지로 전달합니다.
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

       MemberInfoDAO dao = new MemberInfoDAO();
       UserDTO dto = dao.getMemberInfo(id);

       req.setAttribute("dto", dto);

       RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/member/info.jsp");
       dispatcher.forward(req, resp);
   }
}