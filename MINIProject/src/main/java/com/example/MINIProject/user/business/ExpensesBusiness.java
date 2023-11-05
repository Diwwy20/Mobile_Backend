package com.example.MINIProject.user.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MINIProject.user.json.ExpensesListJson;
import com.example.MINIProject.user.model.Expenses;
import com.example.MINIProject.user.model.MoneyType;
import com.example.MINIProject.user.payload.ExpensesPayload;
import com.example.MINIProject.user.service.ExpensesService;

@Service
public class ExpensesBusiness {

	@Autowired
	ExpensesService expensesService;
	
	public List<ExpensesListJson> getListExpenses(){
		return ExpensesListJson.packJsons(expensesService.getAllExpenses());
	}
	
	public ExpensesListJson getExpensesTypeId(long id) {
		return ExpensesListJson.packJson(expensesService.findById(id));
	}
	
	public List<ExpensesListJson> getExpensesByUserId(long userId){
		return ExpensesListJson.packJsons(expensesService.getExpensesByUserId(userId));
	}
	
	public List<ExpensesListJson> getMoneyTypeByUserId(long userId, MoneyType moneyType){
		return ExpensesListJson.packJsons(expensesService.getMoneyTypeByUserId(userId, moneyType));
	}
	
//	public List<ExpensesListJson> getExpensesByUserIdAndCategory(long userId, Categories category){
//		return ExpensesListJson.packJsons(expensesService.getExpensesByUserIdAndCategory(userId, category));
//	}
	
	public void saveExpenses(ExpensesPayload epl) {
		Expenses expenses = new Expenses(epl.getEName(), epl.getEMoney(), epl.getMoneyType() ,epl.getUser());
		expensesService.save(expenses);
	}
	
	public void updateExpenses(long id, ExpensesPayload payload) {
		Expenses expensesData = expensesService.findById(id);
		expensesData.setEName(payload.getEName());
		expensesData.setEMoney(payload.getEMoney());
		expensesData.setMoneyType(payload.getMoneyType());
//		expensesData.setCategories(payload.getCategories());
		expensesData.setCreatedAt(payload.getCreatedAt());
		expensesData.setUser(payload.getUser());
		expensesService.save(expensesData);
	}
	
	public void deleteExpenses(long id) {
		expensesService.deleteById(id);
	}
}
