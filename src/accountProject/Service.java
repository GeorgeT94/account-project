package accountProject;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.XML;

public class Service {
	public static final int BANNED_ACCOUNT = 123456; 

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
	
	public JSONObject getJson() {
		JSONObject json = new JSONObject(accounts);
		return json;
	}
	
	public String getXML() {
		String xml = XML.toString(getJson());
		return xml;
	}
	
	public void searchAccounts() throws AccountBlockedException {
		if(accounts.containsKey(BANNED_ACCOUNT)) {
			throw new AccountBlockedException("this account has been blocked, you cannot access this account.");
		}
	}
}
 