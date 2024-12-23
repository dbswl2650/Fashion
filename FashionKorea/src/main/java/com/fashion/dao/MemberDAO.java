package com.fashion.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import com.fashion.vo.MemberVO;

public class MemberDAO {
    // 데이터베이스 연결 정보
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "fashion";
    private static final String PASSWORD = "fashion";
    private static final Logger LOGGER = Logger.getLogger(MemberDAO.class.getName());

    // 시퀀스 생성 메서드
    private void createSequenceIfNotExists() {
        String sql = "CREATE SEQUENCE "
        		+ "member_seq "
        		+ "START WITH 1 "
        		+ "INCREMENT BY 1 NOCACHE";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
             // 시퀀스 생성
        	 stmt.execute(sql); 
             LOGGER.info("시퀀스가 생성되었습니다.");
         } catch (SQLException e) {
             // 에러 코드와 메시지를 출력
             LOGGER.warning("SQL 오류발생" + e.getErrorCode() + ", 메시지: " + e.getMessage());
         }
     }

    // 회원 정보 삽입 메서드
    public boolean insertMember(MemberVO member) {
        createSequenceIfNotExists();
        String sql1 = "INSERT INTO member (member_no, "
        		+ "member_name, "
        		+ "member_id, "
        		+ "member_pw, "
        		+ "member_mail, "
        		+ "member_phone, "
        		+ "member_age, "
        		+ "member_add) "
                   + "VALUES (member_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement psmt = conn.prepareStatement(sql1)) {

            psmt.setString(1, member.getMemberName());
            psmt.setString(2, member.getMemberId());
            psmt.setString(3, member.getMemberPw());
            psmt.setString(4, member.getMemberMail());
            psmt.setString(5, member.getMemberPhone());
            psmt.setString(6, member.getMemberAge());
            psmt.setString(7, member.getMemberAdd());

            int result = psmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
