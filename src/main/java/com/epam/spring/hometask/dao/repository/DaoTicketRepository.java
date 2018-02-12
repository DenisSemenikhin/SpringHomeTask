package com.epam.spring.hometask.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("DaoTicketRepository")
public interface DaoTicketRepository<Ticket,Long> extends JpaRepository<com.epam.spring.hometask.domain.Ticket, Long> {
}
