/**
 * EquityPositionServiceListener - get data from EquityTradeBookingService and notify EquityPositionService
 * @author Wenting Yang, Sara Liu
 *
 */
public class EquityPositionServiceListener extends ServiceListener<Trade<Equity>> {
	private EquityPositionService EPService;
	private static EquityPositionServiceListener instance = null;
	
	private EquityPositionServiceListener() {}
	/**
	 * singleton - public getInstance method
	 * @return
	 */
	public static EquityPositionServiceListener getInstance() {
		if(instance == null) {
			instance = new EquityPositionServiceListener();
		}
		return instance;
	}
	

	/**
	 * notify EquityPositionService
	 */
	@Override
	void processAdd(Trade<Equity> data) {
		
		EPService.addTrade(data);
	}
	@Override
	void processRemove(Trade<Equity> data) {}

	@Override
	void processUpdate(Trade<Equity> data) {
		EPService.addTrade(data);
	}
	
}

