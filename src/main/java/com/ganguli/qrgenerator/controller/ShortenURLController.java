package com.ganguli.qrgenerator.controller;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganguli.qrgenerator.dto.ShortenURLDTO;
import com.ganguli.qrgenerator.dto.ShortenedURLDTO;
import com.ganguli.qrgenerator.exception.BadRequestException;
import com.ganguli.qrgenerator.service.ShortenURLService;

@RestController
@RequestMapping(value = "/v1/shorten-url")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ShortenURLController {
	@Autowired
	private ShortenURLService shortenURLService;
	
	
	@PostMapping("/shorten")
	public ResponseEntity<ShortenedURLDTO> shortedURL(@RequestBody ShortenURLDTO shortenURLDTO) throws BadRequestException, UnknownHostException {
		return new ResponseEntity<>(shortenURLService.shortenURL(shortenURLDTO), HttpStatus.ACCEPTED);
	}
}
