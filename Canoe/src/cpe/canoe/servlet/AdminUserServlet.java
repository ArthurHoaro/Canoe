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
	private UserService uService;
	private ArrayList<IEntity> listUsers;
	
	public AdminUserServlet() {
		uService = new UserService(); 
		listUsers = new ArrayList<IEntity>();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
		if( uService.isLoggedIn() ) {
			listUsers = (ArrayList<IEntity>) uService.findAll();
			
			try {
				req.getRequestDispatcher("/admin/users.jsp").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				req.getRequestDispatcher("/auth/login.jsp").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
}
