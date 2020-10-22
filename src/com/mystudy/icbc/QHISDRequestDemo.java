package com.mystudy.icbc;

import com.mystudy.icbc.request.ConstRequest;
import com.mystudy.icbc.request.ConstTransCode;
import com.mystudy.icbc.request.QHISDRequestBizV1;
import com.mystudy.icbc.request.QHISDRequestV1;
import com.mystudy.icbc.request.RequestParam;
import com.mystudy.icbc.request.RequestParamUtil;
import com.mystudy.icbc.request.RequestUtil;

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
