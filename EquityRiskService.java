import java.util.ArrayList;
import java.util.HashMap;

/**
 * EquityPositionService - addTrade to book position 
 * notify EquityRiskServiceListener 
 * @author Wenting Yang, Sara Liu
 *
 */
public class EquityRiskService extends Service<String,Risk<Equity>>{
	private HashMap<String,Risk<Equity>> riskMap = new HashMap<String,Risk<Equity>>();
	private ArrayList<ServiceListener<Risk<Equity>>> listeners = new ArrayList<ServiceListener<Risk<Equity>>>();
	private static EquityRiskService instance = null;
	
	//constructor
	private EquityRiskService() {}
	
	public static EquityRiskService getInstance() {
		if(instance == null) {
			instance = new EquityRiskService();
		}
		return instance;
	}
	
	/**
	 * add trade by process trade data and update positions
	 * @param data
	 */
	public void assessRisk(Position<Equity> data) {
		
	}

	@Override
	public Risk<Equity> getData(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void onMessage(Risk<Equity> data) {
		
		for(ServiceListener<Risk<Equity>> listener:listeners) {
			listener.processAdd(data);
		}
		
	}

	@Override
	void addListener(ServiceListener<Risk<Equity>> listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	ArrayList<ServiceListener<Risk<Equity>>> getListeners() {
		// TODO Auto-generated method stub
		return null;
	}

	public HashMap<String,Risk<Equity>> getRiskMap() {
		return riskMap;
	}

	public void setTradeMap(HashMap<String,Risk<Equity>> riskMap) {
		this.riskMap = riskMap;
	}
	
}
