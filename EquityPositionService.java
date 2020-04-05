import java.util.ArrayList;
import java.util.HashMap;

/**
 * EquityPositionService - addTrade to book position 
 * notify EquityRiskServiceListener 
 * @author Wenting Yang, Sara Liu
 *
 */
public class EquityPositionService extends Service<String,Position<Equity>>{
	private HashMap<String,Position<Equity>> positionMap = new HashMap<String,Position<Equity>>();
	private ArrayList<ServiceListener<Position<Equity>>> listeners = new ArrayList<ServiceListener<Position<Equity>>>();
	private static EquityPositionService instance = null;
	
	//constructor
	private EquityPositionService() {}
	
	public static EquityPositionService getInstance() {
		if(instance == null) {
			instance = new EquityPositionService();
		}
		return instance;
	}
	
	/**
	 * add trade by process trade data and update positions
	 * @param data
	 */
	public void addTrade(Trade<Equity> data) {
		
	}

	@Override
	public Position<Equity> getData(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void onMessage(Position<Equity> data) {
		
		for(ServiceListener<Position<Equity>> listener:listeners) {
			listener.processAdd(data);
		}
		
	}

	@Override
	void addListener(ServiceListener<Position<Equity>> listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	ArrayList<ServiceListener<Position<Equity>>> getListeners() {
		// TODO Auto-generated method stub
		return null;
	}

	public HashMap<String,Position<Equity>> getTradeMap() {
		return positionMap;
	}

	public void setTradeMap(HashMap<String,Position<Equity>> positonMap) {
		this.positionMap = positonMap;
	}
	
}
