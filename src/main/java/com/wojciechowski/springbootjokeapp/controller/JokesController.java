package com.wojciechowski.springbootjokeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wojciechowski.springbootjokeapp.service.JokeService;

@Controller
public class JokesController {

	private JokeService jokeService;
	
	@Autowired
	public JokesController(JokeService jokeService) {
		this.jokeService = jokeService;
	}
	
	@RequestMapping({"/",""})
	public String showMain(Model theModel) {
		String randomQuote = jokeService.getRandomQuote();
		theModel.addAttribute("quote", randomQuote);
		return "main";
	}


}
