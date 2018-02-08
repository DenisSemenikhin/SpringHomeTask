package com.epam.spring.hometask;

/*
@ContextConfiguration(classes = { AppConfig.class }, loader = AnnotationConfigContextLoader.class)
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
		LocalDateTime airDateTime = LocalDateTime
				.of(USER_BIRTHDAY.getYear() + 15, dayOfMonthUserBirthday, monthOfUserBirthday, 00, 00).minusDays(2);
        Discount discount = discountService.getDiscount(user, event, airDateTime, 20);
		double discountActual =discount.getDiscountValue();
		Assert.assertEquals(discountActual, EXPECTED_HAPPY_DISCOUNT);
	}

	@Test(description = "invoke birthday discount")
	public void getDiscountBirthday() {
		LocalDateTime airDateTimeEventOnTime = LocalDateTime.of(USER_BIRTHDAY.getYear() + 15, dayOfMonthUserBirthday,
				monthOfUserBirthday, 00, 00);
        Discount discount = discountService.getDiscount(user, event, airDateTimeEventOnTime, 9);
		double discountActualWithinOneDay = discount.getDiscountValue();
		Assert.assertEquals(discountActualWithinOneDay, EXPECTED_BIRTHDAY_DISCOUNT);
		LocalDateTime airDateTimeEventFiveDay = LocalDateTime
				.of(USER_BIRTHDAY.getYear() + 15, dayOfMonthUserBirthday, monthOfUserBirthday, 00, 00).plusDays(5);
		discount = discountService.getDiscount(user, event, airDateTimeEventFiveDay, 9);
		double discountActualWithinFiveDay = discount.getDiscountValue();
		Assert.assertEquals(discountActualWithinFiveDay, EXPECTED_BIRTHDAY_DISCOUNT);
	}

	@Test(description = "invoke all discounts")
	public void getDiscountMatchAlllRequirements() {
		LocalDateTime airDateTimeEventFiveDay = LocalDateTime
				.of(USER_BIRTHDAY.getYear() + 15, dayOfMonthUserBirthday, monthOfUserBirthday, 00, 00).plusDays(2);

        Discount discount = discountService.getDiscount(user, event, airDateTimeEventFiveDay, 10);
		double discountActualWithinFiveDay = discount.getDiscountValue();

		Assert.assertEquals(discountActualWithinFiveDay, EXPECTED_HAPPY_DISCOUNT);
	}

}*/
