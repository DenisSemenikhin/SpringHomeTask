package com.epam.spring.hometask.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("DaoDiscountRepository")
public interface DaoDiscountRepository<Discount, Long>
		extends JpaRepository<com.epam.spring.hometask.domain.Discount, Long> {

}
