package com.kudeaketa.app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kudeaketa.app.core.beans.User;

@Controller
public class LoginController {
	
	@GetMapping("/")
	public String login(Model model) {
		return "login";
	}
	
	@PostMapping("/login-procesar")
	public String procesarLogin(@ModelAttribute User user) {
		System.out.println();
		return "login";
	}

}
