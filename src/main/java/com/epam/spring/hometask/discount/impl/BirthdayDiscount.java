package com.epam.spring.hometask.discount.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.User;
import com.epam.spring.hometask.service.DiscountService;

public class BirthdayDiscount implements DiscountService {

	private byte birthdayDiscount = 0;

	public byte getBirthdayDiscount() {
		return birthdayDiscount;
	}

	public void setBirthdayDiscount(byte birthdayDiscount) {
		this.birthdayDiscount = birthdayDiscount;
	}

	@Override
	public int getDiscount(User user, Event event, LocalDateTime airDateTime, long numberOfTickets) {
		LocalDate dateAirDate = LocalDate.now();
		LocalDate dateUserBirthday = user.getDateBirthday();
		long difference = ChronoUnit.DAYS.between(dateAirDate, dateUserBirthday);
		return (0 >= difference && difference <= 5) ? birthdayDiscount : 0;
	}

}
