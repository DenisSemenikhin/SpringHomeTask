package com.epam.spring.hometask.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("DaoAuditoriumRepository")
public interface DaoAuditoriumRepository<Auditorium,Long>
        extends JpaRepository<com.epam.spring.hometask.domain.Auditorium, Long> {
}
