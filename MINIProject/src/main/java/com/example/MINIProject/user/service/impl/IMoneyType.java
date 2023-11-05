package com.example.MINIProject.user.service.impl;

import java.util.List;

import com.example.MINIProject.user.model.MoneyType;

public interface IMoneyType {
	List<MoneyType> getAllMoneyTypes();
	MoneyType findById(long id);
	MoneyType findByMoneyTypeName(String moneyTypeName);
	MoneyType save(MoneyType moneyType);
	void deleteById(long id);
}
