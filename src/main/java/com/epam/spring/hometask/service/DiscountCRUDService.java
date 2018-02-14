package com.epam.spring.hometask.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.epam.spring.hometask.domain.Discount;

public interface DiscountCRUDService extends AbstractDomainObjectService<Discount> {

	public @Nullable Discount getByName(@Nonnull String name);

}
