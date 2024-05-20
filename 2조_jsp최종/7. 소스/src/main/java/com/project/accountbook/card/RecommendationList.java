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
 * 카드 추천 목록을 처리하는 서블릿입니다.
 * 선택한 카테고리에 해당하는 카드 목록을 가져와 화면에 표시합니다.
 */
@WebServlet("/card/recommendation-list.do")
public class RecommendationList extends HttpServlet {

	
	
	
    private static final String[] CATEGORIES = {
            "모든가맹점", "교통", "주유", "통신", "마트/편의점", "쇼핑", "푸드", "카페/디저트", "뷰티/피트니스",
            "무실적", "공과금/렌탈", "병원/약국", "애완동물", "교육/육아", "자동차/하이패스",
            "레저/스포츠", "영화/문화", "간편결제", "항공마일리지", "공항라운지/PP", "프리미엄",
            "여행/숙박", "해외", "비즈니스"
    };

    /**
     * GET 요청을 처리하는 메서드입니다.
     * 선택한 카테고리에 해당하는 카드 목록을 가져와 화면에 표시합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String category = req.getParameter("category");
        System.out.println("Selected Category: " + category); // 선택한 카테고리 값 출력
        
        
        
        if (category == null || category.isEmpty()) {
            category = "통신";
        }

        boolean isValidCategory = false;
        for (String validCategory : CATEGORIES) {
            if (validCategory.equals(category)) {
                isValidCategory = true;
                break;
            }
        }

        if (!isValidCategory) {
            category = "통신";
        }

        CardDAO dao = new CardDAO();
        ArrayList<CardDTO> list = dao.categoryCard(category);

        req.setAttribute("list", list);
        req.setAttribute("selectedCategory", category);

        System.out.println("Selected Category in Servlet: " + category);
        System.out.println("Number of Cards in Servlet: " + list.size());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/card/recommendation-list.jsp");
        dispatcher.forward(req, resp);
    }
}