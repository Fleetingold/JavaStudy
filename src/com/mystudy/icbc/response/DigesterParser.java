package com.mystudy.icbc.response;

import java.io.IOException;

import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

public class DigesterParser {
	
	public static QACCBALResponseV1 Parse() {
		QACCBALResponseV1 response = null;
		
		//1、创建Digester对象实例
		Digester digester = new Digester();
		
		//2、配置属性值
        digester.setValidating(false);
        
        //3、push对象到对象栈
        //digester.push(new Foo());
        
        //4、设置匹配模式、规则
        digester.addObjectCreate("CMS/eb/pub", "com.mystudy.icbc.response.QACCBALResponseV1");
        digester.addCallMethod("CMS/eb/pub/TransCode", "setTransCode", 0);
        //addBeanPropertySetter也能实现给对象赋值的操作
        //digester.addBeanPropertySetter("CMS/eb/pub/TransCode", "transCode");
        digester.addCallMethod("CMS/eb/pub/CIS", "setCis", 0);
        digester.addCallMethod("CMS/eb/pub/BankCode", "setBankCode", 0);
        digester.addCallMethod("CMS/eb/pub/ID", "setID", 0);
        digester.addCallMethod("CMS/eb/pub/TranDate", "setTranDate", 0);
        digester.addCallMethod("CMS/eb/pub/TranTime", "setTranTime", 0);
        digester.addCallMethod("CMS/eb/pub/fSeqno", "setfSeqno", 0);
        digester.addCallMethod("CMS/eb/pub/RetCode", "setReturnCode", 0);
        digester.addCallMethod("CMS/eb/pub/RetMsg", "setReturnMsg", 0);
        
        //5、开始解析
        try {
			response = digester.parse(DigesterParser.class.getClassLoader().getResourceAsStream("example.xml"));
	
			System.out.println("TransCode:" + response.getTransCode());
			System.out.println("CIS:" + response.getCis());
			System.out.println("BankCode:" + response.getBankCode());
			System.out.println("ID:" + response.getID());
			System.out.println("TranDate:" + response.getTranDate());
			System.out.println("fSeqno:" + response.getfSeqno());
			System.out.println("ReturnCode:" + response.getReturnCode());
			System.out.println("ReturnMsg:" + response.getReturnMsg());
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return response;
	}
	
	public static QACCBALResponseV1.QACCBALResponseV1Rd ParseRd() {
		QACCBALResponseV1.QACCBALResponseV1Rd responseRd = null;
		
		//1、创建Digester对象实例
		Digester digester = new Digester();
		
		//2、配置属性值
        digester.setValidating(false);
        
        //3、push对象到对象栈
        //digester.push(new Foo());
        
        //4、设置匹配模式、规则
        //CMS/eb/out/rd
        digester.addObjectCreate("CMS/eb/out/rd", "com.mystudy.icbc.response.QACCBALResponseV1$QACCBALResponseV1Rd");
        digester.addCallMethod("CMS/eb/out/rd/iSeqno", "setiSeqno", 0);
        digester.addBeanPropertySetter("CMS/eb/out/rd/iSeqno", "iSeqno");
        digester.addBeanPropertySetter("CMS/eb/out/rd/AccNo", "accNo");
        digester.addBeanPropertySetter("CMS/eb/out/rd/CurrType", "currType");
        digester.addBeanPropertySetter("CMS/eb/out/rd/CashExf", "cashExf");
        digester.addBeanPropertySetter("CMS/eb/out/rd/AcctProperty", "acctProperty");
        digester.addBeanPropertySetter("CMS/eb/out/rd/AccBalance", "accBalance");
        digester.addBeanPropertySetter("CMS/eb/out/rd/Balance", "balance");
        digester.addBeanPropertySetter("CMS/eb/out/rd/UsableBalance", "usableBalance");
        digester.addBeanPropertySetter("CMS/eb/out/rd/FrzAmt", "frzAmt");
        digester.addBeanPropertySetter("CMS/eb/out/rd/QueryTime", "queryTime");
        digester.addBeanPropertySetter("CMS/eb/out/rd/iRetCode", "iRetCode");
        digester.addBeanPropertySetter("CMS/eb/out/rd/iRetMsg", "iRetMsg");
        digester.addBeanPropertySetter("CMS/eb/out/rd/RepReserved3", "repReserved3");
        digester.addBeanPropertySetter("CMS/eb/out/rd/RepReserved4", "repReserved4");
        
        //5、开始解析
        try {
        	responseRd = digester.parse(DigesterParser.class.getClassLoader().getResourceAsStream("example.xml"));
			
			//rd
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return responseRd;
	}
	
	public static void main(String [] args) {
		QACCBALResponseV1 response = Parse();
		
		QACCBALResponseV1.QACCBALResponseV1Rd responseRd = ParseRd();
		
		response.setRd(responseRd);
		
		System.out.println("TransCode:" + response.getTransCode());
		System.out.println("CIS:" + response.getCis());
		System.out.println("BankCode:" + response.getBankCode());
		System.out.println("ID:" + response.getID());
		System.out.println("TranDate:" + response.getTranDate());
		System.out.println("fSeqno:" + response.getfSeqno());
		System.out.println("ReturnCode:" + response.getReturnCode());
		System.out.println("ReturnMsg:" + response.getReturnMsg());
		
		System.out.println("iSeqno:" + responseRd.getiSeqno());
		System.out.println("AccNo:" + responseRd.getAccNo());
		System.out.println("CurrType:" + responseRd.getCurrType());
		System.out.println("CashExf:" + responseRd.getCashExf());
		System.out.println("AcctProperty:" + responseRd.getAcctProperty());
		System.out.println("AccBalance:" + responseRd.getAccBalance());
		System.out.println("Balance:" + responseRd.getBalance());
		System.out.println("UsableBalance:" + responseRd.getUsableBalance());
		System.out.println("FrzAmt:" + responseRd.getFrzAmt());
		System.out.println("QueryTime:" + responseRd.getQueryTime());
		System.out.println("iRetCode:" + responseRd.getiRetCode());
		System.out.println("iRetMsg:" + responseRd.getiRetMsg());
		System.out.println("RepReserved3:" + responseRd.getRepReserved3());
		System.out.println("RepReserved4:" + responseRd.getRepReserved4());
		
		System.out.println("账号:" + response.getRd().getAccNo());
		System.out.println("余额:" + response.getRd().getUsableBalance());
	}
}
