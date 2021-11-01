
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

}
