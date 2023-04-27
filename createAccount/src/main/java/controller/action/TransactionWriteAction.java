package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import dao.TransactionDAO;
import dto.TransactionVO;

public class TransactionWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TransactionVO tVo = new TransactionVO();
		
		tVo.setSender_account(request.getParameter("sender_account"));
		tVo.setReceiver_account(request.getParameter("receiver_account"));
		tVo.setAmount(Integer.parseInt(request.getParameter("amount")));
		tVo.setSend_context(request.getParameter("send_context"));
		
		TransactionDAO tDao = TransactionDAO.getInstance();
		tDao.insertTransction(tVo);
//		HttpSession session = request.getSession();
		
		new TransactionAction().execute(request, response);
		
	}
}
