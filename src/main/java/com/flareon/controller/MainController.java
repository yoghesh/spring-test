package com.flareon.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.flareon.model.Customers;

@Controller
@RequestMapping("/hello")
public class MainController {

	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model)
	{
		model.addAttribute("customer", new Customers());
		return "home";
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public String cisto(@Valid Customers custo, BindingResult res, Model mod)
	{
		if(res.hasErrors())
		{
			mod.addAttribute("errors", res.getAllErrors());
			mod.addAttribute("customer", custo);
			return "home";
			}
		else
		{return "success";}
	}
	
}
