package com.epam.spring.hometask.service;

import com.epam.spring.hometask.domain.Discount;
import com.epam.spring.hometask.domain.Event;
import com.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

/**
 * @author Yuriy_Tkach
 */
public interface DiscountService {

	/**
	 * Getting discount based on some rules for user that buys some number of
	 * tickets for the specific date time of the event
	 * 
	 * @param user
	 *            User that buys tickets. Can be <code>null</code>
	 * @param event
	 *            Event that tickets are bought for
	 * @param airDateTime
	 *            The date and time event will be aired
	 * @param numberOfTickets
	 *            Number of tickets that user buys
	 * @return discount obj
	 */
	Discount getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets);

}
