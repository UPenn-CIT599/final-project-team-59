
/**
 * EquityAlgoExecutionServiceListener get notification from EquityMarketDataService 
 * and notify the EquityAlgoExecutionServiceListener with the data it obtains
 * @author Wenting Yang, Sara Liu
 *
 */
public class EquityAlgoExecutionServiceListener extends ServiceListener<OrderBook<Equity>> {
	private EquityAlgoExecutionService EAEService;
	private static EquityAlgoExecutionServiceListener instance = null;
	
	/**
	 * singleton - private constructor
	 */
	private EquityAlgoExecutionServiceListener() {EAEService = EquityAlgoExecutionService.getInstance();}
	
	/**
	 * singleton - public getInstance method
	 * @return
	 */
	public static EquityAlgoExecutionServiceListener getInstance() {
		if(instance == null) {
			instance = new EquityAlgoExecutionServiceListener();
		}
		return instance;
	}
	
	/**
	 * notify EquityAlgoExecutionService
	 */
	@Override
	void processAdd(OrderBook<Equity> data) {
		
		EAEService.processOrder(data);		
	}

	@Override
	void processRemove(OrderBook<Equity> data) {}

	@Override
	void processUpdate(OrderBook<Equity> data) {
		EAEService.processOrder(data);
	}
	
	
}
