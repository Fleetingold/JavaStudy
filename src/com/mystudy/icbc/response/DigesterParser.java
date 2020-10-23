package com.mystudy.icbc.response;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

public class DigesterParser {
	
	public static QACCBALResponseV1 ParseQACCBALResponse(InputStream input) {
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
			response = digester.parse(input);
	
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
	
	public static QACCBALResponseV1.QACCBALResponseV1Rd ParseQACCBALResponseRd(InputStream input) {
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
        	responseRd = digester.parse(input);
			
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
	
	public static QACCBALResponseV1 GetQACCBALResponseFromInputStream(InputStream input1, InputStream input2) {
		
		QACCBALResponseV1 response = ParseQACCBALResponse(input1);
		
		QACCBALResponseV1.QACCBALResponseV1Rd responseRd = ParseQACCBALResponseRd(input2);
		
		response.setRd(responseRd);
		
		return response;
	}
	
	public static QACCBALResponseV1 GetQACCBALResponseFromXML(String responseXml) {
		InputStream input1 = new ByteArrayInputStream(responseXml.getBytes());
		InputStream input2 = new ByteArrayInputStream(responseXml.getBytes());
		
		return GetQACCBALResponseFromInputStream(input1, input2);
	}
	
	public static void TestQACCBALResponse() {
		InputStream input1 = DigesterParser.class.getClassLoader().getResourceAsStream("example.xml");
		InputStream input2 = DigesterParser.class.getClassLoader().getResourceAsStream("example.xml");
		
		QACCBALResponseV1 response = GetQACCBALResponseFromInputStream(input1, input2);
		
		System.out.println("TransCode:" + response.getTransCode());
		System.out.println("CIS:" + response.getCis());
		System.out.println("BankCode:" + response.getBankCode());
		System.out.println("ID:" + response.getID());
		System.out.println("TranDate:" + response.getTranDate());
		System.out.println("fSeqno:" + response.getfSeqno());
		System.out.println("ReturnCode:" + response.getReturnCode());
		System.out.println("ReturnMsg:" + response.getReturnMsg());
		
		System.out.println("iSeqno:" + response.getRd().getiSeqno());
		System.out.println("AccNo:" + response.getRd().getAccNo());
		System.out.println("CurrType:" + response.getRd().getCurrType());
		System.out.println("CashExf:" + response.getRd().getCashExf());
		System.out.println("AcctProperty:" + response.getRd().getAcctProperty());
		System.out.println("AccBalance:" + response.getRd().getAccBalance());
		System.out.println("Balance:" + response.getRd().getBalance());
		System.out.println("UsableBalance:" + response.getRd().getUsableBalance());
		System.out.println("FrzAmt:" + response.getRd().getFrzAmt());
		System.out.println("QueryTime:" + response.getRd().getQueryTime());
		System.out.println("iRetCode:" + response.getRd().getiRetCode());
		System.out.println("iRetMsg:" + response.getRd().getiRetMsg());
		System.out.println("RepReserved3:" + response.getRd().getRepReserved3());
		System.out.println("RepReserved4:" + response.getRd().getRepReserved4());
		
		System.out.println("账号:" + response.getRd().getAccNo());
		System.out.println("余额:" + response.getRd().getUsableBalance());
	}

	public static void main(String [] args) {
		TestQHISDResponse();
	}
	
	public static void TestQHISDResponse() {
		InputStream input = DigesterParser.class.getClassLoader().getResourceAsStream("BalanceDetailResponse.xml");
		
		QHISDResponseV1 response = ParseQHISDResponse(input);
		
		System.out.println("TransCode:" + response.getTransCode());
		System.out.println("CIS:" + response.getCis());
		System.out.println("BankCode:" + response.getBankCode());
		System.out.println("ID:" + response.getID());
		System.out.println("TranDate:" + response.getTranDate());
		System.out.println("fSeqno:" + response.getfSeqno());
		System.out.println("ReturnCode:" + response.getReturnCode());
		System.out.println("ReturnMsg:" + response.getReturnMsg());
		System.out.println("AccNo:" + response.getAccNo());
		
		for(QHISDResponseV1.QHISDResponseV1Rd rd : response.getRds()) {
			System.out.println("------------------------------------");
			//CreditAmount
			System.out.println("CreditAmount:" + rd.getCreditAmount());
			System.out.println("RecipAccNo:" + rd.getRecipAccNo());
			System.out.println("RecipName:" + rd.getRecipName());
			System.out.println("Summary:" + rd.getSummary());
			System.out.println("Time:" + rd.getTime());
			System.out.println("Drcrf:" + rd.getDrcrf());
			//RecipBkName1
			System.out.println("RecipBkName1:" + rd.getRecipBkName1());
			//TInfoNew
			System.out.println("TInfoNew:" + rd.getTInfoNew());
			//ReceiptInfo
			System.out.println("ReceiptInfo:" + rd.getReceiptInfo());
		}
	}
	
	public static QHISDResponseV1 ParseQHISDResponse(InputStream input) {
		QHISDResponseV1 response = null;
		
		//1、创建Digester对象实例
		Digester digester = new Digester();
		
		//2、配置属性值
        digester.setValidating(false);
        
        //3、push对象到对象栈
        //digester.push(new Foo());
        
        //4、设置匹配模式、规则
        digester.addObjectCreate("CMS/eb", "com.mystudy.icbc.response.QHISDResponseV1");
        //CMS/eb/pub
        digester.addCallMethod("CMS/eb/pub/TransCode", "setTransCode", 0);
        digester.addCallMethod("CMS/eb/pub/CIS", "setCis", 0);
        digester.addCallMethod("CMS/eb/pub/BankCode", "setBankCode", 0);
        digester.addCallMethod("CMS/eb/pub/ID", "setID", 0);
        digester.addCallMethod("CMS/eb/pub/TranDate", "setTranDate", 0);
        digester.addCallMethod("CMS/eb/pub/TranTime", "setTranTime", 0);
        digester.addCallMethod("CMS/eb/pub/fSeqno", "setfSeqno", 0);
        digester.addCallMethod("CMS/eb/pub/RetCode", "setReturnCode", 0);
        digester.addCallMethod("CMS/eb/pub/RetMsg", "setReturnMsg", 0);
        
        //CMS/eb/out
        digester.addCallMethod("CMS/eb/out/AccNo", "setAccNo", 0);
        digester.addCallMethod("CMS/eb/out/AccName", "setAccName", 0);
        digester.addCallMethod("CMS/eb/out/CurrType", "setCurrType", 0);
        digester.addCallMethod("CMS/eb/out/BeginDate", "setBeginDate", 0);
        digester.addCallMethod("CMS/eb/out/EndDate", "setEndDate", 0);
        digester.addCallMethod("CMS/eb/out/MinAmt", "setMinAmt", 0);
        digester.addCallMethod("CMS/eb/out/MaxAmt", "setMaxAmt", 0);
        digester.addCallMethod("CMS/eb/out/BankType", "setBankType", 0);
        digester.addCallMethod("CMS/eb/out/NextTag", "setNextTag", 0);
        digester.addCallMethod("CMS/eb/out/TotalNum", "setTotalNum", 0);
        digester.addCallMethod("CMS/eb/out/DueBillNo", "setDueBillNo", 0);
        digester.addCallMethod("CMS/eb/out/AcctSeq", "setAcctSeq", 0);
        
        //CMS/eb/out/rd
        digester.addObjectCreate("CMS/eb/out/rd", "com.mystudy.icbc.response.QHISDResponseV1$QHISDResponseV1Rd");
        digester.addCallMethod("CMS/eb/out/rd/Drcrf", "setDrcrf", 0);
        digester.addCallMethod("CMS/eb/out/rd/VouhNo", "setVouhNo", 0);
        digester.addCallMethod("CMS/eb/out/rd/DebitAmount", "setDebitAmount", 0);
        digester.addCallMethod("CMS/eb/out/rd/CreditAmount", "setCreditAmount", 0);
        digester.addCallMethod("CMS/eb/out/rd/Balance", "setBalance", 0);
        digester.addCallMethod("CMS/eb/out/rd/RecipBkNo", "setRecipBkNo", 0);
        digester.addCallMethod("CMS/eb/out/rd/RecipBkName", "setRecipBkName", 0);
        digester.addCallMethod("CMS/eb/out/rd/RecipAccNo", "setRecipAccNo", 0);
        digester.addCallMethod("CMS/eb/out/rd/RecipName", "setRecipName", 0);
        digester.addCallMethod("CMS/eb/out/rd/Summary", "setSummary", 0);
        digester.addCallMethod("CMS/eb/out/rd/UseCN", "setUseCN", 0);
        digester.addCallMethod("CMS/eb/out/rd/PostScript", "setPostScript", 0);
        digester.addCallMethod("CMS/eb/out/rd/BusCode", "setBusCode", 0);
        digester.addCallMethod("CMS/eb/out/rd/Date", "setDate", 0);
        digester.addCallMethod("CMS/eb/out/rd/Time", "setTime", 0);
        digester.addCallMethod("CMS/eb/out/rd/Ref", "setRef", 0);
        digester.addCallMethod("CMS/eb/out/rd/Oref", "setOref", 0);
        digester.addCallMethod("CMS/eb/out/rd/EnSummary", "setEnSummary", 0);
        digester.addCallMethod("CMS/eb/out/rd/BusType", "setBusType", 0);
        digester.addCallMethod("CMS/eb/out/rd/VouhType", "setVouhType", 0);
        digester.addCallMethod("CMS/eb/out/rd/AddInfo", "setAddInfo", 0);
        digester.addCallMethod("CMS/eb/out/rd/Toutfo", "setToutfo", 0);
        digester.addCallMethod("CMS/eb/out/rd/OnlySequence", "setOnlySequence", 0);
        digester.addCallMethod("CMS/eb/out/rd/AgentAcctName", "setAgentAcctName", 0);
        digester.addCallMethod("CMS/eb/out/rd/AgentAcctNo", "setAgentAcctNo", 0);
        digester.addCallMethod("CMS/eb/out/rd/UpDtranf", "setUpDtranf", 0);
        digester.addCallMethod("CMS/eb/out/rd/ValueDate", "setValueDate", 0);
        digester.addCallMethod("CMS/eb/out/rd/TrxCode", "setTrxCode", 0);
        digester.addCallMethod("CMS/eb/out/rd/Ref1", "setRef1", 0);
        digester.addCallMethod("CMS/eb/out/rd/Oref1", "setOref1", 0);
        digester.addCallMethod("CMS/eb/out/rd/CASHF", "setCASHF", 0);
        digester.addCallMethod("CMS/eb/out/rd/BusiDate", "setBusiDate", 0);
        digester.addCallMethod("CMS/eb/out/rd/BusiTime", "setBusiTime", 0);
        digester.addCallMethod("CMS/eb/out/rd/TradeTime", "setTradeTime", 0);
        digester.addCallMethod("CMS/eb/out/rd/TradeLocation", "setTradeLocation", 0);
        digester.addCallMethod("CMS/eb/out/rd/SubAcctSeq", "setSubAcctSeq", 0);
        digester.addCallMethod("CMS/eb/out/rd/THCurrency", "setTHCurrency", 0);
        digester.addCallMethod("CMS/eb/out/rd/RecipBkName1", "setRecipBkName1", 0);
        digester.addCallMethod("CMS/eb/out/rd/RecipBkNo1", "setRecipBkNo1", 0);
        digester.addCallMethod("CMS/eb/out/rd/TInfoNew", "setTInfoNew", 0);
        digester.addCallMethod("CMS/eb/out/rd/BusTypNo", "setBusTypNo", 0);
        digester.addCallMethod("CMS/eb/out/rd/ReceiptInfo", "setReceiptInfo", 0);
        digester.addCallMethod("CMS/eb/out/rd/TelNo", "setTelNo", 0);
        digester.addCallMethod("CMS/eb/out/rd/MDCARDNO", "setMdCardNo", 0);
        digester.addCallMethod("CMS/eb/out/rd/TrxAmt", "setTrxAmt", 0);
        digester.addCallMethod("CMS/eb/out/rd/TrxCurr", "setTrxCurr", 0);
        digester.addCallMethod("CMS/eb/out/rd/CurrType", "setCurrType", 0);
        
        
        digester.addSetNext("CMS/eb/out/rd", "addRd");
        
        //5、开始解析
        try {
			response = digester.parse(input);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return response;
	}

	public static QHISDResponseV1 GetQHISDResponseFromXML(String responseXml) {
		InputStream input1 = new ByteArrayInputStream(responseXml.getBytes());
		
		return ParseQHISDResponse(input1);
	}
	
	public static BATEBILLResponseV1 GetBATEBILLResponseFromXML(String responseXml) {
		BATEBILLResponseV1 response = null;
		
		InputStream input = new ByteArrayInputStream(responseXml.getBytes());
		
		//1、创建Digester对象实例
		Digester digester = new Digester();
		
		//2、配置属性值
        digester.setValidating(false);
        
        //3、push对象到对象栈
        //digester.push(new Foo());
        
        //4、设置匹配模式、规则
        digester.addObjectCreate("CMS/eb", "com.mystudy.icbc.response.BATEBILLResponseV1");
        //CMS/eb/pub
        digester.addCallMethod("CMS/eb/pub/TransCode", "setTransCode", 0);
        digester.addCallMethod("CMS/eb/pub/CIS", "setCis", 0);
        digester.addCallMethod("CMS/eb/pub/BankCode", "setBankCode", 0);
        digester.addCallMethod("CMS/eb/pub/ID", "setID", 0);
        digester.addCallMethod("CMS/eb/pub/TranDate", "setTranDate", 0);
        digester.addCallMethod("CMS/eb/pub/TranTime", "setTranTime", 0);
        digester.addCallMethod("CMS/eb/pub/fSeqno", "setfSeqno", 0);
        digester.addCallMethod("CMS/eb/pub/RetCode", "setReturnCode", 0);
        digester.addCallMethod("CMS/eb/pub/RetMsg", "setReturnMsg", 0);
        
        //CMS/eb/out
        digester.addCallMethod("CMS/eb/out/TotalNum", "setTotalNum", 0);
        
        //CMS/eb/out/rd
        digester.addObjectCreate("CMS/eb/out/rd", "com.mystudy.icbc.response.BATEBILLResponseV1$BATEBILLResponseV1Rd");
        
        digester.addCallMethod("CMS/eb/out/rd/iSeqno", "setiSeqno", 0);
        digester.addCallMethod("CMS/eb/out/rd/OrderNo", "setOrderNo", 0);
        digester.addCallMethod("CMS/eb/out/rd/EbillSerialno", "setEbillSerialno", 0);
        digester.addCallMethod("CMS/eb/out/rd/PayAccount", "setPayAccount", 0);
        digester.addCallMethod("CMS/eb/out/rd/PayAcctName", "setPayAcctName", 0);
        digester.addCallMethod("CMS/eb/out/rd/PayBankName", "setPayBankName", 0);
        digester.addCallMethod("CMS/eb/out/rd/RecAccount", "setRecAccount", 0);
        digester.addCallMethod("CMS/eb/out/rd/RecAcctName", "setRecAcctName", 0);
        digester.addCallMethod("CMS/eb/out/rd/RecBankName", "setRecBankName", 0);
        digester.addCallMethod("CMS/eb/out/rd/PayAmt", "setPayAmt", 0);
        digester.addCallMethod("CMS/eb/out/rd/CurrType", "setCurrType", 0);
        digester.addCallMethod("CMS/eb/out/rd/Summary", "setSummary", 0);
        digester.addCallMethod("CMS/eb/out/rd/BusType", "setBusType", 0);
        digester.addCallMethod("CMS/eb/out/rd/UseCN", "setUseCN", 0);
        digester.addCallMethod("CMS/eb/out/rd/TranSerialNo", "setTranSerialNo", 0);
        digester.addCallMethod("CMS/eb/out/rd/TimeStamp", "setTimeStamp", 0);
        digester.addCallMethod("CMS/eb/out/rd/Remark", "setRemark", 0);
        digester.addCallMethod("CMS/eb/out/rd/EbillKey", "setEbillKey", 0);
        digester.addCallMethod("CMS/eb/out/rd/TransNetCode", "setTransNetCode", 0);
        digester.addCallMethod("CMS/eb/out/rd/TransTellno", "setTransTellno", 0);
        digester.addCallMethod("CMS/eb/out/rd/TransDate", "setTransDate", 0);
        digester.addCallMethod("CMS/eb/out/rd/RePrintNum", "setRePrintNum", 0);
        digester.addCallMethod("CMS/eb/out/rd/PostScript", "setPostScript", 0);
        digester.addCallMethod("CMS/eb/out/rd/VouchNo", "setVouchNo", 0);
        digester.addCallMethod("CMS/eb/out/rd/VouchType", "setVouchType", 0);
        digester.addCallMethod("CMS/eb/out/rd/Result", "setResult", 0);
        digester.addCallMethod("CMS/eb/out/rd/iRetCode", "setiRetCode", 0);
        digester.addCallMethod("CMS/eb/out/rd/iRetMsg", "setiRetMsg", 0);
        digester.addCallMethod("CMS/eb/out/rd/AgentPayAcctNo", "setAgentPayAcctNo", 0);
        digester.addCallMethod("CMS/eb/out/rd/AgentPayName", "setAgentPayName", 0);
        digester.addCallMethod("CMS/eb/out/rd/UpdTranf", "setUpdTranf", 0);
        digester.addCallMethod("CMS/eb/out/rd/ValueDate", "setValueDate", 0);
        digester.addCallMethod("CMS/eb/out/rd/AcctSeq", "setAcctSeq", 0);
        digester.addCallMethod("CMS/eb/out/rd/AcctSeqName", "setAcctSeqName", 0);
        digester.addCallMethod("CMS/eb/out/rd/ProdType", "setProdType", 0);
        digester.addCallMethod("CMS/eb/out/rd/CusInfo", "setCusInfo", 0);
        digester.addCallMethod("CMS/eb/out/rd/BankSerialNo", "setBankSerialNo", 0);
        
        digester.addSetNext("CMS/eb/out/rd", "addRd");
        
        //5、开始解析
        try {
			response = digester.parse(input);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return response;
	} 
}
