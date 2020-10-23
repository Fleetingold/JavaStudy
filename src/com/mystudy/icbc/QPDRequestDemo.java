package com.mystudy.icbc;

import com.mystudy.icbc.request.ConstRequest;
import com.mystudy.icbc.request.ConstTransCode;
import com.mystudy.icbc.request.QPDRequestBizV1;
import com.mystudy.icbc.request.QPDRequestV1;
import com.mystudy.icbc.request.RequestParam;
import com.mystudy.icbc.request.RequestParamUtil;
import com.mystudy.icbc.request.RequestUtil;
import com.mystudy.icbc.response.QPDResponseV1;

public class QPDRequestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Seqno = ConstTransCode.QUERY_QPD + ConstRequest.getDateTime();
		
		RequestParam requestParam = RequestParamUtil.GetRequestParam(Seqno, ConstTransCode.QUERY_QPD, ConstRequest.VERSIONNEW);
		
		QPDRequestV1 request = new QPDRequestV1();
		QPDRequestBizV1 bizContent = new QPDRequestBizV1();
		
		RequestUtil.AssignToRequestBiz(bizContent, Seqno, ConstTransCode.QUERY_QPD);
        
		//rd��
		QPDRequestV1.QPDRequestRdV1 rd = new QPDRequestV1.QPDRequestRdV1();
		
		rd.setAccNo(ConstRequest.ACCNO2528);
		rd.setAreaCode("1311");
		rd.setMinAmt("0");
		rd.setMaxAmt("99999999999");
		//HHmmss Ԥ����Ŀǰ������
		rd.setBeginTime("");
		//HHmmss Ԥ����Ŀǰ������
		rd.setEndTime("");
		rd.setNextTag("2020-10-23-09.37.06.362410");
		rd.setReqReserved1("");
		rd.setReqReserved2("");
		rd.setCurrType("");
		rd.setAcctSeq("");
		
		bizContent.setRd(rd);
		
		try {
			requestParam.setReqData(RequestParamUtil.GetReqData(bizContent));
			
			String sParam = RequestParamUtil.GetParam(requestParam);
			request.setServiceUrl(ConstRequest.BASE_URL + "?" + sParam);
			request.setParam(sParam);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setBizContent(bizContent);
        System.out.println(request.getServiceUrl());
        
        //ִ������
        QPDResponseV1 response = RequestUtil.ExecuteQPD(ConstRequest.BASE_URL, request.getParam());
        
        System.out.println("TransCode:" + response.getTransCode());
		System.out.println("CIS:" + response.getCis());
		System.out.println("BankCode:" + response.getBankCode());
		System.out.println("ID:" + response.getID());
		System.out.println("TranDate:" + response.getTranDate());
		System.out.println("TranTime:" + response.getTranTime());
		System.out.println("fSeqno:" + response.getfSeqno());
		System.out.println("ReturnCode:" + response.getReturnCode());
		System.out.println("ReturnMsg:" + response.getReturnMsg());
		System.out.println("AccNo:" + response.getAccNo());
		System.out.println("NextTag:" + response.getNextTag());
		System.out.println("TotalNum:" + response.getTotalNum());
		
		for(QPDResponseV1.QPDResponseV1Rd resRd : response.getRds()) {
			System.out.println("------------------------------------");
			//Drcrf �����־	�����ֵ䣺1-�裻2-����
			System.out.println("Drcrf(�����־):" + resRd.getDrcrf());
			//Amount  ������
			System.out.println("Amount(������):" + resRd.getAmount());
			System.out.println("RepReserved3(���ӻص�Ψһ��ʶ):" + resRd.getRepReserved3());
			System.out.println("SequenceNo(����������ˮ��):" + resRd.getSequenceNo());
			//OnlySequence ���н�����ˮ��
			System.out.println("OnlySequence(���н�����ˮ��):" + resRd.getOnlySequence());
			//RecipBkNo �Է��к�
			System.out.println("RecipBkNo(�Է��к�):" + resRd.getRecipBkNo());
			System.out.println("RecipName(�Է�����):" + resRd.getRecipName());
			System.out.println("RecipAccNo(�Է��˺�):" + resRd.getRecipAccNo());
			//ReceiptInfo �Է���Ϣ
			System.out.println("ReceiptInfo(�Է���Ϣ):" + resRd.getReceiptInfo());
			
			System.out.println("UseCN(��;):" + resRd.getUseCN());
			System.out.println("PostScript(����):" + resRd.getPostScript());
			System.out.println("Summary(ժҪ):" + resRd.getSummary());
			//EnSummary Ӣ��ժҪ
			System.out.println("EnSummary(Ӣ��ժҪ):" + resRd.getEnSummary());
			System.out.println("TimeStamp(ʱ���):" + resRd.getTimeStamp());
		}
	}

}
