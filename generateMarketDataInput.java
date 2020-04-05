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
			double mid = 241.41;
			double tickSize = 0.01;
			String tickerName = "APPL";
			double currBid = Math.round((mid-tickSize)*100.0)/100.0;
			double currOffer = Math.round((mid+tickSize)*100.0)/100.0;
			Random ran = new Random();
			pw.println("APPL,4384000000,1.28");
			
			for(int i = 0; i<100; i++) {
				String output = new String();
				long bidSize = ran.nextInt(50)*100000+10000000;
				long offerSize = ran.nextInt(50)*100000+10000000;
				output = currBid+","+bidSize+","+currOffer+","+offerSize;
				System.out.println(output);
				pw.println(output);
				currBid = Math.round((currBid-tickSize)*100.0)/100.0;
				currOffer =Math.round((currOffer+tickSize)*100.0)/100.0;
			}
			pw.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
