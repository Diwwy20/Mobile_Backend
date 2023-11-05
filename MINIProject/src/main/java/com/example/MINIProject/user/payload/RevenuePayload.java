package com.example.MINIProject.user.payload;

import java.time.LocalDateTime;

import com.example.MINIProject.user.model.MoneyType;
import com.example.MINIProject.user.model.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RevenuePayload {
	private String rName;
	private int rMoney;
	private MoneyType moneyType;
	private LocalDateTime createdAt;
	private User user;
}
