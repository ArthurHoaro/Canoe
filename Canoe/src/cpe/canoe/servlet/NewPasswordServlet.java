package cpe.canoe.servlet;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import cpe.canoe.model.User;
import cpe.canoe.services.UserService;

public class NewPasswordServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1538261003394072690L;
	private String error;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		try {
			req.getRequestDispatcher("/auth/newPassword.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		UserService userService = new cpe.canoe.services.UserService();
		User usr=
			(User) req.getSession().getAttribute("User");
		String pass = req.getParameter("pass");
		String repass = req.getParameter("repass");
		if(pass.equals(repass)){
			if(usr!=null){
				usr.setPassword(pass);
				userService.updateUser(usr);
				userService.updateSessionDate(usr);				
				resp.sendRedirect("/user/user.jsp");
			}	
		}
		else{	
			error= new String("Passwords have to be the same !");
			req.setAttribute("error", error);
			req.getRequestDispatcher("/auth/newPassword.jsp").forward(req, resp);			
		}
			

	}

}
