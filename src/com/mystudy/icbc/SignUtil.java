package com.mystudy.icbc;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class SignUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fSeqno ="FRK"+ DateFormatUtil.formatDate(new Date(),"yyyyMMddHHmmss");
		String time =DateFormatUtil.formatDate(new Date(),"yyyyMMddHHmmssSSS");
		
		// 明文组包
		String xmlContent = "<?xml version=\"1.0\" encoding = \"GB2312\"?>\r\n" + 
			"	<CMS>\r\n" + 
			"		<eb>\r\n" + 
			"			<pub>\r\n" + 
			"				<TransCode>BATEBILL</TransCode>\r\n" + 
			"				<CIS>71390256-5AAAAA</CIS>\r\n" + 
			"				<BankCode>102</BankCode>\r\n" + 
			"				<ID>hyhl.y.1311</ID>	\r\n" + 
			"				<TranDate>" + DateFormatUtil.formatDate(new Date(),DateFormatUtil.PT_YYYYMMDD) + "</TranDate>\r\n" + 
			"				<TranTime>" + DateFormatUtil.formatDate(new Date(),"hhmmssSSS") + "</TranTime>\r\n" + 
		"					<fSeqno>" + fSeqno + "</fSeqno>\r\n" + 
			"			</pub>\r\n" + 
			"			<in>\r\n" + 
			"				<SignTime>" + time + "</SignTime>\r\n" + 
			"				<TotalNum>1</TotalNum>\r\n" + 
			"				<rd>\r\n" + 
			"					<iSeqno>1</iSeqno>\r\n" + 
			"					<AreaCode></AreaCode>\r\n" + 
			"					<NetCode></NetCode>\r\n" + 
			"					<TranDate>" + DateFormatUtil.formatDate(new Date(),"yyyyMMdd") + "</TranDate>\r\n" + 
			"					<AccNo>1311045029200040348</AccNo>\r\n" + 
			"					<TranSerial></TranSerial>\r\n" + 
			"					<AcctSeq></AcctSeq>\r\n" + 
			"					<CurrType></CurrType>\r\n" + 
			"				</rd>\r\n" + 
			"			</in>\r\n" + 
			"		</eb>\r\n" + 
			"</CMS>";
	       
       System.out.println("xml报文明文组包:\r\n" + xmlContent);
       
       String url = "http://127.0.0.1:449";
       
       String signContent = Sign(url, xmlContent);
       System.out.println("签名:" + signContent);
	}

	public static String Sign(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String signContent = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			
			// 设置通用的请求属性
			conn.setRequestProperty("Content-Type", "INFOSEC_SIGN/1.0");
			conn.setRequestProperty("Content-Length", Integer.toString(param.length()));
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
				signContent += line;
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
		
		signContent.replaceAll("\n", "");
		if(signContent.length() > 6) {
			int beginSign = signContent.indexOf("<sign>") + 6;
			int endSign = signContent.indexOf("</sign>");
			signContent = signContent.substring(beginSign, endSign);
		}
		return signContent;
	}

	/**
	 * 	这个不好使: RetrunCode 500
	 * 
	 * @param xmlContent
	 * @return
	 */
	public static String SignError(String xmlContent) {
		String signContent = ""; // 签名返回的信息
		String NCIp = "127.0.0.1"; //你安装工行系统服务器的ip
		String NCPort2 = "449"; // 加密端口号
	   
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse httpResponse = null;
		HttpPost httppost = null;
	
		// 如果明文xmlcontent中包括SignTime节点，即该交易需要签名
		if (xmlContent.indexOf("<SignTime>") > -1) {
			try {
				httpClient = HttpClients.createDefault(); // 构建http客户端
				httppost = new HttpPost("http://" + NCIp + ":" + NCPort2); // 加密端口
				httppost.addHeader("Content-Type", "INFOSEC_SIGN/1.0");
				httppost.addHeader("Content-Length", Integer.toString(xmlContent.getBytes().length));
				InputStream in = new ByteArrayInputStream(xmlContent.getBytes());
				InputStreamEntity entity = new InputStreamEntity(in);
				httppost.setEntity(entity);
				httpResponse = httpClient.execute(httppost); // 获得http返回码
				
				StatusLine status = httpResponse.getStatusLine();
				System.out.println("返回响应: " + status.getStatusCode());
				System.out.println("响应内容：" + EntityUtils.toString(httpResponse.getEntity()));
	   
				if(status.getStatusCode() == 200)
				{
					String postResult = EntityUtils.toString(httpResponse.getEntity());
					signContent = new String(postResult.getBytes("ISO8859-1"), "gb2312");
					System.out.println("NC签名返回数据如下:" + signContent);
				}
			} catch (Exception e) {
				System.out.println("签名出错:" + e.toString());
				e.printStackTrace();
			} finally {
				// 关闭资源
				if (null != httpResponse) {
					try {
						httpResponse.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (null != httpClient) {
					try {
						httpClient.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			signContent.replaceAll("\n", "");
			if(signContent.length() > 6) {
				int beginSign = signContent.indexOf("<sign>") + 6;
				int endSign = signContent.indexOf("</sign>");
				signContent = signContent.substring(beginSign, endSign);
			}
		} else {
			// 如果不需要签名直接放明文
			signContent = xmlContent;
		}
	   
	   return  signContent;
	}
}
