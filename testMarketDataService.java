import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testMarketDataService {

	@Test
	void test() {
		EquityMarketDataConnector EMDConnector = EquityMarketDataConnector.getInstance();
		EquityMarketDataService EMDService = EquityMarketDataService.getInstance();
		EMDConnector.readTxt("orderBook.txt");
		BidOffer testBestBidOffer = EMDService.getBestBidOffer("APPL");
		assertEquals(241.4,testBestBidOffer.getBidOrder().getPrice());
	}
	
	

}
