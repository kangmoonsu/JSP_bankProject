package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import dao.InquiryDAO;
import dto.CustomerVO;
import dto.InquiryVO;

public class CustomerBoardForm implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/web/customerBoard.jsp";
		String customer_num = request.getParameter("customer_num");
		
		InquiryDAO iDao = InquiryDAO.getInstance();
		CustomerDAO cDao = CustomerDAO.getInstance();
		
		CustomerVO cVo = cDao.getCustomerVO(customer_num);
		List<InquiryVO> iVoList = iDao.getInquiryVO(customer_num);
		
		request.setAttribute("inquiryList", iVoList);
		request.setAttribute("customer", cVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
}
