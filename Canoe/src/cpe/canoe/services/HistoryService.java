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

import cpe.canoe.model.Flight;
import cpe.canoe.model.History;
import cpe.canoe.model.IEntity;
import cpe.canoe.model.User;

/**
 * @author arthur
 *
 */
public class HistoryService extends Service {

	/**
	 * 
	 */
	public HistoryService() {
		super("History");
	}
	
	public ArrayList<History> findAllFromUser(User user) {
		ArrayList<History> list = new ArrayList<History>();
		Query q = new Query(this.entityName).addFilter("userKey", Query.FilterOperator.EQUAL, KeyFactory.stringToKey(user.getKey()));
		PreparedQuery pq = this.getDBInstance().prepare(q);
		for(Entity en : pq.asList(FetchOptions.Builder.withDefaults()) )
			list.add(new History(en));	
		
		return list;
	}
	
	protected Entity ormToEntity(IEntity iOrm, boolean newEntity){
		Entity finalEntity = null;
		History orm = (History) iOrm;
		if( newEntity ) {
			Key ukey = KeyFactory.createKey("date-from-to", orm.getDeparture().toString() + orm.getFrom() + orm.getTo());
	        finalEntity = new Entity(this.entityName, ukey);
		} else
			try {
				finalEntity = this.getDBInstance().get(KeyFactory.stringToKey(orm.getKey()));
			} catch (EntityNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
        finalEntity.setProperty("departure", orm.getDeparture());
        finalEntity.setProperty("from", orm.getFrom());
        finalEntity.setProperty("to", orm.getTo());
        finalEntity.setProperty("nbResponse", orm.getNbResponse());
        finalEntity.setProperty("user", orm.getUser());
        finalEntity.setProperty("avgPrice", orm.getAvgPrice());
        if( newEntity )
        	finalEntity.setProperty("date", new Date());
        	
		return finalEntity;
	}
	
}
