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
			pnlMap.get(data.getBook()).updatePnl(data.getQuantity(), data.getSide(), data.getPrice());
			
			onMessage(pnlMap.get(data.getBook()));
		}
		else {
			String currBook = data.getBook();
			Equity currEquity = data.getProduct();
			PnL<Equity> currPnl = new PnL<Equity>();
			currPnl.setPnl(0.0);
			currPnl.setProduct(currEquity);
			currPnl.setBook(currBook);
			currPnl.updatePnl(data.getQuantity(),data.getSide(),data.getPrice());
			pnlMap.put(currBook, currPnl);
			onMessage(pnlMap.get(data.getBook()));
			
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
		listeners.add(listener);
		
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
