package com.project.accountbook.user;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.project.accountbook.user.model.UserDTO;
import com.project.accountbook.user.repository.UserDAO;

/**
 * 회원 가입 기능을 수행하는 서블릿입니다.
 * 사용자로부터 회원 정보를 입력받아 회원 가입을 처리합니다.
 */
@WebServlet("/user/register.do")
public class Register extends HttpServlet {

    /**
     * GET 요청을 처리하는 메서드입니다.
     * 회원 가입 페이지로 포워딩합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/register.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * POST 요청을 처리하는 메서드입니다.
     * 사용자로부터 회원 정보를 입력받아 회원 가입을 처리합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        String name = req.getParameter("name");
        String nickname = req.getParameter("nickname");
        String phoneNumber = req.getParameter("phoneNumber");
        String ssn = req.getParameter("ssn");
        String gender = req.getParameter("gender");
        String challenge = req.getParameter("challenge");

        UserDTO dto = new UserDTO();
        dto.setId(id);
        dto.setPw(pw);
        dto.setName(name);
        dto.setNickname(nickname);
        dto.setPhoneNumber(phoneNumber);
        dto.setSsn(ssn);
        dto.setGender(gender);

        if (challenge != null) {
            String seqCompressionIntensity = req.getParameter("seqCompressionIntensity");
            String monthlyPaycheckStr = req.getParameter("monthlyPaycheck");
            String savingsGoalsStr = req.getParameter("savingsGoals");
            String seqSavingsPeriod = req.getParameter("seqSavingsPeriod");

            int monthlyPaycheck = 0;
            int savingsGoals = 0;

            if (monthlyPaycheckStr != null && !monthlyPaycheckStr.isEmpty()) {
                monthlyPaycheck = Integer.parseInt(monthlyPaycheckStr);
            }

            if (savingsGoalsStr != null && !savingsGoalsStr.isEmpty()) {
                savingsGoals = Integer.parseInt(savingsGoalsStr);
            }

            dto.setSeqCompressionIntensity(seqCompressionIntensity);
            dto.setMonthlyPaycheck(monthlyPaycheck);
            dto.setSavingsGoals(savingsGoals);
            dto.setSeqSavingsPeriod(seqSavingsPeriod);
        }

        UserDAO dao = new UserDAO();

        // 중복 검사 수행
        if (dao.isIdDuplicate(id)) {
            req.setAttribute("error", "아이디가 이미 사용 중입니다.");
        } else if (dao.isNicknameDuplicate(nickname)) {
            req.setAttribute("error", "닉네임이 이미 사용 중입니다.");
        } else if (dao.isPhoneNumberDuplicate(phoneNumber)) {
            req.setAttribute("error", "전화번호가 이미 사용 중입니다.");
        } else if (dao.isSsnDuplicate(ssn)) {
            req.setAttribute("error", "주민등록번호가 이미 사용 중입니다.");
        } else {
            // 중복 검사 통과 후 회원 가입 처리
            int result = dao.register(dto);

            if (result == 1) {
                resp.sendRedirect("/account/index.do");
            } else {
                req.setAttribute("error", "회원 가입에 실패했습니다.");
            }
        }

        int result = dao.register(dto);

        if (result == 1) {
            resp.sendRedirect("/account/index.do");
        }
    }
}