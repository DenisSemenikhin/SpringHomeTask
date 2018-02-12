package com.epam.spring.hometask.service.impl;

import com.epam.spring.hometask.dao.TicketsDaoService;
import com.epam.spring.hometask.domain.Ticket;
import com.epam.spring.hometask.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.Collection;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketsDaoService ticketsDaoService;

    @Override
    public void saveAll(Collection<Ticket> tickets) {
        ticketsDaoService.saveAll(tickets);
    }

    @Override
    public Ticket save(@Nonnull Ticket ticket) {
        return ticketsDaoService.save(ticket);
    }

    @Override
    public boolean remove(@Nonnull Ticket ticket) {
        return ticketsDaoService.remove(ticket);
    }

    @Override
    public Ticket getById(@Nonnull Long id) {
        return ticketsDaoService.getById(id);
    }

    @Nonnull
    @Override
    public Collection<Ticket> getAll() {
        return ticketsDaoService.getAll();
    }
}
