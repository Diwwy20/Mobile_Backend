package com.example.MINIProject.user.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.MINIProject.user.json.RevenueListJson;
import com.example.MINIProject.user.model.MoneyType;
import com.example.MINIProject.user.model.Revenue;
import com.example.MINIProject.user.payload.RevenuePayload;
import com.example.MINIProject.user.service.RevenueService;

@Service
public class RevenueBusiness {

	@Autowired
	RevenueService revenueService;
	
	public List<RevenueListJson> getListRevenues(){
		return RevenueListJson.packJsons(revenueService.getAllRevenues());
	}
	
	public RevenueListJson getRevenueTypeId(long id) {
		return RevenueListJson.packJson(revenueService.findById(id));
	}
	
	public List<RevenueListJson> getRevenuesByUserId(long userId){
		return RevenueListJson.packJsons(revenueService.getRevenuesByUserId(userId));
	}
	
	public List<RevenueListJson> getMoneyTypeByUserId(long userId, MoneyType moneyType){
		return RevenueListJson.packJsons(revenueService.getMoneyTypeByUserId(userId, moneyType));
	}
	
	public void saveRevenue(RevenuePayload rpl) {
		Revenue revenue = new Revenue(rpl.getRName(), rpl.getRMoney(), rpl.getMoneyType(), rpl.getUser());
		revenueService.save(revenue);
	}
	
	public void updateRevenue(long id, RevenuePayload payload) {
		Revenue revenueData = revenueService.findById(id);
		revenueData.setRName(payload.getRName());
		revenueData.setRMoney(payload.getRMoney());
		revenueData.setMoneyType(payload.getMoneyType());
		revenueData.setCreatedAt(payload.getCreatedAt());
		revenueData.setUser(payload.getUser());
		revenueService.save(revenueData);
	}
	
	public void deleteRevenue(long id) {
		revenueService.deleteById(id);
	}
}
