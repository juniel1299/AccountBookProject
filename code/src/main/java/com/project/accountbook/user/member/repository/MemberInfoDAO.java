package com.project.accountbook.user.member.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.project.accountbook.account.model.AccountInfoDTO;
import com.project.accountbook.card.model.CardDTO;
import com.project.accountbook.user.member.model.MemberInfoDTO;
import com.project.accountbook.user.model.UserDTO;
import com.project.accountbook.util.DBUtil;

/**
* 회원 정보와 관련된 데이터베이스 작업을 수행하는 DAO 클래스입니다.
*/
public class MemberInfoDAO {
   private Connection conn;
   private Statement stat;
   private PreparedStatement pstat;
   private ResultSet rs;

   /**
    * MemberInfoDAO 생성자입니다.
    * 데이터베이스 연결을 설정합니다.
    */
   public MemberInfoDAO() {
       this.conn = DBUtil.open("125.241.245.222", "webproject", "java1234");
   }

   /**
    * 나의 카드를 추가하는 메서드입니다.
    * @param dto 추가할 카드 정보를 담은 MemberInfoDTO 객체입니다.
    * @return 추가 결과를 반환합니다.
    */
   public int addMycard(MemberInfoDTO dto) {
       try {
           String sql = "insert into tblMyCard (seq, cardNumber, alias, validity, idMember, seqCardInformation) values (seqMyCard.nextVal, ?, ?, ?, ?)";
           pstat = conn.prepareStatement(sql);
           pstat.setString(1, dto.getCardNumber());
           pstat.setString(2, dto.getAlias());
           pstat.setString(3, dto.getValidity());
           pstat.setString(4, dto.getMcIdMember());
           pstat.setString(5, dto.getSeqCardInformation());

           pstat.executeUpdate();
       } catch (Exception e) {
           System.out.println("CardDAO.addMyCard");
           e.printStackTrace();
       }

       return 0;
   }

   /**
    * 나의 카드를 삭제하는 메서드입니다.
    * @param dto 삭제할 카드 정보를 담은 MemberInfoDTO 객체입니다.
    * @return 삭제 결과를 반환합니다.
    */
   public int delMyCard(MemberInfoDTO dto) {
       try {
           String sql = "update tblMyCard set cardNumber = 'xxxxxxxxxxxxxxxx' where cardnumber = ?";
           pstat = conn.prepareStatement(sql);
           pstat.setString(1, dto.getCardNumber());

           pstat.executeUpdate();
       } catch (Exception e) {
           System.out.println("CardDAO.delMyCard");
           e.printStackTrace();
       }
       return 0;
   }

   /**
    * 나의 카드를 수정하는 메서드입니다.
    * @param dto 수정할 카드 정보를 담은 MemberInfoDTO 객체입니다.
    * @return 수정 결과를 반환합니다.
    */
   public int updateMyCard(MemberInfoDTO dto) {
       try {
           String sql = "update tblMyCard set alias = ? where cardnumber = ?";
           pstat = conn.prepareStatement(sql);
           pstat.setString(1, dto.getAlias());
           pstat.setString(2, dto.getCardNumber());

           pstat.executeUpdate();
       } catch (Exception e) {
           System.out.println("CardDAO.updateMyCard");
           e.printStackTrace();
       }

       return 0;
   }

   /**
    * 나의 카드 정보를 가져오는 메서드입니다.
    * @param cardNumber 카드 번호입니다.
    * @return 나의 카드 정보를 담은 MemberInfoDTO 객체를 반환합니다.
    */
   public MemberInfoDTO getMyCard(String cardNumber) {
       try {
           String sql = "select * from tblMyCard where cardnumber = ?";
           pstat = conn.prepareStatement(sql);
           pstat.setString(1, cardNumber);

           rs = pstat.executeQuery(sql);

           if (rs.next()) {
               MemberInfoDTO dto = new MemberInfoDTO();
               dto.setAlias(rs.getString("alias"));
               dto.setValidity(rs.getString("validity"));
               dto.setMcIdMember(rs.getString("McIdMember"));
               dto.setSeqCardInformation(rs.getString("seqCardInformation"));

               return dto;
           }
       } catch (Exception e) {
           e.printStackTrace();
       }

       return null;
   }

   /**
    * 나의 카드 목록을 가져오는 메서드입니다.
    * @param McIdMember 회원 ID입니다.
    * @return 나의 카드 목록을 담은 ArrayList를 반환합니다.
    */
   public ArrayList<MemberInfoDTO> listMyCard(String McIdMember) {
       try {
           String sql = "select * from tblmycard where idMember = ?";
           pstat = conn.prepareStatement(sql);
           pstat.setString(1, McIdMember);

           rs = pstat.executeQuery();

           ArrayList<MemberInfoDTO> list = new ArrayList<MemberInfoDTO>();

           while (rs.next()) {
               MemberInfoDTO dto = new MemberInfoDTO();
               dto.setCardNumber(rs.getString("cardNumber"));
               dto.setAlias(rs.getString("alias"));
               dto.setValidity(rs.getString("validity"));
               dto.setMcIdMember(rs.getString("mcIdMember"));
               dto.setExplanation(rs.getString("seqCardInformation"));

               list.add(dto);
           }
           return list;
       } catch (Exception e) {
           e.printStackTrace();
       }
       return null;
   }

   /**
    * 회원 정보를 가져오는 메서드입니다.
    * @param id 회원 ID입니다.
    * @return 회원 정보를 담은 UserDTO 객체를 반환합니다.
    */
   public UserDTO getMemberInfo(String id) {
       try {
           String sql = "select * from tblMember m\r\n"
                   + "left outer join tblProfileimg p \r\n"
                   + "on m.seqProfileimg = p.seq\r\n"
                   + "where m.id = ?";

           pstat = conn.prepareStatement(sql);
           pstat.setString(1, id);

           rs = pstat.executeQuery();

           if (rs.next()) {
               UserDTO dto = new UserDTO();
               dto.setFileLink(rs.getString("fileLink"));
               dto.setName(rs.getString("name"));
               dto.setNickname(rs.getString("nickname"));
               dto.setGender(rs.getString("gender"));
               dto.setPhoneNumber(rs.getString("phoneNumber"));
               dto.setSsn(rs.getString("SSN"));

               return dto;
           }
       } catch (Exception e) {
           e.printStackTrace();
       }

       return null;
   }

   /**
    * 프로필 이미지를 수정하는 메서드입니다.
    * @param id 회원 ID입니다.
    * @param img 수정할 이미지 링크입니다.
    */
   public void editImg(String id, String img) {
       try {
           String sql = "update tblProfileimg set fileLink = ?"
                   + "where seq = (select seqProfileimg from tblMember where id = ?)";

           pstat = conn.prepareStatement(sql);
           pstat.setString(1, img);
           pstat.setString(2, id);

           pstat.executeUpdate();
       } catch (Exception e) {
           System.out.println("MemberInfoDAO.editImg");
           e.printStackTrace();
       }
   }

   /**
    * 비밀번호를 재설정하는 메서드입니다.
    * @param id 회원 ID입니다.
    * @param pw 새로운 비밀번호입니다.
    */
   public void resetPw(String id, String pw) {
       try {
           String sql = "update tblMember set pw = ? where id = ?";

           System.out.println(id);
           System.out.println(pw);

           pstat = conn.prepareStatement(sql);
           pstat.setString(1, pw);
           pstat.setString(2, id);

           pstat.executeUpdate();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }

   /**
    * 비밀번호를 가져오는 메서드입니다.
    * @param id 회원 ID입니다.
    * @return 비밀번호를 반환합니다.
    */
   public String getPw(String id) {
       try {
           String sql = "select pw from tblMember where id =?";

           pstat = conn.prepareStatement(sql);
           pstat.setString(1, id);
           pstat.executeUpdate();

           rs = pstat.executeQuery();

           if (rs.next()) {
               return rs.getString("pw");
           }
       } catch (Exception e) {
           e.printStackTrace();
       }

       return null;
   }

   /**
    * 비밀번호를 수정하는 메서드입니다.
    * @param id 회원 ID입니다.
    * @param pw 수정할 비밀번호입니다.
    */
   public void editPw(String id, String pw) {
       try {
           String sql = "update tblMember set pw = ? where id = ?";

           pstat = conn.prepareStatement(sql);
           pstat.setString(1, pw);
           pstat.setString(2, id);

           pstat.executeUpdate();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }

   /**
    * 전화번호를 가져오는 메서드입니다.
    * @param id 회원 ID입니다.
    * @return 전화번호를 반환합니다.
    */
   public String getPhoneNumber(String id) {
       try {
           String sql = "select phonenumber from tblMember where id = ?";

           pstat = conn.prepareStatement(sql);
           pstat.setString(1, id);

           rs = pstat.executeQuery();

           if (rs.next()) {
               return rs.getString("phonenumber");
           }
       } catch (Exception e) {
           System.out.println("MemberInfoDAO.getPhoneNumber");
           e.printStackTrace();
       } finally {
           try {
               if (rs != null) {
                   rs.close();
               }
               if (pstat != null) {
                   pstat.close();
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }

       return null;
   }

   /**
    * 회원 정보를 업데이트하는 메서드입니다.
    * @param id 회원 ID입니다.
    * @param map 업데이트할 회원 정보를 담은 HashMap입니다.
    */
   public void updateUserInfo(String id, HashMap<String, String> map) {
       try {
           String sql = "update tblMember set name = ?, nickname = ?, phonenumber = ?"
                   + " where id = ?";

           pstat = conn.prepareStatement(sql);

           pstat.setString(1, map.get("name"));
           pstat.setString(2, map.get("nickname"));
           pstat.setString(3, map.get("phonenumber"));
           pstat.setString(4, id);

           pstat.executeUpdate();

           System.out.println("update");
       } catch (Exception e) {
           System.out.println("MemberInfoDAO.updateUserInfo");
           e.printStackTrace();
       }
   }

   /**
    * 전화번호의 중복 여부를 확인하는 메서드입니다.
    * @param phoneNumber 중복 확인할 전화번호입니다.
    * @param id 회원 ID입니다.
    * @return 전화번호의 중복 여부를 반환합니다.
    */
   public boolean isPhoneNumberUnique(String phoneNumber, String id) {
       try {
           String sql = "SELECT COUNT(*) AS count FROM tblMember WHERE phonenumber = ? AND id != ?";

           pstat = conn.prepareStatement(sql);
           pstat.setString(1, phoneNumber);
           pstat.setString(2, id);
           rs = pstat.executeQuery();

           if (rs.next()) {
               int count = rs.getInt("count");
               return count == 0;
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       // 오류가 발생하거나 결과가 없는 경우에는 일단 중복이 아니라고 간주
       System.out.println("번호 중복값 존재");
       return true;
   }

   /**
    * 챌린지 정보를 가져오는 메서드입니다.
    * @param id 회원 ID입니다.
    * @return 챌린지 정보를 담은 ArrayList를 반환합니다.
    */
   public ArrayList<MemberInfoDTO> getChallengeInfo(String id) {
       ArrayList<MemberInfoDTO> list = new ArrayList<>();

       try {
           String sql = "select s.monthlyPaycheck as m, s.savingsGoals as s, sp.period as p\r\n"
                   + "from tblMember m\r\n"
                   + "    inner join tblSurvey s\r\n"
                   + "        on m.seqSurvey = s.seq\r\n"
                   + "            inner join tblSavingsPeriod sp\r\n"
                   + "                on sp.seq = s.seqSavingsPeriod\r\n"
                   + "                    where id = ?";

           pstat = conn.prepareStatement(sql);
           pstat.setString(1, id);
           rs = pstat.executeQuery();

           while (rs.next()) {
               MemberInfoDTO dto = new MemberInfoDTO();

               dto.setMonthlyPaycheck(rs.getInt("m"));
               dto.setSavingsGoals(rs.getInt("s"));
               dto.setSavingPeriod(rs.getInt("p"));

               list.add(dto);
           }
           return list;
       } catch (Exception e) {
           System.out.println("MemberInfoDAO.getChallengeInfo");
           e.printStackTrace();
       }

       return null;
   }

   /**
    * 월급을 수정하는 메서드입니다.
    * @param id 회원 ID입니다.
    * @param sallary 수정할 월급입니다.
   * @return 수정 결과를 반환합니다.
   */
   public MemberInfoDTO editSallary(String id, String sallary) {
   try {
   String sql = "UPDATE tblSurvey SET monthlyPaycheck = ? WHERE seq = (SELECT seqSurvey FROM tblMember where id = ?)";
   pstat = conn.prepareStatement(sql);

   pstat.setString(1, sallary);
   pstat.setString(2, id);

   pstat.executeUpdate();
} catch (Exception e) {
   System.out.println("MemberInfoDAO.editSallary");
   e.printStackTrace();
}

return null;
}

/**
* 저축 목표를 수정하는 메서드입니다.
* @param id 회원 ID입니다.
* @param goal 수정할 저축 목표입니다.
* @return 수정 결과를 반환합니다.
*/
public MemberInfoDTO editGoal(String id, String goal) {
try {
   String sql = "UPDATE tblSurvey SET savingsGoals = ? WHERE seq = (SELECT seqSurvey FROM tblMember where id = ?)";

   pstat = conn.prepareStatement(sql);

   pstat.setString(1, goal);
   pstat.setString(2, id);

   pstat.executeUpdate();
} catch (Exception e) {
   System.out.println("MemberInfoDAO.editSallary");
   e.printStackTrace();
}

return null;
}

/**
* 저축 기간을 수정하는 메서드입니다.
* @param id 회원 ID입니다.
* @param period 수정할 저축 기간입니다.
* @return 수정 결과를 반환합니다.
*/
public MemberInfoDTO editPeriod(String id, String period) {
try {
   String sql = "UPDATE tblSavingsPeriod set period = ?"
           + "where seq = (SELECT s.seqSavingsPeriod"
           + "            from tblSurvey s inner join tblMember m"
           + "                on s.seq = m.seqSurvey"
           + "                    where m.id= ?)";

   System.out.println(period);
   pstat = conn.prepareStatement(sql);

   pstat.setString(1, period);
   pstat.setString(2, id);

   pstat.executeUpdate();
   System.out.println("저축 목표 기간 수정 성공");
} catch (Exception e) {
   System.out.println("MemberInfoDAO.editSallary");
   e.printStackTrace();
}

return null;
}

/**
* 나의 카드 목록을 가져오는 메서드입니다.
* @param id 회원 ID입니다.
* @return 나의 카드 목록을 담은 ArrayList를 반환합니다.
*/
public ArrayList<MemberInfoDTO> getMyCards(String id) {
ArrayList<MemberInfoDTO> list = new ArrayList<>();

try {
   String sql = "select ci.name as name, ci.cardCompany as cardCompany , mc.alias as alias"
           + ", mc.cardNumber as cardNumber , mc.validity as validity, ci.fileLink as fileLink, mc.seq as seq\r\n"
           + "from tblMyCard mc inner join tblMember m\r\n"
           + "    on mc.idMember = m.id\r\n"
           + "        inner join tblCardInformation ci\r\n"
           + "            on mc.seqCardInformation = ci.seq\r\n"
           + "where m.id = ?";
   pstat = conn.prepareStatement(sql);
   pstat.setString(1, id);

   rs = pstat.executeQuery();

   while (rs.next()) {
       MemberInfoDTO dto = new MemberInfoDTO();

       dto.setSeqMyCard(rs.getInt("seq"));
       dto.setName(rs.getString("name"));
       dto.setCardCompany(rs.getString("cardCompany"));
       dto.setAlias(rs.getString("alias"));
       dto.setCardNumber(rs.getString("cardNumber"));
       dto.setValidity(rs.getString("validity"));
       dto.setFileLink(rs.getString("fileLink"));
       dto.setSeqMyCard(rs.getInt("seq"));

       list.add(dto);
   }
   System.out.println(list);
   return list;
} catch (Exception e) {
   System.out.println("MemberInfoDAO.getMyCards");
   e.printStackTrace();
}

return null;
}

/**
* 나의 카드를 추가하는 메서드입니다.
* @param id 회원 ID입니다.
* @param dto 추가할 카드 정보를 담은 CardDTO 객체입니다.
*/
public void addMyCard(String id, CardDTO dto) {
try {
   String sql = "select seq from tblCardInformation where name = ? and cardcompany = ?";

   pstat = conn.prepareStatement(sql);

   pstat.setString(1, dto.getCiName());
   pstat.setString(2, dto.getCardCompany());
   rs = pstat.executeQuery();

   if (rs.next()) {
       dto.setSeq(rs.getInt("seq"));
   }

   sql = "insert into tblMyCard \r\n"
           + "(seq, cardNumber, alias, validity, idMember, seqCardInformation)\r\n"
           + "values ((SELECT NVL(MAX(seq), 0) + 1 FROM tblMyCard), ?, ?, ?, ?, ?)";

   pstat = conn.prepareStatement(sql);
   pstat.setString(1, dto.getCardNumber());
   pstat.setString(2, dto.getAlias());
   pstat.setString(3, dto.getEnddate());
   pstat.setString(4, id);
   pstat.setInt(5, dto.getSeq());

   int indicate = pstat.executeUpdate();

   System.out.println("result: " + indicate);
} catch (Exception e) {
   System.out.println("MemberInfoDAO.addMycard");
   e.printStackTrace();
}
}

/**
* 나의 카드를 삭제하는 메서드입니다.
* @param id 회원 ID입니다.
* @param seq 삭제할 카드의 시퀀스 번호입니다.
* @return 삭제 결과를 반환합니다.
*/
public MemberInfoDTO delMyCard(String id, String seq) {
try {
   String sql = "DELETE FROM tblMyCard WHERE idMember = ? AND seq = ?";

   pstat = conn.prepareStatement(sql);
   pstat.setString(1, id);
   pstat.setString(2, seq);

   pstat.executeUpdate();
} catch (Exception e) {
   System.out.println("MemberInfoDTO: delMyCard");
   e.printStackTrace();
}

return null;
}
}