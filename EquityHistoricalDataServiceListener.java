
public class EquityHistoricalDataServiceListener extends ServiceListener<PnL<Equity>> {
	private EquityHistoricalDataService EHDService;
	private static EquityHistoricalDataServiceListener instance = null;
	
	/**
	 * singleton - private constructor
	 */
	private EquityHistoricalDataServiceListener() {EHDService = EquityHistoricalDataService.getInstance();}
	
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
		
		EHDService.persistData(data);		
	}

	@Override
	void processRemove(PnL<Equity> data) {}

	@Override
	void processUpdate(PnL<Equity> data) {
		EHDService.persistData(data);	
	}
}
