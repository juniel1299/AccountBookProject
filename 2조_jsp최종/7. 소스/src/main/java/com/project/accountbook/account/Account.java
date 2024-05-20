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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.project.accountbook.account.model.AccountInfoDTO;
import com.project.accountbook.account.repository.AccountDAO;

/**
 * 회원의 가계부 정보를 관리하는 서블릿 클래스입니다.
 */
@WebServlet("/account/calendar.do")
public class Account extends HttpServlet {

	/**
     * GET 요청을 처리하여 가계부 캘린더 정보를 가져오고, 화면에 표시합니다.
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
		String id = (String) session.getAttribute("id");

		String word = req.getParameter("word");
		String search = "n"; // 목록보기(n), 검색하기(y)

		if ((word == null) || (word.equals(""))) {
			search = "n";
		} else {
			search = "y";
		}

		HashMap<String, String> map = new HashMap<>();

		if (word == null)
			word = "";

		map.put("search", search);
		map.put("word", word);

		AccountDAO dao = new AccountDAO();

		ArrayList<AccountInfoDTO> calenderdata = dao.accEventContent(id, map);

		ArrayList<AccountInfoDTO> cardlist = dao.getmycards(id);

		JSONArray arr = new JSONArray();
		for (AccountInfoDTO dto : calenderdata) {
			JSONObject obj = new JSONObject();
			String start = "20" + dto.getAccInfoDate().replace("/", "-");

			obj.put("title", dto.getTitle());
			obj.put("start", dto.getAccInfoDate());
			obj.put("loc", dto.getLocation());
			obj.put("content", dto.getContent());
			obj.put("amountIndicator", dto.getSeqDepositWithdrawalStatus());
			obj.put("amount", dto.getPrice());
			obj.put("category", dto.getAcName());
			obj.put("fixed", dto.getSeqFixedFluctuationCheck());
			obj.put("fixedperiod", dto.getSeqFixedFluctuationPeriod());

			arr.add(obj);
		}

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");

		req.setAttribute("eventsev", arr);
		ArrayList<AccountInfoDTO> cList = dao.getCategory();
		req.setAttribute("cList", cList);
		req.setAttribute("cardlist", cardlist);

		System.out.println(cardlist);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/account/calendar.jsp");
		dispatcher.forward(req, resp);

	}

	/**
     * POST 요청을 처리하여 가계부 이벤트를 추가하고, 관련 작업을 수행합니다.
     *
     * @param req  HTTP 요청 객체
     * @param resp HTTP 응답 객체
     * @throws ServletException 서블릿 예외
     * @throws IOException      입출력 예외
     */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 데이터 가져오기()
		// 2. DB 작업 > select
		// 3. 결과 > 인증 티켓

		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");

		req.setCharacterEncoding("UTF-8");
		String accInfoDate = (req.getParameter("start")).substring(0, 10);
		String location = req.getParameter("useLocation");
		String content = req.getParameter("content");
		String seqAccCategory = req.getParameter("category");
		String seqReasonsChangeList = req.getParameter("paymentMethod");
		String price = req.getParameter("amount");
		String seqDepositWithdrawalStatus = req.getParameter("amountindicator");
		String fdwContent = req.getParameter("isFixedExpense");
		String fdwperiod = req.getParameter("isFixedperiod");
		String fdwMemo = req.getParameter("fixedMemo");
		System.out.println("1. paymethodstart");
		String method = null;
		String cardNum = null;
		if(seqReasonsChangeList != null) {
			String [] paymethod = seqReasonsChangeList.split(":");
			method = paymethod[0];
			if(paymethod.length==2) {
				cardNum = paymethod[2];
				
			}
				
		}
		int paycontentseq = 0;
		System.out.println("2. methodcheck");
		if(method.contains("카드")) {
			if(method.contains("체크")) {
				paycontentseq = 3;
			}else {
				paycontentseq = 2;
			}
		}else {
			if (method.contains("계좌")) {
				paycontentseq = 1;
			}else {
				paycontentseq = 4;
			}
		}
		if(fdwperiod!=null) {
			if(Integer.parseInt(fdwperiod)==1) {
				fdwperiod = "1";
			}else if(Integer.parseInt(fdwperiod)==3) {
				fdwperiod ="2";
			}else if(Integer.parseInt(fdwperiod)==12) {
				fdwperiod="3";
			}
		}
		System.out.println("3. dao start");
		AccountInfoDTO dto = new AccountInfoDTO();
		AccountDAO dao = new AccountDAO();
		int runcheck=0;
		if(paycontentseq > 0) {
			runcheck = dao.makercc(paycontentseq,cardNum);
		}
		System.out.println(seqReasonsChangeList);
		System.out.println("4. dtostart");
		dto.setIdMember(id);
		dto.setAccInfoDate(accInfoDate);
		dto.setLocation(location);
		dto.setContent(content);
		dto.setSeqAccCategory(seqAccCategory);
		dto.setSeqReasonsChangeList(seqReasonsChangeList);
		dto.setPrice(Integer.parseInt(price));
		dto.setSeqDepositWithdrawalStatus(seqDepositWithdrawalStatus);
		dto.setSeqReasonChangeCategory(String.valueOf(paycontentseq));
		if (fdwContent.equals("true")) {
			dto.setSeqFixedFluctuationPeriod(fdwperiod);
			dto.setFdwContent(fdwMemo);
			
			int seqfixedcheck =  dao.fixedevent(dto);
			dto.setSeqFixedFluctuationCheck(String.valueOf(seqfixedcheck));
			System.out.println("seqfixedcheck : "+seqfixedcheck);
		}else {
			dto.setSeqFixedFluctuationCheck("0");
		}
		  
		  int indicate = dao.addEvent(dto);
		  
		  if(dto.getSeqFixedFluctuationCheck() == "true") {
			  
			  int makemore = dao.dupEvent(dto);
			  System.out.println("proc insert : "+makemore);
		  }
		  
		  System.out.println("tblrcc insert : "+runcheck);
		  
		  System.out.println("tblaccinfo insert : "+indicate); 

	}

}
