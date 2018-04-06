
public class MainActivity {
	
	public static void main(String args[]) {
		
	}
	
	private long getNumberAtPosition(int position) {
		long mValue1 = 0;
		long mValue2 = 1;
		long mValue3 = 0;
		
		for (int i = 0; i < position; i++ ) { 		
			mValue3 = mValue2 + mValue1;
			mValue2 = mValue3;
			mValue1 = mValue2;
		}
		
		return mValue3;
	}
}

