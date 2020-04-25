
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class testMarketDataService {

	@Test
	void test() {
		EquityMarketDataConnector EMDConnector = EquityMarketDataConnector.getInstance();
		//EquityMarketDataService EMDService = EquityMarketDataService.getInstance();
		TradingSystemRunner runner = new TradingSystemRunner();
		runner.buildSystem();
		EMDConnector.readTxt("orderBook.txt");
		//BidOffer testBestBidOffer = EMDService.getBestBidOffer("APPL");
		//assertEquals(241.4,testBestBidOffer.getBidOrder().getPrice());
	}
	
	
	// connector - 1st execution - tradeBooking - position - pnl - publish 
	
	// execution - 
	
	

}
