package com.lodenrogue.fishingtournament.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lodenrogue.fishingtournament.model.Catch;
import com.lodenrogue.fishingtournament.service.CatchFacade;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class CatchController {

	@RequestMapping(path = "/catches", method = RequestMethod.POST)
	public ResponseEntity<Object> createCatch(@RequestBody Catch catchEntry) {
		catchEntry = new CatchFacade().create(catchEntry);
		return new ResponseEntity<Object>(catchEntry, HttpStatus.CREATED);
	}

	@RequestMapping(path = "/catches", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllCatches() {
		List<Catch> catches = new CatchFacade().findAll();
		return new ResponseEntity<Object>(catches, HttpStatus.OK);
	}

	@RequestMapping(path = "/catches/unreviewed", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllUnreviewedCatches() {
		List<Catch> catches = new CatchFacade().findUnreviewed();
		return new ResponseEntity<Object>(catches, HttpStatus.OK);
	}

	@RequestMapping(path = "/catches/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateCatch(@PathVariable long id, @RequestBody Catch catchEntry) {
		
		// Check that catch exists
		Catch existing = new CatchFacade().find(id);
		if(existing == null){
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		
		catchEntry = new CatchFacade().update(catchEntry);
		return new ResponseEntity<Object>(catchEntry, HttpStatus.OK);
	}

}
