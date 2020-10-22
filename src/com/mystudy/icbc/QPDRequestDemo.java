package com.mystudy.icbc;

import com.mystudy.icbc.request.ConstRequest;
import com.mystudy.icbc.request.ConstTransCode;
import com.mystudy.icbc.request.QPDRequestBizV1;
import com.mystudy.icbc.request.QPDRequestV1;
import com.mystudy.icbc.request.RequestParam;
import com.mystudy.icbc.request.RequestParamUtil;
import com.mystudy.icbc.request.RequestUtil;

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
		rd.setNextTag("");
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
