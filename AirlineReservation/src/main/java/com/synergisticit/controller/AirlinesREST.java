package com.synergisticit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.synergisticit.service.AirlinesService;

@RestController
public class AirlinesREST {
	@Autowired
	AirlinesService airlinesService;
	
	
	
		
}
