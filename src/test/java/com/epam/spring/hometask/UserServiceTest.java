package com.epam.spring.hometask;

import com.epam.spring.hometask.domain.User;
import com.epam.spring.hometask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@ContextConfiguration(classes = { AppConfig.class }, loader = AnnotationConfigContextLoader.class)
public class UserServiceTest extends AbstractTestNGSpringContextTests {

	private static final Long ID = 1l;
	private static final String FIRST_NAME = "Den";
	private static final String LAST_NAME = "Semenikhin";
	private static final String EMAIL = "fromrussia@withlove.com";

	@Autowired
	private UserService userService;
	private User user;

	@BeforeClass
	public void initTest() {
		user = new User();
		user.setId(ID);
		user.setFirstName(FIRST_NAME);
		user.setLastName(LAST_NAME);
		user.setEmail(EMAIL);
	}

	@Test(groups = TestConstants.GROUP_USER_TEST, description = "Testing User save() and getById(), remove()")
	public void userServiceSaveTest() {
		userService.save(user);

		Assert.assertTrue(userService.getAll().size() == 1);
		Assert.assertEquals(user, userService.getById(ID));
		userService.remove(user);
		Assert.assertTrue(userService.getAll().size() == 0);
	}

}
