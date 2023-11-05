package com.example.MINIProject.user.service.impl;

import java.util.List;

import com.example.MINIProject.user.model.Expenses;
import com.example.MINIProject.user.model.MoneyType;

public interface IExpenses {
	
	List<Expenses> getAllExpenses();
	Expenses findById(long id);
	Expenses findByMoneyTypeId(long id);
	List<Expenses> getExpensesByUserId(long id);
	List<Expenses> getMoneyTypeByUserId(long id, MoneyType moneyType);
//	List<Expenses> getExpensesByUserIdAndCategory(long id, Categories category);
	Expenses save(Expenses expenses);
	void deleteById(long id);
}
