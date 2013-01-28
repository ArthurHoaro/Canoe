package cpe.canoe.model;

import java.util.Date;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

public class Flight implements IEntity {
	private Key key;
	private Date dateDepart;
	private Date dateArrivee;
	private String from;
	private String to;
	private String price;
	private int availableSeats;
	
	@Override
	public void init(Entity e) {
		this.key = e.getKey();
		this.dateDepart = (Date) e.getProperty("date");
		this.dateArrivee = (Date) e.getProperty("dateArrivee");
		this.from = (String) e.getProperty("from");
		this.to = (String) e.getProperty("to");
		this.price = (String) e.getProperty("price");
		this.availableSeats = Integer.parseInt("availableSeats");
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}