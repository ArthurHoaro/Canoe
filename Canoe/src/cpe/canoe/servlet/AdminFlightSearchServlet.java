package cpe.canoe.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import cpe.canoe.model.Flight;
import cpe.canoe.model.History;
import cpe.canoe.model.User;
import cpe.canoe.services.FlightService;
import cpe.canoe.services.HistoryService;
import cpe.canoe.services.UserService;

public class AdminFlightSearchServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4853843620909191960L;
	private UserService uService;
	private FlightService fs;
	private HistoryService hs;
	private List<Flight> listFlightDepartFound;
	private List<Flight> listFlightReturnFound;
	private boolean returnSearch;

	public AdminFlightSearchServlet() {
		uService = new UserService();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		if (uService.isLoggedIn(req)) {
			RequestDispatcher dispatcher = null;
			req.setAttribute("admin", uService.isAdmin(req));
			dispatcher = req.getRequestDispatcher("/flight/flight-search.jsp");

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
			User userLoggedIn = (User) req.getSession().getAttribute("User");
			hs = new HistoryService();
			fs = new FlightService();
			String from = req.getParameter("leavingFrom");
			String to = req.getParameter("goingTo");
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date departingDate = null;
			Date returnDate = null;
			try {
				departingDate = df.parse(req.getParameter("departingDate"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (req.getParameter("return") != null) {
				this.returnSearch = true;
				returnDate = null;
				try {
					returnDate = df.parse(req.getParameter("returnDate"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else
				this.returnSearch = false;
			
			this.listFlightDepartFound = fs.getFlights(from, to,departingDate );
			hs.add(this.createHistoryEntity(departingDate, from, to, listFlightDepartFound, userLoggedIn ));			
			
			if(returnSearch){
				this.listFlightReturnFound=fs.getFlights(to, from, returnDate);
				hs.add(this.createHistoryEntity(departingDate, to, from, listFlightReturnFound,userLoggedIn ));	
			}
			req.setAttribute("departs", listFlightDepartFound);
			req.setAttribute("returns", listFlightReturnFound);			
			req.getRequestDispatcher("/flight/flight-search.jsp").forward(req, resp);

		} else
			resp.sendRedirect("/auth/login.jsp");
	}
	
	private History createHistoryEntity(Date departure,String from, String to, List<Flight> response, User usr){
		History hist= new History();
		hist.setDeparture(departure);
		hist.setFrom(from);
		hist.setTo(to);
		hist.setNbResponse(response.size());
		hist.setAvgPrice(this.priceAverage(response));
		hist.setUser(usr.getUsername());		
		return hist;
	}
	
	private long priceAverage(List<Flight> response) {
		int out = 0, i;
		for( i = 0 ; i < response.size() ; ++i ) {
			out += response.get(i).getPrice();
		}
		
		return i == 0 ? 0 : out / i; 
	}
}
