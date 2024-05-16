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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.project.accountbook.user.member.model.MemberInfoDTO;
import com.project.accountbook.user.member.repository.MemberInfoDAO;

/**
 * 사용자의 도전 과제 정보를 수정하는 서블릿입니다.
 * GET 요청 시 도전 과제 정보를 조회하여 JSON 형식으로 반환하고, POST 요청 시 도전 과제 정보를 업데이트합니다.
 */
@WebServlet("/user/member/edit-challenge.do")
public class EditChallenge extends HttpServlet {

    /**
     * GET 요청을 처리하는 메서드입니다.
     * 사용자의 도전 과제 정보를 조회하여 JSON 형식으로 반환합니다.
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
        ArrayList<MemberInfoDTO> challengeList = dao.getChallengeInfo(id);

        JSONArray arr = new JSONArray();

        for (MemberInfoDTO dto : challengeList) {
            JSONObject obj = new JSONObject();
            obj.put("sallary", dto.getMonthlyPaycheck());
            obj.put("goal", dto.getSavingsGoals());
            obj.put("period", dto.getSavingPeriod());
            arr.add(obj);
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        req.setAttribute("clist", arr);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/member/edit-challenge.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * POST 요청을 처리하는 메서드입니다.
     * 사용자의 도전 과제 정보를 업데이트합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("id");

        MemberInfoDAO dao = new MemberInfoDAO();
        MemberInfoDTO dto = new MemberInfoDTO();

        String sallary = req.getParameter("sallary");
        String goal = req.getParameter("goal");
        String period = req.getParameter("period");

        if (!sallary.isEmpty()) {
            dto = dao.editSallary(id, sallary);
        }

        if (!goal.isEmpty()) {
            dto = dao.editGoal(id, goal);
        }

        if (!period.isEmpty()) {
            dto = dao.editPeriod(id, period);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/member/edit-challenge.jsp");
        dispatcher.forward(req, resp);
    }
}