package com.example.MINIProject.user.json;

import java.util.ArrayList;
import java.util.List;

import com.example.MINIProject.user.model.MoneyType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MoneyTypeListJson {
	private long id;
	private String moneyName;
	
	public static MoneyTypeListJson packJson(MoneyType moneyType) {
		MoneyTypeListJson mtlj = new MoneyTypeListJson();
		mtlj.setId(moneyType.getId());
		mtlj.setMoneyName(moneyType.getMoneyName());
		return mtlj;
	}
	
	public static List<MoneyTypeListJson> packJsons(List<MoneyType> moneyTypes){
		List<MoneyTypeListJson> moneyTypeListJson = new ArrayList<MoneyTypeListJson>();
		for (MoneyType moneyType : moneyTypes) {
			moneyTypeListJson.add(packJson(moneyType));
		}
		return moneyTypeListJson;
	}
}
