package com.qa.persistence.repository;

public interface AccountRepository {
	
	String getAllAccounts();

	String addAccount(String account);

	String deleteAccount(Long id);

}
