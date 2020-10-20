package com.mystudy.icbc;

import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class YQHLDemo {
	public static void main(String[] args) throws Exception {
		String fSeqno ="FRK"+ DateFormatUtil.formatDate(new Date(),"yyyyMMddHHmmssSSS");
		String sTransCode = "";
		
		// Base64.Decoder decoder = Base64.getDecoder();
		Base64.Encoder encoder = Base64.getEncoder();
		String xml_text = "<?xml version=\"1.0\"encoding=\"GBK\"?><CMS><eb><pub><TransCode>PAYENT</TransCode><CIS>46694306-XAAAAA</CIS>"
				+ "<BankCode>102</BankCode><ID>suzhouTest.y.1102</ID><TranDate></TranDate>NotCare<TranTime>NotCare</TranTime><fSeqno>X</fSeqno>"
				+ "</pub><in><OnlBatF>1</OnlBatF><SettleMode>0</SettleMode><TotalNum>1</TotalNum><TotalAmt>6789</TotalAmt><SignTime></SignTime>"
				+ "<ReqReserved1></ReqReserved1><ReqReserved2></ReqReserved2><rd><iSeqno>1</iSeqno><ReimburseNo></ReimburseNo><ReimburseNum>"
				+ "</ReimburseNum><StartDate></StartDate><StartTime></StartTime><PayType>1</PayType><PayAccNo>1102020109000009078</PayAccNo>"
				+ "<PayAccNameCN>剥滥火判酬</PayAccNameCN><PayAccNameEN></PayAccNameEN><RecAccNo>1102020109000203242</RecAccNo>"
				+ "<RecAccNameCN>剥滥判幕耕婚舒憾</RecAccNameCN><RecAccNameEN></RecAccNameEN><SysIOFlg>1</SysIOFlg><IsSameCity></IsSameCity>"
				+ "<Prop></Prop><RecICBCCode></RecICBCCode><RecCityName>工行系统内无需注明</RecCityName><RecBankNo></RecBankNo>"
				+ "<RecBankName>工行系统内无需注明</RecBankName><CurrType>001</CurrType><PayAmt>6789</PayAmt><UseCode></UseCode>"
				+ "<UseCN>上线测试</UseCN><EnSummary></EnSummary><PostScript></PostScript><Summary></Summary><Ref></Ref><Oref></Oref>"
				+ "<ERPSqn></ERPSqn><BusCode></BusCode><ERPcheckno></ERPcheckno><CrvouhType></CrvouhType><CrvouhName></CrvouhName>"
				+ "<CrvouhNo></CrvouhNo><BankType></BankType><FileNames></FileNames><Indexs></Indexs><PaySubNo></PaySubNo>"
				+ "<RecSubNo></RecSubNo><MCardNo></MCardNo><MCardName></MCardName></rd></in></eb></CMS>";
		
		//查询余额 返回D0098
		xml_text = "<?xml version=\"1.0\" encoding = \"GB2312\"?>" + 
	       		"<ICBCYH>" + 
	       		"<opReq>" + 
	       		"<opName>NCQueryBalanceOp</opName>" + 
	       		"<ReqParam>" + 
	       		"<Area_code></Area_code>" + 
	       		"<Account_num>1311045029200040348</Account_num>"	+ 
	       		"<Account_cur></Account_cur>" + 
	       		"<userID>hyhl.y.1311</userID>" + 
	       		"<PackageID>" + fSeqno + "</PackageID>" + 
	       		"<ReqReserved1></ReqReserved1>" + 
	       		"<ReqReserved2></ReqReserved2>" + 
	       		"</ReqParam>" + 
	       		"</opReq>" + 
	       		"</ICBCYH>";
		sTransCode = "NCQueryBalanceOp";

		//查询余额明细
		//1311045009200002486
		//1311045029200040348
		xml_text = "<?xml version=\"1.0\" encoding = \"GBK\"?>" + 
				"<CMS>" + 
				"<eb>" + 
				"<pub>" + 
				"<TransCode>QHISD</TransCode>" + 
				"<CIS>71390256-5AAAAA</CIS>" + 
				"<BankCode>102</BankCode>" + 
				"<ID>hyhl.y.1311</ID>	" + 
				"<TranDate>" + DateFormatUtil.formatDate(new Date(),DateFormatUtil.PT_YYYYMMDD) + "</TranDate>" + 
				"<TranTime>" + DateFormatUtil.formatDate(new Date(),"hhmmssSSS") + "</TranTime>" + 
				"<fSeqno>" + fSeqno + "</fSeqno>" + 
				"</pub>" + 
				"<in>" + 
				"<AccNo>1311045009200002486</AccNo>" + 
				"<BeginDate>20201020</BeginDate>" + 
				"<EndDate>20201020</EndDate>" + 
				"<MinAmt>0</MinAmt>" + 
				"<MaxAmt>99999999999</MaxAmt>" +
				"<BankType></BankType>" +
				"<NextTag></NextTag>" + 
				"<CurrType></CurrType>" + 
				"<DueBillNo></DueBillNo>" + 
				"<AcctSeq></AcctSeq>" + 
				"<ComplementFlag></ComplementFlag>" + 
				"</in>" + 
				"</eb>" + 
				"</CMS>";
		sTransCode = "QHISD";
		
//		String s = "<?xml version=\"1.0\" encoding = \"GBK\"?>"
//				+ "<CMS>"
//				+ "<eb>"
//				+ "<pub>"
//				+ "<TransCode>QHISD</TransCode>"
//				+ "<CIS>130290000499759</CIS>"
//				+ "<BankCode>102</BankCode>"
//				+ "<ID>gynbcs0227.y.1302</ID>"
//				+ "<TranDate>20180321</TranDate>"
//				+ "<TranTime>095539631</TranTime>"
//				+ "<fSeqno>20180321.095539.ZFF</fSeqno>"
//				+ "</pub>"
//				+ "<in>"
//				+ "<AccNo>1302015009022576202</AccNo>"
//				+ "<BeginDate>20180101</BeginDate>"
//				+ "<EndDate>20180131</EndDate>"
//				+ "<MinAmt>0</MinAmt>"
//				+ "<MaxAmt>99999999999</MaxAmt>"
//				+ "<BankType></BankType>"
//				+ "<NextTag></NextTag>"
//				+ "<CurrType></CurrType>"
//				+ "<DueBillNo></DueBillNo>"
//				+ "<AcctSeq></AcctSeq>"
//				+ "<ComplementFlag></ComplementFlag></in></eb></CMS>";

		//System.out.println(new String(decoder.decode(encodedText), "GBK"));
		
		String param = "userID=hyhl.y.1311&PackageID=" + fSeqno + "&SendTime=" + DateFormatUtil.formatDate(new Date(),"yyyyMMddHHmmssSSS") 
						+ "&Version=0.0.0.1&TransCode=NCQueryBalanceOp&BankCode=102&ID=hyhl.y.1311&GroupCIS=71390256-5AAAAA" 
						+ "&reqData=" + xml_text;
		
		param = "userID=hyhl.y.1311&PackageID=" + fSeqno + "&SendTime=" + DateFormatUtil.formatDate(new Date(),"yyyyMMddHHmmssSSS") 
		+ "&Version=0.0.1.0&TransCode=" + sTransCode + "&BankCode=102&ID=hyhl.y.1311&GroupCIS=71390256-5AAAAA" 
		+ "&reqData=" + xml_text;
		
		String repcontent = sendPost("http://127.0.0.1:448/servlet/ICBCCMPAPIReqServlet", param);
		try {
	           repcontent = repcontent.substring(8);
	           System.out.println("银企互联返回:\r\n"+repcontent);
	           byte[] decodeResult = Base64Util.getbyteFromBASE64(repcontent);
	           repcontent = new String(decodeResult);
	           System.out.println("base64解码如下:\r\n" + repcontent);
	       } catch (Exception e) {
	           e.printStackTrace();
	           System.out.println("银企互联返回base64报错:" + e.toString());
	       }
		System.out.println();
		
	}

	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Accept-Charset", "utf-8");
			conn.setRequestProperty("contentType", "utf-8");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
}