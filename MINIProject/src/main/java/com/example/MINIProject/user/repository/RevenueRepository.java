package com.example.MINIProject.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.MINIProject.user.model.MoneyType;
import com.example.MINIProject.user.model.Revenue;

public interface RevenueRepository extends JpaRepository<Revenue, Long>{
	Revenue findById(long id);
	Revenue findByMoneyTypeId(long id);
	List<Revenue> findByUserId(long id);
	Optional<Revenue> findOptionalById(long id);
	
	// สร้างคำสั่งค้นหาด้วย JPQL
    @Query("SELECT r FROM Revenue r WHERE r.user.id = :userId AND r.moneyType = :moneyType")
    List<Revenue> findMoneyTypeByUserId(@Param("userId") long userId, @Param("moneyType") MoneyType moneyType);
}
