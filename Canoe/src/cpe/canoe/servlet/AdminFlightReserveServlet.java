package cpe.canoe.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
	private boolean cons;

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
			cons=false;
			if(req.getParameter("cons")!=null && req.getParameter("cons").equals("1")){
				cons= true;			
			}
			req.setAttribute("cons", cons);
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
			fl.setAvailableSeats(fl.getAvailableSeats()-1);
			fs.update(fl);
			sendMail(fl);
			req.setAttribute("msg", "Merci pour votre reservation, vous recevrez une confirmaion par mail !");
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		} else
			resp.sendRedirect("/auth/login.jsp");
	}
	
	private void sendMail( Flight fl){
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		String msgBody = "Dear "
				+ usr.getFirstname()
				+ ":Your command on Canoë has been approved." 
				+ " Please find your flight details here : Departure Date :" + fl.getDateDepart()
				+ " ,Arrival Date : " + fl.getDateArrivee()
				+ " ,from : " + fl.getFrom()
				+ " ,to : " + fl.getTo()
				+ " ,price : " + fl.getPrice()
				;
		
			Message msg = new MimeMessage(session);
			try {
				msg.setFrom(new InternetAddress(
						"admin@x5-feisty-vector-4.appspotmail.com", "Admin"));
				msg.addRecipient(
						Message.RecipientType.TO,
						new InternetAddress(usr.getMail(), "Mr. "
								+ usr.getFirstname() + " " + usr.getLastname()));
				msg.setSubject("Command confirmation");
				msg.setText(msgBody);
				Transport.send(msg);	
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				

	
	}
	
	
}
