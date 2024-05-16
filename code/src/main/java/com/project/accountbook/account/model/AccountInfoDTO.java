package com.project.accountbook.account.model;

import lombok.Data;

/**
 * AccountInfoDTO 클래스는 가계부 내용, 가계부, 구매 위시 목록, 고정 입출금 여부, 고정 입출금 기간,
 * 가계부 카테고리 목록, 가계부 카테고리, 뉴스, 변동 사유 카테고리, 카드 정보, 나의 카드 관련 정보를 담고 있습니다.
 */
@Data
public class AccountInfoDTO {

    //가계부 내용
    /**
     * 가계부 내용입니다.
     */
    private String content;
    
    /**
     * 가계부 날짜입니다.
     */
    private String accInfoDate;
    
    /**
     * 가격입니다.
     */
    private long price;
    
    /**
     * 위치입니다.
     */
    private String location;
    
    /**
     * 가계부 순서입니다.
     */
    private String seqAcc;
    
    /**
     * 카테고리 변경 사유 순서입니다.
     */
    private String seqReasonChangeCategory;
    
    /**
     * 고정 입출금 여부 순서입니다.
     */
    private String seqFixedFluctuationCheck;
    
    /**
     * 입출금 상태 순서입니다.
     */
    private String seqDepositWithdrawalStatus;
    
    /**
     * 입출금 상태입니다.
     */
    private String DepositWithdrawalStatus;
    
    /**
     * 가계부 카테고리 목록 순서입니다.
     */
    private String seqAccCategoryList;
    
    /**
     * 이전 가계부 사용량입니다.
     */
    private int beforeAcUsage;
    
    /**
     * 현재 가계부 사용량입니다.
     */
    private int nowAcUsage;
    
    /**
     * 총 가격입니다.
     */
    private long totalPrice;
    
    /**
     * 총 저축액입니다.
     */
    private long totalSaving;

    //가계부
    /**
     * 회원 아이디입니다.
     */
    private String idMember;

    //구매 위시 목록
    /**
     * 제품 이름입니다.
     */
    private String productName;

    //seqAcc 위에 존재

    //고정 입출금 여부
    /**
     * 고정 입출금 내용입니다.
     */
    private String fdwContent;
    
    /**
     * 고정 입출금 기간 순서입니다.
     */
    private String seqFixedFluctuationPeriod;

    //고정 입출금 기간
    /**
     * 고정 입출금 기간입니다.
     */
    private int ffpPeriod;

    //가계부 카테고리 목록
    /**
     * 가계부 카테고리 순서입니다.
     */
    private String seqAccCategory;
    
    /**
     * 가계부 정보 순서입니다.
     */
    private String seqAccInfo;

    //가계부 카테고리
    /**
     * 가계부 카테고리 이름입니다.
     */
    private String acName;

    //뉴스
    /**
     * 뉴스 제목입니다.
     */
    private String title;
    
    /**
     * 뉴스 링크입니다.
     */
    private String link;
    
    /**
     * 뉴스 발행일입니다.
     */
    private String pubDate;
    
    /**
     * 뉴스 설명입니다.
     */
    private String description;

    //변동 사유 카테고리
    /**
     * 변동 사유 목록 순서입니다.
     */
    private String seqReasonsChangeList;
    
    /**
     * 나의 카드 순서입니다.
     */
    private String seqMyCard;

    //카드 정보
    /**
     * 카드 회사 이름입니다.
     */
    private String cfName;
    
    /**
     * 카드 이미지 링크입니다.
     */
    private String fileLink;

    //나의 카드
    /**
     * 카드 별칭입니다.
     */
    private String alias;
    
    /**
     * 결제 방식입니다.
     */
    private String paymentMethod;
    
    /**
     * 카드 번호입니다.
     */
    private String cardNumber;

}