package com.ganguli.qrgenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ganguli.qrgenerator.exception.BadRequestException;
import com.ganguli.qrgenerator.service.ShortenURLService;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class RedirectController {
	@Autowired
	private ShortenURLService shortenURLService;
	
	@RequestMapping("/{id}")
	private String getDefaultHTML(@PathVariable Long id) throws BadRequestException {
		return "redirect:" + shortenURLService.getURL(id);
	}
}
