package com.example.MINIProject.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MINIProject.user.model.User;


public interface UserRepository extends JpaRepository<User, Long>{
	User findById(long id);
//	User findByUserName(String userName);
	Optional<User> findOptionalById(long id);
//	User findByPassword(String password);
	User findByUserNameAndPassword(String userName, String password);
}
