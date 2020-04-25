
public class PnL<T> {
	T product;
	double pnl;
	public T getProduct() {
		return product;
	}
	public void setProduct(T product) {
		this.product = product;
	}
	public double getPnl() {
		return pnl;
	}
	public void setPnl(double pnl) {
		this.pnl = pnl;
	}
	
	public void updatePnl(long quantity,TradeSide side,double price) {
		int calcSide = side==TradeSide.Buy?-1:1;
		
		pnl += (double)quantity*price*calcSide;
	}
	
}
