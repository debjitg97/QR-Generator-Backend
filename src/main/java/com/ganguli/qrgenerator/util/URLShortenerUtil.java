package com.ganguli.qrgenerator.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class URLShortenerUtil {
	private URLShortenerUtil() {
	}
	
	private static Map<String, Long> stringToLong = new HashMap<>(); 
	private static Map<Long, String> longToString = new HashMap<>();
	
	
	public static boolean checkURL(String url) {
		Pattern pattern = Pattern.compile("^(https?)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
		return pattern.matcher(url).matches();
	}
	
	public static Long generateShortUrl(String url) {
		if(stringToLong.containsKey(url))
			return stringToLong.get(url);
		stringToLong.put(url, stringToLong.size() + 1L);
		longToString.put(stringToLong.get(url), url);
		return stringToLong.get(url);
	}
	
	public static String getUrl(Long id) {
		return longToString.get(id);
	}
}
