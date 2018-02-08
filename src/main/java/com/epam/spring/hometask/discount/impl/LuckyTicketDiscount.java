package com.epam.spring.hometask.discount.impl;

/*
public class LuckyTicketDiscount implements DiscountService {


    private Discount luckyTicketDiscount;

    private int nextLuckyTicketRate;

    private int luckyTicketDiscountValue;


    public LuckyTicketDiscount(Discount luckyTicketDiscount, int nextLuckyTicketRate) {
        this.luckyTicketDiscount = luckyTicketDiscount;
        this.nextLuckyTicketRate = nextLuckyTicketRate;
        this.luckyTicketDiscountValue = this.luckyTicketDiscount.getDiscountValue();
    }

	@Override
	public Discount getDiscount(User user, Event event, LocalDateTime airDateTime, long numberOfTickets) {
		if (nextLuckyTicketRate != 0) {
			if (user.isRegistrationStatus()) {
			    if (numberOfTickets % nextLuckyTicketRate == 0){
			        luckyTicketDiscount.setDiscountValue(luckyTicketDiscountValue);
			        return luckyTicketDiscount;
                }
			} else {
				long numberOfUserTickets = user.getTickets().size() + numberOfTickets;
                if (numberOfUserTickets  % nextLuckyTicketRate == 0){
                    luckyTicketDiscount.setDiscountValue(luckyTicketDiscountValue);
                    return luckyTicketDiscount;
                }
			}
		}
        luckyTicketDiscount.setDiscountValue(0);
        return luckyTicketDiscount;
	}

}
*/