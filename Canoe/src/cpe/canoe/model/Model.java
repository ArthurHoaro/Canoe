package cpe.canoe.model;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;

public abstract class Model {
	protected String type;
	
	public Model(String type) {
		this.type = type;
	}
	
	public final DatastoreService getDBInstance() {
		return DatastoreServiceFactory.getDatastoreService();
	}
	
	
}
