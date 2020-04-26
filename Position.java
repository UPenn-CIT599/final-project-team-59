

/**
 * Position class
 * @author Wenting Yang, Sara Liu
 *
 * @param <T>
 */
public class Position<T> {
	private T product;
	private long positions; //book position mapping

	/**
	 * update position map
	 * @param book
	 * @param newQuantity
	 */
	public void upDatePosition(long newQuantity) {
		
		positions += newQuantity;
		
	}
	
	public T getProduct() {
		return product;
	}

	public void setProduct(T product) {
		this.product = product;
	}

	public long getPositions() {
		return positions;
	}

	public void setPositions(long positions) {
		this.positions = positions;
	}


}
