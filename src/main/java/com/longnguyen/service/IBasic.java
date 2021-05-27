package com.longnguyen.service;

import java.util.List;

public interface IBasic<T> {
	List<T> findAll();
	T save(T model);
	T update(T model);
	Boolean delete(Long id);
	T findOne(Long id);
}
