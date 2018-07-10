package accountProject;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ServiceTest {
	private static Account account;
	private static Service service;
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@BeforeClass
	public static void setUp() {

		account = new Account("Benny", "Wong", 1);
		Account john = new Account("Jarad", "Haggard", 2);
		Account george = new Account("George", "Timbrell", 3);
		Account sam = new Account("Sam", "1", 4);
		Account sam2 = new Account("Sam", "2", 5);

		service = new Service();
		service.addAccount(account);
		service.addAccount(john);
		service.addAccount(george);
		service.addAccount(sam);
		service.addAccount(sam2);
	}

	@Test
	public void addAccountTest() {
		assertTrue("account not found in hashmap", service.getAccounts().containsValue(account));
	}

	@Test
	public void getAccountByNumberTest() {
		Account getAccount = service.getAccountByNumber(account.getAccountNumber());
		
		assertTrue("couldn't get account from hashmap", account.equals(getAccount) );
	}
	
	@Test
	public void objectToJSONtest() {
		System.out.println(service.getJson());
			}
	
	@Test
	public void objectToXMLtest() {
		System.out.println(service.getXML());
	}
	
	@Test
	public void bannedAccountTest() throws AccountBlockedException {
		Account bannedAccount  = new Account("John", "Gordon", 123456);
		service.addAccount(bannedAccount);
		
		exception.expect(AccountBlockedException.class);
		service.searchAccounts();
	}
	
	@Test
	public void getAccountCountByFirstNameTest() {
		int samCount = service.getAccountCountByFirstName("Sam");
		int johnCount = service.getAccountCountByFirstName("Jarad");
		int anonCount = service.getAccountCountByFirstName("Anon");

		assertEquals(samCount, 2);
		assertEquals(johnCount, 1);
		assertEquals(anonCount, 0);
	}
	
}
