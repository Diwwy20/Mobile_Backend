package com.example.MINIProject.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.MINIProject.exception.BaseException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RevenueException extends BaseException{
	private static final long serialVersionUID = 1L;
	
	public RevenueException(String code, HttpStatus status) {
		super("revenue." + code, status);
	}
	
	public static RevenueException emptyRevenue() {
		return new RevenueException("findRevenue.notFound", HttpStatus.BAD_REQUEST);
	}
}
