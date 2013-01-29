package cpe.canoe.servlet;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import cpe.canoe.model.User;
import cpe.canoe.services.UserService;

public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1538261003394072690L;
	private String error;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

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
				//todo
				resp.sendRedirect("/auth/newPassword.jsp");
			}
				
			
			userService.updateSessionDate(usr);
			resp.sendRedirect("/user/user.jsp");
		}
		
		else{
			error=new String("Le systeme n'a pas reussi à vous logger");		
			req.setAttribute("error", error);
			req.getRequestDispatcher("/auth/login.jsp").forward(req, resp);
		}
		

	}

}
