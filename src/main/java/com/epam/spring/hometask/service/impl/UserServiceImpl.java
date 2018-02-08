package com.epam.spring.hometask.service.impl;


import com.epam.spring.hometask.dao.UserDaoService;
import com.epam.spring.hometask.domain.User;
import com.epam.spring.hometask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.EntityManager;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    EntityManager entityManager;

    @Autowired
    private UserDaoService userDaoService;



	@Transactional
    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        return userDaoService.getUserByEmail(email);
    }

    @Transactional
    @Override
    public User save(@Nonnull User user) {
        return userDaoService.save(user);
    }

    @Transactional
    @Override
    public boolean remove(@Nonnull User user) {
	    userDaoService.delete(user);
        return !userDaoService.existsById(user.getId());
    }

    @Transactional
    @Override
    public User getById(@Nonnull Long id) {
        return userDaoService.getOne(id);
    }

    @Transactional
    @Nonnull
    @Override
    public Collection<User> getAll() {
        return userDaoService.findAll();
    }
}
