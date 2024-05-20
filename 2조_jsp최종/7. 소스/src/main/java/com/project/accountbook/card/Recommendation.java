package com.project.accountbook.card;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.accountbook.card.model.CardDTO;
import com.project.accountbook.card.repository.CardDAO;

/**
 * 카드 추천 기능을 처리하는 서블릿입니다.
 * 랜덤한 카드 목록을 가져와 화면에 표시합니다.
 */
@WebServlet("/card/recommendation.do")
public class Recommendation extends HttpServlet {

    /**
     * GET 요청을 처리하는 메서드입니다.
     * 랜덤한 카드 목록을 가져와 화면에 표시합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Recommendation - doGet");

        CardDAO dao = new CardDAO();
        ArrayList<CardDTO> list = dao.randomCard();

        req.setAttribute("list", list);
        System.out.println("Random Card List Size: " + list.size());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/card/recommendation.jsp");
        dispatcher.forward(req, resp);
    }
}