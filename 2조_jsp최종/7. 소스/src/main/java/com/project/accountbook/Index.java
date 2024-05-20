package com.project.accountbook;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* 인덱스 페이지를 처리하는 서블릿입니다.
* GET 요청 시 인덱스 페이지로 포워딩합니다.
*/
@WebServlet("/index.do")
public class Index extends HttpServlet {

   /**
    * GET 요청을 처리하는 메서드입니다.
    * 인덱스 페이지로 포워딩합니다.
    *
    * @param req  HttpServletRequest 객체입니다.
    * @param resp HttpServletResponse 객체입니다.
    * @throws ServletException 서블릿 예외가 발생한 경우입니다.
    * @throws IOException      입출력 예외가 발생한 경우입니다.
    */
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/index.jsp");
       dispatcher.forward(req, resp);
   }
}