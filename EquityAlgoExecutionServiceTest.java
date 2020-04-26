import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.PriorityQueue;
import org.junit.jupiter.api.Test;

class EquityAlgoExecutionServiceTest {
	
    //test ExecutionOrder price and quantity when bid and offer have same prices and quantities
	@Test
	void testProcessOrderEqualPriceandQuantity() {
		//create bidStack
		PriorityQueue<Order> bidStack = new PriorityQueue<Order>();
		bidStack.add(new Order(278.59,800,PricingSide.values()[0]));
		//create offerStack
		PriorityQueue<Order> offerStack = new PriorityQueue<Order>();
		offerStack.add(new Order(278.59,800,PricingSide.values()[1]));
		//create equity
		Equity eq = new Equity("APPL",438000000,1.06);
		//create an OrderBook
		OrderBook<Equity> data = new OrderBook<Equity>(eq,bidStack,offerStack);
		EquityAlgoExecutionService EAEService = EquityAlgoExecutionService.getInstance();
        EAEService.processOrder(data);
        ExecutionOrder EO= EAEService.getData("APPL");
        assertEquals(800,EO.getQuantity(),"quantity is wrong, shoule be 800");		
        assertEquals(278.59,EO.getPrice(),0.1,"price is wrong, should be 278.59");
	}
	
	//test ExecutionOrder price and quantity when bid and offer have same prices and bid quantity < offer quantity
		@Test
		void testProcessOrderEqualPriceBidQuntityIsSmaller() {
			//create bidStack
			PriorityQueue<Order> bidStack = new PriorityQueue<Order>();
			bidStack.add(new Order(278.59,790,PricingSide.values()[0]));
			//create offerStack
			PriorityQueue<Order> offerStack = new PriorityQueue<Order>();
			offerStack.add(new Order(278.59,800,PricingSide.values()[1]));
			//create equity
			Equity eq = new Equity("APPL",438000000,1.06);
			//create an OrderBook
			OrderBook<Equity> data = new OrderBook<Equity>(eq,bidStack,offerStack);
			EquityAlgoExecutionService EAEService = EquityAlgoExecutionService.getInstance();
	        EAEService.processOrder(data);
	        ExecutionOrder EO= EAEService.getData("APPL");
	        assertEquals(790,EO.getQuantity(),"quantity is wrong, shoule be 790");		
	        assertEquals(278.59,EO.getPrice(),0.1,"price is wrong, should be 278.59");
		}
		
		//test ExecutionOrder price and quantity when bid and offer have same prices and bid quantity > offer quantity
		@Test
		void testProcessOrderEqualPriceOfferQuntityIsSmaller() {
			//create bidStack
			PriorityQueue<Order> bidStack = new PriorityQueue<Order>();
			bidStack.add(new Order(278.59,800,PricingSide.values()[0]));
			//create offerStack
			PriorityQueue<Order> offerStack = new PriorityQueue<Order>();
			offerStack.add(new Order(278.59,700,PricingSide.values()[1]));
			//create equity
			Equity eq = new Equity("APPL",438000000,1.06);
			//create an OrderBook
			OrderBook<Equity> data = new OrderBook<Equity>(eq,bidStack,offerStack);
			EquityAlgoExecutionService EAEService = EquityAlgoExecutionService.getInstance();
	        EAEService.processOrder(data);
	        ExecutionOrder EO= EAEService.getData("APPL");
	        assertEquals(700,EO.getQuantity(),"quantity is wrong, shoule be 700");		
	        assertEquals(278.59,EO.getPrice(),0.05,"price is wrong, should be 278.59");
		}	
				
		//test ExecutionOrder price and quantity when bid and offer have same quantities and bid price < offer price
		@Test
		void testProcessOrderEqualQuantityBidPriceIsLower() {
			//create bidStack
			PriorityQueue<Order> bidStack = new PriorityQueue<Order>();
			bidStack.add(new Order(213.84,800,PricingSide.values()[0]));
			//create offerStack
			PriorityQueue<Order> offerStack = new PriorityQueue<Order>();
			offerStack.add(new Order(278.59,800,PricingSide.values()[1]));
			//create equity
			Equity eq = new Equity("APPL",438000000,1.06);
			//create an OrderBook
			OrderBook<Equity> data = new OrderBook<Equity>(eq,bidStack,offerStack);
			EquityAlgoExecutionService EAEService = EquityAlgoExecutionService.getInstance();
	        EAEService.processOrder(data);
	        ExecutionOrder EO= EAEService.getData("APPL");
	        assertEquals(800,EO.getQuantity(),"quantity is wrong, shoule be 800");		
	        assertEquals(246.21,EO.getPrice(),0.1,"price is wrong, should be 246.21");
		}
				
	     //test ExecutionOrder price and quantity when bid and offer have same quantities and offer price < bid price
		@Test
		void testProcessOrderEqualQuantityOfferPriceIsLower() {
			//create bidStack
			PriorityQueue<Order> bidStack = new PriorityQueue<Order>();
			bidStack.add(new Order(213.84,800,PricingSide.values()[0]));
			//create offerStack
			PriorityQueue<Order> offerStack = new PriorityQueue<Order>();
			offerStack.add(new Order(185.32,800,PricingSide.values()[1]));
			//create equity
			Equity eq = new Equity("APPL",438000000,1.06);
			//create an OrderBook
			OrderBook<Equity> data = new OrderBook<Equity>(eq,bidStack,offerStack);
			EquityAlgoExecutionService EAEService = EquityAlgoExecutionService.getInstance();
	        EAEService.processOrder(data);
	        ExecutionOrder EO= EAEService.getData("APPL");
	        assertEquals(800,EO.getQuantity(),"quantity is wrong, shoule be 800");		
	        assertEquals(199.58,EO.getPrice(),0.1,"price is wrong, should be 199.58");
		}
				
     //test ExecutionOrder price and quantity when bid and offer have same quantities and offer price < bid price
	   @Test
	   void testProcessOrderNotEqualQuantityNotEqualPrice() {
			//create bidStack
			PriorityQueue<Order> bidStack = new PriorityQueue<Order>();
			bidStack.add(new Order(213.84,800,PricingSide.values()[0]));
			//create offerStack
			PriorityQueue<Order> offerStack = new PriorityQueue<Order>();
			offerStack.add(new Order(185.32,718,PricingSide.values()[1]));
			//create equity
			Equity eq = new Equity("APPL",438000000,1.06);
			//create an OrderBook
			OrderBook<Equity> data = new OrderBook<Equity>(eq,bidStack,offerStack);
			EquityAlgoExecutionService EAEService = EquityAlgoExecutionService.getInstance();
	        EAEService.processOrder(data);
	        ExecutionOrder EO= EAEService.getData("APPL");
	        assertEquals(718,EO.getQuantity(),"quantity is wrong, shoule be 718");		
	        assertEquals(199.58,EO.getPrice(),0.1,"price is wrong, should be 199.58");
			}		
}
