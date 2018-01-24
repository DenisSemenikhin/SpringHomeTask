package com.epam.spring.hometask.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.epam.spring.hometask.dao.UserDaoService;
import com.epam.spring.hometask.domain.User;

@Repository
public class UserDaoServiceImpl implements UserDaoService {

	private static Map<Long, User> users = new HashMap<Long, User>();

	@Override
	public User save(User user) {
		return users.put(user.getId(), user);
	}

	@Override
	public boolean remove(User user) {
		if (users.containsKey(user.getId())) {
			users.remove(user.getId());
			return true;
		} else {
			return false;
		}

	}

	@Override
	public User getById(Long id) {
		return users.get(id);
	}

	@Override
	public Collection<User> getAll() {
		return users.values();
	}

	@Override
	public User getUserByEmail(String email) {
		List<User> usersList = new ArrayList<User>(users.values());
		for (User user : usersList) {
			if (user.getEmail().equals(email)) {
				return user;
			}
		}
		return null;
	}

	public static Map<Long, User> getUsers() {
		return users;
	}

	public static void setUsers(Map<Long, User> users) {
		UserDaoServiceImpl.users = users;
	}

}
