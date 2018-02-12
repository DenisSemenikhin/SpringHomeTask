package com.epam.spring.hometask.dao;

import com.epam.spring.hometask.domain.Ticket;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Collection;

@NoRepositoryBean
public interface TicketsDaoService extends AbstractDomainObjectDaoService<Ticket>{

	public void saveAll(Collection<Ticket> tickets);

}
