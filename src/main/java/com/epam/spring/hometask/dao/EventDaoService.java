package com.epam.spring.hometask.dao;

import com.epam.spring.hometask.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventDaoService extends JpaRepository<Event, Long> {
/*
	public Event getByName(String eventName);

	public Set<Event> getForDateRange(LocalDate dateFrom, LocalDate dateTo);

	public Set<Event> getNextEvents(LocalDateTime dateTo);
*/
}
