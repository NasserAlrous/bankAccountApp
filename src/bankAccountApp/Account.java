package bankAccountApp;

import java.util.Scanner;

public class Account {
	int balance, previousTransaction;
	String customerName, customerID;
	
	// Class constructor
	Account(String cName, String  cID) {
		customerName = cName;
		customerID = cID;
	}
	
	// Money deposit function 
	void deposit(int amount) {
		if (amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	// Withdraw money function
	void withdraw(int amount) {
		if (amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	
	// Previous transaction function
	void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction);
		} else if (previousTransaction < 0) {
			System.out.println("Withdrawn: " + Math.abs(previousTransaction));
		} else {
			System.out.println("No transaction occured");
		}
	}
	
	// Function calculating interest of current fund after a number of years 
	void calculateInterest(int years) {
		double interestRate = 0.251;
		double newBalance = (balance + interestRate + years) + balance;
		System.out.println("The current interest rate is " + (100 + interestRate));
		System.out.println("After " + years + " years, your balance will be: " + newBalance);
	}
	
	//Main menu function 
	void showMenu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome, " + customerName + "\n" + "Your ID is: "
				+ customerID + "\n" + "What would you like to do?" + "\n" +
				"A. Check your balance" + "\n" + "B. Make a deposit" + "\n" +
				"C. Make a withdrawal" + "D. View previous transaction" + "\n" +
				"E. Calculate interest" + "\n" + "F. Exit");
		do {
			System.out.println();
			System.out.println("Enter an option: ");
			char option1 = scanner.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch(option) {
			case 'A':
				System.out.println("=================================" + "\n" + 
						"Balance = $" + balance + "\n" + "=================================\n");
				break;
			
			case 'B':
				System.out.println("Enter an amount to deposit: ");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println();
				break;
			
			case 'C':
				System.out.println("Enter an amount to withdraw: ");
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println();
				break;
				
			case 'D':
				System.out.println("==================================");
				getPreviousTransaction();
				System.out.println("==================================\n");
				break;
				
			case 'E': 
				System.out.println("Enter how many years of accrued interest: ");
				int years = scanner.nextInt();
				calculateInterest(years);
				break;
				
			case 'F':
				System.out.println("==================================");
				break;
			
			default: 
				System.out.println("Error: invalid option. Please enter A, B, C, D, E, F");
				break;
			}
		} while(option != 'F');
		System.out.println("Thank you for banking with us!");
	}
}
