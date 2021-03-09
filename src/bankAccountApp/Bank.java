package bankAccountApp;

public class Bank {

	public static void main(String[] args) {
		Account john = new Account("John Doe", "A00007");
		john.showMenu();
		
		Account jane = new Account("Jane Doe", "A00008");
		jane.showMenu();
	}

}
