package com.efunzo.services.epellationfront.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.efunzo.services.epellationfront.client.epellation.client.model.Level;
import com.efunzo.services.epellationfront.service.ApelationService;

@Controller
public class EpellationController {
	
	
	@Autowired
	private ApelationService epelationService;
	
	@RequestMapping("/")
	public ModelAndView homepage() {
	
		return new ModelAndView("homepage", "username", "Tom");
	}
	
	@RequestMapping("/profile")
	public ModelAndView profile() {
		
		Map<String, Object> profile = new HashMap<>();
		
		profile.put("firstName", "Blaise");
		profile.put("lastName", "Mbascou");
		profile.put("school", "ST Famille");
		profile.put("level", "12");
		
		return new ModelAndView("profile", "profile", profile);
	}
	
	@RequestMapping("/all/level")
	public ModelAndView getAllLevels() {
		
		List<Level> levels = epelationService.getAllLevel();
	
		
		return new ModelAndView("levels", "levels", levels);
	}

}
