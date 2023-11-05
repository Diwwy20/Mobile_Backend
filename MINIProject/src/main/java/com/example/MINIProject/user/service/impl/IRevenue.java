package com.example.MINIProject.user.service.impl;

import java.util.List;

import com.example.MINIProject.user.model.MoneyType;
import com.example.MINIProject.user.model.Revenue;

public interface IRevenue {
	List<Revenue> getAllRevenues();
	Revenue findById(long id);
	Revenue findByMoneyTypeId(long id);
	List<Revenue> getRevenuesByUserId(long id);
	List<Revenue> getMoneyTypeByUserId(long id, MoneyType moneyType);
	Revenue save(Revenue revenue);
	void deleteById(long id);
	
}
