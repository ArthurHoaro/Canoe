package cpe.canoe.servlet;

import java.io.IOException;
import java.util.List;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import cpe.canoe.model.Booking;
import cpe.canoe.model.User;
import cpe.canoe.services.BookingService;
import cpe.canoe.services.UserService;

public class BookingServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1538261003394072690L;
	private String error;
	private BookingService bs;
	private UserService uService;
	private List<Booking> books;
	
	

	public BookingServlet() {
		bs=new BookingService();
		uService=new UserService();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		if (uService.isLoggedIn(req)) {
			books = bs.findAllFromUser((User) req.getSession().getAttribute("User"));			
			req.setAttribute("books",books);
			try {
				req.getRequestDispatcher("/auth/booking.jsp").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			resp.sendRedirect("/auth/login.jsp");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		UserService userService = new cpe.canoe.services.UserService();
		User usr=
		userService.getUser(req.getParameter("username"), req.getParameter("pass"));
		if(usr!=null){
			HttpSession session= req.getSession();
			session.setAttribute("User", usr);
			if(usr.getLastLoginDate().equals(usr.getRegisterDate())){				
				resp.sendRedirect("/auth/newpassword");
			}
			else{
				userService.updateSessionDate(usr);
				resp.sendRedirect("/user/user.jsp");
			}
		}
		
		else{
			error=new String("Le systeme n'a pas reussi à vous logger");		
			req.setAttribute("error", error);
			req.getRequestDispatcher("/auth/login.jsp").forward(req, resp);
		}
		

	}

}
