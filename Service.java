
import java.util.ArrayList;
/**
 * Definition of a generic base class Service.
 * Uses key generic type K and value generic type V.
 */
abstract public class Service <K,V> {
	/** 
	 * Get data on our service given a key
	 * return the reference of the data (need to use non-primitive method) 
	 * */
	abstract public V getData(K key);
	
	/**  
	 * The callback that a Connector should invoke for any new or updated data
	 * passing the reference of the data
	 * */
	abstract void onMessage(V data);
	
	/**
	 *Add a listener to the Service for callbacks on add, remove, and update events
	 *for data to the Service.
	 */
	abstract void addListener(ServiceListener<V> listener);
	
	/**Get all listeners on the Service.*/
	abstract ArrayList<ServiceListener<V>> getListeners();
}
