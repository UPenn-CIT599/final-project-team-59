/**
 * publish-only connector
 * publish data to output files
 * @author Wenting Yang, Sara Liu
 *
 */
public class EquityHistoricalDataConnector extends Connector<Risk<Equity>> {
	
	private static EquityHistoricalDataConnector instance = null;
	private EquityHistoricalDataConnector() {}
	
	/**
	 * singleton pattern public getInstance methods
	 * @return
	 */
	public static EquityHistoricalDataConnector getInstance() {
		if(instance == null) {
			instance = new EquityHistoricalDataConnector();
		}
		return instance;
	}
	
	/**
	 * publish data to output file
	 */
	@Override
	public void Publish(Risk<Equity> data) {
		// TODO Auto-generated method stub
		
	}
}
