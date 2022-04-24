package com.taobao.alihealth;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.internal.util.StringUtils;
import com.taobao.api.request.AlibabaAlihealthDrugKytUploadcircubillRequest;
import com.taobao.api.response.AlibabaAlihealthDrugKytUploadcircubillResponse;

public class UploadBillTest {

	public static void main(String[] args) throws java.lang.Exception{
		// TODO Auto-generated method stub
		
		
		String url="https://eco.taobao.com/router/rest";
		String appkey="25465001";
		String secret="cf06ee099ede59995fe39a7e67cc0498";
		
		
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAlihealthDrugKytUploadcircubillRequest req = new AlibabaAlihealthDrugKytUploadcircubillRequest();
		req.setBillCode("bc001newtest");
		req.setBillTime(StringUtils.parseDateTime("2022-03-10 15:30:30"));
		req.setBillType(201L);
		req.setPhysicType(3L);
		req.setRefUserId("320000000000127971");
		req.setAgentRefUserId("320000000000127971");
		req.setFromUserId("00000000000020671792");
		req.setToUserId("d5f5f05c6af04e52ba7894d9bbf8e757");
		req.setDestUserId("d5f5f05c6af04e52ba7894d9bbf8e757");
		req.setOperIcCode("212000345");
		req.setOperIcName("张三");
		
		String content=XmlUtil.createFileZipContent("d://单据文件示例1.xml");
		
		req.setFileContent(content);
		req.setUploadFileName("单据文件00001.xml");
		req.setClientType("2");
		req.setFromAddress("发货地址XXX");
		req.setToAddress("收货地址XXX");
		req.setFromBillCode("123456");
		req.setOrderCode("123456");
		req.setFromPerson("张某");
		req.setToPerson("李某");
		req.setDisRefEntId("5069452c34b94a778abaa26c2b40b305");
		req.setDisEntId("5069452c34b94a778abaa26c2b40b305");
		req.setQuReceivable(10L);
		req.setXtIsCheck("0");
		req.setXtCheckCode("未验证通过原因");
		req.setXtCheckCodeDesc("未通过原因描述");
		req.setDrugListJson("[{\"codeCount\":100,\"commDrugId\":\"testCommDrugId0\",\"exprieDate\":1571131734945,\"physicInfo\":\"test0\",\"pkgSpec\":\"test0\",\"prepnCount\":10,\"produceBatchNo\":\"test0\",\"produceDate\":1571131734945},{\"codeCount\":100,\"commDrugId\":\"testCommDrugId1\",\"exprieDate\":1571131734945,\"physicInfo\":\"test1\",\"pkgSpec\":\"test1\",\"prepnCount\":10,\"produceBatchNo\":\"test1\",\"produceDate\":1571131734945}]");
		req.setAssRefEntId("5069452c34b94a778abaa26c2b40b305");
		req.setAssEntId("5069452c34b94a778abaa26c2b40b305");
		AlibabaAlihealthDrugKytUploadcircubillResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
		

	}

}
