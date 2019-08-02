package edu.uw.info360.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.uw.info360.models.User;
import edu.uw.info360.services.UserService;
import edu.uw.info360.validators.UserValidator;

@Controller
@RequestMapping("login")
public class LoginController {
	private final UserService userService;
	private final UserValidator userValidator;
	
	public LoginController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	
	@RequestMapping("")
	public String login() {
		return "Login/login.jsp";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password) {
		boolean isAuthenticated = userService.authenticateUser(email, password);
		if(isAuthenticated) {
			return "redirect:/home";
		} else {
			return "Login/login.jsp";
		}
	}
	
	@RequestMapping("/loginAssistant")
	public String loginAssistant() {
		return "Login/loginAssistant.jsp";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "Login/register.jsp";
	}
	
    @RequestMapping(value="/registerUser", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        userValidator.validate(user, result);
        if(result.hasErrors()) {
            return "Login/register.jsp";
        }
        User u = userService.registerUser(user);
        session.setAttribute("userId", u.getId());
        return "redirect:/home";
    }
	
}
