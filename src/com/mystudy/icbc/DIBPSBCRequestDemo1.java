package com.mystudy.icbc;

import com.mystudy.icbc.request.ConstRequest;
import com.mystudy.icbc.request.ConstTransCode;
import com.mystudy.icbc.request.DIBPSBCRequestBizV1;
import com.mystudy.icbc.request.DIBPSBCRequestV1;
import com.mystudy.icbc.request.RequestParam;
import com.mystudy.icbc.request.RequestParamUtil;
import com.mystudy.icbc.request.RequestUtil;

public class DIBPSBCRequestDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Seqno = ConstTransCode.QUERY_DIBPSBC + ConstRequest.getDateTime();
		
		RequestParam requestParam = RequestParamUtil.GetRequestParam(Seqno, ConstTransCode.QUERY_DIBPSBC, ConstRequest.VERSIONOLD);
		
		DIBPSBCRequestV1 request = new DIBPSBCRequestV1();
		DIBPSBCRequestBizV1 bizContent = new DIBPSBCRequestBizV1();
		
		RequestUtil.AssignToRequestBiz(bizContent, Seqno, ConstTransCode.QUERY_DIBPSBC);
		
		//行别代码
		bizContent.setBnkCode(ConstRequest.BANKCODE);;
		//查询下页标识
		bizContent.setNextTag("200");
		//请求备用字段1
		bizContent.setReqReserved1("");
		//请求备用字段21
		bizContent.setReqReserved2("");
		
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
