package com.epam.spring.hometask.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.User;
import com.epam.spring.hometask.service.DiscountService;
import com.epam.spring.hometask.service.UserService;

@Service
public class DiscountServiceImpl implements DiscountService {

	@Autowired
	private UserService userService;

	@Resource(name = "bunchOfDiscounts")
	private List<DiscountService> discounts;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<DiscountService> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<DiscountService> discounts) {
		this.discounts = discounts;
	}

	@Override
	public int getDiscount(User user, Event event, LocalDateTime airDateTime, long numberOfTickets) {
		int maximumDiscount = 0;
		for (DiscountService discountService : discounts) {
			int currentDiscount = discountService.getDiscount(user, event, airDateTime, numberOfTickets);
			if (currentDiscount > maximumDiscount) {
				maximumDiscount = currentDiscount;
			}
		}
		return maximumDiscount;
	}

}
