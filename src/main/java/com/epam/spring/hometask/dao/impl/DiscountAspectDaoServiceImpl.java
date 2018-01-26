package com.epam.spring.hometask.dao.impl;

import com.epam.spring.hometask.dao.DiscountAspectDaoService;
import com.epam.spring.hometask.domain.Discount;
import com.epam.spring.hometask.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public class DiscountAspectDaoServiceImpl implements DiscountAspectDaoService{

    private static Map<String, Long> discountGivesInfo = new HashMap<String, Long>();

    private static Map<Long, Map<String, Long>> discountByUserGivesInfo = new HashMap<Long, Map<String, Long>>();

    @Override
    public void saveDiscountGives(Discount discount) {
        String discountName = discount.getDiscountName();
        saveObjInMapWithCounter(discountName, discountGivesInfo);
    }

    @Override
    public void saveDiscountByUserGives(User user, Discount discount) {
        Long userID = user.getId();
        String discountName = discount.getDiscountName();
        if (discountByUserGivesInfo.containsKey(userID)){
            Map<String, Long> userDiscountMap = discountByUserGivesInfo.get(userID);
            saveObjInMapWithCounter(discountName, userDiscountMap);
        } else {
            Map<String, Long> userDiscountMap = new HashMap<String, Long>();
            saveObjInMapWithCounter(discountName, userDiscountMap);
            discountByUserGivesInfo.put(userID, userDiscountMap);
        }
    }

    private void saveObjInMapWithCounter(String objName, Map map){
        if (map.containsKey(objName)){
            long count = (Long) map.get(objName) + 1;
            map.replace(objName, count);
        } else {
            map.put(objName, 1l);
        }
    }
}
