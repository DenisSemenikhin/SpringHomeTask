package com.epam.spring.hometask;

import com.epam.spring.hometask.domain.User;
import com.epam.spring.hometask.service.UserService;
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

@ContextConfiguration(classes = { AppTestConfig.class }, loader = AnnotationConfigContextLoader.class)
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests {

	private static final String FIRST_NAME = "Den";
	private static final String LAST_NAME = "Semenikhin";
	private static final String EMAIL = "fromrussia@withlove.com";

	@Autowired
	UserService userService;
	private User user;

	@BeforeMethod
	public void initTest() {
		user = new User();
		user.setFirstName(FIRST_NAME);
		user.setLastName(LAST_NAME);
		user.setEmail(EMAIL);

	}

	@Transactional
	@Rollback(true)
	@Test(groups = TestConstants.GROUP_USER_TEST, description = "Testing User save() and getByEmail(), remove()")
	public void userServiceSaveTest() {
		userService.save(user);
		Assert.assertTrue(userService.getAll().size() == 1);
		Assert.assertEquals(user, userService.getUserByEmail(EMAIL));
		Assert.assertEquals(true,userService.remove(user));
		Assert.assertTrue(userService.getAll().size() == 0);
	}

	@Transactional
	@Rollback(true)
	@Test(groups = TestConstants.GROUP_USER_TEST, description = "Testing User getById()")
	public void userServiceGetByIdTest() {
		userService.save(user);
		User expectedUser = userService.getAll().stream().findAny().get();
		Long Id = expectedUser.getId();
		Assert.assertTrue(expectedUser.equals(userService.getById(Id)));
	}


}
