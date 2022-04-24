package com.taobao.alihealth;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.zip.GZIPOutputStream;

public class XmlUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 生产批发企业的xml上传时 使用(通过一个xml文件生成加密xml文件内容体)
	 * 
	 * @param fileName
	 * @return
	 */
	public static String createFileZipContent(String fileName) {
		String xmlFileContent = readFileByLines(fileName);
		try {
			byte[] temp_fileByte = xmlFileContent.getBytes("UTF-8");
			byte[] fileByte = compressFile(temp_fileByte);
			String base64Content = "";
			base64Content = base64EncoderToByte(fileByte);
			return base64Content;
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	private static String readFileByLines(String fileName) {

		File file = new File(fileName);
		BufferedReader reader = null;
		String temp_s = "";
		try {
			// System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			@SuppressWarnings("unused")
			int line = 1;

			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				temp_s += tempString.trim();
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		// System.out.println("temp_s------"+temp_s);
		return temp_s;
	}

	/*
	 * 
	 * 压缩
	 * 
	 * @param abyte0
	 * 
	 * @return
	 */private static byte[] compressFile(byte abyte0[]) {
		byte abyte1[] = null;
		try {
			ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
			GZIPOutputStream gzipoutputstream = new GZIPOutputStream(
					bytearrayoutputstream);
			gzipoutputstream.write(abyte0);
			gzipoutputstream.finish();
			abyte1 = bytearrayoutputstream.toByteArray();
			gzipoutputstream.close();
			bytearrayoutputstream.close();
		} catch (IOException ioexception) {
			ioexception.printStackTrace();
		}
		return abyte1;
	}

	private static String base64EncoderToByte(byte[] gzByte) {
		//sun.misc.BASE64Encoder be = new sun.misc.BASE64Encoder();
		
		return Base64.getEncoder().encodeToString(gzByte);
	}

}
