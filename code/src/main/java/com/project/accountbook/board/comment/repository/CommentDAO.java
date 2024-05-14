package com.project.accountbook.board.comment.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.accountbook.board.comment.model.CommentDTO;
import com.project.accountbook.util.DBUtil;

/**
 * 댓글과 관련된 데이터베이스 작업을 수행하는 DAO 클래스입니다.
 */
public class CommentDAO {
    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    /**
     * CommentDAO 생성자입니다.
     * 데이터베이스 연결을 설정합니다.
     */
    public CommentDAO() {
        this.conn = DBUtil.open("125.241.245.222", "webproject", "java1234");
    }

    /**
     * 댓글의 싫어요 수를 증가시키는 메서드입니다.
     *
     * @param commentSeq 댓글 번호입니다.
     * @return 업데이트된 행의 수를 반환합니다.
     */
    public int updateCommentDislike(String commentSeq) {
        try {
            String sql = "UPDATE tblComments SET dislikeCount = dislikeCount + 1 WHERE seq = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, commentSeq);
            return pstat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 댓글의 좋아요 수를 증가시키는 메서드입니다.
     *
     * @param commentSeq 댓글 번호입니다.
     * @return 업데이트된 행의 수를 반환합니다.
     */
    public int updateCommentLike(String commentSeq) {
        try {
            String sql = "UPDATE tblComments SET likeCount = likeCount + 1 WHERE seq = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, commentSeq);
            return pstat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 게시글 번호로 댓글 목록을 조회하는 메서드입니다.
     *
     * @param postSeq 게시글 번호입니다.
     * @return 댓글 목록을 반환합니다.
     */
    public List<CommentDTO> getCommentsByPostSeq(String postSeq) {
        List<CommentDTO> comments = new ArrayList<>();
        try {
            String sql = "SELECT c.seq, c.seqPost, c.seqUser, c.content, c.writeDate, c.likeCount, c.dislikeCount, c.reportCount, m.nickname, p.fileLink AS profileImage, u.idMember " +
                    "FROM tblComments c " +
                    "INNER JOIN tblUser u ON c.seqUser = u.seq " +
                    "INNER JOIN tblMember m ON u.idMember = m.id " +
                    "LEFT JOIN tblProfileimg p ON m.seqProfileimg = p.seq " +
                    "WHERE c.seqPost = ? " +
                    "ORDER BY c.seq";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, postSeq);
            rs = pstat.executeQuery();

            while (rs.next()) {
                CommentDTO dto = new CommentDTO();
                dto.setIdMember(rs.getString("idMember"));
                dto.setSeq(rs.getString("seq"));
                dto.setSeqPost(rs.getInt("seqPost"));
                dto.setSeqUser(rs.getInt("seqUser"));
                dto.setContent(rs.getString("content"));
                dto.setWriteDate(rs.getString("writeDate"));
                dto.setLikeCount(rs.getInt("likeCount"));
                dto.setDislikeCount(rs.getInt("dislikeCount"));
                dto.setReportCount(rs.getInt("reportCount"));
                dto.setNickname(rs.getString("nickname"));
                dto.setProfileImage(rs.getString("profileImage"));
                comments.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }

    /**
     * 댓글을 추가하는 메서드입니다.
     *
     * @param commentDto 댓글 정보를 담은 DTO 객체입니다.
     * @return 추가된 행의 수를 반환합니다.
     */
    public int addComment(CommentDTO commentDto) {
        try {
            String sql = "INSERT INTO tblComments (seq, seqPost, seqUser, content, writeDate, likeCount, dislikeCount, reportCount) " +
                         "VALUES ((SELECT NVL(MAX(seq), 0) + 1 FROM tblcomments), ?, ?, ?, SYSDATE, 0, 0, 0)";
            pstat = conn.prepareStatement(sql);
            pstat.setInt(1, commentDto.getSeqPost());
            pstat.setInt(2, commentDto.getSeqUser());
            pstat.setString(3, commentDto.getContent());
            
            return pstat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 댓글 번호로 답글 목록을 조회하는 메서드입니다.
     *
     * @param commentSeq 댓글 번호입니다.
     * @return 답글 목록을 반환합니다.
     */
    public List<CommentDTO> getReplyCommentsByCommentSeq(String commentSeq) {
        List<CommentDTO> replyComments = new ArrayList<>();
        try {
            String sql = "SELECT trc.*, tm.nickname, tp.fileLink AS profileImage " +
                         "FROM tblReplyComments trc " +
                         "JOIN tblUser tu ON trc.seqUser = tu.seq " +
                         "JOIN tblMember tm ON tu.idMember = tm.id " +
                         "LEFT JOIN tblProfileimg tp ON tm.seqProfileimg = tp.seq " +
                         "WHERE trc.seqComments = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, commentSeq);
            rs = pstat.executeQuery();

            while (rs.next()) {
                CommentDTO replyComment = new CommentDTO();
                replyComment.setSeq(rs.getString("seq"));
                replyComment.setSeqComments(rs.getInt("seqComments"));
                replyComment.setSeqUser(rs.getInt("seqUser"));
                replyComment.setContent(rs.getString("content"));
                replyComment.setWriteDate(rs.getString("writeDate"));
                replyComment.setLikeCount(rs.getInt("likeCount"));
                replyComment.setDislikeCount(rs.getInt("dislikeCount"));
                replyComment.setReportCount(rs.getInt("reportCount"));
                replyComment.setNickname(rs.getString("nickname"));
                replyComment.setProfileImage(rs.getString("profileImage"));
                replyComments.add(replyComment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return replyComments;
    }

    /**
     * 답글을 추가하는 메서드입니다.
     *
     * @param replyComment 답글 정보를 담은 DTO 객체입니다.
     * @return 추가된 행의 수를 반환합니다.
     */
    public int addReplyComment(CommentDTO replyComment) {
        try {
            String sql = "INSERT INTO tblReplyComments (seq, seqComments, seqUser, content, writeDate, likeCount, dislikeCount, reportCount) " +
                         "VALUES (seqReplyComments.nextval, ?, ?, ?, SYSDATE, 0, 0, 0)";

            pstat = conn.prepareStatement(sql);
            pstat.setInt(1, replyComment.getSeqComments());
            pstat.setInt(2, replyComment.getSeqUser());
            pstat.setString(3, replyComment.getContent());

            return pstat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 댓글을 수정하는 메서드입니다.
     *
     * @param commentSeq    수정할 댓글 번호입니다.
     * @param editedContent 수정된 댓글 내용입니다.
     * @return 수정된 행의 수를 반환합니다.
     */
    public int updateComment(String commentSeq, String editedContent) {
        try {
            String sql = "UPDATE tblComments SET content = ? WHERE seq = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, editedContent);
            pstat.setString(2, commentSeq);
            return pstat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 댓글을 삭제하는 메서드입니다.
     *
     * @param commentSeq 삭제할 댓글 번호입니다.
     * @return 삭제된 행의 수를 반환합니다.
     */
    public int deleteComment(String commentSeq) {
        try {
            String sql = "DELETE FROM tblComments WHERE seq = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, commentSeq);
            return pstat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 답글을 수정하는 메서드입니다.
     *
     * @param replyCommentSeq 수정할 답글 번호입니다.
     * @param editedContent   수정된 답글 내용입니다.
     * @return 수정된 행의 수를 반환합니다.
     */
    public int updateReplyComment(String replyCommentSeq, String editedContent) {
        try {
            String sql = "UPDATE tblReplyComments SET content = ? WHERE seq = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, editedContent);
            pstat.setString(2, replyCommentSeq);
            return pstat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 답글 작성자를 확인하는 메서드입니다.
     *
     * @param replyCommentSeq 확인할 답글 번호입니다.
     * @param seqUser         사용자 번호입니다.
     * @return 작성자 여부를 반환합니다.
     */
    public boolean isReplyCommentAuthor(String replyCommentSeq, int seqUser) {
        try {
            String sql = "SELECT COUNT(*) FROM tblReplyComments WHERE seq = ? AND seqUser = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, replyCommentSeq);
            pstat.setInt(2, seqUser);
            rs = pstat.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 답글을 삭제하는 메서드입니다.
     *
     * @param replyCommentSeq 삭제할 답글 번호입니다.
     * @return 삭제된 행의 수를 반환합니다.
     */
    public int deleteReplyComment(String replyCommentSeq) {
        try {
            String sql = "DELETE FROM tblReplyComments WHERE seq = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, replyCommentSeq);
            return pstat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}