import java.util.Scanner;

public class Account {
	
	// Class Variables
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;
	
	// Class Constructor
	Account(String cName, String cID){
		customerName = cName;
		customerID = cID;
	}
	
	// Function for depositing money
	void deposit(int amount) {
		if (amount != 0) {
			balance = balance + amount;
			previousTransaction = previousTransaction + amount;
		}
	}
	
	// Function for withdrawing money
	void withdraw(int amount) {
		if (amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	
	// Function showing the previous transaction
	void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposited " + previousTransaction);
		} 
		else if (previousTransaction < 0) {
			// Math.abs returns number that is not negative
			System.out.println("Withdrawn: " + Math.abs(previousTransaction));
		}
		else {
			System.out.println("No transaction ocurred");
		}
	}
	
	// Function calculating interest of current funds after a number of years
	void calculateInterest (int years) {
		double interestRate = .0185;
		double newBalance = (balance * interestRate * years) + balance;
		System.out.println("The current interest rate is " + (100 * interestRate) + "%");
		System.out.println("After " + years + " years your balance will be: " + newBalance);
	}
	
	// Function showing main menu
	void showMenu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome, " + customerName + "!");
		System.out.println("Your ID is " + customerName + ".");
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("A. Check your balance");
		System.out.println("B. Make a deposit");
		System.out.println("C. Make a withdrawl");
		System.out.println("D. View previous transaction");
		System.out.println("E. Calculate interest");
		System.out.println("F. Exit");
		
		do {
			System.out.println();
			System.out.println("Enter an option: ");
			// If user types more than 1 letter than only the first character will be chosen
			char option1 = scanner.next().charAt(0);
			// Converts response to upper case
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch(option) {
			// Case 'A' checks user's account balance
			case 'A':
				System.out.println("==================================");
				System.out.println("Balance = $" + balance);
				System.out.println("==================================");
				System.out.println();
				break;
				
			// Case 'B' allows user to deposit money in to account
			case 'B':
				System.out.println("Enter an amount to depost: ");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println();
				break;
				
			// Case 'C' allows user to withdraw money from their account
			case 'C':
				System.out.println("Enter an amount to withdraw: ");
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println();
				break;
			
			
			// Case 'D' allows the user to view their most recent transaction while using this app
			case 'D':
				System.out.println("==================================");
				getPreviousTransaction();
				System.out.println("==================================");
				System.out.println();
				break;
				
			// Case 'E' calculates the accrued interest on the user's account after a number of years
			case 'E': 
				System.out.println("Enter how many years of accrued interest: ");
				int years = scanner.nextInt();
				calculateInterest(years);
				break;
			
			// Case 'F' exists the user from their account
			case 'F':
				System.out.println("==================================");
				break;
				
			// The default let's the user know they entered an invalid character
			default:
				System.out.println("Error: invalid option. Please enter A, B, C, D, E, or F");
				break;
			}
		} while (option != 'F');
		System.out.println("Thank you for banking with us!");
	}
}
