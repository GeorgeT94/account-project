package accountProject;

import java.util.HashMap;
import java.util.Map;

public class Service {

	private Map<Integer, Account> accounts = new HashMap<Integer, Account>();
	
	public void addAccount(Account account){
		accounts.put(account.getAccountNumber(), account);
	}
	
	public Account getAccountByNumber(int accountNumber) {
		return accounts.get(accountNumber);
		
	}
	
	public Map<Integer, Account> getAccounts() {
		return accounts;
	}
	
}
