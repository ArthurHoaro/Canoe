package cpe.canoe.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;

import cpe.canoe.services.FlightService;
import cpe.canoe.services.UserService;

public class AdminFlightDeleteServlet extends HttpServlet {
	private FlightService fService;
	private UserService uService;
		
	public AdminFlightDeleteServlet() {
		fService = new FlightService();
		uService = new UserService();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
		resp.sendRedirect("/admin/flight-add");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if( uService.isAdmin(req) ) {
			if( !req.getParameter("flightKey").isEmpty() ) {
				System.out.println("delete");
				fService.remove(KeyFactory.stringToKey(req.getParameter("flightKey")));
			}
		}
		resp.sendRedirect("/admin/flight-add");
	}
}
