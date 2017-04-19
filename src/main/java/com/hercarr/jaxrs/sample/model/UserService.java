package com.hercarr.jaxrs.sample.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserService {
	
	public static List<User> users;
	
	static {
		users = new ArrayList<User>();
		
		User userA = new User();
		userA.setEmail("hercarr.mx@gmail.com");
		userA.setId(18);
		userA.setPassword("p@ssw0rd");
		userA.setRegisteredDate(new Date());
		userA.setUsername("hercarr");
		users.add(userA);
		
		User userB = new User();
		userB.setEmail("victor.hernandez@qacg.com");
		userB.setId(24);
		userB.setPassword("q@cg.q@cg");
		userB.setRegisteredDate(new Date());
		userB.setUsername("vhernandez");
		users.add(userB);
	}
	
	public boolean addUser(User user) {
		UserService.users.add(user);
		return true;
	}

	public boolean updateOrCreateUser(User user) {
		User u = findUserById(user.getId());
		if (u == null) {
			return UserService.users.add(user);
		} else {
			return updateUser(user);
		}
	}
	
	public User findUserById(Integer id) {
		if (validateID(id)) {
			return UserService.users.get(id);
		} else {
			return null;
		}
	}
	
	public boolean updateUser(User user) {
		if (UserService.users.size() >= 0) {
			UserService.users.remove(0);
			UserService.users.add(0, user);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteUser(Integer id) {
		if (validateID(id)) {
			UserService.users.remove((int) id);
			return true;
		} else {
			return false;
		}
	}
	
	public List<User> getUsers() {
		return UserService.users;
	}
	
	private boolean validateID(Integer id) {
		if (id != null && id >= 0 && id <= UserService.users.size()) {
			return true;
		} else {
			return false;
		}
	}

}