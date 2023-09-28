package com.vallabha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.vallabha.bindings.LoginDetails;
import com.vallabha.bindings.PasswordDetails;
import com.vallabha.bindings.UnlockDetails;
import com.vallabha.bindings.UserDetails;
import com.vallabha.entity.User;
import com.vallabha.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/register")
	private String LoadRegisterForm(Model model) {
		UserDetails userDetails = new UserDetails();
		model.addAttribute("userDetails", userDetails);
		return "registration_form";
	}

	@PostMapping("/register-user")
	private String RegisterUser(@ModelAttribute("userDetails") UserDetails userDetails, Model model) throws Exception {
		String msg = userService.saveUser(userDetails);
		model.addAttribute("successMsg", msg);
		model.addAttribute("userDetails", userService.findByEmail(userDetails.getEmail()));
		return "registration_success";
	}

	@GetMapping("/unlock_account/{userId}")
	private String unlockAccount(@PathVariable Integer userId, Model model) {
		User userEntity = userService.unlockAccount(userId);
		model.addAttribute("userEntity", userEntity);

		UnlockDetails unlockDetails = new UnlockDetails();
		model.addAttribute("unlockDetails", unlockDetails);
		return "unlock_account";
	}

	@PostMapping("/verify_account")
	private String vefiryAccount(@ModelAttribute("unlockDetails") UnlockDetails unlockDetails, Model model) {
		String verifyAccountMsg = userService.verifyAccount(unlockDetails);
		if (verifyAccountMsg.equals("unlock_account")) {
			model.addAttribute("errorMsg", " Invalid Credentials, Try again ...!!");
		} else {
			LoginDetails loginDetails = new LoginDetails();
			model.addAttribute("loginDetails", loginDetails);
			return verifyAccountMsg;
		}
		return verifyAccountMsg;
	}

	@GetMapping("/forgot_password")
	private String forgotPassword(Model model) {
		LoginDetails loginDetails = new LoginDetails();
		model.addAttribute("loginDetails", loginDetails);
		return "forgot_password";
	}

	@PostMapping("/login_page")
	private String login(@ModelAttribute("loginDetails") LoginDetails loginDetails, Model model) {
		Boolean status = userService.checkLogin(loginDetails);
		if(status) {
			return "dashboard";
		}
		model.addAttribute("errorMsg", "Invalid Credentials");
		return "login_page";
	}
	
	@PostMapping("/create_password")
	private String createPassword(@ModelAttribute("loginDetails") LoginDetails loginDetails, Model model) {
		User userEntity = userService.findByEmail(loginDetails.getUserName());
		if(userEntity != null) {
			return "create_password";
		}
		model.addAttribute("errorMsg", "Invalid User Name...");
		return null;
	}
	
	@PostMapping("/update_password")
	private String updatePwd(@ModelAttribute("passwordDetails") PasswordDetails passwordDetails, Model model) {
		PasswordDetails passwordDetailsObj = new PasswordDetails();
		model.addAttribute("passwordDetails", passwordDetailsObj);
		//userService.updatePwd()
		
		
		// here we need email...
		
		
		return "pending";
	}

}
