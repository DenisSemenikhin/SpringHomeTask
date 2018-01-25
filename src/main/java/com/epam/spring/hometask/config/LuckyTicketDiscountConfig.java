package com.epam.spring.hometask.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LuckyTicketDiscountConfig {

	@Value("#{T(java.lang.Integer).parseInt('${discount.lucky.discount}')}")
	private int discount;
	@Value("#{T(java.lang.Integer).parseInt('${discount.next.lucky.ticket.rate}')}")
	private int nextTicketRate;

	public int getNextTicketRate() {
		return nextTicketRate;
	}

	public void setNextTicketRate(int nextTicketRate) {
		this.nextTicketRate = nextTicketRate;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

}
