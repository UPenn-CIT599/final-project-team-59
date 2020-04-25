import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collector;

/**
 * EquityMarketDataConnector
 * Subscribe-only class read the input file
 * @author Wenting Yang, Sara Liu
 *
 */

//TODO	
public class EquityMarketDataConnector extends Connector<OrderBook<Equity>>{
	private EquityMarketDataService EMDService;
	private HashMap<String,OrderBook<Equity>> orderBooks = new HashMap<String,OrderBook<Equity>>();
	
	private static EquityMarketDataConnector instance = null;
	private EquityMarketDataConnector() {EMDService = EquityMarketDataService.getInstance();}
	
	/**
	 * singleton pattern public getInstance methods
	 * @return
	 */
	public static EquityMarketDataConnector getInstance() {
		if(instance == null) {
			instance = new EquityMarketDataConnector();
		}
		return instance;
	}
	
	public void readTxt(String fileName) {
		  // read from the input txt file
		File inputFile = new File(fileName);
		
		try {
			Scanner reader = new Scanner(inputFile);
			
			String ticker = new String();
			long totShare = 0;
			double divYield = 0.0;
			HashMap<String,Equity> equityMap = new HashMap<String,Equity>();
			for (int i = 0; i<3; i++) {
				String[] orderInfo = reader.nextLine().split(",");
				ticker = orderInfo[0];
				totShare = Long.valueOf(orderInfo[1]);
				divYield = Double.valueOf(orderInfo[2]);
				Equity currEquity = new Equity(ticker,totShare,divYield);
				equityMap.put(ticker, currEquity);
				PriorityQueue<Order> bidStack = new PriorityQueue<Order>();
				PriorityQueue<Order> offerStack = new PriorityQueue<Order>(Collections.reverseOrder());
				OrderBook<Equity> orderBook = new OrderBook<Equity>(currEquity,bidStack,offerStack);
				orderBooks.put(ticker, orderBook);
			}
			
			
			while(reader.hasNextLine()) {
				String[] orderInfo = reader.nextLine().split(",");
				ticker = orderInfo[0];
				double price = Double.valueOf(orderInfo[1]);
				long size = Long.valueOf(orderInfo[2]);
				PricingSide side = Integer.valueOf(orderInfo[3]) == 1?PricingSide.BID:PricingSide.OFFER;
				Order currOrder = new Order(price,size,side);
				
				if(side == PricingSide.BID) {
					orderBooks.get(ticker).addBidOrder(currOrder);
					
					
				}
				else {
					orderBooks.get(ticker).addOfferOrder(currOrder);
				}
				
				EMDService.onMessage(orderBooks.get(ticker));
			}
			
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  // construct OrderBook object
		  // call OnMessage method
	}
	
	public EquityMarketDataService getService() {
		return EMDService;
	}

	@Override
	public void Publish(OrderBook<Equity> data) {
		// subscribe only
		
	}

}
