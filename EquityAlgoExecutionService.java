import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.ArrayList;

/**
 * Process and execute order, and notify EquityTradeBookingServiceListener
 * @author Sara Liu, Wenting Yang
 *
 */
public class EquityAlgoExecutionService extends Service<String,ExecutionOrderBook<Equity>> {
	private HashMap<String,ExecutionOrderBook<Equity>> executionOrderMap =new HashMap<String,ExecutionOrderBook<Equity>>();
	private ArrayList<ServiceListener<ExecutionOrderBook<Equity>>> listeners = new ArrayList<ServiceListener<ExecutionOrderBook<Equity>>>();
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
		/*//*********process OrderBook<Equity> data and generate ExecutionOrderBook<Equity>********/
		PriorityQueue<ExecutionOrder> exeBidStack = new PriorityQueue<ExecutionOrder>();
		PriorityQueue<ExecutionOrder> exeOfferStack = new PriorityQueue<ExecutionOrder>();
		while(!data.getOfferStack().isEmpty()&&!data.getBidStack().isEmpty()) {
		double execute_price = 0.0;
		long min_quantity = 0;
		//calculate price for ExecuteOrder
		if(data.getOfferStack().peek().getPrice()==data.getBidStack().peek().getPrice()) {
			execute_price = data.getBidStack().peek().getPrice();
		}
		else {
			execute_price = (data.getBidStack().peek().getPrice()+data.getOfferStack().peek().getPrice())/2;
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
        //update BiStack and OfferStack
		if(curr_side == PricingSide.BID) {
			exeBidStack.add(new ExecutionOrder(curr_side, curr_ordertype, execute_price, min_quantity));
		}
		else {exeOfferStack.add(new ExecutionOrder(curr_side, curr_ordertype, execute_price, min_quantity));
		}	
	  }		
		//generate ExecutionOrderBook
		ExecutionOrderBook EOBook = new ExecutionOrderBook(data.getProduct(), exeBidStack, exeOfferStack);
		//add to executionOrderMap
		String ticker = data.getProduct().getTicker();
		executionOrderMap.put(ticker,EOBook);
	}
		
		
	
	@Override
	public ExecutionOrderBook<Equity> getData(String key) {
		// TODO Auto-generated method stub
		return executionOrderMap.get(key);
	}

	@Override
	void onMessage(ExecutionOrderBook<Equity> executeOrder) {
		// TODO Auto-generated method stub
		for(ServiceListener<ExecutionOrderBook<Equity>> listener:listeners) {
			listener.processAdd(executeOrder);
		}
	}

	@Override
	void addListener(ServiceListener<ExecutionOrderBook<Equity>> listener) {
		// TODO Auto-generated method stub
		listeners.add(listener);
	}

	@Override
	ArrayList<ServiceListener<ExecutionOrderBook<Equity>>> getListeners() {
		// TODO Auto-generated method stub
		return listeners;
	}








}
