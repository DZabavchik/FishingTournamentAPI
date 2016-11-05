package com.lodenrogue.fishingtournament.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lodenrogue.fishingtournament.model.User;
import com.lodenrogue.fishingtournament.service.UserFacade;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class UserController {

	@RequestMapping(path = "/users", method = RequestMethod.POST)
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		user = new UserFacade().create(user);
		return new ResponseEntity<Object>(user, HttpStatus.CREATED);
	}

	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public ResponseEntity<Object> getUser(@RequestParam String email, @RequestParam String firstName, @RequestParam String lastName) {
		User user = new UserFacade().findByCredentials(email, firstName, lastName);
		if (user == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<Object>(user, HttpStatus.OK);
		}
	}

}
