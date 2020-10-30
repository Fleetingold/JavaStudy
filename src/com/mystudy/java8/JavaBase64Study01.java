package com.mystudy.java8;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

public class JavaBase64Study01 {
	public static void main(String args[]) {
		try {
			// Ê¹ÓÃ»ù±¾±àÂë
			String base64encodedString = Base64.getEncoder().encodeToString("runoob?java8".getBytes("utf-8"));
			System.out.println("Base64 ±àÂë×Ö·û´® (»ù±¾) :" + base64encodedString);

			// ½âÂë
			byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);

			System.out.println("Ô­Ê¼×Ö·û´®: " + new String(base64decodedBytes, "utf-8"));
			base64encodedString = Base64.getUrlEncoder().encodeToString("runoob?java8".getBytes("utf-8"));
			System.out.println("Base64 ±àÂë×Ö·û´® (URL) :" + base64encodedString);

			StringBuilder stringBuilder = new StringBuilder();

			for (int i = 0; i < 10; ++i) {
				stringBuilder.append(UUID.randomUUID().toString());
			}

			byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
			String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
			System.out.println("Base64 ±àÂë×Ö·û´® (MIME) :" + mimeEncodedString);

		} catch (UnsupportedEncodingException e) {
			System.out.println("Error :" + e.getMessage());
		}
	}
}
