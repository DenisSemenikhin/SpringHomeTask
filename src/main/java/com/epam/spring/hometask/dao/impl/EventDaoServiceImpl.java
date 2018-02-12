package com.epam.spring.hometask.dao.impl;

import com.epam.spring.hometask.dao.EventDaoService;
import com.epam.spring.hometask.dao.repository.DaoEventRepository;
import com.epam.spring.hometask.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@EnableJpaRepositories("com.epam.spring.hometask")
public class EventDaoServiceImpl implements EventDaoService {

	@Autowired
	@Qualifier("DaoEventRepository")
	DaoEventRepository<Event, Long> daoEventRepository;

	@Override
	public Event save(Event event) {
		return daoEventRepository.save(event);
	}

	@Override
	public boolean remove(Event event) {
		daoEventRepository.delete(event);
		return !daoEventRepository.existsById(event.getId());
	}

	@Override
	public Event getById(Long id) {
		return daoEventRepository.findAll()
                .stream().filter(ev -> ev.getId().equals(id)).findFirst().get();
	}

	@Override
	public Collection<Event> getAll() {
		return daoEventRepository.findAll();
	}

	@Override
	public Set<Event> getForDateRange(LocalDate dateFrom, LocalDate dateTo) {
        return daoEventRepository.findAll().stream()
                .filter(ev -> ev.getDate().after(Date.valueOf(dateFrom)))
                .filter(ev -> ev.getDate().before(Date.valueOf(dateTo)))
                .collect(Collectors.toSet());
    }

     @Override
     public Set<Event> getNextEvents (LocalDateTime dateTo){
         return daoEventRepository.findAll().stream()
                .sorted((ev1, ev2) -> ev1.getDate().compareTo(ev2.getDate()))
                .filter(ev -> ev.getDate().after(Date.valueOf(dateTo.toLocalDate())))
                .collect(Collectors.toSet());

     }
}
