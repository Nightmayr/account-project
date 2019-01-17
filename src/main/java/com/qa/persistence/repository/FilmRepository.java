package com.qa.persistence.repository;

public interface FilmRepository {
	
	String getAllFilms();

	String addFilm(String film);

	String deleteFilm(Long id);

}
