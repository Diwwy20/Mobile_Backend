package com.example.MINIProject.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MINIProject.user.model.Expenses;
import com.example.MINIProject.user.model.MoneyType;
import com.example.MINIProject.user.repository.ExpensesRepository;
import com.example.MINIProject.user.service.impl.IExpenses;

@Service
public class ExpensesService implements IExpenses{
	
	@Autowired
	ExpensesRepository expensesRepository;

	@Override
	public List<Expenses> getAllExpenses() {
		// TODO Auto-generated method stub
		return expensesRepository.findAll();
	}

	@Override
	public Expenses findById(long id) {
		// TODO Auto-generated method stub
		return expensesRepository.findById(id);
	}

	@Override
	public Expenses findByMoneyTypeId(long id) {
		// TODO Auto-generated method stub
		return expensesRepository.findByMoneyTypeId(id);
	}

	@Override
	public List<Expenses> getExpensesByUserId(long userId) {
		// TODO Auto-generated method stub
		return expensesRepository.findByUserId(userId);
	}

	@Override
	public List<Expenses> getMoneyTypeByUserId(long id, MoneyType moneyType) {
		// TODO Auto-generated method stub
		return expensesRepository.findMoneyTypeByUserId(id, moneyType);
	}

//	@Override
//	public List<Expenses> getExpensesByUserIdAndCategory(long id, Categories category) {
//		// TODO Auto-generated method stub
//		return expensesRepository.findExpensesByCategoryId(id, category);
//	}

	@Override
	public Expenses save(Expenses expenses) {
		// TODO Auto-generated method stub
		return expensesRepository.save(expenses);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		expensesRepository.deleteById(id);
	}
	
	public Optional<Expenses> findOptionalById(long id){
		return expensesRepository.findOptionalById(id);
	}

}
