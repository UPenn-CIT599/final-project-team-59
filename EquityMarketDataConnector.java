import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * EquityMarketDataConnector
 * Subscribe-only class read the input file
 * @author Wenting Yang, Sara Liu
 *
 */

//TODO	
public class EquityMarketDataConnector extends Connector<OrderBook<Equity>>{
	private EquityMarketDataService EMDService;
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
			ArrayList<Order> currBidStack = new ArrayList<Order>();
			ArrayList<Order> currOfferStack = new ArrayList<Order>();
			String ticker = new String();
			long totShare = 0;
			double divYield = 0.0;
			String[] orderInfo = reader.nextLine().split(",");
			ticker = orderInfo[0];
			totShare = Long.valueOf(orderInfo[1]);
			divYield = Double.valueOf(orderInfo[2]);
			Equity currEquity = new Equity(ticker,totShare,divYield);
			//System.out.println(currEquity.getTicker()+";"+currEquity.getTotalShares());
			while(reader.hasNextLine()) {
				orderInfo = reader.nextLine().split(",");
				double currBidPrice = Double.valueOf(orderInfo[0]);
				double currOfferPrice = Double.valueOf(orderInfo[2]);
				long currBidSize = Long.valueOf(orderInfo[1]);
				long currOfferSize = Long.valueOf(orderInfo[3]);
				//System.out.println(currBidPrice +"; "+currBidSize);
				currBidStack.add(new Order(currBidPrice,currBidSize,PricingSide.BID));
				currOfferStack.add(new Order(currOfferPrice,currOfferSize,PricingSide.OFFER));
				
			}
			//ticker = orderInfo[0];
			//System.out.println(currOfferStack.get(0).getQuantity());
			
			OrderBook<Equity> currOrderBook = new OrderBook<Equity>(currEquity,currBidStack,currOfferStack);
			//System.out.println(ticker);
			EMDService.onMessage(currOrderBook);
			
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
