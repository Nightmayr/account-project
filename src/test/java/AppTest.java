import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qa.accountApplication.Account;
import com.qa.accountApplication.Service;

public class AppTest {
	
	Service service;
	Account account1;
	Account account2;
	Account account3;

	
	@Before
	public void setup() {
		service = new Service();
		account1 = new Account("Umayr", "Saghir", 1);
		account2 = new Account("JSON", "Dairy", 2);
		account3 = new Account("Henry", "Cheeeeeya", 3);
	}
	
//	@Test
//	public void fail() {
//		fail();
//	}
	
	@Test
	public void addUserTest() {
		service.addAccount(account1);
		assertEquals(1,service.getMapSize());
	}
	
	@Test
	public void removeUserTest() {
		service.addAccount(account1);
		service.deleteAccount(0);
		assertEquals(0,service.getMapSize());
		
	}
	
	@Test
	public void retrieveUserTest() {
		service.addAccount(account1);
		assertEquals("Umayr", service.retrieveAccount(0).getFirstName()																															);
	}
}
