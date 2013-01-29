package cpe.canoe.model;

import java.util.Date;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.KeyFactory;

public class Booking implements IEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -245800182022719306L;
	/**
	 * 
	 */
	private String key;
	private String userKey;
	private String flightKey; 
	private int numberOfSeats;
	private Date date;
	
	public Booking()
	{		
	}	
	
	public Booking(String userKey, String flightKey) {
		
		this.userKey = userKey;
		this.flightKey = flightKey;
		this.numberOfSeats=1;
	}

	public Booking(String userKey, String flightKey,int numberOfSeats) {
		
		this.userKey = userKey;
		this.flightKey = flightKey;
		this.numberOfSeats=numberOfSeats;
	}


	public Booking( Entity e ) {
		this.init(e);
	}
	
	@Override
	public void init(Entity e) {
		this.key = KeyFactory.keyToString(e.getKey());
		this.flightKey = (String) e.getProperty("flightKey");
		this.userKey = (String) e.getProperty("userKey");
		this.numberOfSeats = (Integer) ((Long)e.getProperty("numberOfSeats")).intValue();
		this.date = (Date) e.getProperty("date");
	}


	public String getUserKey() {
		return userKey;
	}



	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	
	
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	public String getFlightKey() {
		return flightKey;
	}



	public void setFlightKey(String flightKey) {
		this.flightKey = flightKey;
	}



	public int getNumberOfSeats() {
		return numberOfSeats;
	}



	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}



	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	

}
