package com.example.MINIProject.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name = "User")
@Table(
		name = "user",
		uniqueConstraints = {
				@UniqueConstraint(name = "user_name_unique", columnNames = "username")
		})

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UID")
	private Long id;
	

	@Column(name = "username", unique = true, nullable = false)
	private String userName;
	
	@Column(name = "password",  nullable = false)
	private String password;

	@Column(name = "u_name", nullable = false)
	private String uName;
	
	public User() {
		;
	}
	
	public User(String userName, String password, String uName) {
		super();
		this.userName = userName;
		this.password = password;
		this.uName = uName;
	}
}
