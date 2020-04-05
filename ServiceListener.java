/**
 * Definition of a generic base class ServiceListener to listen to add, update, and remove
 * events on a Service. This listener should be registered on a Service for the Service
 * to notify all listeners for these events.
 */
abstract public class ServiceListener <V> {
	
	
	/**Listener callback to process an add event to the Service*/
	abstract void processAdd(V data);

	/**Listener callback to process a remove event to the Service*/
	abstract void processRemove(V data);
	

	/**Listener callback to process an update event to the Service*/
	abstract void processUpdate(V data);

}
