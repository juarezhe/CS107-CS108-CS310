import java.util.Scanner;

public class MainActivity {

	public static void main(String args[]) {
		int perimeter = 3000;
		int length = 0;
		int lSegments = 3;
		int width = 0;
		int wSegments = 4;
		int area = 0;

		for (int x = 1; x * lSegments < perimeter; x++) {
			for (int y = 1; y * wSegments < perimeter - x; y++) {
				int tempArea = x * lSegments * y * wSegments;
				
				if (tempArea > area && x * lSegments + y * wSegments <= perimeter) {
					area = tempArea;
					length = x;
					width = y;
				}
			}
		}
		
		System.out.println("The optimal area of " + area + " is obtained with a length of " + length * lSegments + " and a  width of " + width * wSegments + ".");
		System.out.println("For each subdivision, the length will be " + length + " and the width will be " + width + ".");
	}
}
