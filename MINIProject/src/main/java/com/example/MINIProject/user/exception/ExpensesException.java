package com.example.MINIProject.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.MINIProject.exception.BaseException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExpensesException extends BaseException{
	private static final long serialVersionUID = 1L;
	
	public ExpensesException(String code, HttpStatus status) {
		super("expenses." + code, status);
	}
	
	public static ExpensesException emptyExpenses() {
		return new ExpensesException("findExpenses.notFound", HttpStatus.BAD_REQUEST);
	}
}
