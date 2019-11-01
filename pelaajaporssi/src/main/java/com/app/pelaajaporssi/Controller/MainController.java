package com.app.pelaajaporssi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.app.pelaajaporssi.domain.Message;
import com.app.pelaajaporssi.domain.MessageRepository;
import com.app.pelaajaporssi.domain.User;
import com.app.pelaajaporssi.domain.UserRepository;

@Controller
public class MainController {
	
	@Autowired UserRepository userRepository; 
	@Autowired MessageRepository messageRepository;
	private String _username, _message;

	@GetMapping({"/index"})
	public String index(@RequestParam(value="username")String username, 
		@RequestParam(value="message")String message, Model model) {
		_username = username;
		model.addAttribute("username", _username);
		model.addAttribute("message", new Message());
	//	model.addAttribute("note", new Message());
		model.addAttribute("allMessages", messageRepository.findAll());
		
		
		
		return "index";
		
	} 
	
	@PostMapping ("/submit")
	public String forward(Model model, User user, Message message) { 
		
		message.setUsername(_username);
		//message.setMessage("onnistui");
		
		messageRepository.save(message);
		
		_username = message.getUsername();
		_message = message.getMessagetext();
		
		
		return "redirect:/index?username=" + _username + "&message=" + _message;
	}
	
	
	@PostMapping ("/form")
	public String send(User user) {
		_username = user.getUsername();
	//	return "index?username=" + _username + "&message=";
		return "redirect:/index?username=" + _username + "&message=";
	}
	
	@GetMapping({"/", "/login"})
	public String login(Model model) {
		model.addAttribute("user", new User());
		
		return "login";
	}

	
}