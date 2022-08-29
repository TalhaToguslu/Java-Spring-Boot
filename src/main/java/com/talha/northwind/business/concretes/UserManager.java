package com.talha.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talha.northwind.business.abstracts.UserService;
import com.talha.northwind.core.dataAccess.UserDao;
import com.talha.northwind.core.entities.User;
import com.talha.northwind.core.utilities.result.DataResult;
import com.talha.northwind.core.utilities.result.Result;
import com.talha.northwind.core.utilities.result.SuccessDataResult;
import com.talha.northwind.core.utilities.result.SuccessResult;

@Service
public class UserManager implements UserService{

	@Autowired
	private UserDao _userDao;
	
	@Override
	public Result add(User user) {
		_userDao.save(user);
		return new SuccessResult("Başarılı.");
	}

	@Override
	public DataResult<List<User>> getByEmail(String email) {
		return new SuccessDataResult<List<User>>(this._userDao.getByEmail(email));
	}

}
