package com.project.accountbook.board.comment.model;

import java.util.List;

import lombok.Data;

/**
 * 댓글 정보를 담는 DTO 클래스입니다.
 * tblComments와 tblReplyComments 테이블의 정보를 포함합니다.
 */
@Data
public class CommentDTO {

    /**
     * 답글 수입니다.
     */
    private int replyCount;

    /**
     * 사용자의 닉네임입니다.
     */
    private String nickname;

    /**
     * 답글 목록입니다.
     */
    private List<CommentDTO> replyComments;

    /**
     * 사용자의 아이디입니다.
     */
    private String idMember;

    /**
     * 사용자의 프로필 이미지 경로입니다.
     */
    private String profileImage;

    /**
     * 댓글이 속한 게시글의 번호입니다.
     */
    private int seqPost;

    /**
     * 댓글 작성자의 번호입니다.
     */
    private int seqUser;

    /**
     * 댓글 내용입니다.
     */
    private String content;

    /**
     * 댓글 작성 날짜입니다.
     */
    private String writeDate;

    /**
     * 댓글의 좋아요 수입니다.
     */
    private int likeCount;

    /**
     * 댓글의 싫어요 수입니다.
     */
    private int dislikeCount;

    /**
     * 댓글의 신고 수입니다.
     */
    private int reportCount;

    /**
     * 답글이 속한 댓글의 번호입니다.
     */
    private int seqComments;

    /**
     * 댓글 또는 답글의 고유 번호입니다.
     */
    private String seq;
}