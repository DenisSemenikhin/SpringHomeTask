package com.epam.spring.hometask.service.impl;

import java.time.LocalDateTime;
import java.util.NavigableMap;
import java.util.Set;

import com.epam.spring.hometask.domain.Auditorium;
import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.EventRating;
import com.epam.spring.hometask.domain.Ticket;
import com.epam.spring.hometask.domain.User;
import com.epam.spring.hometask.service.AuditoriumService;
import com.epam.spring.hometask.service.BookingService;
import com.epam.spring.hometask.service.DiscountService;
import com.epam.spring.hometask.service.EventService;
import com.epam.spring.hometask.service.UserService;

public class BookingServiceImpl implements BookingService {

	private double hightEventRate = 1.2;
	private double vipSeatRate = 2;

	private DiscountService discountService;
	private AuditoriumService auditoriumService;
	private EventService eventService;
	private UserService userService;

	@Override
	public double getTicketsPrice(Event event, LocalDateTime dateTime, User user, Set<Long> seats) {
		double totalPrice = 0;
		double basePrice;
		double baseEventPrice = event.getBasePrice();
		if (event.getRating() == EventRating.HIGH) {
			baseEventPrice = baseEventPrice * hightEventRate;
		}
		int ticketsCount = 0;
		for (Long id : seats) {
			basePrice = baseEventPrice;
			Event eventById = eventService.getById(event.getId());
			Auditorium auditorium = eventById.getAuditoriums().get(dateTime);
			boolean isSeatVip = auditoriumService.getByName(auditorium.getName()).isSeatVip(id);
			if (isSeatVip) {
				basePrice *= vipSeatRate;
			}
			int discount = discountService.getDiscount(user, event, dateTime, ++ticketsCount);
			basePrice = basePrice * (100 - discount) / 100;
			totalPrice += basePrice;
		}
		return totalPrice;
	}

	@Override
	public void bookTickets(Set<Ticket> tickets) {
		for (Ticket ticket : tickets) {
			Long eventId = ticket.getEvent().getId();
			Event event = eventService.getById(eventId);
			event.getAuditoriums().get(ticket.getDateTime()).addTicket(ticket);
			User user = ticket.getUser();
			Long userId = user.getId();

			if (userService.getById(userId) != null) {
				user.getTickets().add(ticket);
				userService.save(user);
			}
		}
	}

	@Override
	public Set<Ticket> getPurchasedTicketsForEvent(Event event, LocalDateTime dateTime) {
		Event choosenEvent = eventService.getById(event.getId());
		NavigableMap<LocalDateTime, Auditorium> auditoriums = choosenEvent.getAuditoriums();
		Auditorium auditorium = auditoriums.get(dateTime);
		return auditorium.getTickets();
	}

	public double getHightEventRate() {
		return hightEventRate;
	}

	public void setHightEventRate(double hightEventRate) {
		this.hightEventRate = hightEventRate;
	}

	public double getVipSeatRate() {
		return vipSeatRate;
	}

	public void setVipSeatRate(double vipSeatRate) {
		this.vipSeatRate = vipSeatRate;
	}

	public DiscountService getDiscountService() {
		return discountService;
	}

	public void setDiscountService(DiscountService discountService) {
		this.discountService = discountService;
	}

	public AuditoriumService getAuditoriumService() {
		return auditoriumService;
	}

	public void setAuditoriumService(AuditoriumService auditoriumService) {
		this.auditoriumService = auditoriumService;
	}

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
