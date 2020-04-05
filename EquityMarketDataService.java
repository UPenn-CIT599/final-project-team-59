import java.util.HashMap;
import java.util.ArrayList;

/**
 * EquityMareketDataService, subscribe at EquityMarketDataConnector, get data once connector read in the input file
 * @author Wenting Yang, Sara Liu
 *
 */
public class EquityMarketDataService extends Service<String,OrderBook<Equity>>{
	private HashMap<String,OrderBook<Equity>> orderBookMap = new HashMap<String,OrderBook<Equity>>(); //ticker to OrderBook map
	private ArrayList<ServiceListener<OrderBook<Equity>>> listeners = new ArrayList<ServiceListener<OrderBook<Equity>>>();
	private static EquityMarketDataService instance = null;
	
	/**
	 * constructor
	 * Singleton pattern - private ctor
	 */
	private EquityMarketDataService() {}
	
	/**
	 * singleton pattern public getInstance methods
	 * @return
	 */
	public static EquityMarketDataService getInstance() {
		if(instance == null) {
			instance = new EquityMarketDataService();
		}
		return instance;
	}
	
	public HashMap<String, OrderBook<Equity>> getOrderBookMap() {
		return orderBookMap;
	}

	public void setOrderBookMap(HashMap<String, OrderBook<Equity>> orderBookMap) {
		this.orderBookMap = orderBookMap;
	}


	
	/**
	 * grab the best bid order and best offer order
	 * @param ticker
	 * @return
	 */
	//TODO: write the unit test for getBestBidOffer function
	BidOffer getBestBidOffer(String ticker) {
		OrderBook<Equity> tickerOrderBook = orderBookMap.get(ticker);
		Order bestBid = tickerOrderBook.getBidStack().get(0);
		Order bestOffer = tickerOrderBook.getOfferStack().get(0);
		BidOffer bestBidOffer = new BidOffer(bestBid,bestOffer);
		return bestBidOffer;
	}
	
	
	/**
	 * get the depth of the order book
	 * @param productId
	 * @return
	 */
	OrderBook<Equity> aggregateDepth(String ticker) {
		return orderBookMap.get(ticker);
		
	}
	
	/**
	 * override base class getData method
	 */
	@Override
	public OrderBook<Equity> getData(String key) {
		
		return orderBookMap.get(key);
	}
	
	/**
	 * override base class onMessage method
	 * notify EquityAlgoExecutionServiceListener 
	 */
	@Override
	void onMessage(OrderBook<Equity> orderBook) {
		
		String ticker = orderBook.getProduct().getTicker();
		//System.out.println(ticker);
		orderBookMap.put(ticker,orderBook);
		
		//System.out.println(orderBook.getOfferStack().get(0).getPrice());
		for(ServiceListener<OrderBook<Equity>> listener:listeners) {
			listener.processAdd(orderBook);
		}		
	}
	
	/**
	 * override base class addListerner method
	 * polymorphism - add OrderBook<Equity> type listener, can be used to add EquityAlgoExecutionServiceListener
	 * @param listener
	 */
	@Override
	void addListener(ServiceListener<OrderBook<Equity>> listener) {
		listeners.add(listener);
	}
	
	@Override
	ArrayList<ServiceListener<OrderBook<Equity>>> getListeners() {
		return listeners;
	}
}
