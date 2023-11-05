package com.example.MINIProject.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MINIProject.user.model.MoneyType;
import com.example.MINIProject.user.repository.MoneyTypeRepository;
import com.example.MINIProject.user.service.impl.IMoneyType;

@Service
public class MoneyTypeService implements IMoneyType{
	
	@Autowired
	MoneyTypeRepository moneyTypeRepository;

	@Override
	public List<MoneyType> getAllMoneyTypes() {
		// TODO Auto-generated method stub
		return moneyTypeRepository.findAll();
	}

	@Override
	public MoneyType findById(long id) {
		// TODO Auto-generated method stub
		return moneyTypeRepository.findById(id);
	}

	@Override
	public MoneyType findByMoneyTypeName(String moneyTypeName) {
		// TODO Auto-generated method stub
		return moneyTypeRepository.findByMoneyName(moneyTypeName);
	}

	@Override
	public MoneyType save(MoneyType moneyType) {
		// TODO Auto-generated method stub
		return moneyTypeRepository.save(moneyType);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		moneyTypeRepository.deleteById(id);
	}
	
	public Optional<MoneyType> findOptionalById(long id){
		return moneyTypeRepository.findOptionalById(id);
	}
}
