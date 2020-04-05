import java.util.HashMap;

/**
 * Position class
 * @author Wenting Yang, Sara Liu
 *
 * @param <T>
 */
public class Position<T> {
	private T product;
	private HashMap<String,Long> positions = new HashMap<String,Long>(); //book position mapping

	/**
	 * update position map
	 * @param book
	 * @param newQuantity
	 */
	public void upDatePosition(String book, Long newQuantity) {
		Long oldPosition = positions.get(book);
		oldPosition += newQuantity;
		positions.replace(book, oldPosition);
	}
	
	public T getProduct() {
		return product;
	}

	public void setProduct(T product) {
		this.product = product;
	}

	public HashMap<String, Long> getPositions() {
		return positions;
	}

	public void setPositions(HashMap<String, Long> positions) {
		this.positions = positions;
	}

	Long getAggregatePosition() {
		long aggPosition = 0;
		for(HashMap.Entry mapElement : positions.entrySet()) {
			aggPosition += (long)mapElement.getValue();
		}
		return aggPosition;
	}
}
