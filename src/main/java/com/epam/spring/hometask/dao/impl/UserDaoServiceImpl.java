package com.epam.spring.hometask.dao.impl;


import com.epam.spring.hometask.dao.UserDaoService;
import com.epam.spring.hometask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class UserDaoServiceImpl extends DaoRepositoryImpl<User,Long> implements UserDaoService{

    @PersistenceContext
    private EntityManager em;

   UserDaoService userDaoService;

   @Autowired
   Class domainClass;

   public UserDaoServiceImpl(Class domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
    }

    @Override
	public User getUserByEmail(String email) {
		return userDaoService.findAll().stream().filter(us -> us.getEmail().equals(email)).findAny().get();
	}


}
