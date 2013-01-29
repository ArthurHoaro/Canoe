/**
 * 
 */
package cpe.canoe.model;

import java.util.Date;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.KeyFactory;

/**
 * @author arthur
 *
 */
public class History implements IEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5885431440899079021L;

	private String key;
	private Date date;
	private Date departure;
	private String from;
	private String to;
	private int nbResponse;
	private String userKey;
	private long avgPrice;
	
	
	/**
	 * 
	 */
	public History() {
	
	}
	
	public History(Entity e) {
		this.init(e);
	}

	/* (non-Javadoc)
	 * @see cpe.canoe.model.IEntity#init(com.google.appengine.api.datastore.Entity)
	 */
	@Override
	public void init(Entity e) {
		this.key = KeyFactory.keyToString(e.getKey());
		this.date = (Date) e.getProperty("departure");
		this.from = (String) e.getProperty("from");
		this.to = (String) e.getProperty("to");
		this.departure = (Date) e.getProperty("departure");
		this.nbResponse = (Integer) ((Long)e.getProperty("nbResponse")).intValue();
		this.userKey = (String) e.getProperty("user");
		this.avgPrice = (Long) e.getProperty("avgPrice");
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return userKey;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String userKey) {
		this.userKey = userKey;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the departure
	 */
	public Date getDeparture() {
		return departure;
	}

	/**
	 * @param departure the departure to set
	 */
	public void setDeparture(Date departure) {
		this.departure = departure;
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * @return the nbResponse
	 */
	public int getNbResponse() {
		return nbResponse;
	}

	/**
	 * @param nbResponse the nbResponse to set
	 */
	public void setNbResponse(int nbResponse) {
		this.nbResponse = nbResponse;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the avgPrice
	 */
	public long getAvgPrice() {
		return avgPrice;
	}

	/**
	 * @param avgPrice the avgPrice to set
	 */
	public void setAvgPrice(long avgPrice) {
		this.avgPrice = avgPrice;
	}
	
	
}
