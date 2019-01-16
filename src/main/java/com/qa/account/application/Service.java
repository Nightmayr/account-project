package com.qa.account.application;

public class Service {
	
	Repo repo = new Repo();
	int counter = 0;
	
	public void addAccount(Account account) {
		repo.accountMap.put(counter, account);
		counter++;
	}
	
	public Account retrieveAccount(int accountId) {
		return repo.accountMap.get(accountId);
	}
	
	public void deleteAccount(int accountId) {
		repo.accountMap.remove(accountId);
	}
	
	public int getMapSize() {
		int size = this.repo.accountMap.size();
		return size;
	}
	
	public int firstNameSearch(String fName) {
		int counter = 0;
		for(int i = 0; i<repo.accountMap.size();i++) {
			if(repo.accountMap.get(i)!=null) {
				if(repo.accountMap.get(i).getFirstName()==fName) {
					counter++;
				}
			}
		}
		return counter;
	}
}
