package com.lodenrogue.fishingtournament.service;

import com.lodenrogue.fishingtournament.model.Catch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatchFacade extends AbstractFacade<Catch> {

	public CatchFacade() {
		super(Catch.class);
	}

	public List<Catch> findUnreviewed() {
		return findAllFromQuery("FROM Catch WHERE review_date IS NULL", null);
	}

	public List<Catch> findByUser(long userId) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("user_id", userId);

		return findAllFromQuery("FROM Catch WHERE user_id = :user_id", parameters);
	}
}
