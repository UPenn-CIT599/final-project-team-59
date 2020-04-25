import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class generateMarketDataInput {
	public static void main(String[] arguments) {
		File out = new File("OrderBook.txt");
		try {
			PrintWriter pw = new PrintWriter(out);
			

			double tickSize = 0.01;
			String ticker[]= {"APPL","AMZN","ZM"};
			double mid[]= {282.80,2375.00,160.06};
			int dayChange[] = {500,4000,450};
			int volume[]= {25,50,25};
			
		
			Random ran = new Random();
			pw.println("APPL,438000000,1.06");
			pw.println("AMZN,498000000,0.00");
			pw.println("ZM,111800000,0.00");
			
			for(int i = 0; i<10; i++) { //30000
				int company = ran.nextInt(3);
					
				String output = new String();
				long size = ran.nextInt(20)*volume[company];
				//long offerSize = ran.nextInt(100)*volume[company];
				int side1 = ran.nextInt(2)==1?1:-1;
				int side2 = ran.nextInt(2);
				double price = Math.round((mid[company]+(double)ran.nextInt(dayChange[company])*tickSize*side1)*100.0)/100.0;
						
				output = ticker[company]+","+price+","+size+","+side2;
				System.out.println(output);
				pw.println(output);
				
			}
			pw.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
