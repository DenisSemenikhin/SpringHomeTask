package com.epam.spring.hometask.dao.impl;


import com.epam.spring.hometask.dao.DaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;


public class DaoRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements DaoRepository<T, ID> {



    @Autowired
    private EntityManager entityManager;




    // There are two constructors to choose from, either can be used.
    public DaoRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }




}



