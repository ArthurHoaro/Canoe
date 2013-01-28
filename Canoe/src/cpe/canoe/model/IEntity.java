package cpe.canoe.model;

import com.google.appengine.api.datastore.Entity;

public interface IEntity {
	public void init(Entity e);
}
