package com.kudeaketa.app.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kudeaketa.app.core.beans.User;
import com.kudeaketa.app.core.facades.LoginFacade;
import com.kudeaketa.app.core.utils.Utilidades;

@Controller
public class LoginController {
	
	@Autowired
	private LoginFacade loginFacade;
	
	@GetMapping("/")
	public String login(Model model) {
		return "login";
	}
	
	@PostMapping("/login-procesar")
	public String procesarLogin(@ModelAttribute User user, Model model) {
		User usuario = loginFacade.getUsuarioLogin(user.getUsername(), user.getPass());
		if (Utilidades.esVacio(usuario)) {
			model.addAttribute("error", true);
			return "login";
		}
		return "home";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		
		return "register";
	}
	
	@PostMapping("/register-procesar")
	public String procesarRegister(@ModelAttribute User user, Model model) {
		if (loginFacade.insertarUsuario(user) != 1) {
			model.addAttribute("error", true);
			return "register";
		}
		model.addAttribute("register", true);
		return "login";
	}

}
