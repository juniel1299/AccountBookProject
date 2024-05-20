package com.project.accountbook.board.post.model;

/**
 * 신고 게시판의 게시물 정보를 담는 DTO 클래스입니다.
 */
public class ReportDTO {

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

    /**
     * 게시물의 고유 번호를 반환합니다.
     *
     * @return 게시물의 고유 번호입니다.
     */
    public int getSeq() {
        return seq;
    }

    /**
     * 게시물의 고유 번호를 설정합니다.
     *
     * @param seq 게시물의 고유 번호입니다.
     */
    public void setSeq(int seq) {
        this.seq = seq;
    }

    /**
     * 게시물 작성자의 닉네임을 반환합니다.
     *
     * @return 게시물 작성자의 닉네임입니다.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 게시물 작성자의 닉네임을 설정합니다.
     *
     * @param nickname 게시물 작성자의 닉네임입니다.
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 게시물의 제목을 반환합니다.
     *
     * @return 게시물의 제목입니다.
     */
    public String getTitle() {
        return title;
    }

    /**
     * 게시물의 제목을 설정합니다.
     *
     * @param title 게시물의 제목입니다.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 게시물의 작성 날짜를 반환합니다.
     *
     * @return 게시물의 작성 날짜입니다.
     */
    public String getDate() {
        return date;
    }

    /**
     * 게시물의 작성 날짜를 설정합니다.
     *
     * @param date 게시물의 작성 날짜입니다.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 게시물의 조회수를 반환합니다.
     *
     * @return 게시물의 조회수입니다.
     */
    public int getViewCount() {
        return viewCount;
    }

    /**
     * 게시물의 조회수를 설정합니다.
     *
     * @param viewCount 게시물의 조회수입니다.
     */
    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * 게시물의 좋아요 수를 반환합니다.
     *
     * @return 게시물의 좋아요 수입니다.
     */
    public int getLikeCount() {
        return likeCount;
    }

    /**
     * 게시물의 좋아요 수를 설정합니다.
     *
     * @param likeCount 게시물의 좋아요 수입니다.
     */
    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * 게시물의 신고 횟수를 반환합니다.
     *
     * @return 게시물의 신고 횟수입니다.
     */
    public String getReportCount() {
        return reportCount;
    }

    /**
     * 게시물의 신고 횟수를 설정합니다.
     *
     * @param reportCount 게시물의 신고 횟수입니다.
     */
    public void setReportCount(String reportCount) {
        this.reportCount = reportCount;
    }

    /**
     * 게시물의 비밀글 여부를 반환합니다.
     *
     * @return 게시물의 비밀글 여부입니다.
     */
    public String getSecretCheck() {
        return secretCheck;
    }

    /**
     * 게시물의 비밀글 여부를 설정합니다.
     *
     * @param secretCheck 게시물의 비밀글 여부입니다.
     */
    public void setSecretCheck(String secretCheck) {
        this.secretCheck = secretCheck;
    }

    /**
     * 게시물의 블라인드 처리 여부를 반환합니다.
     *
     * @return 게시물의 블라인드 처리 여부입니다.
     */
    public String getBlindCheck() {
        return blindCheck;
    }

    /**
     * 게시물의 블라인드 처리 여부를 설정합니다.
     *
     * @param blindCheck 게시물의 블라인드 처리 여부입니다.
     */
    public void setBlindCheck(String blindCheck) {
        this.blindCheck = blindCheck;
    }

    /**
     * 게시물의 정보를 문자열로 반환합니다.
     *
     * @return 게시물의 정보를 담은 문자열입니다.
     */
    @Override
    public String toString() {
        return "ReportDTO [seq=" + seq + ", nickname=" + nickname + ", title=" + title + ", date=" + date
                + ", viewCount=" + viewCount + ", likeCount=" + likeCount + ", reportCount=" + reportCount
                + ", secretCheck=" + secretCheck + ", blindCheck=" + blindCheck + "]";
    }
}