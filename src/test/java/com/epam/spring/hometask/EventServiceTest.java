package com.epam.spring.hometask;


import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.EventRating;
import com.epam.spring.hometask.service.EventService;
import com.epam.spring.hometask.spring.config.AppTestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@ContextConfiguration(classes = { AppTestConfig.class }, loader = AnnotationConfigContextLoader.class)
public class EventServiceTest extends AbstractTestNGSpringContextTests {

    private static final String EVENT_NAME = "NewYear";
    private static final EventRating EVENT_RATING = EventRating.HIGH;
    private static final double EVENT_BASE_PRICE = 150.5;
    private static final LocalDateTime DATE_TIME = LocalDateTime.of(2017, 2, 3, 18, 30);

    @Autowired
    private EventService eventService;

    private Event event;

    @BeforeMethod
    public void initTest() {
        event = new Event();
        event.setName(EVENT_NAME);
        event.setRating(EVENT_RATING);
        event.setBasePrice(EVENT_BASE_PRICE);
        event.setDate(Date.valueOf(DATE_TIME.toLocalDate()));
        event.setAuditorium(null);
    }

    @Transactional
    @Rollback(false)
    @Test(groups = TestConstants.GROUP_EVENT_TEST, description = "Testing Event Save, Remove and getByID")
    public void eventServiceSaveRemoveandGetByIDTest() {
        eventService.save(event);
        Assert.assertTrue(!eventService.getAll().isEmpty());
        Event expectedEvent = eventService.getAll().stream().findAny().get();
        Long Id = expectedEvent.getId();
        Assert.assertTrue(expectedEvent.equals(eventService.getById(Id)));
        Assert.assertEquals(true, eventService.remove(event));
    }

    @Transactional
    @Rollback(true)
    @Test(groups = TestConstants.GROUP_EVENT_TEST, description = "Testing GetForDateRange")
    public void eventServiceGetForDateRangeTest() {
        eventService.save(event);
        Set<Event> expectedEvents = eventService.getForDateRange(LocalDate.from(DATE_TIME.minusDays(3)),
                LocalDate.from(DATE_TIME.plusDays(3)));
        Assert.assertTrue(expectedEvents.size() == 1);
        expectedEvents = eventService.getForDateRange(LocalDate.from(DATE_TIME.minusDays(6)),
                LocalDate.from(DATE_TIME.minusDays(2)));
        Assert.assertTrue(expectedEvents.isEmpty());
        expectedEvents = eventService.getForDateRange(LocalDate.from(DATE_TIME.plusDays(1)),
                LocalDate.from(DATE_TIME.plusDays(2)));
        Assert.assertTrue(expectedEvents.isEmpty());
    }

    @Transactional
    @Rollback(true)
    @Test(groups = TestConstants.GROUP_EVENT_TEST, description = "Testing GetForDateRange")
    public void eventServiceGetNextEventsTest() {
        eventService.save(event);
        Set<Event> expectedEvents = eventService.getNextEvents(LocalDateTime.from(DATE_TIME.minusDays(3)));
        Assert.assertTrue(expectedEvents.size() == 1);
        expectedEvents = eventService.getNextEvents(LocalDateTime.from(DATE_TIME.plusDays(3)));
        Assert.assertTrue(expectedEvents.isEmpty());
    }


}
