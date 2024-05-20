package com.project.accountbook.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.accountbook.board.post.model.PostDTO;
import com.project.accountbook.board.repository.BoardDAO;

/**
 * 출석 게시판 기능을 수행하는 서블릿입니다.
 * 출석 게시글 목록을 조회하고 페이징, 검색, 좋아요, 싫어요, 신고 기능을 처리합니다.
 */
@WebServlet("/board/attendanceBoard.do")
public class AttendanceBoard extends HttpServlet {

    BoardDAO dao = new BoardDAO();

    /**
     * GET 요청을 처리하는 메서드입니다.
     * 출석 게시글 목록을 조회하고 페이징, 검색 기능을 처리합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("read", "n");

        // 쿠키 조회수
        Cookie cookies = new Cookie("cookieread", "n");
        cookies.setMaxAge(60 * 60);
        cookies.setPath("/");
        resp.addCookie(cookies);
        // 끝

        // 페이징
        String page = req.getParameter("page");

        int nowPage = 0;
        int totalCount = 0;
        int pageSize = 10;
        int totalPage = 0;
        int begin = 0;
        int end = 0;
        int n = 0;
        int loop = 0;
        int blockSize = 10;

        if (page == null || page.equals("")) {
            nowPage = 1;
        } else {
            nowPage = Integer.parseInt(page);
        }

        begin = ((nowPage - 1) * pageSize) + 1;
        end = begin + pageSize - 1;

        // 검색
        String column = req.getParameter("column");
        String word = req.getParameter("word");
        String search = "n"; // n : 목록보기, y : 검색하기

        if ((column == null && word == null) || (word.equals(""))) {
            search = "n";
        } else {
            search = "y";
        }

        HashMap<String, String> map = new HashMap<>();

        if (column == null)
            column = "";
        if (word == null)
            word = "";

        map.put("search", search);
        map.put("column", column);
        map.put("word", word);

        map.put("begin", begin + "");
        map.put("end", end + "");

        ArrayList<PostDTO> attendanceList = dao.list(map, "4");

        for (PostDTO list : attendanceList) {
            String title = list.getTitle();

            if (search != null && search.equals("y") && (column.equals("title") || column.equals("total"))) {
                title = title.replace(word, "<span style='color: tomato; font-weight: bold;'>" + word + "</span>");
                list.setTitle(title);
            }
        }

        totalCount = dao.getTotalCount(map, "4");
        totalPage = (int) Math.ceil((double) totalCount / pageSize);

        // 페이지 바
        StringBuilder sb = new StringBuilder();

        loop = 1;
        n = ((nowPage - 1) / blockSize) * blockSize + 1;

        // 이전 페이지
        if (n == 1) {
            sb.append(String.format(" <a href='#!'>[이전 %d페이지]</a> ", blockSize));
        } else {
            sb.append(String.format(" <a href='/account/board/freeBoard.do?page=%d&column=%s&word=%s'>[이전 %d페이지]</a> ", n - 1, column, word, blockSize));
        }

        // 페이지 리스트
        while (!(loop > blockSize || n > totalPage)) {
            if (n == nowPage) {
                sb.append(String.format(" <a href='#!' class='paging-nowpage'>%d</a> ", n));
            } else {
                sb.append(String.format(" <a href='/account/board/freeBoard.do?page=%d&column=%s&word=%s'>%d</a> ", n, column, word, n));
            }

            loop++;
            n++;
        }

        // 다음 페이지
        if (n >= totalPage) {
            sb.append(String.format(" <a href='#!'>[다음 %d페이지]</a> ", blockSize));
        } else {
            sb.append(String.format(" <a href='/account/board/freeBoard.do?page=%d&column=%s&word=%s'>[다음 %d페이지]</a> ", n, column, word, blockSize));
        }

        req.setAttribute("attendanceList", attendanceList); // attendanceList 객체를 요청 객체에 추가
        req.setAttribute("map", map);
        req.setAttribute("nowPage", nowPage);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("pagebar", sb.toString());
        req.setAttribute("seqBoard", "4");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/attendance-board.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * POST 요청을 처리하는 메서드입니다.
     * 좋아요, 싫어요, 신고 기능을 처리합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String seq = req.getParameter("seq"); // Post seq
        String type = req.getParameter("type"); // Like, Dislike, Report 구분

        Cookie postcookie;
        Cookie[] cookies = req.getCookies(); // 모든 쿠키 가져오기
        boolean postcheck = false;
        boolean reportcheck = false;

        if (cookies != null) {
            for (Cookie c : cookies) {
                String name = c.getName(); // 쿠키 이름 가져오기
                String value = c.getValue(); // 쿠키 내용 가져오기
                if (name.equals("postSeq" + seq) && value.equals(seq)) {
                    postcheck = true;
                }
                if (name.equals("report" + seq) && value.equals(seq)) {
                    reportcheck = true;
                }
            }
        }

        if (postcheck == false) {
            reportcheck = true;
            if (type.equals("like")) {
                dao.like(seq);
                postcookie = new Cookie("postSeq" + seq, seq);
                // postcookie.setMaxAge(60 * 60 * 24); //하루
                postcookie.setMaxAge(60 * 60); // 1시간
                postcookie.setPath("/");
                resp.addCookie(postcookie);
            } else if (type.equals("dislike")) {
                dao.dislike(seq);
                postcookie = new Cookie("postSeq" + seq, seq);
                // postcookie.setMaxAge(60 * 60 * 24);
                postcookie.setMaxAge(60 * 60);
                postcookie.setPath("/");
                resp.addCookie(postcookie);
            }
        }

        if (reportcheck == false) {
            dao.report(seq);
            postcookie = new Cookie("report" + seq, seq);
            postcookie.setMaxAge(60 * 60);
            postcookie.setPath("/");
            resp.addCookie(postcookie);
        }
    }
}