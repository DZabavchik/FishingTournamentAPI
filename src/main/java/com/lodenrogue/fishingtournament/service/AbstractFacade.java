package com.lodenrogue.fishingtournament.service;

import com.lodenrogue.fishingtournament.persistence.EntityManager;

import java.util.List;
import java.util.Map;

public class AbstractFacade<T> {
	private EntityManager<T> entityManager;

	public AbstractFacade(Class<T> entityClass) {
		entityManager = new EntityManager<T>(entityClass);
	}

	public List<T> findAll() {
		return entityManager.getAll();
	}

	public T find(long id) {
		return entityManager.get(id);
	}

	public T create(T t) {
		return entityManager.create(t);
	}

	public T update(T t) {
		return entityManager.update(t);
	}

	public void delete(long id) {
		entityManager.delete(id);
	}

	protected T findUnique(String query, Map<String, Object> parameters) {
		return entityManager.getUnique(query, parameters);
	}

	protected List<T> findAllFromQuery(String query, Map<String, Object> parameters) {
		return entityManager.findAllFromQuery(query, parameters);
	}

	protected List<T> findAllFromQuery(String query) {
		return entityManager.findAllFromQuery(query, null);
	}

}
