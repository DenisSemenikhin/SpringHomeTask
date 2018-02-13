package com.epam.spring.hometask.service;

import com.epam.spring.hometask.domain.Auditorium;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;

/**
 * @author Yuriy_Tkach
 */

public interface AuditoriumService extends AbstractDomainObjectService<Auditorium> {

	public @Nullable Auditorium getByName(@Nonnull String name);

	public Set<Integer> getVipSeatNumbers(Auditorium auditorium);
}


