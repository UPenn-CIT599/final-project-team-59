
public class TradingSystemRunner {
	/**
	 * For run system purpose
	 */
	public static void buildSystem() {
		
		EquityMarketDataService EMDService = EquityMarketDataService.getInstance();
		EquityAlgoExecutionServiceListener EAEListener = EquityAlgoExecutionServiceListener.getInstance();
		EMDService.addListener(EAEListener);
		EquityAlgoExecutionService EAEService = EquityAlgoExecutionService.getInstance();
		EquityTradeBookingServiceListener ETBListener = EquityTradeBookingServiceListener.getInstance();
		EAEService.addListener(ETBListener);
		EquityTradeBookingService ETBService = EquityTradeBookingService.getInstance();
		EquityPositionServiceListener EPListener = EquityPositionServiceListener.getInstance();
		ETBService.addListener(EPListener);
		EquityPositionService EPService = EquityPositionService.getInstance();
		EquityPnLServiceListener EPLListener = EquityPnLServiceListener.getInstance();
		ETBService.addListener(EPLListener);
		EquityPnLService EPLService = EquityPnLService.getInstance();
		EquityHistoricalDataServiceListener EHDListener = EquityHistoricalDataServiceListener.getInstance();
		EPLService.addListener(EHDListener);
	
    }
	
	/**
	 * For unit test purpose
	 */
	public void buildTestSystem() {
		
		EquityMarketDataService EMDService = EquityMarketDataService.getInstance();
		EquityAlgoExecutionServiceListener EAEListener = EquityAlgoExecutionServiceListener.getInstance();
		EMDService.addListener(EAEListener);
		EquityAlgoExecutionService EAEService = EquityAlgoExecutionService.getInstance();
		EquityTradeBookingServiceListener ETBListener = EquityTradeBookingServiceListener.getInstance();
		EAEService.addListener(ETBListener);
		EquityTradeBookingService ETBService = EquityTradeBookingService.getInstance();
		EquityPositionServiceListener EPListener = EquityPositionServiceListener.getInstance();
		ETBService.addListener(EPListener);
		EquityPositionService EPService = EquityPositionService.getInstance();
		EquityPnLServiceListener EPLListener = EquityPnLServiceListener.getInstance();
		ETBService.addListener(EPLListener);
		EquityPnLService EPLService = EquityPnLService.getInstance();

    }
	
	public static void main(String[]args) {
		buildSystem();
		EquityMarketDataConnector EMDConnector = EquityMarketDataConnector.getInstance();
		EMDConnector.readTxt("OrderBook.txt");
		
	}
	
}
