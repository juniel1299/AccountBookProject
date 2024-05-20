package com.project.accountbook.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.accountbook.board.comment.model.CommentDTO;
import com.project.accountbook.board.comment.repository.CommentDAO;
import com.project.accountbook.board.post.model.PostDTO;
import com.project.accountbook.board.repository.BoardDAO;

/**
 * 게시글 상세 페이지 및 댓글 관련 기능을 처리하는 서블릿입니다.
 * GET 요청 시 게시글 상세 정보와 댓글 목록을 조회하여 화면에 출력합니다.
 * POST 요청 시 댓글 수정, 좋아요, 싫어요 기능을 처리합니다.
 */
@WebServlet({"/board/discussion.do", "/board/updateCommentLike.do", "/board/updateCommentDislike.do"})
public class Discussion extends HttpServlet {
    
    CommentDTO cdto = new CommentDTO();
    CommentDAO cdao = new CommentDAO();
    BoardDAO bdao = new BoardDAO();

    /**
     * GET 요청을 처리하는 메서드입니다.
     * 게시글 상세 정보와 댓글 목록을 조회하여 화면에 출력합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cookie[] cookies = req.getCookies();
        Cookie cookie;

        String seq = req.getParameter("seq");

        // 쿠키로 조회수 조절
        if (cookies != null) {
            for (Cookie c : cookies) {
                String name = c.getName(); // 쿠키 이름 가져오기
                String value = c.getValue(); // 쿠키 내용 가져오기
                if (name.equals("cookieread") && value.equals("n")) {
                    // bdao.updateReadcount(seq);
                    cookie = new Cookie("cookieread", "y");
                    cookie.setMaxAge(60 * 60);
                    cookie.setPath("/");
                    resp.addCookie(cookie);
                }
            }
        }

        // 세션으로 조회수 조절
        if (session.getAttribute("read") != null
                && session.getAttribute("read").toString().equals("n")) {
            // 조회수 증가
            bdao.updateReadcount(seq);
            session.setAttribute("read", "y");
        }

        Integer seqUser = (Integer) session.getAttribute("seqUser");

        String id = (String) session.getAttribute("id");

        PostDTO post = bdao.readPost(seq, id);

        List<CommentDTO> comments = cdao.getCommentsByPostSeq(seq);

        for (CommentDTO comment : comments) {
            List<CommentDTO> replyComments = cdao.getReplyCommentsByCommentSeq(comment.getSeq());
            comment.setReplyComments(replyComments);
        }

        req.setAttribute("post", post);
        req.setAttribute("comments", comments);
        req.setAttribute("seqUser", seqUser);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/discussion.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * POST 요청을 처리하는 메서드입니다.
     * 댓글 수정, 좋아요, 싫어요 기능을 처리합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @throws ServletException 서블릿 예외가 발생한 경우입니다.
     * @throws IOException      입출력 예외가 발생한 경우입니다.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        if (action != null) {
            switch (action) {
                case "updateComment":
                    String commentSeq = req.getParameter("commentSeq");
                    String editedContent = req.getParameter("editedContent");
                    int result = cdao.updateComment(commentSeq, editedContent);
                    if (result > 0) {
                        resp.getWriter().write("Success");
                    } else {
                        resp.getWriter().write("Fail");
                    }
                    break;
                case "updateCommentLike":
                    String likeCommentSeq = req.getParameter("commentSeq");
                    int likeResult = cdao.updateCommentLike(likeCommentSeq);
                    if (likeResult > 0) {
                        resp.getWriter().write("Success");
                    } else {
                        resp.getWriter().write("Fail");
                    }
                    break;
                case "updateCommentDislike":
                    String dislikeCommentSeq = req.getParameter("commentSeq");
                    int dislikeResult = cdao.updateCommentDislike(dislikeCommentSeq);
                    if (dislikeResult > 0) {
                        resp.getWriter().write("Success");
                    } else {
                        resp.getWriter().write("Fail");
                    }
                    break;
            }
        }
    }
}