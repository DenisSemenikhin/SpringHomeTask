package com.epam.spring.hometask;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.spring.hometask.discount.impl.BirthdayDiscount;
import com.epam.spring.hometask.discount.impl.LuckyTicketDiscount;
import com.epam.spring.hometask.domain.Discount;
import com.epam.spring.hometask.domain.User;
import com.epam.spring.hometask.service.DiscountCRUDService;
import com.epam.spring.hometask.service.impl.UserServiceImpl;
import com.epam.spring.hometask.spring.config.AppTestConfig;

@ContextConfiguration(classes = { AppTestConfig.class }, loader = AnnotationConfigContextLoader.class)
public class DiscountServiceTest extends AbstractTestNGSpringContextTests {

	private static final String FIRST_NAME = "Den";
	private static final String LAST_NAME = "Semenikhin";
	private static final String EMAIL = "fromrussia@withlove.com";
	private static final Date USER_BIRTH_DATE = Date.valueOf("2000-01-01");

	private static final String DISCOUNT_TEST_NAME = "Test_Discount";
	private static final int DISCOUNT_VALUE = 50;
	private static final String DISCOUNT_LUCKY_TEST_NAME = "Lucky Discount";
	private static final String DISCOUNT_BIRTHDAY_TEST_NAME = "Birthtday Discount";
	private static final int BIRTHDAY_DISCOUNT_VALUE = 5;

	@Autowired
	private DiscountCRUDService discountCRUDService;

	@Autowired
	private UserServiceImpl userServiceImpl;

	private Discount discount;
	private Discount luckyDiscount;
	private Discount birthdayDiscount;
	private User user;

	@BeforeMethod
	public void initTest() {
		discount = new Discount();
		discount.setDiscountName(DISCOUNT_TEST_NAME);
		discount.setDiscountValue(DISCOUNT_VALUE);

		luckyDiscount = new Discount();
		luckyDiscount.setDiscountName(DISCOUNT_LUCKY_TEST_NAME);
		luckyDiscount.setDiscountValue(DISCOUNT_VALUE);

		birthdayDiscount = new Discount();
		birthdayDiscount.setDiscountName(DISCOUNT_BIRTHDAY_TEST_NAME);
		birthdayDiscount.setDiscountValue(BIRTHDAY_DISCOUNT_VALUE);

		user = new User();
		user.setFirstName(FIRST_NAME);
		user.setLastName(LAST_NAME);
		user.setEmail(EMAIL);
		user.setDateBirthday(USER_BIRTH_DATE);
		user.setRegistrationStatus(true);
		userServiceImpl.save(user);

	}

	@Transactional
	@Rollback(false)
	@Test(groups = TestConstants.GROUP_DISCOUNT_TEST, description = "Testing Discount Save, Remove and getByID")
	public void discountServiceSaveRemoveandGetByIDTest() {
		discountCRUDService.save(discount);
		Assert.assertTrue(!discountCRUDService.getAll().isEmpty());
		Discount expectedDiscount = discountCRUDService.getAll().stream().findAny().get();
		Long Id = expectedDiscount.getId();
		Assert.assertTrue(expectedDiscount.equals(discountCRUDService.getById(Id)));
		Assert.assertEquals(true, discountCRUDService.remove(discount));
	}

	@Transactional
	@Rollback(true)
	@Test(groups = TestConstants.GROUP_DISCOUNT_TEST, description = "Testing Discount getByName()")
	public void getByNameDiscountTest() {
		discountCRUDService.save(discount);
		Discount expectedDiscount = discountCRUDService.getAll().stream().findAny().get();
		String name = expectedDiscount.getDiscountName();
		Assert.assertTrue(expectedDiscount.equals(discountCRUDService.getByName(name)));
	}

	@Transactional
	@Rollback(true)
	@Test(groups = TestConstants.GROUP_DISCOUNT_TEST, description = "Testing LuckyDiscount()")
	public void getLuckyDiscountForEachTenthTicketTest() {
		LocalDateTime airDateTime = LocalDateTime.of(USER_BIRTH_DATE.toLocalDate(), LocalTime.now());
		discountCRUDService.save(luckyDiscount);
		LuckyTicketDiscount luckyTicketDiscount = new LuckyTicketDiscount(
				discountCRUDService.getByName(DISCOUNT_LUCKY_TEST_NAME), 10);
		User testedUser = userServiceImpl.getById(user.getId());
		Discount expectedDiscount = luckyTicketDiscount.getDiscount(testedUser, airDateTime, 20);
		Assert.assertEquals(DISCOUNT_VALUE, expectedDiscount.getDiscountValue());
		expectedDiscount = luckyTicketDiscount.getDiscount(testedUser, airDateTime, 19);
		Assert.assertEquals(0, expectedDiscount.getDiscountValue());
	}

	@Transactional
	@Rollback(true)
	@Test(groups = TestConstants.GROUP_DISCOUNT_TEST, description = "Testing BirthdayDiscount()")
	public void getBirthdayDiscountTest() {
		discountCRUDService.save(birthdayDiscount);
		BirthdayDiscount testedBirthdayDiscount = new BirthdayDiscount(
				discountCRUDService.getById(birthdayDiscount.getId()));
		User testedUser = userServiceImpl.getById(user.getId());
		LocalDateTime airDateTime = LocalDateTime.of(USER_BIRTH_DATE.toLocalDate(), LocalTime.now());
		airDateTime = airDateTime.withYear(LocalDate.now().getYear());
		Discount expectedDiscount = testedBirthdayDiscount.getDiscount(testedUser, airDateTime.minusDays(2), 20);
		Assert.assertEquals(BIRTHDAY_DISCOUNT_VALUE, expectedDiscount.getDiscountValue());
		expectedDiscount = testedBirthdayDiscount.getDiscount(testedUser, airDateTime.minusDays(6), 20);
		Assert.assertEquals(0, expectedDiscount.getDiscountValue());
		expectedDiscount = testedBirthdayDiscount.getDiscount(testedUser, airDateTime.plusDays(2), 20);
		Assert.assertEquals(BIRTHDAY_DISCOUNT_VALUE, expectedDiscount.getDiscountValue());
		expectedDiscount = testedBirthdayDiscount.getDiscount(testedUser, airDateTime.plusDays(6), 20);
		Assert.assertEquals(0, expectedDiscount.getDiscountValue());
	}

}
