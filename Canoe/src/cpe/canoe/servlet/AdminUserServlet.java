package cpe.canoe.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import cpe.canoe.model.UserModel;

public class AdminUserServlet extends HttpServlet {
	private UserModel umodel;
	private ArrayList<Entity> listUsers;
	
	public AdminUserServlet() {
		umodel = new UserModel(); 
		listUsers = new ArrayList<Entity>();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
		if( umodel.isLoggedIn() ) {
			PreparedQuery pq = umodel.getDBInstance().prepare(umodel.findAll());
			for ( Entity user : pq.asIterable() ) {
				listUsers.add(user);
			}
			resp.sendRedirect("/admin/users.jsp");
		}
		else
			resp.sendRedirect(UserServiceFactory.getUserService().createLoginURL(req.getRequestURI()));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
}
