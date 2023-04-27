package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import dao.CustomerDAO;
import dao.TransactionDAO;
import dto.AccountVO;
import dto.CustomerVO;
import dto.TransactionVO;

public class TransactionAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String url = "/account/transaction.jsp";
		
		TransactionDAO tDao = TransactionDAO.getInstance();
//		int customer_num = Integer.parseInt(request.getParameter("customer_num"));
		CustomerDAO cDao = CustomerDAO.getInstance();
		AccountDAO aDao = AccountDAO.getInstance();
		
		List<AccountVO> account = aDao.selectAllAccount();
		List<TransactionVO> transaction = tDao.selectAlltransaction();
		List<CustomerVO> customer = cDao.selectAllCustomer();
		
		request.setAttribute("customer", customer);
		request.setAttribute("account", account);
		request.setAttribute("transaction", transaction);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
