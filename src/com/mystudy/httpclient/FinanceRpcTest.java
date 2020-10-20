package com.mystudy.httpclient;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import com.alibaba.fastjson.JSON;

public class FinanceRpcTest {

	public static void main(String[] args) throws UnsupportedEncodingException{
		// TODO Auto-generated method stub
		FinanceRpcTest_DeleteFromJavaBean();
	}

	/**
	 * JavaBeanת��JSONString �� ���ñ���FinanceRpc�е�Create����
	 */
	static void FinanceRpcTest_CreateFromJavaBean() throws UnsupportedEncodingException{
		String url = "http://localhost:11002/IFinance/CreateFinaBankAccountBalance";
		
		FinaBankAccountBalance object = new FinaBankAccountBalance("042C7348-4F76-4EFE-AAB1-6F76D5FA6908","JAVA_Call_RPC-API","123456789",520.00,1,"jeffrey",new Date(),"JAVA_Call_FinanceRpc");
		
		String jsonString =  JSON.toJSONString(object);
		System.out.println(HttpClientHelper.doPostJson(url,jsonString));
	}
	
	/**
	 * JavaBeanת��JSONString �� ���ñ���FinanceRpc�е�Update����
	 */
	static void FinanceRpcTest_UpdateFromJavaBean() throws UnsupportedEncodingException{
		String url = "http://localhost:11002/IFinance/UpdateFinaBankAccountBalance";
		
		FinaBankAccountBalance object = new FinaBankAccountBalance("042C7348-4F76-4EFE-AAB1-6F76D5FA6908","JAVA_Call_RPC-API_Update","123456789",520.00,1,"jeffrey",new Date(),"JAVA_Call_FinanceRpc_Update");
		
		String jsonString =  JSON.toJSONString(object);
		System.out.println(HttpClientHelper.doPostJson(url,jsonString));
	}
	
	/**
	 * JavaBeanת��JSONString �� ���ñ���FinanceRpc�е�Delete����
	 */
	static void FinanceRpcTest_DeleteFromJavaBean() throws UnsupportedEncodingException{
		String url = "http://localhost:11002/IFinance/DeleteFinaBankAccountBalance";
		
		FinaBankAccountBalance object = new FinaBankAccountBalance();
		object.setId("042C7348-4F76-4EFE-AAB1-6F76D5FA6908");
		
		String jsonString =  JSON.toJSONString(object);
		System.out.println(jsonString);
		System.out.println(HttpClientHelper.doPostJson(url,jsonString));
	}
}
