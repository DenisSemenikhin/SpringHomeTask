package com.epam.spring.hometask.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/booking.properties")
public class BookingConfig {

	@Value("#{T(java.lang.Double).parseDouble('${booking.hight.event.rate}')}")
	private double hightEventRate;

	@Value("#{T(java.lang.Double).parseDouble('${booking.vip.seat.rate}')}")
	private double vipSeatRate;

	public double getHightEventRate() {
		return hightEventRate;
	}

	public void setHightEventRate(double hightEventRate) {
		this.hightEventRate = hightEventRate;
	}

	public double getVipSeatRate() {
		return vipSeatRate;
	}

	public void setVipSeatRate(double vipSeatRate) {
		this.vipSeatRate = vipSeatRate;
	}

}
