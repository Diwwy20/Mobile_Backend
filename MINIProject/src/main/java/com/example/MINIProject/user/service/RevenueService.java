package com.example.MINIProject.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MINIProject.user.model.MoneyType;
import com.example.MINIProject.user.model.Revenue;
import com.example.MINIProject.user.repository.RevenueRepository;
import com.example.MINIProject.user.service.impl.IRevenue;

@Service
public class RevenueService implements IRevenue{
	
	@Autowired
	RevenueRepository revenueRepository;

	@Override
	public List<Revenue> getAllRevenues() {
		// TODO Auto-generated method stub
		return revenueRepository.findAll();
	}

	@Override
	public Revenue findById(long id) {
		// TODO Auto-generated method stub
		return revenueRepository.findById(id);
	}

	@Override
	public Revenue findByMoneyTypeId(long id) {
		// TODO Auto-generated method stub
		return revenueRepository.findByMoneyTypeId(id);
	}

	@Override
	public Revenue save(Revenue revenue) {
		// TODO Auto-generated method stub
		return revenueRepository.save(revenue);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		revenueRepository.deleteById(id);
	}
	
	public Optional<Revenue> findOptionalById(long id){
		return revenueRepository.findOptionalById(id);
	}

	@Override
	public List<Revenue> getRevenuesByUserId(long userId) {
		// TODO Auto-generated method stub
		return revenueRepository.findByUserId(userId);
	}

	@Override
	public List<Revenue> getMoneyTypeByUserId(long id, MoneyType moneyType) {
		// TODO Auto-generated method stub
		return revenueRepository.findMoneyTypeByUserId(id, moneyType);
	}
}
