package com.epam.spring.hometask.dao;

import java.util.Collection;

import com.epam.spring.hometask.domain.User;

public interface UserDaoService {

	public User save(User object);

	public boolean remove(User object);

	public User getById(Long id);

	public Collection<User> getAll();

	public User getUserByEmail(String email);

}
