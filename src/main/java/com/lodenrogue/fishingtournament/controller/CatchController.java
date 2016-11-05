package com.lodenrogue.fishingtournament.controller;

import com.lodenrogue.fishingtournament.model.Catch;
import com.lodenrogue.fishingtournament.service.CatchFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
