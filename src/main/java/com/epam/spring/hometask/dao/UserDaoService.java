package com.epam.spring.hometask.dao;


import com.epam.spring.hometask.domain.User;
import org.springframework.data.repository.NoRepositoryBean;

import javax.annotation.Nonnull;
import java.util.Collection;

@NoRepositoryBean
public interface UserDaoService {

	public User getUserByEmail(String email);

	public User save(@Nonnull User user);

	public boolean remove(@Nonnull User user);

	public User getById(@Nonnull Long id);

	public Collection<User> getAll();

}
