import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;

/**
 * Process and execute order, and notify EquityTradeBookingServiceListener
 * @author Sara Liu, Wenting Yang
 *
 */
public class EquityAlgoExecutionService extends Service<String,ExecutionOrder<Equity>> {
	private HashMap<String,ExecutionOrder<Equity>> executionOrderMap =new HashMap<String,ExecutionOrder<Equity>>();
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
		/*//*********process OrderBook<Equity> data and generate ExecutionOrder<Equity>********/
		while(!data.getOfferStack().isEmpty()&&!data.getBidStack().isEmpty()) {
			double execute_price = 0.0;
			long min_quantity = 0;
			//calculate price for ExecuteOrder
			if(data.getOfferStack().peek().getPrice()==data.getBidStack().peek().getPrice()) {
				execute_price = data.getBidStack().peek().getPrice();
			}
			else {
				execute_price = Math.round((data.getBidStack().peek().getPrice()+data.getOfferStack().peek().getPrice())/2*100.0)/100.0;
			}
			//update quantities of BidOrder and OfferOrder
			if(data.getBidStack().peek().getQuantity()<data.getOfferStack().peek().getQuantity()) {
				min_quantity = data.getBidStack().poll().getQuantity();
				data.getOfferStack().peek().setQuantity(data.getOfferStack().peek().getQuantity()-min_quantity);
			}
			else if(data.getOfferStack().peek().getQuantity()<data.getBidStack().peek().getQuantity()) {
				min_quantity = data.getOfferStack().poll().getQuantity();
				data.getBidStack().peek().setQuantity(data.getBidStack().peek().getQuantity()-min_quantity);
			}
			else {
				min_quantity = data.getOfferStack().peek().getQuantity();
				data.getOfferStack().poll();
				data.getBidStack().poll();
			}
			//decide PriceSide
			PricingSide curr_side = PricingSide.values()[new Random().nextInt(PricingSide.values().length)];
			//decide OrderType
	        OrderType curr_ordertype = OrderType.values()[new Random().nextInt(OrderType.values().length)];
	        //create ExecutionOrder
			ExecutionOrder<Equity> EO = new ExecutionOrder<Equity>(data.getProduct(),curr_side, data.getProduct().getTicker(),curr_ordertype, execute_price, min_quantity);
		    executionOrderMap.put(data.getProduct().getTicker(), EO);
			//pass to listener
			onMessage(EO);
			}		
	}
		
		
	
	@Override
	public ExecutionOrder<Equity> getData(String key) {
		
		return executionOrderMap.get(key);
	}

	@Override
	void onMessage(ExecutionOrder<Equity> executeOrder) {
		//add executeOrder to executionOrderMp
		String ticker = executeOrder.getTicker();
		executionOrderMap.put(ticker, executeOrder);
		
		for(ServiceListener<ExecutionOrder<Equity>> listener:listeners) {
			listener.processAdd(executeOrder);
		}
	}

	@Override
	void addListener(ServiceListener<ExecutionOrder<Equity>> listener) {
		
		listeners.add(listener);
	}

	@Override
	ArrayList<ServiceListener<ExecutionOrder<Equity>>> getListeners() {
		
		return listeners;
	}

}
