package cpe.canoe.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;

import cpe.canoe.model.IEntity;
import cpe.canoe.model.User;
import cpe.canoe.services.UserService;

public class AdminUserDeleteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -11098582423284045L;
	private UserService uService;
		
	public AdminUserDeleteServlet() {
		uService = new UserService(); 
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
		if( uService.isAdmin(req) ) {
			if( req.getParameter("queue") == "1" ) {
				System.out.println("delete");
				uService.remove(KeyFactory.stringToKey(req.getParameter("u")));
			}
			else if ( req.getParameter("u") != null ) {
				Queue queue = QueueFactory.getQueue("delete-user");
		        queue.add(TaskOptions.Builder.withUrl("/admin/delete").param("u", req.getParameter("u")).param("queue", "1"));
		        resp.sendRedirect("/admin/users?del=ok&u="+req.getParameter("u"));
			}
			else
				resp.sendRedirect("/admin/users?del=ko");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
}
