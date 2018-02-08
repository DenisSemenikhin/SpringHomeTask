package com.epam.spring.hometask.dao.impl;


import com.epam.spring.hometask.dao.UserDaoService;
import com.epam.spring.hometask.dao.repository.DaoUserRepository;
import com.epam.spring.hometask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;


@Repository
@EnableJpaRepositories("com.epam.spring.hometask")
public class UserDaoServiceImpl implements UserDaoService{

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    @Qualifier("DaoUserRepository")
    private DaoUserRepository<User,Long> daoUserRepository;

    @Override
	public User getUserByEmail(String email) {
		return daoUserRepository.findAll().stream().filter(us -> us.getEmail().equals(email)).findAny().get();
	}

    @Override
    public User save(@Nonnull User user) {
        return daoUserRepository.save(user);
    }

    @Override
    public boolean remove(@Nonnull User user) {
        daoUserRepository.delete(user);
        return daoUserRepository.existsById(user.getId());
    }

    @Override
    public User getById(@Nonnull Long id) {
        return daoUserRepository.getOne(id);
    }

    @Override
    public Collection<User> getAll() {
        return daoUserRepository.findAll();
    }


}
