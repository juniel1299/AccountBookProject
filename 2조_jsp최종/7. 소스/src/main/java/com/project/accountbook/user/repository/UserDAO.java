package com.project.accountbook.user.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.project.accountbook.board.post.model.PostDTO;
import com.project.accountbook.user.model.UserDTO;
import com.project.accountbook.util.DBUtil;

/**
 * 사용자 관련 데이터베이스 작업을 수행하는 DAO 클래스입니다.
 */
public class UserDAO {
    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    /**
     * UserDAO 생성자입니다.
     * 데이터베이스 연결을 설정합니다.
     */
    public UserDAO() {
        this.conn = DBUtil.open("125.241.245.222", "webproject", "java1234");
    }

    /**
     * 비밀번호 찾기 시 회원 정보를 확인하는 메서드입니다.
     * @param id 사용자의 아이디입니다.
     * @param name 사용자의 이름입니다.
     * @return 회원 정보 확인 결과를 반환합니다.
     */
    public int checkId(String id, String name) {
        try {
            String sql = "select\r\n" + "count(*) count\r\n" + "from tblMember\r\n" + "where id = ?\r\n"
                    + "and name = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, id);
            pstat.setString(2, name);
            rs = pstat.executeQuery();

            if (rs.next()) {
                return rs.getInt("count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 비밀번호 찾기 시 이메일을 전송하는 메서드입니다.
     * @param id 사용자의 아이디입니다.
     * @param name 사용자의 이름입니다.
     * @return 이메일 전송 결과를 반환합니다.
     */
    public static int gmailSend(String id, String name) {
        String user = "6udget6uddy@gmail.com"; // email
        String password = "jwtz zegm lhdz vmuf";// 패스워드

        // SMTP 서버 정보를 설정한다.
        Properties prop = new Properties();

        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", 587);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

        // SMaTP 서버 정보와 사용자 정보를 기반으로 Session 클래스의 인스턴스를 생성
        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));

            // 받는 이메일
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(id));

            // Subject
            message.setSubject("[BudgetBuddy] 비밀번호 재설정 안내"); // 메일 제목을 입력

            String resetLink = "http://localhost:8090/account/user/member/reset-pw.do?id=" + id;
            String emailContent = "비밀번호를 재설정하려면 아래 링크를 클릭하세요.\r\n\r\n" + resetLink;
            message.setText(emailContent);

            // send the message
            Transport.send(message); //// 전송
            System.out.println("message sent successfully...");

            return 1;

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return 0;
    }

    /**
     * 회원 로그인을 처리하는 메서드입니다.
     * @param dto 로그인 정보를 담은 UserDTO 객체입니다.
     * @return 로그인 결과를 반환합니다.
     */
    public UserDTO login(UserDTO dto) {
        try {
            String sql = "SELECT m.*, mp.seqPriv FROM tblMember m "
                    + "INNER JOIN tblMemberPriv mp ON m.id = mp.idMember "
                    + "WHERE m.id = ? AND m.pw = ? AND mp.seqPriv = 2";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, dto.getId());
            pstat.setString(2, dto.getPw());
            rs = pstat.executeQuery();

            if (rs.next()) {
                UserDTO result = new UserDTO();
                result.setId(rs.getString("id"));
                result.setName(rs.getString("name"));
                result.setSeqPriv(rs.getString("seqPriv"));
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 관리자 로그인을 처리하는 메서드입니다.
     * @param dto 로그인 정보를 담은 UserDTO 객체입니다.
     * @return 로그인 결과를 반환합니다.
     */
    public UserDTO loginAdmin(UserDTO dto) {
        try {
            String sql = "SELECT a.*, ap.seqPriv FROM tblAdmin a " +
                         "INNER JOIN tblAdminPriv ap ON a.id = ap.idAdmin " +
                         "WHERE a.id = ? AND a.pw = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, dto.getId());
            pstat.setString(2, dto.getPw());
            rs = pstat.executeQuery();

            if (rs.next()) {
                UserDTO result = new UserDTO();
                result.setId(rs.getString("id"));
                result.setSeqPriv(rs.getString("seqPriv"));
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 회원 탈퇴를 처리하는 메서드입니다.
     * @param id 탈퇴할 회원의 아이디입니다.
     * @param pw 탈퇴할 회원의 비밀번호입니다.
     * @return 탈퇴 결과를 반환합니다.
     */
    public int unregister(String id, String pw) {
        try {
            // 트랜잭션 시작
            conn.setAutoCommit(false);

            String sql = "SELECT COUNT(*) FROM tblMember WHERE id = ? AND pw = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, id);
            pstat.setString(2, pw);
            rs = pstat.executeQuery();

            if (rs.next() && rs.getInt(1) == 1) {
                sql = "UPDATE tblMember SET pw = '0000', name = '탈퇴' WHERE id = ?";
                pstat = conn.prepareStatement(sql);
                pstat.setString(1, id);
                pstat.executeUpdate();

                sql = "UPDATE tblMemberPriv SET seqPriv = 4 WHERE idMember = ?";
                pstat = conn.prepareStatement(sql);
                pstat.setString(1, id);
                pstat.executeUpdate();

                // 트랜잭션 커밋
                conn.commit();
                return 1;
            } else {
                // 트랜잭션 롤백
                conn.rollback();
                return 0;
            }
        } catch (Exception e) {
            // 트랜잭션 롤백
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("MemberInfoDAO.unregister");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstat != null)
                    pstat.close();
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    /**
     * 아이디를 찾는 메서드입니다.
     * @param name 사용자의 이름입니다.
     * @param ssn 사용자의 주민등록번호입니다.
     * @return 찾은 아이디를 반환합니다.
     */
    public String findId(String name, String ssn) {
        try {
            String sql = "SELECT id FROM tblMember WHERE name = ? AND ssn = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, name);
            pstat.setString(2, ssn);
            rs = pstat.executeQuery();

            System.out.println("SQL Query: " + sql);
            System.out.println("Name: " + name);
            System.out.println("SSN: " + ssn);

            if (rs.next()) {
                String foundId = rs.getString("id");
                System.out.println("Found ID: " + foundId);
                return foundId;
            } else {
                System.out.println("No matching ID found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstat != null)
                    pstat.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 계정을 생성하는 메서드입니다.
     * @param dto 계정 정보를 담은 UserDTO 객체입니다.
     * @return 계정 생성 결과를 반환합니다.
     */
    public int register(UserDTO dto) {
        try {
            // tblSurvey 데이터 삽입
            String sql = "INSERT INTO tblSurvey (seq, monthlyPaycheck, savingsGoals, seqCompressionIntensity, seqSavingsPeriod) " +
                         "VALUES (seqSurvey.NEXTVAL, ?, ?, ?, ?)";
            pstat = conn.prepareStatement(sql);
            if (dto.getSeqCompressionIntensity() != null && dto.getSeqSavingsPeriod() != null) {
                pstat.setInt(1, dto.getMonthlyPaycheck());
                pstat.setInt(2, dto.getSavingsGoals());
                pstat.setString(3, dto.getSeqCompressionIntensity());
                pstat.setString(4, dto.getSeqSavingsPeriod());
                System.out.println("tblSurvey 데이터 삽입 (사용자 입력 값)");
            } else {
                pstat.setInt(1, 0);
                pstat.setInt(2, 0);
                pstat.setString(3, "1");
                pstat.setString(4, "1");
                System.out.println("tblSurvey 데이터 삽입 (기본값)");
            }
            int surveyResult = pstat.executeUpdate();
            System.out.println("tblSurvey 데이터 삽입 결과: " + surveyResult);

            // seq 값 가져오기
            sql = "SELECT seqSurvey.CURRVAL FROM DUAL";
            pstat = conn.prepareStatement(sql);
            rs = pstat.executeQuery();
            int seq = 0;
            if (rs.next()) {
                seq = rs.getInt(1);
                System.out.println("seq 값: " + seq);
            }

            // tblMember 데이터 삽입
            sql = "INSERT INTO tblMember (id, pw, name, nickname, phoneNumber, ssn, gender, reportCount, joinDate, seqSurvey, seqProfileimg) " +
                  "VALUES (?, ?, ?, ?, ?, ?, ?, 0, SYSDATE, ?, 1)";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, dto.getId());
            pstat.setString(2, dto.getPw());
            pstat.setString(3, dto.getName());
            pstat.setString(4, dto.getNickname());
            pstat.setString(5, dto.getPhoneNumber());
            pstat.setString(6, dto.getSsn());
            pstat.setString(7, dto.getGender());
            pstat.setInt(8, seq);
            int result = pstat.executeUpdate();
            System.out.println("tblMember 데이터 삽입 결과: " + result);

            if (result == 1) {
                // tblMemberPriv 데이터 삽입
                sql = "INSERT INTO tblMemberPriv (seq, seqPriv, idMember) " +
                      "VALUES (seqMemberPriv.NEXTVAL, 2, ?)";
                
                
                pstat = conn.prepareStatement(sql);
                pstat.setString(1, dto.getId());
                int privResult = pstat.executeUpdate();
                System.out.println("tblMemberPriv 데이터 삽입 결과: " + privResult);
            
             // tblUser 데이터 삽입
                sql = "INSERT INTO tblUser (seq, idMember) " +
                        "VALUES (seqUser.NEXTVAL, ?)";
                pstat = conn.prepareStatement(sql);
                pstat.setString(1, dto.getId());
                int userResult = pstat.executeUpdate();
                System.out.println("tblUser 데이터 삽입 결과: " + userResult);
            }
            

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 아이디의 중복 여부를 확인하는 메서드입니다.
     * @param id 중복 확인할 아이디입니다.
     * @return 중복 여부를 반환합니다.
     */
    public boolean isIdDuplicate(String id) {
        try {
            String sql = "SELECT COUNT(*) FROM tblMember WHERE id = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, id);
            rs = pstat.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 닉네임의 중복 여부를 확인하는 메서드입니다.
     * @param nickname 중복 확인할 닉네임입니다.
     * @return 중복 여부를 반환합니다.
     */
    public boolean isNicknameDuplicate(String nickname) {
        try {
            String sql = "SELECT COUNT(*) FROM tblMember WHERE nickname = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, nickname);
            rs = pstat.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 전화번호의 중복 여부를 확인하는 메서드입니다.
     * @param phoneNumber 중복 확인할 전화번호입니다.
     * @return 중복 여부를 반환합니다.
     */
    public boolean isPhoneNumberDuplicate(String phoneNumber) {
        try {
            String sql = "SELECT COUNT(*) FROM tblMember WHERE phoneNumber = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, phoneNumber);
            rs = pstat.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 주민등록번호의 중복 여부를 확인하는 메서드입니다.
     * @param ssn 중복 확인할 주민등록번호입니다.
     * @return 중복 여부를 반환합니다.
     */
    public boolean isSsnDuplicate(String ssn) {
        try {
            String sql = "SELECT COUNT(*) FROM tblMember WHERE ssn = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, ssn);
            rs = pstat.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * API 키 값을 불러오는 메서드입니다.
     * @param seq API의 시퀀스 번호입니다.
     * @return API 키 값을 담은 HashMap을 반환합니다.
     */
    public HashMap<String, String> getAPIKey(String seq) {
        try {
            String sql = "select \r\n" + "*\r\n" + "from tblAPI\r\n" + "where seq = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seq);

            rs = pstat.executeQuery();

            HashMap<String, String> map = new HashMap<String, String>();

            while (rs.next()) {
                map.put("name", rs.getString("name"));
                map.put("key", rs.getString("key"));
            }

            return map;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 사용자가 작성한 게시글 목록을 가져오는 메서드입니다.
     * @param id 사용자의 아이디입니다.
     * @return 사용자가 작성한 게시글 목록을 담은 ArrayList를 반환합니다.
     */
    public ArrayList<PostDTO> getMyPosts(String id) {
        ArrayList<PostDTO> plist = new ArrayList<>();

        try {
            String sql = "select p.title, m.nickname, p.writeDate, p.viewCount, p.likeCount, p.seq\r\n"
                    + " from tblUser u inner join tblPost p\r\n"
                    + "    on u.seq = p.seqUser\r\n"
                    + "       inner join tblMember m\r\n"
                    + "           on u.idMember = m.id\r\n"
                    + "              where id = ?"; 

            
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, id);

            rs = pstat.executeQuery();

            while (rs.next()) {
                PostDTO dto = new PostDTO();

                dto.setTitle(rs.getString("title"));
                dto.setMe_nickName(rs.getString("nickname"));
                dto.setWriteDate(rs.getString("writeDate"));
                dto.setViewCount(rs.getInt("viewCount"));
                dto.setLikeCount(rs.getInt("likeCount"));
                dto.setSeq(rs.getString("seq"));

                plist.add(dto);
            }

            return plist;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 사용자가 작성한 댓글 목록을 가져오는 메서드입니다.
     * @param id 사용자의 아이디입니다.
     * @return 사용자가 작성한 댓글 목록을 담은 ArrayList를 반환합니다.
     */
    public ArrayList<HashMap<String, String>> getMyComments(String id) {
        ArrayList<HashMap<String, String>> commentsList = new ArrayList<>();

        try {
            String sql = "SELECT p.title, p.seq, c.content, m.nickname, p.writedate, p.viewCount, p.likeCount " +
                         "FROM tblPost p " +
                         "INNER JOIN tblComments c ON p.seq = c.seqPost " +
                         "INNER JOIN tblUser u ON u.seq = c.seqUser " +
                         "INNER JOIN tblMember m ON u.idMember = m.id " +
                         "WHERE m.id = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, id);

            rs = pstat.executeQuery();

            while (rs.next()) {
                HashMap<String, String> map = new HashMap<>();
                map.put("title", rs.getString("title"));
                map.put("seq", String.valueOf(rs.getInt("seq")));
                
                if(rs.getString("content").length() > 250) {
                    map.put("content", rs.getString("content").substring(0, 250)+" ...");
                } else {
                    map.put("content", rs.getString("content"));
                }
                
                map.put("nickname", rs.getString("nickname"));              
                map.put("writedate", rs.getString("writedate"));
                map.put("viewCount", String.valueOf(rs.getInt("viewCount")));
                map.put("likeCount", String.valueOf(rs.getInt("likeCount")));
                commentsList.add(map);
            }

            return commentsList;

        } catch (Exception e) {
            System.out.println("UserDAO.getMyComments");
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 회원 아이디를 통해 tblUser의 시퀀스 번호를 가져오는 메서드입니다.
     * @param memberId 회원의 아이디입니다.
     * @return tblUser의 시퀀스 번호를 반환합니다.
     */
    public int getSeqUserByMemberId(String memberId) {
        try {
            String sql = "SELECT seq FROM tblUser WHERE idMember = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, memberId);
            rs = pstat.executeQuery();

            if (rs.next()) {
                return rs.getInt("seq");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 사용자가 작성한 게시글의 총 개수를 가져오는 메서드입니다.
     * @param id 사용자의 아이디입니다.
     * @return 사용자가 작성한 게시글의 총 개수를 반환합니다.
     */
    public int getTotalCount(String id) {
        try {
            String sql = "select count(*) as cnt\r\n"
                    + " from tblUser u inner join tblPost p\r\n"
                    + "    on u.seq = p.seqUser\r\n"
                    + "       inner join tblMember m\r\n"
                    + "           on u.idMember = m.id\r\n"
                    + "              where id = ?"; 
            
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, id);
            rs = pstat.executeQuery();
            
            if(rs.next()) {
                return rs.getInt("cnt");
            }
        } catch (Exception e) {
            System.out.println("UserDAO.getTotalCount");
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 사용자가 작성한 댓글의 총 개수를 가져오는 메서드입니다.
     * @param id 사용자의 아이디입니다.
     * @return 사용자가 작성한 댓글의 총 개수를 반환합니다.
     */
    public int getTotalcommentNum(String id) {
        try {
            String sql = "SELECT count(*) as cnt " +
                    "FROM tblPost p " +
                    "INNER JOIN tblComments c ON p.seq = c.seqPost " +
                    "INNER JOIN tblUser u ON u.seq = c.seqUser " +
                    "INNER JOIN tblMember m ON u.idMember = m.id " +
                    "WHERE m.id = ?";
            
            pstat = conn.prepareStatement(sql);
            
            pstat.setString(1, id);
            
            rs = pstat.executeQuery();
            
            if(rs.next()) {
                return rs.getInt("cnt");
            }
        } catch (Exception e) {
            System.out.println("UserDAO.getTotalcommentNum");
            e.printStackTrace();
        }
        return 0;
    }
}