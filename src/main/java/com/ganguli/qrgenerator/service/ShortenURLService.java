package com.ganguli.qrgenerator.service;

import com.ganguli.qrgenerator.dto.ShortenURLDTO;
import com.ganguli.qrgenerator.dto.ShortenedURLDTO;
import com.ganguli.qrgenerator.exception.BadRequestException;

public interface ShortenURLService {
	public ShortenedURLDTO shortenURL(ShortenURLDTO shortenURLDTO) throws BadRequestException;
	
	public String getURL(Long id) throws BadRequestException;
}
