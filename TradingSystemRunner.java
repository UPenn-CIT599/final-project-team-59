
public class TradingSystemRunner {
	public void buildSystem() {
		EquityMarketDataConnector EMDConnector = EquityMarketDataConnector.getInstance();
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
		EPService.addListener(EPLListener);
		EquityPnLService EPLService = EquityPnLService.getInstance();
		EquityHistoricalDataServiceListener EHDListener = EquityHistoricalDataServiceListener.getInstance();
		EPLService.addListener(EHDListener);
		EquityHistoricalDataService EHDService = EquityHistoricalDataService.getInstance();
		EquityHistoricalDataConnector EHDConnector = EquityHistoricalDataConnector.getInstance();
    }
	
	public void main(String[]args) {
		buildSystem();
		EquityMarketDataConnector EMDConnector = EquityMarketDataConnector.getInstance();
		EMDConnector.readTxt("orderBook.txt");
		//BidOffer testBestBidOffer = EMDService.getBestBidOffer("APPL");
	}
	
}
