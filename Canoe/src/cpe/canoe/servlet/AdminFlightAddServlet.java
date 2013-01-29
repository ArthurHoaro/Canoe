package cpe.canoe.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.criteria.From;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cpe.canoe.model.Flight;
import cpe.canoe.model.IEntity;
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
		if (uService.isAdmin(req)) {
			RequestDispatcher dispatcher = null;

			dispatcher = req.getRequestDispatcher("/admin/flight-add.jsp");

			addFlightAttributes(req);
			
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
			SimpleDateFormat parseDateDepart = new java.text.SimpleDateFormat(
					"dd/MM/yyyy HH:mm");
			SimpleDateFormat parseDateArrivee = new java.text.SimpleDateFormat(
					"dd/MM/yyyy HH:mm");
			Date dateDepart = null;
			Date dateArrivee = null;
			try {
				dateDepart = parseDateDepart.parse(req
						.getParameter("departing"));
				dateArrivee = parseDateArrivee.parse(req
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
			addFlightAttributes(req);
			resp.sendRedirect("/admin/flight-add");
		} else
			resp.sendRedirect("/auth/login.jsp");
	}
	
	private void addFlightAttributes(HttpServletRequest req)
	{
		FlightService flightService = new cpe.canoe.services.FlightService();
		ArrayList<IEntity> allFlights = flightService.findAll();
		
		// On va chercher tous les avions pour afficher
		req.setAttribute("flightList", allFlights);
		
		// On cherche tous les écarts
		ArrayList<Date> dateEcartList = dateEcartList(allFlights);
		req.setAttribute("dateEcartList", dateEcartList);
	}
	
	private ArrayList<Date> dateEcartList(ArrayList<IEntity> flightArray)
	{
		ArrayList<Date> listDateEcart = new ArrayList<Date>();
		for(IEntity entityFlight : flightArray)
		{
			Flight flight = (Flight) entityFlight;
			listDateEcart.add(dateEcart(flight.getDateDepart(), flight.getDateArrivee()));
		}
		return listDateEcart;
	}
	
	private Date dateEcart(Date dateDepart, Date dateArrivee)
	{
		Date dateEcart = null;
		if(dateDepart == null || dateArrivee == null)
		{
			
		}
		else
		{
			Long ecart = dateArrivee.getTime() - dateDepart.getTime();
			dateEcart = new Date(ecart);
		}
		return dateEcart;
	}
}
