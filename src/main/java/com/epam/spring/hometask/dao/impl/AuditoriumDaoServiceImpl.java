package com.epam.spring.hometask.dao.impl;


import com.epam.spring.hometask.dao.AuditoriumDaoService;
import com.epam.spring.hometask.dao.repository.DaoAuditoriumRepository;
import com.epam.spring.hometask.domain.Auditorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Nonnull;
import java.util.Collection;

public class AuditoriumDaoServiceImpl implements AuditoriumDaoService {

    @Autowired
    @Qualifier("DaoAuditoriumRepository")
    private DaoAuditoriumRepository<Auditorium,Long> daoAuditoriumRepository;


    @Override
    public Auditorium save(@Nonnull Auditorium auditorium) {
        return daoAuditoriumRepository.save(auditorium);
    }

    @Override
    public boolean remove(@Nonnull Auditorium auditorium) {
        daoAuditoriumRepository.delete(auditorium);
        return !daoAuditoriumRepository.existsById(auditorium.getId());
    }

    @Override
    public Auditorium getById(@Nonnull Long id) {
        return daoAuditoriumRepository.findAll()
                .stream().filter(au -> au.getId().equals(id)).findFirst().get();
    }

    @Nonnull
    @Override
    public Collection<Auditorium> getAll() {
        return daoAuditoriumRepository.findAll();
    }


}
