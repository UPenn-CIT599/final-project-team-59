import java.util.PriorityQueue;

public class ExecutionOrderBook<T> {
	
/**
 * ExecutionOrderBook stores product info and bid executeOrder stack and offer executeOrder stack
 * @author Sara Liu
 * @param <T>
 */
		private T product;
		private PriorityQueue<ExecutionOrder> bidStack = new PriorityQueue<ExecutionOrder>();
		private PriorityQueue<ExecutionOrder> offerStack = new PriorityQueue<ExecutionOrder>();
		
		/**
		 * constructor
		 * @param product
		 * @param bidStack
		 * @param offerStack
		 */
		public ExecutionOrderBook(T product, PriorityQueue<ExecutionOrder> bidStack, PriorityQueue<ExecutionOrder> offerStack) {
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
		public PriorityQueue<ExecutionOrder> getBidStack(){
			return bidStack;
		}
		
		
		/**
		 * getter of offer order stack
		 * @return
		 */
		public PriorityQueue<ExecutionOrder> getOfferStack(){
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
		public void setBidStack(PriorityQueue<ExecutionOrder> bidStack) {
			this.bidStack = bidStack;
		}
		
		/**
		 * setter of offer side stack
		 * @param offerStack
		 */
		public void setOfferStack(PriorityQueue<ExecutionOrder> offerStack) {
			this.offerStack = offerStack;
		}
		
}
