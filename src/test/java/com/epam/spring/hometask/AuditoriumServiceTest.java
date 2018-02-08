package com.epam.spring.hometask;

/*
@ContextConfiguration(classes = { AppConfig.class }, loader = AnnotationConfigContextLoader.class)
public class AuditoriumServiceTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private AuditoriumService auditoriumService;

	// expected bunch of auditorium
	private Collection<Auditorium> expectedBunchOfAuditoriums;

	// expected auditorium
	private Auditorium firstAuditorium;
	private Auditorium secondAuditorium;

	// expected attribute of small auditorium
	private final static String NAME_OF_FIRST_AUDITORIUM = "Monro";
	private final static int NUMBER_OF_SEATS_FIRST_AUDITORIUM = 100;
	private final static String VIP_SEATS_OF_FIRST_AUDITORIUM = "1,2,3,4,5,6,7";

	// expected attribute of large auditorium
	private final static String NAME_OF_SECOND_AUDITORIUM = "Shalapin";
	private final static int NUMBER_OF_SEATS_SECOND_AUDITORIUM = 120;
	private final static String VIP_SEATS_OF_SECOND_AUDITORIUM = "1,2,3,4,5,6,7,8,9,10";

	@BeforeClass
	public void initAuditoriumsTest() {
		firstAuditorium = new Auditorium();
		firstAuditorium.setName(NAME_OF_FIRST_AUDITORIUM);
		firstAuditorium.setNumberOfSeats(NUMBER_OF_SEATS_FIRST_AUDITORIUM);
		firstAuditorium.setVipSeats(getVipSeats(VIP_SEATS_OF_FIRST_AUDITORIUM));

		secondAuditorium = new Auditorium();
		secondAuditorium.setName(NAME_OF_SECOND_AUDITORIUM);
		secondAuditorium.setNumberOfSeats(NUMBER_OF_SEATS_SECOND_AUDITORIUM);
		secondAuditorium.setVipSeats(getVipSeats(VIP_SEATS_OF_SECOND_AUDITORIUM));
	}

	@BeforeClass(dependsOnMethods = "initAuditoriumsTest")
	public void initBunchOfAuditoriumsTest() {
		expectedBunchOfAuditoriums = new ArrayList<>();
		expectedBunchOfAuditoriums.add(firstAuditorium);
		expectedBunchOfAuditoriums.add(secondAuditorium);
	}

	@Test(description = "getAll()")
	public void getAllAuditoriumTest() {
		Collection<Auditorium> bunchOfAuditorium = auditoriumService.getAll();
		Assert.assertTrue(bunchOfAuditorium.size() == expectedBunchOfAuditoriums.size());
	}

	@Test(description = "getByName()")
	public void getByName() {
		Auditorium auditoriumFirstActual = auditoriumService.getByName(NAME_OF_FIRST_AUDITORIUM);
		Auditorium auditoriumSecondActual = auditoriumService.getByName(NAME_OF_SECOND_AUDITORIUM);
		Assert.assertEquals(auditoriumFirstActual, firstAuditorium);
		Assert.assertEquals(auditoriumSecondActual, secondAuditorium);
	}

	private Set<Long> getVipSeats(String vipSeatsOfFirstAuditorium) {
		Set<Long> bunchOfVipSeats = new HashSet<>();
		List<String> vipSeats = Arrays.asList(vipSeatsOfFirstAuditorium.split(","));
		for (String vipSeat : vipSeats) {
			bunchOfVipSeats.add(Long.valueOf(vipSeat.trim()));
		}
		return bunchOfVipSeats;
	}

}
*/