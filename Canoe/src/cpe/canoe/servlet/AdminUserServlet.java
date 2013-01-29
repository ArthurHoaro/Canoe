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

public class AdminUserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9059911230958526810L;
	private UserService uService;
	private ArrayList<IEntity> listUsers;
	
	public AdminUserServlet() {
		uService = new UserService(); 
		listUsers = new ArrayList<IEntity>();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
		if( uService.isAdmin(req) ) {			
			listUsers = (ArrayList<IEntity>) uService.findAll();
			
			try {
				req.setAttribute("listUsers", listUsers);
				req.getRequestDispatcher("/admin/users.jsp").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			resp.sendRedirect("/auth/login.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
}
