import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * OrderBook class stores the product info and bid order stack and offer order stack
 * @author wentingyang
 * @param <T>
 */
public class OrderBook<T> {
	private T product;
	private PriorityQueue<Order> bidStack = new PriorityQueue<Order>();
	private PriorityQueue<Order> offerStack = new PriorityQueue<Order>(Collections.reverseOrder());
	
	/**
	 * constructor
	 * @param product
	 * @param bidStack
	 * @param offerStack
	 */
	public OrderBook(T product, PriorityQueue<Order> bidStack, PriorityQueue<Order> offerStack) {
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
	public PriorityQueue<Order> getBidStack(){
		return bidStack;
	}
	
	
	/**
	 * getter of offer order stack
	 * @return
	 */
	public PriorityQueue<Order> getOfferStack(){
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
	public void setBidStack(PriorityQueue<Order> bidStack) {
		this.bidStack = bidStack;
	}
	
	/**
	 * setter of offer side stack
	 * @param offerStack
	 */
	public void setOfferStack(PriorityQueue<Order> offerStack) {
		this.offerStack = offerStack;
	}
	
	/**
	 * Add BidOrder to the bid Stack
	 * @param bidOrder
	 */
	public void addBidOrder(Order bidOrder) {
		this.bidStack.add(bidOrder);
	}
	
	/**
	 * Add offerOrder to the offer stack
	 * @param offerOrder
	 */
	public void addOfferOrder(Order offerOrder) {
		this.offerStack.add(offerOrder);
	}
	
	/**
	 * print orderBook 5 depths
	 */
	public void printOrderBook() {
		Iterator<Order> bidIter = bidStack.iterator();
		Iterator<Order> offerIter = offerStack.iterator();
		int cnt = 0;
		String bidOutputStr = new String();
		String offerOutputStr = new String();
		while (cnt<5) {
			if(bidIter.hasNext()) {
				Order currBidOrder = bidIter.next();
				bidOutputStr = bidOutputStr+"("+currBidOrder.getPrice()+
						","+currBidOrder.getQuantity()+")\n";
			}
			if(offerIter.hasNext()) {
				Order currOfferOrder = offerIter.next();
				offerOutputStr = offerOutputStr + "(" + currOfferOrder.getPrice()+
						","+currOfferOrder.getQuantity()+")\n";
			}
			cnt++;
		}
		
		System.out.println("5 depths in bid stack:" + bidOutputStr);
		System.out.println("5 depths in offer stack:"+offerOutputStr);
	}

}
