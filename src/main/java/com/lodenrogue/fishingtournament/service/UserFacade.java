package com.lodenrogue.fishingtournament.service;

import java.util.HashMap;
import java.util.Map;

import com.lodenrogue.fishingtournament.model.User;

public class UserFacade extends AbstractFacade<User> {

	public UserFacade() {
		super(User.class);
	}

	public User findByCredentials(String email, String firstName, String lastName) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("email", email);
		parameters.put("firstName", firstName);
		parameters.put("lastName", lastName);
		return findUnique("FROM User WHERE email = :email AND firstName = :firstName AND lastName = :lastName", parameters);
	}

}
