package com.mystudy.icbc.request;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConstRequest {
	public static final String CIS = "71390256-5AAAAA";
	
	public static final String BANKCODE = "102";
	
	public static final String CERTID = "hyhl.y.1311";
	
	public static final String PT_yyyyMMdd = "yyyyMMdd";
	
	public static final String PT_HHmmssSSS = "HHmmssSSS";
	
	public static final String PT_yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
	
	public static final String CURRTYPE = "001";
	
	public static final String ACCNO40348 = "1311045029200040348";
	
	public static final String ACCNO2528 = "1311045029200002528";
	
	public static final String ACCNO2486 = "1311045009200002486";
	
	public static final String VERSIONOLD = "0.0.0.1";
	
	public static final String VERSIONNEW = "0.0.1.0";
	
	public static final String BASE_URL = "http://127.0.0.1:448/servlet/ICBCCMPAPIReqServlet";
	
	public static final String SIGN_URL = "http://127.0.0.1:449";
	
	public static String getTranDate() {
        return getDateByPattern(PT_yyyyMMdd);
	}
	
	public static String getTranTime() {
		return getDateByPattern(PT_HHmmssSSS);
	}
	
	public static String getDateTime() {
		return getDateByPattern(PT_yyyyMMddHHmmssSSS);
	}
	
	public static String getDateByPattern(String pattern) {
		Date dNow = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(dNow);
	}
}
