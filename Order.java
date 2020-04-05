/**
 * Order Class contains the price, quantity and pricing side of the equity order
 * @author wentingyang
 *
 */

public class Order {
	

	private double price;
	private long quantity;
	private PricingSide side;
	

	/**
	 * constructor
	 * @param price
	 * @param quantity
	 * @param side
	 */
	public Order(double price, long quantity, PricingSide side) {
		this.price = price;
		this.quantity = quantity;
		this.side = side;
	}
	
	/**
	 * Copy Constructor
	 * @param source
	 */
	public Order (Order source){
		this.price = source.price;
		this.quantity = source.quantity;
		this.side = source.side;
	}
	
	/**
	 * getter function of price
	 * @return
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * getter function of quantity
	 * @return
	 */
	public long getQuantity() {
		return quantity;
	}
	
	/**
	 * getter function of side
	 * @return
	 */
	public PricingSide getSide() {
		return side;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	public void setSide(PricingSide side) {
		this.side = side;
	}
	
}
