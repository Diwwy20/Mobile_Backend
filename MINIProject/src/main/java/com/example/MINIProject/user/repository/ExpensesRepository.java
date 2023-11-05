package com.example.MINIProject.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.MINIProject.user.model.Expenses;
import com.example.MINIProject.user.model.MoneyType;

public interface ExpensesRepository extends JpaRepository<Expenses, Long>{
	Expenses findById(long id);
	Expenses findByMoneyTypeId(long id);
//	Expenses findByCategoriesId(long id);
	List<Expenses> findByUserId(long id);
	Optional<Expenses> findOptionalById(long id);
	

    @Query("SELECT e FROM Expenses e WHERE e.user.id = :userId AND e.moneyType = :moneyType")
    List<Expenses> findMoneyTypeByUserId(@Param("userId") long userId, @Param("moneyType") MoneyType moneyType);
    
}
