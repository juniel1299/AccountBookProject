package com.project.accountbook.user.member;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.project.accountbook.card.model.CardDTO;
import com.project.accountbook.user.member.model.MemberInfoDTO;
import com.project.accountbook.user.member.repository.MemberInfoDAO;

/**
* 사용자의 카드 정보를 조회하는 서블릿입니다.
* GET 요청 시 사용자의 카드 정보를 가져와 my-card.jsp 페이지로 전달합니다.
*/
@WebServlet("/user/member/my-card.do")
public class MyCard extends HttpServlet {

   /**
    * GET 요청을 처리하는 메서드입니다.
    * 세션에서 사용자 ID를 가져와 사용자의 카드 정보를 조회하고, my-card.jsp 페이지로 전달합니다.
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
       MemberInfoDTO dto = new MemberInfoDTO();

       ArrayList<MemberInfoDTO> clist = dao.getMyCards(id);

       req.setCharacterEncoding("UTF-8");
       req.setAttribute("clist", clist);

       RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/member/my-card.jsp");
       dispatcher.forward(req, resp);
   }

   // @Override
   // protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   //
   //     HttpSession session = req.getSession();
   //     String id = (String) req.getParameter("id");
   //     String seq = req.getParameter("seq");
   //
   //     System.out.println(id);
   //     System.out.println(seq);
   //
   //     MemberInfoDAO dao = new MemberInfoDAO();
   //     MemberInfoDTO dto = dao.delMyCard(id, seq);
   //
   //     RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/member/my-card.jsp");
   //     dispatcher.forward(req, resp);
   //
   // }
}