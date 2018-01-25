package com.epam.spring.hometask.service.impl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.epam.spring.hometask.domain.Auditorium;
import com.epam.spring.hometask.service.AuditoriumService;

@Service
public class AuditoriumServiceImpl implements AuditoriumService {

	@Resource(name = "bunchOfAuditoriums")
	private Map<String, Auditorium> auditoriums;

	public Map<String, Auditorium> getAuditoriums() {
		return auditoriums;
	}

	public void setAuditoriums(Map<String, Auditorium> auditoriums) {
		this.auditoriums = auditoriums;
	}

	@Override
	public Set<Auditorium> getAll() {
		return new HashSet<Auditorium>(auditoriums.values());
	}

	@Override
	public Auditorium getByName(String auditoriumName) {
		return auditoriums.get(auditoriumName);
	}

}
