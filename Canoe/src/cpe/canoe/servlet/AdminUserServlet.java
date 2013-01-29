package cpe.canoe.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.KeyFactory;
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
			if( req.getParameter("adm") != null && !req.getParameter("adm").equals(((User)req.getSession().getAttribute("User")).getKey())) {
				try {
					User user = (User) uService.findByKey(KeyFactory.stringToKey((String) req.getParameter("adm")));
					user.toggleAdmin();
					uService.update(user);
				} catch (EntityNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
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
