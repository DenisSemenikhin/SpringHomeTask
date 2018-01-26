package com.epam.spring.hometask.service.impl;

import com.epam.spring.hometask.domain.Discount;
import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.User;
import com.epam.spring.hometask.service.DiscountService;
import com.epam.spring.hometask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

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
	public Discount getDiscount(User user, Event event, LocalDateTime airDateTime, long numberOfTickets) {
		Discount maximumDiscount = new Discount(0,"Base Discount");
		for (DiscountService discountService : discounts) {
			Discount currentDiscount = discountService.getDiscount(user, event, airDateTime, numberOfTickets);
			if (currentDiscount.getDiscountValue() > maximumDiscount.getDiscountValue()) {
				maximumDiscount = currentDiscount;
			}
		}
		return maximumDiscount;
	}

}
