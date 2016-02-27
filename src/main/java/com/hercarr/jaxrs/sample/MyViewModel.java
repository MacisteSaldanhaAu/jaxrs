package com.hercarr.jaxrs.sample;

import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

import com.hercarr.jaxrs.sample.model.User;
import com.hercarr.jaxrs.sample.model.UserService;

public class MyViewModel {

	private int count;
	
	@Init
	public void init() {
		count = 100;
	}

	@Command
	@NotifyChange("count")
	public void cmd() {
		++count;
	}

	public int getCount() {
		return count;
	}
	
	public List<User> getUsers() {
		return UserService.users;
	}
	
}
