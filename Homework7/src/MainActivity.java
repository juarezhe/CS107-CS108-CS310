import java.util.Scanner;

public class MainActivity {
	
	private static Scanner scan;

	public static void main(String args[]) {
		int count = 0;
		int sum = 0;
		int value = 0;
		
		scan = new Scanner(System.in);
		
		System.out.println("Please input an integer from 0 to 100, or -1 to quit.");
		value = Integer.parseInt(scan.nextLine());
		
		do {
			if (value < -1 || value > 100) {
				System.out.println("Sorry, the expected range is -1 through 100. Please try again.");
				value = Integer.parseInt(scan.nextLine());
			}
			else {
				sum += value;
				count++;
				System.out.println("Sum = " + sum + ", Count = " + count + "\n");
				System.out.println("Please input an integer from 0 to 100, or -1 to quit.");
				value = Integer.parseInt(scan.nextLine());
			}
		} while (value != -1);
		
		float average = (float) sum / count;
		
		System.out.println("The average of the values entered is " + average + ".");
	}
}
