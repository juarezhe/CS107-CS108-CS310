import java.util.ArrayList;

public class ArrayStack {
	
	//private Object[] btsarr = new Object[100];
	//private ArrayList<Object> btsarr = new ArrayList<Object>(0);
	private ArrayList<Object> btsarr; //holds stack items
	private int topidx; //indexes the top-most (and most recent) stack item
	
	public ArrayStack() { //constructor - only default is required
		//this.btsarr = new Object[100];
		this.btsarr = new ArrayList<Object>(0); //initialize with zero stack items
		this.topidx = -1; //initialize to reflect no items on the stack
	}
	
	public void push(Object x) { //pushes new item onto the stack
		if (this.size() ==  100) { //limit stack items to 100
			System.out.println("Out of space!");
		}
		else {
			this.btsarr.add(x); //add item to the stack
			this.topidx++; //point to the newly added item 
			//this.btsarr[this.topidx] = x;
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
} //class
