
public class ArrayStack {
	
	private Object[] btsarr = new Object[100];
	private int topidx;
	
	public ArrayStack() {
		topidx = -1;
	}
	
	public void push(Object x) {
		topidx++;
		btsarr[topidx] = x;
	}
	
	public Object pop() {
		if (topidx == -1) {
			System.out.println("Out of items!");
			return null;
		}
		else {
			topidx--;
			return btsarr[topidx + 1];
		}
	}
	
	public int size() {
		return btsarr.length;
	}
	
	public boolean isEmpty() {
		if (topidx == -1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		if (!isEmpty()) {
			String stringToReturn;
			
			stringToReturn = "top\n";
			
			for (int i = topidx; i > -1; i--) {
				stringToReturn += btsarr[i] + "\n";
			}
			
			stringToReturn += "bottom";
			return stringToReturn;
		}
		else {
			return "No items in array.";
		}
	}
}
