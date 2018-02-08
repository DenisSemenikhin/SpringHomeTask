package com.epam.spring.hometask;

import com.epam.spring.hometask.domain.User;
import com.epam.spring.hometask.service.UserService;
import com.epam.spring.hometask.service.impl.UserServiceImpl;
import com.epam.spring.hometask.spring.config.PersistanceJPAConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.sql.Date;
import java.util.Calendar;

@ContextConfiguration(classes = { AppConfig.class, PersistanceJPAConfig.class}, loader = AnnotationConfigContextLoader.class)
public class App {

    @Autowired
    public static UserService userService;


    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);


        UserService userService = ctx.getBean(UserServiceImpl.class);


        System.out.println("Hello world");

        User user = new User();
        user.setEmail("helloworld@com.ru");
        user.setFirstName("Den");
        user.setLastName("Semenikhin");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1980, Calendar.MARCH, 8);
        user.setDateBirthday(new Date(calendar.getTime().getTime()));
        user.setRegistrationStatus(true);

        userService.save(user);

        System.out.println(userService.getUserByEmail("helloworld@com.ru"));


    }
}
