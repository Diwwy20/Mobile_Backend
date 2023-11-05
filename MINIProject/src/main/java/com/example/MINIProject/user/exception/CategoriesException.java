package com.example.MINIProject.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.MINIProject.exception.BaseException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CategoriesException extends BaseException{
	private static final long serialVersionUID = 1L;
	
	public CategoriesException(String code, HttpStatus status) {
		super("categories." + code, status);
	}
	
	public static CategoriesException emptyCategories() {
		return new CategoriesException("findCategories.notFound", HttpStatus.BAD_REQUEST);
	}
}
