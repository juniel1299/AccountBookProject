package com.project.accountbook.user.member.model;

import lombok.Data;

/**
* 회원 정보와 관련된 데이터를 담는 DTO 클래스입니다.
* tblMemberFinance와 tblSurvey 테이블의 정보를 포함합니다.
*/
@Data
public class MemberInfoDTO {

   /**
    * 회원 금융 정보 - 회원 ID입니다.
    */
   private String mfIdMember;

   /**
    * 회원 금융 정보 - 재산 일련번호입니다.
    */
   private String seqProperty;

   /**
    * 회원 금융 정보 - 빚 일련번호입니다.
    */
   private String seqDebt;

   /**
    * 챌린지 - 월급입니다.
    */
   private int monthlyPaycheck;

   /**
    * 챌린지 - 저축 목표입니다.
    */
   private int savingsGoals;

   /**
    * 챌린지 - 저축 기간입니다.
    */
   private int savingPeriod;

   /**
    * 챌린지 - 압축 강도 일련번호입니다.
    */
   private String seqCompressionIntensity;

   /**
    * 챌린지 - 저축 기간 일련번호입니다.
    */
   private String seqSavingsPeriod;

   /**
    * 나의 카드 - 카드 번호입니다.
    */
   private String cardNumber;

   /**
    * 나의 카드 - 카드 별칭입니다.
    */
   private String alias;

   /**
    * 나의 카드 - 카드 유효기간입니다.
    */
   private String validity;

   /**
    * 나의 카드 - 회원 ID입니다.
    */
   private String mcIdMember;

   /**
    * 나의 카드 - 카드 정보 일련번호입니다.
    */
   private String seqCardInformation;

   /**
    * 나의 카드 - 일련번호입니다.
    */
   private String seq;

   /**
    * 카드 정보 - 카드 이름입니다.
    */
   private String Name;

   /**
    * 카드 정보 - 카드 설명입니다.
    */
   private String explanation;

   /**
    * 카드 정보 - 연회비입니다.
    */
   private int annualFee;

   /**
    * 카드 정보 - 해외 사용 가능 여부입니다.
    */
   private String overseasUse;

   /**
    * 카드 정보 - 카드사입니다.
    */
   private String cardCompany;

   /**
    * 카드 정보 - 카드 이미지 파일 링크입니다.
    */
   private String fileLink;

   /**
    * 카드 정보 - 카드 타입 일련번호입니다.
    */
   private int seqCardType;

   /**
    * 카드 혜택 목록 - 카드 변경 사유 목록 일련번호입니다.
    */
   private int seqReasonsChangeList;

   /**
    * 카드 혜택 목록 - 나의 카드 일련번호입니다.
    */
   private int seqMyCard;
}