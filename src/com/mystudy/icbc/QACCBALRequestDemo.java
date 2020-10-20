package com.mystudy.icbc;

import java.util.ArrayList;

import com.mystudy.icbc.request.QACCBALRequestBizV1;
import com.mystudy.icbc.request.QACCBALRequestV1;
import com.mystudy.icbc.request.RequestParam;
import com.mystudy.icbc.request.RequestParamUtil;
import com.mystudy.icbc.request.RequestUtil;
import com.mystudy.icbc.request.ConstRequest;
import com.mystudy.icbc.request.ConstTransCode;

public class QACCBALRequestDemo {

	protected static String BASE_URL = "http://127.0.0.1:448/servlet/ICBCCMPAPIReqServlet";
	
	public static void main(String[] args) {
		String Seqno = ConstTransCode.QUERY_BALANCE + ConstRequest.getDateTime();
		
		RequestParam requestParam = new RequestParam();
		requestParam.setUserID(ConstRequest.CERTID);
		requestParam.setPackageID(Seqno);
		requestParam.setSendTime(ConstRequest.getDateTime());
		requestParam.setVersion(ConstRequest.VERSIONOLD);
		requestParam.setTransCode(ConstTransCode.QUERY_BALANCE);
		requestParam.setBankCode(ConstRequest.BANKCODE);
		requestParam.setID(ConstRequest.CERTID);
		requestParam.setGroupCIS(ConstRequest.CIS);
		
		QACCBALRequestV1 request = new QACCBALRequestV1();
		QACCBALRequestBizV1 bizContent = new QACCBALRequestBizV1();
		
		//��1�����״���
        bizContent.setTransCode(ConstTransCode.QUERY_BALANCE);
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
        bizContent.setfSeqno(Seqno);
        
        bizContent.setReqReserved1("");
        bizContent.setReqReserved2("");
        
        //rd��
        ArrayList<QACCBALRequestV1.QACCBALRequestRdV1> rds = new ArrayList<QACCBALRequestV1.QACCBALRequestRdV1>();
        QACCBALRequestV1.QACCBALRequestRdV1 rd = new QACCBALRequestV1.QACCBALRequestRdV1();
        
        rd.setiSeqno("1");
        rd.setAccNo(ConstRequest.ACCNO40348);
        rd.setCurrType(ConstRequest.CURRTYPE);
        rd.setReqReserved3("");
        rd.setReqReserved4("");
        rd.setAcctSeq("");
        rds.add(rd);
        
        bizContent.setTotalNum(Integer.toString(rds.size()));
        bizContent.setBLFlag("");
        bizContent.setSynFlag("");
        bizContent.setRd(rds);
        
        try {
			requestParam.setReqData(RequestParamUtil.GetReqData(bizContent));
			
			request.setServiceUrl(BASE_URL + RequestParamUtil.GetParam(requestParam));
			request.setParam(RequestParamUtil.GetParam(requestParam));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        request.setBizContent(bizContent);
        System.out.println(request.getServiceUrl());
        
        String repcontent = RequestUtil.sendPost(BASE_URL, request.getParam());
		try {
	           repcontent = repcontent.substring(8);
	           System.out.println("����������:\r\n"+repcontent);
	           byte[] decodeResult = Base64Util.getbyteFromBASE64(repcontent);
	           repcontent = new String(decodeResult);
	           System.out.println("base64��������:\r\n" + repcontent);
	       } catch (Exception e) {
	           e.printStackTrace();
	           System.out.println("����������base64����:" + e.toString());
	       }
	}

}
