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
import com.example.MINIProject.user.business.RevenueBusiness;
import com.example.MINIProject.user.json.RevenueListJson;
import com.example.MINIProject.user.model.MoneyType;
import com.example.MINIProject.user.model.Revenue;
import com.example.MINIProject.user.payload.RevenuePayload;
import com.example.MINIProject.user.service.RevenueService;

@RestController
@RequestMapping("/api")
public class RevenueController {
	@Autowired
	RevenueService revenueService;
	
	@Autowired
	RevenueBusiness revenueBusiness;
	
	@GetMapping(value = "/revenues")
	public ResponseEntity<List<RevenueListJson>> getAllRevenues() throws BaseException {
		return ResponseEntity.ok(revenueBusiness.getListRevenues());
	}
	
//	ดูเฉพาะ รายการ รายได้ นั้น
	@GetMapping(value = "/revenue/{id}")
	public ResponseEntity<RevenueListJson> getRevenueById(@PathVariable("id") long id) throws BaseException {
		return ResponseEntity.ok(revenueBusiness.getRevenueTypeId(id));
	} 
	
//	ดูรายการ รายได้ ของ user คนนี้ทั้งหมด
	@GetMapping(value = "/revenue/user/{uid}")
	public ResponseEntity<List<RevenueListJson>> getRevenueByUserid(@PathVariable("uid") long uid) throws BaseException {
		return ResponseEntity.ok(revenueBusiness.getRevenuesByUserId(uid));
	}
	
//	ดูรายการ รายได้ ของ User คนนี้ทั้งหมด เฉพาะ เงินสด หรือ โอน
	@GetMapping(value = "/revenue/user/{uid}/type/{moneyType}")
	public ResponseEntity<List<RevenueListJson>> getRevenueByUserIdAndMoneyType(@PathVariable("uid") long userId, @PathVariable("moneyType") MoneyType moneyType) throws BaseException {
		return ResponseEntity.ok(revenueBusiness.getMoneyTypeByUserId(userId, moneyType));
	}
	
//	สร้างรายได้ สำหรับ User คนนั้นๆ
	@PostMapping(value = "/revenue/save")
	public ResponseEntity<Void> saveRevenueList(@RequestBody RevenuePayload payload) throws BaseException{
		revenueBusiness.saveRevenue(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/revenue/update/{id}")
	public ResponseEntity<RevenueListJson> updateRevenue(@PathVariable("id") long id, @RequestBody RevenuePayload payload) {
		Optional<Revenue> revenueData = revenueService.findOptionalById(id);
		if(revenueData.isPresent()) {
			revenueBusiness.updateRevenue(revenueData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/revenue/delete/{id}")
	public ResponseEntity<HttpStatus> deleteRevenue(@PathVariable("id") long id) {
		try {
			revenueBusiness.deleteRevenue(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
