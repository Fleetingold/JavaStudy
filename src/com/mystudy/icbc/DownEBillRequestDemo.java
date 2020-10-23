package com.mystudy.icbc;

import com.mystudy.icbc.request.ConstRequest;
import com.mystudy.icbc.request.ConstTransCode;

import java.util.ArrayList;

import com.mystudy.icbc.request.DownEBillRequestBizV1;
import com.mystudy.icbc.request.DownEBillRequestV1;
import com.mystudy.icbc.request.RequestParam;
import com.mystudy.icbc.request.RequestParamUtil;
import com.mystudy.icbc.request.RequestUtil;

public class DownEBillRequestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Seqno = ConstTransCode.QUERY_DownEBill + ConstRequest.getDateTime();
		
		RequestParam requestParam = RequestParamUtil.GetRequestParam(Seqno, ConstTransCode.QUERY_DownEBill, ConstRequest.VERSIONNEW);
		
		DownEBillRequestV1 request = new DownEBillRequestV1();
		DownEBillRequestBizV1 bizContent = new DownEBillRequestBizV1();
		
		RequestUtil.AssignToRequestBiz(bizContent, Seqno, ConstTransCode.QUERY_DownEBill);
		
        //QPD��ѯ������ϸ�ӿ�(RepReserved3)��QHISD�߼���ϸ��ѯ�ӿ�(Toutfo)
        //��ʽ:������|�����|��Ա��|����������ˮ��
        //����:1311|0600|20295|000094
        //������ ������ - 1311���ո���
        bizContent.setAreaCode("1311");
        //����� ������
        bizContent.setNetCode("02623");
        //��Ա��
        bizContent.setTellerNo("20295");
        //�������� ������
        bizContent.setWorkDate("20201023");
        //��� ������ 1311|00600|20297|000001
        bizContent.setTranSerialNo("000001");
        bizContent.setAcctNo(ConstRequest.ACCNO2528);
        bizContent.setCurrencyType(ConstRequest.CURRTYPE);
        //��Ҫǩ��
        bizContent.setSignTime(ConstRequest.getDateTime());
        bizContent.setReqReserved1("");
        bizContent.setReqReserved2("");
        bizContent.setReqReserved3("");
        bizContent.setReqReserved4("");
        bizContent.setAcctSeq("");
		
		try {
			String reqData = RequestParamUtil.GetReqData(bizContent);
			
			//����ǩ������
			String signReqData = SignUtil.Sign(ConstRequest.SIGN_URL, reqData);
			
			requestParam.setReqData(signReqData);
			
			String sParam = RequestParamUtil.GetParam(requestParam);
			request.setServiceUrl(ConstRequest.BASE_URL + "?" + sParam);
			request.setParam(sParam);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setBizContent(bizContent);
        System.out.println(request.getServiceUrl());
        
        String repcontent = RequestUtil.SendPost(ConstRequest.BASE_URL, request.getParam());
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
