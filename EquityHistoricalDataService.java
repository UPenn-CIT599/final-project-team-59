import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author Wenting Yang, Sara Liu
 *
 */
public class EquityHistoricalDataService extends Service<String,Risk<Equity>> {
	HashMap<String,Risk<Equity>> riskMap;
	EquityHistoricalDataConnector EHDConnector;
	private static EquityHistoricalDataService instance = null;
	
	/**
	 * constructor
	 * Singleton pattern - private ctor
	 */
	private EquityHistoricalDataService() {}
	
	/**
	 * singleton pattern public getInstance methods
	 * @return
	 */
	public static EquityHistoricalDataService getInstance() {
		if(instance == null) {
			instance = new EquityHistoricalDataService();
		}
		return instance;
	}
	
	/**
	 * persist data and call EquityHistoricalDataConnector publish() method
	 * @param data
	 */
	public void persistData(Risk<Equity> data) {
		
	}

	
	
	@Override
	public Risk<Equity> getData(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	// register to publish-only connector, no onMessage implementation
	void onMessage(Risk<Equity> data) {}

	@Override
	void addListener(ServiceListener<Risk<Equity>> listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	ArrayList<ServiceListener<Risk<Equity>>> getListeners() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
