package com.epam.spring.hometask.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.spring.hometask.dao.EventDaoService;
import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDaoService eventDaoService;

	public EventDaoService getEventDaoService() {
		return eventDaoService;
	}

	public void setEventDaoService(EventDaoService eventDaoService) {
		this.eventDaoService = eventDaoService;
	}

	@Override
	public Event save(Event event) {
		return eventDaoService.save(event);
	}

	@Override
	public boolean remove(Event event) {
		return eventDaoService.remove(event);
	}

	@Override
	public Event getById(Long eventId) {
		return eventDaoService.getById(eventId);
	}

	@Override
	public Collection<Event> getAll() {
		return eventDaoService.getAll();
	}

	@Override
	public Event getByName(String eventName) {
		return eventDaoService.getByName(eventName);
	}

	@Override
	public Set<Event> getForDateRange(LocalDate dateFrom, LocalDate dateTo) {
		return (Set<Event>) eventDaoService.getForDateRange(dateFrom, dateTo);
	}

	@Override
	public Set<Event> getNextEvents(LocalDateTime dateTo) {
		return eventDaoService.getNextEvents(dateTo);
	}

}
