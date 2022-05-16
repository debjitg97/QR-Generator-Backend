package com.ganguli.qrgenerator.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ganguli.qrgenerator.dto.ShortenURLDTO;
import com.ganguli.qrgenerator.dto.ShortenedURLDTO;
import com.ganguli.qrgenerator.exception.BadRequestException;
import com.ganguli.qrgenerator.service.ShortenURLService;
import com.ganguli.qrgenerator.util.URLShortenerUtil;

@Service
public class ShortenURLServiceImpl implements ShortenURLService {
	@Value("${HOST_URL}")
	private String hostUrl;
	
	
	@Override
	public ShortenedURLDTO shortenURL(ShortenURLDTO shortenURLDTO) throws BadRequestException {
		if(!URLShortenerUtil.checkURL(shortenURLDTO.getUrl()))
			throw new BadRequestException("Not a valid URL!");
		Long id = URLShortenerUtil.generateShortUrl(shortenURLDTO.getUrl());
		return new ShortenedURLDTO(hostUrl + "/" + id, hostUrl + "/v1/qr-code/image/" + id);
	}
	@Override
	public String getURL(Long id) throws BadRequestException {
		String url = URLShortenerUtil.getUrl(id);
		if(url == null)
			throw new BadRequestException("Not a valid short URL!");
		return url;
	}

	
}
