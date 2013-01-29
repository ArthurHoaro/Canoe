/**
 * 
 */
package cpe.canoe.services;

import java.util.Date;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

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
       
		return finalEntity;
	}
	
}
