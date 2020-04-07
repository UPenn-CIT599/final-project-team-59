import java.util.HashMap;
import java.util.ArrayList;

/**
 * Process and execute order, and notify EquityTradeBookingServiceListener
 * @author Sara Liu, Wenting Yang
 *
 */
public class EquityAlgoExecutionService extends Service<String,ExecutionOrder<Equity>> {
	private HashMap<String,ExecutionOrder<Equity>> executionOrderMap =new HashMap<String,ExecutionOrder<Equity>>();
	//TODO: ExecutionOrder
	private ArrayList<ServiceListener<ExecutionOrder<Equity>>> listeners = new ArrayList<ServiceListener<ExecutionOrder<Equity>>>();
	private static EquityAlgoExecutionService instance = null;
	
	//constructor
	private EquityAlgoExecutionService(){}
	
	
	public static EquityAlgoExecutionService getInstance() {
		if(instance == null) {
			instance = new EquityAlgoExecutionService();
		}
		return instance;
	}
	
	/**
	 * process order and execute
	 * notify and pass the ExecutionOrder to 
	 * EquityTradeBookingServiceListener by calling onMessage() method
	 * @param data
	 */
	public void processOrder(OrderBook<Equity> data) {
		//process OrderBook<Equity> data
		
	}


	
	@Override
	public ExecutionOrder<Equity> getData(String key) {
		// TODO Auto-generated method stub
		return executionOrderMap.get(key);
	}

	@Override
	void onMessage(ExecutionOrder<Equity> orderBook) {
		// TODO Auto-generated method stub
		for(ServiceListener<ExecutionOrder<Equity>> listener:listeners) {
			listener.processAdd(orderBook);
		}
	}

	@Override
	void addListener(ServiceListener<ExecutionOrder<Equity>> listener) {
		// TODO Auto-generated method stub
		listeners.add(listener);
	}

	@Override
	ArrayList<ServiceListener<ExecutionOrder<Equity>>> getListeners() {
		// TODO Auto-generated method stub
		return listeners;
	}








}
