package com.epam.spring.hometask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.epam.spring.hometask.config.BirthDayDiscountConfig;
import com.epam.spring.hometask.config.BookingConfig;
import com.epam.spring.hometask.config.FirstAuditoriumConfig;
import com.epam.spring.hometask.config.LuckyTicketDiscountConfig;
import com.epam.spring.hometask.config.SecondAuditoriumConfig;
import com.epam.spring.hometask.discount.impl.BirthdayDiscount;
import com.epam.spring.hometask.discount.impl.LuckyTicketDiscount;
import com.epam.spring.hometask.domain.Auditorium;
import com.epam.spring.hometask.service.DiscountService;

@Configuration
@ComponentScan("com.epam.spring.hometask")
public class AppConfig {

	@Autowired
	private FirstAuditoriumConfig firstAuditoriumConfig;
	@Autowired
	private SecondAuditoriumConfig secondAuditoriumConfig;

	@Autowired
	private BirthDayDiscountConfig birthDayDiscountConfig;
	@Autowired
	private LuckyTicketDiscountConfig luckyTicketDiscountConfig;

	@Autowired
	private BookingConfig bookingConfig;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholder() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean(name = "bunchOfAuditoriums")
	public Map<String, Auditorium> bunchOfAuditoriums() {
		Map<String, Auditorium> bunchOfAuditoriums = new HashMap<>();

		Auditorium firstAuditorium = new Auditorium();
		firstAuditorium.setName(firstAuditoriumConfig.getName());
		firstAuditorium.setNumberOfSeats(firstAuditoriumConfig.getNumberOfSeats());
		firstAuditorium.setVipSeats(firstAuditoriumConfig.getVipSeats());

		Auditorium secondAuditorium = new Auditorium();
		secondAuditorium.setName(secondAuditoriumConfig.getName());
		secondAuditorium.setNumberOfSeats(secondAuditoriumConfig.getNumberOfSeats());
		secondAuditorium.setVipSeats(secondAuditoriumConfig.getVipSeats());

		bunchOfAuditoriums.put(firstAuditorium.getName(), firstAuditorium);
		bunchOfAuditoriums.put(secondAuditorium.getName(), secondAuditorium);

		return bunchOfAuditoriums;
	}

	@Bean(name = "bunchOfDiscounts")
	public List<DiscountService> bunchOfDiscounts() {
		List<DiscountService> bunchOfDiscounts = new ArrayList<>();

		BirthdayDiscount birthDayDiscount = new BirthdayDiscount();
		birthDayDiscount.setBirthdayDiscount(birthDayDiscountConfig.getDiscount());
		bunchOfDiscounts.add(birthDayDiscount);

		LuckyTicketDiscount luckyTicketDiscount = new LuckyTicketDiscount();
		luckyTicketDiscount.setLuckyDiscount(luckyTicketDiscountConfig.getDiscount());
		luckyTicketDiscount.setNextLuckyTicketRate(luckyTicketDiscountConfig.getNextTicketRate());
		bunchOfDiscounts.add(luckyTicketDiscount);
		return bunchOfDiscounts;
	}

	@Bean(name = "hightEventRate")
	public double hightEventRate() {
		return bookingConfig.getHightEventRate();
	}

	@Bean(name = "vipSeatRate")
	public double vipSeatRate() {
		return bookingConfig.getVipSeatRate();
	}

}
