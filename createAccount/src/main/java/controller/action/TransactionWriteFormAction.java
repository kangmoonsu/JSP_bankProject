package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import dao.CustomerDAO;
import dto.AccountVO;
import dto.CustomerVO;

public class TransactionWriteFormAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String url = "/account/transactionWrite.jsp";
		
		CustomerDAO cDao = CustomerDAO.getInstance();
		AccountDAO aDao = AccountDAO.getInstance();
		
		List<CustomerVO> customer = cDao.selectAllCustomer();
		List<AccountVO> account = aDao.selectAllAccount();
		
		request.setAttribute("customer", customer);
		request.setAttribute("account", account);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
