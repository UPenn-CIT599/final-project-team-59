
public class Trade<T> {
	private T product;
	private String tradeId;
	private double price;
	private String book;
	private long quantity;
	private TradeSide side;
	
	public T getProduct() {
		return product;
	}
	public void setProduct(T product) {
		this.product = product;
	}
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public TradeSide getSide() {
		return side;
	}
	public void setSide(TradeSide side) {
		this.side = side;
	}
}
