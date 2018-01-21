package com.epam.spring.hometask.discount.impl;

import java.time.LocalDateTime;

import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.User;
import com.epam.spring.hometask.service.DiscountService;

public class LuckyTicketDiscount implements DiscountService {

	private byte luckyDiscount = 0;
	private int nextLuckyTicketRate;

	public byte getLuckyDiscount() {
		return luckyDiscount;
	}

	public void setLuckyDiscount(byte luckyDiscount) {
		this.luckyDiscount = luckyDiscount;
	}

	public int getNextLuckyTicketRate() {
		return nextLuckyTicketRate;
	}

	public void setNextLuckyTicketRate(int nextLuckyTicketRate) {
		this.nextLuckyTicketRate = nextLuckyTicketRate;
	}

	@Override
	public byte getDiscount(User user, Event event, LocalDateTime airDateTime, long numberOfTickets) {
		if (nextLuckyTicketRate != 0) {
			if (user.isRegistrationStatus()) {
				return numberOfTickets % nextLuckyTicketRate == 0 ? luckyDiscount : 0;
			} else {
				long numberOfUserTickets = user.getTickets().size() + numberOfTickets;
				return numberOfUserTickets % nextLuckyTicketRate == 0 ? luckyDiscount : 0;
			}
		}
		return 0;
	}

}
