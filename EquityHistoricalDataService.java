import java.util.ArrayList;
import java.util.HashMap;

/**
 * notify output connector via EquityHistoricalDataServiceConnector.publish() method
 * @author Wenting Yang, Sara Liu
 *
 */
public class EquityHistoricalDataService extends Service<String,PnL<Equity>> {
	HashMap<String,PnL<Equity>> riskMap;
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
	public void persistData(PnL<Equity> data) {
		//TODO: 
	}

	
	
	@Override
	public PnL<Equity> getData(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	// register to publish-only connector, no onMessage implementation
	void onMessage(PnL<Equity> data) {}

	@Override
	void addListener(ServiceListener<PnL<Equity>> listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	ArrayList<ServiceListener<PnL<Equity>>> getListeners() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
