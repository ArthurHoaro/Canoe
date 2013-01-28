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
		if( uService.isLoggedIn(req)) {
			if( req.getParameter("key") != null ) {
				User user = null;
				try {
					user = (User) uService.findByKey(KeyFactory.stringToKey(req.getParameter("key")));
				} catch (EntityNotFoundException e) {
					this.error = "Une erreur s'est produite, veuillez vous reconnecter.";
					this.redirectPost(req, resp);
				}
				if( req.getParameter("pass") != null ){
					if( req.getParameter("pass") == user.getPassword() ) {
						if( req.getParameter("username") != null ) { user.setUsername(req.getParameter("username")); }
						if( req.getParameter("firstname") != null ) { user.setFirstname(req.getParameter("firstname")); }
						if( req.getParameter("lastname") != null ) { user.setLastname(req.getParameter("lastname")); }
						if( req.getParameter("birthday") != null ) { 
							SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
							try {
								user.setBirthday(df.parse(req.getParameter("birthday")));
							} catch (ParseException e) {
								this.error = "Le format de date utilisé est incorrect.";
								this.redirectPost(req, resp);
							} 
						}
						if( req.getParameter("mail") != null ) { user.setMail(req.getParameter("mail")); }
						if( req.getParameter("newpass") != null && req.getParameter("renewpass") != null ) { 
							if (req.getParameter("newpass") == req.getParameter("renewpass")) 
								user.setPassword(req.getParameter("newpass")); 
							else {
								this.error = "Les deux nouveaux mots de passe ne correspondent pas.";
								this.redirectPost(req, resp);
							}
						}
						
						if( error == null ) {
							uService.updateSessionDate(user);
							this.success = "Votre profil a bien été mis à jour.";
							this.redirectPost(req, resp);
						}
					}
					else {
						this.error = "Mot de passe incorrect.";
						this.redirectPost(req, resp);
					}
				}
				else {
					this.error = "Vous devez vérifier votre mot de passe pour modifier ces informations.";
					this.redirectPost(req, resp);
				}
			}
			else {
				this.error = "Une erreur s'est produite, veuillez vous reconnecter.";
				this.redirectPost(req, resp);
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
