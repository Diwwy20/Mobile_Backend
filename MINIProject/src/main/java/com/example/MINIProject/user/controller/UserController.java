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
import com.example.MINIProject.user.business.MoneyTypeBusiness;
import com.example.MINIProject.user.business.UserBusiness;
import com.example.MINIProject.user.json.MoneyTypeListJson;
import com.example.MINIProject.user.json.UserListJson;
import com.example.MINIProject.user.model.MoneyType;
import com.example.MINIProject.user.model.User;
import com.example.MINIProject.user.payload.MoneyTypePayload;
import com.example.MINIProject.user.payload.UserPayload;
import com.example.MINIProject.user.service.ExpensesService;
import com.example.MINIProject.user.service.MoneyTypeService;
import com.example.MINIProject.user.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserBusiness userBusiness;
	
//	@Autowired
//	CategoriesService categoryService;
//	
//	@Autowired
//	CategoriesBusiness categoryBusiness;
	
	@Autowired
	MoneyTypeService moneyTypeService;
	
	@Autowired
	MoneyTypeBusiness moneyTypeBusiness;
	
	@Autowired
	ExpensesService expensesService;
	
	@Autowired
	ExpensesBusiness expensesBusiness;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(value = "/users")
	public ResponseEntity<List<UserListJson>> getAllUsers() throws BaseException {
		return ResponseEntity.ok(userBusiness.getListUser());
	}
	
	@GetMapping(value = "/users/{id}")
	public ResponseEntity<UserListJson> getUserById(@PathVariable("id") long id) throws BaseException {
		return ResponseEntity.ok(userBusiness.getUserId(id));
	}
	
	@PostMapping(value = "/users")
	public ResponseEntity<Void> saveUser(@RequestBody UserPayload payload) throws BaseException {
			userBusiness.saveUser(payload);
			return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<UserListJson> updateUser(@PathVariable("id") long id, @RequestBody UserPayload payload){
		Optional<User> userData = userService.findOptionalById(id);
		if(userData.isPresent()) {
			userBusiness.updateUser(userData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
		try {
			userBusiness.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/user/login")
    public String login(@RequestBody User user) {
        String userName = user.getUserName();
        String password = user.getPassword();

        if (userService.verifyUser(userName, password)) {
            return "Login successful!";
        } else {
            return "Invalid email or password. Please try again.";
        }
    }
	
		//	Categories //
//	@GetMapping(value = "/categories")
//	public ResponseEntity<List<CategoriesListJson>> getAllCategories() throws BaseException {
//		return ResponseEntity.ok(categoryBusiness.getListCategories());
//	}
//	
//	@GetMapping(value = "/category/{id}")
//	public ResponseEntity<CategoriesListJson> getCategoriesById(@PathVariable("id") long id) throws BaseException {
//		return ResponseEntity.ok(categoryBusiness.getCategoriesId(id));
//	}
//	
//	@PostMapping(value = "/category")
//	public ResponseEntity<Void> saveCategory(@RequestBody CategoriesPayload payload) throws BaseException {
//			categoryBusiness.saveCategory(payload);
//			return new ResponseEntity<>(HttpStatus.CREATED);
//	}
//	
//	@PutMapping("/category/{id}")
//	public ResponseEntity<CategoriesListJson> updateCategory(@PathVariable("id") long id, @RequestBody CategoriesPayload payload){
//		Optional<Categories> categoryData = categoryService.findOptionalById(id);
//		if(categoryData.isPresent()) {
//			categoryBusiness.updateCategory(categoryData.get().getId(), payload);
//			return new ResponseEntity<>(HttpStatus.OK);
//		}
//		else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
//	
//	@DeleteMapping("/category/{id}")
//	public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id") long id){
//		try {
//			categoryBusiness.deleteCategory(id);
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		catch(Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
		//	MoneyType //
	@GetMapping(value = "/moneytypes")
	public ResponseEntity<List<MoneyTypeListJson>> getAllMoneyTypes() throws BaseException {
		return ResponseEntity.ok(moneyTypeBusiness.getListMoneyTypes());
	}
	
	@GetMapping(value = "/moneytype/{id}")
	public ResponseEntity<MoneyTypeListJson> getMoneyTypeById(@PathVariable("id") long id) throws BaseException {
		return ResponseEntity.ok(moneyTypeBusiness.getMoneyTypeId(id));
	}
	
	@PostMapping(value = "/moneytype")
	public ResponseEntity<Void> saveMoneyType(@RequestBody MoneyTypePayload payload) throws BaseException{
			moneyTypeBusiness.saveMoneyType(payload);
			return new ResponseEntity<>(HttpStatus.CREATED);	
	}
	
	@PutMapping("/moneytype/{id}")
	public ResponseEntity<MoneyTypeListJson> updateMoneyType(@PathVariable("id") long id, @RequestBody MoneyTypePayload payload) {
		Optional<MoneyType> moneyTypeData = moneyTypeService.findOptionalById(id);
		if(moneyTypeData.isPresent()) {
			moneyTypeBusiness.updateMoneyType(moneyTypeData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/moneytype/{id}")
	public ResponseEntity<HttpStatus> deleteMoneyType(@PathVariable("id") long id) {
		try {
			moneyTypeBusiness.deleteMoneyType(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
