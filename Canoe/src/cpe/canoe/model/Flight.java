package cpe.canoe.model;

import java.util.Date;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

public class Flight implements IEntity {
	private Key key;
	private Date dateDepart;
	private Date dateArrivee;
	private Date duration;
	private String from;
	private String to;
	private float price;
	private int availableSeats;
	
	public Flight(Date dateDepart, Date dateArrivee, String from, String to, 
			float price, int availableSeats)
	{
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.duration = this.getDuration(dateDepart, dateArrivee);
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
		this.key = e.getKey();
		this.dateDepart = (Date) e.getProperty("dateDepart");
		this.dateArrivee = (Date) e.getProperty("dateArrivee");
		this.duration = this.getDuration(dateDepart, dateArrivee);
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
		this.duration = duration;
	}

	private Date getDuration(Date dateDepart, Date dateArrivee)
	{
		Date dateEcart = null;
		if(dateDepart == null || dateArrivee == null)
		{
			
		}
		else
		{
			Long ecart = dateArrivee.getTime() - dateDepart.getTime();
			dateEcart = new Date(ecart);
		}
		return dateEcart;
	}

}
