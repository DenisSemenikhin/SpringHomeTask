package com.epam.spring.hometask.discount.impl;

import com.epam.spring.hometask.domain.Discount;
import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.User;
import com.epam.spring.hometask.service.DiscountService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class BirthdayDiscount implements DiscountService {

	public BirthdayDiscount() {
	}

	private Discount birthdayDiscount;

    public BirthdayDiscount(Discount birthdayDiscount) {
        this.birthdayDiscount = birthdayDiscount;
    }

    public void setBirthdayDiscount(Discount birthdayDiscount) {
        this.birthdayDiscount = birthdayDiscount;
    }

	@Override
	public Discount getDiscount(User user, Event event, LocalDateTime airDateTime, long numberOfTickets) {
		LocalDate dateAirDate = airDateTime.toLocalDate().withYear(0);
		LocalDate dateUserBirthday = user.getDateBirthday().withYear(0);
		long difference = ChronoUnit.DAYS.between(dateAirDate, dateUserBirthday);
		if (0 >= difference && difference <= 5) {
		    return birthdayDiscount;
        } else {
		    birthdayDiscount.setDiscountValue(0);
		    return birthdayDiscount;
        }
	}

}
