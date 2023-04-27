package dao;

import java.sql.*;

import Util.DBManager;
import dto.CustomerVO;

public class CustomerDAO {
	private CustomerDAO() {
	}

	private static CustomerDAO instance = new CustomerDAO();

	public static CustomerDAO getInstance() {
		return instance;
	}

	public int updateCustomerInfo(CustomerVO cVo) { // 계좌 개설 후 고객정보 update 하는 메서드
		int result = -1;
		String sql = "update customer set reg_num = ?, email = ?, job = ? where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cVo.getReg_num());
			pstmt.setString(2, cVo.getEmail());
			pstmt.setString(3, cVo.getJob());
			pstmt.setString(4, cVo.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

}
