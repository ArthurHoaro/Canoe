package cpe.canoe.services;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import cpe.canoe.model.IEntity;
import cpe.canoe.model.User;

public class UserService extends Service {

	public UserService() {
		super("User");
	}

	public boolean isLoggedIn(HttpServletRequest req) {;
		return req.getSession().getAttribute("User") != null;
	}
	
	public boolean isAdmin(HttpServletRequest req) {;
		return this.isLoggedIn(req) && ((User)req.getSession().getAttribute("User")).isAdmin() == true;
	}
	
	public User getUser(String username, String password ){
		User usr = null;
		Query q = new Query(this.entityName).addFilter("username", Query.FilterOperator.EQUAL, username)
				.addFilter("password", Query.FilterOperator.EQUAL, password);
		PreparedQuery pq = this.getDBInstance().prepare(q);
		if(!pq.asList(FetchOptions.Builder.withDefaults()).isEmpty())
			usr = new User( pq.asList(FetchOptions.Builder.withDefaults()).get(0));		
		return usr;
	}
	
	public void add(IEntity usr){
        this.getDBInstance().put(this.ormToEntity(usr, true));
	}
	
	public void update(IEntity usr){
		this.getDBInstance().put(this.ormToEntity(usr, false));
	}

	public void updateSessionDate(User user) {
		Entity dbUser = null;
		try {
			dbUser = this.getDBInstance().get(KeyFactory.stringToKey(user.getKey()));
			dbUser.setProperty("lastLoginDate",new Date());
			this.getDBInstance().put(dbUser);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected Entity ormToEntity(IEntity iusr, boolean newUser) {
		Entity user = null;
		User usr = (User) iusr;
		if( newUser ) {
			Key ukey = KeyFactory.createKey("Username", usr.getUsername());
	        user = new Entity("User", ukey);
		} else
			try {
				user = this.getDBInstance().get(KeyFactory.stringToKey(usr.getKey()));
			} catch (EntityNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        user.setProperty("username", usr.getUsername());
        user.setProperty("password", usr.getPassword());
        user.setProperty("mail", usr.getMail());
        user.setProperty("firstname", usr.getFirstname());
        user.setProperty("lastname", usr.getLastname());
        user.setProperty("birthday", usr.getBirthday());
        if(newUser)
        	user.setProperty("registerDate",new Date());
        user.setProperty("lastLoginDate", usr.getLastLoginDate()); 
        user.setProperty("admin", usr.isAdmin());
        return user;
	}
}
