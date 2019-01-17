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

import com.qa.persistence.domain.Film;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class FilmDBRepository implements FilmRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	public String getAllFilms() {
		Query query = manager.createQuery("SELECT f FROM Film f");
		Collection<Film> films = (Collection<Film>)query.getResultList();
		return util.getJSONForObject(films);
	}
	
	@Transactional(REQUIRED)
	public String addFilm(String film) {
		Film afilm = util.getObjectForJSON(film, Film.class);
		manager.persist(afilm);
		return "Created it m8";
	}
	
	@Transactional(REQUIRED)
	public String deleteFilm(Long id) {
		Film film = findFilm(id); 
		if (film != null) {
			manager.remove(film);
		}
		return "Deleted it m8";
	}
	
	private Film findFilm(Long id) {
		return manager.find(Film.class, id);
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
