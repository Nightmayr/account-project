package com.qa.accountApplication;

import java.util.HashMap;
import java.util.Map;

public class Service {
	Map<Integer, Account> accountMap = new HashMap<>();
	int counter = 0;
	
	public void addAccount(Account account) {
		accountMap.put(counter, account);
		counter++;
	}
	
	public Account retrieveAccount(int accountId) {
		return accountMap.get(accountId);
	}
	
	public void deleteAccount(int accountId) {
		accountMap.remove(accountId);
	}
	
	public int getMapSize() {
		int size = this.accountMap.size();
		return size;
	}
}
