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
			// �򿪺�URL֮�������
			URLConnection conn = realUrl.openConnection();
			// ����ͨ�õ���������
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Accept-Charset", "utf-8");
			conn.setRequestProperty("contentType", "utf-8");
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
				result += line;
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
		return result;
	}

	public static void AssignToRequestBiz(RequestBizV1 bizContent, String sSeqno, String sTransCode) {
		//��1�����״���
        bizContent.setTransCode(sTransCode);
        //��2������CIS�ţ��ͻ�ע��ʱ�Ĺ�������
        bizContent.setCis(ConstRequest.CIS);
        //��3���������б�ţ��ͻ�ע��ʱ�Ĺ�����λ 102
        bizContent.setBankCode(ConstRequest.BANKCODE);
        //��4��֤��ID����֤��ͻ������Ϳ�
        bizContent.setID(ConstRequest.CERTID);
        //��5��ERPϵͳ�����Ľ������ڣ���ʽ��yyyyMMdd
        bizContent.setTranDate(ConstRequest.getTranDate());
        //��6��ERPϵͳ�����Ľ���ʱ�䣬��ʽ��HHmmssSSS����ȷ������
        bizContent.setTranTime(ConstRequest.getTranTime());
        //��7��ERPϵͳ������ָ������кţ�һ��������Զ�����ظ����ͻ���ѡ�����ͻ���ϵͳ�Զ�����
        bizContent.setfSeqno(sSeqno);
	}
}
