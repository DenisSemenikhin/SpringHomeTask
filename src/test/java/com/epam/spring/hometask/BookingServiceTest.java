/*
 * package com.epam.spring.hometask;
 * 
 * import java.time.LocalDate; import java.time.LocalDateTime; import
 * java.util.Arrays; import java.util.HashSet; import java.util.Set;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.test.context.ContextConfiguration; import
 * org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
 * import org.testng.Assert; import org.testng.annotations.BeforeClass; import
 * org.testng.annotations.Test;
 * 
 * import com.epam.spring.hometask.domain.Auditorium; import
 * com.epam.spring.hometask.domain.Event; import
 * com.epam.spring.hometask.domain.EventRating; import
 * com.epam.spring.hometask.domain.Ticket; import
 * com.epam.spring.hometask.domain.User; import
 * com.epam.spring.hometask.service.AuditoriumService; import
 * com.epam.spring.hometask.service.BookingService; import
 * com.epam.spring.hometask.service.EventService;
 * 
 * @ContextConfiguration(locations = "classpath:applicationContext.xml") public
 * class BookingServiceTest extends AbstractTestNGSpringContextTests {
 * 
 * // EVENT private static final Long EVENT_TEST_ID = 1l; private static final
 * String EVENT_TEST_NAME = "NewYear"; private static final double
 * EVENT_TEST_PRICE = 100.0; private static final EventRating EVENT_TEST_RATING
 * = EventRating.HIGH;
 * 
 * // USER private static final Long USER_TEST_ID = 1l; private static final
 * String USER_TEST_FIRST_NAME = "Den"; private static final String
 * USER_TEST_LAST_NAME = "Semenikhin"; private static final String
 * USER_TEST_EMAIL = "fromrussia@withlove.com"; private static final LocalDate
 * USER_TEST_BIRTHDAY = LocalDate.of(1985, 3, 15); private static final String
 * NAME_OF_AUDITORIUM = "Monro"; private static final LocalDateTime
 * TEST_DATE_TIME = LocalDateTime.of(2017, 2, 3, 18, 30);
 * 
 * private static final double EXPECTED_TICKETS_PRICE = 480.0;
 * 
 * @Autowired private EventService eventService;
 * 
 * @Autowired private BookingService bookingService;
 * 
 * @Autowired private AuditoriumService auditoriumService;
 * 
 * private Event event; private User user;
 * 
 * @BeforeClass public void initEventTest() { Auditorium auditorium =
 * auditoriumService.getByName(NAME_OF_AUDITORIUM); event = new Event();
 * event.setId(EVENT_TEST_ID); event.setName(EVENT_TEST_NAME);
 * event.setBasePrice(EVENT_TEST_PRICE); event.setRating(EVENT_TEST_RATING);
 * event.addAirDateTime(TEST_DATE_TIME, auditorium); eventService.save(event); }
 * 
 * @BeforeClass public void initUserTest() { user = new User();
 * user.setId(USER_TEST_ID); user.setFirstName(USER_TEST_FIRST_NAME);
 * user.setLastName(USER_TEST_LAST_NAME); user.setEmail(USER_TEST_EMAIL);
 * user.setDateBirthday(USER_TEST_BIRTHDAY); }
 * 
 * @Test(dependsOnGroups = { TestConstants.GROUP_EVENT_TEST,
 * TestConstants.GROUP_USER_TEST }, description = "getTicketsPrice()") public
 * void getTicketsPriceTest() { Set<Long> seats = new
 * HashSet<>(Arrays.asList(2l, 1l)); double actualTicketsPrice =
 * bookingService.getTicketsPrice(event, TEST_DATE_TIME, user, seats);
 * Assert.assertEquals(actualTicketsPrice, EXPECTED_TICKETS_PRICE); }
 * 
 * @Test(dependsOnGroups = { TestConstants.GROUP_EVENT_TEST,
 * TestConstants.GROUP_USER_TEST }, description =
 * "getPurchasedTicketsForEvent()") public void
 * getPurchasedTicketsForEventTest() { Ticket firstTestTicket = new Ticket(user,
 * event, TEST_DATE_TIME, 1); Ticket secondTestTicket = new Ticket(user, event,
 * TEST_DATE_TIME, 2);
 * 
 * Set<Ticket> tickets = new HashSet<>(); tickets.add(firstTestTicket);
 * tickets.add(secondTestTicket);
 * 
 * bookingService.bookTickets(tickets); Set<Ticket> ticketsActual =
 * bookingService.getPurchasedTicketsForEvent(event, TEST_DATE_TIME);
 * Assert.assertEquals(ticketsActual, tickets); }
 * 
 * }
 */