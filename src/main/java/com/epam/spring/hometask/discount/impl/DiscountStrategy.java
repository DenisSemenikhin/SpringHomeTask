package com.epam.spring.hometask.discount.impl;

import com.epam.spring.hometask.service.DiscountService;

public class DiscountStrategy {

	public static DiscountService getDiscount(DiscountService discountService) {
		return discountService;
	}

}
