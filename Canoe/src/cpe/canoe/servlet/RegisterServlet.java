package cpe.canoe.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import cpe.canoe.model.User;
import cpe.canoe.services.UserService;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserService usrService = new UserService();
		User usr = new User();
		usr.setFirstname(req.getParameter("firstname"));
		usr.setLastname(req.getParameter("lastname"));
		usr.setUsername(req.getParameter("username"));
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date d = null;
		try {
			d = df.parse(req.getParameter("birthday"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		usr.setBirthday(d);
		usr.setMail(req.getParameter("mail"));
		usr.setFirstname(req.getParameter("firstname"));
		if (req.getParameter("pass").equals(req.getParameter("repass")))
			usr.setPassword(req.getParameter("pass"));

		usrService.addUser(usr);		
	}

}
