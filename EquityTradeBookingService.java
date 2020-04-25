import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
/**
 * EquityTradeBookingService - book trade 
 * notify EquityPositionServiceListener 
 * @author Sara Liu, Wenting Yang
 *
 */
public class EquityTradeBookingService extends Service<String,Trade<Equity>>{
	private HashMap<String,Trade<Equity>> tradeMap = new HashMap<String,Trade<Equity>>();
	private ArrayList<ServiceListener<Trade<Equity>>> listeners = new ArrayList<ServiceListener<Trade<Equity>>>();
	private static EquityTradeBookingService instance = null;
	private List<Long> tradeIds;
	private static int ind = 0;//keep trade id unique
	private String[] bookList = {"Book1","Book2","Book3"};
	
	//constructor
	private EquityTradeBookingService() {
		LongStream tradeIdStream = LongStream.range(100000, 400000);
		tradeIds = tradeIdStream.boxed().collect(Collectors.toList());
		Collections.shuffle(tradeIds);
	}
	
	public static EquityTradeBookingService getInstance() {
		if(instance == null) {
			instance = new EquityTradeBookingService();
		}
		return instance;
	}
	
	
	//book trades
	public void bookTrades(ExecutionOrder<Equity> data) {
		//generate trade id 
		Long currTradeId = tradeIds.get(ind);
		String ticker = data.getTicker();
		String currBook = new String();
		if (ticker.equals("APPL")) {
			currBook = bookList[0];
		}
		else if (ticker.equals("ZM")) {
			currBook = bookList[1];
		}
		else {
			currBook = bookList[2];
		}
		Trade<Equity> currTrade = new Trade<Equity>(data.getProduct(),Long.toString(currTradeId),
				data.getPrice(),currBook,data.getQuantity(),TradeSide.values()[data.getSide().ordinal()]);
		ind++;
		onMessage(currTrade);
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
