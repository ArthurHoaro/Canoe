/**
 * 
 */
package cpe.canoe.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.KeyFactory;

import cpe.canoe.model.History;
import cpe.canoe.model.User;
import cpe.canoe.services.HistoryService;
import cpe.canoe.services.UserService;

/**
 * @author arthur
 *
 */
public class HistoryServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8112083510086671468L;
	private UserService uService;
	private HistoryService hService;
	
	public HistoryServlet() {
		uService = new UserService();
		hService = new HistoryService();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if( uService.isLoggedIn(req) ) {
			ArrayList<History> historyList = hService.findAllFromUser((User) req.getSession().getAttribute("User"));
			req.setAttribute("history", historyList);
			req.getRequestDispatcher("/flight/history.jsp").forward(req, resp);
		}
		else
			resp.sendRedirect("/auth/login.jsp");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
}
