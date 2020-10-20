package com.mystudy.icbc;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {

	public static final String PT_YYYYMMDD = "yyyyMMdd";

	public static String formatDate(Date date, String ptYyyymmdd) {
		// TODO Auto-generated method stub
		Date dNow = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(ptYyyymmdd);
		return dateFormat.format(dNow);
	}
}
