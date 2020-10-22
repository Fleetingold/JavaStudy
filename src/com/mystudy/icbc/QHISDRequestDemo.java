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
        
		//rd区
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
        
        //执行请求
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
			//Toutfo 电子回单唯一标识
			System.out.println("Toutfo(电子回单唯一标识):" + resRd.getToutfo());
			//OnlySequence 银行交易流水号
			System.out.println("OnlySequence(银行交易流水号):" + resRd.getOnlySequence());
			
			//Drcrf 借贷标志	数据字典：1-借；2-贷；
			System.out.println("Drcrf(借贷标志):" + resRd.getDrcrf());
			//DebitAmount  借方发生额
			System.out.println("DebitAmount(借方发生额):" + resRd.getDebitAmount());
			//CreditAmount 贷方发生额
			System.out.println("CreditAmount(贷方发生额):" + resRd.getCreditAmount());
			System.out.println("Balance(当时余额):" + resRd.getBalance());
			//RecipBkNo1 对方行号
			System.out.println("RecipBkNo1(对方行号):" + resRd.getRecipBkNo1());
			//RecipBkName1 对方行名
			System.out.println("RecipBkName1(对方行名):" + resRd.getRecipBkName1());
			System.out.println("RecipAccNo(对方账号):" + resRd.getRecipAccNo());
			System.out.println("RecipName(对方户名):" + resRd.getRecipName());
			//ReceiptInfo 对方信息
			System.out.println("ReceiptInfo(对方信息):" + resRd.getReceiptInfo());
			
			System.out.println("Summary(摘要):" + resRd.getSummary());
			System.out.println("Time(时间戳):" + resRd.getTime());
		}
	}

}
