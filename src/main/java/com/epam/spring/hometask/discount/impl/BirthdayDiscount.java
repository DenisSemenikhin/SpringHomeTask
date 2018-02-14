package com.epam.spring.hometask.discount.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.epam.spring.hometask.domain.Discount;
import com.epam.spring.hometask.domain.User;
import com.epam.spring.hometask.service.DiscountGetService;

public class BirthdayDiscount implements DiscountGetService {

	public BirthdayDiscount(Discount discount) {
		this.birthdayDiscount = discount;
		this.birthdayDiscountValue = this.birthdayDiscount.getDiscountValue();
	}

	private Discount birthdayDiscount;

	private int birthdayDiscountValue;

	@Override
	public Discount getDiscount(User user, LocalDateTime airDateTime, long numberOfTickets) {
		LocalDate eventDate = airDateTime.toLocalDate();
		LocalDate birthDate = user.getDateBirthday().toLocalDate();
		long difference = getDaysBetweenBirthdayAndEventDate(eventDate, birthDate);
		if (difference > 0 && difference < 5) {
			birthdayDiscount.setDiscountValue(birthdayDiscountValue);
			return birthdayDiscount;
		} else {
			birthdayDiscount.setDiscountValue(0);
			return birthdayDiscount;
		}
	}

	private long getDaysBetweenBirthdayAndEventDate(LocalDate eventDate, LocalDate dateUserBirthday) {
		LocalDate birthdayDate = dateUserBirthday.withYear(eventDate.getYear());
		return Math.min(Math.abs(ChronoUnit.DAYS.between(eventDate, birthdayDate)),
				Math.min(Math.abs(ChronoUnit.DAYS.between(eventDate, birthdayDate.plusYears(1))),
						Math.abs(ChronoUnit.DAYS.between(eventDate, birthdayDate.minusYears(1)))));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthdayDiscount == null) ? 0 : birthdayDiscount.hashCode());
		result = prime * result + birthdayDiscountValue;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BirthdayDiscount other = (BirthdayDiscount) obj;
		if (birthdayDiscount == null) {
			if (other.birthdayDiscount != null)
				return false;
		} else if (!birthdayDiscount.equals(other.birthdayDiscount))
			return false;
		if (birthdayDiscountValue != other.birthdayDiscountValue)
			return false;
		return true;
	}

}