import java.util.Scanner;

public class MainActivity {
	
	private static Scanner scan;


	public static void main(String args[]) {
		int perimeter, length, subLength, lengthDivisions, width, subWidth, widthDivisions, area;
		
		scan = new Scanner(System.in);
		
		System.out.println("What is the maximum fence length?");
		perimeter = Integer.parseInt(scan.nextLine());
		
		System.out.println("How many times will the area be split along its width?");
		widthDivisions = Integer.parseInt(scan.nextLine());
		
		System.out.println("How many times will the area be split along its length?");
		lengthDivisions = Integer.parseInt(scan.nextLine());
		
		length = width = perimeter / 4;
		subLength = length / lengthDivisions;
		subWidth = width / widthDivisions;
		area = length * width;
		
		System.out.println("The optimal area of " + area + " is obtained with a length of " + length + " and a  width of " + width + ".");
		System.out.println("For each subdivision, the length will be " + subLength + " and the width will be " + subWidth + ".");
	}
}
