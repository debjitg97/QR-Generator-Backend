package com.ganguli.qrgenerator.dto;

public class ShortenURLDTO {
	private String url;
	
	public ShortenURLDTO() {
	}

	public ShortenURLDTO(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
