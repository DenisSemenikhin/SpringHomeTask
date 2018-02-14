package com.epam.spring.hometask.discount.impl;

import java.time.LocalDateTime;

import com.epam.spring.hometask.domain.Discount;
import com.epam.spring.hometask.domain.User;
import com.epam.spring.hometask.service.DiscountGetService;

public class LuckyTicketDiscount implements DiscountGetService {

	private Discount luckyTicketDiscount;

	private int nextLuckyTicketRate;

	private int luckyTicketDiscountValue;

	public LuckyTicketDiscount(Discount luckyTicketDiscount, int nextLuckyTicketRate) {
		this.luckyTicketDiscount = luckyTicketDiscount;
		this.nextLuckyTicketRate = nextLuckyTicketRate;
		this.luckyTicketDiscountValue = this.luckyTicketDiscount.getDiscountValue();
	}

	@Override
	public Discount getDiscount(User user, LocalDateTime airDateTime, long numberOfTickets) {
		if (nextLuckyTicketRate != 0) {
			if (user.isRegistrationStatus()) {
				if (numberOfTickets % nextLuckyTicketRate == 0) {
					luckyTicketDiscount.setDiscountValue(luckyTicketDiscountValue);
					return luckyTicketDiscount;
				}
			} else {
				long numberOfUserTickets = user.getTickets().size() + numberOfTickets;
				if (numberOfUserTickets % nextLuckyTicketRate == 0) {
					luckyTicketDiscount.setDiscountValue(luckyTicketDiscountValue);
					return luckyTicketDiscount;
				}
			}
		}
		luckyTicketDiscount.setDiscountValue(0);
		return luckyTicketDiscount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((luckyTicketDiscount == null) ? 0 : luckyTicketDiscount.hashCode());
		result = prime * result + luckyTicketDiscountValue;
		result = prime * result + nextLuckyTicketRate;
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
		LuckyTicketDiscount other = (LuckyTicketDiscount) obj;
		if (luckyTicketDiscount == null) {
			if (other.luckyTicketDiscount != null)
				return false;
		} else if (!luckyTicketDiscount.equals(other.luckyTicketDiscount))
			return false;
		if (luckyTicketDiscountValue != other.luckyTicketDiscountValue)
			return false;
		if (nextLuckyTicketRate != other.nextLuckyTicketRate)
			return false;
		return true;
	}

}
