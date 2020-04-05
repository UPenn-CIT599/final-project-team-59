
/**
 * BidOffer order class
 * variables: bid order; offer order
 * @author Wenting Yang, Sara Liu
 */
public class BidOffer {
	private Order bidOrder;
	private Order offerOrder;
	
	/**
	 * constructor
	 * @param bidOrder
	 * @param offerOrder
	 */
	public BidOffer(Order bidOrder, Order offerOrder) {
		this.bidOrder = bidOrder;
		this.offerOrder = offerOrder;
	}
	
	/**
	 * setter of bid order
	 * @param bidOrder
	 */
	public void setBidOrder(Order bidOrder) {
		this.bidOrder = bidOrder;
	}
	
	/**
	 * setter of offer order
	 * @param offerOrder
	 */
	public void setOfferOrder(Order offerOrder) {
		this.offerOrder = offerOrder;
	}
	
	
	/**
	 * getter of bid order
	 * @return
	 */
	public Order getBidOrder() {
		return bidOrder;
	}
	
	/**
	 * getter of offer order
	 * @return
	 */
	public Order getOfferOrder() {
		return offerOrder;
	}
	
}
