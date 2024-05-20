package com.project.accountbook.board.post.model;

import lombok.Data;

/**
 * 공지사항 게시판의 게시물 정보를 담는 DTO 클래스입니다.
 */
@Data
public class NoticeDTO {

    /**
     * 게시물의 고유 번호입니다.
     */
    private int seq;

    /**
     * 게시물 작성자의 닉네임입니다.
     */
    private String nickname;

    /**
     * 게시물의 제목입니다.
     */
    private String title;

    /**
     * 게시물의 작성 날짜입니다.
     */
    private String date;

    /**
     * 게시물의 조회수입니다.
     */
    private int viewCount;

    /**
     * 게시물의 좋아요 수입니다.
     */
    private int likeCount;

    /**
     * 게시물의 신고 횟수입니다.
     */
    private String reportCount;

    /**
     * 게시물의 비밀글 여부입니다.
     */
    private String secretCheck;

    /**
     * 게시물의 블라인드 처리 여부입니다.
     */
    private String blindCheck;
}