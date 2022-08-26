package com.talha.northwind.business.abstracts;

import java.util.List;

import com.talha.northwind.core.entities.User;

public interface UserService {
	User add(User user);
	List<User> getByEmail(String email);
}
