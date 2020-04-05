
public class Risk<T> {
	T ticker;
	double beta;
	double volatility;
	long quantity;
	public T getTicker() {
		return ticker;
	}
	public void setTicker(T ticker) {
		this.ticker = ticker;
	}
	public double getBeta() {
		return beta;
	}
	public void setBeta(double beta) {
		this.beta = beta;
	}
	public double getVolatility() {
		return volatility;
	}
	public void setVolatility(double volatility) {
		this.volatility = volatility;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
}
