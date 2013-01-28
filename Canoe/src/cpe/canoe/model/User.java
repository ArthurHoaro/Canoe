package cpe.canoe.model;

import java.util.Date;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

public class User {
	private Key key;
	private String fistname;
	private String lastname;
	private String address;
	private String username;
	private String password;
	private Date birthday;
	private Date registerDate;
	private Date lastLoginDate;
	
	public User( Entity e ) {
		this.key = e.getKey();
		this.fistname = (String) e.getProperty("fistname");
		this.lastname = (String) e.getProperty("lastname");
		this.address = (String) e.getProperty("address");
		this.username = (String) e.getProperty("username");
		this.password = (String) e.getProperty("password");
		this.birthday = (Date) e.getProperty("birthday");
		this.registerDate = (Date) e.getProperty("registerDate");
		this.lastLoginDate = (Date) e.getProperty("lastLoginDate");
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getFistname() {
		return fistname;
	}
	public void setFistname(String fistname) {
		this.fistname = fistname;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
