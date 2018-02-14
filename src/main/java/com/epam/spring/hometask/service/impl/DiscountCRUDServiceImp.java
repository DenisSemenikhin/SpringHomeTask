package com.epam.spring.hometask.service.impl;

import java.util.Collection;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.spring.hometask.dao.DiscountDaoService;
import com.epam.spring.hometask.domain.Discount;
import com.epam.spring.hometask.service.DiscountCRUDService;

@Service
public class DiscountCRUDServiceImp implements DiscountCRUDService {

	@Autowired
	DiscountDaoService discountDaoService;

	@Override
	public Discount save(Discount discount) {
		return discountDaoService.save(discount);
	}

	@Override
	public boolean remove(Discount discount) {
		return discountDaoService.remove(discount);
	}

	@Override
	public Discount getById(Long id) {
		return discountDaoService.getById(id);
	}

	@Override
	public Collection<Discount> getAll() {
		return discountDaoService.getAll();
	}

	@Nullable
	@Override
	public Discount getByName(@Nonnull String name) {
		return discountDaoService.getAll().stream().filter(dc -> dc.getDiscountName().equals(name)).findFirst().get();
	}

}
