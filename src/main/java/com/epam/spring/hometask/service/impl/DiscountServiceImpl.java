package com.epam.spring.hometask.service.impl;

/*
//@Service
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
*/