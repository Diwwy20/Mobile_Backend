package com.example.MINIProject.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MINIProject.user.model.MoneyType;

public interface MoneyTypeRepository extends JpaRepository<MoneyType, Long>{
	MoneyType findById(long id);
	MoneyType findByMoneyName(String moneyName);
	Optional<MoneyType> findOptionalById(long id); 
}
