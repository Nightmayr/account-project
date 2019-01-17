package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.AccountService;

@Path("/account")
public class AccountEndpoint {
	
	@Inject
	private AccountService service;

	@Path("/getAllAccounts")
	@GET
	@Produces({"application/json"})
	public String getAllFilms()
	{
		return service.getAllAccounts();
	}
	
	@Path("/addAccount")
	@POST
	@Produces({"application/json"})
	public String addFilm(String film) {
		return service.addAccount(film);
	}
	
	@Path("/deleteAccount/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteFilm(@PathParam("id") Long id) {
		return service.deleteAccount(id);
	}
	
	public void setService(AccountService service) {
		this.service = service;
	}
	
}
