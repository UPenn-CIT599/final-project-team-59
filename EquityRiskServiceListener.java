
public class EquityRiskServiceListener extends ServiceListener<Position<Equity>> {
	private EquityRiskService ERService;
	private static EquityRiskServiceListener instance = null;
	
	private EquityRiskServiceListener() {}
	/**
	 * singleton - public getInstance method
	 * @return
	 */
	public static EquityRiskServiceListener getInstance() {
		if(instance == null) {
			instance = new EquityRiskServiceListener();
		}
		return instance;
	}
	
	/**
	 * notify EquityRiskService
	 */
	@Override
	void processAdd(Position<Equity> data) {
		
		ERService.assessRisk(data);
	}
	@Override
	void processRemove(Position<Equity> data) {}

	@Override
	void processUpdate(Position<Equity> data) {
		ERService.assessRisk(data);
	}
	
}


