package com.epam.spring.hometask;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.EventRating;
import com.epam.spring.hometask.domain.User;
import com.epam.spring.hometask.service.DiscountService;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class DiscountServiceTest extends AbstractTestNGSpringContextTests {

	// User
	private static final Long USER_ID = 1l;
	private static final String USER_FIRST_NAME = "Den";
	private static final String USER_LAST_NAME = "Semenikhin";
	private static final String USER_EMAIL = "fromrussia@withlove.com";
	private static final LocalDate USER_BIRTHDAY = LocalDate.of(1985, 5, 15);

	// Event
	private static final Long ID_EVENT = 1l;
	private static final String EVENT_NAME = "EPAM";
	private static final double EVENT_PRICE = 100.0;
	private static final EventRating EVENT_RATING = EventRating.HIGH;

	// Expected discount
	private static final double EXPECTED_HAPPY_DISCOUNT = 50;
	private static final double EXPECTED_BIRTHDAY_DISCOUNT = 5;

	@Autowired
	@Qualifier("discountServiceImpl")
	private DiscountService discountService;
	private User user;
	private Event event;

	private static int dayOfMonthUserBirthday;
	private static int monthOfUserBirthday;

	@BeforeClass
	public void initTest() {
		user = new User();
		user.setId(USER_ID);
		user.setFirstName(USER_FIRST_NAME);
		user.setLastName(USER_LAST_NAME);
		user.setEmail(USER_EMAIL);
		user.setDateBirthday(USER_BIRTHDAY);

		event = new Event();
		event.setId(ID_EVENT);
		event.setName(EVENT_NAME);
		event.setBasePrice(EVENT_PRICE);
		event.setRating(EVENT_RATING);

		dayOfMonthUserBirthday = USER_BIRTHDAY.getMonthValue();
		monthOfUserBirthday = USER_BIRTHDAY.getDayOfMonth();
	}

	@Test(description = "invoke lucky discount")
	public void getDiscountEachTenthTicket() {
		LocalDateTime airDateTime = LocalDateTime.of(USER_BIRTHDAY.getYear() + 15, dayOfMonthUserBirthday, monthOfUserBirthday, 00, 00).minusDays(2);
		double discountActual = discountService.getDiscount(user, event, airDateTime, 20);
		Assert.assertEquals(discountActual, EXPECTED_HAPPY_DISCOUNT);
	}

	@Test(description = "invoke birthday discount")
	public void getDiscountBirthday() {
		LocalDateTime airDateTimeEventOnTime = LocalDateTime.of(USER_BIRTHDAY.getYear() + 15, dayOfMonthUserBirthday, monthOfUserBirthday, 00, 00);
		double discountActualWithinOneDay = discountService.getDiscount(user, event, airDateTimeEventOnTime, 9);
		Assert.assertEquals(discountActualWithinOneDay, EXPECTED_BIRTHDAY_DISCOUNT);

		LocalDateTime airDateTimeEventFiveDay = LocalDateTime.of(USER_BIRTHDAY.getYear() + 15, dayOfMonthUserBirthday, monthOfUserBirthday, 00, 00).plusDays(5);
		double discountActualWithinFiveDay = discountService.getDiscount(user, event, airDateTimeEventFiveDay, 9);
		Assert.assertEquals(discountActualWithinFiveDay, EXPECTED_BIRTHDAY_DISCOUNT);
	}

	@Test(description = "invoke all discounts")
	public void getDiscountMatchAlllRequirements() {
		LocalDateTime airDateTimeEventFiveDay = LocalDateTime.of(USER_BIRTHDAY.getYear() + 15, dayOfMonthUserBirthday, monthOfUserBirthday, 00, 00).plusDays(2);
		double discountActualWithinFiveDay = discountService.getDiscount(user, event, airDateTimeEventFiveDay, 10);
		Assert.assertEquals(discountActualWithinFiveDay, EXPECTED_HAPPY_DISCOUNT);
	}

}
