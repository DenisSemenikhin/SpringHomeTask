package com.epam.spring.hometask;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.spring.hometask.domain.Auditorium;
import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.EventRating;
import com.epam.spring.hometask.service.AuditoriumService;
import com.epam.spring.hometask.service.EventService;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class EventServiceTest extends AbstractTestNGSpringContextTests {

	private static final Long ID = 1l;
	private static final String EVENT_NAME = "NewYear";
	private static final EventRating EVENT_RATING = EventRating.HIGH;
	private static final double EVENT_BASE_PRICE = 150.5;
	private static final String NAME_OF_AUDITORIUM = "Monro";
	private static final LocalDateTime DATE_TIME = LocalDateTime.of(2017, 2, 3, 18, 30);

	@Autowired
	private EventService eventService;
	private Event event;
	private AuditoriumService auditoriumService;

	@BeforeClass
	public void initTest() {
		Auditorium auditorium = auditoriumService.getByName(NAME_OF_AUDITORIUM);
		event = new Event();
		event.setId(ID);
		event.setName(EVENT_NAME);
		event.setRating(EVENT_RATING);
		event.setBasePrice(EVENT_BASE_PRICE);
		event.addAirDateTime(DATE_TIME, auditorium);
	}

	@Test(groups = TestConstants.GROUP_EVENT_SAVE, description = "Testing Event getByName")
	public void eventServiceGetByNameTest() {
		eventService.save(event);
		Assert.assertEquals(event, eventService.getByName(EVENT_NAME));
	}

	@Test(groups = TestConstants.GROUP_EVENT_SAVE, description = "Testing Event Save, Remove and getByID")
	public void eventServiceSaveRemoveandGetByIDTest() {
		eventService.remove(event);
		Assert.assertTrue(eventService.getAll().size() == 0);
		eventService.save(event);
		Assert.assertTrue(eventService.getAll().size() == 1);
		Assert.assertEquals(event, eventService.getById(ID));
		eventService.remove(event);
		Assert.assertTrue(eventService.getAll().size() == 0);
	}
	/*
	 * @Test(groups = TestConstants.GROUP_EVENT_SAVE, description =
	 * "Testing GetForDateRange") public void eventServiceGetForDateRange() {
	 * 
	 * }
	 */
}
