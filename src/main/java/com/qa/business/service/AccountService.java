package com.qa.business.service;

import com.qa.account.application.Repo;
import com.qa.persistence.domain.Account;

public interface AccountService {
	
	Repo repo = new Repo();
	int counter = 0;
	
	public void addAccount(Account account) {
		repo.accountMap.put(counter, account);
		counter++;
	}
	
	public Account getAccount(int accountId) {
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
