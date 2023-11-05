package com.example.MINIProject.user.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MINIProject.user.json.MoneyTypeListJson;
import com.example.MINIProject.user.model.MoneyType;
import com.example.MINIProject.user.payload.MoneyTypePayload;
import com.example.MINIProject.user.service.MoneyTypeService;

@Service
public class MoneyTypeBusiness {

	@Autowired
	MoneyTypeService moneyTypeService;
	
	
	public List<MoneyTypeListJson> getListMoneyTypes(){
		return MoneyTypeListJson.packJsons(moneyTypeService.getAllMoneyTypes());
	}
	
	public MoneyTypeListJson getMoneyTypeId(long id) {
		return MoneyTypeListJson.packJson(moneyTypeService.findById(id));
	}
	
	public void saveMoneyType(MoneyTypePayload mtpl) {
		MoneyType moneyType = new MoneyType(mtpl.getMoneyName());
		moneyTypeService.save(moneyType);
	}
	
	public void updateMoneyType(long id, MoneyTypePayload payload) {
		MoneyType moneyTypeData = moneyTypeService.findById(id);
		moneyTypeData.setMoneyName(payload.getMoneyName());
		moneyTypeService.save(moneyTypeData);
	}
	
	public void deleteMoneyType(long id) {
		moneyTypeService.deleteById(id);
	}
}
