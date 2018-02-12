package com.epam.spring.hometask.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("DaoEventRepository")
public interface DaoEventRepository<Event, Long> extends JpaRepository<com.epam.spring.hometask.domain.Event, Long> {

}
