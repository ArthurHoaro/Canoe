package cpe.canoe.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.KeyFactory;

import cpe.canoe.model.Booking;
import cpe.canoe.model.Flight;
import cpe.canoe.model.History;
import cpe.canoe.model.User;
import cpe.canoe.services.BookingService;
import cpe.canoe.services.FlightService;
import cpe.canoe.services.HistoryService;
import cpe.canoe.services.UserService;

public class AdminFlightReserveServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4853843620909191960L;
	private UserService uService;
	private FlightService fs;
	private Flight fl;
	private BookingService bs;
	private User usr;

	public AdminFlightReserveServlet() {
		uService = new UserService();
		fs= new FlightService();
		bs = new BookingService();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		if (uService.isLoggedIn(req)) {
			RequestDispatcher dispatcher = null;
			String flightId= req.getParameter("flightId");			
			try {
				 fl = (Flight) fs.findByKey(KeyFactory.stringToKey(flightId));
			} catch (EntityNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			req.setAttribute("flight", fl);
			dispatcher = req.getRequestDispatcher("/flight/flight-reserve.jsp");
			try {
				dispatcher.forward(req, resp);
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
		if (uService.isLoggedIn(req)) {
			usr = (User) req.getSession().getAttribute("User");
			Booking bk = new Booking(usr.getKey(), fl.getKey(), 1);
			bs.add(bk);		
			
		} else
			resp.sendRedirect("/auth/login.jsp");
	}
	
	
}
