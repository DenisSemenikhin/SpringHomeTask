package com.epam.spring.hometask.discount.impl;

/*
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
*/