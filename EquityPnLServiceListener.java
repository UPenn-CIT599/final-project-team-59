
public class EquityPnLServiceListener extends ServiceListener<Trade<Equity>> {
	private EquityPnLService ERService;
	private static EquityPnLServiceListener instance = null;
	
	private EquityPnLServiceListener() {}
	/**
	 * singleton - public getInstance method
	 * @return
	 */
	public static EquityPnLServiceListener getInstance() {
		if(instance == null) {
			instance = new EquityPnLServiceListener();
		}
		return instance;
	}
	
	/**
	 * notify EquityRiskService
	 */
	@Override
	void processAdd(Trade<Equity> data) {
		
		ERService.calcPnL(data);
	}
	@Override
	void processRemove(Trade<Equity> data) {}

	@Override
	void processUpdate(Trade<Equity> data) {
		ERService.calcPnL(data);
	}
	
}


