package com.project.accountbook.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.accountbook.util.OutputUtil;

/**
 * 사용자 권한을 검사하여 로그인이 필요한 페이지에 대한 접근을 제어하는 필터입니다.
 */
public class AuthFilter implements Filter {

	 /**
     * 서블릿 필터가 요청을 필터링하는 메서드입니다.
     * 
     * @param request  요청 객체
     * @param response 응답 객체
     * @param chain    필터 체인
     * @throws IOException      입출력 예외가 발생할 경우
     * @throws ServletException 서블릿 예외가 발생할 경우
     */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		HttpSession session = req.getSession();

		if (session.getAttribute("id") == null) {

			if (req.getRequestURI().contains("card") 
					|| req.getRequestURI().endsWith("reportBoard.do")
					|| req.getRequestURI().endsWith("attendanceBoard.do")
					|| req.getRequestURI().contains("/account/account/")
					|| req.getRequestURI().contains("/account/user/member/") && !req.getRequestURI().contains("reset-pw")) {
				
				HttpServletResponse httpResponse = (HttpServletResponse) response;
		        httpResponse.sendRedirect("/account/user/login.do");
		        return;

			}
		}

		// 여기서 끝나기 때문에 넘겨줘야한다.
		chain.doFilter(request, response);

	}

}
