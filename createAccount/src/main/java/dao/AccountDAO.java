package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Util.DBManager;
import dto.AccountVO;

public class AccountDAO {
	
	private AccountDAO() {}

	private static AccountDAO instance = new AccountDAO();

	public static AccountDAO getInstance() {
		return instance;
	}

	public String createAccountNumber() { // 계좌번호 랜덤 생성 메서드 
		String accountNumber = "";
		boolean isDuplicate = true;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		while (isDuplicate) {
			// 2222로 시작하는 10자리 랜덤 숫자를 생성합니다.
			accountNumber = "2222" + String.format("%010d", new Random().nextInt(1000000000));
			// 계좌번호 중복체크
			try {
				conn = DBManager.getConnection();
				String sql = "select count(*) from account where account_num = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, accountNumber);
				rs = pstmt.executeQuery();
				if (rs.next() && rs.getInt(1) == 0) {
					isDuplicate = false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return accountNumber;
	}

	// 계좌 정보 DB로 보내는 메서드
	public int insertAccountInfo(AccountVO aVo) {
		int result = -1;
		String sql = "insert into account values(?, 1000000, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aVo.getAccount_num());
			pstmt.setInt(2, aVo.getCustomer_num());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	// 기훈님
	
	public  List<AccountVO> selectAllAccount(){
		String sql = "select * from account order by account_num desc";
		
		List<AccountVO> list = new ArrayList<AccountVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				AccountVO aVo = new AccountVO();
				
				aVo.setAccount_num(rs.getString("account_num"));
				aVo.setBalance(rs.getInt("balance"));
				aVo.setCustomer_num(rs.getInt("customer_num"));
				
				list.add(aVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
}
