package com.vallabha.service;

import java.util.List;

import com.vallabha.bindings.LoginDetails;
import com.vallabha.bindings.UnlockDetails;
import com.vallabha.bindings.UserDetails;
import com.vallabha.entity.User;

public interface UserService {
	
	List<User> getAllUsers();
	
	String saveUser(UserDetails userDetails) throws Exception;

	User unlockAccount(Integer userId);

	User findByEmail(String email);

	String verifyAccount(UnlockDetails unlockDetails);

	Boolean checkLogin(LoginDetails loginDetails);

}
