package com.epam.spring.hometask.service.impl;


import com.epam.spring.hometask.dao.AuditoriumDaoService;
import com.epam.spring.hometask.domain.Auditorium;
import com.epam.spring.hometask.domain.Seat;
import com.epam.spring.hometask.domain.SeatStatus;
import com.epam.spring.hometask.service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuditoriumServiceImpl implements AuditoriumService {


    @Autowired
    private AuditoriumDaoService auditoriumDaoService;

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        return auditoriumDaoService.getAll().stream()
                .filter(au -> au.getName().equals(name)).findFirst().get();
    }

    @Override
    public Set<Integer> getVipSeatNumbers(Auditorium auditorium) {
        return auditoriumDaoService.getById(auditorium.getId()).getSeats()
                .stream().filter(seat -> seat.getSeatStatus().equals(SeatStatus.VIP))
                .map(Seat::getNumber)
                .collect(Collectors.toSet());
    }

    @Override
    public Auditorium save(@Nonnull Auditorium auditorium) {
        return auditoriumDaoService.save(auditorium);
    }

    @Override
    public boolean remove(@Nonnull Auditorium auditorium) {
        return auditoriumDaoService.remove(auditorium);
    }

    @Override
    public Auditorium getById(@Nonnull Long id) {
        return auditoriumDaoService.getById(id);
    }

    @Nonnull
    @Override
    public Collection<Auditorium> getAll() {
        return auditoriumDaoService.getAll();
    }
}