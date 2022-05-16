package com.ganguli.qrgenerator.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public final class QRCodeUtil {
	private QRCodeUtil() {
	}
	
	private static final int HEIGHT = 250, WIDTH = 250;
	
	public static byte[] generateQRCode(String shortPath) throws WriterException, IOException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(shortPath, BarcodeFormat.QR_CODE, WIDTH, HEIGHT);
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
	}
}
