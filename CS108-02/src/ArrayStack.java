import java.util.ArrayList;

public class ArrayStack {
	
	//private Object[] btsarr = new Object[100];
	private ArrayList<Object> btsarr = new ArrayList<Object>(0);
	private int topidx;
	
	public ArrayStack() {
		topidx = -1;
	}
	
	public void push(Object x) {
		topidx++;
		//btsarr[topidx] = x;
		btsarr.add(x);
	}
	
	public Object pop() {
		if (topidx == -1) {
			System.out.println("Out of items!");
			return null;
		}
		else {
			Object objectToReturn = btsarr.get(topidx);
			btsarr.remove(topidx);
			topidx--;
			//return btsarr[topidx + 1];
			return objectToReturn;
		}
	}
	
	public int size() {
		//return topidx + 1;
		return btsarr.size();
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
				//stringToReturn += btsarr[i] + "\n";
				stringToReturn += btsarr.get(i) + "\n";
			}
			
			stringToReturn += "bottom\n";
			return stringToReturn;
		}
		else {
			return "No items in array.";
		}
	}
}
