package com.epam.spring.hometask.service.impl;


import com.epam.spring.hometask.dao.UserDaoService;
import com.epam.spring.hometask.domain.User;
import com.epam.spring.hometask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoService userDaoService;


    @Override
    public User getUserByEmail(@Nonnull String email) {
        return userDaoService.getUserByEmail(email);
    }

    @Override
    public User save(@Nonnull User user) {
        return userDaoService.save(user);
    }

   @Override
    public boolean remove(@Nonnull User user) {
	   return userDaoService.remove(user);
    }

    @Override
    public User getById(@Nonnull Long id) {
        return userDaoService.getById(id);
    }

    @Override
    public Collection<User> getAll() {
        return userDaoService.getAll();
    }

}
