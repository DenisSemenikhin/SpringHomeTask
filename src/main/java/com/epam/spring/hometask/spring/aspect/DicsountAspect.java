package com.epam.spring.hometask.spring.aspect;

import com.epam.spring.hometask.dao.DiscountAspectDaoService;
import com.epam.spring.hometask.domain.Discount;
import com.epam.spring.hometask.domain.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class DicsountAspect {


    @Autowired
    DiscountAspectDaoService discountAspectDaoService;

    public void setDiscountAspectDaoService(DiscountAspectDaoService discountAspectDaoService) {
        this.discountAspectDaoService = discountAspectDaoService;
    }

    @Pointcut("execution(* com.epam.spring.hometask.service.impl.DiscountServiceImpl.getDiscount(..))")
    private void getDiscountCall() {
    }

    @AfterReturning(pointcut = "getDiscountCall()", returning = "discount")
    public void saveDiscountCall(JoinPoint jp, Object discount) {
        Discount rDiscount = (Discount) discount;
        if (rDiscount.getDiscountValue() != 0) {
            discountAspectDaoService.saveDiscountGives(rDiscount);
        }
    }

    @AfterReturning(pointcut = "getDiscountCall()", returning = "discount")
    public void saveDiscountCallByUser(JoinPoint jp, Object discount) {
        Discount rDiscount = (Discount) discount;
        List<?> args = Arrays.asList(jp.getArgs());
        User user = (User) args.stream().filter(obj -> obj instanceof User).findAny().get();
            discountAspectDaoService.saveDiscountByUserGives(user, rDiscount);
        }
    }



