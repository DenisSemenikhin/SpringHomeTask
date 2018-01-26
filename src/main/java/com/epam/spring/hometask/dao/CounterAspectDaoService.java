package com.epam.spring.hometask.dao;

import com.epam.spring.hometask.domain.Event;

public interface CounterAspectDaoService {

	public void saveEventByNameCall(Event event);

	public void savePriceOfEventCall(Event event);

	public void saveBookingOfTicketCall(Event event);

}
