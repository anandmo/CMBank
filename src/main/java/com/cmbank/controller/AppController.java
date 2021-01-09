package com.cmbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cmbank.model.BankAccount;
import com.cmbank.model.User;
import com.cmbank.repository.BankAccountRepository;
import com.cmbank.repository.UserRepository;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BankAccountRepository accountRepo;

	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());

		return "signup_form";
	}

	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		userRepo.save(user);

		return "register_success";
	}

	@PostMapping("/process_openaccount")
	public String processOpenAccount(BankAccount bankaccount) {
		accountRepo.save(bankaccount);
		return "account_success";
	}

	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);

		return "users";
	}

	@GetMapping("/userportal")
	public String userPortal(Model model) {

		return "userportal";
	}

	/*@GetMapping("/error")
	public String userPortal() {

		return "error";
	}*/

	@GetMapping("/newaccount")
	public String openAccount(Model model) {
		model.addAttribute("bankaccount", new BankAccount());
		return "newaccount";
	}

}