
public class EquityTradeBookingServiceListener extends ServiceListener<ExecutionOrder<Equity>> {
	private EquityTradeBookingService ETBService;
	private static EquityTradeBookingServiceListener instance = null;
	
	//constructor
	private EquityTradeBookingServiceListener() {}
	
	/**
	 * singleton - public getInstance method
	 * @return
	 */
	public static EquityTradeBookingServiceListener getInstance() {
		if(instance == null) {
			instance = new EquityTradeBookingServiceListener();
		}
		return instance;
	}
	
	@Override
	void processAdd(ExecutionOrder<Equity> data) {
		// TODO Auto-generated method stub
		ETBService.bookTrades(data);
	}

	@Override
	void processRemove(ExecutionOrder<Equity> data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void processUpdate(ExecutionOrder<Equity> data) {
		// TODO Auto-generated method stub
		
	}

}
