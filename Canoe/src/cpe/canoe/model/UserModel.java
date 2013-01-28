package cpe.canoe.model;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class UserModel extends Model {

	public UserModel() {
		super("User");
	}

	public boolean isLoggedIn() {;
        return (UserServiceFactory.getUserService().getCurrentUser() != null) ? true : false;
	}
	
	
}
