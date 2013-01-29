package cpe.canoe.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cpe.canoe.services.UserService;

public class AdminFlightSearchServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4853843620909191960L;
	private UserService uService;
	
	
	public AdminFlightSearchServlet() {
		uService = new UserService();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		if( uService.isAdmin(req)) {
			RequestDispatcher dispatcher = null;
			
			dispatcher = req.getRequestDispatcher("/admin/flight-search.jsp");	
			
			try {
				dispatcher.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		else
			resp.sendRedirect("/auth/login.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if( uService.isAdmin(req)) {
			// TODO
		} 
		else
			resp.sendRedirect("/auth/login.jsp");
	}
}
