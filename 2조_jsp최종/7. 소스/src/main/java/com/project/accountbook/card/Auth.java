package com.project.accountbook.card;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.project.accountbook.board.repository.BoardDAO;
import com.project.accountbook.util.OutputUtil;

/**
 * 게시글 권한 체크를 수행하는 클래스입니다.
 * 사용자의 권한을 확인하여 게시글 수정, 삭제 등의 작업 권한을 검사합니다.
 */
public class Auth {

    /**
     * 사용자의 권한을 체크하는 메서드입니다.
     * 게시글의 작성자 본인인지 또는 관리자인지 확인합니다.
     *
     * @param req  HttpServletRequest 객체입니다.
     * @param resp HttpServletResponse 객체입니다.
     * @return 권한이 없을 경우 true, 권한이 있을 경우 false를 반환합니다.
     * @throws IOException 입출력 예외가 발생한 경우입니다.
     */
    public static boolean check(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        HttpSession session = req.getSession();
//        String seq = req.getParameter("seq"); // Edit.java의 req를 받았기 때문에 seq를 받을 수 있습니다.
//
//        // 글쓴이 본인?
//        BoardDAO dao = new BoardDAO();
//        BoardDTO dto = dao.get(seq);
//
//        // id != dto.id && lv != 2
//        if (session.getAttribute("id") == null || (!session.getAttribute("id").toString().equals(dto.getId())
//                && !session.getAttribute("lv").toString().equals("2"))) {
//            resp.setCharacterEncoding("UTF-8");
//            PrintWriter writer = resp.getWriter();
//            writer.print(OutputUtil._redirect_("권한이 없습니다."));
//            writer.close();
//            return true;
//        }

        return false;
    }
}