package com.epam.spring.hometask.spring.aspect;

/*
@Aspect
@Component
public class CounterAspect {

	private Event event;

	@Autowired
	private CounterAspectDaoService counterAspectDaoService;

	public void setCounterAspectDaoService(CounterAspectDaoService counterAspectDaoService) {
		this.counterAspectDaoService = counterAspectDaoService;
	}

	@Pointcut("execution(* com.epam.spring.hometask.dao.impl.EventDaoServiceImpl.getByName(..))")
	private void eventGetByNameCall() {
	}

	@AfterReturning(pointcut = "eventGetByNameCall()", returning = "event")
	public void saveEventGetByNameCall(JoinPoint jp, Object event) {
		this.event = (Event) event;
		counterAspectDaoService.saveEventByNameCall(this.event);

	}

	@Pointcut("execution(* com.epam.spring.hometask.service.impl.BookingServiceImpl.getTicketsPrice(..))")
	private void eventGetPriceCall() {
	}

	@After("eventGetPriceCall()")
	public void saveEventGetPriceCall(JoinPoint jp) {
		List<?> args = Arrays.asList(jp.getArgs());
		this.event = (Event) args.stream().filter(obj -> obj instanceof Event).findAny().get();
		counterAspectDaoService.savePriceOfEventCall(this.event);
	}

	@Pointcut("execution(* com.epam.spring.hometask.service.impl.BookingServiceImpl.bookTickets(..))")
	private void bookingOfTicketCall() {
	}

	@After("bookingOfTicketCall()")
	public void saveBookingOfTicketCall(JoinPoint jp) {
		List<?> args = Arrays.asList(jp.getArgs());
		Set<Ticket> tickets = (Set<Ticket>) args.stream().filter(arg -> arg instanceof Set).findAny().get();
		tickets.forEach(tk -> counterAspectDaoService.saveBookingOfTicketCall(tk.getEvent()));
	}






}
*/