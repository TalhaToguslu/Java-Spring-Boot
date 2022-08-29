package com.talha.northwind.business.abstracts;

import java.util.List;

import com.talha.northwind.core.entities.User;
import com.talha.northwind.core.utilities.result.DataResult;
import com.talha.northwind.core.utilities.result.Result;

public interface UserService {
	Result add(User user);
	DataResult<List<User>> getByEmail(String email);
}
