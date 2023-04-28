package controller.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import dao.CustomerDAO;
import dto.AccountVO;
import dto.CustomerVO;

public class CreateAccountAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/web/CreateAccount.jsp";
		
		HttpSession session = request.getSession();
		AccountVO aVo = new AccountVO();
		CustomerVO cVo = (CustomerVO)session.getAttribute("loginUser");
		AccountDAO aDao = AccountDAO.getInstance();
		CustomerDAO cDao = CustomerDAO.getInstance();
		aVo.setAccount_num(aDao.createAccountNumber());
		aVo.setCustomer_num(cVo.getCustomer_num());		
		
		
		try {
			if (aDao.isAccountExist(cVo.getCustomer_num())) {
			    request.setAttribute("message", "이미 계좌가 존재합니다.");
			} else {
			    aVo.setAccount_num(aDao.createAccountNumber());
			    aVo.setCustomer_num(cVo.getCustomer_num());

			    cDao.updateCustomerInfo(cVo);
			    aDao.insertAccountInfo(aVo);

			    request.setAttribute("message", "계좌가 생성되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}

}
