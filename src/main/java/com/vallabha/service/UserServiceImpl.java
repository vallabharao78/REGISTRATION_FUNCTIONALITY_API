package com.vallabha.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vallabha.bindings.LoginDetails;
import com.vallabha.bindings.UnlockDetails;
import com.vallabha.bindings.UserDetails;
import com.vallabha.config.EmailConfig;
import com.vallabha.entity.User;
import com.vallabha.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private EmailConfig emailConfig;

	@Override
	public List<User> getAllUsers() {
		return null;
	}

	@Override
	public String saveUser(UserDetails userDetails) throws Exception {
		User user = new User();
		BeanUtils.copyProperties(userDetails, user);
		user.setPassword(GenerateRandomPwd(8));
		User savedEntity = userRepo.save(user);

		if (savedEntity != null) {
			boolean isSent = emailConfig.sendEmail(savedEntity);
			if (isSent) {
				return "User saved Successfully and Mail sent to your email check now";
			}
		}
		return "User Not saved mail not sent...";
	}
	
	@Override
	public User unlockAccount(Integer userId) {
		Optional<User> userEntity = userRepo.findById(userId);
		if(userEntity != null) {
			return userEntity.get();
		}
		return null;
	}
	
	@Override
	public User findByEmail(String email) {
		User userEntity = userRepo.findByEmail(email);
		if(userEntity != null) {
			return userEntity;
		}
		return null;
	}
	
	@Override
	public String verifyAccount(UnlockDetails unlockDetails) {
		User userEntity = userRepo.findByEmail(unlockDetails.getEmail());
		if(userEntity != null) {
			String tempPw = userEntity.getPassword();
			if(tempPw.equals(unlockDetails.getTempPwd())) {
				// Updating New User Password
				userEntity.setPassword(unlockDetails.getNewPwd());
				userRepo.save(userEntity);
				return "login_page";
			}else {
				return "unlock_account";
			}
		}
		return "unlock_account";
	}
	
	@Override
	public Boolean checkLogin(LoginDetails loginDetails) {
		User userEntity = userRepo.findByEmailAndPassword(loginDetails.getUserName(),loginDetails.getPassword());
		if(userEntity != null) {
			return true;
		}
		return false;
	}
	
	private static String GenerateRandomPwd(int length) {
		String cap_letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String small_letter = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String finalString = cap_letter + small_letter + numbers;

		Random random = new Random();
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			password[i] = finalString.charAt(random.nextInt(finalString.length()));
		}
		System.out.println(password);
		return new String(password);
	}

	

}
