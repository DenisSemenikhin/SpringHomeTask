package com.epam.spring.hometask.dao;

import com.epam.spring.hometask.domain.Discount;
import com.epam.spring.hometask.domain.User;

public interface DiscountAspectDaoService {

    void saveDiscountGives(Discount discount);

    void saveDiscountByUserGives(User user, Discount discount);



}
