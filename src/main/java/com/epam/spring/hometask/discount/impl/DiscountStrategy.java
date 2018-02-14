package com.epam.spring.hometask.discount.impl;

import com.epam.spring.hometask.service.DiscountGetService;

public class DiscountStrategy {

	public static DiscountGetService getDiscount(DiscountGetService discountService) {
		return discountService;
	}

}
