
/**
 * ExecutionOrder Class
 * @author Wenting Yang, Sara Liu
 *
 * @param <T>
 */
public class ExecutionOrder<T> {
	//private T product;
	private PricingSide side;// bid/offer
	private String ticker;
	private OrderType orderType; 
	private double price;
	private long quantity;
	
	
	
	/**
	 * constructor
	 */
	public ExecutionOrder(PricingSide side,String ticker,
						OrderType orderType, double price, long quantity) {
		
		this.side = side;
		this.ticker = ticker;
		this.orderType = orderType;
		this.price = price;
		this.quantity = quantity;
	}
	

	
	public void setSide (PricingSide side) {
		this.side = side;
	}
	
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
	
	public void setPrice (double price) {
		this.price = price;
	}
	
	public void setQuantity (long quantity) {
		this.quantity = quantity;
	}
	
	


	public PricingSide getSide() {
		return side;
	}

	public String getTicker() {
		return ticker;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public double getPrice() {
		return price;
	}

	public long getQuantity() {
		return quantity;
	}
	
	
	
}
