/**
 * 
 */
package cpe.canoe.servlet;

import java.io.IOException;
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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cpe.canoe.model.User;
import cpe.canoe.services.UserService;

/**
 * @author arthur
 *
 */
public class AdminUserAddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3582501874900728165L;

	/**
	 * 
	 */
	public AdminUserAddServlet() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 
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
						"admin@canoe-flights.appspotmail.com", "Admin"));
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

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
								"admin@canoe-flights.appspotmail.com", "Admin"));
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
