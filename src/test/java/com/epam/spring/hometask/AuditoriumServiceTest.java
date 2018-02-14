package com.epam.spring.hometask;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.spring.hometask.domain.Auditorium;
import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.EventRating;
import com.epam.spring.hometask.domain.Seat;
import com.epam.spring.hometask.domain.SeatStatus;
import com.epam.spring.hometask.domain.Ticket;
import com.epam.spring.hometask.domain.User;
import com.epam.spring.hometask.service.AuditoriumService;
import com.epam.spring.hometask.spring.config.AppTestConfig;

@ContextConfiguration(classes = { AppTestConfig.class }, loader = AnnotationConfigContextLoader.class)
public class AuditoriumServiceTest extends AbstractTestNGSpringContextTests {

	private static final String FIRST_NAME = "Den";
	private static final String LAST_NAME = "Semenikhin";
	private static final String EMAIL = "fromrussia@withlove.com";
	private static final Integer SEAT_NUMBER = 1;

	private static final String EVENT_NAME = "TEST_EVENT";
	private static final Date EVENT_DATE = Date.valueOf("2000-01-01");
	private static final Long EVENT_PRICE = 100l;

	private static final Integer SEAT_NUMBERS = 10;
	private static final int[] VIP_SEAT_NUMBERS = { 1, 2, 3 };
	private static final String AUDITORIUM_NAME = "TEST_AUDITORIUM";

	@Autowired
	private AuditoriumService auditoriumService;
	private Auditorium auditorium;

	@BeforeMethod
	public void initTest() {
		auditorium = new Auditorium();
		auditorium.setName(AUDITORIUM_NAME);
		Set<Seat> seats = new HashSet<>();
		Set<Integer> vipNumbers = new HashSet<Integer>();
		for (int vsn : VIP_SEAT_NUMBERS) {
			vipNumbers.add(vsn);
		}
		for (int i = 0; i < SEAT_NUMBERS; i++) {
			Seat seat = new Seat();
			seat.setNumber(i);
			seat.setAuditorium(auditorium);
			if (vipNumbers.contains(seat.getNumber())) {
				seat.setSeatStatus(SeatStatus.VIP);
			} else {
				seat.setSeatStatus(SeatStatus.BASE);
			}
			seats.add(seat);
		}
		auditorium.setSeats(seats);

		Event event = new Event();
		event.setName(EVENT_NAME);
		event.setDate(EVENT_DATE);
		event.setBasePrice(EVENT_PRICE);
		event.setAuditorium(auditorium);
		event.setRating(EventRating.MID);
		Set<Event> events = new HashSet<>();
		events.add(event);
		auditorium.setEvents(events);

		Ticket ticket = new Ticket();
		ticket.setEvent(event);
		User user = new User();
		user.setFirstName(FIRST_NAME);
		user.setLastName(LAST_NAME);
		user.setEmail(EMAIL);
		ticket.setUser(user);
		Seat seat1 = auditorium.getSeats().stream().findAny().get();
		ticket.setSeat(seat1);
		ticket.setDateTime(Date.valueOf(LocalDate.now()));
		Set<Ticket> tickets = new HashSet<>();
		tickets.add(ticket);

	}

	@Transactional
	@Rollback(true)
	@Test(groups = TestConstants.GROUP_AUDITORIUM_TEST, description = "Testing Auditorium save() and remove()")
	public void auditoriumServiceSaveTest() {
		auditoriumService.save(auditorium);
		Assert.assertTrue(!auditoriumService.getAll().isEmpty());
		Assert.assertEquals(true, auditoriumService.remove(auditorium));
	}

	@Transactional
	@Rollback(true)
	@Test(groups = TestConstants.GROUP_AUDITORIUM_TEST, description = "Testing Auditorium getById()")
	public void auditoriumServiceGetByIdTest() {
		auditoriumService.save(auditorium);
		Auditorium expectedAuditorium = auditoriumService.getAll().stream().findAny().get();
		Long id = expectedAuditorium.getId();
		Assert.assertTrue(id.equals(auditoriumService.getById(id).getId()));
	}

	@Transactional
	@Rollback(true)
	@Test(groups = TestConstants.GROUP_AUDITORIUM_TEST, description = "Testing Auditorium getByName()")
	public void getByNameAuditoriumTest() {
		auditoriumService.save(auditorium);
		Auditorium expectedAuditorium = auditoriumService.getAll().stream().findAny().get();
		String name = expectedAuditorium.getName();
		Assert.assertTrue(name.equals(auditoriumService.getByName(name).getName()));
	}

	@Transactional
	@Rollback(true)
	@Test(groups = TestConstants.GROUP_AUDITORIUM_TEST, description = "Testing Auditorium getByName()")
	public void getSetofVipSeatsInAuditoriumTest() {
		auditoriumService.save(auditorium);
		Set<Integer> expectedVipSeatsNumber = auditoriumService.getVipSeatNumbers(auditorium);
		Assert.assertTrue(Integer.valueOf(VIP_SEAT_NUMBERS.length).equals(expectedVipSeatsNumber.size()));
	}

}