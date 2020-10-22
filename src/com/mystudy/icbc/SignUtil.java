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
		
		// �������
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
	       
       System.out.println("xml�����������:\r\n" + xmlContent);
       
       String url = "http://127.0.0.1:449";
       
       String signContent = Sign(url, xmlContent);
       System.out.println("ǩ��:" + signContent);
	}

	public static String Sign(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String signContent = "";
		try {
			URL realUrl = new URL(url);
			// �򿪺�URL֮�������
			URLConnection conn = realUrl.openConnection();
			
			// ����ͨ�õ���������
			conn.setRequestProperty("Content-Type", "INFOSEC_SIGN/1.0");
			conn.setRequestProperty("Content-Length", Integer.toString(param.length()));
			// ����POST�������������������
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// ��ȡURLConnection�����Ӧ�������
			out = new PrintWriter(conn.getOutputStream());
			// �����������
			out.print(param);
			// flush������Ļ���
			out.flush();
			// ����BufferedReader����������ȡURL����Ӧ
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				signContent += line;
			}
		} catch (Exception e) {
			System.out.println("���� POST ��������쳣��" + e);
			e.printStackTrace();
		}
		// ʹ��finally�����ر��������������
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
	 * 	�������ʹ: RetrunCode 500
	 * 
	 * @param xmlContent
	 * @return
	 */
	public static String SignError(String xmlContent) {
		String signContent = ""; // ǩ�����ص���Ϣ
		String NCIp = "127.0.0.1"; //�㰲װ����ϵͳ��������ip
		String NCPort2 = "449"; // ���ܶ˿ں�
	   
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse httpResponse = null;
		HttpPost httppost = null;
	
		// �������xmlcontent�а���SignTime�ڵ㣬���ý�����Ҫǩ��
		if (xmlContent.indexOf("<SignTime>") > -1) {
			try {
				httpClient = HttpClients.createDefault(); // ����http�ͻ���
				httppost = new HttpPost("http://" + NCIp + ":" + NCPort2); // ���ܶ˿�
				httppost.addHeader("Content-Type", "INFOSEC_SIGN/1.0");
				httppost.addHeader("Content-Length", Integer.toString(xmlContent.getBytes().length));
				InputStream in = new ByteArrayInputStream(xmlContent.getBytes());
				InputStreamEntity entity = new InputStreamEntity(in);
				httppost.setEntity(entity);
				httpResponse = httpClient.execute(httppost); // ���http������
				
				StatusLine status = httpResponse.getStatusLine();
				System.out.println("������Ӧ: " + status.getStatusCode());
				System.out.println("��Ӧ���ݣ�" + EntityUtils.toString(httpResponse.getEntity()));
	   
				if(status.getStatusCode() == 200)
				{
					String postResult = EntityUtils.toString(httpResponse.getEntity());
					signContent = new String(postResult.getBytes("ISO8859-1"), "gb2312");
					System.out.println("NCǩ��������������:" + signContent);
				}
			} catch (Exception e) {
				System.out.println("ǩ������:" + e.toString());
				e.printStackTrace();
			} finally {
				// �ر���Դ
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
			// �������Ҫǩ��ֱ�ӷ�����
			signContent = xmlContent;
		}
	   
	   return  signContent;
	}
}
