package com.epam.spring.hometask.service;

import java.time.LocalDateTime;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.Ticket;
import com.epam.spring.hometask.domain.User;

public interface BookingService {

	/**
	 * Getting price when buying all supplied seats for particular event
	 * 
	 * @param event
	 *            Event to get base ticket price, vip seats and other information
	 * @param dateTime
	 *            Date and time of event air
	 * @param user
	 *            User that buys ticket could be needed to calculate discount. Can
	 *            be <code>null</code>
	 * @param seats
	 *            Set of seat numbers that user wants to buy
	 * @return total price
	 */
	public double getTicketsPrice(@Nonnull Event event, @Nonnull LocalDateTime dateTime, @Nullable User user,
			@Nonnull Set<Long> seats);

	/**
	 * Getting all purchased tickets for event on specific air date and time
	 * 
	 * @param event
	 *            Event to get tickets for
	 * 
	 * @param dateTime
	 *            Date and time of airing of event
	 * 
	 * @return set of all purchased tickets
	 */
	public @Nonnull Set<Ticket> getPurchasedTicketsForEvent(@Nonnull String eventName, @Nonnull LocalDateTime dateTime);

	/**
	 * Books tickets in internal system. If user is not <code>null</code> in a
	 * ticket then booked tickets are saved with it
	 * 
	 * @param tickets
	 *            Set of tickets
	 * 
	 */
	public void bookTickets(@Nonnull Set<Ticket> tickets);

}

/*
 * 
 * /* /** Books tickets in internal system. If user is not <code>null</code> in
 * a ticket then booked tickets are saved with it
 * 
 * @param tickets Set of tickets
 * 
 * public void bookTickets(@Nonnull Set<Ticket> tickets); /* /** Getting all
 * purchased tickets for event on specific air date and time
 * 
 * @param event Event to get tickets for
 * 
 * @param dateTime Date and time of airing of event
 * 
 * @return set of all purchased tickets
 * 
 * 
 */
