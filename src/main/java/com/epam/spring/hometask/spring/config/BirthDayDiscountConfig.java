package com.epam.spring.hometask.spring.config;

import com.epam.spring.hometask.domain.Discount;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/discount.properties")
public class BirthDayDiscountConfig {

	@Value("#{T(java.lang.Integer).parseInt('${discount.birthday.discount}')}")
	private int discountValue;

    @Value("${discount.birthday.discount.name}")
    private String discountName;

    public BirthDayDiscountConfig() {
    }

    public void setDiscountValue(int discountValue) {
        this.discountValue = discountValue;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public Discount getDiscount() {
        Discount birthdayDiscount = new Discount(discountValue, discountName);
	    return birthdayDiscount;
	}





}
