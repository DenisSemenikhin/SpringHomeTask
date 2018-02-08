package com.epam.spring.hometask.dao;


import com.epam.spring.hometask.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDaoService extends JpaRepository<User,Long>, JpaSpecificationExecutor<User>,
		DaoRepository<User,Long> {

	public User getUserByEmail(String email);

}
