package com.talha.northwind.core.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talha.northwind.core.entities.User;
import com.talha.northwind.core.utilities.result.DataResult;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	List<User> getByEmail(String email);
}
