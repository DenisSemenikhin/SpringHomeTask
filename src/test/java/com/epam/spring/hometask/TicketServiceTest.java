package com.epam.spring.hometask;

import com.epam.spring.hometask.domain.*;
import com.epam.spring.hometask.service.TicketService;
import com.epam.spring.hometask.spring.config.AppTestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@ContextConfiguration(classes = { AppTestConfig.class }, loader = AnnotationConfigContextLoader.class)
public class TicketServiceTest extends AbstractTransactionalTestNGSpringContextTests{

    private static final String FIRST_NAME = "Den";
    private static final String LAST_NAME = "Semenikhin";
    private static final String EMAIL = "fromrussia@withlove.com";
    private static final Integer SEAT_NUMBER = 1;
    private static final String AUDITORIUM_NAME = "TEST_EVENT";
    private static final String EVENT_NAME = "TEST_EVENT";
    private static final Date EVENT_DATE = Date.valueOf("2000-01-01");
    private static final Long EVENT_PRICE = 100l;

    @Autowired
    TicketService ticketService;
    private Ticket ticket;

    @BeforeMethod
    public void initTest() {
        User user = new User();
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setEmail(EMAIL);

        Seat seat = new Seat();
        seat.setNumber(SEAT_NUMBER);
        seat.setSeatStatus(SeatStatus.BASE);
        Set<Seat> seats = new HashSet<>();
        seats.add(seat);

        Auditorium auditorium = new Auditorium();
        auditorium.setName(AUDITORIUM_NAME);
        auditorium.setSeats(seats);

        Event event = new Event();
        event.setName(EVENT_NAME);
        event.setDate(EVENT_DATE);
        event.setBasePrice(EVENT_PRICE);
        event.setAuditorium(auditorium);
        event.setRating(EventRating.MID);

        ticket = new Ticket();
        ticket.setUser(user);
        ticket.setEvent(event);
        ticket.setSeat(seat);
        ticket.setDateTime(Date.valueOf(LocalDate.now()));

    }

    @Transactional
    @Rollback(true)
    @Test(groups = TestConstants.GROUP_TICKET_TEST, description = "Testing Ticket save() and remove()")
    public void ticketServiceSaveTest() {
        ticketService.save(ticket);
        Assert.assertTrue(ticketService.getAll().size() == 1);
        Assert.assertEquals(true, ticketService.remove(ticket));
        Assert.assertTrue(ticketService.getAll().size() == 0);
    }

    @Transactional
    @Rollback(true)
    @Test(groups = TestConstants.GROUP_TICKET_TEST, description = "Testing Ticket getById()")
    public void userServiceGetByIdTest () {
        ticketService.save(ticket);
        Ticket expectedTicked = ticketService.getAll().stream().findAny().get();
        Long Id = expectedTicked.getId();
        Assert.assertTrue(expectedTicked.equals(ticketService.getById(Id)));
    }

}


