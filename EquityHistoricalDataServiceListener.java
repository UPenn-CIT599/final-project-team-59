
public class EquityHistoricalDataServiceListener extends ServiceListener<PnL<Equity>> {
	private EquityHistoricalDataConnector EHDConnector;
	private static EquityHistoricalDataServiceListener instance = null;
	
	/**
	 * singleton - private constructor
	 */
	private EquityHistoricalDataServiceListener() {EHDConnector = EquityHistoricalDataConnector.getInstance();}
	
	/**
	 * singleton - public getInstance method
	 * @return
	 */
	public static EquityHistoricalDataServiceListener getInstance() {
		if(instance == null) {
			instance = new EquityHistoricalDataServiceListener();
		}
		return instance;
	}
	
	/**
	 * notify EquityAlgoExecutionService
	 */
	@Override
	void processAdd(PnL<Equity> data) {
		
		EHDConnector.Publish(data);		
	}

	@Override
	void processRemove(PnL<Equity> data) {}

	@Override
	void processUpdate(PnL<Equity> data) {
		EHDConnector.Publish(data);		
	}
}
