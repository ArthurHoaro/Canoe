package cpe.canoe.model;

import java.util.Date;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class User implements IEntity {
	private String key;
	private String firstname;
	private String lastname;
	private String mail;
	private String username;
	private String password;
	private Date birthday;
	private Date registerDate;
	private Date lastLoginDate;
	private boolean admin;
	
	public User() {
	}
	public User( Entity e ) {
		this.init(e);
	}
	
	@Override
	public void init(Entity e) {
		this.key = KeyFactory.keyToString(e.getKey());
		this.firstname = (String) e.getProperty("firstname");
		this.lastname = (String) e.getProperty("lastname");
		this.mail = (String) e.getProperty("mail");
		this.username = (String) e.getProperty("username");
		this.password = (String) e.getProperty("password");
		this.birthday = (Date) e.getProperty("birthday");
		this.registerDate = (Date) e.getProperty("registerDate");
		this.lastLoginDate = (Date) e.getProperty("lastLoginDate");
		this.admin = (Boolean) e.getProperty("admin");
	}
	
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public void toggleAdmin(){
		this.admin = (this.admin == true) ? false : true;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String fistname) {
		this.firstname = fistname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
