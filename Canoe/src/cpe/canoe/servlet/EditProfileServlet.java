/**
 * 
 */
package cpe.canoe.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.KeyFactory;

import cpe.canoe.model.User;
import cpe.canoe.services.UserService;

/**
 * @author arthur
 *
 */
public class EditProfileServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1806697540384760970L;
	private UserService uService;
	private String success;
	private String error;
	private RequestDispatcher dispatch;
	
	public EditProfileServlet() {
		uService = new UserService();
		this.error = null;
		this.success = null;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if( uService.isLoggedIn(req)) {
			req.getRequestDispatcher("/auth/edit.jsp").forward(req, resp);
		}
		else
			resp.sendRedirect("/auth/login.jsp");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		dispatch = req.getRequestDispatcher("/auth/edit.jsp");
		this.error = null;
		this.success = null;
		if( uService.isLoggedIn(req)) {
			if( req.getParameter("key") != null ) {
				User user = null;
				try {
					user = (User) uService.findByKey(KeyFactory.stringToKey(req.getParameter("key")));
				} catch (EntityNotFoundException e) {
					this.error = "Une erreur s'est produite, veuillez vous reconnecter.";
					this.redirectPost(req, resp);
				}
				System.out.println("POST : \""+ req.getParameter("pass") +"\" - Session : \""+ user.getPassword() +"\"");
				if( ! req.getParameter("pass").isEmpty() ){
					if( req.getParameter("pass").equals(user.getPassword()) ) {
						if( ! req.getParameter("username").isEmpty() ) { user.setUsername(req.getParameter("username")); }
						if( !req.getParameter("firstname").isEmpty() ) { user.setFirstname(req.getParameter("firstname")); }
						if( !req.getParameter("lastname").isEmpty()) { user.setLastname(req.getParameter("lastname")); }
						if( !req.getParameter("birthday").isEmpty() ) { 
							SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
							try {
								user.setBirthday(df.parse(req.getParameter("birthday")));
							} catch (ParseException e) {
								this.error = "Le format de date utilisé est incorrect.";
								this.redirectPost(req, resp);
							} 
						}
						if( !req.getParameter("mail").isEmpty() ) { user.setMail(req.getParameter("mail")); }
						if( !req.getParameter("newpass").isEmpty() && !req.getParameter("renewpass").isEmpty() ) { 
							if (req.getParameter("newpass").equals(req.getParameter("renewpass"))) 
								user.setPassword(req.getParameter("newpass")); 
							else {
								this.error = "Les deux nouveaux mots de passe ne correspondent pas.";
							}
						}
						
						if( error == null ) {
							uService.update(user);
							req.getSession().setAttribute("User", user);
							this.success = "Votre profil a bien été mis à jour.";
						}
					}
					else {
						this.error = "Mot de passe incorrect.";
					}
				}
				else {
					this.error = "Vous devez vérifier votre mot de passe pour modifier ces informations.";
				}
			}
			else {
				this.error = "Une erreur s'est produite, veuillez vous reconnecter.";
			}
			
			this.redirectPost(req, resp);
		}
		else
			resp.sendRedirect("/auth/login.jsp");		
	}
	
	private void redirectPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setAttribute("success", this.success);
			req.setAttribute("error", this.error);
			dispatch.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
