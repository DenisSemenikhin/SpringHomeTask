package com.epam.spring.hometask.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/discount.properties")
public class BirthDayDiscountConfig {

	@Value("#{T(java.lang.Byte).parseByte('${discount.birthday.discount}')}")
	private byte discount;

	public byte getDiscount() {
		return discount;
	}

	public void setDiscount(byte discount) {
		this.discount = discount;
	}

}
