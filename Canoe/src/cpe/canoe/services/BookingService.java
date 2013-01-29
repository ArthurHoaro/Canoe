/**
 * 
 */
package cpe.canoe.services;

import java.util.ArrayList;
import java.util.Date;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import cpe.canoe.model.Booking;
import cpe.canoe.model.Flight;
import cpe.canoe.model.History;
import cpe.canoe.model.IEntity;
import cpe.canoe.model.User;

/**
 * @author arthur
 *
 */
public class BookingService extends Service {

	/**
	 * 
	 */
	public BookingService() {
		super("Booking");
	}
	
	public ArrayList<Booking> findAllFromUser(User user) {
		ArrayList<Booking> list = new ArrayList<Booking>();
		Query q = new Query(this.entityName).addFilter("userKey", Query.FilterOperator.EQUAL, user.getKey());
		PreparedQuery pq = this.getDBInstance().prepare(q);
		for(Entity en : pq.asList(FetchOptions.Builder.withDefaults()) )
			list.add(new Booking(en));	
		
		return list;
	}
	
	protected Entity ormToEntity(IEntity iOrm, boolean newEntity){
		Entity finalEntity = null;
		Booking orm = (Booking) iOrm;
		if( newEntity ) {
			Key ukey = KeyFactory.createKey("user-flight", orm.getUserKey().toString() + orm.getFlightKey().toString());
	        finalEntity = new Entity(this.entityName, ukey);
		} else
			try {
				finalEntity = this.getDBInstance().get(KeyFactory.stringToKey(orm.getKey()));
			} catch (EntityNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
        finalEntity.setProperty("userKey", orm.getUserKey());
        finalEntity.setProperty("flightKey", orm.getFlightKey());
        finalEntity.setProperty("numberOfSeats", orm.getNumberOfSeats());       
        if( newEntity )
        	finalEntity.setProperty("date", new Date());       	
		return finalEntity;
	}
	
}
