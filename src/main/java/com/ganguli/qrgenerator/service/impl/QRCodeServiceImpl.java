package com.ganguli.qrgenerator.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ganguli.qrgenerator.service.QRCodeService;
import com.ganguli.qrgenerator.util.QRCodeUtil;
import com.google.zxing.WriterException;

@Service
public class QRCodeServiceImpl implements QRCodeService {
	@Value("${HOST_URL}")
	private String hostUrl;
	
	@Override
	public byte[] getQRCode(Long id) throws WriterException, IOException {
		return QRCodeUtil.generateQRCode(hostUrl + "/" + id);
	}

}
