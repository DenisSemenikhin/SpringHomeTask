package com.epam.spring.hometask.service.impl;

import java.util.Collection;

import com.epam.spring.hometask.dao.UserDaoService;
import com.epam.spring.hometask.domain.User;
import com.epam.spring.hometask.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDaoService userDaoService;

	public UserDaoService getUserDaoService() {
		return userDaoService;
	}

	public void setUserDaoService(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}

	@Override
	public User save(User user) {
		return userDaoService.save(user);
	}

	@Override
	public boolean remove(User user) {
		return userDaoService.remove(user);
	}

	@Override
	public User getById(Long id) {
		return userDaoService.getById(id);
	}

	@Override
	public Collection<User> getAll() {
		return userDaoService.getAll();
	}

	@Override
	public User getUserByEmail(String email) {
		return userDaoService.getUserByEmail(email);
	}

}
