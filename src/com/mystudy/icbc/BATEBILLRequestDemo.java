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
		
		//rd��
        ArrayList<BATEBILLRequestV1.BATEBILLRequestRdV1> rds = new ArrayList<BATEBILLRequestV1.BATEBILLRequestRdV1>();
        BATEBILLRequestV1.BATEBILLRequestRdV1 rd = new BATEBILLRequestV1.BATEBILLRequestRdV1();
        
        //QPD��ѯ������ϸ�ӿ�(RepReserved3)��QHISD�߼���ϸ��ѯ�ӿ�(Toutfo)
        //��ʽ:������|�����|��Ա��|����������ˮ��
        //����:1311|0600|20295|000094
        rd.setiSeqno("1");
        //������ ������ - 1311���ո���
        rd.setAreaCode("1311");
        //����� ������
        rd.setNetCode("02623");
        //�������� ������
        rd.setTranDate("20201023");
        rd.setAccNo(ConstRequest.ACCNO40348);
        //��� ������ 
        rd.setTranSerial("20297000095");
        rd.setAcctSeq("");
        rd.setCurrType(ConstRequest.CURRTYPE);
        rds.add(rd);
        
        //��Ҫǩ��
        bizContent.setSignTime(ConstRequest.getDateTime());
        bizContent.setTotalNum(Integer.toString(rds.size()));
        bizContent.setRd(rds);
		
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
        
        //ִ������
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
			//iSeqno		ָ���˳���
			System.out.println("iSeqno(ָ���˳���):" + resRd.getiSeqno());
			//OrderNo		ƽ̨�������
			System.out.println("OrderNo(ƽ̨�������):" + resRd.getOrderNo());
			//EbillSerialno	���ӻص�����
			System.out.println("EbillSerialno(���ӻص�����):" + resRd.getEbillSerialno());
			//PayAccount	�����˺�
			System.out.println("PayAccount(�����˺�):" + resRd.getPayAccount());
			//PayAcctName	�����˻�����
			System.out.println("PayAcctName(�����˻�����):" + resRd.getPayAcctName());
			//PayBankName  	����������������
			System.out.println("PayBankName(����������������):" + resRd.getPayBankName());
			//RecAccount 	�շ��˺�
			System.out.println("RecAccount(�շ��˺�):" + resRd.getRecAccount());
			//RecAcctName	�շ��˻�����
			System.out.println("RecAcctName(�շ��˻�����):" + resRd.getRecAcctName());
			//RecBankName	�շ�����������
			System.out.println("RecBankName(�շ�����������):" + resRd.getRecBankName());
			//PayAmt		���
			System.out.println("PayAmt(���):" + resRd.getPayAmt());
			//CurrType		����
			System.out.println("CurrType(����):" + resRd.getCurrType());
			//Summary		ժҪ
			System.out.println("Summary(ժҪ):" + resRd.getSummary());
			//BusType		ҵ������
			System.out.println("BusType(ҵ������):" + resRd.getBusType());
			//UseCN			��;
			System.out.println("UseCN(��;):" + resRd.getUseCN());
			//TranSerialNo	������ˮ��
			System.out.println("TranSerialNo(������ˮ��):" + resRd.getTranSerialNo());
			//TimeStamp		ʱ���
			System.out.println("TimeStamp(ʱ���):" + resRd.getTimeStamp());
			//Remark		��ע
			System.out.println("Remark(��ע):" + resRd.getRemark());
			//EbillKey		��֤��
			System.out.println("EbillKey(��֤��):" + resRd.getEbillKey());
			//TransNetCode	��������
			System.out.println("TransNetCode(��������):" + resRd.getTransNetCode());
			//TransTellno	���˹�Ա
			System.out.println("TransTellno(���˹�Ա):" + resRd.getTransTellno());
			//TransDate		��������
			System.out.println("TransDate(��������):" + resRd.getTransDate());
			//RePrintNum	�������
			System.out.println("RePrintNum(�������):" + resRd.getRePrintNum());
			//PostScript	����
			System.out.println("PostScript(����):" + resRd.getPostScript());
			//VouchNo		ƾ֤��
			System.out.println("VouchNo(ƾ֤��):" + resRd.getVouchNo());
			//VouchType		ƾ֤����
			System.out.println("VouchType(ƾ֤����):" + resRd.getVouchType());
			//Result		������
			System.out.println("Result(������):" + resRd.getResult());
			//iRetCode		��ϸ���׷�����
			System.out.println("iRetCode(��ϸ���׷�����):" + resRd.getiRetCode());
			//iRetMsg		��ϸ���׷�������
			System.out.println("iRetMsg(��ϸ���׷�������):" + resRd.getiRetMsg());
			//AgentPayAcctNo�������˺�
			System.out.println("AgentPayAcctNo(�������˺�):" + resRd.getAgentPayAcctNo());
			//AgentPayName	�����˻���
			System.out.println("AgentPayName(�����˻���):" + resRd.getAgentPayName());
			//UpdTranf 		������־
			System.out.println("UpdTranf(������־):" + resRd.getUpdTranf());
			//ValueDate		��Ϣ��
			System.out.println("ValueDate(��Ϣ��):" + resRd.getValueDate());
			//AcctSeq		�˺����
			System.out.println("AcctSeq(�˺����):" + resRd.getAcctSeq());
			//AcctSeqName	���˻�����
			System.out.println("AcctSeqName(���˻�����):" + resRd.getAcctSeqName());
			//ProdType		ҵ�񣨲�Ʒ������
			System.out.println("ProdType(ҵ�񣨲�Ʒ������):" + resRd.getProdType());
			//CusInfo		�ص����Ի�Ҫ��
			System.out.println("CusInfo(�ص����Ի�Ҫ��):" + resRd.getCusInfo());
			//BankSerialNo	���н�����ˮ��
			System.out.println("BankSerialNo(���н�����ˮ��):" + resRd.getBankSerialNo());
		}
	}

}
