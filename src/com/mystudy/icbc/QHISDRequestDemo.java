package com.mystudy.icbc;

import com.mystudy.icbc.request.ConstRequest;
import com.mystudy.icbc.request.ConstTransCode;
import com.mystudy.icbc.request.QHISDRequestBizV1;
import com.mystudy.icbc.request.QHISDRequestV1;
import com.mystudy.icbc.request.RequestParam;
import com.mystudy.icbc.request.RequestParamUtil;
import com.mystudy.icbc.request.RequestUtil;
import com.mystudy.icbc.response.QHISDResponseV1;

public class QHISDRequestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Seqno = ConstTransCode.QUERY_BALANCEDETAIL + ConstRequest.getDateTime();
		
		RequestParam requestParam = RequestParamUtil.GetRequestParam(Seqno, ConstTransCode.QUERY_BALANCEDETAIL, ConstRequest.VERSIONNEW);
		
		QHISDRequestV1 request = new QHISDRequestV1();
		QHISDRequestBizV1 bizContent = new QHISDRequestBizV1();
		
		RequestUtil.AssignToRequestBiz(bizContent, Seqno, ConstTransCode.QUERY_BALANCEDETAIL);
        
		//rd��
		QHISDRequestV1.QHISDRequestRdV1 rd = new QHISDRequestV1.QHISDRequestRdV1();
		
		rd.setAccNo(ConstRequest.ACCNO2528);
		rd.setBeginDate("20201022");
		rd.setEndDate("20201022");
		rd.setMinAmt("0");
		rd.setMaxAmt("99999999999");
		rd.setBankType("");
		rd.setNextTag("");
		rd.setCurrType("");
		rd.setDueBillNo("");
		rd.setAcctSeq("");
		rd.setComplementFlag("");
		
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
        QHISDResponseV1 response = RequestUtil.ExecuteQHISD(ConstRequest.BASE_URL, request.getParam());
        
        System.out.println("TransCode:" + response.getTransCode());
		System.out.println("CIS:" + response.getCis());
		System.out.println("BankCode:" + response.getBankCode());
		System.out.println("ID:" + response.getID());
		System.out.println("TranDate:" + response.getTranDate());
		System.out.println("fSeqno:" + response.getfSeqno());
		System.out.println("ReturnCode:" + response.getReturnCode());
		System.out.println("ReturnMsg:" + response.getReturnMsg());
		System.out.println("AccNo:" + response.getAccNo());
		System.out.println("NextTag:" + response.getNextTag());
		System.out.println("TotalNum:" + response.getTotalNum());
		
		for(QHISDResponseV1.QHISDResponseV1Rd resRd : response.getRds()) {
			System.out.println("------------------------------------");
			//Toutfo ���ӻص�Ψһ��ʶ
			System.out.println("Toutfo(���ӻص�Ψһ��ʶ):" + resRd.getToutfo());
			//OnlySequence ���н�����ˮ��
			System.out.println("OnlySequence(���н�����ˮ��):" + resRd.getOnlySequence());
			
			//Drcrf �����־	�����ֵ䣺1-�裻2-����
			System.out.println("Drcrf(�����־):" + resRd.getDrcrf());
			//DebitAmount  �跽������
			System.out.println("DebitAmount(�跽������):" + resRd.getDebitAmount());
			//CreditAmount ����������
			System.out.println("CreditAmount(����������):" + resRd.getCreditAmount());
			System.out.println("Balance(��ʱ���):" + resRd.getBalance());
			//RecipBkNo1 �Է��к�
			System.out.println("RecipBkNo1(�Է��к�):" + resRd.getRecipBkNo1());
			//RecipBkName1 �Է�����
			System.out.println("RecipBkName1(�Է�����):" + resRd.getRecipBkName1());
			System.out.println("RecipAccNo(�Է��˺�):" + resRd.getRecipAccNo());
			System.out.println("RecipName(�Է�����):" + resRd.getRecipName());
			//ReceiptInfo �Է���Ϣ
			System.out.println("ReceiptInfo(�Է���Ϣ):" + resRd.getReceiptInfo());
			
			System.out.println("Summary(ժҪ):" + resRd.getSummary());
			System.out.println("Time(ʱ���):" + resRd.getTime());
		}
	}

}
