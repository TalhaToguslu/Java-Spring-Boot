package com.talha.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.talha.northwind.business.abstracts.UserService;
import com.talha.northwind.core.entities.User;
import com.talha.northwind.core.utilities.result.DataResult;
import com.talha.northwind.core.utilities.result.Result;
import com.talha.northwind.core.utilities.result.SuccessDataResult;
import com.talha.northwind.core.utilities.result.SuccessResult;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService _userService;
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody User user) {
		_userService.add(user);
		return ResponseEntity.ok(new SuccessResult());
	}
	
	@GetMapping("/getByEmail")
	public ResponseEntity<?> getByEmail(@RequestParam String email) {
		return ResponseEntity.ok(new SuccessDataResult<List<User>>(_userService.getByEmail(email)));
	}
}
