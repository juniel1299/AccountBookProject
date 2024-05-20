package com.project.accountbook.card.model;

import lombok.Data;

/**
 * 카드 정보와 관련된 데이터를 담는 DTO 클래스입니다.
 */
@Data
public class CardDTO {

    /**
     * 카드 이름입니다.
     */
    private String ciName;

    /**
     * 카드 설명입니다.
     */
    private String explanation;

    /**
     * 연회비입니다.
     */
    private int annualFee;

    /**
     * 해외 사용 가능 여부입니다.
     */
    private String overseasUse;

    /**
     * 카드사입니다.
     */
    private String cardCompany;

    /**
     * 파일 링크입니다.
     */
    private String fileLink;

    /**
     * 카드 타입 일련번호입니다.
     */
    private int seqCardType;

    /**
     * 카드 혜택 카테고리 일련번호입니다.
     */
    private int lcbseqCardCategory;

    /**
     * 카드 정보 일련번호입니다.
     */
    private int seqCardInformation;

    /**
     * 카드 혜택 카테고리 이름입니다.
     */
    private String ccName;

    /**
     * 카드/가계부 카테고리 연결 - 카드 카테고리 일련번호입니다.
     */
    private int caaSeqCardCategory;

    /**
     * 카드/가계부 카테고리 연결 - 가계부 카테고리 일련번호입니다.
     */
    private int seqAccCategory;

    /**
     * 할인율입니다.
     */
    private int discountRate;

    /**
     * 일련번호입니다.
     */
    private int seq;

    /**
     * 이름입니다.
     */
    private String name;

    /**
     * 카드 번호입니다.
     */
    private String cardNumber;

    /**
     * 카드 별칭입니다.
     */
    private String alias;

    /**
     * 카드 만료일입니다.
     */
    private String enddate;

    /**
     * 카드 카테고리입니다.
     */
    private String category;
}