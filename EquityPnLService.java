import java.util.ArrayList;
import java.util.HashMap;

/**
 * EquityRiskService - assess risks 
 * notify EquityHistoricalDataServiceListener 
 * @author Wenting Yang, Sara Liu
 *
 */
public class EquityPnLService extends Service<String,PnL<Equity>>{
	private HashMap<String,PnL<Equity>> pnlMap = new HashMap<String,PnL<Equity>>();
	private ArrayList<ServiceListener<PnL<Equity>>> listeners = new ArrayList<ServiceListener<PnL<Equity>>>();
	private static EquityPnLService instance = null;
	
	//constructor
	private EquityPnLService() {}
	
	public static EquityPnLService getInstance() {
		if(instance == null) {
			instance = new EquityPnLService();
		}
		return instance;
	}
	
	/**
	 * add trade by process trade data and update positions
	 * @param data
	 */
	public void calcPnL(Trade<Equity> data) {
		if(pnlMap.get(data.getBook())!=null) {
			PnL<Equity> currPnl = pnlMap.get(data.getBook());
			currPnl.updatePnl(data.getQuantity(), data.getSide(), data.getPrice());
			onMessage(currPnl);
		}
		else {
			//TODO: 
		}
	}

	@Override
	public PnL<Equity> getData(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void onMessage(PnL<Equity> data) {
		
		for(ServiceListener<PnL<Equity>> listener:listeners) {
			listener.processAdd(data);
		}
		
	}

	@Override
	void addListener(ServiceListener<PnL<Equity>> listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	ArrayList<ServiceListener<PnL<Equity>>> getListeners() {
		// TODO Auto-generated method stub
		return null;
	}

	public HashMap<String,PnL<Equity>> getPnLMap() {
		return pnlMap;
	}

	public void setTradeMap(HashMap<String,PnL<Equity>> pnlMap) {
		this.pnlMap = pnlMap;
	}
	
}
