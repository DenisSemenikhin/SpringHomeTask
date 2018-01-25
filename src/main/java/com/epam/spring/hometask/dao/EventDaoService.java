package com.epam.spring.hometask.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

import com.epam.spring.hometask.domain.Event;

public interface EventDaoService {

	public Event save(Event event);

	public boolean remove(Event event);

	public Event getById(Long eventId);

	public Collection<Event> getAll();

	public Event getByName(String eventName);

	public Set<Event> getForDateRange(LocalDate dateFrom, LocalDate dateTo);

	public Set<Event> getNextEvents(LocalDateTime dateTo);

}
