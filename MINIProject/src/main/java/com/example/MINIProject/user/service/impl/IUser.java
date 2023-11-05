package com.example.MINIProject.user.service.impl;

import java.util.List;

import com.example.MINIProject.user.model.User;

public interface IUser {
	List<User> getAllUsers();
	User findById(long id);
	User save(User user);
	void deleteById(long id);
}
