package com.epam.spring.hometask.dao.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.epam.spring.hometask.dao.EventDaoService;
import com.epam.spring.hometask.domain.Event;

public class EventDaoServiceImpl implements EventDaoService {

	private static Map<Long, Event> events = new HashMap<Long, Event>();

	@Override
	public Event save(Event event) {
		return events.put(event.getId(), event);
	}

	@Override
	public boolean remove(Event event) {
		if (events.containsKey(event.getId())) {
			events.remove(event.getId());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Event getById(Long id) {
		return events.get(id);
	}

	@Override
	public Collection<Event> getAll() {
		return events.values();
	}

	@Override
	public Event getByName(String eventName) {
		List<Event> eventList = new ArrayList<Event>(events.values());
		for (Event event : eventList) {
			if (event.getName().equals(eventName)) {
				return event;
			}
		}
		return null;
	}

	@Override
	public Set<Event> getForDateRange(LocalDate dateFrom, LocalDate dateTo) {
		List<Event> eventList = (List<Event>) events.values();
		@SuppressWarnings("unchecked")
		Set<Event> resultEventsList = (Set<Event>) new ArrayList<Event>();
		for (Event event : eventList) {
			if (event.airsOnDates(dateFrom, dateTo)) {
				resultEventsList.add(event);
			}
		}
		return resultEventsList.isEmpty() ? null : resultEventsList;
	}

	@Override
	public Set<Event> getNextEvents(LocalDateTime dateTo) {
		List<Event> eventList = (List<Event>) events.values();
		@SuppressWarnings("unchecked")
		Set<Event> resultEventsList = (Set<Event>) new ArrayList<Event>();
		for (Event event : eventList) {
			if (event.airsOnDates(LocalDateTime.now(), dateTo)) {
				resultEventsList.add(event);
			}
		}
		return resultEventsList.isEmpty() ? null : resultEventsList;
	}

}
