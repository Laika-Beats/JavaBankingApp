
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

}
