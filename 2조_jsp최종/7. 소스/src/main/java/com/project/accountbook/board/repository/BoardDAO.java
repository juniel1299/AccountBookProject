package com.project.accountbook.board.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.Cookie;

import com.project.accountbook.board.post.model.PostDTO;
import com.project.accountbook.util.DBUtil;

/**
 * 게시판 관련 데이터베이스 작업을 수행하는 DAO 클래스입니다.
 */
public class BoardDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    /**
     * BoardDAO 생성자입니다.
     * 데이터베이스 연결을 설정합니다.
     */
    public BoardDAO() {
        this.conn = DBUtil.open("125.241.245.222", "webproject", "java1234");
    }

    /**
     * 세션에서 사용자의 시퀀스 번호를 읽어오는 메서드입니다.
     * @param id 사용자의 아이디입니다.
     * @return 사용자의 시퀀스 번호를 반환합니다.
     */
    public String readSession(String id) {
        try {
            String sql = "select seq from tblUser where idMember = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, id);
            rs = pstat.executeQuery();

            if (rs.next()) {
                String seq = rs.getString("seq");
                return seq;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 게시글을 작성하는 메서드입니다.
     * @param dto 게시글 정보를 담은 PostDTO 객체입니다.
     * @return 게시글 작성 결과를 반환합니다.
     */
    public int boardWrite(PostDTO dto) {
        try {
            String sql = "INSERT INTO tblPost (seq, seqBoard, seqUser, title, content, writeDate, editDate, viewCount, likeCount, dislikeCount, reportCount, secretCheck, blindCheck) "
                    + "VALUES ((SELECT NVL(MAX(seq), 0) + 1 FROM tblPost), ?, ?, ?, ?, SYSDATE, null, 0, 0, 0, 0, ?, 0)";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, dto.getSeqBoard());
            pstat.setString(2, dto.getSeqUser());
            pstat.setString(3, dto.getTitle());
            pstat.setString(4, dto.getContent());
            pstat.setInt(5, dto.getSecretCheck());

            System.out.println(sql);
            int result = pstat.executeUpdate();
            System.out.println("result: " + result);

            return result; // 실행 결과 반환

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * 게시글을 읽어오는 메서드입니다.
     * @param seq 게시글의 시퀀스 번호입니다.
     * @param id 사용자의 아이디입니다.
     * @return 게시글 정보를 담은 PostDTO 객체를 반환합니다.
     */
    public PostDTO readPost(String seq, String id) {
        try {
            PostDTO dto = new PostDTO();

            String sql = "select\r\n"
                    + "    po_seq as seq,\r\n"
                    + "    me_nickname as me_nickname,\r\n"
                    + "    ad_nickname as ad_nickname,\r\n"
                    + "    ca_seq as seqboard,\r\n"
                    + "    po_seqUser as seqUser,\r\n"
                    + "    po_title as title,\r\n"
                    + "    po_content as content,\r\n"
                    + "    po_writedate as writedate,\r\n"
                    + "    po_editdate as editdate,\r\n"
                    + "    po_viewcount as viewcount,\r\n"
                    + "    po_likecount as likecount,\r\n"
                    + "    po_dislikecount as dislikecount,\r\n"
                    + "    po_reportcount as reportcount,\r\n"
                    + "    po_secretcheck as secretcheck,\r\n"
                    + "    po_blindcheck as blindcheck,\r\n"
                    + "    us_seq as seqpost,\r\n"
                    + "    af_filename as filename,\r\n"
                    + "    af_filelink as filelink,\r\n"
                    + "    me_id as id\r\n"
                    + "from vwboard2 where po_seq = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seq);

            rs = pstat.executeQuery();

            if (rs.next()) {
                dto.setSeq(rs.getString("seq"));
                dto.setSeqBoard(rs.getString("seqboard"));
                dto.setSeqUser(rs.getString("sequser"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setWriteDate(rs.getString("writedate"));
                dto.setEditDate(rs.getString("editdate"));
                dto.setViewCount(rs.getInt("viewcount"));
                dto.setLikeCount(rs.getInt("likecount"));
                dto.setDislikeCount(rs.getInt("dislikecount"));
                dto.setReportCount(rs.getInt("reportcount"));
                dto.setSecretCheck(rs.getInt("secretcheck"));
                dto.setBlindCheck(rs.getInt("blindcheck"));
                dto.setAd_nickName(rs.getString("ad_nickname"));
                dto.setMe_nickName(rs.getString("me_nickname"));
                dto.setId(rs.getString("id"));

                dto.setSeqPost(rs.getString("seqpost"));
                dto.setFileName(rs.getString("filename"));
                dto.setFileLink(rs.getString("filelink"));
            }

            String searchnic;

            if (dto.getMe_nickName() == null) {
                searchnic = dto.getAd_nickName();
            } else {
                searchnic = dto.getMe_nickName();
            }

            sql = "select FILELINK as profileImg from TBLPROFILEIMG where seq = (select SEQPROFILEIMG from tblmember where nickname = ?)";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, searchnic);

            rs = pstat.executeQuery();

            if (rs.next()) {
                dto.setProfileImg(rs.getString("profileImg"));
            }

            return dto;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 게시글 목록을 가져오는 메서드입니다.
     * @param map 검색 조건을 담은 HashMap 객체입니다.
     * @param seq 게시판의 시퀀스 번호입니다.
     * @return 게시글 목록을 담은 ArrayList를 반환합니다.
     */
    public ArrayList<PostDTO> list(HashMap<String, String> map, String seq) {
        try {
            String where = "";

            if (map.get("search").equals("y") && map.get("column").equals("total")) {
                where = String.format("WHERE ca_seq = %s AND po_content LIKE '%%%s%%' or po_title like '%%%s%%'", seq, map.get("word"), map.get("word"));
            } else if (map.get("search").equals("y") && map.get("column").equals("title")) {
                where = String.format("WHERE ca_seq = %s AND po_title like '%%%s%%'", seq, map.get("word"));
            } else if (map.get("search").equals("y") && map.get("column").equals("content")) {
                where = String.format("WHERE ca_seq = %s AND po_content LIKE '%%%s%%'", seq, map.get("word"));
            } else {
                where = String.format("where ca_seq = %s", seq);
            }

            String sql = "select * from\r\n"
                    + "(SELECT\r\n"
                    + "    po_seq AS seq,\r\n"
                    + "    me_nickname AS me_nickname,\r\n"
                    + "    me_id AS id,\r\n"
                    + "    ad_nickname AS ad_nickname,\r\n"
                    + "    ca_seq AS seqboard,\r\n"
                    + "    po_seqUser AS seqUser,\r\n"
                    + "    po_title AS title,\r\n"
                    + "    po_content AS content,\r\n"
                    + "    po_writedate AS writedate,\r\n"
                    + "    po_editdate AS editdate,\r\n"
                    + "    po_viewcount AS viewcount,\r\n"
                    + "    po_likecount AS likecount,\r\n"
                    + "    po_dislikecount AS dislikecount,\r\n"
                    + "    po_reportcount AS reportcount,\r\n"
                    + "    po_secretcheck AS secretcheck,\r\n"
                    + "    po_blindcheck AS blindcheck,\r\n"
                    + "    us_seq AS seqpost,\r\n"
                    + "    img_filename AS filename,\r\n"
                    + "    img_filelink AS filelink,\r\n"
                    + "    ROW_NUMBER() OVER (ORDER BY po_writedate DESC) AS rnum\r\n"
                    + "FROM vwboard2\r\n"
                    + where + ")"
                    + "where rnum between ? and ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, map.get("begin"));
            pstat.setString(2, map.get("end"));

            rs = pstat.executeQuery();

            ArrayList<PostDTO> list = new ArrayList<PostDTO>();

            // 오늘 날짜 (2024-05-09)
            String today = LocalDate.now().toString();

            while (rs.next()) {
                PostDTO dto = new PostDTO();

                dto.setSeq(rs.getString("seq"));
                dto.setSeqBoard(rs.getString("seqboard"));
                dto.setSeqUser(rs.getString("seqUser"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));

                if ((rs.getString("writedate").substring(0, 10)).equals(today)) {
                    dto.setWriteDate(rs.getString("writedate").substring(11, 16));
                } else {
                    dto.setWriteDate(rs.getString("writedate").substring(0, 10));
                }

                dto.setEditDate(rs.getString("editdate"));
                dto.setViewCount(rs.getInt("viewcount"));
                dto.setLikeCount(rs.getInt("likecount"));
                dto.setDislikeCount(rs.getInt("dislikecount"));
                dto.setReportCount(rs.getInt("reportcount"));
                dto.setSecretCheck(rs.getInt("secretcheck"));
                dto.setBlindCheck(rs.getInt("blindcheck"));
                dto.setAd_nickName(rs.getString("ad_nickname"));
                dto.setMe_nickName(rs.getString("me_nickname"));
                dto.setId(rs.getString("id"));
                dto.setSeqUser(rs.getString("seqUser"));
                dto.setSecretCheck(rs.getInt("secretcheck"));

                dto.setSeqPost(rs.getString("seqpost"));
                dto.setFileName(rs.getString("filename"));
                dto.setFileLink(rs.getString("filelink"));

                list.add(dto);
            }

            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 게시글 목록을 가져오는 메서드입니다.
     * @param seq 게시판의 시퀀스 번호입니다.
     * @return 게시글 목록을 담은 ArrayList를 반환합니다.
     */
    public ArrayList<PostDTO> list(String seq) {
        try {
            String sql = "select\r\n"
                    + "    po_seq as seq,\r\n"
                    + "    me_nickname as me_nickname,\r\n"
                    + "    ad_nickname as ad_nickname,\r\n"
                    + "    ca_seq as seqboard,\r\n"
                    + "    po_seqUser as seqUser,\r\n"
                    + "    po_title as title,\r\n"
                    + "    po_content as content,\r\n"
                    + "    po_writedate as writedate,\r\n"
                    + "    po_editdate as editdate,\r\n"
                    + "    po_viewcount as viewcount,\r\n"
                    + "    po_likecount as likecount,\r\n"
                    + "    po_dislikecount as dislikecount,\r\n"
                    + "    po_reportcount as reportcount,\r\n"
                    + "    po_secretcheck as secretcheck,\r\n"
                    + "    po_blindcheck as blindcheck,\r\n"
                    + "    us_seq as seqpost,\r\n"
                    + "    img_filename as filename,\r\n"
                    + "    img_filelink as filelink\r\n"
                    + "from vwboard2 where ca_seq = ?\r\n"
                    + "order by po_writedate desc";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seq);

            rs = pstat.executeQuery();

            ArrayList<PostDTO> list = new ArrayList<PostDTO>();

            while (rs.next()) {
                PostDTO dto = new PostDTO();

                dto.setSeq(rs.getString("seq"));
                dto.setSeqBoard(rs.getString("seqboard"));
                dto.setSeqUser(rs.getString("sequser"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setWriteDate(rs.getString("writedate"));
                dto.setEditDate(rs.getString("editdate"));
                dto.setViewCount(rs.getInt("viewcount"));
                dto.setLikeCount(rs.getInt("likecount"));
                dto.setDislikeCount(rs.getInt("dislikecount"));
                dto.setReportCount(rs.getInt("reportcount"));
                dto.setSecretCheck(rs.getInt("secretcheck"));
                dto.setBlindCheck(rs.getInt("blindcheck"));
                dto.setAd_nickName(rs.getString("ad_nickname"));
                dto.setMe_nickName(rs.getString("me_nickname"));

                dto.setSeqPost(rs.getString("seqpost"));
                dto.setFileName(rs.getString("filename"));
                dto.setFileLink(rs.getString("filelink"));

                list.add(dto);
            }

            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 게시글을 작성하는 메서드입니다.
     * @param dto 게시글 정보를 담은 PostDTO 객체입니다.
     * @return 작성 결과를 반환합니다.
     */
    public int write(PostDTO dto) {
        try {
            String sql = "insert into tblPost values ((SELECT NVL(MAX(seq), 0) + 1 FROM tblPost), ?, ?, ?, ?, ?, null, 0, 0, 0, 0, ?, ?)";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, dto.getSeqBoard());
            pstat.setString(2, dto.getSeqUser());
            pstat.setString(3, dto.getTitle());
            pstat.setString(4, dto.getContent());
            pstat.setString(5, dto.getWriteDate());
            pstat.setInt(6, dto.getSecretCheck());
            pstat.setInt(7, dto.getBlindCheck());

            pstat.executeUpdate();

        } catch (Exception e) {
            System.out.println("BoardDAO.write");
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 게시글의 좋아요 수를 증가시키는 메서드입니다.
     * @param seq 게시글의 시퀀스 번호입니다.
     */
    public void like(String seq) {
        try {
            String sql = "update tblpost set likecount = likecount + 1 where seq = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seq);

            pstat.executeUpdate();

        } catch (Exception e) {
            System.out.println("BoardDAO.like");
            e.printStackTrace();
        }
    }

    /**
     * 게시글의 싫어요 수를 증가시키는 메서드입니다.
     * @param seq 게시글의 시퀀스 번호입니다.
     */
    public void dislike(String seq) {
        try {
            String sql = "update tblpost set dislikecount = dislikecount + 1 where seq = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seq);

            pstat.executeUpdate();

        } catch (Exception e) {
            System.out.println("BoardDAO.like");
            e.printStackTrace();
        }
    }

    /**
     * 조회수가 높은 게시글 목록을 가져오는 메서드입니다.
     * @param seq 게시판의 시퀀스 번호입니다.
     * @return 게시글 목록을 담은 ArrayList를 반환합니다.
     */
    public ArrayList<PostDTO> viewlist(String seq) {
        try {
            String sql = "select\r\n"
                    + "    po_seq as seq,\r\n"
                    + "    me_nickname as me_nickname,\r\n"
                    + "    ad_nickname as ad_nickname,\r\n"
                    + "    ca_seq as seqboard,\r\n"
                    + "    po_seqUser as seqUser,\r\n"
                    + "    po_title as title,\r\n"
                    + "    po_content as content,\r\n"
                    + "    po_writedate as writedate,\r\n"
                    + "    po_editdate as editdate,\r\n"
                    + "    po_viewcount as viewcount,\r\n"
                    + "    po_likecount as likecount,\r\n"
                    + "    po_dislikecount as dislikecount,\r\n"
                    + "    po_reportcount as reportcount,\r\n"
                    + "    po_secretcheck as secretcheck,\r\n"
                    + "    po_blindcheck as blindcheck,\r\n"
                    + "    us_seq as seqpost,\r\n"
                    + "    img_filename as filename,\r\n"
                    + "    img_filelink as filelink\r\n"
                    + "from vwboard2 where ca_seq = ?\r\n"
                    + "order by po_writedate desc";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seq);

            rs = pstat.executeQuery();

            ArrayList<PostDTO> list = new ArrayList<PostDTO>();

            while (rs.next()) {
                PostDTO dto = new PostDTO();

                dto.setSeq(rs.getString("seq"));
                dto.setSeqBoard(rs.getString("seqboard"));
                dto.setSeqUser(rs.getString("sequser"));

                if (rs.getString("title").length() > 28) {
                    dto.setTitle(rs.getString("title").substring(0, 28) + " ...");
                } else {
                    dto.setTitle(rs.getString("title"));
                }

                dto.setContent(rs.getString("content"));
                dto.setWriteDate(rs.getString("writedate"));
                dto.setEditDate(rs.getString("editdate"));
                dto.setViewCount(rs.getInt("viewcount"));
                dto.setLikeCount(rs.getInt("likecount"));
                dto.setDislikeCount(rs.getInt("dislikecount"));
                dto.setReportCount(rs.getInt("reportcount"));
                dto.setSecretCheck(rs.getInt("secretcheck"));
                dto.setBlindCheck(rs.getInt("blindcheck"));
                dto.setAd_nickName(rs.getString("ad_nickname"));
                dto.setMe_nickName(rs.getString("me_nickname"));

                dto.setSeqPost(rs.getString("seqpost"));
                dto.setFileName(rs.getString("filename"));
                dto.setFileLink(rs.getString("filelink"));

                list.add(dto);
            }

            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 게시글을 수정하는 메서드입니다.
     * @param post 수정할 게시글 정보를 담은 PostDTO 객체입니다.
     * @return 수정 결과를 반환합니다.
     */
    public int updatePost(PostDTO post) {
        try {
            String sql = "UPDATE tblPost SET title = ?, content = ?, editDate = SYSDATE WHERE seq = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, post.getTitle());
            pstat.setString(2, post.getContent());
            pstat.setString(3, post.getSeq());

            return pstat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * 게시글을 삭제하는 메서드입니다.
     * @param seq 삭제할 게시글의 시퀀스 번호입니다.
     * @return 삭제 결과를 반환합니다.
     */
    public int deletePost(String seq) {
        try {
            System.out.println("del start?");
            System.out.println(seq);
            String sql = "DELETE FROM tblReplyComments WHERE SEQCOMMENTS IN (SELECT seq FROM tblComments WHERE seqPost = ?)";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seq);
            int indicate1 = pstat.executeUpdate();
            System.out.println(indicate1);

            sql = "Delete from tblcomments where seqPost = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seq);

            int indicate2 = pstat.executeUpdate();

            sql = "Delete from tblAttachedFile where seqPost = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seq);

            int indicate3 = pstat.executeUpdate();

            sql = "DELETE FROM tblPost WHERE seq = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seq);

            int indicate4 = pstat.executeUpdate();
            System.out.println("del fin");
            System.out.println("indicate 1:" + indicate1 + " indicate 2: " + indicate2 + " indicate 3: " + indicate3 + " indicate 4: " + indicate4);

            return indicate4;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 게시글의 신고 횟수를 증가시키는 메서드입니다.
     * @param seq 신고할 게시글의 시퀀스 번호입니다.
     */
    public void report(String seq) {
        try {
            String sql = "update tblpost set reportcount = reportcount + 1 where seq = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seq);

            pstat.executeUpdate();

        } catch (Exception e) {
            System.out.println("BoardDAO.report");
            e.printStackTrace();
        }
    }

    /**
     * 게시글의 조회수를 증가시키는 메서드입니다.
     * @param seq 조회할 게시글의 시퀀스 번호입니다.
     */
    public void updateReadcount(String seq) {
        try {
            String sql = "update tblpost set viewcount = viewcount + 1 where seq = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seq);

            pstat.executeUpdate();

        } catch (Exception e) {
            System.out.println("BoardDAO.updateReadcount");
            e.printStackTrace();
        }
    }

    /**
     * 게시글의 총 개수를 가져오는 메서드입니다.
     * @param map 검색 조건을 담은 HashMap 객체입니다.
     * @param seq 게시판의 시퀀스 번호입니다.
     * @return 게시글의 총 개수를 반환합니다.
     */
    public int getTotalCount(HashMap<String, String> map, String seq) {
        try {
            String where = "";
            if (map.get("search").equals("y") && map.get("column").equals("total")) {
                where = String.format("WHERE content LIKE '%%%s%%' or title like '%%%s%%'", map.get("word"), map.get("word"));
            } else if (map.get("search").equals("y") && map.get("column").equals("title")) {
                where = String.format("WHERE title like '%%%s%%'", map.get("word"));
            } else if (map.get("search").equals("y") && map.get("column").equals("content")) {
                where = String.format("WHERE content LIKE '%%%s%%'", map.get("word"));
            }

            String sql = "select count(*) as cnt from (select\r\n"
                    + "po_seq as seq,\r\n"
                    + "me_nickname as me_nickname,\r\n"
                    + "ad_nickname as ad_nickname,\r\n"
                    + "ca_seq as seqboard,\r\n"
                    + "po_seqUser as seqUser,\r\n"
                    + "po_title as title,\r\n"
                    + "po_content as content,\r\n"
                    + "po_writedate as writedate,\r\n"
                    + "po_editdate as editdate,\r\n"
                    + "po_viewcount as viewcount,\r\n"
                    + "po_likecount as likecount,\r\n"
                    + "po_dislikecount as dislikecount,\r\n"
                    + "po_reportcount as reportcount,\r\n"
                    + "po_secretcheck as secretcheck,\r\n"
                    + "po_blindcheck as blindcheck,\r\n"
                    + "us_seq as seqpost,\r\n"
                    + "img_filename as filename,\r\n"
                    + "img_filelink as filelink\r\n"
                    + "from vwboard2\r\n"
                    + "WHERE ca_seq =  ?) "
                    + where;

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seq);

            rs = pstat.executeQuery();

            if (rs.next()) {
                return rs.getInt("cnt");
            }

        } catch (Exception e) {
            System.out.println("BoardDAO.getTotalCount");
            e.printStackTrace();
        }

        return 0;
    }

}// BoardDAO