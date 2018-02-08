package com.epam.spring.hometask.dao;

import com.epam.spring.hometask.domain.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditoriumDaoService extends JpaRepository<Auditorium, Long>{

}
