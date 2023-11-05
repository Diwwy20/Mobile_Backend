package com.example.MINIProject.user.business;

import java.util.List;

import com.example.MINIProject.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MINIProject.user.json.UserListJson;
import com.example.MINIProject.user.payload.UserPayload;
import com.example.MINIProject.user.service.UserService;

@Service
public class UserBusiness {

	@Autowired
	UserService userService;
	
	public List<UserListJson> getListUser(){
		return UserListJson.packJsons(userService.getAllUsers());
	}
	
	public UserListJson getUserId(long id) {
		return UserListJson.packJson(userService.findById(id));
	}
	
	public void saveUser(UserPayload upl) {
		User user = new User(upl.getUserName(),
							  upl.getPassword(),
							  upl.getUName());
		userService.save(user);
	}
	
	public void updateUser(long id, UserPayload payload) {
		User userData = userService.findById(id);
		userData.setUserName(payload.getUserName());
		userData.setPassword(payload.getPassword());
		userData.setUName(payload.getUName());
		userService.save(userData);
	}
	
	public void deleteUser(long id) {
		userService.deleteById(id);
	}
}
