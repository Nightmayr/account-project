package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class AccountDBRepository implements AccountRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	public String getAllAccounts() {
		Query query = manager.createQuery("SELECT a FROM Account a");
		Collection<Account> accounts = (Collection<Account>)query.getResultList();
		return util.getJSONForObject(accounts);
	}
	
	@Transactional(REQUIRED)
	public String addAccount(String account) {
		Account aAccount = util.getObjectForJSON(account, Account.class);
		manager.persist(aAccount);
		return "{\"message\": \"account sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		Account account = findAccount(id); 
		if (account != null) {
			manager.remove(account);
		}
		return "{\"message\": \"account sucessfully deleted\"}";	}
	
	@Override
	public String updateAccount(Long id, String account) {
		Account foundAccount = findAccount(id);
		Account jsonAccount = util.getObjectForJSON(account, Account.class);
		if(foundAccount!=null) {
			manager.remove(foundAccount);
			manager.persist(jsonAccount);
			return "{\"message\": \"account sucessfully updated\"}";
		}
		return null;
	}
	
	private Account findAccount(Long id) {
		return manager.find(Account.class, id);
	}
	
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public JSONUtil getUtil() {
		return util;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}


}
