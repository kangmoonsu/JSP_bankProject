package controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDAO;
import dto.CustomerVO;

public class IndexAfterLogin implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/web/Login.jsp";

		CustomerDAO cDao = CustomerDAO.getInstance();
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		int result = cDao.userCheck(userid, pwd);
		if (result == 1) {
			CustomerVO cVo = cDao.getCustomer(userid);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", cVo);
			url = "/web/IndexAfterLogin.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
