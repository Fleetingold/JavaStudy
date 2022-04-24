package com.taobao.alihealth;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAlihealthDrugKytGetentinfoRequest;
import com.taobao.api.response.AlibabaAlihealthDrugKytGetentinfoResponse;

public class GetentinfoTest {

	public static void main(String[] args) throws java.lang.Exception {
		// TODO Auto-generated method stub
		
		
		String url="https://eco.taobao.com/router/rest";
		String appkey="25465001";
		String secret="cf06ee099ede59995fe39a7e67cc0498";
		
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAlihealthDrugKytGetentinfoRequest req = new AlibabaAlihealthDrugKytGetentinfoRequest();
		req.setEntName("≤‚ ‘∆Û“µ");
		AlibabaAlihealthDrugKytGetentinfoResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());

	}

}
