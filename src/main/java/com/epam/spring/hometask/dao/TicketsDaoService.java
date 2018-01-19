package com.epam.spring.hometask.dao;

import java.util.Collection;

import com.epam.spring.hometask.domain.Ticket;

public interface TicketsDaoService {

	public Ticket save(Ticket ticket);

	public boolean remove(Ticket ticket);

	public Ticket getById(Long ticketId);

	public Collection<Ticket> getAll();

	public void saveAll(Collection<Ticket> tickets);

}
