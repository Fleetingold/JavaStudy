package com.mystudy.icbc;

import com.mystudy.icbc.request.ConstRequest;
import com.mystudy.icbc.request.ConstTransCode;

import java.util.ArrayList;

import com.mystudy.icbc.request.BATEBILLRequestBizV1;
import com.mystudy.icbc.request.BATEBILLRequestV1;
import com.mystudy.icbc.request.RequestParam;
import com.mystudy.icbc.request.RequestParamUtil;
import com.mystudy.icbc.request.RequestUtil;

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
        
        rd.setiSeqno("1");
        //地区号 必输项?
        rd.setAreaCode("");
        //网点号 必输项?
        rd.setNetCode("");
        //交易日期 必输项
        rd.setTranDate(ConstRequest.getTranDate());
        rd.setAccNo(ConstRequest.ACCNO2486);
        //序号 必输项?
        rd.setTranSerial("");
        rd.setAcctSeq("");
        rd.setCurrType(ConstRequest.CURRTYPE);
        rds.add(rd);
        
        //需要签名?
        bizContent.setSignTime(ConstRequest.getDateTime());
        bizContent.setTotalNum(Integer.toString(rds.size()));
        bizContent.setRd(rds);
		
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
        
        String repcontent = RequestUtil.SendPost(ConstRequest.BASE_URL, request.getParam());
		try {
            repcontent = repcontent.substring(8);
            System.out.println("银企互联返回:\r\n"+repcontent);
            byte[] decodeResult = Base64Util.getbyteFromBASE64(repcontent);
            repcontent = new String(decodeResult);
            System.out.println("base64解码如下:\r\n" + repcontent);
        } catch (Exception e) {
        	e.printStackTrace();
        	System.out.println("银企互联返回base64报错:" + e.toString());
        }
	}

}
