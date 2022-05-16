package com.ganguli.qrgenerator.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganguli.qrgenerator.service.QRCodeService;
import com.google.zxing.WriterException;

@RestController
@RequestMapping(value = "/v1/qr-code")
@CrossOrigin(origins = "*", maxAge = 3600)
public class QRCodeController {
	@Autowired
	private QRCodeService codeService;
	
	
	@GetMapping(value = "/image/{id}", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> getQRCode(@PathVariable Long id) throws WriterException, IOException {
        return new ResponseEntity<>(codeService.getQRCode(id), HttpStatus.CREATED);
	}
}
