package com.epam.spring.hometask.service;


import com.epam.spring.hometask.domain.Event;

import javax.annotation.Nonnull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;


public interface EventService extends AbstractDomainObjectService<Event> {

      /*
	 * Finding all events that air on specified date range
	 *
	 * @param from Start date
	 *
	 * @param to End date inclusive
	 *
	 * @return Set of events
	 */
    public @Nonnull Set<Event> getForDateRange(@Nonnull LocalDate from, @Nonnull LocalDate to);

	/*
	 * Return events from 'now' till the the specified date time
	 * 
	 * @param to End date time inclusive s
	 * 
	 * @return Set of events
	 */
    public @Nonnull Set<Event> getNextEvents(@Nonnull LocalDateTime to);

}
