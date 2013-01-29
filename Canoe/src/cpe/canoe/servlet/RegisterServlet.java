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
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if (!uService.isLoggedIn(req) || uService.isAdmin(req)) {
			Queue queue = QueueFactory.getQueue("add-user");
			queue.add(TaskOptions.Builder.withUrl("/admin/user-adds")
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
		else 
			resp.sendRedirect("/auth/register.jsp?error");
	}
}
