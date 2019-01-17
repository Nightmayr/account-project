package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;
import com.qa.util.JSONUtil;

public class AccountServiceImplementation implements AccountService{
	
	
	@Inject
	private AccountRepository repo;
	@Inject
	private JSONUtil util;
	
	@Override
	public String getAllAccounts() {
		
		return repo.getAllAccounts();
	}
	@Override
	public String addAccount(String account) {
		Account checkAccount = util.getObjectForJSON(account, Account.class);
		String accountNum = checkAccount.getAccountNumber();
		
//		if(account.contains("9999")) {
//			return "{\"message\": \"account sucessfully deleted\"}";	
//		} else {
//			return repo.addAccount(account);			
//		}
		if(checkAccountNumber(accountNum)) {
			return "{\"message\": \"account blocked!\"}";	
		}
		return repo.addAccount(account);
	}
	
	public boolean checkAccountNumber(String id) {
		if(id.equals("9999")) {
			return true;
		} 
		return false;
	}
	
	@Override
	public String deleteAccount(Long id) {
		
		return repo.deleteAccount(id);
	}
	@Override
	public String updateAccount(Long id, String account) {
		
		return repo.updateAccount(id, account);
	}
	
}
