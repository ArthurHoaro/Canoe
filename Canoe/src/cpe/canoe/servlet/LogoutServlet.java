package cpe.canoe.servlet;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import cpe.canoe.model.User;
import cpe.canoe.services.UserService;


@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet {
	private UserService uService;
	
	public LogoutServlet() {
		uService = new UserService();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		if( uService.isLoggedIn(req)) {
			req.getSession().invalidate();
			
		}
		resp.sendRedirect("/auth/login.jsp");
	}
}
