package com.ganguli.qrgenerator.service;

import java.io.IOException;

import com.google.zxing.WriterException;

public interface QRCodeService {
	public byte[] getQRCode(Long id) throws WriterException, IOException;
}
