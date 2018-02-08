package com.epam.spring.hometask.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("DaoUserRepository")
public interface DaoUserRepository<User,Long> extends JpaRepository<com.epam.spring.hometask.domain.User,Long>{
}
