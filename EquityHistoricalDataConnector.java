import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
		try {
			File fname = new File("output.csv");       	
        	if(!fname.exists()) {
        		fname.createNewFile();
        		FileWriter csvWriter = new FileWriter(fname);
			    csvWriter.append("ticker");
			    csvWriter.append(",");
			    csvWriter.append("beta");
			    csvWriter.append(",");
			    csvWriter.append("volatility");
			    csvWriter.append(",");
			    csvWriter.append("quantity");
			    csvWriter.append("ticker");
			    csvWriter.append("\n");
			    String[] values = new String[] {data.getTicker().toString(), Double.toString(data.getBeta()),Double.toString(data.getVolatility()),String.valueOf(data.getQuantity())};
		        csvWriter.append(String.join(",", values));
		        csvWriter.append("\n");	
		        csvWriter.close();
		    }
        	else {
        		FileWriter csvWriter = new FileWriter(fname,true);
        		BufferedWriter bfWriter = new BufferedWriter(csvWriter);
        		String[] values = new String[] {data.getTicker().toString(), Double.toString(data.getBeta()),Double.toString(data.getVolatility()),String.valueOf(data.getQuantity())};
		        bfWriter.append(String.join(",", values));
		        bfWriter.append("\n");
		        bfWriter.close();
		        csvWriter.close();
        	}
		}
        catch (IOException e) { 
	        // TODO Auto-generated catch block 
        	System.out.println("IOException Occured");
	        e.printStackTrace(); 
	    }		
	}
}
