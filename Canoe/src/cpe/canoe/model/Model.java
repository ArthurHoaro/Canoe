package cpe.canoe.model;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query;

public abstract class Model {
	protected String entity;
	
	public Model(String type) {
		this.entity = type;
	}
	
	public Query findAll() {
		return new Query(this.entity);
	}
	
	public Entity findByKey(Key key) throws EntityNotFoundException {
		return this.getDBInstance().get(key);
	}
	
	public final DatastoreService getDBInstance() {
		return DatastoreServiceFactory.getDatastoreService();
	}
	
	
}
