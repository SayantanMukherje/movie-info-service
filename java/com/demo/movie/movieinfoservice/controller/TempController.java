package com.demo.movie.movieinfoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.movie.movieinfoservice.configuration.DbConfiguration;

@RestController
@RequestMapping ("/tempController")
public class TempController {
	@Autowired
	DbConfiguration configuration;
	
	@Autowired
	Environment environment;
	
	@GetMapping ("/displayData")
	public String displayData() {
		return configuration.getConnection()+" "+configuration.getHost()+" "+configuration.getPort();
	}
	
	@GetMapping ("/envDetails")
	public String envDetails() {
		return environment.toString();
	}
}
