
/**
 * Equity product class
 * @author Wenting Yang, Sara Liu
 *
 */
public class Equity {
	

	private String ticker;
	private long totalShares;
	private double dividendYield;
	
	/**
	 * Constructor of class Equity
	 * @param ticker
	 * @param Tshare
	 * @param divYield
	 */
	public Equity(String ticker, long Tshare, double divYield) {
		this.ticker = ticker;
		this.totalShares = Tshare;
		this.dividendYield = divYield;
	}
	

	/**
	 * getter function of ticker
	 * @return
	 */
	public String getTicker() {
		return ticker;
	}
	
	/**
	 * getter function of total shares
	 * @return
	 */
	public long getTotalShares() {
		return totalShares;
	}
	
	/**
	 * getter function of dividend yield
	 * @return
	 */
	public double getDividendYield() {
		return dividendYield;
	}
	

	
	/**
	 * setter function of ticker
	 */
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	
	/**
	 * setter function of total shares
	 * @param totShares
	 */
	public void setTotalShares(long totShares) {
		this.totalShares = totShares;
	}
	
	/**
	 * setter function of dividend yield
	 * @param divYield
	 */
	public void setDividendYield(double divYield){
		this.dividendYield = divYield;
	}
	
}


