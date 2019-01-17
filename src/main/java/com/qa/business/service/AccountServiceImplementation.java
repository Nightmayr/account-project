package com.qa.business.service;

import javax.inject.Inject;

import com.qa.account.application.Repo;
import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;

public class AccountServiceImplementation implements AccountService{
	
	
	@Inject
	AccountRepository repo;
	
	@Override
	public String getAllAccounts() {
		
		return repo.getAllAccounts();
	}
	@Override
	public String addAccount(String account) {
		
		return repo.addAccount(account);
	}
	@Override
	public String deleteAccount(Long id) {
		
		return repo.deleteAccount(id);
	}
	
}
