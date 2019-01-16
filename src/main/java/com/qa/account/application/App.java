package com.qa.account.application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App {

	public static void main(String[] args) {
		
		Service service = new Service();
		Gson gson = new GsonBuilder().create();
		gson.toJson(service.repo.accountMap, System.out);
	}

}
