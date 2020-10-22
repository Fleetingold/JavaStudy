package com.mystudy.icbc;

import com.mystudy.icbc.request.ConstRequest;
import com.mystudy.icbc.request.ConstTransCode;
import com.mystudy.icbc.request.QHISDRequestBizV1;
import com.mystudy.icbc.request.QHISDRequestV1;
import com.mystudy.icbc.request.RequestParam;
import com.mystudy.icbc.request.RequestParamUtil;
import com.mystudy.icbc.request.RequestUtil;
import com.mystudy.icbc.response.QACCBALResponseV1;
import com.mystudy.icbc.response.QHISDResponseV1;

public class QHISDRequestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Seqno = ConstTransCode.QUERY_BALANCEDETAIL + ConstRequest.getDateTime();
		
		RequestParam requestParam = RequestParamUtil.GetRequestParam(Seqno, ConstTransCode.QUERY_BALANCEDETAIL, ConstRequest.VERSIONNEW);
		
		QHISDRequestV1 request = new QHISDRequestV1();
		QHISDRequestBizV1 bizContent = new QHISDRequestBizV1();
		
		RequestUtil.AssignToRequestBiz(bizContent, Seqno, ConstTransCode.QUERY_BALANCEDETAIL);
        
		//rdÇø
		QHISDRequestV1.QHISDRequestRdV1 rd = new QHISDRequestV1.QHISDRequestRdV1();
		
		rd.setAccNo(ConstRequest.ACCNO2486);
		rd.setBeginDate("20201021");
		rd.setEndDate("20201021");
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
        
        //Ö´ÐÐÇëÇó
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
		System.out.println("TotalNum:" + response.getTotalNum());
		
		for(QHISDResponseV1.QHISDResponseV1Rd resRd : response.getRds()) {
			System.out.println("------------------------------------");
			//CreditAmount
			System.out.println("CreditAmount:" + resRd.getCreditAmount());
			System.out.println("RecipAccNo:" + resRd.getRecipAccNo());
			System.out.println("RecipName:" + resRd.getRecipName());
			System.out.println("Summary:" + resRd.getSummary());
			System.out.println("Time:" + resRd.getTime());
			System.out.println("Drcrf:" + resRd.getDrcrf());
			//RecipBkName1
			System.out.println("RecipBkName1:" + resRd.getRecipBkName1());
			//TInfoNew
			System.out.println("TInfoNew:" + resRd.getTInfoNew());
			//ReceiptInfo
			System.out.println("ReceiptInfo:" + resRd.getReceiptInfo());
		}
	}

}
