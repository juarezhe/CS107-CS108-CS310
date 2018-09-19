import java.util.ArrayList;

public class ArrayStack {
	
	//private Object[] btsarr = new Object[100];
	//private ArrayList<Object> btsarr = new ArrayList<Object>(0);
	private ArrayList<Object> btsarr;
	private int topidx;
	
	public ArrayStack() {
		//this.btsarr = new Object[100];
		this.btsarr = new ArrayList<Object>(0);
		this.topidx = -1;
	}
	
	public void push(Object x) {
		if (this.size() ==  100) {
			System.out.println("Out of space!");
		}
		else {
			this.topidx++;
			//this.btsarr[this.topidx] = x;
			this.btsarr.add(x);
		}
	}
	
	public Object pop() {
		//if (this.topidx == -1) {
		if (this.size() == 0) {
			System.out.println("Out of items!");
			return null;
		}
		else {
			//Object objectToReturn = this.btsarr[this.topidx];
			Object objectToReturn = this.btsarr.get(this.topidx);
			//this.btsarr[this.topidx] = null;
			this.btsarr.remove(this.topidx);
			this.topidx--;
			return objectToReturn;
		}
	}
	
	public int size() {
		//return this.topidx + 1;
		return this.btsarr.size();
	}
	
	public boolean isEmpty() {
		/**
		if (this.topidx == -1) {
			return true;
		}
		else {
			return false;
		}**/
		return this.topidx == -1;
	}
	
	@Override
	public String toString() {
		if (!isEmpty()) {
			String stringToReturn = "top\n";
			
			for (int i = this.topidx; i > -1; i--) {
				//stringToReturn += this.btsarr[i] + "\n";
				stringToReturn += this.btsarr.get(i) + "\n";
			}
			
			stringToReturn += "bottom\n";
			return stringToReturn;
		}
		else {
			return "No items in array.";
		}
	}
}
