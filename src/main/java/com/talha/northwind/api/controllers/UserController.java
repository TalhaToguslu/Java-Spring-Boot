package com.talha.northwind.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.talha.northwind.business.abstracts.UserService;
import com.talha.northwind.core.entities.User;
import com.talha.northwind.core.utilities.result.ErrorDataResult;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService _userService;
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody User user) {	
		return ResponseEntity.ok(_userService.add(user));
	}
	
	@GetMapping("/getByEmail")
	public ResponseEntity<?> getByEmail(@RequestParam String email) {
		return ResponseEntity.ok(_userService.getByEmail(email));
	}
	
	// Otomatik error 500 döndürsün demek.
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	// AOP burada yani tüm işlevleri bir kapsayıcı içine alma.
	// Şöyle bir hata olursa bu fonks çalıştır demek.
	@ExceptionHandler(MethodArgumentNotValidException.class) // Validation hatası olursa bu fonks gönder.
	public ErrorDataResult<Object> handlerValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String, String>();
		for(FieldError error: exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(error.getField(), error.getDefaultMessage());
		}
		return new ErrorDataResult<Object>("", validationErrors);
	}
}
