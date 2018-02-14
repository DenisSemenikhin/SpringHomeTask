package com.epam.spring.hometask.spring.config;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication
@ComponentScan("com.epam.spring.hometask")
public class AppConfig {

	@Autowired
	EntityManager entityManager;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholder() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
//	@Autowired
//	private FirstAuditoriumConfig firstAuditoriumConfig;
//	@Autowired
//	private SecondAuditoriumConfig secondAuditoriumConfig;
//	@Autowired
//	private BookingConfig bookingConfig;
//
//	@Bean(name = "bunchOfDiscounts")
//	@Scope("prototype")
//	public List<DiscountGetService> bunchOfDiscounts() {
//		List<DiscountGetService> bunchOfDiscounts = new ArrayList<>();
//
//		BirthdayDiscount birthDayDiscount = new BirthdayDiscount(birthDayDiscountConfig.getDiscount());
//		bunchOfDiscounts.add(birthDayDiscount);
//
//		LuckyTicketDiscount luckyTicketDiscount = new LuckyTicketDiscount(luckyTicketDiscountConfig.getDiscount(),
//				luckyTicketDiscountConfig.getNextTicketRate());
//
//		bunchOfDiscounts.add(luckyTicketDiscount);
//		return bunchOfDiscounts;
//	}
//
//	@Bean(name = "hightEventRate")
//	public double hightEventRate() {
//		return bookingConfig.getHightEventRate();
//	}
//
//	@Bean(name = "vipSeatRate")
//	public double vipSeatRate() {
//		return bookingConfig.getVipSeatRate();
//	}
//
//}
//	@Autowired
//	private BirthDayDiscountConfig birthDayDiscountConfig;
//	@Autowired
//	private LuckyTicketDiscountConfig luckyTicketDiscountConfig;

/*
 * @Bean(name = "bunchOfAuditoriums") public Map<String, Auditorium>
 * bunchOfAuditoriums() { Map<String, Auditorium> bunchOfAuditoriums = new
 * HashMap<>();
 * 
 * Auditorium firstAuditorium = new Auditorium();
 * firstAuditorium.setName(firstAuditoriumConfig.getName());
 * firstAuditorium.setNumberOfSeats(firstAuditoriumConfig.getNumberOfSeats());
 * firstAuditorium.setVipSeats(firstAuditoriumConfig.getVipSeats());
 * 
 * Auditorium secondAuditorium = new Auditorium();
 * secondAuditorium.setName(secondAuditoriumConfig.getName());
 * secondAuditorium.setNumberOfSeats(secondAuditoriumConfig.getNumberOfSeats());
 * secondAuditorium.setVipSeats(secondAuditoriumConfig.getVipSeats());
 * 
 * bunchOfAuditoriums.put(firstAuditorium.getName(), firstAuditorium);
 * bunchOfAuditoriums.put(secondAuditorium.getName(), secondAuditorium);
 * 
 * return bunchOfAuditoriums; }
 */
/*
 * @Bean(name = "bunchOfDiscounts")
 * 
 * @Scope("prototype") public List<DiscountService> bunchOfDiscounts() {
 * List<DiscountService> bunchOfDiscounts = new ArrayList<>();
 * 
 * BirthdayDiscount birthDayDiscount = new
 * BirthdayDiscount(birthDayDiscountConfig.getDiscount());
 * bunchOfDiscounts.add(birthDayDiscount);
 * 
 * LuckyTicketDiscount luckyTicketDiscount = new LuckyTicketDiscount(
 * luckyTicketDiscountConfig.getDiscount(),
 * luckyTicketDiscountConfig.getNextTicketRate());
 * 
 * bunchOfDiscounts.add(luckyTicketDiscount); return bunchOfDiscounts; }
 * 
 * @Bean(name = "hightEventRate") public double hightEventRate() { return
 * bookingConfig.getHightEventRate(); }
 * 
 * @Bean(name = "vipSeatRate") public double vipSeatRate() { return
 * bookingConfig.getVipSeatRate(); }
 */
