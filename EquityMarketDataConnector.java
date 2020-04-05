
public class EquityMarketDataConnector extends Connector<OrderBook<Equity>>{
	private EquityMarketDataService EMDService;
	private EquityMarketDataConnector() {}
	
	public static EquityMarketDataConnector getInstance() {
		final EquityMarketDataConnector instance = new EquityMarketDataConnector();
		return instance;
	}
	
	public void readTxt() {
		  // read from the marketdate.txt
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
