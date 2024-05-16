package com.project.accountbook.account.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.project.accountbook.account.model.AccountInfoDTO;
import com.project.accountbook.user.model.UserDTO;
import com.project.accountbook.user.repository.UserDAO;
import com.project.accountbook.util.DBUtil;

/**
* 가계부 관련 데이터베이스 작업을 수행하는 DAO 클래스입니다.
*/
public class AccountDAO {
   
   private Connection conn;
   private Statement stat;
   private PreparedStatement pstat;
   private ResultSet rs;
   
   /**
    * AccountDAO 생성자입니다.
    * 데이터베이스 연결을 설정합니다.
    */
   public AccountDAO() {
   	this.conn = DBUtil.open("125.241.245.222", "webproject", "java1234");
   }
   
   /**
    * 가계부를 추가하는 메서드입니다.
    * @param dto 추가할 가계부 정보를 담은 AccountInfoDTO 객체입니다.
    * @return 추가 결과를 반환합니다.
    */
   public int add(AccountInfoDTO dto) {
   	
   	try {
   		
   		String sql = "insert into ";

   		pstat = conn.prepareStatement(sql);
//			pstat.setString(1, dto.get);


   		return pstat.executeUpdate();
   		
   	} catch (Exception e) {
   		System.out.println("AccountDAO.add");
   		e.printStackTrace();
   	}
   	
   	return 0;
   }
   
   /**
    * 카테고리 자동 매칭을 수행하는 메서드입니다.
    * @param dto 카테고리 자동 매칭에 필요한 정보를 담은 AccountInfoDTO 객체입니다.
    * @return 카테고리 자동 매칭 결과를 반환합니다.
    */
   public int addCategory(AccountInfoDTO dto) {
   	
   	return 0;
   }
   
   /**
    * 가계부를 읽는 메서드입니다.
    * @param dto 읽을 가계부 정보를 담은 AccountInfoDTO 객체입니다.
    * @return 가계부 읽기 결과를 반환합니다.
    */
   public int get(AccountInfoDTO dto) {
   	
   	return 0;
   }
   	
   /**
    * 이번달 지출과 수입을 계산하는 메서드입니다.
    * @param dto 계산에 필요한 정보를 담은 AccountInfoDTO 객체입니다.
    * @return 지출과 수입 계산 결과를 반환합니다.
    */
   public int getExpenditureIncome(AccountInfoDTO dto) {
   	
   	return 0;
   }
   
   /**
    * 가계부 목록을 읽는 메서드입니다.
    * @param dto 목록 조회에 필요한 정보를 담은 AccountInfoDTO 객체입니다.
    * @return 가계부 목록 읽기 결과를 반환합니다.
    */
   public int list(AccountInfoDTO dto) {
   	
   	return 0;
   }
   
   /**
    * 가계부를 수정하는 메서드입니다.
    * @param dto 수정할 가계부 정보를 담은 AccountInfoDTO 객체입니다.
    * @return 수정 결과를 반환합니다.
    */
   public int update(AccountInfoDTO dto) {
   	
   	return 0;
   }
   
   /**
    * 가계부를 삭제하는 메서드입니다.
    * @param dto 삭제할 가계부 정보를 담은 AccountInfoDTO 객체입니다.
    * @return 삭제 결과를 반환합니다.
    */
   public int del(AccountInfoDTO dto) {
   	
   	return 0;
   }
   
   /**
    * 구매 위시 목록을 작성하는 메서드입니다.
    * @param dto 구매 위시 목록 정보를 담은 AccountInfoDTO 객체입니다.
    * @return 구매 위시 목록 작성 결과를 반환합니다.
    */
   public int addProduct(AccountInfoDTO dto) {
   	
   	return 0;
   }
   
   /**
    * 구매 위시 목록을 수정하는 메서드입니다.
    * @param dto 수정할 구매 위시 목록 정보를 담은 AccountInfoDTO 객체입니다.
    * @return 구매 위시 목록 수정 결과를 반환합니다.
    */
   public int updateProduct(AccountInfoDTO dto) {
   	
   	return 0;
   }
   
   /**
    * 구매 위시 목록을 삭제하는 메서드입니다.
    * @param dto 삭제할 구매 위시 목록 정보를 담은 AccountInfoDTO 객체입니다.
    * @return 구매 위시 목록 삭제 결과를 반환합니다.
    */
   public int delProduct(AccountInfoDTO dto) {
   	
   	return 0;
   }
   
   /**
    * 현재 기간의 카테고리별 지출 금액을 조회하는 메서드입니다.
    * @param id 회원 아이디입니다.
    * @param map 조회 조건을 담은 HashMap 객체입니다.
    * @return 카테고리별 지출 금액을 담은 ArrayList를 반환합니다.
    */
   public ArrayList<AccountInfoDTO> nowAnalysis(String id, HashMap<String, String> map) {
   	
   	try {
   		
   		String period = map.get("period");
   		
   		String sql = "select\r\n"
   				+ "    sum(price) totalPrice,\r\n"
   				+ "    ac.NAME acName\r\n"
   				+ "from tblaccinfo ai\r\n"
   				+ "    inner join TBLACCCATEGORYLIST acl on ai.SEQ = acl.SEQACCINFO\r\n"
   				+ "    inner join TBLACCCATEGORY ac on acl.SEQACCCATEGORY = ac.SEQ\r\n"
   				+ "    inner join TBLACC a on ai.SEQACC = a.SEQ\r\n"
   				+ "    inner join TBLMEMBER me on a.IDMEMBER = me.ID\r\n"
   				+ "    where IDMEMBER = ?";
   		
   		
   		if (period.equals("day")) {
   			sql +=    "and trunc(ai.accInfoDate) = trunc(sysdate) -- 오늘 날짜\r\n";
   			
   		} else if (period.equals("week")) {
   			sql +=  "and ai.accInfoDate >= trunc(sysdate, 'IW') -- 이번주 시작 날짜\r\n"
   					+ "    and ai.accInfoDate < trunc(sysdate) + 1 -- 이번주 종료 날짜\r\n";

   		} else if (period.equals("month")) {
   			sql +=    "                                        and ai.accInfoDate \r\n"
   					+ "                                            between to_date(sysdate, 'YY/MM/DD') \r\n"
   					+ "                                                - interval '1' month and to_date(sysdate, 'YY/MM/DD')\r\n";

   		}
   		
   		 sql += "and ai.SEQDEPOSITWITHDRAWALSTATUS = 2\r\n"
   		 		+ "    group by ac.NAME";
   		
   		pstat = conn.prepareStatement(sql);
   		pstat.setString(1, id);
   		
   		rs = pstat.executeQuery();
   		
   		ArrayList<AccountInfoDTO> list = new ArrayList<AccountInfoDTO>();
   		
   		while (rs.next()) {
   			
   			AccountInfoDTO dto = new AccountInfoDTO();
   			
   			dto.setTotalPrice(rs.getInt("totalPrice"));
   			dto.setAcName(rs.getString("acName"));
   			
   			list.add(dto);				
   		}	
   		
   		return list;
   		
   	} catch (Exception e) {
   		e.printStackTrace();
   	}
   	
   	return null;
   }
   
   /**
    * 이전 기간의 카테고리별 지출 금액을 조회하는 메서드입니다.
    * @param id 회원 아이디입니다.
    * @param map 조회 조건을 담은 HashMap 객체입니다.
    * @return 카테고리별 지출 금액을 담은 ArrayList를 반환합니다.
    */
   public ArrayList<AccountInfoDTO> beforeAnalysis(String id, HashMap<String, String> map) {
   	
   	try {
   		
   		String period = map.get("period");
   		
   		String sql = "select\r\n"
   				+ "    sum(price) totalPrice,\r\n"
   				+ "    ac.NAME acName\r\n"
   				+ "from tblaccinfo ai\r\n"
   				+ "    inner join TBLACCCATEGORYLIST acl on ai.SEQ = acl.SEQACCINFO\r\n"
   				+ "    inner join TBLACCCATEGORY ac on acl.SEQACCCATEGORY = ac.SEQ\r\n"
   				+ "    inner join TBLACC a on ai.SEQACC = a.SEQ\r\n"
   				+ "    inner join TBLMEMBER me on a.IDMEMBER = me.ID\r\n"
   				+ "    where IDMEMBER = ?";
   		
   		
   		if (period.equals("day")) {
   			sql +=    "and trunc(ai.accInfoDate) = trunc(sysdate) - 1 -- 어제 날짜\r\n";
   			
   		} else if (period.equals("week")) {
   			sql +=  " and ai.accInfoDate >= trunc(sysdate, 'IW') - 7 -- 저번주 시작 날짜\r\n"
   			   + "    and ai.accInfoDate < trunc(sysdate, 'IW') -- 저번주 종료 날짜\r\n";

   		} else if (period.equals("month")) {
   			sql +=    "and ai.accInfoDate \r\n"
   					+ "                                            between to_date(sysdate, 'YY/MM/DD') \r\n"
   					+ "                                                - interval '2' month and to_date(sysdate, 'YY/MM/DD')\r\n"
   					+ "                                                    - interval '1' month\r\n";

   		}
   		
   		 sql += "and ai.SEQDEPOSITWITHDRAWALSTATUS = 2\r\n"
   		 		+ "    group by ac.NAME";
   		
   		pstat = conn.prepareStatement(sql);
   		pstat.setString(1, id);
   		
   		rs = pstat.executeQuery();
   		
   		ArrayList<AccountInfoDTO> list = new ArrayList<AccountInfoDTO>();
   		
   		while (rs.next()) {
   			
   			AccountInfoDTO dto = new AccountInfoDTO();
   			
   			dto.setTotalPrice(rs.getInt("totalPrice"));
   			dto.setAcName(rs.getString("acName"));
   			
   			list.add(dto);				
   		}	
   		
   		return list;
   		
   	} catch (Exception e) {
   		e.printStackTrace();
   	}

   	return null;
   }	

   /**
    * 이번달 고정 지출 정보를 조회하는 메서드입니다.
    * @param id 회원 아이디입니다.
    * @return 고정 지출 정보를 담은 ArrayList를 반환합니다.
    */	
   public ArrayList<AccountInfoDTO> getFixedFluctuation(String id) {

   	try {

   		String sql = "select \r\n"
   				+ "    ai.accinfodate as accinfodate,\r\n"
   				+ "    ai.price as price,\r\n"
   				+ "    ffp.period as period\r\n"
   				+ "from \r\n"
   				+ "    tblaccinfo ai\r\n"
   				+ "    inner join tblfixeddepositwithdrawalcheck fdw on fdw.seq = ai.seqfixedfluctuationcheck\r\n"
   				+ "    inner join tblacc acc on acc.seq = ai.seqacc\r\n"
   				+ "    inner join tblfixedfluctuationperiod ffp on ffp.seq = fdw.seqfixedfluctuationperiod\r\n"
   				+ "where \r\n"
   				+ "    fdw.seqfixedfluctuationperiod != 0\r\n"
   				+ "    and acc.idmember = ?\r\n"
   				+ "    and to_date(ai.accinfodate, 'yy/mm/dd') + interval '1' month * ffp.period > current_date";

   		pstat = conn.prepareStatement(sql);
   		pstat.setString(1, id);

   		rs = pstat.executeQuery();

   		ArrayList<AccountInfoDTO> list = new ArrayList<AccountInfoDTO>();

   		while (rs.next()) {

   			AccountInfoDTO dto = new AccountInfoDTO();

   			dto.setAccInfoDate(rs.getString("accInfoDate"));
   			dto.setPrice(rs.getInt("price"));
   			dto.setFfpPeriod(rs.getInt("period"));
   			
   			list.add(dto);
   		}

   		return list;

   	} catch (Exception e) {
   		e.printStackTrace();
   	}

   	return null;
   }
   
   /**
    * 챌린지 정보를 조회하는 메서드입니다.
    * @param id 회원 아이디입니다.
    * @return 챌린지 정보를 담은 UserDTO 객체를 반환합니다.
   */
   public UserDTO getSavingsGoals(String id) {
	   try {

			String sql = "select \r\n"
					+ "su.monthlyPaycheck monthlyPaycheck, --월급\r\n"
					+ "su.savingsGoals savingsGoals, --저축 목표 금액\r\n"
					+ "seqCompressionIntensity seqCompressionIntensity,\r\n"
					+ "sp.period period,\r\n"
					+ "me.joinDate joinDate,\r\n"
					+ "trunc(months_between(sysdate, me.joindate)) monthsSinceJoin\r\n"
					+ "from tblSurvey su\r\n"
					+ "    inner join tblMember me\r\n"
					+ "        on su.seq = me.seqSurvey\r\n"
					+ "            inner join tblSavingsPeriod sp\r\n"
					+ "                on sp.seq = su.seqSavingsPeriod\r\n"
					+ "                    where me.id = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);

			rs = pstat.executeQuery();

			while (rs.next()) {

				UserDTO dto = new UserDTO();
				
				dto.setMonthlyPaycheck(rs.getInt("monthlyPaycheck"));
				dto.setSavingsGoals(rs.getInt("savingsGoals"));
				dto.setSeqCompressionIntensity(rs.getString("seqCompressionIntensity"));
				dto.setSpPeriod(rs.getInt("period"));
				dto.setJoinDate(rs.getString("joinDate"));
				dto.setMonthsSinceJoin(rs.getInt("monthsSinceJoin"));
				
				return dto;
			}

		} catch (Exception e) {
			System.out.println("AccountDAO.getSavingsGoals");
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 이번달 사용 금액을 조회하는 메서드입니다.
	 * @param id 회원 아이디입니다.
	 * @return 이번달 사용 금액을 반환합니다.
	 */
	public int getMonthUsage (String id) {

		try {

			String sql = "select\r\n"
					+ "sum(ai.price) monthUsage,\r\n"
					+ "acc.idMember idMember\r\n"
					+ "from tblAccInfo ai\r\n"
					+ "    inner join tblAcc acc\r\n"
					+ "        on acc.seq = ai.seqAcc\r\n"
					+ "            where acc.idMember = ?\r\n"
					+ "                and ai.accInfoDate \r\n"
					+ "                    between to_date(sysdate, 'YY/MM/DD') \r\n"
					+ "                        - interval '1' month and to_date(sysdate, 'YY/MM/DD')\r\n"
					+ "                            and ai.seqDepositWithdrawalStatus = 2 --출금\r\n"
					+ "                                group by acc.idMember";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);

			rs = pstat.executeQuery();

			while (rs.next()) {

				return rs.getInt("monthUsage");
			}

		} catch (Exception e) {
			System.out.println("AccountDAO.getMonthUsage");
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * 이번달 입금 금액을 조회하는 메서드입니다.
	 * @param id 회원 아이디입니다.
	 * @return 이번달 입금 금액을 반환합니다.
	 */
	public int getMonthSaving (String id) {
		
		try {
			
			String sql = "select\r\n"
					+ "sum(ai.price) monthSaving,\r\n"
					+ "acc.idMember idMember\r\n"
					+ "from tblAccInfo ai\r\n"
					+ "    inner join tblAcc acc\r\n"
					+ "        on acc.seq = ai.seqAcc\r\n"
					+ "            where acc.idMember = ?\r\n"
					+ "                and ai.seqDepositWithdrawalStatus = 1 -- 입금\r\n"
					+ "                    and ai.accInfoDate \r\n"
					+ "                        between to_date(sysdate, 'YY/MM/DD') \r\n"
					+ "                            - interval '1' month and to_date(sysdate, 'YY/MM/DD')\r\n"
					+ "                                group by acc.idMember";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			while (rs.next()) {
				
				return rs.getInt("monthSaving");
			}
			
		} catch (Exception e) {
			System.out.println("AccountDAO.getMonthSaving");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 총 저축 금액을 조회하는 메서드입니다.
	 * @param id 회원 아이디입니다.
	 * @return 총 저축 금액을 반환합니다.
	 */
	public int getTotalSaving(String id) {

		try {

			String sql = "select\r\n"
					+ "    sum(case when ai.seqdepositwithdrawalstatus = 1 then ai.price else -ai.price end) as totalsaving,\r\n"
					+ "    acc.idmember as idmember\r\n"
					+ "from\r\n"
					+ "    tblaccinfo ai\r\n"
					+ "    inner join tblacc acc on acc.seq = ai.seqacc\r\n"
					+ "where\r\n"
					+ "    acc.idmember = ?\r\n"
					+ "    and ai.seqdepositwithdrawalstatus in (1, 2) -- 입금 및 출금\r\n"
					+ "group by\r\n"
					+ "    acc.idmember";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);

			rs = pstat.executeQuery();

			while (rs.next()) {
				
				return rs.getInt("totalSaving");
			}

		} catch (Exception e) {
			System.out.println("AccountDAO.getTotalSaving");
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * 현재까지 총 지출 금액을 조회하는 메서드입니다.
	 * @param id 회원 아이디입니다.
	 * @return 총 지출 금액을 반환합니다.
	 */
	public int getTotalExpenditure(String id) {

		try {

			String sql = "select\r\n"
					+ "sum(ai.price) totalExpenditure,\r\n"
					+ "acc.idMember idMember\r\n"
					+ "from tblAccInfo ai\r\n"
					+ "    inner join tblAcc acc\r\n"
					+ "        on acc.seq = ai.seqAcc\r\n"
					+ "            where acc.idMember = ?\r\n"
					+ "                and ai.seqDepositWithdrawalStatus = 2 --출금\r\n"
					+ "                    group by acc.idMember";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);

			rs = pstat.executeQuery();

			while (rs.next()) {
				
				return rs.getInt("totalExpenditure");
			}

		} catch (Exception e) {
			System.out.println("AccountDAO.getTotalSaving");
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * 챌린지에 대한 정보를 조회하는 메서드입니다.
	 * 이번달 목표치와 현재 상황을 조회합니다.
	 * @param id 회원 아이디입니다.
	 * @return 챌린지 정보를 담은 HashMap을 반환합니다.
	 */
	public HashMap<String, String> getChallenge(String id) {
		
		try {
			//1000단위 콤마 찍기 위한 형식
			DecimalFormat formatter = new DecimalFormat("#,###");
			
			//이번 달의 마지막 날짜 구하기
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			int lastDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
					
			String accInfoDate = null;
			long price = 0; //고정 지출 금액
			int ffpPeriod = 0; //고정 지출 간격
			int totalfixedFluctuation = 0; //고청 지출 총 합
			
			int savingsGoals = 0; //저축 목표 금액
			int monthlyPaycheck = 0; //월급
			String joinDate = null; //회원 가입일
			int spPeriod = 0; //저축 목표 기간
			int monthsSinceJoin = 0; //지난 저축 기간
			
			int monthUsage = getMonthUsage(id); //이번달 지출
			int monthSaving = getMonthSaving(id); //이번달 입금
			
			int totalSaving = getTotalSaving(id); //총 입/출금 금액
			int totalExpenditure = getTotalExpenditure(id); //총 지출
			
			
			int goalAchievementPeriod = 0; //목표 달성까지 예상 기간
			int avgMonthlyUsablePrice = 0; //달 평균 사용 가능 금액
			int avgDailyUsablePrice = 0; //일 평균 사용 가능 금액
			int avgMonthlySavingsPrice = 0; //목표 기간 안에 저축하기 위한 한 달 평균 저축 금액
			
			int avgMonthlySavings = 0; //한 달 평균 저축 금액
			int avgMonthlySpending = 0; //한 달 평균 지출 금액
			int remainingSavings = 0; //남은 저축 금액
			
			HashMap<String, String> map = new HashMap<>();

			// 고정 지출
			ArrayList<AccountInfoDTO> fixedFluctuationList = getFixedFluctuation(id);
			
			// 챌린지 정보
			UserDTO userDTO = getSavingsGoals(id);
			
			if (fixedFluctuationList != null) {
				
				//고정 지출 담기
				for (AccountInfoDTO dto : fixedFluctuationList) {
					
					accInfoDate = dto.getAccInfoDate();
					price = dto.getPrice();
					ffpPeriod = dto.getFfpPeriod();
					
					totalfixedFluctuation += price;
//					System.out.println(totalfixedFluctuation);
				}
				
			}
						
			//챌린지 정보 불러오기
			monthlyPaycheck = userDTO.getMonthlyPaycheck();
			savingsGoals = userDTO.getSavingsGoals();
//			userDTO.getSeqCompressionIntensity();
spPeriod = userDTO.getSpPeriod();
//			joinDate = userDTO.getJoinDate();
monthsSinceJoin = userDTO.getMonthsSinceJoin();
//남은 저축 금액
		remainingSavings = savingsGoals - totalSaving;

		//한 달 평균 지출 금액
		avgMonthlySpending = totalExpenditure / monthsSinceJoin;
		
		//한 달 평균 저축 금액
		avgMonthlySavings = totalSaving / monthsSinceJoin;
				
		//목표 달성까지 기간 계산
		goalAchievementPeriod = remainingSavings / avgMonthlySavings;
				
		//목표 기간 안에 목표 금액을 저축하기 위해 매달 저축해야하는 평균
		avgMonthlySavingsPrice = remainingSavings / (spPeriod - monthsSinceJoin);
		
		//달 평균 사용 가능 금액
		avgMonthlyUsablePrice = (monthSaving - monthUsage - totalfixedFluctuation) - avgMonthlySavingsPrice;
		
		//일 편귱 사용 가능 금액
		avgDailyUsablePrice = avgMonthlyUsablePrice / lastDayOfMonth;
		
		map.put("savingsGoals", formatter.format(savingsGoals));
		map.put("totalSaving", formatter.format(totalSaving));
		map.put("remainingSavings", formatter.format(remainingSavings));
		map.put("avgMonthlySpending", formatter.format(avgMonthlySpending));
		map.put("avgMonthlySavings", formatter.format(avgMonthlySavings));
		map.put("goalAchievementPeriod", formatter.format(goalAchievementPeriod));
		map.put("monthUsage", formatter.format(monthUsage));
		
		map.put("spPeriod", formatter.format(spPeriod));
		map.put("monthsSinceJoin", formatter.format(monthsSinceJoin));
		
		map.put("avgMonthlySavings", formatter.format(avgMonthlySavings));
		map.put("avgMonthlySavingsPrice", formatter.format(avgMonthlySavingsPrice));
		map.put("avgMonthlyUsablePrice", formatter.format(avgMonthlyUsablePrice));
		map.put("avgDailyUsablePrice", formatter.format(avgDailyUsablePrice));
		
		return map;
		
	} catch (Exception e) {
		System.out.println("AccountDAO.getChallenge");
		e.printStackTrace();
	}
	
	return null;

}

/**
* 기간별 사용 금액을 조회하는 메서드입니다.
* @param id 회원 아이디입니다.
* @return 기간별 사용 금액을 담은 HashMap을 반환합니다.
*/
public HashMap<String, Integer> getPeriodUsage (String id) {

	try {

		String sql = "SELECT \r\n"
				+ "    COALESCE(sub1.totalPrice, 0) beforeMonthUsage,\r\n"
				+ "    COALESCE(sub2.totalPrice, 0) nowMonthUsage,\r\n"
				+ "    COALESCE(sub1.idMember, sub2.idMember) idMember\r\n"
				+ "FROM (\r\n"
				+ "    -- 2달 전부터 1달 전까지의 사용 금액\r\n"
				+ "    SELECT \r\n"
				+ "        SUM(ai.price) AS totalPrice,\r\n"
				+ "        me.ID AS idMember\r\n"
				+ "    from tblaccinfo ai\r\n"
				+ "    inner join TBLACCCATEGORYLIST acl on ai.SEQ = acl.SEQACCINFO\r\n"
				+ "    inner join TBLACCCATEGORY ac on acl.SEQACCCATEGORY = ac.SEQ\r\n"
				+ "    inner join TBLACC a on ai.SEQACC = a.SEQ\r\n"
				+ "    inner join TBLMEMBER me on a.IDMEMBER = me.ID\r\n"
				+ "    WHERE \r\n"
				+ "        me.ID = ?\r\n"
				+ "        AND ai.accInfoDate BETWEEN to_date(sysdate, 'YY/MM/DD') - interval '2' month AND to_date(sysdate, 'YY/MM/DD') - interval '1' month -- 2달 전부터 1달 전까지\r\n"
				+ "        AND ai.seqDepositWithdrawalStatus = 2 -- 입출금 상태\r\n"
				+ "    GROUP BY \r\n"
				+ "        me.ID\r\n"
				+ ") sub1\r\n"
				+ "FULL OUTER JOIN (\r\n"
				+ "    -- 1달 전부터 현재까지의 사용 금액\r\n"
				+ "    SELECT \r\n"
				+ "        SUM(ai.price) AS totalPrice,\r\n"
				+ "        me.ID AS idMember\r\n"
				+ "    from tblaccinfo ai\r\n"
				+ "    inner join TBLACCCATEGORYLIST acl on ai.SEQ = acl.SEQACCINFO\r\n"
				+ "    inner join TBLACCCATEGORY ac on acl.SEQACCCATEGORY = ac.SEQ\r\n"
				+ "    inner join TBLACC a on ai.SEQACC = a.SEQ\r\n"
				+ "    inner join TBLMEMBER me on a.IDMEMBER = me.ID\r\n"
				+ "    WHERE \r\n"
				+ "        me.ID = ?\r\n"
				+ "        AND ai.accInfoDate BETWEEN to_date(sysdate, 'YY/MM/DD') - interval '1' month AND to_date(sysdate, 'YY/MM/DD') -- 1달 전부터 현재까지\r\n"
				+ "        AND ai.seqDepositWithdrawalStatus = 2 -- 입출금 상태\r\n"
				+ "    GROUP BY \r\n"
				+ "        me.ID\r\n"
				+ ") sub2 ON sub1.idMember = sub2.idMember";
		
		pstat = conn.prepareStatement(sql);
		pstat.setString(1, id);
		pstat.setString(2, id);

		rs = pstat.executeQuery();

		HashMap<String, Integer> map = new HashMap<>();
		
		while (rs.next()) {
			
			map.put("nowMonthUsage", rs.getInt("nowMonthUsage"));
			map.put("beforeMonthUsage", rs.getInt("beforeMonthUsage"));
			
		}

		return map; 

	} catch (Exception e) {
		e.printStackTrace();
	}

	return null;
}

/**
 * 최대 사용 카테고리를 조회하는 메서드입니다.
 * @param id 회원 아이디입니다.
 * @return 최대 사용 카테고리 정보를 담은 AccountInfoDTO 객체를 반환합니다.
 */
public AccountInfoDTO getMaxUsageCategory(String id) {

	try {

		String sql = "WITH max_category AS (\r\n"
				+ "    SELECT \r\n"
				+ "        ac.name AS acName,\r\n"
				+ "        SUM(ai.price) AS totalPrice\r\n"
				+ "    FROM \r\n"
				+ "        tblaccinfo ai\r\n"
				+ "        INNER JOIN TBLACCCATEGORYLIST acl ON ai.SEQ = acl.SEQACCINFO\r\n"
				+ "        INNER JOIN TBLACCCATEGORY ac ON acl.SEQACCCATEGORY = ac.SEQ\r\n"
				+ "        INNER JOIN TBLACC a ON ai.SEQACC = a.SEQ\r\n"
				+ "        INNER JOIN TBLMEMBER me ON a.IDMEMBER = me.ID\r\n"
				+ "    WHERE \r\n"
				+ "        me.ID = ?\r\n"
				+ "        AND ai.accInfoDate BETWEEN to_date(sysdate, 'YY/MM/DD') - interval '2' month AND to_date(sysdate, 'YY/MM/DD') - interval '1' month -- 2달 전부터 1달 전까지\r\n"
				+ "        AND ai.seqDepositWithdrawalStatus = 2\r\n"
				+ "    GROUP BY \r\n"
				+ "        ac.name\r\n"
				+ "    ORDER BY \r\n"
				+ "        totalPrice DESC\r\n"
				+ "    FETCH FIRST 1 ROW ONLY\r\n"
				+ ")\r\n"
				+ "SELECT \r\n"
				+ "    mc.acName AS acName,\r\n"
				+ "    MAX(totalPrice) AS beforeAcUsage,\r\n"
				+ "    SUM(CASE WHEN ai.accInfoDate BETWEEN TRUNC(SYSDATE, 'MM') - INTERVAL '1' MONTH AND TRUNC(SYSDATE, 'MM') THEN ai.price ELSE 0 END) AS nowAcUsage\r\n"
				+ "FROM \r\n"
				+ "    tblaccinfo ai\r\n"
				+ "    INNER JOIN TBLACCCATEGORYLIST acl ON ai.SEQ = acl.SEQACCINFO\r\n"
				+ "    INNER JOIN TBLACCCATEGORY ac ON acl.SEQACCCATEGORY = ac.SEQ\r\n"
				+ "    INNER JOIN TBLACC a ON ai.SEQACC = a.SEQ\r\n"
				+ "    inner join max_category mc on mc.acName = ac.name\r\n"
				+ "    INNER JOIN TBLMEMBER me ON a.IDMEMBER = me.ID\r\n"
				+ "WHERE \r\n"
				+ "    me.ID = ?\r\n"
				+ "    AND ai.seqDepositWithdrawalStatus = 2\r\n"
				+ "GROUP BY \r\n"
				+ "    mc.acName";

		pstat = conn.prepareStatement(sql);
		pstat.setString(1, id);
		pstat.setString(2, id);

		rs = pstat.executeQuery();

		AccountInfoDTO dto = new AccountInfoDTO();
		
		while (rs.next()) {
			
			dto.setBeforeAcUsage(rs.getInt("beforeAcUsage"));
			dto.setNowAcUsage(rs.getInt("nowAcUsage"));
			dto.setAcName(rs.getString("acName"));
		}

		return dto; 

	} catch (Exception e) {
		e.printStackTrace();
	}

	return null;
}

/**
 * 카테고리별 지출 비교 정보를 조회하는 메서드입니다.
 * @param id 회원 아이디입니다.
 * @return 카테고리별 지출 비교 정보를 담은 HashMap을 반환합니다.
 */
public HashMap<String, String> getComparisonCategoryUsage(String id) {
	
	DecimalFormat formatter = new DecimalFormat("#,###");
	
	HashMap<String, String> map = new HashMap<>();
		
	String acName = null;
	
	int nowAcUsage = 0;
	int beforeAcUsage = 0;
	
	int nowMonthUsage = 0; // 이번달 지출
	int beforeMonthUsage = 0; // 지난달 지출
	
	int now = 0;
	int before = 0;
	
	AccountInfoDTO dto = getMaxUsageCategory(id);
	HashMap<String, Integer> usageMap = getPeriodUsage(id);
	
	beforeAcUsage = dto.getBeforeAcUsage();
	nowAcUsage = dto.getNowAcUsage();
	acName = dto.getAcName();
	
	beforeMonthUsage = usageMap.get("beforeMonthUsage");
	nowMonthUsage = usageMap.get("nowMonthUsage");
	
	before = beforeAcUsage / beforeMonthUsage;
	now = nowAcUsage / nowMonthUsage;
	
	map.put("acName", acName);
	
	map.put("now", String.valueOf(formatter.format(now)));
	map.put("before", String.valueOf(formatter.format(before)));
	
	map.put("beforeMonthUsage", String.valueOf(formatter.format(beforeMonthUsage)));
	map.put("nowMonthUsage", String.valueOf(formatter.format(nowMonthUsage)));
	
	map.put("beforeAcUsage", String.valueOf(formatter.format(beforeAcUsage)));
	map.put("nowAcUsage", String.valueOf(formatter.format(nowAcUsage)));
	
	map.put("gap", String.valueOf(formatter.format(before - now)));

	return map;
}

/**
 * 뉴스 검색 결과를 조회하는 메서드입니다.
 * @param category 검색할 카테고리입니다.
 * @return 뉴스 검색 결과를 담은 ArrayList를 반환합니다.
 */
public ArrayList<AccountInfoDTO> search(String category) {
	UserDAO dao = new UserDAO();
	HashMap<String, String> apiInfoMap = dao.getAPIKey("2");

	// 돌려주기 위한 리스트
	ArrayList<AccountInfoDTO> newsList = new ArrayList();

	String clientId = apiInfoMap.get("name"); // 애플리케이션 클라이언트 아이디
	String clientSecret = apiInfoMap.get("key");
	; // 애플리케이션 클라이언트 시크릿

	String word = "경제";
	
	try {
		category = URLEncoder.encode(category, "UTF-8");
		word = URLEncoder.encode(word, "UTF-8");
	} catch (UnsupportedEncodingException e) {
		throw new RuntimeException("검색어 인코딩 실패", e);
	}

	String apiURL = "https://openapi.naver.com/v1/search/news?query=" + category + "+" + word + "&display=5&sort=date"; // JSON 결과
	// String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text;
	// // XML 결과

	Map<String, String> requestHeaders = new HashMap<>();
	requestHeaders.put("X-Naver-Client-Id", clientId);
	requestHeaders.put("X-Naver-Client-Secret", clientSecret);
	String responseBody = get(apiURL, requestHeaders);
	
//	System.out.println(responseBody);
	// 파싱
		JSONParser parser = new JSONParser();

		try {
			JSONObject root = (JSONObject) parser.parse(responseBody);
//			System.out.println(root.get("total"));

			JSONArray list = (JSONArray) root.get("items");

			for (int i = 0; i < list.size(); i++) {

				// JSON Object == 뉴스 1개 > dto 1개에 담기

				AccountInfoDTO dto = new AccountInfoDTO();
				
				// get도 object 타입이라 toString로 받는다.
				dto.setTitle(((JSONObject) list.get(i)).get("title").toString());
				dto.setLink(((JSONObject)list.get(i)).get("link").toString());
				
				// 날짜 형식 변환
	            String pubDateStr = ((JSONObject) list.get(i)).get("pubDate").toString();
	            SimpleDateFormat inputFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
	            Date pubDate = inputFormat.parse(pubDateStr);
	            SimpleDateFormat outputFormat = new SimpleDateFormat("yy/MM/dd", Locale.ENGLISH);
	            String formattedDate = outputFormat.format(pubDate);
	            dto.setPubDate(formattedDate);
//				dto.setPubDate(((JSONObject)list.get(i)).get("pubDate").toString());
dto.setDescription(((JSONObject)list.get(i)).get("description").toString());
newsList.add(dto);
			}

			return newsList;

		}
			
	  catch (Exception e) {
		System.out.println("AccountDAO.search");
		e.printStackTrace();
	}
		return null;
	}

	/**
	 * API 요청을 수행하고 응답을 반환하는 메서드입니다.
	 * @param apiUrl API URL입니다.
	 * @param requestHeaders 요청 헤더입니다.
	 * @return API 응답을 문자열로 반환합니다.
	 */
	private static String get(String apiUrl, Map<String, String> requestHeaders){
	    HttpURLConnection con = connect(apiUrl);
	    try {
	        con.setRequestMethod("GET");
	        for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
	            con.setRequestProperty(header.getKey(), header.getValue());
	        }


	        int responseCode = con.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
	            return readBody(con.getInputStream());
	        } else { // 오류 발생
	            return readBody(con.getErrorStream());
	        }
	    } catch (IOException e) {
	        throw new RuntimeException("API 요청과 응답 실패", e);
	    } finally {
	        con.disconnect();
	    }
	}

	/**
	 * API에 연결하는 메서드입니다.
	 * @param apiUrl API URL입니다.
	 * @return HttpURLConnection 객체를 반환합니다.
	 */
	private static HttpURLConnection connect(String apiUrl){
	    try {
	        URL url = new URL(apiUrl);
	        return (HttpURLConnection)url.openConnection();
	    } catch (MalformedURLException e) {
	    throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
	    } catch (IOException e) {
	    throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
	    }
	    }
	/**
	 * API 응답을 읽는 메서드입니다.
	 * @param body InputStream 객체입니다.
	 * @return 응답 내용을 문자열로 반환합니다.
	 */
	private static String readBody(InputStream body){
	    InputStreamReader streamReader = new InputStreamReader(body);


	    try (BufferedReader lineReader = new BufferedReader(streamReader)) {
	        StringBuilder responseBody = new StringBuilder();


	        String line;
	        while ((line = lineReader.readLine()) != null) {
	            responseBody.append(line);
	        }


	        return responseBody.toString();
	    } catch (IOException e) {
	        throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
	    }
	}

	/**
	 * 비용과 수익을 조회하는 메서드입니다.
	 * @param dto 조회에 필요한 정보를 담은 AccountInfoDTO 객체입니다.
	 * @return 비용과 수익 조회 결과를 반환합니다.
	 */
	public int costRevenue(AccountInfoDTO dto) {
		
		return 0;
	}

	/**
	 * 카드 사용 내역을 조회하는 메서드입니다.
	 * @param id 회원 아이디입니다.
	 * @param map 조회 조건을 담은 HashMap 객체입니다.
	 * @return 카드 사용 내역을 담은 ArrayList를 반환합니다.
	 */
	public ArrayList<AccountInfoDTO> list(String id, HashMap<String, String> map) {
		
		try {
			
			String startDate = map.get("startDate");
		    String endDate = map.get("endDate");
			
			String sql = "select \r\n"
	                + "sum(ai.price) totalPrice,\r\n"
	                + "mc.alias alias, --카드 별칭\r\n"
	                + "cf.name cfName, -- 카드명\r\n"
	                + "cf.fileLink fileLink, --카드 이미지\r\n"
	                + "mc.seq seqMyCard, --카드 번호\r\n"
	                + "mc.idMember idMember\r\n"
	                + "from tblAccInfo ai\r\n"
	                + "    inner join tblReasonChangeCategory rcc \r\n"
	                + "        on rcc.seq = ai.seqReasonChangeCategory\r\n"
	                + "            inner join tblMyCard "
	                + ""
	                + "mc \r\n"
	                + "                on mc.seq = rcc.seqMyCard\r\n"
	                + "                    inner join tblCardInformation cf \r\n"
	                + "                        on cf.seq = mc.seqCardInformation\r\n"
	                + "                            where mc.idMember = ?\r\n";

			// 시작일과 종료일이 둘 다 비어 있지 않은 경우에만 조건을 추가
	        if (startDate != null && !startDate.isEmpty() && endDate != null && !endDate.isEmpty()) {
	            sql += "and ai.accInfoDate between to_date(?, 'YYYY-MM-DD') and to_date(?, 'YYYY-MM-DD')\r\n";
	        }

	        sql += "group by mc.alias, cf.name, cf.fileLink, mc.seq, mc.idMember";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			 // 시작일과 종료일이 둘 다 비어 있지 않은 경우에만 파라미터로 설정
	        if (startDate != null && !startDate.isEmpty() && endDate != null && !endDate.isEmpty()) {
	            pstat.setString(2, startDate);
	            pstat.setString(3, endDate);
	        }
			
			rs = pstat.executeQuery();
			
			ArrayList<AccountInfoDTO> list = new ArrayList<AccountInfoDTO>();
			
			while (rs.next()) {
				
				AccountInfoDTO dto = new AccountInfoDTO();
				
				dto.setTotalPrice(rs.getLong("totalPrice"));
				dto.setAlias(rs.getString("alias"));
				dto.setCfName(rs.getString("cfName"));
				dto.setFileLink(rs.getString("fileLink"));
				dto.setSeqMyCard(rs.getString("seqMyCard"));
				
				list.add(dto);

			}	
				
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	/**
	 * 특정 카드의 사용 내역을 조회하는 메서드입니다.
	 * @param id 회원 아이디입니다.
	 * @param map 조회 조건을 담은 HashMap 객체입니다.
	 * @return 특정 카드의 사용 내역을 담은 ArrayList를 반환합니다.
	 */
	public ArrayList<AccountInfoDTO> getCardUsageDetails(String id, HashMap<String, String> map) {

		try {
			
			String seqMyCard = map.get("seqMyCard");
			String startDate = map.get("startDate");
		    String endDate = map.get("endDate");		    
			
			String sql = "select \r\n"
					+ "ai.accInfoDate accInfoDate, --날짜\r\n"
					+ "ai.price price, --금액\r\n"
					+ "ac.name acName, --카테고리\r\n"
					+ "ai.location location, --사용처\r\n"
					+ "ai.seqDepositWithdrawalStatus seqDepositWithdrawalStatus, --입출금 상태\r\n"
					+ "mc.alias alias, --카드 별칭\r\n"
					+ "cf.name cfName, -- 카드명\r\n"
					+ "cf.fileLink fileLink, --카드 이미지\r\n"
					+ "mc.seq seqMyCard, --카드 번호\r\n"
					+ "mc.idMember idMember\r\n"
					+ "from tblAccInfo ai\r\n"
					+ "    inner join tblAccCategoryList acl\r\n"
					+ "        on acl.seqAccInfo = ai.seq\r\n"
					+ "            inner join tblAccCategory ac\r\n"
					+ "                on ac.seq = acl.seqAccCategory\r\n"
					+ "                    inner join tblReasonChangeCategory rcc \r\n"
					+ "                        on rcc.seq = ai.seqReasonChangeCategory\r\n"
					+ "                            inner join tblMyCard mc \r\n"
					+ "                                on mc.seq = rcc.seqMyCard\r\n"
					+ "                                    inner join tblCardInformation cf \r\n"
					+ "                                        on cf.seq = mc.seqCardInformation\r\n"
					+ "                                            where mc.idMember = ?\r\n";

			
			
			// 시작일과 종료일이 둘 다 비어 있지 않은 경우에만 조건을 추가
	        if (startDate != null && !startDate.isEmpty() && endDate != null && !endDate.isEmpty()) {
	            sql += "and ai.accInfoDate between to_date(?, 'YYYY-MM-DD') and to_date(?, 'YYYY-MM-DD')\r\n";
	        }

	        sql += "and mc.seq = ?"
	        	+ "order by ai.accInfoDate desc";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			System.out.println("id: " + id);
			
			 // 시작일과 종료일이 둘 다 비어 있지 않은 경우에만 파라미터로 설정
	        if (startDate != null && !startDate.isEmpty() && endDate != null && !endDate.isEmpty()) {
	            pstat.setString(2, startDate);
	            pstat.setString(3, endDate);
	            pstat.setString(4, seqMyCard);
	            System.out.println("startDate: " + startDate);
	            System.out.println("endDate: " + endDate);
	            System.out.println("seqMyCard: " + seqMyCard);
	        } else {
	        	pstat.setString(2, seqMyCard);
	        }
	        
			
			rs = pstat.executeQuery();
						
			ArrayList<AccountInfoDTO> list = new ArrayList<AccountInfoDTO>();
			
			while (rs.next()) {
				
				AccountInfoDTO dto = new AccountInfoDTO();
				
				dto.setAccInfoDate(rs.getString("accInfoDate"));
				dto.setPrice(rs.getLong("price"));
				dto.setAcName(rs.getString("acName"));
				dto.setLocation(rs.getString("location"));
				dto.setSeqDepositWithdrawalStatus(rs.getString("seqDepositWithdrawalStatus"));
				dto.setAlias(rs.getString("alias"));
				dto.setCfName(rs.getString("cfName"));
				dto.setFileLink(rs.getString("fileLink"));
				dto.setSeqMyCard(rs.getString("seqMyCard"));

				list.add(dto);				
			}	
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 카테고리 목록을 가져오는 메서드입니다.
	 * @return 카테고리 목록을 담은 ArrayList를 반환합니다.
	 */
	public ArrayList<AccountInfoDTO> getCategory() {
		
		try {
			
			String sql = "select * from tblAccCategory order by seq asc";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<AccountInfoDTO> list = new ArrayList<AccountInfoDTO>();
			
			while (rs.next()) {
				
				AccountInfoDTO dto = new AccountInfoDTO();
				
				dto.setSeqAccCategory(rs.getString("seq"));
				dto.setAcName(rs.getString("name"));
				
				list.add(dto);				
			}	
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 가계부 이벤트 내용을 조회하는 메서드입니다.
	 * @param id 회원 아이디입니다.
	 * @param map 검색 조건을 담은 HashMap 객체입니다.
	 * @return 가계부 이벤트 내용을 담은 ArrayList를 반환합니다.
	 */
	public ArrayList<AccountInfoDTO> accEventContent(String id, HashMap<String, String> map) {
		ArrayList<AccountInfoDTO> list = new ArrayList<AccountInfoDTO>();
		try {
			
			//검색
			String where = "";
			
			if (map.get("search").equals("y")) {

				where = String.format(" and ai.content like '%%%s%%'\r\n or location like '%%%s%%'", map.get("word"), map.get("word"));
			}
			
			String sql = "select  ai.seq as accinfonum,\r\n"
					+ "					    ai.content as aicontent,\r\n"
					+ "					    ai.SEQACC as seqacc,\r\n"
					+ "                     ai.SEQREASONCHANGECATEGORY as seqrcc,\r\n"
					+ "                     ai.SEQFIXEDFLUCTUATIONCHECK as seqffc,\r\n"
					+ "					    acl.SEQACCCATEGORY,\r\n"
					+ "					    accinfodate,\r\n"
					+ "					    price,\r\n"
					+ "					    location,\r\n"
					+ "					    me.ID as idMember,\r\n"
					+ "					    acate.NAME as acName,\r\n"
					+ "					    seqfixedfluctuationcheck,\r\n"
					+ "					    PERIOD,\r\n"
					+ "					    ai.SEQDEPOSITWITHDRAWALSTATUS as spendstatus,\r\n"
					+ "					    rcl.CONTENT as paymentmethod,\r\n"
					+ "					    mc.ALIAS as name,\r\n"
					+ "					    mc.CARDNUMBER as cardnumber\r\n"
					+ "					from TBLACCINFO ai\r\n"
					+ "					    inner join TBLACC ac on ai.SEQACC = ac.SEQ\r\n"
					+ "					    inner join TBLMEMBER me on ac.IDMEMBER = me.ID\r\n"
					+ "					    inner join TBLACCCATEGORYLIST acl on ai.SEQ = acl.SEQACCINFO\r\n"
					+ "					    inner join TBLACCCATEGORY acate on acl.SEQACCCATEGORY = acate.SEQ\r\n"
					+ "					    inner join TBLDEPOSITWITHDRAWALSTATUS dws on ai.SEQDEPOSITWITHDRAWALSTATUS = dws.SEQ\r\n"
					+ "					    inner join TBLREASONCHANGECATEGORY rc on ai.SEQREASONCHANGECATEGORY = rc.SEQ\r\n"
					+ "					    inner join TBLREASONSCHANGELIST rcl on rc.SEQREASONSCHANGELIST = rcl.SEQ\r\n"
					+ "					    inner join TBLMYCARD mc on rc.SEQMYCARD = mc.SEQ\r\n"
					+ "					    inner join TBLFIXEDDEPOSITWITHDRAWALCHECK fdw on ai.SEQFIXEDFLUCTUATIONCHECK = fdw.SEQ\r\n"
					+ "					    inner join TBLFIXEDFLUCTUATIONPERIOD ffp on fdw.SEQFIXEDFLUCTUATIONPERIOD = ffp.SEQ\r\n"
					+ "					    where me.ID = ?" + where
					+ "					    order by accinfodate desc";
			
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			rs = pstat.executeQuery();			
			
			
			while(rs.next()) {
				AccountInfoDTO dto = new AccountInfoDTO();
				dto.setSeqAccInfo(rs.getString("accinfonum"));
				dto.setSeqAcc(rs.getString("seqacc")); //추가
				dto.setSeqReasonChangeCategory(rs.getString("seqrcc")); //추가
				dto.setContent(rs.getString("aicontent"));
				dto.setAccInfoDate(rs.getString("accinfodate"));
				dto.setPrice(rs.getInt("price"));
				dto.setLocation(rs.getString("location"));
				dto.setIdMember(rs.getString("idMember"));
				dto.setAcName(rs.getString("acName"));
				dto.setSeqFixedFluctuationCheck(rs.getString("seqfixedfluctuationcheck"));
				dto.setFfpPeriod(rs.getInt("PERIOD"));
				dto.setSeqDepositWithdrawalStatus(rs.getString("spendstatus"));
				dto.setPaymentMethod(rs.getString("paymentmethod"));
				dto.setAlias(rs.getString("name"));
				dto.setCardNumber(rs.getString("cardnumber"));
				list.add(dto);
			}
//			System.out.println("run");
			return list;
		} catch (Exception e) {
			System.out.println("AccountDAO.accEventContent");
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 가계부 이벤트를 추가하는 메서드입니다.
	 * @param dto 가계부 이벤트 정보를 담은 AccountInfoDTO 객체입니다.
	 * @return 가계부 이벤트 추가 결과를 반환합니다.
	 */
	public int addEvent(AccountInfoDTO dto) {
		
		try {
			
			System.out.println("insert start");
			
			String sql = "select * from tblAcc where idMember = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getIdMember());
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				dto.setSeqAcc(rs.getString("seq"));
			}
			 if (rs != null) rs.close();

		        sql = "INSERT INTO tblAccInfo(SEQ, CONTENT, ACCINFODATE, PRICE, LOCATION, SEQACC, SEQREASONCHANGECATEGORY, SEQFIXEDFLUCTUATIONCHECK, SEQDEPOSITWITHDRAWALSTATUS) VALUES ((SELECT NVL(MAX(seq), 0) + 1 FROM tblAccInfo), ?, ?, ?, ?, ?, ?, ?, ?)";
		        pstat = conn.prepareStatement(sql);

		        pstat.setString(1, dto.getContent());
		        pstat.setString(2, dto.getAccInfoDate());
		        pstat.setLong(3, dto.getPrice());
		        pstat.setString(4, dto.getLocation());
		        pstat.setInt(5, Integer.parseInt(dto.getSeqAcc()));
		        pstat.setInt(6, 2);
		        pstat.setInt(7, Integer.parseInt(dto.getSeqFixedFluctuationCheck()));
		        pstat.setInt(8, Integer.parseInt(dto.getSeqDepositWithdrawalStatus()));
		        System.out.println("dao indicator: "+dto.getSeqDepositWithdrawalStatus());
		        

		        int indicate = pstat.executeUpdate();

		        System.out.println("First insert result: " + indicate);

		        // Prepare to insert into tblAccCategoryList
		        sql = "INSERT INTO tblAccCategoryList(seq, seqAccCategory, seqAccInfo) VALUES ((SELECT NVL(MAX(seq), 0) + 1 FROM tblAccCategoryList), ?, (SELECT MAX(seq) FROM tblAccInfo))";
		        pstat = conn.prepareStatement(sql);
		        pstat.setString(1, dto.getSeqAccCategory());

		        int indicate2 = pstat.executeUpdate();

		        System.out.println("Second insert result: " + indicate2);

		        return indicate; 
			
		} catch (Exception e) {
			System.out.println("AccountDAO.addEvent");
			e.printStackTrace();
		}
		
		
		
		return 0;
	}

	/**
	 * 사용자의 카드 정보를 가져오는 메서드입니다.
	 * @param id 회원 아이디입니다.
	 * @return 사용자의 카드 정보를 담은 ArrayList를 반환합니다.
	 */
	public ArrayList<AccountInfoDTO> getmycards(String id) {
		ArrayList<AccountInfoDTO> list = new ArrayList<AccountInfoDTO>();
		try {
			String sql = "select\r\n"
					+ "    content as paymentmethod,\r\n"
					+ "    CARDNUMBER as cardnumber,\r\n"
					+ "    alias as name\r\n"
					+ "from TBLREASONCHANGECATEGORY rcc\r\n"
					+ "    left join TBLREASONSCHANGELIST rcl on rcc.SEQREASONSCHANGELIST = rcl.SEQ\r\n"
					+ "    left join TBLMYCARD mc on rcc.SEQMYCARD = mc.SEQ\r\n"
					+ "where IDMEMBER = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				AccountInfoDTO dto = new AccountInfoDTO();
				dto.setPaymentMethod(rs.getString("paymentmethod"));
				dto.setAlias(rs.getString("name"));
				dto.setCardNumber(rs.getString("cardnumber"));
				list.add(dto);
			}
			return list;
			
			
		} catch (Exception e) {
			System.out.println("AccountDAO.getmycards");
			e.printStackTrace();
		}
		
		
		return null;
	}

	/**
	 * 가계부를 업데이트하는 메서드입니다.
	 * @param dto 업데이트할 가계부 정보를 담은 AccountInfoDTO 객체입니다.
	 * @return 업데이트 결과를 반환합니다.
	 */
	public int updateAcc(AccountInfoDTO dto) {
		
		try {
			
			
			String sql = "UPDATE TBLACCINFO SET CONTENT = ?, ACCINFODATE = ?, PRICE = ?, LOCATION = ?, SEQACC = ?, SEQREASONCHANGECATEGORY = ?, SEQFIXEDFLUCTUATIONCHECK = ?, SEQDEPOSITWITHDRAWALSTATUS = ?  WHERE SEQ = ?";
	        pstat = conn.prepareStatement(sql);
	        pstat.setString(1, dto.getContent());
	        pstat.setString(2, dto.getAccInfoDate());
	        pstat.setLong(3, dto.getPrice());
	        pstat.setString(4, dto.getLocation());
	        pstat.setInt(5, Integer.parseInt(dto.getSeqAcc()));
	        pstat.setInt(6, Integer.parseInt(dto.getSeqReasonChangeCategory()));
	        pstat.setInt(7, Integer.parseInt(dto.getSeqFixedFluctuationCheck()));
	        pstat.setInt(8, Integer.parseInt(dto.getSeqDepositWithdrawalStatus()));
	        pstat.setInt(9, Integer.parseInt(dto.getSeqAccInfo()));
	        int firstUpdateResult = pstat.executeUpdate();

	        // Second update statement
	        
	        sql = "UPDATE TBLACCCATEGORYLIST SET SEQACCCATEGORY = ? where SEQACCINFO = ?";
	        pstat = conn.prepareStatement(sql);
	        pstat.setInt(1, Integer.parseInt(dto.getSeqAccCategory()));
	        pstat.setInt(2, Integer.parseInt(dto.getSeqAccInfo()));
	        int secondUpdateResult = pstat.executeUpdate();


	        System.out.println("First Update Result: " + firstUpdateResult + ", Second Update Result: " + secondUpdateResult);
	        return firstUpdateResult;

		} catch (Exception e) {
			System.out.println("AccountDAO.updateAcc");
			e.printStackTrace();
		}
		
		
		return 0;
	}

	/**
	 * 가계부를 삭제하는 메서드입니다.
	 * @param dto 삭제할 가계부 정보를 담은 AccountInfoDTO 객체입니다.
	 * @return 삭제 결과를 반환합니다.
	 */
	public int delAcc(AccountInfoDTO dto) {
		
		try {
			String sql = "DELETE FROM TBLACCCATEGORYLIST WHERE SEQACCINFO = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, Integer.parseInt(dto.getSeqAccInfo()));
			int firstdelResult = pstat.executeUpdate();
			
			sql = "DELETE FROM TBLACCINFO WHERE SEQ = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, Integer.parseInt(dto.getSeqAccInfo()));
			
			int seconddelResult = pstat.executeUpdate();
			
			System.out.println("first: "+firstdelResult);
			System.out.println("second: "+seconddelResult);
			
			
			return seconddelResult;
			
			
		} catch (Exception e) {
			System.out.println("AccountDAO.delAcc");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 사용자의 위시리스트를 가져오는 메서드입니다.
	 * @param id 회원 아이디입니다.
	 * @return 사용자의 위시리스트를 담은 ArrayList를 반환합니다.
	 */
	public ArrayList<AccountInfoDTO> mywishlist(String id) {
		ArrayList<AccountInfoDTO> list = new ArrayList<AccountInfoDTO>();
		try {
			String sql = "select PRODUCTNAME as pname from TBLPURCHASEWISHLIST where SEQACC = (select seq from TBLACC where IDMEMBER=?)order by SEQ asc";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				AccountInfoDTO dto = new AccountInfoDTO();
				dto.setProductName(rs.getString("pname"));
				list.add(dto);
			}
			return list;
			
			
			
		} catch (Exception e) {
			System.out.println("AccountDAO.mywishlist");
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	/**
	 * 위시리스트에 항목을 추가하는 메서드입니다.
	 * @param dto 추가할 위시리스트 항목 정보를 담은 AccountInfoDTO 객체입니다.
	 * @return 추가 결과를 반환합니다.
	 */
	public int addlist(AccountInfoDTO dto) {
		
		try {
			
			String sql = "insert into TBLPURCHASEWISHLIST(seq, PRODUCTNAME, SEQACC) values ((SELECT NVL(MAX(seq), 0) + 1 FROM TBLPURCHASEWISHLIST),?,(select seq from TBLACC where IDMEMBER=?))";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getProductName());
			pstat.setString(2, dto.getIdMember());
			
			int firstUpdateResult = pstat.executeUpdate();
			
			System.out.println(firstUpdateResult);
			
			return firstUpdateResult;
			
			
		} catch (Exception e) {
			System.out.println("AccountDAO.addlist");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 위시리스트에서 항목을 삭제하는 메서드입니다.
	 * @param dto 삭제할 위시리스트 항목 정보를 담은 AccountInfoDTO 객체입니다.
	 * @return 삭제 결과를 반환합니다.
	 */
	public int delwishlist(AccountInfoDTO dto) {
		
		try {
			
			String sql = "delete from TBLPURCHASEWISHLIST where PRODUCTNAME = ? and SEQACC = (select seq from TBLACC where IDMEMBER=?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getProductName());
			pstat.setString(2, dto.getIdMember());
			
			int indicate = pstat.executeUpdate();
			
			return indicate;
			
		} catch (Exception e) {
			System.out.println("AccountDAO.delwishlist");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 고정 지출 이벤트를 추가하는 메서드입니다.
	 * @param dto 추가할 고정 지출 이벤트 정보를 담은 AccountInfoDTO 객체입니다.
	 * @return 추가된 고정 지출 이벤트의 시퀀스 번호를 반환합니다.
	 */
	public int fixedevent(AccountInfoDTO dto) {
		try {
			
			String sql = "INSERT INTO TBLFIXEDDEPOSITWITHDRAWALCHECK (SEQ, CONTENT, SEQFIXEDFLUCTUATIONPERIOD) VALUES ((SELECT NVL(MAX(seq), 0) + 1 FROM TBLFIXEDDEPOSITWITHDRAWALCHECK), ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getFdwContent());
			pstat.setString(2, dto.getSeqFixedFluctuationPeriod());
			
			int indicate = pstat.executeUpdate();
			
			sql = "select seq from TBLFIXEDDEPOSITWITHDRAWALCHECK where content = ?";
			
			pstat= conn.prepareStatement(sql);
			pstat.setString(1, dto.getFdwContent());
			
			rs =pstat.executeQuery();
			int seqreturn =0;
			if(rs.next()) {
				seqreturn = rs.getInt("seq");
			}
			
			System.out.println("fixed finsih");
			return seqreturn;
			
			
		} catch (Exception e) {
			System.out.println("AccountDAO.fixedevent");
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 변경 사유 카테고리를 생성하는 메서드입니다.
	 * @param paycontentseq 변경 사유 목록의 시퀀스 번호입니다.
	 * @param cardNum 카드 번호입니다.
	 * @return 생성 결과를 반환합니다.
	 */
	public int makercc(int paycontentseq, String cardNum) {
		try {
			
			String sql;
			String cardSeq = null;
			
			if(cardNum != null) {
				sql = "select SEQ from TBLMYCARD where CARDNUMBER=?";
				
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, cardNum);
				
				rs = pstat.executeQuery();
				
				if(rs.next()) {
					cardSeq = rs.getString("seq");
					System.out.println("cardseq: "+cardSeq );
                }
            }
			if(cardSeq != null) {
                sql = "INSERT INTO TBLREASONCHANGECATEGORY (SEQ, SEQREASONSCHANGELIST, SEQMYCARD) VALUES ((SELECT NVL(MAX(seq), 0) + 1 FROM TBLREASONCHANGECATEGORY), ?, ?)";
                pstat = conn.prepareStatement(sql);
                pstat.setInt(1, paycontentseq);
                pstat.setInt(2, Integer.parseInt(cardSeq));
            } else {
                sql = "INSERT INTO TBLREASONCHANGECATEGORY (SEQ, SEQREASONSCHANGELIST, SEQMYCARD) VALUES ((SELECT NVL(MAX(seq), 0) + 1 FROM TBLREASONCHANGECATEGORY), ?, null)";
                pstat = conn.prepareStatement(sql);
                pstat.setInt(1, paycontentseq);
            }
            
            int indicate = pstat.executeUpdate();            
            
            System.out.println("rcc finsih");
            return indicate;
            
        } catch (Exception e) {
            System.out.println("AccountDAO.makercc");
            e.printStackTrace();
        }
        
        
        return 0;
    }

    /**
     * 중복 이벤트를 처리하는 메서드입니다.
     * @param dto 중복 이벤트 정보를 담은 AccountInfoDTO 객체입니다.
     * @return 처리 결과를 반환합니다.
     */
    public int dupEvent(AccountInfoDTO dto) {
        
        try {
            
            System.out.println("dup start");
            String sql = "select seq from tblaccinfo where SEQFIXEDFLUCTUATIONCHECK = ?";
            
            pstat = conn.prepareStatement(sql);
            pstat.setInt(1, Integer.parseInt(dto.getSeqFixedFluctuationCheck()));
            
            rs = pstat.executeQuery();
            
            if(rs.next()) {
                dto.setSeqAccInfo(String.valueOf(rs.getInt("seq")));
            }
            sql = "select SEQREASONCHANGECATEGORY from tblaccinfo where SEQFIXEDFLUCTUATIONCHECK = ?";
            
            pstat = conn.prepareStatement(sql);
            pstat.setInt(1, Integer.parseInt(dto.getSeqFixedFluctuationCheck()));
            
            rs = pstat.executeQuery();
            
            if(rs.next()) {
                dto.setSeqReasonChangeCategory(String.valueOf(rs.getInt("SEQREASONCHANGECATEGORY")));
            }
            
            sql ="call insert_interval_entries(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstat = conn.prepareStatement(sql);
            
            pstat.setInt(1,Integer.parseInt(dto.getSeqAccInfo()));            
            pstat.setString(2, dto.getContent());
            String dateString = dto.getAccInfoDate();
            java.sql.Date sqlDate = java.sql.Date.valueOf(dateString);
            System.out.println("sqlDate: "+sqlDate);
            pstat.setDate(3, sqlDate);
            pstat.setLong(4, dto.getPrice());
            pstat.setString(5, dto.getLocation());
            pstat.setInt(6, Integer.parseInt(dto.getSeqAcc()));
            pstat.setInt(7, Integer.parseInt(dto.getSeqReasonChangeCategory()));
            pstat.setInt(8, Integer.parseInt(dto.getSeqFixedFluctuationCheck()));
            pstat.setInt(9, Integer.parseInt(dto.getSeqDepositWithdrawalStatus()));
            pstat.setInt(10, Integer.parseInt(dto.getSeqAccCategory()));
            int indicate = pstat.executeUpdate();            
            System.out.println("proc indicate: "+indicate);
            
            return indicate;
            
        } catch (Exception e) {
            System.out.println("AccountDAO.dupEvent");
            e.printStackTrace();
        }
        
        return 0;
    }
  
}