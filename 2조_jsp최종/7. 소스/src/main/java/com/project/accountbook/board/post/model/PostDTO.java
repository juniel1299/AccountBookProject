package com.project.accountbook.board.post.model;

import lombok.Data;

/**
 * 게시글과 첨부파일 정보를 담는 DTO 클래스입니다.
 */
@Data
public class PostDTO {

    /**
     * 게시글의 고유 번호입니다.
     */
    private String seq;

    /**
     * 게시글이 속한 게시판의 고유 번호입니다.
     */
    private String seqBoard;

    /**
     * 게시글 작성자의 고유 번호입니다.
     */
    private String seqUser;

    /**
     * 게시글 작성자의 프로필 이미지 링크입니다.
     */
    private String profileImg;

    /**
     * 게시글의 제목입니다.
     */
    private String title;

    /**
     * 게시글의 내용입니다.
     */
    private String content;

    /**
     * 게시글의 작성일입니다.
     */
    private String writeDate;

    /**
     * 게시글의 수정일입니다.
     */
    private String editDate;

    /**
     * 게시글의 조회수입니다.
     */
    private int viewCount;

    /**
     * 게시글의 좋아요 수입니다.
     */
    private int likeCount;

    /**
     * 게시글의 싫어요 수입니다.
     */
    private int dislikeCount;

    /**
     * 게시글의 신고 횟수입니다.
     */
    private int reportCount;

    /**
     * 게시글의 비밀글 여부입니다. (0: 공개, 1: 비밀글)
     */
    private int secretCheck;

    /**
     * 게시글의 블라인드 처리 여부입니다. (0: 정상, 1: 블라인드)
     */
    private int blindCheck;

    /**
     * 게시글의 카테고리 번호입니다.
     */
    private String seqCategory;

    /**
     * 게시글 작성자의 아이디입니다.
     */
    private String id;

    /**
     * 첨부파일이 속한 게시글의 고유 번호입니다.
     */
    private String seqPost;

    /**
     * 첨부파일의 이름입니다.
     */
    private String fileName;

    /**
     * 첨부파일의 링크입니다.
     */
    private String fileLink;

    /**
     * 회원의 닉네임입니다.
     */
    private String me_nickName;

    /**
     * 관리자의 닉네임입니다.
     */
    private String ad_nickName;
}