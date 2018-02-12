package com.epam.spring.hometask.service;

import com.epam.spring.hometask.domain.Ticket;

import java.util.Collection;

public interface TicketService extends AbstractDomainObjectService<Ticket> {
    /**
     * Save all tickets
     * @param tickets
     */
    public void saveAll(Collection<Ticket> tickets);
}
