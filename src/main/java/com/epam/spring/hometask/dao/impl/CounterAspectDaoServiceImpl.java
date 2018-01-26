package com.epam.spring.hometask.dao.impl;

import com.epam.spring.hometask.dao.CounterAspectDaoService;
import com.epam.spring.hometask.domain.Event;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CounterAspectDaoServiceImpl implements CounterAspectDaoService {

	private static Map<String, Long> queriesAccesToEventByName = new HashMap<String, Long>();

	private static Map<String, Long> queriesPriceOfEvent = new HashMap<String, Long>();

	private static Map<String, Long> queriesBookingOfTicket = new HashMap<String, Long>();

	@Override
	public void saveEventByNameCall(Event event){
	    String  eventName = event.getName();
        saveObjInMapWithCounter(eventName, queriesAccesToEventByName);
	}

	@Override
	public void savePriceOfEventCall(Event event) {
        String eventName = event.getName();
        saveObjInMapWithCounter(eventName, queriesPriceOfEvent);

	}

	@Override
	public void saveBookingOfTicketCall(Event event) {
        String eventName = event.getName();
        saveObjInMapWithCounter(eventName, queriesBookingOfTicket);
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
