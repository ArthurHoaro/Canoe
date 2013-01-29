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
	private Date departure;
	private String from;
	private String to;
	private int nbResponse;
	private User user;
	
	
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
		this.from = (String) e.getProperty("from");
		this.to = (String) e.getProperty("to");
		this.departure = (Date) e.getProperty("departure");
		this.nbResponse = (Integer) e.getProperty("nbResponse");
		this.user = (User) e.getProperty("user");
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
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
	
	
}
