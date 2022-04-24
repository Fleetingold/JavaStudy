package com.taobao.alihealth;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAlihealthDrugKytSearchstatusRequest;
import com.taobao.api.response.AlibabaAlihealthDrugKytSearchstatusResponse;

public class SearchStatusTest {

	public static void main(String[] args)throws java.lang.Exception {
		// TODO Auto-generated method stub
		
		String url="https://eco.taobao.com/router/rest";
		String appkey="25465001";
		String secret="cf06ee099ede59995fe39a7e67cc0498";
		
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAlihealthDrugKytSearchstatusRequest req = new AlibabaAlihealthDrugKytSearchstatusRequest();
		req.setRefEntId("320000000000127971");
		req.setBeginDate("2022-03-22");
		req.setEndDate("2022-03-22");
		req.setBillType("A");
		//req.setBillCode("SYS_IN_201811061737543754_0002");
		//req.setDrugType("1");
		//req.setDealStatus("3");
		//req.setFromUserId("320000000000127971");
		//req.setToUserId("320000000000127971");
		//req.setAgentRefUserId("320000000000127971");
		req.setPageSize(20L);
		req.setPage(1L);
		AlibabaAlihealthDrugKytSearchstatusResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());

	}

}
