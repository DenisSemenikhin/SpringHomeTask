package com.epam.spring.hometask.spring.config;

import com.epam.spring.hometask.domain.Discount;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:/discount.properties")
@Scope("prototype")
public class LuckyTicketDiscountConfig {

	@Value("#{T(java.lang.Integer).parseInt('${discount.lucky.discount}')}")
	private int discountValue;

    public LuckyTicketDiscountConfig() {
    }

    public int getNextTicketRate() {
        return nextTicketRate;
    }

    @Value("#{T(java.lang.Integer).parseInt('${discount.next.lucky.ticket.rate}')}")
	private int nextTicketRate;


    @Value("${discount.lucky.discount.name}")
    private String discountName;

    public void setDiscountValue(int discountValue) {
        this.discountValue = discountValue;
    }

    public void setNextTicketRate(int nextTicketRate) {
        this.nextTicketRate = nextTicketRate;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public Discount getDiscount() {
        Discount luckyTicketDiscount = new Discount(discountValue, discountName);
        return luckyTicketDiscount;
    }

}
