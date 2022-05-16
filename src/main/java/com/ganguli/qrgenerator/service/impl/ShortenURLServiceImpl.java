package com.ganguli.qrgenerator.service.impl;

import org.springframework.stereotype.Service;

import com.ganguli.qrgenerator.dto.ShortenURLDTO;
import com.ganguli.qrgenerator.dto.ShortenedURLDTO;
import com.ganguli.qrgenerator.exception.BadRequestException;
import com.ganguli.qrgenerator.service.ShortenURLService;
import com.ganguli.qrgenerator.util.URLShortenerUtil;

@Service
public class ShortenURLServiceImpl implements ShortenURLService {

	@Override
	public ShortenedURLDTO shortenURL(ShortenURLDTO shortenURLDTO) throws BadRequestException {
		if(!URLShortenerUtil.checkURL(shortenURLDTO.getUrl()))
			throw new BadRequestException("Not a valid URL!");
		return new ShortenedURLDTO(URLShortenerUtil.generateShortUrl(shortenURLDTO.getUrl()));
	}
	@Override
	public String getURL(Long id) throws BadRequestException {
		String url = URLShortenerUtil.getUrl(id);
		if(url == null)
			throw new BadRequestException("Not a valid short URL!");
		return url;
	}

	
}
