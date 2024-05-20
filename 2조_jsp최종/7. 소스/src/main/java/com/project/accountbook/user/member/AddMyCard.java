package com.project.accountbook.user.member;

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
import com.project.accountbook.card.model.CardDTO;
import com.project.accountbook.card.repository.CardDAO;
import com.project.accountbook.user.member.model.MemberInfoDTO;
import com.project.accountbook.user.member.repository.MemberInfoDAO;

/**
 * 사용자의 카드 추가 기능을 처리하는 서블릿입니다.
 * GET 요청 시 카드 추가 페이지로 이동하고, POST 요청 시 카드 정보를 받아 데이터베이스에 저장합니다.
 */
@WebServlet("/user/member/add-my-card.do")
public class AddMyCard extends HttpServlet {

    /**
     * GET 요청을 처리하는 메서드입니다.
     * 카드 추가 페이지로 이동하기 전에 모든 카드 정보를 조회하여 request에 저장합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        CardDAO dao = new CardDAO();
        CardDTO dto = new CardDTO();

        ArrayList<CardDTO> list = dao.getAllCards();
        System.out.println(list);

        resp.setCharacterEncoding("UTF-8");
        req.setAttribute("list", list);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/member/add-my-card.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * POST 요청을 처리하는 메서드입니다.
     * 사용자가 입력한 카드 정보를 받아 데이터베이스에 저장합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String cardname = req.getParameter("cardName");
        String cardCompany = req.getParameter("cardIssuer");
        String cardNumber = req.getParameter("cardNumber");
        String nickname = req.getParameter("nickname");
        String exp = req.getParameter("expirationDate");

        System.out.println();
        System.out.println(cardname);
        System.out.println(exp);

        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("id");

        CardDTO dto = new CardDTO();
        dto.setCiName(cardname);
        dto.setCardCompany(cardCompany);
        dto.setCardNumber(cardNumber);
        dto.setAlias(nickname);
        dto.setEnddate(exp);

        MemberInfoDAO dao = new MemberInfoDAO();
        dao.addMyCard(id, dto);

        resp.setCharacterEncoding("UTF-8");
        resp.sendRedirect(req.getContextPath() + "/account/user/member/my-card.do");
    }
}