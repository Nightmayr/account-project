package com.qa.account.app.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qa.account.application.Service;
import com.qa.persistence.domain.Account;

public class AppTest {

	public Service service;
	public Account account1;
	public Account account2;
	public Account account3;
	public Account account4;

	@Before
	public void setup() {
		service = new Service();
		account1 = new Account("Umayr", "Saghir", 1);
		account2 = new Account("JSON", "Dairy", 2);
		account3 = new Account("Henry", "Cheeeeeya", 3);
		account4 = new Account("Umayr", "Nightmayr",4);
	}

	// @Test
	// public void fail() {
	// fail();
	// }

	@Test
	public void addUserTest() {
		service.addAccount(account1);
		assertEquals(1, service.getMapSize());
	}

	@Test
	public void removeUserTest() {
		service.addAccount(account1);
		service.deleteAccount(0);
		assertEquals(0, service.getMapSize());
	}

	@Test
	public void retrieveUserTest() {
		service.addAccount(account1);
		assertEquals("Umayr", service.retrieveAccount(0).getFirstName());
	}
	
	@Test
	public void accountGetFnameTest() {
		assertEquals("JSON",account2.getFirstName());
	}
	
	@Test
	public void accountGetSnameTest() {
		assertEquals("Dairy",account2.getLastName());
	}
	
	@Test
	public void accountGetNumTest() {
		assertEquals(2,account2.getAccountNumber());
	}
	
	@Test
	public void accountSetNumTest() {
		account3.setAccountNumber(1);
		assertEquals(1,account3.getAccountNumber());
	}
	
	@Test
	public void accountSetFnameTest() {
		account3.setFirstName("Declan");
		assertEquals("Declan",account3.getFirstName());
	}
	
	@Test
	public void accountSetLastnameTest() {
		account3.setLastName("McGee");
		assertEquals("McGee",account3.getLastName());
	}
	
	@Test
	public void firstNameSearchTest() {
		service.addAccount(account1);
		assertEquals(1,service.firstNameSearch("Umayr"));
	}
	
	@Test
	public void firstNameSearchTest2() {
		service.addAccount(account1);
		service.addAccount(account4);
		assertEquals(2,service.firstNameSearch("Umayr"));
	}
}
