import java.util.Scanner;

public class MainActivity {
	private static Scanner reader;

	public static void main(String args[]) {
		String username;
		byte tenDollarTicketCount;
		byte twentyDollarTicketCount;
		short total;
		
		reader = new Scanner(System.in);
		
		System.out.println("Welcome to homework 4.");
		System.out.println("Homework 4 is a highly advanced ticket-ordering software.");
		System.out.print("User, please enter your name: ");
		username = reader.nextLine();
		
		System.out.print("\nHow many $10 tickets would you like? ");
		tenDollarTicketCount = reader.nextByte();
		while (tenDollarTicketCount < 0) {
			System.out.println("\nUnfortunately, we aren't able to purchase your tickets at the moment.");
			System.out.print("How many $10 tickets would you like? ");
			tenDollarTicketCount = reader.nextByte();
		}
		
		System.out.print("\nHow many $20 tickets would you like? ");
		twentyDollarTicketCount = reader.nextByte();
		while (twentyDollarTicketCount < 0) {
			System.out.println("\nUnfortunately, we aren't able to purchase your tickets at the moment.");
			System.out.print("How many $10 tickets would you like? ");
			twentyDollarTicketCount = reader.nextByte();
		}
		total = (short) (tenDollarTicketCount * 10 + twentyDollarTicketCount * 20);
		
		System.out.println("\nThank you for your order, " + username + ".");
		System.out.print("For (" + tenDollarTicketCount + ") $10 " + checkForPlural(tenDollarTicketCount));
		System.out.print(" and (" + twentyDollarTicketCount + ") $20 " + checkForPlural(twentyDollarTicketCount));
		System.out.print(", that will be $" + total + " total.");
	}
	
	private static String checkForPlural(byte number) {
		if (number == 1)		
			return "ticket";
		else
			return "tickets";
	}
}
