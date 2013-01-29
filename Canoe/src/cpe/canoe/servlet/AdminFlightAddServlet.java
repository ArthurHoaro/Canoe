package cpe.canoe.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.criteria.From;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cpe.canoe.model.Flight;
import cpe.canoe.services.FlightService;
import cpe.canoe.services.UserService;

public class AdminFlightAddServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8398873930457816961L;
	private UserService uService;

	public AdminFlightAddServlet() {
		uService = new UserService();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		if (uService.isLoggedIn(req)) {
			RequestDispatcher dispatcher = null;

			dispatcher = req.getRequestDispatcher("/admin/flight-add.jsp");

			FlightService flightService = new cpe.canoe.services.FlightService();

			req.setAttribute("flightList", flightService.findAll());

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
			RequestDispatcher dispatcher = null;

			dispatcher = req.getRequestDispatcher("/admin/flight-add.jsp");

			FlightService flightService = new cpe.canoe.services.FlightService();
			SimpleDateFormat parseDate = new java.text.SimpleDateFormat(
					"dd/MM/yyyy");
			Date dateDepart = null;
			Date dateArrivee = null;
			try {
				dateDepart = (Date) parseDate.parse(req
						.getParameter("departing"));
				dateArrivee = (Date) parseDate.parse(req
						.getParameter("arrivalTime"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String from = req.getParameter("leavingFrom");
			String to = req.getParameter("goingTo");
			float price = Float.parseFloat(req.getParameter("price"));
			int availableSeats = Integer.parseInt(req
					.getParameter("availableSeats"));

			Flight flight = new Flight(dateDepart, dateArrivee, from, to,
					price, availableSeats);
			flightService.add(flight);

			dispatcher.forward(req, resp);
		} else
			resp.sendRedirect("/auth/login.jsp");
	}
}
