
public class ArrQueue {
	private Object[] btsarr;
	private int backidx;
	
	public ArrQueue() {
		this.btsarr = new Object[100];
		this.backidx = -1;
	}
	
	public void enqueue(Object x) {
		if (this.size() == this.btsarr.length) {
			System.out.println("Out of array space!");
		}
		else {
			this.backidx++;
			this.btsarr[backidx] = x;
		}
	}
	
	public Object dequeue() {
		if (this.size() == 0) {
			System.out.println("Out of items!");
			return null;
		}
		else {
			Object objectToReturn = this.btsarr[0];
			
			for (int i = 0; i < this.backidx; i++) {
				this.btsarr[i] = this.btsarr[i + 1];
			}
			
			this.btsarr[backidx] = null;
			this.backidx--;
			return objectToReturn;
		}
	}
	
	public int size() {
		return this.backidx + 1;
	}
	
	public boolean isEmpty() {
		return this.backidx == -1;
	}
	
	@Override
	public String toString() {
		String stringToReturn = "[";

		for (int i = 0; i <= this.backidx; i++) {
			if (i == this.backidx) {
				stringToReturn += this.btsarr[i];
			}
			else {
				stringToReturn += this.btsarr[i] + ", ";
			}
		}
		
		stringToReturn += "]";
		return stringToReturn;
	}
}
