package cpe.canoe.services;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.apache.jsp.ah.datastoreViewerBody_jsp;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import cpe.canoe.model.IEntity;

public abstract class Service {
	protected String entityName;
	
	public Service(String type) {
		this.entityName = type;
	}
	
	public ArrayList<IEntity> findAll() {
		Query q = new Query(this.entityName);
		PreparedQuery pq = this.getDBInstance().prepare(q);
		ArrayList<IEntity> entities = new ArrayList<IEntity>();
		for( Entity e : pq.asList(FetchOptions.Builder.withDefaults() )) {
			try {
				Object obj = Class.forName(this.entityName).newInstance();
				((IEntity) obj).init(e);
				entities.add((IEntity) obj);
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return entities;
	}
	
	public IEntity findByKey(Key key) throws EntityNotFoundException {
		Object obj = null;
		try {
			obj = Class.forName(this.entityName).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((IEntity) obj).init(this.getDBInstance().get(key));
		return (IEntity) obj;
	}
	
	public void remove(Key key) {
		this.getDBInstance().delete(key);
	}
	
	public final DatastoreService getDBInstance() {
		return DatastoreServiceFactory.getDatastoreService();
	}
	
	
}
