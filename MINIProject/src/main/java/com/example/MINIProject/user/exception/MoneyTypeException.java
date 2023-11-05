package com.example.MINIProject.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.MINIProject.exception.BaseException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MoneyTypeException extends BaseException{
	private static final long serialVersionUID = 1L;
	
	public MoneyTypeException(String code, HttpStatus status) {
		super("moneyType." + code, status);
	}
	
	public static MoneyTypeException emptyMoneyType() {
		return new MoneyTypeException("findMoneyType.notFound", HttpStatus.BAD_REQUEST);
	}
}
