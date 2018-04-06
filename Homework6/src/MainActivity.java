import java.util.Scanner;

public class MainActivity {
	
	private static Scanner scan;

	public static void main(String args[]) {
		int position = 0;
		
		scan = new Scanner(System.in);		
		System.out.println("What position in the Fibonacci sequence would you like to know?");
		position = Integer.parseInt(scan.nextLine());
		
		do {
			if (position < 1 ) {
				System.out.println("Sorry, there are no positions before the first. Please try a different position.");
				position = Integer.parseInt(scan.nextLine());
			}
			if (position > 92) {
				System.out.println("Sorry, that exceeds our capabilities at the moment. Please try a different position.");
				position = Integer.parseInt(scan.nextLine());
			}
			
		} while (position < 1 || position > 92);
		
		long value = getNumberAtPosition(position);
		System.out.println("The value at position " + position + " is " + value + ".");
	}
	
	private static long getNumberAtPosition(int position) {
		long mValue1 = 0;
		long mValue2 = 0;
		long mValue3 = 1;
		
		for (int i = 1; i < position; i++ ) {
			mValue1 = mValue2;
			mValue2 = mValue3;
			mValue3 = mValue2 + mValue1;
			
		}
		
		return mValue3;
	}
}

