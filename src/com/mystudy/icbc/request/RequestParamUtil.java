package com.mystudy.icbc.request;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class RequestParamUtil {
	public static String GetReqData(Object reqDataModel) throws Exception {
		StringBuilder result = new StringBuilder();
		result.append("<?xml version=\"1.0\" encoding=\"GBK\"?>");
		result.append("<CMS><eb>");
		
		result.append("<pub>");
		Field[] superfields = reqDataModel.getClass().getSuperclass().getDeclaredFields();
		for(Field field : superfields) {
			if(field.isAnnotationPresent(RequestXMLElement.class)) {
				RequestXMLElement annotation = field.getDeclaredAnnotation(RequestXMLElement.class);
				if(annotation.parent().equals("pub")) {
					field.setAccessible(true);
					result.append("<" + annotation.name() + ">");
					result.append(field.get(reqDataModel));
					result.append("</" + annotation.name() + ">");
				}
			}
		}
		result.append("</pub>");
		
		result.append("<in>");
		Field[] fields = reqDataModel.getClass().getDeclaredFields();
		for(Field field : fields) {
			if(field.isAnnotationPresent(RequestXMLElement.class)) {
				RequestXMLElement annotation = field.getDeclaredAnnotation(RequestXMLElement.class);
				if(annotation.parent().equals("in")) {
					field.setAccessible(true);
					
					if(annotation.name().equals("rd")) {
						Object rds = field.get(reqDataModel);
						
						if(rds instanceof ArrayList<?>) 
						{
							for(Object rd :  (ArrayList<?>) rds) 
							{
								result.append("<rd>");
								Field[] rdFields = rd.getClass().getDeclaredFields();
								for(Field rdField : rdFields) {
									if(rdField.isAnnotationPresent(RequestXMLElement.class)) {
										rdField.setAccessible(true);
										RequestXMLElement rdAnnotation = rdField.getDeclaredAnnotation(RequestXMLElement.class);
										result.append("<" + rdAnnotation.name() + ">");
										result.append(rdField.get(rd));
										result.append("</" + rdAnnotation.name() + ">");
									}
								}
								result.append("</rd>");
							}
						}
					} else if(annotation.name().equals("directin")) {
						Object directin = field.get(reqDataModel);
						
						Field[] directinFields = directin.getClass().getDeclaredFields();
						for(Field directinField : directinFields) {
							if(directinField.isAnnotationPresent(RequestXMLElement.class)) {
								directinField.setAccessible(true);
								RequestXMLElement directinAnnotation = directinField.getDeclaredAnnotation(RequestXMLElement.class);
								result.append("<" + directinAnnotation.name() + ">");
								result.append(directinField.get(directin));
								result.append("</" + directinAnnotation.name() + ">");
							}
						}
					} else {
						result.append("<" + annotation.name() + ">");
						result.append(field.get(reqDataModel));
						result.append("</" + annotation.name() + ">");
					}
				}
			}
		}
		result.append("</in>");
		result.append("</eb></CMS>");
		
		return result.toString();
	}
	
	public static String GetParam(RequestParam requestParam) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = requestParam.getClass().getDeclaredFields();
		
		ArrayList<String> strs = new ArrayList<String>();
		
		for(Field field : fields) {
			
			if(field.isAnnotationPresent(RequestXMLElement.class)) {
				RequestXMLElement annotation = field.getAnnotation(RequestXMLElement.class);
				field.setAccessible(true);
				strs.add(annotation.name() + "=" + field.get(requestParam));
			}
		}
		
		return String.join("&", strs);
	}
	
	public static RequestParam GetRequestParam(String sSeqno, String sTransCode, String sVersion) {
		RequestParam requestParam = new RequestParam();
		requestParam.setUserID(ConstRequest.CERTID);
		requestParam.setPackageID(sSeqno);
		requestParam.setSendTime(ConstRequest.getDateTime());
		requestParam.setVersion(sVersion);
		requestParam.setTransCode(sTransCode);
		requestParam.setBankCode(ConstRequest.BANKCODE);
		requestParam.setID(ConstRequest.CERTID);
		requestParam.setGroupCIS(ConstRequest.CIS);
		
		return requestParam;
	}
}
