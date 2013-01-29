package cpe.canoe.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;

import cpe.canoe.model.User;
import cpe.canoe.services.UserService;

public class RegisterServlet extends HttpServlet {
	/**
	 * 
	 */
	private UserService uService;
	private static final long serialVersionUID = -7737019253228961975L;

	public RegisterServlet() {
		uService = new UserService();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		if (req.getParameter("queue") == "1") {
			UserService usrService = new UserService();
			User usr = new User();
			String pass = Long.toHexString(Double.doubleToLongBits(Math
					.random()));
			
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
			usr.setAdmin(true);

			if (!req.getParameter("pass").equals("")
					&& req.getParameter("pass").equals(
							req.getParameter("repass")))
				usr.setPassword(req.getParameter("pass"));
			else
				usr.setPassword(pass);
			usrService.add(usr);
			Properties props = new Properties();
			Session session = Session.getDefaultInstance(props, null);

			String msgBody = "Dear "
					+ usr.getFirstname()
					+ ":Your Canoë account has been approved.  You can now visit "
					+ "http://x5-feisty-vector-4.appspot.com and sign in using your login and this generated password : "
					+ usr.getPassword() + " to "
					+ "access your new features."
					+ "Please let us know if you have any questions."
					+ "The Canoë Team.";
			try {
				Message msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress(
						"admin@x5-feisty-vector-4.appspotmail.com", "Admin"));
				msg.addRecipient(
						Message.RecipientType.TO,
						new InternetAddress(usr.getMail(), "Mr. "
								+ usr.getFirstname() + " "
								+ usr.getLastname()));
				msg.setSubject("Your Canoe account has been activated");
				msg.setText(msgBody);
				Transport.send(msg);

			} catch (AddressException e) {
				// ...
			} catch (MessagingException e) {
				// ...
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if (!uService.isLoggedIn(req) || uService.isAdmin(req)) {
			Queue queue = QueueFactory.getQueue("add-user");
			queue.add(TaskOptions.Builder.withUrl("/register")
					.param("firstname", req.getParameter("firstname"))
					.param("lastname", req.getParameter("lastname"))
					.param("username", req.getParameter("username"))
					.param("birthday", req.getParameter("birthday"))
					.param("mail", req.getParameter("mail"))
					.param("pass", req.getParameter("pass"))
					.param("repass", req.getParameter("repass"))
					.param("queue", "1"));
			resp.sendRedirect("/auth/register-ok.jsp");
		}
	}
}
