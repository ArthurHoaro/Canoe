package cpe.canoe.services;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import cpe.canoe.model.Flight;
import cpe.canoe.model.User;

public class FlightService extends Service {

	public FlightService(String type) {
		super("Flight");
	}
	
	public List<Flight> getFlights(String from, String to, Date dateDepart ){
		List<Flight> flights = null;
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
	
	public void addFlight(Flight flight){
        Entity eflight = new Entity("Flight");
        eflight.setProperty("dateDepart", flight.getDateDepart());
        eflight.setProperty("dateArrivee", flight.getDateArrivee());
        eflight.setProperty("from", flight.getFrom());
        eflight.setProperty("to", flight.getTo());
        eflight.setProperty("price", flight.getPrice());
        eflight.setProperty("availableSeats", flight.getAvailableSeats());
		this.getDBInstance().put(eflight);
	}

}
