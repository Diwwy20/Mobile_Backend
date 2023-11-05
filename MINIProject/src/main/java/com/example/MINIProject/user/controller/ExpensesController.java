package com.example.MINIProject.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MINIProject.exception.BaseException;
import com.example.MINIProject.user.business.ExpensesBusiness;
import com.example.MINIProject.user.json.ExpensesListJson;
import com.example.MINIProject.user.model.Expenses;
import com.example.MINIProject.user.model.MoneyType;
import com.example.MINIProject.user.payload.ExpensesPayload;
import com.example.MINIProject.user.service.ExpensesService;

@RestController
@RequestMapping("/api")
public class ExpensesController {
	@Autowired
	ExpensesService expensesService;
	
	@Autowired
	ExpensesBusiness expensesBusiness;
	
	@GetMapping(value = "/expenses")
	public ResponseEntity<List<ExpensesListJson>> getAllExpenses() throws BaseException {
		return ResponseEntity.ok(expensesBusiness.getListExpenses());
	}
	
//	ดูเฉพาะ รายการ รายจ่าย นั้น
	@GetMapping(value = "/expenses/{id}")
	public ResponseEntity<ExpensesListJson> getExpensesById(@PathVariable("id") long id) throws BaseException {
		return ResponseEntity.ok(expensesBusiness.getExpensesTypeId(id));
	}
	
//	ดูรายการ รายจ่าย ของ user คนนี้ทั้งหมด
	@GetMapping(value = "/expenses/user/{uid}")
	public ResponseEntity<List<ExpensesListJson>> getExpensesByUserid(@PathVariable("uid") long uid) throws BaseException {
		return ResponseEntity.ok(expensesBusiness.getExpensesByUserId(uid));
	}
	
//	ดูรายการ รายจ่าย ของ User คนนี้ทั้งหมด เฉพาะ เงินสด หรือ โอน
	@GetMapping(value = "/expenses/user/{uid}/type/{moneyType}")
	public ResponseEntity<List<ExpensesListJson>> getExpensesByUserIdAndMoneyType(@PathVariable("uid") long userId, @PathVariable("moneyType") MoneyType moneyType) throws BaseException {
		return ResponseEntity.ok(expensesBusiness.getMoneyTypeByUserId(userId, moneyType));
	}
	
//	สร้างรายจ่าย สำหรับ User คนนั้นๆ
	@PostMapping(value = "/expenses/save")
	public ResponseEntity<Void> saveExpensesList(@RequestBody ExpensesPayload payload) throws BaseException{
		expensesBusiness.saveExpenses(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
//	แก้ไข รายจ่าย รายการ นั้น
	@PutMapping("/expenses/update/{id}")
	public ResponseEntity<ExpensesListJson> updateExpenses(@PathVariable("id") long id, @RequestBody ExpensesPayload payload) {
		Optional<Expenses> expensesData = expensesService.findOptionalById(id);
		if(expensesData.isPresent()) {
			expensesBusiness.updateExpenses(expensesData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/expenses/delete/{id}")
	public ResponseEntity<HttpStatus> deleteExpenses(@PathVariable("id") long id) {
		try {
			expensesBusiness.deleteExpenses(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
