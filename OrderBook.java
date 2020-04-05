import java.util.ArrayList;

/**
 * OrderBook class stores the product info and bid order stack and offer order stack
 * @author wentingyang
 * @param <T>
 */
public class OrderBook<T> {
	private T product;
	private ArrayList<Order> bidStack = new ArrayList<Order>();
	private ArrayList<Order> offerStack = new ArrayList<Order>();
	
	/**
	 * constructor
	 * @param product
	 * @param bidStack
	 * @param offerStack
	 */
	public OrderBook(T product, ArrayList<Order> bidStack, ArrayList<Order> offerStack) {
		this.product = product;
		this.bidStack = bidStack;
		this.offerStack = offerStack;
	}
	
	/**
	 * getter of product
	 */
	public T getProduct() {
		return product;
	}
	
	/**
	 * getter of bid order stack
	 * @return
	 */
	public ArrayList<Order> getBidStack(){
		return bidStack;
	}
	
	
	/**
	 * getter of offer order stack
	 * @return
	 */
	public ArrayList<Order> getOfferStack(){
		return offerStack;
	}
	
	/**
	 * setter of product
	 * @param product
	 */
	public void setProduct(T product) {
		this.product = product;
	}
	
	/**
	 * setter of bid side stack
	 * @param bidStack
	 */
	public void setBidStack(ArrayList<Order> bidStack) {
		this.bidStack = bidStack;
	}
	
	/**
	 * setter of offer side stack
	 * @param offerStack
	 */
	public void setOfferStack(ArrayList<Order> offerStack) {
		this.offerStack = offerStack;
	}
	


}
