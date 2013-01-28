/**
 * 
 */
package cpe.canoe.listener;

import java.io.Serializable;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author arthur
 *
 */
public final class SessionCounterListener implements HttpSessionListener, Serializable {

	private int nbSession = 0;
    
	public void sessionCreated(HttpSessionEvent event) {
		synchronized (this) {
			++nbSession;
		}
		event.getSession().setAttribute("counter", this);
    }
 
    public void sessionDestroyed(HttpSessionEvent event) {
    	synchronized (this) {
    		--nbSession;
    	}
    	event.getSession().setAttribute("counter", this);
    }

	/**
	 * @return the count of opened sessions
	 */
	public int getNb() {
		return nbSession;
	}
	
	

}
