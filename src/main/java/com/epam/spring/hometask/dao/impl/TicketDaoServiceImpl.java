package com.epam.spring.hometask.dao.impl;

import com.epam.spring.hometask.dao.TicketsDaoService;
import com.epam.spring.hometask.dao.repository.DaoTicketRepository;
import com.epam.spring.hometask.domain.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@EnableJpaRepositories("com.epam.spring.hometask")
public class TicketDaoServiceImpl implements TicketsDaoService {


    @Autowired
    @Qualifier("DaoTicketRepository")
    private DaoTicketRepository<Ticket,Long> daoTicketRepository;

    @Override
    public Ticket save(Ticket ticket) {
        return daoTicketRepository.save(ticket);
    }

    @Override
    public boolean remove(Ticket ticket) {
        daoTicketRepository.delete(ticket);
        return !daoTicketRepository.existsById(ticket.getId());
    }

    @Override
    public Ticket getById(Long ticketId) {
        return daoTicketRepository.findAll()
                .stream().filter(tk -> tk.getId().equals(ticketId)).findFirst().get();
    }

    @Override
    public Collection<Ticket> getAll() {
        return daoTicketRepository.findAll();
    }

    @Override
    public void saveAll(Collection<Ticket> tickets) {
        daoTicketRepository.saveAll(tickets);
    }
}


