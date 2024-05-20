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
 * 회원의 가계부 수정을 처리하는 서블릿 클래스입니다.
 */
@WebServlet("/account/calendaredit.do")
public class AccountEdit extends HttpServlet {

	/**
     * POST 요청을 처리하여 가계부 정보를 수정하고 결과를 반환합니다.
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
            String accInfoDate = req.getParameter("start").substring(0, 10);
            String location = req.getParameter("useLocation");
            String content = req.getParameter("content");
            String category = req.getParameter("category");
            String paymentMethod = req.getParameter("paymentMethod");
            String amount = req.getParameter("amount");
            String amountIndicator = req.getParameter("amountindicator");
            String isFixedExpense = req.getParameter("fixed");
            String seq = req.getParameter("seq");
            String seqacc = req.getParameter("seqacc");
            String seqrcc = req.getParameter("seqrcc");
            String method = null;
    		String cardNum = null;
    		System.out.println("method: "+method+" cardnum: "+cardNum);
    		
    		int paycontentseq = 0;
    		System.out.println("seq: "+seq);
    		System.out.println("2. methodcheck");
            AccountDAO dao = new AccountDAO();
            AccountInfoDTO dto = new AccountInfoDTO();
            // Set DTO properties from request
            System.out.println("dto start");
            dto.setIdMember(id);
            dto.setSeqAccInfo(seq);
            dto.setSeqAcc(seqacc);
            dto.setSeqReasonChangeCategory(seqrcc);
            dto.setCardNumber(cardNum);
    		dto.setAccInfoDate(accInfoDate);
    		dto.setLocation(location);
    		dto.setContent(content);
    		dto.setSeqAccCategory(category);
    		dto.setSeqReasonsChangeList(String.valueOf(paycontentseq));
    		dto.setPrice(Integer.parseInt(amount));
    		dto.setSeqDepositWithdrawalStatus(amountIndicator);
    		dto.setSeqFixedFluctuationCheck(isFixedExpense);
            System.out.println("dto end");
            

            int editResult = dao.updateAcc(dto);

            if (editResult > 0) {
                out.println("{\"message\": \"Update successful\", \"status\": \"success\"}");
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.println("{\"message\": \"Update failed\", \"status\": \"error\"}");
            }
        } catch (Exception e) {
        	e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("{\"message\": \"" + e.getMessage() + "\", \"status\": \"error\"}");
        } 
    }
}