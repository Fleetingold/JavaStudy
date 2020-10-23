package com.mystudy.icbc.request;

public class DownEBillRequestV1 extends RequestV1 {
	private DownEBillRequestBizV1 bizContent;
	
	public DownEBillRequestBizV1 getBizContent() {
		return bizContent;
	}
	public void setBizContent(DownEBillRequestBizV1 bizContent) {
		this.bizContent = bizContent;
	}
}
