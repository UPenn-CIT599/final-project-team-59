
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestTradingSystem {

	@BeforeAll
	public static void setUp() {
		
		TradingSystemRunner runner = new TradingSystemRunner();
		runner.buildTestSystem();
		EquityMarketDataConnector EMDConnector = EquityMarketDataConnector.getInstance();
		EMDConnector.readTxt("OrderBookTest.txt");
		
	}
	

	
	@Test
	void testSystemLinkage() { 
		
		EquityTradeBookingService ETBService = EquityTradeBookingService.getInstance();
		EquityPositionService EPService = EquityPositionService.getInstance();
		System.out.println(String.valueOf(EPService.getData("Book1").getPositions()));
		assertEquals(EquityPositionServiceListener.getInstance(),ETBService.getListeners().get(0));
	}
	
	@Test
	void testPositionService() {
		EquityPositionService EPService = EquityPositionService.getInstance();
		System.out.println(String.valueOf(EPService.getData("Book1").getPositions()));
		assertEquals(200,Math.abs(EPService.getData("Book1").getPositions()));
		
	}

	
	@Test
	void testConnector() {
		EquityMarketDataConnector EMDConnector = EquityMarketDataConnector.getInstance();
		assertEquals(3,EMDConnector.getOrderBooks().size());
	}
	
	@Test
	void testAlgoExecutionService() {
		EquityAlgoExecutionService EAEService = EquityAlgoExecutionService.getInstance();
		assertEquals(281.32,EAEService.getData("APPL").getPrice());
		assertEquals(200,EAEService.getData("APPL").getQuantity());
	}
	
	
	@Test
	void testTradeBookingService() {
		EquityTradeBookingService ETBService = EquityTradeBookingService.getInstance();
		
		assertEquals("APPL",ETBService.getData("Book1").getProduct().getTicker());
		
	}
	

	
	@Test
	void testPnLService() {
		EquityPnLService EPLService = EquityPnLService.getInstance();
		assertEquals(56264.0,Math.abs(EPLService.getData("Book1").getPnl()));
		
	}
	

	

}
