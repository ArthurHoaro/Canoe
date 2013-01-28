package cpe.canoe.model;

import java.io.Serializable;

import com.google.appengine.api.datastore.Entity;

public interface IEntity extends Serializable {
	public void init(Entity e);
}
