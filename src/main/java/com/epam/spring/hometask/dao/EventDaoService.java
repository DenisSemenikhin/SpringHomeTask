package com.epam.spring.hometask.dao;

import com.epam.spring.hometask.domain.Event;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@NoRepositoryBean
public interface EventDaoService extends AbstractDomainObjectDaoService<Event> {

	public Set<Event> getForDateRange(LocalDate dateFrom, LocalDate dateTo);

	public Set<Event> getNextEvents(LocalDateTime dateTo);
}
