import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class EquityHistoricalDataConnectorTest {	
	
	static ArrayList<String> output = new ArrayList<>();
	EquityHistoricalDataConnector EHDConnector = EquityHistoricalDataConnector.getInstance();
	
	//test to check if output.csv file was continuously updated each time publish() method being called 
	@Test
	void testPublishPnLOfEquity() {
		//generate four PnL<Equity> instances: pnl1,pnl2,pnl3,pnl4
		Equity eq0 = new Equity("APPL",438000000,1.06);
		Equity eq1 = new Equity("AMZN",498000000,0.00);
		PnL<Equity> pnl1 = new PnL<Equity>();
		pnl1.setProduct(eq0);
		pnl1.setBook("Book1");
		pnl1.setPnl(135004.0);
		PnL<Equity> pnl2 = new PnL<Equity>();
		pnl2.setProduct(eq0);
		pnl2.setBook("Book1");
		pnl2.setPnl(360000.0);
		PnL<Equity> pnl3 = new PnL<Equity>();
		pnl3.setProduct(eq1);
		pnl3.setBook("Book3");
		pnl3.setPnl(220000.0);
		PnL<Equity> pnl4 = new PnL<Equity>();
		pnl4.setProduct(eq0);
		pnl4.setBook("Book1");
		pnl4.setPnl(480000.0);
		EquityPnLService EPLService = EquityPnLService.getInstance();
		
		//publish pnl1,pnl2,pnl3,pnl4
        EHDConnector.Publish(pnl1);
        EHDConnector.Publish(pnl2);
        EHDConnector.Publish(pnl3);
        EHDConnector.Publish(pnl4);
        
        //read in output.csv file and add to ArrayList<String> output
		File file = new File("output.csv");        
        try(Scanner sc = new Scanner(file)){
        	sc.nextLine();
        	while(sc.hasNextLine()) {
        		output.add(sc.nextLine());
        	}
        }
        catch(IOException e) {
        	e.printStackTrace();
        	System.out.println("check if file being written properly");
        }
        
		//check if last and second to the last elements in output.csv file match with PnL<Equity> pnl4 and pnl3 data
        String second_to_last = output.get(output.size()-2);
        String last = output.get(output.size()-1);
	    assertEquals(220000.0,Double.parseDouble(second_to_last.split(",")[2]),"answer is wrong, second-to-last pnl shoule be 220000.0");	
	    assertEquals(480000.0,Double.parseDouble(last.split(",")[2]),"answer is wrong, last pnl shoule be 480000.0");
		}
}
	


