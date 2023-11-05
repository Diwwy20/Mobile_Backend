package com.example.MINIProject.user.json;

import java.util.ArrayList;
import java.util.List;

import com.example.MINIProject.user.model.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserListJson {
	private long id;
	private String userName;
	private String password;
	private String uName;
	
	public static UserListJson packJson(User user) {
		UserListJson ulj = new UserListJson();
		ulj.setId(user.getId());
		ulj.setUserName(user.getUserName());
		ulj.setPassword(user.getPassword());
		ulj.setUName(user.getUName());
		
		return ulj;
	}
	
	public static List<UserListJson> packJsons(List<User> users){
		List<UserListJson> userListJson = new ArrayList<UserListJson>();
		for (User user : users) {
			userListJson.add(packJson(user));
		}
		return userListJson;
	}
}
