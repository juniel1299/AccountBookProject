package com.project.accountbook.user.model;

import lombok.Data;

/**
 * UserDTO 클래스는 회원, 관리자, 사용자 테이블, 프로필 이미지 및 권한 관련 정보를 담고 있습니다.
 */
@Data
public class UserDTO {

    //회원, 관리자
    /**
     * 아이디입니다.
     */
    private String id;
    
    /**
     * 비밀번호입니다.
     */
    private String pw;
    
    /**
     * 이름입니다.
     */
    private String name;
    
    /**
     * 닉네임입니다.
     */
    private String nickname;
    
    /**
     * 전화번호입니다.
     */
    private String phoneNumber;
    
    /**
     * 주민등록번호입니다.
     */
    private String ssn;
    
    /**
     * 가입일자입니다.
     */
    private String joinDate;
    
    /**
     * 가입 후 경과한 개월 수입니다.
     */
    private int monthsSinceJoin;
    
    /**
     * 월급입니다.
     */
    private int monthlyPaycheck;
    
    /**
     * 저축 목표입니다.
     */
    private int savingsGoals;
    
    /**
     * 압축 강도 순서입니다.
     */
    private String seqCompressionIntensity;
    
    /**
     * 저축 기간 순서입니다.
     */
    private String seqSavingsPeriod;
    
    /**
     * 저축 기간입니다.
     */
    private int spPeriod;
    
    /**
     * 성별입니다.
     */
    private String gender;
    
    /**
     * 신고 횟수입니다.
     */
    private int reportCount;
    
    /**
     * 설문조사 순서입니다.
     */
    private String seqSurvey;
    
    /**
     * 프로필 이미지 순서입니다.
     */
    private String seqProfileimg;

    //사용자 테이블
    /**
     * 회원 아이디입니다.
     */
    private String idMember;

    //프로필 이미지
    /**
     * 파일 이름입니다.
     */
    private String fileName;
    
    /**
     * 파일 링크입니다.
     */
    private String fileLink;

    //권한
    /**
     * 권한 순서입니다.
     */
    private String seqPriv;

}