
/**
 * ExecutionOrder Class
 * @author Wenting Yang, Sara Liu
 *
 * @param <T>
 */
public class ExecutionOrder<T> {
	private T product;
	private PricingSide side;
	private String orderId;
	private OrderType orderType;
	private double price;
	private long visibleQuantity;
	private long hiddenQuantity;
	private String parentOrderId;
	private Boolean isChildOrder;
	
	
	/**
	 * constructor
	 */
	public ExecutionOrder(T product,PricingSide side,String orderId,
						OrderType orderType, double price, long visibleQtty,
						long hiddenQtty,String parentOrder, Boolean isChild) {
		this.product = product;
		this.side = side;
		this.orderId = orderId;
		this.orderType = orderType;
		this.price = price;
		this.visibleQuantity = visibleQtty;
		this.hiddenQuantity = hiddenQtty;
		this.parentOrderId= parentOrder;
		this.isChildOrder = isChild;
	}
	
	public void setProduct(T product) {
		this.product = product;
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
	
	public void setVisibleQuantity (long visibleQtty) {
		this.visibleQuantity = visibleQtty;
	}
	
	public void setHiddenQuantity(long hiddenQtty) {
		this.hiddenQuantity = hiddenQtty;
	}
	
	public void setParentOrderId(String parentOrderId) {
		this.parentOrderId = parentOrderId;
	}
	
	public void setIsChild(Boolean isChildOrder) {
		this.isChildOrder = isChildOrder;
	}

	public T getProduct() {
		return product;
	}

	public PricingSide getSide() {
		return side;
	}

	public String getOrderId() {
		return orderId;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public double getPrice() {
		return price;
	}

	public long getVisibleQuantity() {
		return visibleQuantity;
	}

	public long getHiddenQuantity() {
		return hiddenQuantity;
	}

	public String getParentOrderId() {
		return parentOrderId;
	}

	public Boolean getIsChildOrder() {
		return isChildOrder;
	}
	
	
	
}
