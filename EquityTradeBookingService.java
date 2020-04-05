import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class EquityTradeBookingService extends Service<String,Trade<Equity>>{
	private HashMap<String,Trade<Equity>> tradeMap = new HashMap<String,Trade<Equity>>();
	private ArrayList<ServiceListener<Trade<Equity>>> listeners = new ArrayList<ServiceListener<Trade<Equity>>>();
	private static EquityTradeBookingService instance = null;
	
	//constructor
	private EquityTradeBookingService() {}
	
	public static EquityTradeBookingService getInstance() {
		if(instance == null) {
			instance = new EquityTradeBookingService();
		}
		return instance;
	}
	
	//book trades
	public void bookTrades(ExecutionOrder<Equity> data) {
		
	}

	@Override
	public Trade<Equity> getData(String key) {
		// TODO Auto-generated method stub
		return tradeMap.get(key);
	}

	@Override
	void onMessage(Trade<Equity> data) {
		// TODO Auto-generated method stub
		for(ServiceListener<Trade<Equity>> listener:listeners) {
			listener.processAdd(data);
		}
	}

	@Override
	// register new listener
	void addListener(ServiceListener<Trade<Equity>> listener) {
		listeners.add(listener);
		
	}

	@Override
	ArrayList<ServiceListener<Trade<Equity>>> getListeners() {
		// TODO Auto-generated method stub
		return listeners;
	}

}
