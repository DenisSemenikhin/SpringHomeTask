package com.epam.spring.hometask.dao.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.epam.spring.hometask.dao.DiscountDaoService;
import com.epam.spring.hometask.dao.repository.DaoDiscountRepository;
import com.epam.spring.hometask.domain.Discount;

@Repository
public class DiscountDaoServiceImpl implements DiscountDaoService {

	@Autowired
	@Qualifier("DaoDiscountRepository")
	DaoDiscountRepository<Discount, Long> daoDiscountRepository;

	@Override
	public Discount save(Discount discount) {
		return daoDiscountRepository.save(discount);
	}

	@Override
	public boolean remove(Discount discount) {
		daoDiscountRepository.delete(discount);
		return !daoDiscountRepository.existsById(discount.getId());
	}

	@Override
	public Discount getById(Long id) {
		return daoDiscountRepository.findAll().stream().filter(dc -> dc.getId().equals(id)).findFirst().get();
	}

	@Override
	public Collection<Discount> getAll() {
		return daoDiscountRepository.findAll();
	}

}
