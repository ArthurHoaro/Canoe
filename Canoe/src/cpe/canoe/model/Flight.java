package cpe.canoe.model;

import java.util.Date;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class Flight implements IEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3210356911756106173L;
	private String key;
	private Date dateDepart;
	private Date dateArrivee;
	private String from;
	private String to;
	private float price;
	private int availableSeats;
	
	public Flight(Date dateDepart, Date dateArrivee, String from, String to, 
			float price, int availableSeats)
	{
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.from = from;
		this.to = to;
		this.price = price;
		this.availableSeats = availableSeats;
	}
	
	public Flight()
	{
		
	}
	
	public Flight( Entity e ) {
		this.init(e);
	}
	
	@Override
	public void init(Entity e) {
		this.key = KeyFactory.keyToString(e.getKey());
		this.dateDepart = (Date) e.getProperty("dateDepart");
		this.dateArrivee = (Date) e.getProperty("dateArrivee");
		this.from = (String) e.getProperty("from");
		this.to = (String) e.getProperty("to");
		this.price = Float.parseFloat(e.getProperty("price").toString());
		this.availableSeats = Integer.parseInt(e.getProperty("availableSeats").toString());
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
