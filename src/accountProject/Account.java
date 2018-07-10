package accountProject;

public class Account {
	

	private String firstName;
	private String lastName;
	private int accountNumber;

	public Account(String firstName, String lastName, int accountNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

}
