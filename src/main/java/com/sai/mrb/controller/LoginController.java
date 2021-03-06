/**
 * 
 */
package com.sai.mrb.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sai.mrb.model.Login;
import com.sai.mrb.service.UserService;

/**
 * @author sv
 *
 */
@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	UserService userService;

	@GetMapping
	public String login() {
		return "index";
	}

	@PostMapping(path = "/login")
	public String validateandLogin( @RequestParam("name") String name, @RequestParam("password") String password,
			Model m,@ModelAttribute("booking") Login login, HttpSession httpSession) {
		String flag = "index";
		System.out.println(login.getName());
		if (name.equalsIgnoreCase("admin") && password.equals("admin")) {
			httpSession.setAttribute("name", "admin");
			flag = "admin";
			System.out.println("Inside Admin");
		}
		else if (validateUser(login)) {
			httpSession.setAttribute("name", login.getName());
			flag = "user";
			System.out.println("Inside User");
		}
		else {
			m.addAttribute("message", "Invalid Credentials");
			flag = "error";
			System.out.println("Inside Error");
		}
		return flag;
	}
	
	@RequestMapping("/add")
	public String redirectToAddUserPage(Map<String, Object> model) {
		model.put("message","Please fill the required details");
		return "add";
	}
	
	@RequestMapping("/meetingroom")
	public String redirectToAddMeetingRoomPage(Map<String, Object> model) {
		model.put("message","Please fill the required details");
		return "meetingroom";
	}

	private boolean validateUser(Login login) {
		// TODO Auto-generated method stub
		return userService.validateUser(login);
	}

}
