package com.lodenrogue.fishingtournament.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lodenrogue.fishingtournament.model.Fish;
import com.lodenrogue.fishingtournament.service.FishFacade;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class FishController {

	@RequestMapping(path = "/fish", method = RequestMethod.POST)
	public ResponseEntity<Object> createFish(@RequestBody Fish fish) {
		fish = new FishFacade().create(fish);
		return new ResponseEntity<Object>(fish, HttpStatus.CREATED);
	}

	@RequestMapping(path = "/fish", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllFish() {
		List<Fish> fish = new FishFacade().findAll();
		return new ResponseEntity<Object>(fish, HttpStatus.OK);
	}

}
