package com.epam.spring.hometask.dao.impl;

/*
public class TicketDaoServiceImpl implements TicketsDaoService {

	private static Map<Long, Ticket> tickets = new HashMap<Long, Ticket>();

	@Override
	public Ticket save(Ticket ticket) {
		return tickets.put(ticket.getId(), ticket);
	}

	@Override
	public boolean remove(Ticket ticket) {
		if (tickets.containsKey(ticket.getId())) {
			tickets.remove(ticket.getId());
			return true;
		}
		return false;
	}

	@Override
	public Ticket getById(Long ticketId) {
		return tickets.get(ticketId);
	}

	@Override
	public Collection<Ticket> getAll() {
		return tickets.values();
	}

	@Override
	public void saveAll(Collection<Ticket> tickets) {
		tickets.addAll(tickets);
	}

}
*/