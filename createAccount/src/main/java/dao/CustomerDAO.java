package dao;

import java.sql.*;
import java.util.*;

import Util.DBManager;
import dto.CustomerVO;

public class CustomerDAO {
	private CustomerDAO() {
	}

	private static CustomerDAO instance = new CustomerDAO();

	public static CustomerDAO getInstance() {
		return instance;
	}

	public int addCustomerInfo(CustomerVO cVo) { // 계좌 개설 후 고객정보 update 하는 메서드
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
	
	// 기훈님
	
	public List<CustomerVO> selectAllCustomer(){
		String sql = "select * from customer order by customer_num";
		
		List<CustomerVO> list = new ArrayList<CustomerVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				CustomerVO cVo = new CustomerVO();
				
				cVo.setCustomer_num(rs.getInt("customer_num"));
				cVo.setName(rs.getString("name"));
				cVo.setId(rs.getString("id"));
				cVo.setPw(rs.getString("pw"));
				cVo.setPhone(rs.getString("phone"));
				cVo.setReg_num(rs.getString("reg_num"));
				cVo.setEmail(rs.getString("email"));
				cVo.setJob(rs.getString("job"));
				
				list.add(cVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	// 나연님
	public int userCheck(String id, String pw) {
		int result = -1;
		String sql = "select pw from customer where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (rs.getString("pw")!= null && rs.getString("pw").equals(pw)) {
					result = 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	public CustomerVO getCustomer(String userid) {
		CustomerVO cVo = null;
		String sql = "select * from customer where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		 try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cVo = new CustomerVO();
				cVo.setCustomer_num(rs.getInt("customer_num"));
				cVo.setEmail(rs.getString("email"));
				cVo.setId(rs.getString("id"));
				cVo.setJob(rs.getString("job"));
				cVo.setReg_num(rs.getString("reg_num"));
				cVo.setName(rs.getString("name"));
				cVo.setPhone(rs.getString("phone"));
				cVo.setPw(rs.getString("pw"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		 
		return cVo;
	}

	public void insertCustomer(CustomerVO cVo) {
		String sql = "insert into customer (customer_num, name, id, pw, phone) values (customer_seq.nextval, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cVo.getName());
			pstmt.setString(2, cVo.getId());
			pstmt.setString(3, cVo.getPw());
			pstmt.setString(4, cVo.getPhone());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 수민님
	
	//customer에 대한 데이터를 가져오기
		public CustomerVO selectCustomerInfo(int customer_num) {
			CustomerVO cVo = null;
			String sql = "select * from customer where customer_num=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, customer_num);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					cVo = new CustomerVO();
					cVo.setCustomer_num(rs.getInt("customer_num"));
					cVo.setEmail(rs.getString("email"));
					cVo.setJob(rs.getString("job"));
					cVo.setPhone(rs.getString("phone"));
					cVo.setPw(rs.getString("pw"));
					cVo.setId(rs.getString("id"));
					cVo.setName(rs.getString("name"));
					cVo.setReg_num(rs.getString("reg_num"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally  {
				DBManager.close(conn, pstmt, rs);
			}
			return cVo;
		}

		public void updateCustomerInfo(CustomerVO cVo) {
			String sql = "update customer set pw=?, phone=?, email=?, job=? where customer_num=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cVo.getPw());
				pstmt.setString(2, cVo.getPhone());
				pstmt.setString(3, cVo.getEmail());
				pstmt.setString(4, cVo.getJob());
				pstmt.setInt(5, cVo.getCustomer_num());
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}

		// 인철님
		public CustomerVO getCustomerVO(String customer_num) {
			String sql = "select * from customer where customer_num = ?";
			CustomerVO cVo = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, customer_num);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					cVo = new CustomerVO();
					cVo.setCustomer_num(rs.getInt("customer_num"));
					cVo.setEmail(rs.getString("email"));
					cVo.setId(rs.getString("id"));
					cVo.setJob(rs.getString("job"));
					cVo.setName(rs.getString("name"));
					cVo.setPhone(rs.getString("phone"));
					cVo.setPw(rs.getString("pw"));
					cVo.setReg_num(rs.getString("reg_num"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			
			return cVo;
		}
		
	

}
