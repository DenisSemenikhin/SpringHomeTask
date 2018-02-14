package com.epam.spring.hometask.dao;

import org.springframework.data.repository.NoRepositoryBean;

import com.epam.spring.hometask.domain.Discount;

@NoRepositoryBean
public interface DiscountDaoService extends AbstractDomainObjectDaoService<Discount> {

}
