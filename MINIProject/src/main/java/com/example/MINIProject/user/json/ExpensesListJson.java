package com.example.MINIProject.user.json;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.MINIProject.user.model.Expenses;
import com.example.MINIProject.user.model.MoneyType;
import com.example.MINIProject.user.model.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ExpensesListJson {
	private long id;
	private String eName;
	private int eMoney;
	private MoneyType moneyType;
	private LocalDateTime createdAt;
	private User user;
	
	public static ExpensesListJson packJson(Expenses expenses) {
		ExpensesListJson eplj = new ExpensesListJson();
		eplj.setId(expenses.getId());
		
		User user = new User();
		user.setUserName(expenses.getUser().getUserName());
		user.setId(expenses.getUser().getId());
		user.setUName(expenses.getUser().getUName());
		user.setPassword(expenses.getUser().getPassword());
		eplj.setUser(user);
		
		eplj.setEName(expenses.getEName());
		eplj.setEMoney(expenses.getEMoney());
		eplj.setMoneyType(expenses.getMoneyType());
		eplj.setCreatedAt(expenses.getCreatedAt());		
		return eplj;
	}
	
	public static List<ExpensesListJson> packJsons(List<Expenses> expensess){
		List<ExpensesListJson> expensesListJson = new ArrayList<ExpensesListJson>();
		for (Expenses expenses : expensess) {
			expensesListJson.add(packJson(expenses));
		}
		return expensesListJson;
	}
}
