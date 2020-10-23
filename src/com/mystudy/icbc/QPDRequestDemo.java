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
        
		//rd区
		QPDRequestV1.QPDRequestRdV1 rd = new QPDRequestV1.QPDRequestRdV1();
		
		rd.setAccNo(ConstRequest.ACCNO2528);
		rd.setAreaCode("1311");
		rd.setMinAmt("0");
		rd.setMaxAmt("99999999999");
		//HHmmss 预留，目前无意义
		rd.setBeginTime("");
		//HHmmss 预留，目前无意义
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
        
        //执行请求
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
			//Drcrf 借贷标志	数据字典：1-借；2-贷；
			System.out.println("Drcrf(借贷标志):" + resRd.getDrcrf());
			//Amount  发生额
			System.out.println("Amount(发生额):" + resRd.getAmount());
			System.out.println("RepReserved3(电子回单唯一标识):" + resRd.getRepReserved3());
			System.out.println("SequenceNo(主机交易流水号):" + resRd.getSequenceNo());
			//OnlySequence 银行交易流水号
			System.out.println("OnlySequence(银行交易流水号):" + resRd.getOnlySequence());
			//RecipBkNo 对方行号
			System.out.println("RecipBkNo(对方行号):" + resRd.getRecipBkNo());
			System.out.println("RecipName(对方户名):" + resRd.getRecipName());
			System.out.println("RecipAccNo(对方账号):" + resRd.getRecipAccNo());
			//ReceiptInfo 对方信息
			System.out.println("ReceiptInfo(对方信息):" + resRd.getReceiptInfo());
			
			System.out.println("UseCN(用途):" + resRd.getUseCN());
			System.out.println("PostScript(附言):" + resRd.getPostScript());
			System.out.println("Summary(摘要):" + resRd.getSummary());
			//EnSummary 英文摘要
			System.out.println("EnSummary(英文摘要):" + resRd.getEnSummary());
			System.out.println("TimeStamp(时间戳):" + resRd.getTimeStamp());
		}
	}

}
