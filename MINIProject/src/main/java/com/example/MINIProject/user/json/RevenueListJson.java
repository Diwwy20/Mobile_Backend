package com.example.MINIProject.user.json;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.MINIProject.user.model.MoneyType;
import com.example.MINIProject.user.model.Revenue;
import com.example.MINIProject.user.model.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RevenueListJson {
	private long id;
	private String rName;
	private int rMoney;
	private MoneyType moneyType;
	private LocalDateTime createdAt;
	private User user;
	
	public static RevenueListJson packJson(Revenue revenue) {
		RevenueListJson rlj = new RevenueListJson();
		rlj.setId(revenue.getId());
		
		User user = new User();
		user.setUserName(revenue.getUser().getUserName());
		user.setId(revenue.getUser().getId());
		user.setUName(revenue.getUser().getUName());
		user.setPassword(revenue.getUser().getPassword());
		rlj.setUser(user);
		
		rlj.setRName(revenue.getRName());
		rlj.setRMoney(revenue.getRMoney());
		rlj.setMoneyType(revenue.getMoneyType());
		rlj.setCreatedAt(revenue.getCreatedAt());
		

		
		return rlj;
	}
	
	public static List<RevenueListJson> packJsons(List<Revenue> revenues){
		List<RevenueListJson> revenueListJson = new ArrayList<RevenueListJson>();
		for (Revenue revenue : revenues) {
			revenueListJson.add(packJson(revenue));
		}
		return revenueListJson;
	}
}
