package com.qa.accountApplication;

public class App {

	public static void main(String[] args) {
//		System.out.println("Hello world to the standard out");
		Service service = new Service();
		Account account1 = new Account("Umayr", "Saghir", 1);
		Account account2 = new Account("JSON", "Dairy", 2);
		Account account3 = new Account("Henry", "Cheeeeeya", 3);
		
		service.addAccount(account1);
		service.addAccount(account2);
		service.addAccount(account3);
		
		service.retrieveAccount(0);
		service.retrieveAccount(1);
		service.retrieveAccount(2);
		
		service.deleteAccount(1);
		service.retrieveAccount(1);
		
	}

}
