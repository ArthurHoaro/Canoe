package cpe.canoe.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import cpe.canoe.model.Flight;
import cpe.canoe.model.IEntity;
import cpe.canoe.model.User;

public class FlightService extends Service {

	public FlightService() {
		super("Flight");
	}
	
	public List<Flight> getFlights(String from, String to, Date dateDepart ){
		List<Flight> flights = new ArrayList<Flight>();
		Query q = new Query(this.entityName).addFilter("from", Query.FilterOperator.EQUAL, from)
				.addFilter("to", Query.FilterOperator.EQUAL, to).addFilter("dateDepart", Query.FilterOperator.EQUAL, dateDepart);
		PreparedQuery pq = this.getDBInstance().prepare(q);
		if(!pq.asList(FetchOptions.Builder.withDefaults()).isEmpty())
		{
			for(Entity e : pq.asList(FetchOptions.Builder.withDefaults()))
			{
				flights.add(new Flight(e));
			}
		}
		return flights;
	}
	
	protected Entity ormToEntity(IEntity iOrm, boolean newEntity){
		Entity finalEntity = null;
		Flight orm = (Flight) iOrm;
		if( newEntity ) {
			Key ukey = KeyFactory.createKey("date", orm.getDateDepart().toString() + orm.getFrom() + orm.getTo());
	        finalEntity = new Entity(this.entityName, ukey);
		} else
			try {
				finalEntity = this.getDBInstance().get(KeyFactory.stringToKey(orm.getKey()));
			} catch (EntityNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
        finalEntity.setProperty("dateDepart", orm.getDateDepart());
        finalEntity.setProperty("dateArrivee", orm.getDateArrivee());
        finalEntity.setProperty("from", orm.getFrom());
        finalEntity.setProperty("to", orm.getTo());
        finalEntity.setProperty("price", orm.getPrice());
        finalEntity.setProperty("availableSeats", orm.getAvailableSeats());
        
		return finalEntity;
	}

}
