package cpe.canoe.services;

import java.util.Date;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import cpe.canoe.model.User;

public class UserService extends Service {

	public UserService() {
		super("User");
	}

	public boolean isLoggedIn() {;
		return true;
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
	
	public void addUser(User usr){
		Key ukey = KeyFactory.createKey("Username", usr.getUsername());
        Entity user = new Entity("User", ukey);
        user.setProperty("username", usr.getUsername());
        user.setProperty("password", usr.getPassword());
        user.setProperty("mail", usr.getMail());
        user.setProperty("firstname", usr.getFirstname());
        user.setProperty("lastname", usr.getLastname());
        user.setProperty("birthday", usr.getBirthday());
        user.setProperty("registerDate",new Date());
        user.setProperty("lastLoginDate",new Date());   
        this.getDBInstance().put(user);
	}
}
