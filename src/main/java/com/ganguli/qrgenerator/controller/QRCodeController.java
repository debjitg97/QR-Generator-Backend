package com.ganguli.qrgenerator.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganguli.qrgenerator.dto.ShortenURLDTO;
import com.ganguli.qrgenerator.util.QRCodeUtil;
import com.google.zxing.WriterException;

@RestController
@RequestMapping(value = "/v1/qr-code")
public class QRCodeController {
	@PostMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> getQRCode(@RequestBody ShortenURLDTO shortenURLDTO) throws WriterException, IOException {
        return new ResponseEntity<>(QRCodeUtil.generateQRCode(shortenURLDTO.getUrl()), HttpStatus.CREATED);
	}
}
