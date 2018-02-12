package com.epam.spring.hometask.service.impl;


import com.epam.spring.hometask.dao.EventDaoService;
import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDaoService eventDaoService;

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

    @Nonnull
    @Override
    public Set<Event> getForDateRange(@Nonnull LocalDate from, @Nonnull LocalDate to) {
        return eventDaoService.getForDateRange(from,to);
    }

    @Nonnull
    @Override
    public Set<Event> getNextEvents(@Nonnull LocalDateTime to) {
        return eventDaoService.getNextEvents(to);
    }
}
