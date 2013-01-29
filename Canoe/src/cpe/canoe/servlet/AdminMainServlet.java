package cpe.canoe.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;

import cpe.canoe.model.IEntity;
import cpe.canoe.model.User;
import cpe.canoe.services.UserService;

public class AdminMainServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5203098254254262281L;
	private UserService uService;
	
	public AdminMainServlet() {
		uService = new UserService();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
		if( uService.isAdmin(req) ) {			
			try {
				req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else 
			resp.sendRedirect("/auth/login.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
}
