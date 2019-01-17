package com.qa.business.service;

import com.qa.account.application.Repo;
import com.qa.persistence.domain.Account;

public interface AccountService {
	
	
	String getAllAccounts();

	String addAccount(String account);

	String deleteAccount(Long id);
	
}
