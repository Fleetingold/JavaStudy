package com.mystudy.icbc.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class RequestUtil {
	public static String SendPost(String url, String param) {
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

	public static void AssignToRequestBiz(RequestBizV1 bizContent, String sSeqno, String sTransCode) {
		//（1）交易代码
        bizContent.setTransCode(sTransCode);
        //（2）集团CIS号，客户注册时的归属编码
        bizContent.setCis(ConstRequest.CIS);
        //（3）归属银行编号，客户注册时的归属单位 102
        bizContent.setBankCode(ConstRequest.BANKCODE);
        //（4）证书ID，无证书客户可上送空
        bizContent.setID(ConstRequest.CERTID);
        //（5）ERP系统产生的交易日期，格式是yyyyMMdd
        bizContent.setTranDate(ConstRequest.getTranDate());
        //（6）ERP系统产生的交易时间，格式如HHmmssSSS，精确到毫秒
        bizContent.setTranTime(ConstRequest.getTranTime());
        //（7）ERP系统产生的指令包序列号，一个集团永远不能重复。客户可选择上送或由系统自动生成
        bizContent.setfSeqno(sSeqno);
	}
}
