package com.mystudy.icbc;

import com.mystudy.icbc.request.ConstRequest;
import com.mystudy.icbc.request.ConstTransCode;

import java.util.ArrayList;

import com.mystudy.icbc.request.BATEBILLRequestBizV1;
import com.mystudy.icbc.request.BATEBILLRequestV1;
import com.mystudy.icbc.request.RequestParam;
import com.mystudy.icbc.request.RequestParamUtil;
import com.mystudy.icbc.request.RequestUtil;
import com.mystudy.icbc.response.BATEBILLResponseV1;

public class BATEBILLRequestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Seqno = ConstTransCode.QUERY_BATEBILL + ConstRequest.getDateTime();
		
		RequestParam requestParam = RequestParamUtil.GetRequestParam(Seqno, ConstTransCode.QUERY_BATEBILL, ConstRequest.VERSIONNEW);
		
		BATEBILLRequestV1 request = new BATEBILLRequestV1();
		BATEBILLRequestBizV1 bizContent = new BATEBILLRequestBizV1();
		
		RequestUtil.AssignToRequestBiz(bizContent, Seqno, ConstTransCode.QUERY_BATEBILL);
		
		//rd区
        ArrayList<BATEBILLRequestV1.BATEBILLRequestRdV1> rds = new ArrayList<BATEBILLRequestV1.BATEBILLRequestRdV1>();
        BATEBILLRequestV1.BATEBILLRequestRdV1 rd = new BATEBILLRequestV1.BATEBILLRequestRdV1();
        
        //QPD查询当日明细接口(RepReserved3)和QHISD高级明细查询接口(Toutfo)
        //格式:地区号|网点号|柜员号|主机交易流水号
        //例如:1311|0600|20295|000094
        rd.setiSeqno("1");
        //地区号 必输项 - 1311安徽阜阳
        rd.setAreaCode("1311");
        //网点号 必输项
        rd.setNetCode("02623");
        //交易日期 必输项
        rd.setTranDate("20201023");
        rd.setAccNo(ConstRequest.ACCNO40348);
        //序号 必输项 
        rd.setTranSerial("20297000095");
        rd.setAcctSeq("");
        rd.setCurrType(ConstRequest.CURRTYPE);
        rds.add(rd);
        
        //需要签名
        bizContent.setSignTime(ConstRequest.getDateTime());
        bizContent.setTotalNum(Integer.toString(rds.size()));
        bizContent.setRd(rds);
		
		try {
			String reqData = RequestParamUtil.GetReqData(bizContent);
			
			//进行签名操作
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
        
        //执行请求
        BATEBILLResponseV1 response = RequestUtil.ExecuteBATEBILL(ConstRequest.BASE_URL, request.getParam());
        
        System.out.println("TransCode:" + response.getTransCode());
		System.out.println("CIS:" + response.getCis());
		System.out.println("BankCode:" + response.getBankCode());
		System.out.println("ID:" + response.getID());
		System.out.println("TranDate:" + response.getTranDate());
		System.out.println("TranTime:" + response.getTranTime());
		System.out.println("fSeqno:" + response.getfSeqno());
		System.out.println("ReturnCode:" + response.getReturnCode());
		System.out.println("ReturnMsg:" + response.getReturnMsg());
		System.out.println("TotalNum:" + response.getTotalNum());
		
		for(BATEBILLResponseV1.BATEBILLResponseV1Rd resRd : response.getRds()) {
			System.out.println("------------------------------------");
			//iSeqno		指令包顺序号
			System.out.println("iSeqno(指令包顺序号):" + resRd.getiSeqno());
			//OrderNo		平台交易序号
			System.out.println("OrderNo(平台交易序号):" + resRd.getOrderNo());
			//EbillSerialno	电子回单号码
			System.out.println("EbillSerialno(电子回单号码):" + resRd.getEbillSerialno());
			//PayAccount	付方账号
			System.out.println("PayAccount(付方账号):" + resRd.getPayAccount());
			//PayAcctName	付方账户名称
			System.out.println("PayAcctName(付方账户名称):" + resRd.getPayAcctName());
			//PayBankName  	付方开户银行名称
			System.out.println("PayBankName(付方开户银行名称):" + resRd.getPayBankName());
			//RecAccount 	收方账号
			System.out.println("RecAccount(收方账号):" + resRd.getRecAccount());
			//RecAcctName	收方账户名称
			System.out.println("RecAcctName(收方账户名称):" + resRd.getRecAcctName());
			//RecBankName	收方开户行名称
			System.out.println("RecBankName(收方开户行名称):" + resRd.getRecBankName());
			//PayAmt		金额
			System.out.println("PayAmt(金额):" + resRd.getPayAmt());
			//CurrType		币种
			System.out.println("CurrType(币种):" + resRd.getCurrType());
			//Summary		摘要
			System.out.println("Summary(摘要):" + resRd.getSummary());
			//BusType		业务种类
			System.out.println("BusType(业务种类):" + resRd.getBusType());
			//UseCN			用途
			System.out.println("UseCN(用途):" + resRd.getUseCN());
			//TranSerialNo	交易流水号
			System.out.println("TranSerialNo(交易流水号):" + resRd.getTranSerialNo());
			//TimeStamp		时间戳
			System.out.println("TimeStamp(时间戳):" + resRd.getTimeStamp());
			//Remark		备注
			System.out.println("Remark(备注):" + resRd.getRemark());
			//EbillKey		验证码
			System.out.println("EbillKey(验证码):" + resRd.getEbillKey());
			//TransNetCode	记账网点
			System.out.println("TransNetCode(记账网点):" + resRd.getTransNetCode());
			//TransTellno	记账柜员
			System.out.println("TransTellno(记账柜员):" + resRd.getTransTellno());
			//TransDate		记账日期
			System.out.println("TransDate(记账日期):" + resRd.getTransDate());
			//RePrintNum	补打次数
			System.out.println("RePrintNum(补打次数):" + resRd.getRePrintNum());
			//PostScript	附言
			System.out.println("PostScript(附言):" + resRd.getPostScript());
			//VouchNo		凭证号
			System.out.println("VouchNo(凭证号):" + resRd.getVouchNo());
			//VouchType		凭证种类
			System.out.println("VouchType(凭证种类):" + resRd.getVouchType());
			//Result		处理结果
			System.out.println("Result(处理结果):" + resRd.getResult());
			//iRetCode		明细交易返回码
			System.out.println("iRetCode(明细交易返回码):" + resRd.getiRetCode());
			//iRetMsg		明细交易返回描述
			System.out.println("iRetMsg(明细交易返回描述):" + resRd.getiRetMsg());
			//AgentPayAcctNo付款人账号
			System.out.println("AgentPayAcctNo(付款人账号):" + resRd.getAgentPayAcctNo());
			//AgentPayName	付款人户名
			System.out.println("AgentPayName(付款人户名):" + resRd.getAgentPayName());
			//UpdTranf 		冲正标志
			System.out.println("UpdTranf(冲正标志):" + resRd.getUpdTranf());
			//ValueDate		起息日
			System.out.println("ValueDate(起息日):" + resRd.getValueDate());
			//AcctSeq		账号序号
			System.out.println("AcctSeq(账号序号):" + resRd.getAcctSeq());
			//AcctSeqName	子账户别名
			System.out.println("AcctSeqName(子账户别名):" + resRd.getAcctSeqName());
			//ProdType		业务（产品）种类
			System.out.println("ProdType(业务（产品）种类):" + resRd.getProdType());
			//CusInfo		回单个性化要素
			System.out.println("CusInfo(回单个性化要素):" + resRd.getCusInfo());
			//BankSerialNo	银行交易流水号
			System.out.println("BankSerialNo(银行交易流水号):" + resRd.getBankSerialNo());
		}
	}

}
