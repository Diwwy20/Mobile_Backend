package com.example.MINIProject.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MINIProject.user.model.User;
import com.example.MINIProject.user.repository.UserRepository;
import com.example.MINIProject.user.service.impl.IUser;

@Service
public class UserService implements IUser{

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}
	
	public Optional<User> findOptionalById(long id){
		return userRepository.findOptionalById(id);
	}
	
	public boolean verifyUser(String userName, String password) {
        User user = userRepository.findByUserNameAndPassword(userName, password);
        return user != null;
    }
}
