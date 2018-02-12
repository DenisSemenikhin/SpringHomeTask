package com.epam.spring.hometask.dao;


import com.epam.spring.hometask.domain.User;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UserDaoService extends AbstractDomainObjectDaoService<User> {

	public User getUserByEmail(String email);

}
