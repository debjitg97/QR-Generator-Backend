package com.ganguli.qrgenerator.dto;

public class ShortenedURLDTO {
	private String shortenedUrl, qrCodeUrl;

	public ShortenedURLDTO(String shortenedUrl, String qrCodeUrl) {
		this.shortenedUrl = shortenedUrl;
		this.qrCodeUrl = qrCodeUrl;
	}

	public String getShortenedUrl() {
		return shortenedUrl;
	}

	public void setShortenedUrl(String shortenedUrl) {
		this.shortenedUrl = shortenedUrl;
	}

	public String getQrCodeUrl() {
		return qrCodeUrl;
	}

	public void setQrCodeUrl(String qrCodeUrl) {
		this.qrCodeUrl = qrCodeUrl;
	}
}
